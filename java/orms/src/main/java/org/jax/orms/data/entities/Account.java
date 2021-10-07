package org.jax.orms.data.entities;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Account {
    private Integer account_id;
    private String username;
    private String password;
    private Timestamp createdDate;
    private Timestamp updatedDate;
}
