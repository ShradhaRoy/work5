package com.cg.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
public class ShradhaRoyProductCartManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShradhaRoyProductCartManagementApplication.class, args);
	}

}
