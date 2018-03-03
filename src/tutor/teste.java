package tutor;

import aluno.Aluno;
import main.Sistema;

/**
 * MINHA CLASSE PRA TESTAR SE AS COISAS ESTÃO FUNCIONANDO
 * N APAGUEM <3
 * @author Marcus Vinicius
 *
 */
public class teste {

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();
				
		sistema.cadastrarAluno("rayla", "1234519", 5, "9883-3456", "VelhaDosGatos@hotmail.com");
		sistema.tornarTutor("1234519", "Poo", 5);
		
		sistema.cadastrarAluno("fanny", "655484", 2, "1234-9282", "fannyHistory@hotmail.com");
		sistema.tornarTutor("655484", "discreta", 3);
		
		sistema.cadastrarHorario("VelhaDosGatos@hotmail.com", "13:00", "Segunda");
		sistema.cadastrarLocalDeAtendimento("VelhaDosGatos@hotmail.com", "Escola");
		
		sistema.pedirAjudaPresencial("655484", "Poo", "13:00", "Segunda", "Escola");
	}

}