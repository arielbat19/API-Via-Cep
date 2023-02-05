package com.project.api.busca.endereco.cep.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.api.busca.endereco.cep.enums.RegioesBrasil;
import com.project.api.busca.endereco.cep.infraestrutura.rest.BuscaEnderecoRestClient;
import com.project.api.busca.endereco.cep.model.Cep;
import com.project.api.busca.endereco.cep.model.Endereco;

@Service
public class BuscaEnderecoService {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private BuscaEnderecoRestClient restClient;

	public Endereco executar(Cep cep) throws Exception {
		
		log.info("[CEP: {}]. Buscando dados de endereço.", cep.getCep());
		Endereco endereco = restClient.buscarEndereco(cep);
		
		if(endereco.getUf() == null) {
			throw new Exception();
		}
		
		Integer regiao = RegioesBrasil.buscarRegiao(endereco.getUf());
		String valorFrete = calcularFrete(regiao);
		endereco.setFrete(valorFrete);
		return endereco;
	}

	private String calcularFrete(Integer codigoRegiao) {
		String frete = null;

		switch (codigoRegiao) {
		// SUL
		case 1:
			frete = "R$ 17.30";
			break;
		// SUDESTE
		case 2:
			frete = "R$ 7.85";
			break;
		// CENTRO OESTE
		case 3:
			frete = "R$ 12.50";
			break;
		// NORDESTE
		case 4:
			frete = "R$ 15.98";
			break;
		// NORTE
		case 5:
			frete = "R$ 20.83";
			break;
		}

		return frete;
	}

}
