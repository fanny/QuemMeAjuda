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
	public static boolean validaAluno(String nome, String matricula,String telefone, String email, int codigoDoCurso) {
		return (validaMatricula(matricula) && validaNome(nome) && 
				validaTelefone(telefone) && validaEmail(email) && 
				validaCodigoDoCurso(codigoDoCurso));
	}

	/**
	 * @see Validador#validaTexto(String, String)
	 */
	public static boolean validaMatricula(String matricula){
		return Validador.validaTexto(matricula, 
				ErroAluno.MATRICULA_INVALIDA.toString());
	}
	
	/**
	 * @see Validador#validaTexto(String)
	 */
	public static boolean validaNome(String nome) {
		return Validador.validaTexto(nome, ErroAluno.NOME_INVALIDO.toString());
		
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
		if(telefone.equals("") || telefone == null){
			throw new IllegalArgumentException( ErroAluno.TELEFONE_INVALIDO.toString());
		
		}else if (!telefone.matches(formaTelefone)) {
				throw new IllegalArgumentException( ErroAluno.TELEFONE_INVALIDO.toString());
			}
		return true;
	}

	/**
	 * @see Validador#validaEmail(String)
	 */
	public static boolean validaEmail(String email) {
		return Validador.validaEmail(email, ErroAluno.EMAIL_INVALIDO.toString());
	}

	/**
	 * @see Validador#validaMaiorQuezero(String)
	 */
	public static boolean validaCodigoDoCurso(int codigoDoCurso) {
		return Validador.validaMaiorQueZero(codigoDoCurso, ErroAluno.CODIGO_INVALIDO.toString());	
	}
	
	/**
	 * Verifica se a nota de avaliação do tutor é maior que 0 e menor que 6
	 * 
	 * @param notaAvaliacao
	 *            a nota de avaliação do aluno
	 * @return true caso a nota seja válida, false caso contrário
	 */
	public static boolean validaNotaAvaliacao(int notaAvaliacao) {
		return Validador.validaMaiorQueZero(notaAvaliacao, ErroAluno.NOTA_AVALIACAO_INVALIDA.toString()) && 
				Validador.validaMenorQue6(notaAvaliacao, ErroAluno.NOTA_AVALIACAO_INVALIDA.toString());
	}

}
