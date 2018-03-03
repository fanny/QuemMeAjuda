package tutor.ajuda;

import java.util.HashMap;
import java.util.Map;

import tutor.Tutor;

/**
 * Controller das ajudas do sistema.
 * 
 * @author Marcus Vinicius
 */
public class AjudaController {

	/**
	 * Map que representa as ajudas cadastradas no sistema. Possui como chave o
	 * identificador da ajuda, e como valor um objeto que representa a ajuda.
	 */
	private Map<Integer, Ajuda> ajudas;

	/**
	 * Construtor da classe.
	 */
	public AjudaController() {
		this.ajudas = new HashMap<>();
	}

	/**
	 * Registra um pedido de ajuda presencial
	 * 
	 * @param tutorMatricula
	 *            matricula do tutor que dará a ajuda
	 * @param disciplina
	 *            disciplina tema da ajuda
	 * @param horario
	 *            horario da ajuda
	 * @param dia
	 *            dia da ajuda
	 * @param local
	 *            local da ajuda
	 * @return um <code>int</code> que representa o identificador da ajuda
	 */
	public int cadastrarAjudaPresencial(Tutor tutor, String disciplina, String horario, String dia, String local) {

		int id = ajudas.size() + 1;

		AjudaPresencial ajudaPresencial = new AjudaPresencial(id, disciplina, tutor, horario, dia, local);

		this.ajudas.put(id, ajudaPresencial);

		return id;
	}

	/**
	 * Registra um pedido de ajuda online.
	 * 
	 * @param matrAluno
	 *            matricula di tutor da ajuda
	 * @param disciplina
	 *            disiciplina tema da ajuda
	 * @return um <code>int</code> que representa o identificador da ajuda.
	 */
	public int cadastraAjudaOnline(Tutor tutor, String disciplina) {

		int id = ajudas.size() + 1;

		AjudaOnline ajudaOnline = new AjudaOnline(id, disciplina, tutor);

		this.ajudas.put(id, ajudaOnline);

		return id;
	}

	/**
	 * Recupera a matricula do tutor de uma determinada ajuda.
	 * 
	 * @param idAjuda
	 *            identificador da ajuda
	 * @return uma <code>String</code> que representa a matricula do tutor
	 */
	public String pegarTutor(int idAjuda) {

		return this.ajudas.get(idAjuda).toString();
	}

	/**
	 * Recupera um determinado atributo de uma ajuda.
	 * 
	 * @param idAjuda
	 *            identificador da ajuda
	 * @param atributo
	 *            atributo que se deseja capturar
	 * @return uma <code>string</code> que representa um atributo
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {

		switch (atributo) {
		case "localInteresse": {
			AjudaPresencial ajuda = (AjudaPresencial) this.ajudas.get(idAjuda);
			return ajuda.getLocal();
		}
		case "horario": {
			AjudaPresencial ajuda = (AjudaPresencial) this.ajudas.get(idAjuda);
			return ajuda.getHorario().getHorario();
		}
		case "dia": {
			AjudaPresencial ajuda = (AjudaPresencial) this.ajudas.get(idAjuda);
			return ajuda.getHorario().getDia();
		}
		case "disciplina":
			return this.ajudas.get(idAjuda).getDisciplina();
		case "tutorMatricula":
			return this.pegarTutor(idAjuda);
		default:
			return null;
		}

	}
}