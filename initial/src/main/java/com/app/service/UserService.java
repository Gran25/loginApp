package com.app.service;

import com.app.model.LoginVO;

public interface  UserService {

    public LoginVO validateUser(String user,String pass);

    public void registerUser(String user,String name,String pass,String role);

    public boolean checkUser(String user);

}