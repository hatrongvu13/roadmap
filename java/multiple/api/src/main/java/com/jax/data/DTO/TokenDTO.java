package com.jax.data.DTO;

import lombok.Data;

@Data
public class TokenDTO {
	String token;
	
	public TokenDTO(String token) {
		this.token = token;
	}
}
