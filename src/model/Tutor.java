package model;

import java.util.HashSet;
import java.util.Set;

import util.Validador;

/**
 * Representação de um orientador de um aluno
 * 
 * @author fanny
 */
public class Tutor {

	/**
	 * A matéria na qual o tutor domina
	 */
	private String disciplina;

	/**
	 * Indica o nível de conhecimento do tutor
	 */
	private int proficiencia;

	/**
	 * Indica o quanto um tutor recebe do sistema
	 */
	private double salario;

	/**
	 * Conjunto de locais de atendimento do tutor
	 */
	private Set<String> locaisDeAtendimento;

	/**
	 * Conjunto de horários de atendimento do tutor
	 */
	private Set<HorarioAtendimento> horariosDeAtendimento;

	/**
	 * A referência do aluno que o tutor é
	 */
	private Aluno aluno;

	/**
	 * Constutor usado para inicializar a disciplina e a proficiência do mentor
	 * 
	 * @param disciplina
	 *            A matéria na qual o tutor domina
	 * @param proficiencia
	 *            Indica o nível de conhecimento do tuto
	 */
	public Tutor(String disciplina, int proficiencia, Aluno aluno) {
		if (Validador.validaTexto(disciplina) && Validador.validaProficiencia(proficiencia)) {
			this.proficiencia = proficiencia;
			this.disciplina = disciplina;
		}
		this.salario = 0;
		this.locaisDeAtendimento = new HashSet<>();
		this.horariosDeAtendimento = new HashSet<>();
		this.aluno = aluno;

	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public int getProficiencia() {
		return proficiencia;
	}

	public void setProficiencia(int proficiencia) {
		// TODO: provavelmente essa logica seria alterada para uma média
		this.proficiencia = proficiencia;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	/**
	 * Cadastra um novo horario de atendimento para o tutor.
	 * 
	 * @param horario
	 *            Horario do atendimento
	 * @param dia
	 *            Dia do atendimento
	 */
	public void cadastrarHorario(String horario, String dia) {
		this.horariosDeAtendimento.add(new HorarioAtendimento(dia, horario));
	}

	/**
	 * Cadastra um novo local de atendimento para o tutor.
	 * 
	 * @param local
	 *            Local do atendimento
	 */
	public void cadastrarLocal(String local) {
		this.locaisDeAtendimento.add(local);
	}

	/**
	 * Consulta se o tutor possui um determinado local de atendimento.
	 * 
	 * @param local
	 *            Local de atendimento
	 * @return um <code>boolean</boolean> que informa se o tutor possui ou nao o
	 *         local de atendimento
	 */
	public boolean consultaLocal(String local) {
		return this.locaisDeAtendimento.contains(local);
	}

	/**
	 * Consulta se o tutor possui um determinado horario de atendimento.
	 * 
	 * @param horario
	 *            Horario de atendimento
	 * @param dia
	 *            Dia de atendimento
	 * @return um <code>boolean</boolean> que informa se o tutor possui ou nao o
	 *         horario de atendimento
	 */
	public boolean consultaHorario(String horario, String dia) {
		return this.horariosDeAtendimento.contains(new HorarioAtendimento(dia, horario));
	}

	public String getMatricula() {
		return this.aluno.getMatricula();
	}

	public String getNome() {
		return this.aluno.getNome();
	}

	public String getTelefone() {
		return this.aluno.getTelefone();
	}

	public String getEmail() {
		return this.aluno.getEmail();
	}

	public String getCodCurso() {
		return this.aluno.getCodCurso();
	}

	public int getNotaAvaliacao() {
		return this.aluno.getNotaAvaliacao();
	}

	public void setNotaAvaliacao(int notaAvaliacao) {
		aluno.setNotaAvaliacao(notaAvaliacao);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + proficiencia;
		long temp;
		temp = Double.doubleToLongBits(salario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tutor other = (Tutor) obj;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (proficiencia != other.proficiencia)
			return false;
		if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
			return false;
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return this.disciplina + " - " + this.proficiencia + " - " + this.salario;
	}

}
