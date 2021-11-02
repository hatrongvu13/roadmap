package com.jax.websocketserver.data.response;

import lombok.Data;

@Data
public class UserInfo {
    private String username;
    private String email;
    private String dob;
    private String fullName;
    private String mobile;
    private String address;
    private String sex;
}
