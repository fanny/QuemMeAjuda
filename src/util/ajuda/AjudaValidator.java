package util.ajuda;

import util.Validador;
import util.tutor.MensagemTutor;

public class AjudaValidator {

	/**
	 * Valida as informações de um pedido de ajuda presencial.
	 * 
	 * @param disciplina
	 *            nome da disciplina
	 * @param horario
	 *            descrição do horario
	 * @param dia
	 *            nome do dia
	 * @param local
	 *            nome do local
	 * @return um <code>boolean</code> que informa se o pedido de ajuda presencial é
	 *         valido ou não
	 */
	public static boolean validaAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String local) {
		return (validaMatriculaAluno(matrAluno) && validaDisciplina(disciplina)
				&& validaHorarioDeAtendimento(horario, dia) && validaLocal(local));

	}

	/**
	 * Valida as informações de um pedido de ajuda online.
	 * 
	 * @param disciplina
	 *            nome da disciplina
	 * @return um <code>boolean</code> que informa se o pedido de ajuda online é
	 *         valido ou não
	 */
	public static boolean validaAjudaOnline(String matrAluno, String disciplina) {
		return (validaMatriculaAluno(matrAluno) && validaDisciplina(disciplina));
	}

	/**
	 * Valida uma disciplina passada.
	 * 
	 * @param disciplina
	 *            nome da disciplina
	 * @return um <code>boolean</code> que informa se a disciplina é valida ou não
	 */
	public static boolean validaDisciplina(String disciplina) {
		return Validador.validaTexto(disciplina, MensagemAjuda.DISCIPLINA_INVALIDA.toString());
	}

	/**
	 * Valida um local.
	 * 
	 * @param local
	 *            nome do local
	 * @return um <code>boolean</code> que informa se o local é válido ou não
	 */
	public static boolean validaLocal(String local) {
		return Validador.validaTexto(local, MensagemAjuda.LOCAL_INVALIDO.toString());
	}

	/**
	 * Valida um horario e um dia.
	 * 
	 * @param horario
	 *            descricao do horario
	 * @param dia
	 *            nome do dia
	 * @return um <code>boolean</code> que informa se o horario e dia são validos ou
	 *         não
	 */
	public static boolean validaHorarioDeAtendimento(String horario, String dia) {
		return validaHorario(horario) && validaDia(dia);
	}

	/**
	 * Valida um horario.
	 * 
	 * @param horario
	 *            descricao do horario
	 * @return um <code>boolean</code> que informa se o horario é valido ou não
	 */
	public static boolean validaHorario(String horario) {
		if (Validador.validaTexto(horario, MensagemAjuda.HORARIO_ATENDIMENTO_INVALIDO.toString())) {
			String formaHorario = "^([0-9]{2}:[0-9]{2})$";

			if (!horario.matches(formaHorario)) {
				throw new IllegalArgumentException(MensagemAjuda.HORARIO_ATENDIMENTO_INVALIDO.toString());
			}
		}
		return true;
	}

	/**
	 * Valida um dia.
	 * 
	 * @param dia
	 *            nome do dia
	 * @return um <code>boolean</code> que informa se o dia é valido ou não
	 */
	public static boolean validaDia(String dia) {
		return Validador.validaTexto(dia, MensagemAjuda.DIA_ATENDIMENTO_INVALIDO.toString());
	}

	public static boolean validaMatriculaAluno(String matricula) {
		return Validador.validaTexto(matricula, MensagemAjuda.MATRICULA_ALUNO_INVALIDA.toString());
	}
	
	public static boolean validaIdAjuda(int idAjuda) {
		return Validador.validaMenorQueZero(idAjuda, MensagemAjuda.ID_INVALIDO.toString());
	}
	
	public static boolean validaAtributo(String atributo) {
		return Validador.validaTexto(atributo, MensagemAjuda.ATRIBUTO_INVALIDO.toString());
	}
}
