package util;

public class AlunoValidador {
	
	public static boolean validaAluno(String nome, String telefone, String email, int codigoDoCurso) {
		return (validaNome(nome) && validaTelefone(telefone) && 
				validaEmail(email) && validaCodigoDoCurso(codigoDoCurso));
	}
	
	public static boolean validaNome(String nome) {
		return Validador.validaTexto(nome);
		
	}
	
	public static boolean validaTelefone(String telefone) {
		if (Validador.validaTexto(telefone)) {
			String formaTelefone = "^([0-9]{4,}-[0-9]{4})$";
			
			if (!telefone.matches(formaTelefone)) {
				throw new IllegalArgumentException("Telefone invalido");
			}
		}
		return true;
	}

	
	public static boolean validaEmail(String email) {
		return Validador.validaEmail(email);
	}

	public static boolean validaCodigoDoCurso(int codigoDoCurso) {
		return Validador.validaMaiorQueZero(codigoDoCurso);	
	}
	
	public static boolean validaNotaAvaliacao(int notaAvaliacao) {
		return Validador.validaMaiorQueZero(notaAvaliacao) && 
				Validador.validaMenorQue6(notaAvaliacao);
	}

}
