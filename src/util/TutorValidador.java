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
		return validaDisciplina(disciplina, ErroTutor.DISCIPLINA_JA_EXISTE.toString()) &&
				validaProficiencia(proficiencia, ErroTutor.PROFICIENCIA_INVALIDA.toString());
	}
	
	/**
	 * @see Validador#validaTexto(String)
	 */
	public static boolean validaDisciplina(String disciplina, String mensagem){
		return Validador.validaTexto(disciplina, mensagem);
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
	public static boolean validaProficiencia(int proficiencia, String mensagem) {
		if (!Validador.validaMaiorQueZero(proficiencia, 
				mensagem) || !Validador.validaMenorQue6(proficiencia, mensagem)) {
			throw new IllegalArgumentException(mensagem);
		}
		return true;
	}
}
