package util.tutor;

public enum TaxaDoacaoValores {

	TOP_TAXA_DOACAO(0.9),
	TUTOR_TAXA_DOACAO(0.8),
	APRENDIZ_TAXA_DOACAO(0.4);
	
	private double valor;
	
	private TaxaDoacaoValores(double valor) {
		
		this.valor = valor;
	}

	public double getValor() {
		return this.valor;
	}
}
