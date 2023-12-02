package com.java.projeto_JAVA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjetoJavaApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjetoJavaApplication.class, args);
	}

}
