package tutor.ajuda;

import tutor.Tutor;

/**
 * Classe que representa uma ajuda.
 * 
 * @author Marcus Vinícius de Farias Barbosa
 */
public abstract class Ajuda {

	/**
	 * Identificador da ajuda.
	 */
	protected Integer id;

	/**
	 * Disciplina tema da ajuda.
	 */
	protected String disciplina;

	/**
	 * Matricula do tutor que realizará a ajuda.
	 */
	protected Tutor tutor;

	public Integer getId() {
		return this.id;
	}

	public String getDisciplina() {
		return this.disciplina;
	}

	public Tutor getTutor() {
		return this.tutor;
	}
}