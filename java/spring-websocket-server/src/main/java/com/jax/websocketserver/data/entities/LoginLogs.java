package com.jax.websocketserver.data.entities;

import com.jax.websocketserver.data.enums.LoginEnums;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Document(collection = "logs")
public class LoginLogs {

    @Id
    private ObjectId id;

    @NotNull
    private String username;

    @NotBlank
    private LoginEnums status;

    @CreatedDate
    private LocalDateTime loginTime;

}
