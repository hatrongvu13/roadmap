package com.jax.websocketserver.api.controllers;

import com.jax.websocketserver.data.response.Token;
import com.jax.websocketserver.data.response.UserInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
public class AuthenticationController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Token login() {
        return null;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Token register() {
        return null;
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public UserInfo info() {
        return null;
    }

}
