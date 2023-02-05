package com.project.api.busca.endereco.cep.dto;

import lombok.Data;

@Data

public class CodeErrorDto {
	private Integer codigo;
	private String mensagem;
	
	public CodeErrorDto() {
	}

	public CodeErrorDto(Integer codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}


}
