package com.example.request;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/request_demo_002")
public class request_demo_002 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Enumeration<String> names = request.getHeaderNames();
        while(names.hasMoreElements()){
            String name = names.nextElement();
            String value = request.getHeader(name);
            System.out.println(name+"---"+value);
        }

        String header = request.getHeader("referer");
        if(header.contains("demo_war")){
           // System.out.println("run movie");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("播放电影...");
        }else{
           // System.out.println("illegal action");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("盗链行为...");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

    }
}
