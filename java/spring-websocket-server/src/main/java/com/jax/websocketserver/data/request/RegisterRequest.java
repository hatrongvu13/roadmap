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

    @NotNull(message = "Date of birth is not empty")
    private String dob;

    @NotNull(message = "Mobile is not empty")
    private String mobile;

    @NotNull(message = "Full name is not empty")
    private String fullName;

    @NotNull(message = "Value is one of [MALE,FEMALE,OTHER]")
    private SexEnums sex;
}
