package com.family.filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author: gzb
 * @date  : 2019年8月7日 上午10:54:18
 *
 */
public class FilterInitParamDemo02 implements Filter {

    @Override
    public void destroy() {
        System.out.println("----过滤器销毁----");
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        /**
         *  <filter>
                  <filter-name>FilterDemo02</filter-name>
                  <filter-class>me.gacl.web.filter.FilterDemo02</filter-class>
                  <!--配置FilterDemo02过滤器的初始化参数-->
                  <init-param>
                      <description>配置FilterDemo02过滤器的初始化参数</description>
                      <param-name>name</param-name>
                      <param-value>gacl</param-value>
                  </init-param>
                  <init-param>
                      <description>配置FilterDemo02过滤器的初始化参数</description>
                      <param-name>like</param-name>
                      <param-value>java</param-value>
                  </init-param>
            </filter>
            
             <filter-mapping>
                  <filter-name>FilterDemo02</filter-name>
                  <!--“/*”表示拦截所有的请求 -->
                  <url-pattern>/*</url-pattern>
             </filter-mapping>
         */
      //得到过滤器的名字
        String filterName = arg0.getFilterName();
        //得到在web.xml文件中配置的初始化参数
        String initParam1 = arg0.getInitParameter("name");
        String initParam2 = arg0.getInitParameter("like");
        //返回过滤器的所有初始化参数的名字的枚举集合。
        Enumeration<String> initParameterNames = arg0.getInitParameterNames();
        
        System.out.println(filterName);
        System.out.println(initParam1);
        System.out.println(initParam2);
        while (initParameterNames.hasMoreElements()) {
            String paramName = (String) initParameterNames.nextElement();
            System.out.println(paramName);
        }
    }
    
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
            throws IOException, ServletException {
        System.out.println("FilterDemo02执行前！！！");
        arg2.doFilter(arg0, arg1);  //让目标资源执行，放行
        System.out.println("FilterDemo02执行后！！！");
    }

}
