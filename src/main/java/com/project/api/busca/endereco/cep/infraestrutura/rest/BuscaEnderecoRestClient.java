package com.project.api.busca.endereco.cep.infraestrutura.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import com.google.gson.Gson;
import com.project.api.busca.endereco.cep.BuscaEnderecoProfileConfiguration;
import com.project.api.busca.endereco.cep.model.Cep;
import com.project.api.busca.endereco.cep.model.Endereco;

@Component
public class BuscaEnderecoRestClient {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BuscaEnderecoClientRestTemplate restTemplate;

	@Autowired
	private BuscaEnderecoProfileConfiguration config;

	public Endereco buscarEndereco(Cep cep) throws Exception {

		String endpoint = config.getEndpoint(cep.getCep());

		ResponseEntity<String> response = null;
		String jsonResposta = null;

		try {
			response = restTemplate.execute(endpoint, HttpMethod.GET);
			jsonResposta = response.getBody();

			return new Gson().fromJson(jsonResposta, Endereco.class);
		} catch (HttpClientErrorException e) {
			log.error(e.getMessage(), e);
			throw new Exception();
		}

	}
}
