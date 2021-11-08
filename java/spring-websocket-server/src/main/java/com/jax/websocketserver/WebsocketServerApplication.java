package com.jax.websocketserver;

import org.dozer.DozerBeanMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;

@SpringBootApplication
public class WebsocketServerApplication {

    @Bean
    DozerBeanMapper mapper() {
        DozerBeanMapper beanMapper = new DozerBeanMapper();

        beanMapper.setMappingFiles(Collections.singletonList("dozerJdk8Converters.xml"));
//		new CsvDozerBeanReader(reader, CsvPreference.STANDARD_PREFERENCE, beanMapper);

        return beanMapper;
    }

    public static void main(String[] args) {
        SpringApplication.run(WebsocketServerApplication.class, args);
    }

}
