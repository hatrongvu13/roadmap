package com.jax.spring.api.controllers;

import com.jax.spring.api.services.DemoServices;
import com.jax.spring.data.requests.DemoRequest;
import com.jax.spring.data.responses.DemoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/demo", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(value = "*", maxAge = 3600)
public class DemoController {

    @Autowired
    DemoServices demoServices;

    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
    public String hello(
            @PathVariable("name") String guys
    ) {
        return "Hello " + guys;
    }

    @RequestMapping(value = "/fake", method = RequestMethod.GET)
    public String fake(){
        return demoServices.fake();
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public DemoResponse search(@RequestBody DemoRequest demoRequest) {
        return demoServices.search(demoRequest);
    }
}
