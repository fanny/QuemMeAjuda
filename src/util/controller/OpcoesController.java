package util.controller;

public enum OpcoesController {
	NOME("Nome"),
	EMAIL("Email"),
	TELEFONE("Telefone"),
	OPCAO_INVALIDA("Opção inválida");
	
	private String descricao;
	
	/**
	 * Inicializa os valores de cada enum
	 * @param descricao o valor do enum
	 */
	private OpcoesController(String descricao){
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
	public static OpcoesController getEnumByString(String descricao){
		for(OpcoesController op: OpcoesController.values()){
			if(descricao.equals(op.toString())){
				return op;
			}
		}
		return OpcoesController.OPCAO_INVALIDA;
		
	}

}
