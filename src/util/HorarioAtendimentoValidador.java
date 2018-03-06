package util;

public class HorarioAtendimentoValidador {

	/**
	 * Verifica se o dia ou o horário é vazio ou nulo
	 * 
	 * @param dia o dia a ser verificado
	 * @param horario o horário a ser verificado
	 */
	public static boolean validaHorarioAtedendimento(String dia, String horario) {
		
		return Validador.validaTexto(dia, "Erro no cadastrar horario: dia nao pode ser vazio ou em branco") && 
				Validador.validaTexto(horario, "Erro no cadastrar horario: horario nao pode ser vazio ou em branco");
	}
}
