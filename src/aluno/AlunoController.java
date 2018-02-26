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
}
