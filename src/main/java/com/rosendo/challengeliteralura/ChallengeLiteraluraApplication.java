package com.rosendo.challengeliteralura;

import com.rosendo.challengeliteralura.controllers.ApiBooksController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiteraluraApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraluraApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("iniciei");
		ApiBooksController api = new ApiBooksController();
		api.consumeApi();
	}
}
