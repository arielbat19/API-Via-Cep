package com.project.api.busca.endereco.cep.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Endereco {

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;
	private String frete;
	
}
