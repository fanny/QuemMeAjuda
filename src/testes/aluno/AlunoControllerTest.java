package testes.aluno;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import aluno.Aluno;
import aluno.AlunoController;
import testes.TestUtil;
import util.controller.OpcoesController;

public class AlunoControllerTest {

	private AlunoController alunoController;
	
	
	@Before
	public void setUp() throws Exception {
		alunoController = new AlunoController();
	}

	/*---------------------- TESTES CADASTRAR ALUNO ----------------------*/
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoNomeVazio() {
		alunoController.cadastrarAluno("", "11715963", 2, "99984-1347", "fannyvieira@gmail.com");
	}
	
	@Test
	public void testCadastrarAlunoValido() {
		alunoController.cadastrarAluno("fanny", "658372", 3, "64637-3435", "fannyJoke@hotmail.com");
		String resultadoEsperado = "658372 - fanny - 3 - 64637-3435 - fannyJoke@hotmail.com";
		assertEquals(resultadoEsperado, alunoController.recuperaAluno("658372"));
	}
	
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoJaExistente() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "fannyvieira@gmail.com");
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "fannyvieira@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoNomeComEspacos() {
		alunoController.cadastrarAluno("     ", "11715963", 2, "99984-1347", "fannyvieira@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoMatriculaVazio() {
		alunoController.cadastrarAluno("Fanny", "", 2, "99984-1347", "fannyvieira@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoMatriculaComEspacos() {
		alunoController.cadastrarAluno("Fanny", "      ", 2, "99984-1347", "fannyvieira@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoCursoNegativo() {
		alunoController.cadastrarAluno("Fanny", "11715963", -2, "99984-1347", "fannyvieira@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoCursoZero() {
		alunoController.cadastrarAluno("Fanny", "11715963", 0, "99984-1347", "fannyvieira@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoTelefoneComLetras() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "asheowh", "fannyvieira@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoTelefoneComEspacos() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "      ", "fannyvieira@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoTelefoneComCaracteres() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "*&$#@#$!", "fannyvieira@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoEmailInvalido() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "@@fannyvieira!!!gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoEmailComApenasLetras() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "fsndlçknfwe");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoEmailComCaracteresEspeciais() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", TestUtil.getStringCaracteresEspeciais());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoEmailComDoisArrobas() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "fannyvieira@@gmail.com");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoEmailVazio() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "");
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCadastrarAlunoCodigoEmailEspacos() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", TestUtil.getStringEspacosEmBranco());
	}
	
	/*----------------- TESTES RECUPERA ALUNO ------------------------*/
	
	@Test(expected=IllegalArgumentException.class)
	public void testRecuperaAlunoMatriculaVazia() {
		alunoController.recuperaAluno(TestUtil.getStringEspacosEmBranco());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRecuperaAlunoMatriculaComLetras() {
		alunoController.recuperaAluno(TestUtil.getStringLetrasAleatorias());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRecuperaAlunoMatriculaComCaracteresEspeciais() {
		alunoController.recuperaAluno(TestUtil.getStringCaracteresEspeciais());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testRecuperaAlunoMatriculaNaoCadastrada() {
		alunoController.recuperaAluno(TestUtil.getExemploMatricula());
	}
	
	@Test
	public void testRecuperaAlunoValido() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "fannyvieira082@gmail.com");
		
		String resultadoEsperado = "11715963 - Fanny - 2 - 99984-1347 - fannyvieira082@gmail.com";
		assertEquals(resultadoEsperado, alunoController.recuperaAluno("11715963"));
	}
	
	/*-------------------- TESTES GETALUNOPELAMATRICULA ------------*/
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetAlunoPelaMatriculaVazia() {
		alunoController.getAlunoPelaMatricula(TestUtil.getStringEspacosEmBranco());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void tesGetAlunoPelaMatriculaComLetras() {
		alunoController.getAlunoPelaMatricula(TestUtil.getStringLetrasAleatorias());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetAlunoPelaMatriculaComCaracteresEspeciais() {
		alunoController.getAlunoPelaMatricula(TestUtil.getStringCaracteresEspeciais());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testGetAlunoPelaMatriculaNaoCadastrada() {
		alunoController.getAlunoPelaMatricula(TestUtil.getExemploMatricula());
	}

	@Test
	public void testGetAlunoPelaMatriculaValida() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "fannyvieira082@gmail.com");
		Aluno aluno = new Aluno("11715963", "Fanny", "99984-1347", "fannyvieira082@gmail.com", 2);
		assertEquals(aluno, alunoController.getAlunoPelaMatricula("11715963"));
	}
	
	/*------------- TESTES GET INFO ALUNO ----------------*/
	

	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAlunoMatriculaVazia() {
		alunoController.getInfoAluno(TestUtil.getStringEspacosEmBranco(), OpcoesController.EMAIL.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAlunoMatriculaComLetras() {
		alunoController.getInfoAluno(TestUtil.getStringLetrasAleatorias(), OpcoesController.EMAIL.toString());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testGetInfoAlunoMatriculaComCaracteresEspeciais() {
		alunoController.getInfoAluno(TestUtil.getStringCaracteresEspeciais(), OpcoesController.EMAIL.toString());
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testGetInfoAlunoMatriculaNaoCadastrada() {
		alunoController.getInfoAluno(TestUtil.getExemploMatricula(), OpcoesController.EMAIL.toString());
	}
	
	@Test
	public void testGetInfoAlunoMatriculaValida() {
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "fannyvieira082@gmail.com");
		assertEquals("fannyvieira082@gmail.com", alunoController.getInfoAluno
				("11715963", OpcoesController.EMAIL.toString()));
	}
	
	/*--------------------- TESTES LISTAR ALUNOS ---------------*/
	
	@Test
	public void testListarAlunos() {
		
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "fannyvieira082@gmail.com");
		alunoController.cadastrarAluno("Vinicius", "11715945", 2, "99974-1357", "viniciusbarbosa@gmail.com");
		alunoController.cadastrarAluno("Rayla", "11715987", 2, "99955-5017", "raylamedeiros082@gmail.com");
		alunoController.cadastrarAluno("Daniel", "11715947", 2, "99974-1477", "danielbarreto082@gmail.com");
		
		String resultadoEsperado = "11715947 - Daniel - 2 - 99974-1477 - danielbarreto082@gmail.com, " 
				+ "11715963 - Fanny - 2 - 99984-1347 - fannyvieira082@gmail.com, "
				+ "11715987 - Rayla - 2 - 99955-5017 - raylamedeiros082@gmail.com, "
				+ "11715945 - Vinicius - 2 - 99974-1357 - viniciusbarbosa@gmail.com";
		assertEquals(resultadoEsperado, alunoController.listarAlunos());
	}
	
	

}
