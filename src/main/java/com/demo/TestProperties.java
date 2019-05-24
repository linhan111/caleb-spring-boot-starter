package com.demo;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties(prefix = "spring.test")
public class TestProperties {
    private String test1 = "tests1";
    private String test2 = "test2";

    private Pool pool = new Pool();

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    private class Pool {
        private int min = 0;
        private int max = 10;
    }
}
