package com.app.dao;

import com.app.model.LoginVO;

public interface UserDao {

  LoginVO validateUser(String user,String pass);

  void registerUser(String user,String name,String pass,String role);
  
  boolean checkUser(String user);
}