package util;

/**
 * Classe responsável por validar as informações de um tutor
 * @author fanny
 *
 */
public class TutorValidador {

	
	public static boolean validaTutor(String disciplina, int proficiencia){
		return validaDisciplina(disciplina) 
				&& validaProficiencia(proficiencia);
	}
	
	
	/**
	 * @see Validador#validaTexto(String)
	 */
	public static boolean validaDisciplina(String disciplina){
		return Validador.validaTexto(disciplina);
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
		if (!Validador.validaMaiorQueZero(proficiencia) || !Validador.validaMenorQue6(proficiencia)) {
			throw new IllegalArgumentException();
		}
		return true;
	}
}
