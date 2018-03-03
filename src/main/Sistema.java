package main;

import tutor.AjudaController;
import tutor.Tutor;
import tutor.TutorController;

import util.aluno.ErroAluno;
import util.controller.ErroController;
import util.controller.OpcoesController;

import java.util.List;
import java.util.NoSuchElementException;

import aluno.Aluno;
import aluno.AlunoController;

/**
 * Classe controller do sistema.
 * 
 * @author Marcus Vinicius
 */
public class Sistema {

	private TutorController tutorController;
	private AlunoController alunoController;
	private AjudaController ajudaController;

	public Sistema() {
		this.tutorController = new TutorController();
		this.alunoController = new AlunoController();
		this.ajudaController = new AjudaController();
	}

	/**
	 * @see AlunoController#cadastrarAluno(String, String, int, String, String)
	 */
	public void cadastrarAluno(String nome, String matricula, int codigoCurso, String telefone, String email) {

		this.alunoController.cadastrarAluno(nome, matricula, codigoCurso, telefone, email);
	}

	/**
	 * Torna um aluno tutor. Caso o aluno não seja um tutor, é criado um novo Tutor
	 * e a referencia do aluno é passada para ele. Caso o aluno já seja um tutor, a
	 * disciplina e a proficiencia na mesma é adicionada as disciplinas que ele já
	 * dá tutoria.
	 * 
	 * @param matricula
	 *            Matricula do aluno
	 * @param disciplina
	 *            Disciplina que ele dara tutoria
	 * @param proficiencia
	 *            Proficiencia na disciplina que ele dara tutoria
	 */
	public void tornarTutor(String matricula, String disciplina, int proficiencia) {

		try {

			this.alunoController.validaAluno(matricula);

		} catch (IllegalArgumentException e) {

			throw new IllegalArgumentException(
					ErroController.TORNA_TUTOR_INVALIDO.toString() + ErroAluno.MATRICULA_INVALIDA.toString());

		} catch (NoSuchElementException e) {

			throw new NoSuchElementException(
					ErroController.TORNA_TUTOR_INVALIDO.toString() + ErroController.TUTOR_NAO_ENCONTRADO.toString());

		}

		String emailTutor = alunoController.getInfoAluno(matricula, OpcoesController.EMAIL.toString());

		try {
			if (tutorController.existeTutor(emailTutor)) {
				tutorController.cadastraDisciplina(emailTutor, disciplina, proficiencia);
			} else {
				Aluno aluno = alunoController.getAlunoPelaMatricula(matricula);
				tutorController.cadastraTutor(disciplina, proficiencia, aluno);
			}
		} catch (NoSuchElementException e) {
			throw new NoSuchElementException(ErroController.TORNA_TUTOR_INVALIDO.toString() + e.getMessage());
		}
	}

	/**
	 * @see AlunoController#listarAlunos()
	 */
	public String listarAlunos() {

		return this.alunoController.listarAlunos();
	}

	/**
	 * @see AlunoController#listarAlunos()
	 */
	public String listarTutores() {

		return this.tutorController.listarTutores();
	}

	/**
	 * @see TutorController#cadastrarHorario(String, String, String)
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		tutorController.cadastrarHorario(email, horario, dia);
	}

	/**
	 * @see TutorController#cadastrarLocalDeAtendimento(String, String)
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		tutorController.cadastrarLocalDeAtendimento(email, local);
	}

	/**
	 * @see TutorController#consultaHorario(String, String, String)
	 */
	public boolean consultaHorario(String email, String horario, String dia) {

		return this.tutorController.consultaHorario(email, horario, dia);

	}

	/**
	 * @see TutorController#consultaLocal(String, String)
	 */
	public boolean consultaLocal(String email, String local) {

		return this.tutorController.consultaLocal(email, local);

	}

	/**
	 * @see TutorController#recuperaTutor(String)
	 */
	public String recuperaTutor(String matricula) {

		try {

			this.alunoController.validaAluno(matricula);

		} catch (IllegalArgumentException e) {

			throw new IllegalArgumentException(
					ErroController.BUSCA_TUTOR_INVALIDA.toString() + ErroAluno.MATRICULA_INVALIDA.toString());

		} catch (NoSuchElementException e) {

			throw new NoSuchElementException(
					ErroController.BUSCA_TUTOR_INVALIDA.toString() + ErroController.TUTOR_NAO_ENCONTRADO.toString());

		}

		String emailTutor = alunoController.getInfoAluno(matricula, OpcoesController.EMAIL.toString());
		String resultado = tutorController.recuperaTutor(emailTutor);

		return resultado;
	}

	/**
	 * @see AlunoController#recuperaAluno(String)
	 */
	public String recuperaAluno(String matricula) {

		return alunoController.recuperaAluno(matricula);
	}

	/**
	 * @see AlunoController#getInfoAluno(String, String)
	 */
	public String getInfoAluno(String matricula, String atributo) {

		return alunoController.getInfoAluno(matricula, atributo);
	}

	/**
	 * 
	 * @param idAjuda
	 * @param nota
	 * @return
	 */
	public String avaliaTutor(int idAjuda, int nota) {
		return "";
	}

	/**
	 * @see TutorController#retornaNotaAvaliacao(String)
	 */
	public double pegaNota(String matriculaTutor) {
		return tutorController.retornaNotaAvaliacao(getInfoAluno(matriculaTutor, "email"));
	}

	/**
	 * @see TutorController#retornaNivel(String)
	 */
	public String pegaNivel(String matriculaTutor) {
		return tutorController.retornaNivel(getInfoAluno(matriculaTutor, "email"));
	}

	/**
	 * TERMINAR
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {
		
		this.tutorController.recuperaTutorParaAjuda(disciplina, horario, dia, localInteresse);

		return 1;
	}

	/**
	 * TERMINAR
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {
		this.ajudaController.cadastraAjudaOnline(matrAluno, disciplina);
		return 1;
	}

	/**
	 * Recupera o tutor de uma ajuda.
	 * 
	 * @param idAjuda
	 *            identificador da ajuda
	 * @return uma <code>string</code> que representa a matricula do tutor
	 */
	public String pegarTutor(int idAjuda) {
		return this.ajudaController.pegarTutor(idAjuda);
	}

	/**
	 * TERMINAR
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.ajudaController.getInfoAjuda(idAjuda, atributo);
	}

}
