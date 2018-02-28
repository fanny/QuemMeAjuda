package tutor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import aluno.Aluno;
import util.TutorValidador;

/**
 * Representação de um orientador de um aluno
 * 
 * @author fanny
 */
public class Tutor {

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
	 * A referência do aluno que o tutor é.
	 */
	private Aluno aluno;

	/**
	 * Disciplinas as quais o tutor tutora e suas respectivas proficiencias.
	 */
	private Map<String, Integer> disciplinas;

	/**
	 * Constutor usado para inicializar a disciplina e a proficiência do mentor
	 * 
	 * @param disciplina
	 *            A matéria na qual o tutor domina
	 * @param proficiencia
	 *            Indica o nível de conhecimento do tuto
	 */
	public Tutor(String disciplina, int proficiencia, Aluno aluno) {
		if (TutorValidador.validaTutor(disciplina, proficiencia, aluno)) {

			this.disciplinas = new HashMap<>();
			this.addDisciplina(disciplina, proficiencia);
			
			this.salario = 0;
			this.locaisDeAtendimento = new HashSet<>();
			this.horariosDeAtendimento = new HashSet<>();
			this.aluno = aluno;

		}
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
		if(TutorValidador.validaHorarioDeAtendimento(horario, dia)){
			this.horariosDeAtendimento.add(new HorarioAtendimento(dia, horario));
		}
	}

	/**
	 * Cadastra um novo local de atendimento para o tutor.
	 * 
	 * @param local
	 *            Local do atendimento
	 */
	public void cadastrarLocal(String local) {
		if(TutorValidador.validaLocalAtendimento(local)){
			this.locaisDeAtendimento.add(local);
		}
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
		boolean resultado = false;
		if(TutorValidador.validaLocalAtendimento(local)){
			resultado = this.locaisDeAtendimento.contains(local);
		}
		return resultado;
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
		boolean resultado = false;
		if(TutorValidador.validaHorarioDeAtendimento(horario, dia)){
			resultado =  this.horariosDeAtendimento.contains(new 
					HorarioAtendimento(dia, horario));
		}
		return resultado;
	}

	/**
	 * Adiciona uma disciplina ao tutor
	 * 
	 * @param nome
	 * @param proficiencia
	 */
	public void addDisciplina(String nome, Integer proficiencia) {
		if(TutorValidador.validaDisciplina(nome) && 
				TutorValidador.validaProficiencia(proficiencia)){
			this.disciplinas.put(nome, proficiencia);
		}
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

	public int getCodCurso() {
		return this.aluno.getCodCurso();
	}

	public int getNotaAvaliacao() {
		return this.aluno.getNotaAvaliacao();
	}

	public void setNotaAvaliacao(int notaAvaliacao) {
		aluno.setNotaAvaliacao(notaAvaliacao);
	}

	@Override
	public String toString() {
		return this.aluno.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((disciplinas == null) ? 0 : disciplinas.hashCode());
		result = prime * result + ((horariosDeAtendimento == null) ? 0 : horariosDeAtendimento.hashCode());
		result = prime * result + ((locaisDeAtendimento == null) ? 0 : locaisDeAtendimento.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Tutor other = (Tutor) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (disciplinas == null) {
			if (other.disciplinas != null)
				return false;
		} else if (!disciplinas.equals(other.disciplinas))
			return false;
		if (horariosDeAtendimento == null) {
			if (other.horariosDeAtendimento != null)
				return false;
		} else if (!horariosDeAtendimento.equals(other.horariosDeAtendimento))
			return false;
		if (locaisDeAtendimento == null) {
			if (other.locaisDeAtendimento != null)
				return false;
		} else if (!locaisDeAtendimento.equals(other.locaisDeAtendimento))
			return false;
		if (Double.doubleToLongBits(salario) != Double.doubleToLongBits(other.salario))
			return false;
		return true;
	}

}
