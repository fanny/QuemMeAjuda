package model;

/**
 * Representação de um horário de atendimento de um tutor
 * @author fanny
 *
 */
public class HorarioAtendimento {
	
	private String dia;
	private String horario;
	
	public HorarioAtendimento(String dia, String horario){
		this.dia = dia;
		this.horario = horario;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	@Override
	public String toString() {
		return  dia + " - " + horario;
	}
	
	
	
	
	
}
