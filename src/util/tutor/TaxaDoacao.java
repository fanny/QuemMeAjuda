package util.tutor;

/**
 * Representação dos possíveis valores da taxa de doação do tutor.
 * @author fanny
 *
 */
public enum TaxaDoacao {

	TOP_TAXA_DOACAO(0.90),
	TUTOR_TAXA_DOACAO(0.80),
	APRENDIZ_TAXA_DOACAO(0.40);
	
	private double valor;
	
	/**
	 * Inicializa os valores de cada enum
	 * @param valor o valor do enum
	 */
	private TaxaDoacao(double valor) {
		this.valor = valor;
	}

	/**
	 * Método usado para obter o valor do enum.
	 * @return double o valor que representa a taxa 
	 * do enum escolhido
	 */
	public double getValor() {
		return this.valor;
	}
}
