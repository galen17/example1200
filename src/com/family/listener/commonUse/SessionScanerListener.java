package com.family.listener.commonUse;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author: gzb
 * @date  : 2019年8月7日 下午4:36:10
 *
 */
public class SessionScanerListener implements HttpSessionListener ,ServletContextListener {

    /**
     * @Field: list
     *          定义一个集合存储服务器创建的HttpSession
     *        LinkedList不是一个线程安全的集合
     */ 
     /**
      * private List<HttpSession> list = new LinkedList<HttpSession>();
      * 这样写涉及到线程安全问题,SessionScanerListener对象在内存中只有一个
      * sessionCreated可能会被多个人同时调用，
      * 当有多个人并发访问站点时，服务器同时为这些并发访问的人创建session
      * 那么sessionCreated方法在某一时刻内会被几个线程同时调用，几个线程并发调用sessionCreated方法
      * sessionCreated方法的内部处理是往一个集合中添加创建好的session，那么在加session的时候就会
      * 涉及到几个Session同时抢夺集合中一个位置的情况，所以往集合中添加session时，一定要保证集合是线程安全的才行
      * 如何把一个集合做成线程安全的集合呢？
      * 可以使用使用 Collections.synchronizedList(List<T> list)方法将不是线程安全的list集合包装线程安全的list集合
      */
     //使用 Collections.synchronizedList(List<T> list)方法将LinkedList包装成一个线程安全的集合
     private List<HttpSession> list = Collections.synchronizedList(new LinkedList<HttpSession>());
   //定义一个对象，让这个对象充当一把锁，用这把锁来保证往list集合添加的新的session和遍历list集合中的session这两个操作达到同步
     private Object lock = new Object();
     
    @Override
    public void sessionCreated(HttpSessionEvent arg0) {
        System.out.println("session被创建了!!");
        HttpSession session = arg0.getSession();
        
        synchronized (lock){
            /**
             *将该操作加锁进行锁定，当有一个thread-1(线程1)在调用这段代码时，会先拿到lock这把锁，然后往集合中添加session，
             *在添加session的这个过程中假设有另外一个thread-2(线程2)来访问了，thread-2可能是执行定时器任务的，
             *当thread-2要调用run方法遍历list集合中的session时，结果发现遍历list集合中的session的那段代码被锁住了，
             *而这把锁正在被往集合中添加session的那个thread-1占用着，因此thread-2只能等待thread-1操作完成之后才能够进行操作
             *当thread-1添加完session之后，就把lock放开了，此时thread-2拿到lock，就可以执行遍历list集合中的session的那段代码了
             *通过这把锁就保证了往集合中添加session和变量集合中的session这两步操作不能同时进行，必须按照先来后到的顺序来进行。
             */
            list.add(session);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent arg0) {
        System.out.println("session被销毁了了!!");
    }

    /* Web应用启动时触发这个事件
     * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
     */
    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        System.out.println("web应用初始化");
        //创建定时器
        Timer timer = new Timer();
        //每隔30秒就定时执行任务
        timer.schedule(new MyTask(list,lock), 0, 1000*30);
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("web应用关闭");
    }



}
/**
* @ClassName: MyTask
* @Description:定时器要定时执行的任务
* @author: 孤傲苍狼
* @date: 2014-9-11 上午12:02:36
*
*/ 
class MyTask extends TimerTask {
        
    //存储HttpSession的list集合
    private List<HttpSession> list;
    //存储传递过来的锁
    private Object lock;
    public MyTask(List<HttpSession> list,Object lock){
        this.list = list;
        this.lock = lock;
    }
    /* run方法指明了任务要做的事情
     * @see java.util.TimerTask#run()
     */
    @Override
    public void run() {
            //将该操作加锁进行锁定
        synchronized (lock) {
            System.out.println("定时器执行！！");
            ListIterator<HttpSession> it = list.listIterator();
            /**
             * 迭代list集合中的session，在迭代list集合中的session的过程中可能有别的用户来访问，
             * 用户一访问，服务器就会为该用户创建一个session,此时就会调用sessionCreated往list集合中添加新的session，
             * 然而定时器在定时执行扫描遍历list集合中的session时是无法知道正在遍历的list集合又添加的新的session进来了，
             * 这样就导致了往list集合添加的新的session和遍历list集合中的session这两个操作无法达到同步
             * 那么解决的办法就是把"list.add(session)和while(it.hasNext()){//迭代list集合}"这两段代码做成同步，
             * 保证当有一个线程在访问"list.add(session)"这段代码时，另一个线程就不能访问"while(it.hasNext()){//迭代list集合}"这段代码
             * 为了能够将这两段不相干的代码做成同步，只能定义一把锁(Object lock)，然后给这两步操作加上同一把锁，
             * 用这把锁来保证往list集合添加的新的session和遍历list集合中的session这两个操作达到同步
             * 当在执行往list集合添加的新的session操作时，就必须等添加完成之后才能够对list集合进行迭代操作，
             * 当在执行对list集合进行迭代操作时，那么必须等到迭代操作结束之后才能够往往list集合添加的新的session
             */
            while(it.hasNext()){
                HttpSession session = (HttpSession) it.next();
                /**
                 * 如果当前时间-session的最后访问时间>1000*15(15秒)
                 * session.getLastAccessedTime()获取session的最后访问时间
                 */
                if(System.currentTimeMillis()-session.getLastAccessedTime()>1000*30){
                    //手动销毁session
                    session.invalidate();
                    //移除集合中已经被销毁的session
                    it.remove();
                }
            }
        }
    }
}