package tutor;

import java.util.HashMap;
import java.util.Map;

import aluno.Aluno;

/**
 * Controller dos tutores do sistema.
 * 
 * @author Marcus Vinicius
 */
public class TutorController {

	/**
	 * Conjunto de tutores que o sistema possui. Possui como chave o email do tutor,
	 * e como chave o objeto do tutor.
	 */
	private Map<String, Tutor> tutores;

	/**
	 * Construtor da classe.
	 */
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
	}

	/**
	 * Cadastra um novo tutor no sistema.
	 * 
	 * @param disciplina
	 *            Disciplina que ele dara tutoria
	 * @param proficiencia
	 *            Proficiencia na disciplina que ele dara tutoria
	 * @param aluno
	 *            Aluno que sera um tutor
	 */
	public void cadastraTutor(String disciplina, int proficiencia, Aluno aluno) {

		Tutor tutor = new Tutor(disciplina, proficiencia, aluno);
		this.tutores.put(aluno.getEmail(), tutor);

	}

	/**
	 * Lista os tutores cadastrados no sistema
	 * 
	 * @return String uma representação textual dos tutores cadastrados no sistema.
	 */
	public String listarTutores() {
		String resultado = "";

		for (Tutor tutor : this.tutores.values()) {
			resultado += tutor.toString() + System.lineSeparator();
		}

		return resultado;
	}

	/**
	 * Adiciona uma disciplina e sua proficiencia ao tutor.
	 * 
	 * @param email
	 *            Email do tutor
	 * @param disciplina
	 *            Disciplina que ele dara tutoria
	 * @param proficiencia
	 *            Proficiencia na disciplina que ele dara tutoria
	 */
	public void cadastraDisciplina(String email, String disciplina, int proficiencia) {

		this.tutores.get(email).addDisciplina(disciplina, proficiencia);
	}

	/**
	 * Cadastra um novo horario de atendimento para um tutor.
	 * 
	 * @param email
	 *            Email do tutor
	 * @param horario
	 *            Horario do atendimento
	 * @param dia
	 *            Dia do atendimento
	 */
	public void cadastrarHorario(String email, String horario, String dia) {

		this.tutores.get(email).cadastrarHorario(horario, dia);

	}

	/**
	 * Cadastra um novo local de atendimento para um tutor.
	 * 
	 * @param email
	 *            Email to tutor
	 * @param local
	 *            Local do atendimento
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {

		this.tutores.get(email).cadastrarLocal(local);

	}

	/**
	 * Consulta se um tutor possui um determinado horario de atendimento.
	 * 
	 * @param horario
	 *            Horario de atendimento
	 * @param dia
	 *            Dia de atendimento
	 * @return um <code>boolean</boolean> que informa se o tutor possui ou nao o
	 *         horario de atendimento
	 */
	public boolean consultaHorario(String email, String horario, String dia) {

		return this.tutores.get(email).consultaHorario(horario, dia);

	}

	/**
	 * Consulta se um tutor possui um determinado local de atendimento.
	 * 
	 * @param local
	 *            Local de atendimento
	 * @return um <code>boolean</boolean> que informa se o tutor possui ou nao o
	 *         local de atendimento
	 */
	public boolean consultaLocal(String email, String local) {

		return this.tutores.get(email).consultaLocal(local);

	}

	/**
	 * Veririca pelo email se um tutor esta cadastradado
	 * 
	 * @param email
	 *            Email do aluno
	 * @return um <code>boolean</code> que informa se o tutor esta cadastrado
	 */
	public boolean existeTutor(String email) {

		return this.tutores.containsKey(email);

	}

	/**
	 * Recupera um tutor pelo seu email.
	 * 
	 * @param email
	 *            Email do tutor
	 * @return uma <code>String</code> que representa o tutor
	 */
	public String recuperaTutor(String email) {

		return this.tutores.get(email).toString();

	}

}
