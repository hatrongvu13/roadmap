package com.jax.websocketserver.data.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class LoginRequest {

    @NotBlank(message = "Username is not blank")
    @NotNull(message = "Username is not null")
    private String username;

    @NotBlank(message = "Password is not blank")
    @NotNull(message = "Password is not empty")
    private String password;

}
