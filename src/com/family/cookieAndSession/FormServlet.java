package com.family.cookieAndSession;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 创建FormServlet，用于生成Token(令牌)和跳转到form.jsp页面
 * @author: gzb
 * @date  : 2019年8月14日 下午4:08:30
 *
 */
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = -884689940866074733L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String token = TokenProccessor.getInstance().makeToken();//创建令牌
        System.out.println("在FormServlet中生成的token："+token);
        request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
        request.getRequestDispatcher("/form2.jsp").forward(request, response);//跳转到form.jsp页面
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
