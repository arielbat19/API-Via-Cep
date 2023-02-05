package com.project.api.busca.endereco.cep.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CodeErrorDto {
	private Integer codigo;
	private String mensagem;

}
