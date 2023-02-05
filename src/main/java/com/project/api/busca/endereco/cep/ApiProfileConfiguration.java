package com.project.api.busca.endereco.cep;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource(ignoreResourceNotFound = true, value = "classpath:profile-${AMBIENTE}.properties")
public class ApiProfileConfiguration {
	
	@Value("${api.buscacep.endpoint}")
	private String endpoint;
	
	public String getEndpoint(String cep) {
		return String.format(endpoint, cep);
	}

	public void setEndpoint(String endpoint) {
		this.endpoint = endpoint;
	}

}
