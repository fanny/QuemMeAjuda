

/**
 * Classe Facade do sistema.
 * 
 * @author Marcus Vinícius
 */
public class Facade {
	
	private Sistema sistema;

	/**
	 * @see Sistema#cadastrarHorario(String, String, String)
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		
		this.sistema.cadastrarHorario(email, horario, dia);
		
	}

	/**
	 * @see Sistema#cadastrarLocalDeAtendimento(String, String)
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		
		this.sistema.cadastrarLocalDeAtendimento(email, local);
		
	}
	
	/**
	 * @see Sistema#consultaHorario(String, String, String)
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		
		return this.sistema.consultaHorario(email, horario, dia);
		
	}

	/**
	 * @see Sistema#consultaLocal(String, String)
	 */
	public boolean consultaLocal(String email, String local) {
		
		return this.sistema.consultaLocal(email, local);
		
	}

}
