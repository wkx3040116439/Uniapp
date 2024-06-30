package com.example.Uniapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.example.Uniapp.mapper") // Scan Mapper interfaces
public class UniappApplication {

	public static void main(String[] args) {
		SpringApplication.run(UniappApplication.class, args);

	}

}
