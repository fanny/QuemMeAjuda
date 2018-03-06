package tutor.ajuda;

import tutor.Tutor;
import util.ajuda.AjudaValidator;

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
	
	/**
	 * Construtor da classe.
	 * 
	 * @param id
	 *            identificador da ajuda
	 * @param disciplina
	 *            disciplina tema da ajuda
	 * @param tutor
	 *            o tutor que realizará a ajuda
	 */
	public Ajuda(int id, String disciplina, Tutor tutor){
		if(AjudaValidator.validaIdAjuda(id) &&
				AjudaValidator.validaDisciplina(disciplina) && 
				AjudaValidator.validaTutor(tutor)){
			
			this.id = id;
			this.disciplina = disciplina;
			this.tutor = tutor;
		
		}
		
	}

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