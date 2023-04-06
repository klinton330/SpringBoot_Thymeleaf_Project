package com.webapps.SBoot_Thymeleaf_CRUD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.webapps."})
@EnableJpaRepositories("com.webapps.repository.")
@EntityScan("com.webapps.entity.")
public class SBootThymeleafCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SBootThymeleafCrudApplication.class, args);
	}

}
