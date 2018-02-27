package util;

public class Validador {

	/**
	 * Verifica se o texto é vazio ou nulo, caso seja é lançada uma exceção, caso
	 * contrário é retornado true.
	 * 
	 * @param texto
	 *            o texto a ser validado
	 * @param mensagem
	 *            a mensagem de erro, caso o texto seja inválido
	 * @exception IllegalArgumentException
	 *                caso o texto seja nulo ou vazio
	 * @return boolean que deve ser true quando o texto é válido.
	 */
	public static boolean validaTexto(String texto) {
		if (texto == null || texto.trim().isEmpty()) {
			// TODO: DEFINIR A MENSAGEM
			throw new IllegalArgumentException();
		}
		return true;
	}


	/**
	 * Verifica se o valor passado é maior que zero
	 * 
	 * @param valor
	 *            o valor a ser validado
	 * @throws IllegalArgumentException
	 *             caso o valor seja negativo
	 * @return true caso o valor seja maior que zero, false caso contrário
	 */
	public static boolean validaMaiorQueZero(double valor) {
		if (valor <= 0.0) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	/**
	 * Verifica se o valor é menor que 0
	 * 
	 * @param valor
	 *            o valor a ser validado
	 * @throws IllegalArgumentException
	 *             caso o valor seja maior ou igual a 6
	 * @return true se o valor é menor que 6, false caso contrário
	 */
	public static boolean validaMenorQue6(double valor) {
		if (valor >= 6.0) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public static boolean validaEmail(String email) {
		if (validaTexto(email)) {
			String formaEmail = "[\\._a-zA-Z0-9]+@[a-zA-Z0-9]+(\\.[a-zA-z]+)+";
			
			if (!email.matches(formaEmail)) {
				throw new IllegalArgumentException("Email invalido");
			}
		}
		
		return true;
	}

}
