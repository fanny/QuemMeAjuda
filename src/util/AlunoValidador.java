package util;

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
	public static boolean validaAluno(String nome, String telefone, String email, int codigoDoCurso) {
		return (validaNome(nome, ErroAluno.NOME_INVALIDO.toString()) && 
				validaTelefone(telefone, ErroAluno.TELEFONE_INVALIDO.toString()) && 
				validaEmail(email, ErroAluno.EMAIL_INVALIDO.toString()) && 
				validaCodigoDoCurso(codigoDoCurso, ErroAluno.CODIGO_INVALIDO.toString()));
	}


	/**
	 * @see Validador#validaTexto(String)
	 */
	public static boolean validaNome(String nome, String mensagem) {
		return Validador.validaTexto(nome, mensagem);
		
	}
	
	/**
	 * Verifica se o telefone possui números e uma barra entre ele
	 * 
	 * @param telefone
	 *            o telefone do aluno
	 * @return true caso o telefone seja válido, false caso contrário
	 */
	public static boolean validaTelefone(String telefone, String mensagem) {
		if (Validador.validaTexto(telefone, mensagem)) {
			String formaTelefone = "^([0-9]{4,}-[0-9]{4})$";
			
			if (!telefone.matches(formaTelefone)) {
				throw new IllegalArgumentException("Telefone invalido");
			}
		}
		return true;
	}

	/**
	 * @see Validador#validaEmail(String)
	 */
	public static boolean validaEmail(String email, String mensagem) {
		return Validador.validaEmail(email, mensagem);
	}

	/**
	 * @see Validador#validaMaiorQuezero(String)
	 */
	public static boolean validaCodigoDoCurso(int codigoDoCurso, String mensagem) {
		return Validador.validaMaiorQueZero(codigoDoCurso, mensagem);	
	}
	
	/**
	 * Verifica se a nota de avaliação do tutor é maior que 0 e menor que 6
	 * 
	 * @param notaAvaliacao
	 *            a nota de avaliação do aluno
	 * @return true caso a nota seja válida, false caso contrário
	 */
	public static boolean validaNotaAvaliacao(int notaAvaliacao, String mensagem) {
		return Validador.validaMaiorQueZero(notaAvaliacao, mensagem) && 
				Validador.validaMenorQue6(notaAvaliacao, mensagem);
	}

}
