

/**
 * Classe Facade do sistema.
 * 
 * @author Marcus Vinícius
 */
public class Facade {
	
	private Sistema sistema;
	
	/**
	 * @see Sistema#recuperaTutor(String)
	 */
	public String recuperaTutor(String matricula) {
		return sistema.recuperaTutor(matricula);
	}
	
	/**
	 * @see Sistema#recuperaAluno(String)
	 */
	public String recuperaAluno(String matricula) {
		return sistema.recuperaAluno(matricula);
	}


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
	
	/**
	 * @see Sistema#getInfoAluno(String, String)
	 */
	public String getInfoAluno(String matricula, String atributo) {
		
		return this.sistema.getInfoAluno(matricula, atributo);
	}
	

}
