package util;

public class HorarioAtendimentoValidador {

	public static boolean validaHorarioAtedendimento(String dia, String horario) {
		
		return Validador.validaTexto(dia, "Erro no cadastrar horario: dia nao pode ser vazio ou em branco") && 
				Validador.validaTexto(horario, "Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
	}
}
