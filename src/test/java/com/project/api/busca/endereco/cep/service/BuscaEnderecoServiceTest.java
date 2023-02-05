package com.project.api.busca.endereco.cep.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.api.busca.endereco.cep.infraestrutura.rest.BuscaEnderecoRestClient;
import com.project.api.busca.endereco.cep.model.Cep;
import com.project.api.busca.endereco.cep.model.Endereco;

@ExtendWith(MockitoExtension.class)
public class BuscaEnderecoServiceTest {
	
	@InjectMocks
	private BuscaEnderecoService service;
	
	@Mock
	private BuscaEnderecoRestClient buscaEnderecoRestClient;
	
	private Cep cep;
	private Endereco endereco;
	
	@BeforeEach
	void setUp() {
		cep = new Cep("81770817");
		endereco = Endereco.builder()
				.cep("81770817")
				.bairro("Alto Boqueirão")
				.complemento("")
				.frete("R$ 17.30")
				.localidade("Curitiba")
				.logradouro("Zires Ferreira Ribas")
				.uf("PR")
				.build();
	}

	@Test
	void deveRetornarEndereco() throws Exception {
		when(buscaEnderecoRestClient.buscarEndereco(cep)).thenReturn(endereco);
		var response = assertDoesNotThrow(() -> service.executar(cep));
		assertNotNull(response);
		
	}

}
