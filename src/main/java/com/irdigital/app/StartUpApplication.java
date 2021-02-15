package com.irdigital.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
@SpringBootApplication
@EntityScan(basePackages = {"com.irdigital.jpa"})
@EnableJpaRepositories(basePackages = {"com.irdigital.repository"})
@ComponentScan(basePackageClasses = SwaggerConfig.class)
public class StartUpApplication {

	public static void main(String[] args) {
		SpringApplication.run(StartUpApplication.class, args);
	}
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "<center><br><strong>xIrDigital - SellerCenter</strong><br><br> <a href='./swagger-ui.html'>Swagger</a></center>";
	}
}
