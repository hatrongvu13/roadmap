package com.jax.websocketserver.data.response;

import com.jax.websocketserver.data.enums.ScopesEnums;
import com.jax.websocketserver.data.enums.SexEnums;
import lombok.Data;

import java.util.Set;

@Data
public class UserInfo {
    private String username;
    private Set<ScopesEnums> scopes;
    private String email;
    private String dob;
    private String fullName;
    private String mobile;
    private String address;
    private SexEnums sex;
}
