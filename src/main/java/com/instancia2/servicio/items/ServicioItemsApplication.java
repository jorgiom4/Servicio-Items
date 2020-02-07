package com.instancia2.servicio.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
// @RibbonClient(name = "servicio-productos") --> Si quita al tener Eureka que viene con Ribbon implicito
@EnableFeignClients
@EnableCircuitBreaker
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class ServicioItemsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServicioItemsApplication.class, args);
	}

}
