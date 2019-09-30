package com.eugene.sso.controller;

import com.eugene.sso.model.User;
import com.eugene.sso.decodingjwt.entry.JwtSign;
import com.eugene.sso.exception.BusinessException;
import com.eugene.sso.web.http.Message;
import com.eugene.sso.service.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping(value = "/user")
public class UserController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private JwtSign jwtSign;

    @PostMapping(value = "/login")
    public Message login(@RequestBody Map<String, String> params) throws BusinessException {
        String jwtToken = userService.login(params.get("userName"), params.get("password"));
        return Message.ok(jwtToken);
    }

    @PostMapping("/register")
    public Message register(@Validated @RequestBody User user) throws BusinessException {
        return Message.ok(userService.register(user));
    }

    @GetMapping(value = "/fetch-all-info")
    public Message fetchAllInfo() {
        return Message.ok(userService.fetchAllInfo());
    }

    @PutMapping(value = "/{userId}")
    public Message updateUserById(@PathVariable(value = "userId") Integer userId) {
        return Message.ok("PathVariable: " + userId);
    }

    @DeleteMapping(value = "/delete-user")
    public Message deleteUserById(@RequestParam(value = "userId") Integer userId) {
        return Message.ok("RequestParam: " + userId);
    }

    @GetMapping(value = "/decoding-jwt-token")
    public Message decodingJwtToken(@RequestParam(value = "jwtToken") String jwtToken) throws BusinessException {
        try {
            return Message.ok(jwtSign.unSignBody(jwtToken));
        } catch (ExpiredJwtException e) {
            logger.error("jwt-token已过期: " + jwtToken, e);
            throw new BusinessException("Token 过期");
        }
    }
}
