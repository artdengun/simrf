package com.deni.gunawan.sistemmanajemenricheesefactory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.dialect.springdata.SpringDataDialect;

@SpringBootApplication
public class SistemManajemenRicheeseFactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemManajemenRicheeseFactoryApplication.class, args);
	}

	@Bean
	public SpringDataDialect springDataDialect() {
		return new SpringDataDialect();
	}
}
