package testes.ajuda;

import static org.junit.Assert.*;

import org.junit.Test;

import aluno.Aluno;
import tutor.Tutor;
import tutor.ajuda.AjudaOnline;

public class AjudaOnlineTest {
	
	private AjudaOnline ajudaOnline;

	@Test
	public void testCadastroAjudaOnline() {
		ajudaOnline = new AjudaOnline(1, "POO", new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)));
		String resultadoEsperado = "Tutor - 87575, disciplina - POO";
		assertEquals(resultadoEsperado, ajudaOnline.toString());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaOnlineTutorIdNegativo() {
		ajudaOnline = new AjudaOnline(-1, "POO", new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaOnlineTutorDisciplinaNula() {
		ajudaOnline = new AjudaOnline(1, null,new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastroAjudaOnlineTutorDisciplinaVazia() {
		ajudaOnline = new AjudaOnline(1, "",new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)));
	}
	
	
	@Test(expected=NullPointerException.class)
	public void testCadastroAjudaOnlineTutorNulo() {
		ajudaOnline = new AjudaOnline(1, "Cálculo II", null);
	}

}
