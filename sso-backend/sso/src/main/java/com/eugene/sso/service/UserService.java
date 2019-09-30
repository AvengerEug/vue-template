package com.eugene.sso.service;

import com.eugene.sso.exception.BusinessException;
import com.eugene.sso.model.User;

import java.util.List;

public interface UserService {

    String login(String userName, String password) throws BusinessException;

    List<User> fetchAllInfo();

    User register(User user) throws BusinessException;
}
