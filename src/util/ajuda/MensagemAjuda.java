package util.ajuda;

/**
 * Classe que contém as mensagens de erro lançadas pelo controller de ajuda
 * @author fanny
 *
 */
public enum MensagemAjuda {
	
	DISCIPLINA_INVALIDA("disciplina nao pode ser vazio ou em branco"),
	LOCAL_INVALIDO("local de interesse nao pode ser vazio ou em branco"),
	DIA_ATENDIMENTO_INVALIDO("dia nao pode ser vazio ou em branco"),
	HORARIO_ATENDIMENTO_INVALIDO("horario nao pode ser vazio ou em branco"),
	MATRICULA_ALUNO_INVALIDA("matricula de aluno nao pode ser vazio ou em branco"),
	ID_NAO_ENCONTRADO("id nao encontrado "),
	ID_INVALIDO("id nao pode menor que zero "),
	ATRIBUTO_INVALIDO("atributo nao pode ser vazio ou em branco"),
	AJUDA_JA_AVALIADA("Ajuda ja avaliada");
	
	private String descricao;
	
	/**
	 * Inicializa os valores de cada enum
	 * @param descricao o valor do enum
	 */
	private MensagemAjuda(String descricao){
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