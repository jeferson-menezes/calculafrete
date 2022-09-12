package com.argon.valorfrete.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.codec.xml.Jaxb2XmlDecoder;
import org.springframework.http.codec.xml.Jaxb2XmlEncoder;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {

	@Bean
	public WebClient webClientCalculador(WebClient.Builder builder) {
		return builder.baseUrl("http://ws.correios.com.br")
				.defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE)
				.codecs(configurer -> {
					configurer.defaultCodecs().jaxb2Decoder(new Jaxb2XmlDecoder());
					configurer.defaultCodecs().jaxb2Encoder(new Jaxb2XmlEncoder());
				}).build();
	}
}
