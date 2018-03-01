package main;
import easyaccept.EasyAccept;

/**
 * Classe Facade do sistema.
 * 
 * @author Marcus Vinícius
 */
public class Facade {

	private Sistema sistema;
	
	public Facade(){
		this.sistema = new Sistema();
	}

	/**
	 * @see Sistema#cadastrarAluno(String, String, int, String, String)
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {

		this.sistema.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
	 * @see Sistema#tornarTutor(String, String, int)
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {

		this.sistema.tornarTutor(matricula, disciplina, proficiencia);

	}

	/**
	 * @see Sistema#recuperaTutor(String)
	 */
	public String recuperaTutor(String matricula) {
		return sistema.recuperaTutor(matricula);
	}

	/**
	 * @see Sistema#recuperaAluno(String)
	 */
	public String recuperaAluno(String matricula) {
		return sistema.recuperaAluno(matricula);
	}

	/**
	 * @see Sistema#listarAlunos()
	 */
	public String listarAlunos() {

		return sistema.listarAlunos();
	}

	/**
	 * @see Sistema#listarTutores()
	 */
	public String listarTutores() {

		return sistema.listarTutores();

	}

	/**
	 * @see Sistema#cadastrarHorario(String, String, String)
	 */
	public void cadastrarHorario(String email, String horario, String dia) {

		this.sistema.cadastrarHorario(email, horario, dia);

	}

	/**
	 * @see Sistema#cadastrarLocalDeAtendimento(String, String)
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {

		this.sistema.cadastrarLocalDeAtendimento(email, local);

	}

	/**
	 * @see Sistema#consultaHorario(String, String, String)
	 */
	public boolean consultaHorario(String email, String horario, String dia) {

		return this.sistema.consultaHorario(email, horario, dia);

	}

	/**
	 * @see Sistema#consultaLocal(String, String)
	 */
	public boolean consultaLocal(String email, String local) {

		return this.sistema.consultaLocal(email, local);

	}

	/**
	 * @see Sistema#getInfoAluno(String, String)
	 */
	public String getInfoAluno(String matricula, String atributo) {

		return this.sistema.getInfoAluno(matricula, atributo);
	}

	public static void main(String[] args) {
		args = new String[] { "main.Facade", "acceptance_test/us1_test.txt", "acceptance_test/us2_test.txt",
				"acceptance_test/us3_test.txt"};
		EasyAccept.main(args);
	}
}
