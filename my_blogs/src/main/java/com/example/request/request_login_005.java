
package com.example.request;

import com.example.dao.*;
import com.example.domain.user;
import com.example.utils.JDBCutils_cn;
import com.mchange.v2.beans.BeansUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/request_login_005")
public class request_login_005 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");

        user loginuser = new user();
        Map<String, String[]> map = request.getParameterMap();
        try {
            BeanUtils.populate(loginuser,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        Userdao ud = new Userdao();
        user user = ud.login(loginuser);

        if(user == null){
            //登陆失败
            request.getRequestDispatcher("/servlet_fail").forward(request,response);
            //将信息传递给管理失败的servlet

        }else {
            //登陆成功，需要转发数据，因为需要在界面上显示相关消息,转发数据可以直接转发一个对象，名字只是一个标识符
            request.setAttribute("username",user);
            request.getRequestDispatcher("/servlet_successful").forward(request,response);
            //将信息传递给管理成功的servlet
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request,response);
    }
}
