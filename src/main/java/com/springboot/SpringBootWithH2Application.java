package com.springboot;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootWithH2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithH2Application.class, args);
	}
	@Bean
	public  Docket swaggerDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.paths(PathSelectors.ant("/api/*"))
				//.apis(RequestHandlerSelectors.basePackage("com.springboot"))
				.build()
				.apiInfo(apiDetails());
		
	}
	
	public ApiInfo apiDetails() {
		return new ApiInfo(
				"Address book API",
				"Book API",
				"1.0",
				"Free to use",
				 new springfox.documentation.service.Contact("Book", "http://book.io", "book@gmail.com"),
				 "API License",
				 "http://book.io",
				 Collections.emptyList());
		
	}

}
//http://localhost:8081/swagger-ui.html
//http://localhost:8081/v2/swagger-ui.html