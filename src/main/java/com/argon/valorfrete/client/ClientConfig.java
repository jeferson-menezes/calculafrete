package com.argon.valorfrete.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {

	
	@Bean
	public WebClient webClientCalculador(WebClient.Builder builder) {
		return builder.baseUrl("https://ws.correios.com.br")
				.build();
	}
}
