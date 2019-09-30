package com.eugene.sso.dao.impl;

import com.eugene.sso.model.User;
import com.eugene.sso.dao.mybatis.MyBatisDAO;
import com.eugene.sso.dao.UserDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDaoImpl extends MyBatisDAO<User, Integer> implements UserDao {

    private Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @Override
    public User checkLoginInfo(String userName, String password) {
        Map<String, String> params = new HashMap<>();
        params.put("userName", userName);
        params.put("password", password);
        logger.info("开始登录");

        return this.getSqlSession().selectOne(this.getSqlNameSpace() + "checkLoginInfo", params);
    }

    @Override
    public User selectByUserName(String userName) {

        return this.getSqlSession().selectOne(this.getSqlNameSpace() + "selectByUserName", userName);
    }
}
