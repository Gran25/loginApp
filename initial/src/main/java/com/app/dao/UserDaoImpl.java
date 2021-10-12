package com.app.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.app.model.LoginVO;
import com.app.dao.UserMapper;

public class UserDaoImpl implements UserDao {

  @Autowired
  DataSource datasource;

  @Autowired
  JdbcTemplate jdbcTemplate;


  public LoginVO validateUser(String user,String pass) {

      String sql = "select * from user where username='" + user + "' and password='" + pass
      + "'";

      List<LoginVO> loginvo = jdbcTemplate.query(sql, new UserMapper());

      return loginvo.size() > 0 ? loginvo.get(0) : null;
  }

  public void registerUser(String user,String name,String pass,String role){
     String sql = "insert into user values(?,?,?,?)";
     jdbcTemplate.update(sql, new Object[] { user, name, pass,role, });
  }

  public boolean checkUser(String user){
      String sql = "select * from user where username='" + user + "'";

      List<LoginVO> loginvo = jdbcTemplate.query(sql, new UserMapper());

      if (loginvo.size()>0){
        return true;
      }else{
        return false;
      }
  }

  }

 