package com.instancia2.servicio.items;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ServicioItemsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ServicioItemsApplication.class, args);
	}

}
