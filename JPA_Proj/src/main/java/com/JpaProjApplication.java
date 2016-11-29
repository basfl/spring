package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaProjApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(JpaProjApplication.class, args);
		Config conf = ctx.getBean(Config.class);
		conf.func();
	}
	@Bean
	public Config  config(){
		return new Config();
	}
	
}
