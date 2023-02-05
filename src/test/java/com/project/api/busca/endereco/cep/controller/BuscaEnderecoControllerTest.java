package com.project.api.busca.endereco.cep.controller;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.api.busca.endereco.cep.model.Cep;
import com.project.api.busca.endereco.cep.model.Endereco;
import com.project.api.busca.endereco.cep.service.BuscaEnderecoService;

@ExtendWith(MockitoExtension.class)
public class BuscaEnderecoControllerTest {
	
	@InjectMocks
	private BuscaEnderecoController buscaEnderecoController;
	
	@Mock
	private BuscaEnderecoService buscaEnderecoService;
	
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
		
		when(buscaEnderecoService.executar(cep)).thenReturn(endereco);
		var response = assertDoesNotThrow(() -> buscaEnderecoController.buscaEndereco(cep));
		assertNotNull(response);
		assertEquals(endereco, response.getBody());
	}
}
