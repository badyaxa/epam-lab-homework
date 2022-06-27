package com.epam.spring.homework2.config;

import com.epam.spring.homework2.beans.BeanB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;


@Configuration
@PropertySource("beanb.properties")
@Import(BeanCDConfigFromProperties.class)
public class BeanBConfigFromProperties {

    @Value("${beanB.name}")
    private String name;

    @Value("${beanB.value}")
    private int value;

    @Bean("beanB")
    @DependsOn("beanD")
    public BeanB getBeanB() {
        System.out.println("created BeanB");
        return new BeanB(name, value);
    }
}