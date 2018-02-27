package testes;

import aluno.Aluno;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class AlunoTest {

	private Aluno aluno1;
	private Aluno aluno2;
	private Aluno aluno3;
	
	
	@Test(expected = IllegalArgumentException.class)
	public void CriacaoDeAlunosComParametrosNulos() {
		
		Aluno alunoErrado1 = new Aluno(null, "rayla", "9883-3456","VelhaDosGatos@hotmail.com", 5);
		Aluno alunoErrado2 = new Aluno("45454", null, "9883-3456","fannyHistory@hotmail.com", 3);
		Aluno alunoErrado3 = new Aluno("655484", "fanny", null,"fannyHistory@hotmail.com", 4);
		Aluno alunoErrado4 = new Aluno("87575", "rayla", "9883-3456",null, 2);
		Aluno alunoErrado5 = new Aluno("958575", "vinicius", "9883-3456","viniciusapekador@hotmail.com", 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CriacaoDeAlunosComParametrosVazios() {
		
		Aluno alunoErrado1 = new Aluno("", "vinicius", "6573-4567", "viniciusgatao@hotmail.com", 2);
		Aluno alunoErrado2 = new Aluno("465869", "", "6573-4567", "viniciusgatao@hotmail.com", 2);
		Aluno alunoErrado3 = new Aluno("87879", "vinicius", "", "viniciusgatao@hotmail.com", 2);
		Aluno alunoErrado4 = new Aluno("343434", "vinicius", "6573-4567", "", 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CriacaoDeAlunosComTelefoneInvalido() {
		
		Aluno alunoErrado1 = new Aluno("87879", "vinicius", "456-5678", "viniciusgatao@hotmail.com", 2);
		Aluno alunoErrado2 = new Aluno("87879", "vinicius", "56785432", "viniciusgatao@hotmail.com", 2);
		Aluno alunoErrado3 = new Aluno("87879", "vinicius", "-7890", "viniciusgatao@hotmail.com", 2);
		Aluno alunoErrado4 = new Aluno("87879", "vinicius", "4567-", "viniciusgatao@hotmail.com", 2);
		Aluno alunoErrado5 = new Aluno("87879", "vinicius", "-", "viniciusgatao@hotmail.com", 2);
		Aluno alunoErrado6 = new Aluno("87879", "vinicius", "56778-567", "viniciusgatao@hotmail.com", 2);
		Aluno alunoErrado7 = new Aluno("87879", "vinicius", "56784-67854", "viniciusgatao@hotmail.com", 2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CriacaoDeAlunosComEmailInvalido() {
		
		Aluno alunoErrado1 = new Aluno("45454", "fanny", "9883-3456","fannyHistory", 3);
		Aluno alunoErrado2 = new Aluno("45454", "fanny", "9883-3456","@hotmail.com", 3);
		Aluno alunoErrado3 = new Aluno("45454", "fanny", "9883-3456","@", 3);
		Aluno alunoErrado4 = new Aluno("45454", "fanny", "9883-3456","fannyHistory", 3);
	}

	@Before
	public void criarAluno() {
		
		this.aluno1 = new Aluno("658372", "fanny", "64637-3435", "fannyJoke@hotmail.com", 3);
		this.aluno2 = new Aluno("658372", "fanny Vieira", "64637-3435", "fannyJoke@hotmail.com", 5);
		this.aluno3 = new Aluno("658372", "fanny", "64637-3435", "fannyHistory@hotmail.com", 4);
	}

	@Test
	public void testToString() {
		
		assertEquals("658372 - fanny - 3 - 64637-3435 - fannyJoke@hotmail.com", aluno1.toString());
	}
}