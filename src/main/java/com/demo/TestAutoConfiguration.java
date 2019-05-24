package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(TestProperties.class)
@ConditionalOnClass(TestService.class)
public class TestAutoConfiguration {
    @Autowired
    private TestProperties testProperties;

    @Bean
    @ConditionalOnMissingBean(TestService.class)
    public TestService testService() {
        return new TestService().setMsg(testProperties.getTest1() + testProperties.getTest2() + testProperties.getPool());
    }
}
