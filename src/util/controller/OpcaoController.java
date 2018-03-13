package util.controller;


/**
 * Classe que contém as opções de filtro usadas no controller
 * @author fanny
 *
 */
public enum OpcaoController {
	NOME("Nome"),
	EMAIL("Email"),
	TELEFONE("Telefone"),
	MATRICULA("Matricula"),
	OPCAO_INVALIDA("Opção inválida"),
	DISCIPLINA("disciplina"),
	LOCAL_INTERESSE("localInteresse"),
	HORARIO("horario"),
	DIA("dia"),
	TUTOR_MATRICULA("tutorMatricula");
	
	private String descricao;
	
	/**
	 * Inicializa os valores de cada enum
	 * @param descricao o valor do enum
	 */
	private OpcaoController(String descricao){
		this.descricao = descricao;
	}
	
	/**
	 * Método usado para obter o valor do enum.
	 * @return String o valor do enum escolhido
	 */
	public String toString(){
		return this.descricao;
	}
	
	/**
	 * Método usado para obter um enum a partir do seu valor.
	 * @param descricao o valor do enum
	 * @return OpcoesMenu o enum correspondente ao valor passado
	 */
	public static OpcaoController getEnumByString(String descricao){
		for(OpcaoController op: OpcaoController.values()){
			if(descricao.equals(op.toString())){
				return op;
			}
		}
		return OpcaoController.OPCAO_INVALIDA;
		
	}

}
