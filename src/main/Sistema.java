package main;

import tutor.Tutor;
import tutor.TutorController;
import tutor.ajuda.AjudaController;
import util.ajuda.AjudaValidator;
import util.aluno.MensagemAluno;
import util.controller.ErroController;
import util.controller.OpcoesController;
import util.tutor.TutorValidador;

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
	private int doacoes;
	
	/**
	 * Construtor da classe
	 */
	public Sistema() {
		this.tutorController = new TutorController();
		this.alunoController = new AlunoController();
		this.ajudaController = new AjudaController();
		this.doacoes = 0;
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
					ErroController.TORNA_TUTOR_INVALIDO.toString() + MensagemAluno.MATRICULA_INVALIDA.toString());

		} catch (NoSuchElementException e) {

			throw new NoSuchElementException(
					ErroController.TORNA_TUTOR_INVALIDO.toString() + ErroController.TUTOR_NAO_ENCONTRADO.toString());

		}

		String emailTutor = alunoController.getInfoAluno(matricula, OpcoesController.EMAIL.toString());

		if (tutorController.existeTutor(emailTutor)) {
			tutorController.cadastraDisciplina(emailTutor, disciplina, proficiencia);
		} else {
			Aluno aluno = alunoController.getAlunoPelaMatricula(matricula);
			tutorController.cadastraTutor(disciplina, proficiencia, aluno);
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
					ErroController.BUSCA_TUTOR_INVALIDA.toString() + MensagemAluno.MATRICULA_INVALIDA.toString());

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
	 * @see AjudaController#cadastrarAjudaPresencial(String, String, String, String,
	 *      String)
	 */
	public int pedirAjudaPresencial(String matrAluno, String disciplina, String horario, String dia,
			String localInteresse) {

		try {
				Tutor tutor = this.tutorController.recuperaTutorParaAjudaPresencial(disciplina, horario, dia,
						localInteresse);
			if (AjudaValidator.validaAjudaPresencial(matrAluno, disciplina, horario, dia, localInteresse, tutor)) {

				return this.ajudaController.cadastrarAjudaPresencial(tutor, disciplina, horario, dia, localInteresse);
			}
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					ErroController.PEDIDO_DE_AJUDA_PRESENCIAL_INVALIDA.toString() + e.getMessage());
		}

		return 0;

	}

	/**
	 * @see AjudaController#cadastraAjudaOnline(String, String)
	 */
	public int pedirAjudaOnline(String matrAluno, String disciplina) {

		try {
			if (AjudaValidator.validaAjudaOnline(matrAluno, disciplina)) {

				Tutor tutor = this.tutorController.recuperaTutorParaAjudaOnline(disciplina);

				return this.ajudaController.cadastraAjudaOnline(tutor, disciplina);
			}
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(
					ErroController.PEDIDO_DE_AJUDA_ONLINE_INVALIDA.toString() + e.getMessage());
		}

		return 0;

	}

	/**
	 * @see AjudaController#pegarTutor(int)
	 */
	public String pegarTutor(int idAjuda) {

		return this.ajudaController.pegarTutor(idAjuda);
	}

	/**
	 * @see AjudaController#getInfoAjuda(int, String)
	 */
	public String getInfoAjuda(int idAjuda, String atributo) {
		return this.ajudaController.getInfoAjuda(idAjuda, atributo);
	}

	/**
	 * 
	 * @param idAjuda
	 * @param nota
	 * @return
	 */
	public String avaliaTutor(int idAjuda, int nota) {
		try{
			TutorValidador.validaNotaAvaliacao(nota);
			ajudaController.validaAjuda(idAjuda);
			String matriculaTutor = ajudaController.pegarMatriculaTutor(idAjuda);
			String emailTutor = getInfoAluno(matriculaTutor, OpcoesController.EMAIL.toString());
			tutorController.avaliaTutor(emailTutor, nota);
			ajudaController.setAjudasAvaliadas(idAjuda);
		}catch(IllegalArgumentException iae) {
			throw new IllegalArgumentException(
					ErroController.ERRO_AVALIACAO_TUTOR.toString() + iae.getMessage());
		}catch(NoSuchElementException nsee) {
			throw new NoSuchElementException(
					ErroController.ERRO_AVALIACAO_TUTOR.toString() + nsee.getMessage());
		}

		return "";
	}

	/**
	 * @see TutorController#retornaNotaAvaliacao(String)
	 */
	public double pegaNota(String matriculaTutor) {
		return tutorController.retornaNotaAvaliacao(getInfoAluno(matriculaTutor, 
				OpcoesController.EMAIL.toString()));
	}

	/**
	 * @see TutorController#retornaNivel(String)
	 */
	public String pegaNivel(String matriculaTutor) {
		return tutorController.retornaNivel(getInfoAluno(matriculaTutor, OpcoesController.EMAIL.toString()));
	}
	
	/**
	 * Avalia se os atributos são válidos e os repassa para
	 * @param matriculaTutor
	 * @param totalCentavos
	 */
	public void doar(String matriculaTutor, int totalCentavos) {
		
		String emailAluno = "";
		try {
			emailAluno = getInfoAluno(matriculaTutor, OpcoesController.EMAIL.toString());
			tutorController.validaDoacao(totalCentavos);
			
		}catch(IllegalArgumentException e) {
			throw new IllegalArgumentException(ErroController.DOACAO_INVALIDA.toString() + 
												MensagemAluno.MATRICULA_INVALIDA.toString());
		
		}catch(NoSuchElementException e) {
			throw new NoSuchElementException(ErroController.DOACAO_INVALIDA.toString() + 
												ErroController.BUSCA_TUTOR_INVALIDA.toString());
		}
		
		tutorController.doar(emailAluno, totalCentavos - this.calculoDoacao(emailAluno, totalCentavos));
	}

	public int totalDinheiroTutor(String emailTutor) {
		return tutorController.totalDinheiroTutor(emailTutor);
	}

	private int calculoDoacao(String emailTutor, int totalCentavos) {
		
		double taxaTutor = tutorController.avaliaTaxaDoacaoTutor(emailTutor);
		int valorAoSistema =  (int)((1 - taxaTutor) * totalCentavos);
		this.doacoes += valorAoSistema;
		
		return valorAoSistema;
	}

	public int totalDinheiroSistema() {
		return this.doacoes;
	}
}