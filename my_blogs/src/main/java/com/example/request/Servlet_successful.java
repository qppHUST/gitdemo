package com.example.request;

/**
 * ClassName: ${NAME}
 * Description:
 * date: 2021/10/24 12:29
 *
 * @author: 邱攀攀
 * @version:
 * @since JDK 1.8
 */

import com.example.domain.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/servlet_successful")
public class Servlet_successful extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");

        //由于传过来的是一个user对象，所以：
        user user =(user) request.getAttribute("username");
        String username = user.getUsername();
        String line = username+",欢迎你";
        response.getWriter().write(line);
    }
}
