package tutor.ajuda;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import tutor.Tutor;
import util.ajuda.AjudaValidator;
import util.ajuda.MensagemAjuda;
import util.aluno.AlunoValidador;
import util.aluno.MensagemAluno;
import util.controller.ErroController;
import util.controller.OpcoesController;

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

		try {

			int id = ajudas.size() + 1;

			AjudaPresencial ajudaPresencial = new AjudaPresencial(id, disciplina, tutor, horario, dia, local);
			this.ajudas.put(id, ajudaPresencial);

			return id;

		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					ErroController.PEDIDO_DE_AJUDA_PRESENCIAL_INVALIDA.toString() + e.getMessage());
		}

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

		try {

			int id = ajudas.size() + 1;

			AjudaOnline ajudaOnline = new AjudaOnline(id, disciplina, tutor);

			this.ajudas.put(id, ajudaOnline);

			return id;

		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					ErroController.PEDIDO_DE_AJUDA_ONLINE_INVALIDA.toString() + e.getMessage());
		}

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

		try {

			if (this.validaAjuda(idAjuda) && this.validaAtributo(atributo)) {

				OpcoesController op = OpcoesController.getEnumByString(atributo);

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
					throw new IllegalArgumentException("atributo nao encontrado");
				}
			}

		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErroController.GET_INFO_AJUDA_INVALIDA.toString() + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(ErroController.GET_INFO_AJUDA_INVALIDA.toString() + e.getMessage());
		}

		return "";

	}

	/**
	 * Retorna a matricula de um tutor de uma ajuda.
	 * 
	 * @param idAjuda
	 *            identificador da ajuda
	 * @return uma <code>string</code> que representa a matricula do tutor
	 */
	public String pegarMatriculaTutor(int idAjuda) {
		return this.ajudas.get(idAjuda).getTutor().getMatricula();
	}

	/**
	 * Verifica se uma ajuda existe.
	 * 
	 * @param idAjuda
	 *            identificador da ajuda
	 * @return um <code>boolean</code> que informa se a ajuda existe ou nao
	 */
	public boolean existeAjuda(int idAjuda) {
		return this.ajudas.containsKey(idAjuda);
	}

	/**
	 * Valida o id de uma ajuda, verificando se existe e se nao é vazio.
	 * 
	 * @param idAjuda
	 *            identificador da ajuda
	 * @return um <code>boolean</code> que informa se a ajuda eh valida ou não
	 */
	public boolean validaAjuda(int idAjuda) {
		if (AjudaValidator.validaIdAjuda(idAjuda)) {
			if (!this.existeAjuda(idAjuda)) {
				throw new NoSuchElementException(MensagemAjuda.ID_NAO_ENCONTRADO.toString());
			}
		}
		return true;
	}

	/**
	 * Valida um atributo.
	 * 
	 * @param atributo
	 *            nome do atributo
	 * @return um <code>boolean</code> que informa se o atributo eh valido ou não
	 */
	public boolean validaAtributo(String atributo) {
		if (!AjudaValidator.validaAtributo(atributo)) {
			throw new IllegalArgumentException(MensagemAjuda.ATRIBUTO_INVALIDO.toString());
		}
		return true;
	}
}