package com.rosendo.challengeliteralura;

import com.rosendo.challengeliteralura.services.ApiBooksMenu;
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
		ApiBooksMenu menu = new ApiBooksMenu();
		menu.runApp();
	}
}
