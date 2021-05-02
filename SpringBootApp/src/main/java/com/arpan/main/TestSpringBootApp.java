package com.arpan.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan(basePackages = {"com.arpan"})
//@EnableJpaRepositories("com.test.repository")
@EntityScan("com.arpan.beans")
public class TestSpringBootApp extends SpringBootServletInitializer {

	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(TestSpringBootApp.class);
    }
	
	public static void main(String[] args) {
		SpringApplication.run(TestSpringBootApp.class, args);
	}

}
