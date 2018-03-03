package tutor.ajuda;

/**
 * Classe que representa uma ajuda online.
 * 
 * @author Marcus Vinicius
 */
public class AjudaOnline extends Ajuda {

	/**
	 * Construtor da classe.
	 * 
	 * @param id
	 *            identificador da ajuda
	 * @param disciplina
	 *            disciplina tema da ajuda
	 * @param tutorMatricula
	 *            matricula do tutor que realizará a ajuda
	 */
	public AjudaOnline(Integer id, String disciplina, String tutorMatricula) {

		this.id = id;
		this.disciplina = disciplina;
		this.tutorMatricula = tutorMatricula;

	}
}
