package com.tianma.sso.dao;

import com.tianma.sso.model.User;

public interface UserDao extends BaseDAO<User, Integer> {

    User checkLoginInfo(String userName, String password);
}
