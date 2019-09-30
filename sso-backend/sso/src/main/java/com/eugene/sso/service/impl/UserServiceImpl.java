package com.eugene.sso.service.impl;

import com.eugene.sso.Enum.HttpErrorStatus;
import com.eugene.sso.dao.UserDao;
import com.eugene.sso.decodingjwt.entry.JwtSign;
import com.eugene.sso.exception.BusinessException;
import com.eugene.sso.model.User;
import com.eugene.sso.utils.RedisUtil;
import com.eugene.sso.service.UserService;
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
            throw new BusinessException(HttpErrorStatus.USER_LOGIN_ERROR.getCode(), HttpErrorStatus.USER_LOGIN_ERROR.getMessage());
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

    @Override
    public User register(User user) throws BusinessException {
        if (userDao.selectByUserName(user.getUserName()) != null) {
            throw new BusinessException(HttpErrorStatus.USER_REGISTER_USERNAME_ERROR.getCode(), HttpErrorStatus.USER_REGISTER_USERNAME_ERROR.getMessage());
        }

        return userDao.create(user);
    }
}
