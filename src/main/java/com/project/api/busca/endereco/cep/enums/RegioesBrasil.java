package com.project.api.busca.endereco.cep.enums;

public enum RegioesBrasil {
	
	PARANA("PR", 1),
	SANTA_CATARINA("SC", 1),
	RIO_GRANDE_SUL("RS", 1),
	SAO_PAULO("SP", 2),
	RIO_DE_JANEIRO("RJ", 2),
	MINAS_GERAIS("MG", 2),
	ESPIRITO_SANTO("ES", 2),
	MATO_GROSSO_SUL("MS", 3),
	MATO_GROSSO("MT", 3),
	GOIAS("GO", 3),
	DISTRITO_FEDERAL("DF", 3),
	BAHIA("BA", 4),
	PERNAMBUCO("PE", 4),
	PARAIBA("PB", 4),
	MARANHAO("MA", 4),
	RIO_GRANDE_NORTE("RN", 4),
	PIAUI("PI", 4),
	CEARA("CE", 4),
	ALAGOAS("AL", 4),
	SERGIPE("SE", 4),
	AMAZONAS("AM", 5),
	ACRE("AC", 5),
	RONDONIA("RO", 5),
	RORAIMA("RR", 5),
	AMAPA("AP", 5),
	PARA("PA", 5),
	TOCANTINS("TO", 5);
	
	private String nome;
	private Integer codigo;
	
	private RegioesBrasil(String nome, Integer codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public static Integer buscarRegiao(String siglaEstado) {

		for (RegioesBrasil regiao : RegioesBrasil.values()) {
			if (regiao.getNome().equals(siglaEstado)) {
				return regiao.getCodigo();
			}
		}
		
		return null;
	}

}
