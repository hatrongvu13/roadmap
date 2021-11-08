package com.jax.websocketserver.api.services.impl;

import com.jax.websocketserver.api.services.AuthenticationService;
import com.jax.websocketserver.data.DTO.UserPrincipal;
import com.jax.websocketserver.data.entities.LoginLogs;
import com.jax.websocketserver.data.entities.User;
import com.jax.websocketserver.data.repositories.LoginLogRepository;
import com.jax.websocketserver.data.repositories.UserRepository;
import com.jax.websocketserver.data.request.LoginRequest;
import com.jax.websocketserver.data.request.RegisterRequest;
import com.jax.websocketserver.data.request.TokenRequest;
import com.jax.websocketserver.data.response.Token;
import com.jax.websocketserver.data.response.UserInfo;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    LoginLogRepository loginLogRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    DozerBeanMapper mapper;

    @Override
    public Token login(LoginRequest loginData) {
        User loginUser = userRepository.findUserByUsername(loginData.getUsername()).orElse(null);
        if (Objects.isNull(loginUser)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username or password invalid");
        }

        return null;
    }

    @Override
    public Token register(RegisterRequest requestData) {

        LoginLogs registerLog = new LoginLogs();
        if (userRepository.existsUserByEmail(requestData.getEmail())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Email is already register, please check again or login with email "+ requestData.getEmail());
        }
        if (userRepository.existsUserByUsername(requestData.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                    "Username is not valid, someone using this username, please check again or login with username "+ requestData.getUsername());
        }
        User newUser = mapper.map(requestData, User.class);

        userRepository.save(newUser);
        loginLogRepository.save(registerLog);

        return authorizeUser(newUser);
    }

    @Override
    public Token tokenLogin(TokenRequest tokenRequest) {
        return null;
    }

    @Override
    public UserInfo info(UserPrincipal currentUser) {
        return currentUser.getUserInfo();
    }

    private Token authorizeUser(User user) {
        UserInfo userInfo = new UserInfo();
        Token token = new Token();

        userInfo.setAddress(user.getAddress());
        return token;
    }
}
