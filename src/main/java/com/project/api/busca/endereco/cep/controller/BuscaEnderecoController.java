package com.project.api.busca.endereco.cep.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	public ResponseEntity<Endereco> buscaEndereco(@RequestBody @Valid Cep cep) throws Exception {
		return ResponseEntity.ok().body(service.executar(cep));
		
	}
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
