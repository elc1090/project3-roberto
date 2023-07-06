package com.roberto.greenhousing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class GreenhousingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreenhousingApplication.class, args);
	}

}
