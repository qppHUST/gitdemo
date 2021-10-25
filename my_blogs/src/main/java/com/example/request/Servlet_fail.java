package com.example.request; /**
 * ClassName: ${NAME}
 * Description:
 * date: 2021/10/24 12:30
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet_fail")
public class Servlet_fail extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //解决中文乱码问题，将编码改为utf-8
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("登陆失败，用户名或密码错误");
    }
}

