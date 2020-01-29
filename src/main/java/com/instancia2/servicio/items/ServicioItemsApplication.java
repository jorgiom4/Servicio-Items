package com.instancia2.servicio.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
// @RibbonClient(name = "servicio-productos") --> Si quita al tener Eureka que viene con Ribbon implicito
@EnableFeignClients
@SpringBootApplication
public class ServicioItemsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServicioItemsApplication.class, args);
	}

}
