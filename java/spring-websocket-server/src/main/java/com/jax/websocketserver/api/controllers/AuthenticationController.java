package com.jax.websocketserver.api.controllers;

import com.jax.websocketserver.api.services.AuthenticationService;
import com.jax.websocketserver.data.DTO.UserPrincipal;
import com.jax.websocketserver.data.request.LoginRequest;
import com.jax.websocketserver.data.request.RegisterRequest;
import com.jax.websocketserver.data.response.Token;
import com.jax.websocketserver.data.response.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@CrossOrigin(value = "*", maxAge = 3600)
public class AuthenticationController {

    @Autowired
    AuthenticationService authenticationService;

    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Login controller")
    public Token login(@RequestBody LoginRequest loginRequest) {
        return authenticationService.login(loginRequest);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Register Controller")
    public Token register(@RequestBody RegisterRequest registerRequest) {
        return authenticationService.register(registerRequest);
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    @ApiOperation(value = "Get info current user")
    public UserInfo info(@ApiIgnore @AuthenticationPrincipal UserPrincipal currentUser) {
        return authenticationService.info(currentUser);
    }

//    @RequestMapping(value = "/reset", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public void resetPassword(String email) {
//
//    }

}
