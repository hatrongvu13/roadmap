package com.jax.websocketserver.api.services;

import com.jax.websocketserver.data.DTO.UserPrincipal;
import com.jax.websocketserver.data.request.LoginRequest;
import com.jax.websocketserver.data.request.RegisterRequest;
import com.jax.websocketserver.data.request.TokenRequest;
import com.jax.websocketserver.data.response.Token;
import com.jax.websocketserver.data.response.UserInfo;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    Token login(LoginRequest loginData);
    Token register(RegisterRequest requestData);
    Token tokenLogin(TokenRequest tokenRequest);

    UserInfo info(UserPrincipal currentUser);
}
