package com.tcx;

import org.testng.annotations.Test;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class PrepareStatementUpdateTest {
    @Test
    public void test7(){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            //    读取配置文件的信息
            InputStream is = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties pros = new Properties();
            pros.load(is);
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");
            String url = pros.getProperty("url");
            String driverClass = pros.getProperty("driverClass");
//        加载驱动
            Class.forName(driverClass);
//        获取连接
            connection = DriverManager.getConnection(url, user, password);
//        预编译sql语句，返回preparestatem实例
            String sql = "insert into customers(name,email,birth)values(?,?,?)";
            ps = connection.prepareStatement(sql);
//       填充占位符

            ps.setString(1,"tom");
            ps.setString(2,"1@qq.com");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = simpleDateFormat.parse("1999-01-01");
            ps.setDate(3,new java.sql.Date(date.getTime()));
//        执行操作
            ps.execute();
//        关闭资源
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}
