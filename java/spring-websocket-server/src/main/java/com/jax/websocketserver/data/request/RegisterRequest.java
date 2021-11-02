package com.jax.websocketserver.data.request;

import com.jax.websocketserver.data.enums.SexEnums;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class RegisterRequest {
    @NotNull
    @Size(min = 6, message = "Username not less than 6 character")
    private String username;

    @NotNull
    @Size(min = 6, message = "Password not less than 6 character")
    private String password;

    @NotNull
    @Email
    private String email;

    private String dob;

    private String mobile;

    private String fullName;


    private SexEnums sex;
}
