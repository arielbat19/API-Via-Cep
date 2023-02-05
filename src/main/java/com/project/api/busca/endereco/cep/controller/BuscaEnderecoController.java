package com.project.api.busca.endereco.cep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.api.busca.endereco.cep.model.Cep;
import com.project.api.busca.endereco.cep.model.Endereco;
import com.project.api.busca.endereco.cep.service.BuscaEnderecoService;

@RestController
@RequestMapping(value = "v1/consulta-endereco")
public class BuscaEnderecoController {
	
	@Autowired
	private BuscaEnderecoService service;
	
	@PostMapping
	public ResponseEntity<Endereco> buscaEndereco(@RequestBody Cep cep) throws Exception {
		return ResponseEntity.ok().body(service.executar(cep));
		
	}

}
