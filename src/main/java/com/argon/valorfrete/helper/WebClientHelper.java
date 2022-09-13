package com.argon.valorfrete.helper;

import org.springframework.web.reactive.function.client.ClientResponse;

import com.argon.valorfrete.client.ClientWebException;

import reactor.core.publisher.Mono;

public interface WebClientHelper {

	default Mono<? extends Throwable> handle4xxError(ClientResponse clientResponse) {
		Mono<String> errorMessage = clientResponse.bodyToMono(String.class);
		return errorMessage.flatMap((message) -> {
			System.out.println("-- Houve um erro -- ");
			throw new ClientWebException(String.format("%s - %s", clientResponse.statusCode(), message));
		});
	}

}
