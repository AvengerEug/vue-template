package com.tianma.sso.dao.impl;

import com.tianma.sso.dao.mybatis.MyBatisDAO;
import com.tianma.sso.dao.UserDao;
import com.tianma.sso.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl extends MyBatisDAO<User, Integer> implements UserDao {

    @Override
    public User checkLoginInfo(String userName, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("userName", userName);
        params.put("password", password);

        return this.getSqlSession().selectOne(this.getSqlNameSpace() + "checkLoginInfo", params);
    }
}
