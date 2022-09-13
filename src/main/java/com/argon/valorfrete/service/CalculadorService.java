package com.argon.valorfrete.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;

import com.argon.valorfrete.client.dto.ParamentrosDto;
import com.argon.valorfrete.client.form.PrazoForm;
import com.argon.valorfrete.helper.StreamHelper;
import com.argon.valorfrete.helper.WebClientHelper;
import com.argon.valorfrete.model.Config;
import com.argon.valorfrete.model.Produto;
import com.argon.valorfrete.repository.ConfigRepository;
import com.argon.valorfrete.repository.ProdutoRepository;

@Service
public class CalculadorService implements WebClientHelper {

	private boolean system = true;

	@Autowired
	private ConfigRepository configRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private WebClient client;

	public void inicial(Scanner scanner) {
		system = true;

		while (system) {
			System.out.println("Selecione a acão de calculadora:");
			System.out.println("0 - Sair");
			System.out.println("1 - Calcular preço prazo");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				calcularPrecoPrazo(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void calcularPrecoPrazo(Scanner scanner) {

		String codigoEmpresa = "";
		String senhaEmpresa = "";

		Optional<Config> configOpt = configRepository.findById(1L);

		if (configOpt.isPresent()) {
			codigoEmpresa = configOpt.get().getCodigoEmpresa();
			senhaEmpresa = configOpt.get().getSenhaEmpresa();
		}

		Optional<Produto> optional = produtoRepository.findById(1L);

		if (!optional.isPresent()) {
			System.out.println("Parametro do produto não cadastrado!");
			System.out.println("\n");
			return;
		}

		System.out.println("Informe o cep de origem");
		String cepOrigem = scanner.next();

		System.out.println("Informe o cep de destino");
		String cepDestino = scanner.next();

		ParamentrosDto parametros = new ParamentrosDto(codigoEmpresa, senhaEmpresa, optional.get(), cepOrigem,
				cepDestino);

		MultiValueMap<String, String> params = StreamHelper.converterNotNullObjeto(parametros);

		PrazoForm retorno = client.get()
				.uri(uriBuilder -> uriBuilder.path("/calculador/CalcPrecoPrazo.aspx").queryParams(params).build())
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, clientResponse -> handle4xxError(clientResponse))
				.bodyToMono(PrazoForm.class)
				.block();

		System.out.println(retorno);
		System.out.println("\n");
	}
}
