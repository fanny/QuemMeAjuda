package tutor.ajuda;

import tutor.HorarioAtendimento;
import tutor.Tutor;
import util.tutor.TutorValidador;

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
	public AjudaPresencial(Integer id, String disciplina, Tutor tutor, String horario, String dia, String local) {
		super(id, disciplina, tutor);
		if(TutorValidador.validaHorarioDeAtendimento(horario, dia) && 
				TutorValidador.validaLocalAtendimento(local)){
			
			this.horario = new HorarioAtendimento(dia, horario);
			this.local = local;
			
		}

	}

	public String getLocal() {

		return this.local;
	}

	public HorarioAtendimento getHorario() {

		return this.horario;
	}

	@Override
	public String toString() {

		String result = "Tutor - " + this.tutor.getMatricula() + ", horario - " + this.horario.getHorario() + ", dia - "
				+ this.horario.getDia() + ", local - " + this.local + ", disciplina - " + this.disciplina;

		return result;
	}
}