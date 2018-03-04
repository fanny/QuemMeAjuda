package util.aluno;

public enum MensagemAluno {
	
	EMAIL_INVALIDO("Email invalido"),
	ALUNO_NAO_ENCONTRADO("Aluno nao encontrado"),
	TELEFONE_INVALIDO("Telefone invalido"),
	MATRICULA_INVALIDA("Matricula invalida"),
	CODIGO_INVALIDO("Codigo de curso invalido"),
	NOME_INVALIDO("Nome nao pode ser vazio ou nulo"),
	ALUNO_JA_CADASTRADO("Aluno de mesma matricula ja cadastrado"),
	NOTA_AVALIACAO_INVALIDA("Nota de avaliação inválida");
	
	private String descricao;
	
	/**
	 * Inicializa os valores de cada enum
	 * @param descricao o valor do enum
	 */
	private MensagemAluno(String descricao){
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
