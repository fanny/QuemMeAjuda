package util;

/**
 * Classe responsável por validar as informações de um tutor
 * @author fanny
 *
 */
public class TutorValidador {
	
	/**
	 * Verifica se todas as informações do tutor são válidas
	 * 
	 * @param disciplina
	 *            a disciplina do tutor
	 * @param proficiencia
	 *            a proficiencia do tutor
	 * @return true caso todas as informações do tutor sejam válidas, false caso
	 *         contrário
	 */
	public static boolean validaTutor(String disciplina, int proficiencia){
		return validaDisciplina(disciplina) &&
				validaProficiencia(proficiencia);
	}
	
	/**
	 * @see Validador#validaTexto(String)
	 */
	public static boolean validaDisciplina(String disciplina){
		return Validador.validaTexto(disciplina, ErroTutor.DISCIPLINA_JA_EXISTE.toString());
	}
	
	public static boolean validaLocalAtendimento(String local){
		return Validador.validaTexto(local, ErroTutor.LOCAL_INVALIDO.toString());
	}
	
	public static boolean validaHorarioDeAtendimento(String horario, String dia){
		return validaHorario(horario) && validaDia(dia);
	}
	
	public static boolean validaHorario(String horario){
		if (Validador.validaTexto(horario, ErroTutor.HORARIO_ATENDIMENTO_INVALIDO.toString())) {
			String formaHorario = "^([0-9]{2}:[0-9]{2})$";
			
			if (!horario.matches(formaHorario)) {
				throw new IllegalArgumentException(ErroTutor.HORARIO_ATENDIMENTO_INVALIDO.toString());
			}
		}
		return true;
	}
	public static boolean validaDia(String dia){
		return Validador.validaTexto(dia, ErroTutor.DIA_ATENDIMENTO_INVALIDO.toString());
	}
	
	/**
	 * Verifica se a proficiencia está na faixa de valor correta (maior que 0 e
	 * menor que 6)
	 * 
	 * @param proficiencia
	 *            o nível de conhecimento do tutor na disciplina
	 * @exception IllegalArgumentException
	 *                caso não seja a faixa de valor correta
	 */
	public static boolean validaProficiencia(int proficiencia) {
		return Validador.validaMaiorQueZero(proficiencia, 
				ErroTutor.PROFICIENCIA_INVALIDA.toString()) && Validador.validaMenorQue6(proficiencia, ErroTutor.PROFICIENCIA_INVALIDA.toString());
	}
}
