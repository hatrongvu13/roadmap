package com.jax.data.DTO;

import com.jax.api.authentications.TokenUser;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserInfoDTO {
	TokenUser detail;
}
