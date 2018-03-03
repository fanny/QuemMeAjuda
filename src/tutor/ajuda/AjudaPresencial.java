package tutor.ajuda;

import tutor.HorarioAtendimento;

/**
 * Classe que representa uma ajuda presencial.
 * 
 * @author Marcus Vinícius
 */
public class AjudaPresencial extends Ajuda {

	/**
	 * Horário de atendimento da ajuda.
	 */
	private HorarioAtendimento horario;

	/**
	 * Local em que será dada a ajuda.
	 */
	private String local;

	/**
	 * Construtor da classe.
	 * 
	 * @param id
	 *            identificador da ajuda
	 * @param disciplina
	 *            disciplina tema da ajuda
	 * @param tutorMatricula
	 *            matricula do tutor que realizará a ajuda
	 * @param horario
	 *            horario em que será dada a ajuda
	 * @param dia
	 *            dia em que será dada a ajuda
	 * @param local
	 *            local em que será dada a ajuda
	 */
	public AjudaPresencial(Integer id, String disciplina, String tutorMatricula, String horario, String dia,
			String local) {

		this.id = id;
		this.disciplina = disciplina;
		this.tutorMatricula = tutorMatricula;
		this.horario = new HorarioAtendimento(dia, horario);
		this.local = local;

	}
}
