package tutor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

import aluno.Aluno;
import util.AlunoValidador;
import util.ErroController;
import util.TutorValidador;

/**
 * Controller dos tutores do sistema.
 * 
 * @author Marcus Vinicius
 */
public class TutorController {

	/**
	 * Conjunto de tutores que o sistema possui. Possui como chave o email do tutor,
	 * e como chave o objeto do tutor.
	 */
	private Map<String, Tutor> tutores;

	/**
	 * Construtor da classe.
	 */
	public TutorController() {
		this.tutores = new HashMap<String, Tutor>();
	}

	/**
	 * Cadastra um novo tutor no sistema.
	 * 
	 * @param disciplina
	 *            Disciplina que ele dara tutoria
	 * @param proficiencia
	 *            Proficiencia na disciplina que ele dara tutoria
	 * @param aluno
	 *            Aluno que sera um tutor
	 */
	public void cadastraTutor(String disciplina, int proficiencia, Aluno aluno) {
		try{
			if(TutorValidador.validaTutor(disciplina, proficiencia, aluno)){
				Tutor tutor = new Tutor(disciplina, proficiencia, aluno);
				this.tutores.put(aluno.getEmail(), tutor);
			}
		}catch(IllegalArgumentException e){
			throw new IllegalArgumentException(ErroController.
					TORNA_TUTOR_INVALIDO.toString() + e.getMessage());
		}
		

	}

	/**
	 * Lista os tutores cadastrados no sistema
	 * 
	 * @return String uma representação textual dos tutores cadastrados no sistema.
	 */
	public String listarTutores() {
		
		List<Tutor> listaTutores = new ArrayList<Tutor>(this.tutores.values());
		Collections.sort(listaTutores);	
		
		String resultado = "";

		for (int i = 0; i < listaTutores.size(); i++) {
			Tutor tutor = listaTutores.get(i);
			
			if(i != 0){
				resultado += ", ";
			}
			
			resultado += tutor.toString();
		}

		return resultado;
	}

	/**
	 * Adiciona uma disciplina e sua proficiencia ao tutor.
	 * 
	 * @param email
	 *            Email do tutor
	 * @param disciplina
	 *            Disciplina que ele dara tutoria
	 * @param proficiencia
	 *            Proficiencia na disciplina que ele dara tutoria
	 */
	public void cadastraDisciplina(String email, String disciplina, int proficiencia) {
		try{
			if(this.validaTutor(email) && 
					TutorValidador.validaDisciplina(disciplina) &&
					TutorValidador.validaProficiencia(proficiencia)){
				
				this.tutores.get(email).addDisciplina(disciplina, proficiencia);
				
				
			}
		}catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErroController.
					TORNA_TUTOR_INVALIDO.toString() + e.getMessage());
		}catch (NoSuchElementException e) {
			throw new NoSuchElementException(ErroController.
					TORNA_TUTOR_INVALIDO.toString() + e.getMessage());
		}
	}

	/**
	 * Cadastra um novo horario de atendimento para um tutor.
	 * 
	 * @param email
	 *            Email do tutor
	 * @param horario
	 *            Horario do atendimento
	 * @param dia
	 *            Dia do atendimento
	 */
	public void cadastrarHorario(String email, String horario, String dia) {
		try{
			if(this.validaTutor(email) &&
					TutorValidador.validaHorarioDeAtendimento(horario, dia)){
				
				this.tutores.get(email).cadastrarHorario(horario, dia);
			
			}
		}catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErroController.
					CADASTRAR_HORARIO_INVALIDO.toString() + e.getMessage());
		}catch (NoSuchElementException e) {
			throw new NoSuchElementException(ErroController.
					CADASTRAR_HORARIO_INVALIDO.toString() + e.getMessage());
		}

	}

	/**
	 * Cadastra um novo local de atendimento para um tutor.
	 * 
	 * @param email
	 *            Email to tutor
	 * @param local
	 *            Local do atendimento
	 */
	public void cadastrarLocalDeAtendimento(String email, String local) {
		try{
			if(this.validaTutor(email) &&
					TutorValidador.validaLocalAtendimento(local)){
				
				this.tutores.get(email).cadastrarLocal(local);
			
			}
		}catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErroController.
					CADASTRAR_LOCAL_INVALIDO.toString() + e.getMessage());
		}catch (NoSuchElementException e) {
			throw new NoSuchElementException(ErroController.
					CADASTRAR_LOCAL_INVALIDO.toString() + e.getMessage());
		}

	}

	/**
	 * Consulta se um tutor possui um determinado horario de atendimento.
	 * 
	 * @param horario
	 *            Horario de atendimento
	 * @param dia
	 *            Dia de atendimento
	 * @return um <code>boolean</boolean> que informa se o tutor possui ou nao o
	 *         horario de atendimento
	 */
	public boolean consultaHorario(String email, String horario, String dia) {
		
		boolean resultado = false;

		try{
			if(!this.existeTutor(email)) {
				resultado = false;
			}else if(TutorValidador.validaHorarioDeAtendimento(horario, dia)){
			
				resultado = this.tutores.get(email).consultaHorario(horario, dia);
			
			}
		}catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErroController.
					CADASTRAR_HORARIO_INVALIDO.toString() + e.getMessage());
		}catch (NoSuchElementException e) {
			throw new NoSuchElementException(ErroController.
					CADASTRAR_HORARIO_INVALIDO.toString() + e.getMessage());
		}
		return resultado;

	}

	/**
	 * Consulta se um tutor possui um determinado local de atendimento.
	 * 
	 * @param local
	 *            Local de atendimento
	 * @return um <code>boolean</boolean> que informa se o tutor possui ou nao o
	 *         local de atendimento
	 */
	public boolean consultaLocal(String email, String local) {
		
		boolean resultado = false;
		try {
			
			if(!this.existeTutor(email)) {
				resultado = false;
			}else if(TutorValidador.validaLocalAtendimento(local)){
				
				resultado = this.tutores.get(email).consultaLocal(local);
				
			}
		}catch (IllegalArgumentException e) {
			throw new IllegalArgumentException(ErroController.
					CADASTRAR_HORARIO_INVALIDO.toString() + e.getMessage());
		}catch (NoSuchElementException e) {
			throw new NoSuchElementException(ErroController.
					CADASTRAR_HORARIO_INVALIDO.toString() + e.getMessage());
		}
		
		return resultado;

	}

	/**
	 * Veririca pelo email se um tutor esta cadastradado
	 * 
	 * @param email
	 *            Email do aluno
	 * @return um <code>boolean</code> que informa se o tutor esta cadastrado
	 */
	public boolean existeTutor(String email) {

		return this.tutores.containsKey(email);

	}

	/**
	 * Recupera um tutor pelo seu email.
	 * 
	 * @param email
	 *            Email do tutor
	 * @return uma <code>String</code> que representa o tutor
	 */
	public String recuperaTutor(String email) {
		String resultado = "";
		
		if(this.validaTutor(email)){
			resultado = this.tutores.get(email).toString();
		
		}
	
		return resultado;
	}
	
	private boolean validaTutor(String email){
		if(TutorValidador.validaEmail(email)){
			if(!this.existeTutor(email)){
				throw new NoSuchElementException(ErroController.
						TUTOR_NAO_CADASTRADO.toString());
			}
			
		}
		return true;
	}

}
