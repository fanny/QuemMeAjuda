package util;

public enum ErroTutor {
	
	DISCIPLINA_JA_EXISTE("Ja eh tutor dessa disciplina"),
	PROFICIENCIA_INVALIDA("Proficiencia invalida"),
	LOCAL_INVALIDO("Local de atendimento invalido"),
	DIA_ATENDIMENTO_INVALIDO("Dia invalido"),
	HORARIO_ATENDIMENTO_INVALIDO("Horario de atendimento invalido"),
	ALUNO_INVALIDO("O aluno não pode ser nulo");
	
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
