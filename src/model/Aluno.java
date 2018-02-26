package model;

import util.Validador;

/**
 * Representação de um aluno
 * 
 * @author Rayla Medeiros Araújo
 *
 */
public class Aluno {

	/**
	 * A matrícula do aluno
	 */
	private String matricula;
	
	/**
	 * O nome do aluno
	 */
	private String nome;
	
	/**
	 * O telefone do aluno
	 */
	private String telefone;
	
	/**
	 * O email do aluno
	 */
	private String email;
	
	/**
	 * A avaliação do aluno
	 */
	private int notaAvaliacao;
	
	/**
	 * O código do curso que o aluno cursa
	 */
	private String codCurso;

	public Aluno(String matricula, String nome, String telefone, String email, String codCurso) {
		if(Validador.validaTexto(matricula) && 
				Validador.validaTexto(nome) && (Validador.validaTexto(email))) {
			this.matricula = matricula;
			this.nome = nome;
			this.email = email;
		}
		
		this.telefone = telefone;
		this.codCurso = codCurso;
		this.notaAvaliacao = 5;
	}

	public String getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getCodCurso() {
		return codCurso;
	}
	
	public int getNotaAvaliacao() {
		return notaAvaliacao;
	}

	public void setNotaAvaliacao(int notaAvaliacao) {
		this.notaAvaliacao = notaAvaliacao;
	}
	

	@Override
	public String toString() {
		String retorno = this.matricula + " - " + this.nome + " - " + this.codCurso + " - ";

		if (!telefone.isEmpty()) {
			retorno += this.telefone + " - ";
		}

		retorno += this.email;

		return retorno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

}
