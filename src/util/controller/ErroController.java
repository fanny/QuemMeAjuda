package util.controller;

public enum ErroController {
	
	TUTOR_NAO_ENCONTRADO("Tutor nao encontrado"),
	TUTOR_NAO_CADASTRADO("tutor nao cadastrado"),
	CADASTRAR_HORARIO_INVALIDO("Erro no cadastrar horario: "),
	CADASTRAR_LOCAL_INVALIDO("Erro no cadastrar local de atendimento: "),
	BUSCA_TUTOR_INVALIDA("Erro na busca por tutor: "),
	JA_EH_TUTOR("Ja eh tutor dessa disciplina"),
	TORNA_TUTOR_INVALIDO("Erro na definicao de papel: "),
	GET_ALUNO_MATRICULA_INVALIDO("Erro na obtenção do objeto aluno: "),
	BUSCA_ALUNO_INVALIDA("Erro na busca por aluno: "),
	GET_INFO_ALUNO_INVALIDA("Erro na obtencao de informacao de aluno: "),
	CADASTRO_ALUNO_INVALIDO("Erro no cadastro de aluno: "),
	ID_INVALIDO("id nao pode menor que zero"),
	OBJETO_NULO("O objeto não pode ser nulo"),
	PEDIDO_DE_AJUDA_PRESENCIAL_INVALIDA("Erro no pedido de ajuda presencial: "),
	PEDIDO_DE_AJUDA_ONLINE_INVALIDA("Erro no pedido de ajuda online: "),
	ID_NAO_ENCONTRADO("id nao encontrado"),
	GET_INFO_AJUDA_INVALIDA("Erro ao tentar recuperar info da ajuda : "),
	PEGAR_TUTOR_INVALIDO("Erro ao tentar recuperar tutor : ");
	
	
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
