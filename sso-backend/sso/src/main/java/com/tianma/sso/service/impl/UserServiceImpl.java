package com.tianma.sso.service.impl;

import com.tianma.sso.decodingjwt.entry.JwtSign;
import com.tianma.sso.exception.BusinessException;
import com.tianma.sso.dao.UserDao;
import com.tianma.sso.model.User;
import com.tianma.sso.service.UserService;
import com.tianma.sso.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private JwtSign jwtSign;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public String login(String userName, String password) throws BusinessException {
        return loginHandler(userName, password);
    }

    private String loginHandler(String userName, String password) throws BusinessException {
        User user = userDao.checkLoginInfo(userName, password);

        if (user == null) {
            throw new BusinessException("用户名或密码错误");
        }

        if (!redisUtil.isExists(jwtSign.buildJwtTokenRedisKey(userName))) {
            String newJwtToken = jwtSign.sign(userName, user);
            redisUtil.set(jwtSign.buildJwtTokenRedisKey(userName), newJwtToken, jwtSign.getJwtProperty().getExpiration());
            return newJwtToken;
        }

        return (String)redisUtil.get(jwtSign.buildJwtTokenRedisKey(userName));
    }

    @Override
    public List<User> fetchAllInfo() {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            users.add(new User(i, i + "", UUID.randomUUID().toString()));
        }

        return users;
    }

}
