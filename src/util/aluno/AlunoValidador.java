package util.aluno;

import util.Validador;

/**
 * Classe utilizada para validar as informações de um aluno
 * @author fanny
 *
 */
public class AlunoValidador {
	
	/**
	 * Verifica se todas as informações do aluno são válidas
	 * 
	 * @param nome
	 *            o nome do aluno
	 * @param telefone
	 *            o telefone do aluno
	 * @param email
	 *            o email do aluno
	 * @param codigoDoCurso
	 *            o código do curso do aluno
	 * @return true se todas as informações são válidas, false, caso contrário
	 */
	public static boolean validaAluno(String nome, String matricula,String telefone, String email, int codigoDoCurso) {
		return (validaMatricula(matricula) && validaNome(nome) && 
				validaTelefone(telefone) && validaEmail(email) && 
				validaCodigoDoCurso(codigoDoCurso));
	}

	/**
	 * @see Validador#validaTexto(String, String)
	 */
	public static boolean validaMatricula(String matricula){
		if (Validador.validaTexto(matricula, MensagemAluno.MATRICULA_INVALIDA.toString())) {
			
			String formaMatricula = "^([0-9]+)$";
			
			if (!matricula.matches(formaMatricula)) {
				throw new IllegalArgumentException(MensagemAluno.MATRICULA_INVALIDA.toString());
			}
		}

		return true;
	}
	
	/**
	 * @see Validador#validaTexto(String)
	 */
	public static boolean validaNome(String nome) {
		return Validador.validaTexto(nome, MensagemAluno.NOME_INVALIDO.toString());
		
	}
	
	/**
	 * Verifica se o telefone possui números e uma barra entre ele
	 * 
	 * @param telefone
	 *            o telefone do aluno
	 * @return true caso o telefone seja válido, false caso contrário
	 */
	public static boolean validaTelefone(String telefone) {
		String formaTelefone = "^([0-9]{4,}-[0-9]{4}|)$"; 
		
		if (telefone == null) {
			throw new IllegalArgumentException(MensagemAluno.TELEFONE_INVALIDO.toString());
		}else if(!telefone.equals("") && !telefone.matches(formaTelefone)) {
			throw new IllegalArgumentException(MensagemAluno.TELEFONE_INVALIDO.toString());
		}
		return true;
	}

	/**
	 * @see Validador#validaEmail(String)
	 */
	public static boolean validaEmail(String email) {
		return Validador.validaEmail(email, MensagemAluno.EMAIL_INVALIDO.toString());
	}

	/**
	 * @see Validador#validaMaiorQuezero(String)
	 */
	public static boolean validaCodigoDoCurso(int codigoDoCurso) {
		return Validador.validaMaiorIgualZero(codigoDoCurso, MensagemAluno.CODIGO_INVALIDO.toString());	
	}
	
	/**
	 * Verifica se a nota de avaliação do tutor é maior que 0 e menor que 6
	 * 
	 * @param notaAvaliacao
	 *            a nota de avaliação do aluno
	 * @return true caso a nota seja válida, false caso contrário
	 */
	public static boolean validaNotaAvaliacao(int notaAvaliacao) {
		return Validador.validaMaiorIgualZero(notaAvaliacao, MensagemAluno.NOTA_AVALIACAO_INVALIDA.toString()) && 
				Validador.validaMenorQue6(notaAvaliacao, MensagemAluno.NOTA_AVALIACAO_INVALIDA.toString());
	}

}
