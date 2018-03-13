package testes.ajuda;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.*;

import aluno.Aluno;
import tutor.Tutor;
import tutor.ajuda.AjudaController;

public class AjudaControllerTest {
	private AjudaController ajudaController;
	
	@Before
	public void testAjudaController() {
		ajudaController = new AjudaController();
	}
	
	@Test
	public void testCadastrarAjudaPresencial() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		int retorno = ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		int esperado = 1;
		assertEquals(retorno, esperado);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAjudaPresencialComDisciplinaNula() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), null, "14:00", "Quinta", "lcc2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAjudaPresencialComDisciplinaVazia() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "     ", "14:00", "Quinta", "lcc2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAjudaPresencialComHorarioNulo() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", null, "Quinta", "lcc2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAjudaPresencialComHorarioVazio() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "   ", "Quinta", "lcc2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAjudaPresencialComDiaNulo() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", null, "lcc2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAjudaPresencialComDiaVazio() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "   ", "lcc2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAjudaPresencialComLocalNulo() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAjudaPresencialComLocalVazio() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "   ");
	}
	
	@Test
	public void testCadastrarAjudaOnline() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		Aluno vini = new Aluno("117110390", "Vini Barbosa", "99742-1892", "Vini.barbosa@gmail.com", 2);
		ajudaController.cadastraAjudaOnline(new Tutor("Discreta", 4, vini), "Discreta");
		int retorno = ajudaController.cadastraAjudaOnline(new Tutor("P2", 5, gauds), "P2");
		int esperado = 2;
		assertEquals(retorno, esperado);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAjudaOnlineComDisciplinaNula() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastraAjudaOnline(new Tutor("P2", 5, gauds), null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testCadastrarAjudaOnlineComDisciplinaVazia() {		
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastraAjudaOnline(new Tutor("P2", 5, gauds), "     ");
	}
	
	@Test
	public void testPegarTutor() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		String esperado = "Tutor - 11715963, horario - 14:00, dia - Quinta, local - lcc2, disciplina - P2";
		assertEquals(esperado, ajudaController.pegarTutor(1));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPegarTutorComIdInvalido() {
		ajudaController.pegarTutor(0);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testPegarTutorComAjudaNaoCadastrada() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		ajudaController.pegarTutor(2);
	}
	
	@Test
	public void testGetInfoAjudaComAtributoLocal() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		String esperado = "lcc2";
		assertEquals(esperado, ajudaController.getInfoAjuda(1, "localInteresse"));
	}
	
	@Test
	public void testGetInfoAjudaComAtributoHorario() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		String esperado = "14:00";
		assertEquals(esperado, ajudaController.getInfoAjuda(1, "horario"));
	}
	
	@Test
	public void testGetInfoAjudaComAtributoDia() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		String esperado = "Quinta";
		assertEquals(esperado, ajudaController.getInfoAjuda(1, "dia"));
	}
	
	@Test
	public void testGetInfoAjudaComAtributoDisciplina() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		String esperado = "P2";
		assertEquals(esperado, ajudaController.getInfoAjuda(1, "disciplina"));
	}
	
	@Test
	public void testGetInfoAjudaComAtributoMatriculaTutor() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		String esperado = "Tutor - 11715963, horario - 14:00, dia - Quinta, local - lcc2, disciplina - P2";
		assertEquals(esperado, ajudaController.getInfoAjuda(1, "tutorMatricula"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaComIdInvalido() {
		ajudaController.getInfoAjuda(0, "dia");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaComAtributoVazio() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		ajudaController.getInfoAjuda(1, "    ");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testGetInfoAjudaComAtributoNulo() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		ajudaController.getInfoAjuda(1, null);
	}
	
	@Test(expected = NoSuchElementException.class)
	public void testGetInfoAjudaComAjudaNaoCadastrada() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		ajudaController.getInfoAjuda(2, "localInteresse");
	}
	
	@Test
	public void testPegarMatriculaTutor() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		assertEquals("11715963", ajudaController.pegarMatriculaTutor(1));
	}
	
	@Test(expected = NullPointerException.class)
	public void testPegarMatriculaTutorComIdInvalido() {
		ajudaController.pegarMatriculaTutor(0);
	}
	
	@Test(expected = NullPointerException.class)
	public void testPegarMatriculaTutorComAjudaNaoCadastrada() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		assertEquals("11715963", ajudaController.pegarMatriculaTutor(2));
	}
	
	@Test
	public void testExisteAjudaComAjudaCadastrada() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		assertEquals(true, ajudaController.existeAjuda(1));
	}
	
	@Test
	public void testExisteAjudaComAjudaNaoCadastrada() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		assertEquals(false, ajudaController.existeAjuda(2));
	}
	
	@Test
	public void testListaAjudas() {
		Aluno gauds = new Aluno("11715963", "Gauds Lindo", "99984-1347", "gaudslindo99@gmail.com", 2);
		ajudaController.cadastrarAjudaPresencial(new Tutor("P2", 5, gauds), "P2", "14:00", "Quinta", "lcc2");
		ajudaController.cadastraAjudaOnline(new Tutor("P2", 5, gauds), "P2");
		String esperado = "Tutor - 11715963, horario - 14:00, dia - Quinta, local - lcc2, disciplina - P2, Tutor - 11715963, disciplina - P2";
		assertEquals(esperado, ajudaController.listaAjudas());
	}
	
	@Test
	public void testListaAjudasSemAjudasCadastradas() {
		assertEquals("", ajudaController.listaAjudas());
	}
}
