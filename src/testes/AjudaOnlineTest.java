package testes;

import static org.junit.Assert.*;

import org.junit.Test;

import aluno.Aluno;
import tutor.Tutor;
import tutor.ajuda.AjudaOnline;

public class AjudaOnlineTest {
	
	private AjudaOnline ajudaOnline;

	@Test
	public void testCadatroAjudaOnline() {
		ajudaOnline = new AjudaOnline(1, "POO", new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)));
		String resultadoEsperado = "Tutor - 87575, disciplina - POO";
		assertEquals(resultadoEsperado, ajudaOnline.toString());
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCadatroAjudaOnlineTutorIdNegativo() {
		ajudaOnline = new AjudaOnline(-1, "POO", new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)));
	}

	@Test(expected=IllegalArgumentException.class)
	public void testCadatroAjudaOnlineTutorDisciplinaNula() {
		ajudaOnline = new AjudaOnline(1, null,new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadatroAjudaOnlineTutorDisciplinaVazia() {
		ajudaOnline = new AjudaOnline(1, "",new Tutor("POO", 5, new Aluno("87575", "rayla", "9883-3456",
				"fannyJoke@hotmail.com", 2)));
	}

}
