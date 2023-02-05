package com.project.api.busca.endereco.cep.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.project.api.busca.endereco.cep.dto.CodeErrorDto;

@ControllerAdvice
public class CepException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(Exception.class)
	public ResponseEntity<List<CodeErrorDto>> handlerException(Exception e) {
		
		List<CodeErrorDto> listaErros = new ArrayList<CodeErrorDto>();
		listaErros.add(new CodeErrorDto(HttpStatus.BAD_REQUEST.value(), "CEP inválido."));
		
		return new ResponseEntity<List<CodeErrorDto>>(listaErros, HttpStatus.BAD_REQUEST);
	}
}
