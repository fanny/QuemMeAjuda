package util;

public enum ErroController {
	
	TUTOR_NAO_ENCONTRADO("Tutor nao encontrado"),
	CADASTRAR_HORARIO_INVALIDO("Erro no cadastrar horario: "),
	CADASTRAR_LOCAL_INVALIDO("Erro no cadastrar local de atendimento: "),
	BUSCA_TUTOR_INVALIDA("Erro na busca por tutor: "),
	TORNA_TUTOR_INVALIDO("Erro na definicao de papel: ");
	
	private String descricao;
	
	/**
	 * Inicializa os valores de cada enum
	 * @param descricao o valor do enum
	 */
	private ErroController(String descricao){
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
