package com.cg.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication(scanBasePackages= {"com.cg.pizza"})
@EntityScan(basePackages="com.cg.pizza.beans")
@EnableJpaRepositories(basePackages="com.cg.pizza.daoservices")
@EnableWebMvc
public class CgPizzaOrderSystemSpringBootRestjpaDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CgPizzaOrderSystemSpringBootRestjpaDataApplication.class, args);
	}
}
