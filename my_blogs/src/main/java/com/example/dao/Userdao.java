package com.example.dao;

import com.example.domain.*;
import com.example.utils.JDBCutils_cn;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

//修改数据库的类

public class Userdao {
    private JdbcTemplate tem = new JdbcTemplate(JDBCutils_cn.getDatasource());
    /**
     * 参数是从服务器得到的user,登陆方法
     * @param loginuser 只有用户名和密码
     * @return 将返回在数据库中找到的所有信息
     */
    public user login(user loginuser){
        try {
            String sql = "select * from user where username = ? and password = ?";
            user user_ = tem.queryForObject(sql,
                    new BeanPropertyRowMapper<user>(user.class),
                    loginuser.getUsername(), loginuser.getPassword());
            return user_;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }
}
