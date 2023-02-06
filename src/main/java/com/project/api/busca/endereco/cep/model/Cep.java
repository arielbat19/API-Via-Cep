package com.project.api.busca.endereco.cep.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Cep {
	
	@NotBlank(message = "O campo CEP é obrigatório")
	private String cep;
}
