package tutor.ajuda;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.StringJoiner;

import persistencia.Persistencia;
import tutor.Tutor;
import util.ajuda.AjudaValidator;
import util.ajuda.MensagemAjuda;
import util.controller.ErroController;
import util.controller.OpcaoController;

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
	 * 
	 */
	private Set<Integer> ajudasAvaliadas;
	
	private Persistencia persistencia;

	/**
	 * Construtor da classe.
	 */
	public AjudaController() {
		this.ajudas = new HashMap<>();
		ajudasAvaliadas = new HashSet<>();
		this.persistencia = new Persistencia();
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
	 * Recupera as informações de um tutor de uma determinada ajuda.
	 * 
	 * @param idAjuda
	 *            identificador da ajuda
	 * @return uma <code>String</code> que representa as informações do tutor de uma
	 *         ajuda
	 */
	public String pegarTutor(int idAjuda) {

		try {

			if (this.validaAjuda(idAjuda)) {

				return this.ajudas.get(idAjuda).toString();

			}

		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErroController.PEGAR_TUTOR_INVALIDO.toString() + e.getMessage());
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(ErroController.PEGAR_TUTOR_INVALIDO.toString() + e.getMessage());
		}

		return "";
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

				OpcaoController op = OpcaoController.getEnumByString(atributo);

				switch (op) {
					case LOCAL_INTERESSE: {
						AjudaPresencial ajuda = (AjudaPresencial) this.ajudas.get(idAjuda);
						return ajuda.getLocal();
					}
					case HORARIO: {
						AjudaPresencial ajuda = (AjudaPresencial) this.ajudas.get(idAjuda);
						return ajuda.getHorario().getHorario();
					}
					case DIA: {
						AjudaPresencial ajuda = (AjudaPresencial) this.ajudas.get(idAjuda);
						return ajuda.getHorario().getDia();
					}
					case DISCIPLINA:
						return this.ajudas.get(idAjuda).getDisciplina();
					case TUTOR_MATRICULA:
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
	
	public void setAjudasAvaliadas(int idAjuda) {
		if(ajudasAvaliadas.contains(idAjuda)) {
			throw new IllegalArgumentException(MensagemAjuda.AJUDA_JA_AVALIADA.toString());
		}
		
		this.ajudasAvaliadas.add(idAjuda);
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
	
	
	/**
	 * Lista todas as ajudas cadastradas no sistema, 
	 * separadas por vírgula
	 * @return String Uma representação textual de todas as 
	 * ajudas cadastradas no sistema.
	 */
	public String listaAjudas(){

		StringJoiner joiner = new StringJoiner(", ");

		for (Ajuda ajuda: this.ajudas.values()) {
			joiner.add(ajuda.toString());
		}

		return joiner.toString();
	}
	
	/**
	 * @see Persistencia#salvaAjudas(String)
	 */
	public void salvaAjudas() throws IOException{
		this.persistencia.salvaAjudas(this.listaAjudas());
	}
	
	/**
	 * @see Persistencia#limparAjudas()
	 */
	public void limpar(){
		this.ajudas.clear();
		this.ajudasAvaliadas.clear();
		this.persistencia.limparAjudas();
	}
	
	/**
	 * @see Persistencia#carregaAjudas()
	 */
	public String carregaAjudas() throws IOException{
		return this.persistencia.carregaAjudas();
	}
	
	
	
	
}