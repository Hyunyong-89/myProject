package com.example.nrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication(exclude= {MultipartAutoConfiguration.class})
@EnableJpaAuditing
@EntityScan(basePackageClasses= {Jsr310JpaConverters.class}, basePackages= {"com.example.nrs"})
@ComponentScan(basePackages = {"com.example.nrs"})
public class NrsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NrsApplication.class, args);
	}

}
