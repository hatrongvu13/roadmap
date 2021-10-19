package com.jax.spring.api.services;

import com.jax.spring.data.requests.DemoRequest;
import com.jax.spring.data.responses.DemoResponse;

public interface DemoServices {
    String fake();
    DemoResponse search(DemoRequest demo);
}
