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
				"acceptance_test/us1_test.txt",
				"acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt"};
		EasyAccept.main(args);
	}
}