package com.app.service;

import com.app.model.LoginVO;
import com.app.dao.UserDao;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    public LoginVO validateUser(String user,String pass) {
        String hpass = DigestUtils.sha256Hex(pass);
        LoginVO loginvo=userDAO.validateUser(user,hpass);

        return loginvo;
    }

    public void registerUser(String user,String name,String pass,String role){
        String hpass = DigestUtils.sha256Hex(pass);
        userDAO.registerUser(user,name,hpass,role);
    }

    public boolean checkUser(String user){
        return userDAO.checkUser(user);
    }

}