package com.jax.api.controllers;


import io.swagger.annotations.Api;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/authentication", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = "Authentication controller")
@CrossOrigin(value = "*", maxAge = 3600)
public class AuthenticationController {

}
