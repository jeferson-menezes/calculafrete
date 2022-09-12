package com.argon.valorfrete;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.argon.valorfrete.service.CalculadorService;
import com.argon.valorfrete.service.ConfigService;

@SpringBootApplication
public class ValorfreteApplication implements CommandLineRunner {

	private boolean system = true;

	@Autowired
	private ConfigService configService;
	
	@Autowired
	private CalculadorService calculadorService;

	public static void main(String[] args) {
		SpringApplication.run(ValorfreteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Selecione a acão:");

			System.out.println("0 - Exit");
			System.out.println("1 - Config");
			System.out.println("2 - Calcular Preço Prazo");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				configService.inicial(scanner);
				break;
			case 2:
				calculadorService.inicial(scanner);
				break;
			default:
				system = false;
				break;
			}

		}
	}

}
