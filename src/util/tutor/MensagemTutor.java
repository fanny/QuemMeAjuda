package util.tutor;

public enum MensagemTutor {
	
	DISCIPLINA_JA_EXISTE("Ja eh tutor dessa disciplina"),
	PROFICIENCIA_INVALIDA("Proficiencia invalida"),
	DISCIPLINA_INVALIDA("disciplina nao pode ser vazio ou em branco"),
	LOCAL_INVALIDO("local nao pode ser vazio ou em branco"),
	DIA_ATENDIMENTO_INVALIDO("dia nao pode ser vazio ou em branco"),
	HORARIO_ATENDIMENTO_INVALIDO("horario nao pode ser vazio ou em branco"),
	EMAIL_INVALIDO("email nao pode ser vazio ou em branco"),
	ALUNO_INVALIDO("O aluno não pode ser nulo"),
	TOP("TOP"),
	APRENDIZ("Aprendiz"),
	TUTOR("Tutor"),
	AJUDA_JA_AVALIADA("Ajuda ja avaliada"),
	ID_NAO_ENCONTRADO("id nao encontrado"),
	NOTA_NAO_PODE_SER_MENOR_QUE_ZERO("nota nao pode ser menor que 0"),
	NOTA_NAO_PODE_SER_MAIOR_QUE_CINCO("nota nao pode ser maior que 5"),
	AJUDA_NAO_ATRIBUIDA_A_TUTOR("Ajuda nao atribuida a tutor");
	
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
