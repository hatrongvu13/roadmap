package com.jax.data.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class LoginRequestDTO {
	@NotNull
	String mbToken;
}
