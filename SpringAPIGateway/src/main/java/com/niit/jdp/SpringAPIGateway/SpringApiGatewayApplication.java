package com.niit.jdp.SpringAPIGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@EnableEurekaClient
public class SpringApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p
						.path("/userservice/**")
						.uri("http://authentication-service:8080/")) // use the name of the application in the uri

				.route(p -> p
						.path("/api/v1/**")
						.uri("http://customer-service:8086/"))
				.build();
	}

}
//post man::http://localhost:9005/api/v1/fetchmovie
//http://localhost:9005/userservice/register
