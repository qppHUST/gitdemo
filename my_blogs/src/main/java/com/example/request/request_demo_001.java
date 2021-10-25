package com.example.request;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/request_demo")
public class request_demo_001 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求方式
        String method = request.getMethod();
        System.out.println(method);
        //获取虚拟目录
        System.out.println(request.getContextPath());
        //获取servlet路径
        System.out.println(request.getServletPath());
        //获取get方法的请求参数
        System.out.println(request.getQueryString());
        //获取请求的URI
        System.out.println(request.getRequestURI());
        //获取请求URL
        System.out.println(request.getRequestURL());
        //获取协议及版本
        System.out.println(request.getProtocol());
        //获取客户的ip
        System.out.println(request.getRemoteAddr());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
