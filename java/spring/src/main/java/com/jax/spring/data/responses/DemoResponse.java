package com.jax.spring.data.responses;

import com.jax.spring.data.entities.Demo;
import lombok.Data;

import java.util.List;

@Data
public class DemoResponse {
    List<Demo> content;
    private Integer pageSize;
    private Integer currentPage;
    private Integer totalRecord;
}
