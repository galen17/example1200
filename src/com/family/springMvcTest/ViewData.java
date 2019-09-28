package com.family.springMvcTest;

import javax.servlet.http.HttpServletRequest;

/**
 * 需要发送到客户端显示的数据模型
 * @author: gzb
 * @date  : 2019年8月14日 下午4:52:52
 *
 */
public class ViewData {
    
   private HttpServletRequest request;
    
    public ViewData() {
        initRequest();
    }

    private void initRequest(){
        //从requestHodler中获取request对象
        this.request = WebContext.requestHodler.get();
    }
    
    public void put(String name,Object value){
        this.request.setAttribute(name, value);
    }
}
