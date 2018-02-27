package util;

public enum ErroAluno {
	
	EMAIL_INVALIDO("Email invalido"),
	ALUNO_NAO_ENCONTRADO("Aluno nao encontrado"),
	NOME_INVALIDO("Nome nao pode ser vazio ou nulo"),
	ALUNO_JA_CADASTRADO("Aluno de mesma matricula ja cadastrado");
	
	private String descricao;
	
	/**
	 * Inicializa os valores de cada enum
	 * @param descricao o valor do enum
	 */
	private ErroAluno(String descricao){
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
