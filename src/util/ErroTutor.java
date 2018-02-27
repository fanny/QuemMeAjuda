package util;

public enum ErroTutor {
	
	TUTOR_NAO_ENCONTRADO("Tutor nao encontrado"),
	DISCIPLINA_JA_EXISTE("Ja eh tutor dessa disciplina"),
	PROFICIENCIA_INVALIDA("Proficiencia invalida");
	
	private String descricao;
	
	/**
	 * Inicializa os valores de cada enum
	 * @param descricao o valor do enum
	 */
	private ErroTutor(String descricao){
		this.descricao = descricao;
	}
	
	/**
	 * Método usado para obter o valor do enum.
	 * @return String o valor do enum escolhido
	 */
	public String toString(){
		return this.descricao;
	}

}
