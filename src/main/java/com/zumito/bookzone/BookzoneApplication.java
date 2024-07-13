package com.zumito.bookzone;

import com.zumito.bookzone.infrestructure.MainRunnerApp;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookzoneApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BookzoneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		MainRunnerApp runnerApp = new MainRunnerApp();
		runnerApp.showMenu();
	}
}
