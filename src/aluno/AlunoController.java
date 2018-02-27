package aluno;

import java.util.HashMap;
import java.util.Map;

/**
 * Controller dos alunos do sistema.
 * 
 * @author Marcus Vinicius
 */
public class AlunoController {
	
	/**
	 * Conjunto de alunos que o sistema possui.
	 */
	private Map<String, Aluno> alunos;
	
	/**
	 * Construtor da classe.
	 */
	public AlunoController() {
		this.alunos = new HashMap<String, Aluno>();
	}
	
	/**
	 * Cadastra um aluno no sistema
	 * 
	 * @param nome
	 *            o nome do aluno
	 * @param matricula
	 *            a matricula do aluno
	 * @param codigoCurso
	 *            o código do curso que o aluno frequenta
	 * @param telefone
	 *            o telefone do aluno
	 * @param email
	 *            o email do aluno
	 */
	public void cadastrarAluno(String nome, String matricula, 
			int codigoCurso, String telefone, String email){
		
		Aluno aluno = new Aluno(matricula, nome, telefone, email, codigoCurso);
		this.alunos.put(matricula, aluno);
		
	}
	
	/**
	 * Obtem a representação textual de um aluno através de sua matrícula
	 * 
	 * @param matricula
	 *            a matrícula do aluno
	 * @return String a representação textual dos atributos do aluno
	 */
	public String recuperaAluno(String matricula){
		
		return this.alunos.get(matricula).toString();
		
	}
	
	/**
	 * Lista os alunos cadastrados no sistema
	 * 
	 * @return String uma representação textual dos alunos cadastrados no
	 *         sistema.
	 */
	public String listarAlunos(){
		String resultado = "";
		
		for (Aluno aluno: this.alunos.values()){
			resultado += aluno.toString() + System.lineSeparator();
		}

		return resultado;
	}
	
	public void getInfoAluno(String matricula, String atributo){
		
	}
	
}
