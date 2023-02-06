package com.project.api.busca.endereco.cep.infraestrutura.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
public class ApiAquisicoesClientRestTemplate {

	private RestTemplate restTemplate;

	@Autowired
	public ApiAquisicoesClientRestTemplate(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}

	public ResponseEntity<String> execute(String endpoint, HttpMethod httpMethod)
			throws HttpClientErrorException {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		return executeGet(endpoint, headers, httpMethod);

	}

	private ResponseEntity<String> executeGet(String endpoint, HttpHeaders headers, HttpMethod httpMethod) {
		HttpEntity<String> request = new HttpEntity<>(headers);

		return restTemplate.exchange(endpoint, httpMethod, request, String.class);
	}

}
