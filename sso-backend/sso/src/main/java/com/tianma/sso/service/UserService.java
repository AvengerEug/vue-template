package com.tianma.sso.service;

import com.tianma.sso.exception.BusinessException;
import com.tianma.sso.model.User;

import java.util.List;

public interface UserService {

    String login(String userName, String password) throws BusinessException;

    List<User> fetchAllInfo();
}
