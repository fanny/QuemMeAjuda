package tutor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import aluno.Aluno;
import util.comparators.Pessoa;
import util.controller.ErroController;
import util.tutor.MensagemTutor;
import util.tutor.TutorValidador;

/**
 * Representação de um orientador de um aluno
 * 
 * @author fanny
 */
public class Tutor implements Pessoa {

	/**
	 * Nota de avaliação do tutor
	 */
	private double notaAvaliacao;

	/**
	 * Nível do tutor
	 */
	private String nivel;

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
	 * Atributo que guarda o valor das doações destinadas ao tutor
	 */
	private int doacoes;
	
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
			this.notaAvaliacao = 4.0;
			this.nivel = MensagemTutor.TUTOR.toString();
			this.salario = 0;
			this.locaisDeAtendimento = new HashSet<>();
			this.horariosDeAtendimento = new HashSet<>();
			this.aluno = aluno;
			this.doacoes = 0;
		}
	}


	/**
	 * Altera a avaliação geral do tutor a partir de uma nova nota.
	 * 
	 * @param notaAvaliacao a nota da avaliação
	 */
	public void alteraNotaAvaliacao(int notaAvaliacao) {
		if (TutorValidador.validaNotaAvaliacao(notaAvaliacao)) {
			this.notaAvaliacao = (this.notaAvaliacao * 5 + notaAvaliacao) / 6.0;
			this.defineNivel();
		}
	}

	public double getNotaAvaliacao() {
		return this.notaAvaliacao;
	}
	
	

	public double calculaTaxaDoacaoTutor() {

		double taxa = 0;
		

		if (this.nivel.equals(MensagemTutor.TOP.toString())) {
	
			taxa = (0.9 + ((this.notaAvaliacao - 4.5) * 0.01));
	

		} else if (this.nivel.equals(MensagemTutor.TUTOR.toString())) {

			taxa = 0.8;

		} else {
			
			taxa = (0.4 - ((3 - this.notaAvaliacao) * 0.1));
		
		}
		return taxa;
	}
	
	
	public double getSalario() {
		return salario;
	}
	
	public void receberDoacao(int doacoes) {
		
		this.doacoes += doacoes;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getNivel() {
		return nivel;
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
		if (TutorValidador.validaHorarioDeAtendimento(horario, dia)) {
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
		if (TutorValidador.validaLocalAtendimento(local)) {
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
		if (TutorValidador.validaLocalAtendimento(local)) {
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
		if (TutorValidador.validaHorarioDeAtendimento(horario, dia)) {
			resultado = this.horariosDeAtendimento.contains(new HorarioAtendimento(dia, horario));
		}
		return resultado;
	}

	/**
	 * Adiciona uma disciplina ao tutor
	 * 
	 * @param nome o nome da disciplina
	 * @param proficiencia a proficiencia do tutor na disciplina
	 */
	public void addDisciplina(String nome, Integer proficiencia) {
		if (TutorValidador.validaDisciplina(nome) && TutorValidador.validaProficiencia(proficiencia)) {
			if (disciplinaExiste(nome)) {
				throw new IllegalArgumentException(ErroController.JA_EH_TUTOR.toString());
			}
			this.disciplinas.put(nome, proficiencia);
		}
	}

	/**
	 * Define o nível do tutor com base na sua avaliação geral
	 */
	private void defineNivel() {
		if (this.notaAvaliacao <= 3) {
			this.nivel = MensagemTutor.APRENDIZ.toString();
		} else if (this.notaAvaliacao <= 4.5) {
			this.nivel = MensagemTutor.TUTOR.toString();
		} else {
			this.nivel = MensagemTutor.TOP.toString();
		}
	}

	/**
	 * Verifica se o tutor já possui a disciplina
	 * 
	 * @param nome o nome da disciplina
	 */
	public boolean disciplinaExiste(String nome) {
		return this.disciplinas.containsKey(nome);
	}

	@Override
	public String getMatricula() {
		return this.aluno.getMatricula();
	}

	@Override
	public String getNome() {
		return this.aluno.getNome();
	}

	public String getTelefone() {
		return this.aluno.getTelefone();
	}

	@Override
	public String getEmail() {
		return this.aluno.getEmail();
	}

	public int getCodCurso() {
		return this.aluno.getCodCurso();
	}
	public int getDoacao() {
		return this.doacoes;
	}

	public double getNotaAvaliacaoAluno() {
		return this.notaAvaliacao;
	}
	
	public void setNotaAvaliacaoAluno(int notaAvaliacao) {
		this.aluno.setNotaAvaliacao(notaAvaliacao);
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