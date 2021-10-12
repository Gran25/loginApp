package com.app.dao;

import org.springframework.jdbc.core.RowMapper;
import com.app.model.LoginVO;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<LoginVO> {

    public LoginVO mapRow(ResultSet rs, int arg1) throws SQLException {
        LoginVO user = new LoginVO();

        user.setName(rs.getString("name"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setRole(rs.getString("role"));


        return user;
    }
}