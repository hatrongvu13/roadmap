package com.jax.api.authentications;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TokenUser {

	private String username;
	private String fullName;
	private String dob;
	private String mobile;
	private String email;
	private List<String> authorities;
}
