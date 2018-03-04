package testes;

import easyaccept.EasyAccept;

/**
 * Classe que executa os testes de aceitação do cliente.
 * 
 * @author Marcus Vinícius
 *
 */
public class SistemaTestClient {
	
	/**
	 * Método que executa os scripts de testes de aceitação.
	 * 
	 * @param args Argumentos recebidos pelo método.
	 */
	public static void main(String[] args) {
		args  = new String[] {"main.Facade", 
				"resources/acceptance_test/us1_test.txt",
				"resources/acceptance_test/us2_test.txt",
				"resources/acceptance_test/us3_test.txt",
				"resources/acceptance_test/us4_test.txt",
				"resources/acceptance_test/us5_test.txt"};
		EasyAccept.main(args);
	}
}