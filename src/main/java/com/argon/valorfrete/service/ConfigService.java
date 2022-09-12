package com.argon.valorfrete.service;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.argon.valorfrete.model.CodigoServico;
import com.argon.valorfrete.model.Config;
import com.argon.valorfrete.model.Produto;
import com.argon.valorfrete.repository.ConfigRepository;
import com.argon.valorfrete.repository.ProdutoRepository;

@Service
public class ConfigService {

	private boolean system = true;

	@Autowired
	private ConfigRepository configRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public void inicial(Scanner scanner) {
		system = true;
		while (system) {
			System.out.println("Selecione a acão de config:");
			System.out.println("0 - Exit");
			System.out.println("1 - Consultar autenticação");
			System.out.println("2 - Cadastrar/Atualizar autenticação");
			System.out.println("3 - Consultar dimensões produto");
			System.out.println("4 - Cadastrar/Atualizar dimensões produto");

			int action = scanner.nextInt();

			switch (action) {

			case 1:
				consultarAutenticacao(scanner);
				break;
			case 2:
				atualizarAutenticacao(scanner);
				break;
			case 3:
				consultarDimensoes(scanner);
				break;
			case 4:
				atualizarDimensoes(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void atualizarDimensoes(Scanner scanner) {
		System.out.println("Informe o código do serviço");
		Arrays.asList(CodigoServico.values()).forEach(c -> System.out.println(c + " - " + c.getCodigo()));

		CodigoServico codigoServico = CodigoServico.valueOf(scanner.next());

		System.out.println("Informe o peso do produto em KG");
		double peso = Double.valueOf(scanner.next());

		System.out.println("Informe o comprimento do produto em CM");
		double comprimento = Double.valueOf(scanner.next());

		System.out.println("Informe a altura do produto em CM");
		double altura = Double.valueOf(scanner.next());

		System.out.println("Informe a largura do produto em CM");
		double largura = Double.valueOf(scanner.next());

		Produto produto = new Produto(codigoServico, peso, comprimento, altura, largura);

		produtoRepository.save(produto);

		System.out.println("Dimensões do produto salva com sucesso!");
		System.out.println("\n");

	}

	private void consultarDimensoes(Scanner scanner) {
		Optional<Produto> optional = produtoRepository.findById(1L);
		if (optional.isPresent()) {
			System.out.println(optional.get());
			System.out.println("\n");
		} else {
			System.out.println("Dimensões produto não cadastrada!");
			System.out.println("\n");
		}
	}

	private void atualizarAutenticacao(Scanner scanner) {
		System.out.println("Informe o código da empresa");
		String user = scanner.next();
		System.out.println("Informe a senha da empresa");
		String senha = scanner.next();

		Config config = new Config(1l, user, senha);

		configRepository.save(config);

		System.out.println("Autenticação salva com sucesso!");
		System.out.println("\n");
	}

	private void consultarAutenticacao(Scanner scanner) {
		Optional<Config> optional = configRepository.findById(1L);
		if (optional.isPresent()) {
			System.out.println(optional.get());
			System.out.println("\n");
		} else {
			System.out.println("Autenticação Não cadastrada!");
			System.out.println("\n");
		}
	}

}
