package com.inventory.inventory_product;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class InventoryProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryProductApplication.class, args);
	}

}
