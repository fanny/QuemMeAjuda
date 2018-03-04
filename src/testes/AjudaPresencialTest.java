package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import aluno.Aluno;
import tutor.Tutor;
import tutor.ajuda.AjudaPresencial;

public class AjudaPresencialTest {

	private AjudaPresencial ajudaPresencial;
	
	@Test
	public void testCadastroAjudaPresencial() {
		ajudaPresencial = new AjudaPresencial(1, "POO",  new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)), "18:00", "segunda", "ufcg");
		String resultadoEsperado = "Tutor - 87575, horario - 18:00, dia - segunda, local - ufcg, disciplina - POO";
		assertEquals(resultadoEsperado, ajudaPresencial.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaPresencialIdNegativo() {
		ajudaPresencial = new AjudaPresencial(-1, "POO",  new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)), "18:00", "segunda", "ufcg");
	}
	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaPresencialDisciplinaNula() {
		ajudaPresencial = new AjudaPresencial(1, null,  new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)), "18:00", "segunda", "ufcg");
	}
	
	
	@Test(expected=NullPointerException.class)
	public void testCadastroAjudaPresencialTutorNulo() {
		ajudaPresencial = new AjudaPresencial(1, "POO",  null, "18:00", "segunda", "ufcg");
	}
	

	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaPresencialHorarioVazio() {
		ajudaPresencial = new AjudaPresencial(1, "POO",  new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)), "", "segunda", "ufcg");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaPresencialHorarioNulo() {
		ajudaPresencial = new AjudaPresencial(1, "POO",  new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)), null, "segunda", "ufcg");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaPresencialDiaNulo() {
		ajudaPresencial = new AjudaPresencial(1, "POO",  new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)), "18:00", null, "ufcg");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaPresencialDiaVazio() {
		ajudaPresencial = new AjudaPresencial(1, "POO",  new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)), "18:00", "", "ufcg");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaPresencialLocalVazio() {
		ajudaPresencial = new AjudaPresencial(1, "POO",  new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)), "18:00", "segunda", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaPresencialLocalNulo() {
		ajudaPresencial = new AjudaPresencial(1, "POO",  new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)), "18:00", "segunda", null);
	}
}
