package util.tutor;

public enum MensagemTutor {
	
	DISCIPLINA_JA_EXISTE("Ja eh tutor dessa disciplina"),
	PROFICIENCIA_INVALIDA("Proficiencia invalida"),
	LOCAL_INVALIDO("local nao pode ser vazio ou em branco"),
	DIA_ATENDIMENTO_INVALIDO("dia nao pode ser vazio ou em branco"),
	HORARIO_ATENDIMENTO_INVALIDO("horario nao pode ser vazio ou em branco"),
	EMAIL_INVALIDO("email nao pode ser vazio ou em branco"),
	ALUNO_INVALIDO("O aluno não pode ser nulo"),
	TOP("TOP"),
	APRENDIZ("Aprendiz"),
	TUTOR("Tutor");
	
	private String descricao;
	
	/**
	 * Inicializa os valores de cada enum
	 * @param descricao o valor do enum
	 */
	private MensagemTutor(String descricao){
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
