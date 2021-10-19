package com.jax.spring.data.requests;

import lombok.Data;

@Data
public class DemoRequest {
    private Integer page;
    private Integer pageSize;
    private String name;
    private String type;
}
