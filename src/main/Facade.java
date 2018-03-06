package main;

import easyaccept.EasyAccept;

/**
 * Classe Facade do sistema.
 * 
 * @author Marcus Vinícius
 */
public class Facade {

	private Sistema sistema;

	public Facade() {
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

	/**
	 * @see Sistema#avaliaTutor(int, int)
	 */
	public String avaliarTutor(int idAjuda, int nota) {
		return sistema.avaliaTutor(idAjuda, nota);
	}

	/**
	 * @see Sistema#pegaNota(String)
	 */
	public double pegarNota(String matriculaTutor) {
		return sistema.pegaNota(matriculaTutor);
	}

	/**
	 * @see Sistema#pegaNivel(String)
	 */
	public String pegarNivel(String matriculaTutor) {
		return sistema.pegaNivel(matriculaTutor);
	}

	/**
	 * @see Sistema#pedirAjudaPresencial(String, String, String, String, String)
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		return sistema.pedirAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse);
	}

	/**
	 * @see Sistema#pedirAjudaOnline(String, String)
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		return sistema.pedirAjudaOnline(matrAluno, disciplina);
	}

	/**
	 * @see Sistema#pegarTutor(int)
	 */
	public String pegarTutor(int idAjuda) {
		return sistema.pegarTutor(idAjuda);
	}

	/**
	 * @see Sistema#getInfoAjuda(int, String)
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return sistema.getInfoAjuda(idAjuda, atributo);
	}
	
	/**
	 * @see Sistema#doar(String, int)
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		sistema.doar(matriculaTutor, totalCentavos);
	}
	
	/**
	 * @see Sistema#totalDinheiroTutor(String)
	 */
	public int totalDinheiroTutor(String emailTutor) {
		return sistema.totalDinheiroTutor(emailTutor);
	}

	public int totalDinheiroSistema() {
		return sistema.totalDinheiroSistema();
	}
}