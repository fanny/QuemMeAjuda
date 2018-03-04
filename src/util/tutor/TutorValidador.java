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
	 * 
	 * @param aluno
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
	 * 
	 * @param local
	 * @return
	 */
	public static boolean validaLocalAtendimento(String local) {
		return Validador.validaTexto(local, MensagemTutor.LOCAL_INVALIDO.toString());
	}

	/**
	 * 
	 * @param horario
	 * @param dia
	 * @return
	 */
	public static boolean validaHorarioDeAtendimento(String horario, String dia) {
		return validaHorario(horario) && validaDia(dia);
	}

	/**
	 * 
	 * @param horario
	 * @return
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
	 * 
	 * @param dia
	 * @return
	 */
	public static boolean validaDia(String dia) {
		return Validador.validaTexto(dia, MensagemTutor.DIA_ATENDIMENTO_INVALIDO.toString());
	}

	/**
	 * 
	 * @param email
	 * @return
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

	public static boolean validaNotaAvaliacao(int notaAvaliacao) {
		return Validador.validaMaiorOuIgualAZero(notaAvaliacao,
				MensagemTutor.NOTA_NAO_PODE_SER_MENOR_QUE_ZERO.toString())
				&& Validador.validaMenorQueCinco(notaAvaliacao,
						MensagemTutor.NOTA_NAO_PODE_SER_MAIOR_QUE_CINCO.toString());
	}
}
