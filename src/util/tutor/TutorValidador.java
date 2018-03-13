package util.tutor;

import aluno.Aluno;
import util.Validador;
import util.aluno.AlunoValidador;

/**
 * Classe responsável por validar as informações de um tutor
 * 
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
	public static boolean validaTutor(String disciplina, int proficiencia, Aluno aluno) {
		return validaDisciplina(disciplina) && validaProficiencia(proficiencia) && validaAluno(aluno);
	}

	/**
	 * Verifica se o aluno é válido
	 * 
	 * @param aluno o aluno a ser avaliado
	 * @return
	 */
	public static boolean validaAluno(Aluno aluno) {
		if (aluno == null) {
			throw new NullPointerException(MensagemTutor.ALUNO_INVALIDO.toString());
		}
		return AlunoValidador.validaAluno(aluno.getNome(), aluno.getMatricula(), aluno.getTelefone(), aluno.getEmail(),
				aluno.getCodCurso());
	}

	/**
	 * @see Validador#validaTexto(String)
	 */
	public static boolean validaDisciplina(String disciplina) {
		return Validador.validaTexto(disciplina, MensagemTutor.DISCIPLINA_JA_EXISTE.toString());
	}

	/**
	 * @see Validador#validaTexto(String, String)
	 */
	public static boolean validaLocalAtendimento(String local) {
		return Validador.validaTexto(local, MensagemTutor.LOCAL_INVALIDO.toString());
	}

	/**
	 * Verifica se o horario e o dia são válidos
	 * 
	 * @param horario o horario a ser verificado
	 * @param dia o dia a ser verificado
	 */
	public static boolean validaHorarioDeAtendimento(String horario, String dia) {
		return validaHorario(horario) && validaDia(dia);
	}

	/**
	 * Verifica se o horario é válido
	 * 
	 * @param horario o horario a ser verificado
	 */
	public static boolean validaHorario(String horario) {
		if (Validador.validaTexto(horario, MensagemTutor.HORARIO_ATENDIMENTO_INVALIDO.toString())) {
			String formaHorario = "^([0-9]{2}:[0-9]{2})$";

			if (!horario.matches(formaHorario)) {
				throw new IllegalArgumentException(MensagemTutor.HORARIO_ATENDIMENTO_INVALIDO.toString());
			}
		}
		return true;
	}

	/**
	 * @see Validador#validaTexto(String, String)
	 */
	public static boolean validaDia(String dia) {
		return Validador.validaTexto(dia, MensagemTutor.DIA_ATENDIMENTO_INVALIDO.toString());
	}

	/**
	 * @see Validador#validaEmail(String, String)
	 */
	public static boolean validaEmail(String email) {
		return Validador.validaEmail(email, MensagemTutor.EMAIL_INVALIDO.toString());
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
		return Validador.validaMaiorIgualZero(proficiencia, MensagemTutor.PROFICIENCIA_INVALIDA.toString())
				&& Validador.validaMenorQue6(proficiencia, MensagemTutor.PROFICIENCIA_INVALIDA.toString());
	}

	/**
	 * Verifica se a nota é maior ou igual a zero e menor ou igual a cinco
	 * 
	 * @param notaAvaliacao a nota a ser avaliada
	 */
	public static boolean validaNotaAvaliacao(int notaAvaliacao) {
		return Validador.validaMaiorOuIgualAZero(notaAvaliacao,
				MensagemTutor.NOTA_NAO_PODE_SER_MENOR_QUE_ZERO.toString())
				&& Validador.validaMenorQueCinco(notaAvaliacao,
						MensagemTutor.NOTA_NAO_PODE_SER_MAIOR_QUE_CINCO.toString());
	}

	/**
	 * Método que avalia se uma doação a um tutor apresenta valor menor que zero
	 * lançando um IllegalArgumentException caso seja
	 * 
	 * @param totalCentavos	valor a ser doado
	 */
	public static boolean validaDoacao(int totalCentavos) {
		
		return Validador.validaMaiorIgualZero(totalCentavos, MensagemTutor.DOACAO_MENOR_QUE_ZERO.toString());
	}
}