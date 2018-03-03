package tutor;

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
	protected String tutorMatricula;
	
	public Integer getId() {
		return this.id;
	}
	
	public String getDisciplina() {
		return this.disciplina;
	}
	
	public String getTutorMatricula() {
		return this.tutorMatricula;
	}
}
