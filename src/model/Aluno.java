package model;

public class Aluno {
	private String matricula;
	private String nome;
	private String telefone;
	private String email;
	private int notaAvaliacao;
	private String codCurso;

	public Aluno(String matricula, String nome, String telefone, String email, String codCurso) {
		this.matricula = matricula;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.notaAvaliacao = notaAvaliacao;
		this.codCurso = codCurso;
		this.notaAvaliacao = 5;
	}

	public Aluno(String matricula, String nome, String email, String codCurso) {
		this.matricula = matricula;
		this.nome = nome;
		this.email = email;
		this.notaAvaliacao = notaAvaliacao;
		this.codCurso = codCurso;
		this.telefone = "";
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

	@Override
	public String toString() {
		if (telefone.isEmpty()) {
			return this.matricula + " - " + this.nome + " - " + this.codCurso + " - " + this.email;
		}

		return this.matricula + " - " + this.nome + " - " + this.codCurso + " - " + this.telefone + " - " + this.email;
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
