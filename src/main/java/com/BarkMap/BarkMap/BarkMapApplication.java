package com.BarkMap.BarkMap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BarkMapApplication implements CommandLineRunner {
	public BarkMapApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(BarkMapApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

	}
}
