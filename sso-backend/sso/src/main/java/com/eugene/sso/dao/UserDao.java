package com.eugene.sso.dao;

import com.eugene.sso.model.User;

public interface UserDao extends BaseDAO<User, Integer> {

    User checkLoginInfo(String userName, String password);

    User selectByUserName(String userName);
}
