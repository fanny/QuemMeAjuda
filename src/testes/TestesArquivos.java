package testes;

import java.io.IOException;

import aluno.Aluno;
import aluno.AlunoController;
import main.Sistema;
import persistencia.Persistencia;
import tutor.Tutor;
import tutor.TutorController;
import tutor.ajuda.AjudaController;

public class TestesArquivos {
	
	public static void main(String[] args) throws IOException {
		
		Sistema sistema = new Sistema();
		
		AlunoController alunoController = new AlunoController();
	
		alunoController.cadastrarAluno("Fanny", "11715963", 2, "99984-1347", "fannyvieira082@gmail.com");
		alunoController.cadastrarAluno("Vinicius", "11715945", 2, "99974-1357", "viniciusbarbosa@gmail.com");
		alunoController.cadastrarAluno("Rayla", "11715987", 2, "99955-5017", "raylamedeiros082@gmail.com");
		alunoController.cadastrarAluno("Daniel", "11715947", 2, "99974-1477", "danielbarreto082@gmail.com");
	
		alunoController.salvaAlunos();
		
		
		TutorController tutorController = new TutorController();
		tutorController.cadastraTutor("Programação 1", 4, new Aluno("117110383", "Rayla", "99887-7692", "rayla.araujo@ccc.ufcg.edu.br", 1));
		tutorController.cadastraTutor("Programação 2", 4, new Aluno("117147123", "abrbrbr", "99883-7692", "fanny.araujo@ccc.ufcg.edu.br", 1));
		tutorController.cadastraTutor("Programação 3", 4, new Aluno("117114383", "tatatata", "99882-7692", "eddie.araujo@ccc.ufcg.edu.br", 1));
		tutorController.cadastraTutor("Programação 4", 4, new Aluno("117115383", "uioeioeao", "99881-7692", "vinii.araujo@ccc.ufcg.edu.br", 1));
	
		tutorController.salvaTutores();
		
		AjudaController ajudaController = new AjudaController();
		ajudaController.cadastraAjudaOnline(new Tutor("Programação 1", 4, new Aluno("117110383", "Rayla", "99887-7692", "rayla.araujo@ccc.ufcg.edu.br", 1)), "quaua");
		ajudaController.cadastraAjudaOnline(new Tutor("Programação 2", 4, new Aluno("117147123", "abrbrbr", "99883-7692", "fanny.araujo@ccc.ufcg.edu.br", 1)), "quaua1");
		ajudaController.cadastraAjudaOnline(new Tutor("Programação 3", 4, new Aluno("117114383", "tatatata", "99882-7692", "eddie.araujo@ccc.ufcg.edu.br", 1)), "quaua2");
		ajudaController.cadastraAjudaOnline(new Tutor("Programação 4", 4, new Aluno("117115383", "uioeioeao", "99881-7692", "vinii.araujo@ccc.ufcg.edu.br", 1)), "quaua3");
	
		ajudaController.salvaAjudas();
		
		sistema.carregar();
		
	
		
	}

}
