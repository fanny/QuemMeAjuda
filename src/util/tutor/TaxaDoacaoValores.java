package util.tutor;

public enum TaxaDoacaoValores {

	TOP_TAXA_DOACAO(90),
	TUTOR_TAXA_DOACAO(80),
	APRENDIZ_TAXA_DOACAO(40);
	
	private int valor;
	
	private TaxaDoacaoValores(int valor) {
		
		this.valor = valor;
	}

	public int getValor() {
		return this.valor;
	}
}
