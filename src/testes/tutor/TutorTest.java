package testes.tutor;

import static org.junit.Assert.*;

import org.junit.*;

import aluno.Aluno;
import tutor.Tutor;
import util.tutor.MensagemTutor;

public class TutorTest {
	private Tutor t;

	@Before
	public void testTutor() {
		t = new Tutor("Programação 1", 4, new Aluno("117110383", "Rayla", "99884-7692", "rayla.araujo@ccc.ufcg.edu.br", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComDisciplinaNula() {
		t = new Tutor(null, 4, new Aluno("117110383", "Rayla", "99884-7692", "rayla.araujo@ccc.ufcg.edu.br", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComDisciplinaVazia() {
		t = new Tutor("    ", 4, new Aluno("117110383", "Rayla", "99884-7692", "rayla.araujo@ccc.ufcg.edu.br", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComProeficienciaInvalida() {
		t = new Tutor("Programação 1", -1, new Aluno("117110383", "Rayla", "99884-7692", "rayla.araujo@ccc.ufcg.edu.br", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComMatriculaDoAlunoNula() {
		t = new Tutor("Programação 1", 4, new Aluno(null, "Rayla", "99884-7692", "rayla.araujo@ccc.ufcg.edu.br", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComMatriculaDoAlunoVazia() {
		t = new Tutor("Programação 1", 4, new Aluno("   ", "Rayla", "99884-7692", "rayla.araujo@ccc.ufcg.edu.br", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComNomeDoAlunoNulo() {
		t = new Tutor("Programação 1", 4, new Aluno("117110383", null, "99884-7692", "rayla.araujo@ccc.ufcg.edu.br", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComNomeDoAlunoVazio() {
		t = new Tutor("Programação 1", 4, new Aluno("117110383", "    ", "99884-7692", "rayla.araujo@ccc.ufcg.edu.br", 1));
	}
	
	@Test
	public void testTutorComTelefoneDoAlunoVazio() {
		t = new Tutor("Programação 1", 4, new Aluno("117110383", "Rayla", "", "rayla.araujo@ccc.ufcg.edu.br", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComTelefoneDoAlunoNulo() {
		t = new Tutor("Programação 1", 4, new Aluno("117110383", "Rayla", null, "rayla.araujo@ccc.ufcg.edu.br", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComEmailDoAlunoNulo() {
		t = new Tutor("Programação 1", 4, new Aluno("117110383", "Rayla", "99884-7692", null, 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComEmailDoAlunoVazio() {
		t = new Tutor("Programação 1", 4, new Aluno("117110383", "Rayla", "99884-7692", "  ", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComEmailDoAlunoInvalido() {
		t = new Tutor("Programação 1", 4, new Aluno("117110383", "Rayla", "99884-7692", "rayla.araujo@.com", 1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTutorComCodigoDoCursoDoAlunoInvalido() {
		t = new Tutor("Programação 1", 4, new Aluno("117110383", "Rayla", "99884-7692", "rayla.araujo@ccc.ufcg.edu.br", 0));
	}
	
	@Test
	public void testCadastrarHorario() {
		t.cadastrarHorario("14:00", "Quinta");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioComDiaNulo() {
		t.cadastrarHorario("14:00", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioComDiaVazio() {
		t.cadastrarHorario("14:00", "  ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioComHorarioAtendimentoNulo() {
		t.cadastrarHorario(null, "Quinta");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarHorarioComHorarioAtendimentoVazio() {
		t.cadastrarHorario("  ", "Quinta");
	}
	
	@Test
	public void testCadastrarLocal() {
		t.cadastrarLocal("CAA 404");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalComLocalNulo() {
		t.cadastrarLocal(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarLocalComLocalVazio() {
		t.cadastrarLocal("  ");
	}
	
	@Test
	public void testConsultaLocal() {
		t.cadastrarLocal("CAA 404");
		assertEquals(t.consultaLocal("CAA 404"), true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaLocalComLocalNulo() {
		t.consultaLocal(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaLocalComLocalVazio() {
		t.consultaLocal("");
	}
	
	@Test
	public void testConsultaHorario() {
		t.cadastrarHorario("14:00", "Quinta");
		assertEquals(t.consultaHorario("14:00", "Quinta"), true);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioComHorarioAtendimentoNulo() {
		t.consultaHorario(null, "Quinta");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioComHorarioAtendimentoVazio() {
		t.consultaHorario("", "Quinta");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioComDiaNulo() {
		t.consultaHorario("14:00", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testConsultaHorarioComDiaVazio() {
		t.consultaHorario("14:00", "");
	}
	
	@Test
	public void testAddDisciplina() {
		t.addDisciplina("Rayla", 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddDisciplinaComNomeNulo() {
		t.addDisciplina(null, 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddDisciplinaComNomeVazio() {
		t.addDisciplina("  ", 5);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAddDisciplinaComProficiênciaInvalida() {
		t.addDisciplina("Rayla", -1);
	}
	
	@Test
	public void testAvaliaTutor(){
		t.alteraNotaAvaliacao(5);
		//O 4 se deve ao fato de que é a primeira invocação
		assertEquals(4.17, t.getNotaAvaliacao(), 0.1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliaTutorNegativo(){
		t.alteraNotaAvaliacao(-5);
	}
	
	@Test
	public void testAvaliaTutorZero(){
		t.alteraNotaAvaliacao(0);
		assertEquals(3.33, t.getNotaAvaliacao(), 0.1);
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAvaliaTutorMaiorQue5(){
		t.alteraNotaAvaliacao(6);
	}
	
	@Test
	public void testAvaliaNivelTutor(){
		t.alteraNotaAvaliacao(5);
		assertEquals(MensagemTutor.TUTOR.toString(), t.getNivel());
	}
	
	@Test
	public void testAvaliaNivelTutorAprendiz(){
		//Só assim para a média ficar inferiro a 3
		t.alteraNotaAvaliacao(1);
		t.alteraNotaAvaliacao(1);
		t.alteraNotaAvaliacao(1);
		assertEquals(MensagemTutor.APRENDIZ.toString(), t.getNivel());
	}
	
	@Test
	public void testAvaliaNivelTutorTop(){
		//Só assim para a média ficar superio a 4.5
		t.alteraNotaAvaliacao(5);
		t.alteraNotaAvaliacao(5);
		t.alteraNotaAvaliacao(5);
		t.alteraNotaAvaliacao(5);
		assertEquals(MensagemTutor.TOP.toString(), t.getNivel());
	}

	
	
	/**
	 * Esse teste é usado para verificar se quando 
	 * a avaliação é feita mais d euma vez ele naõ retorna
	 * o valor da primeira
	 */
	@Test
	public void testAvaliaTutorSegundaVez(){
		t.alteraNotaAvaliacao(5);
		t.alteraNotaAvaliacao(5);
		String resultadoEsperado = String.format("%.2f", 4.31);
		assertEquals(4.31, t.getNotaAvaliacao(), 0.1);
	}
	
}
