package tutor;

/**
 * Representação de um horário de atendimento de um tutor
 * 
 * @author fanny
 */
public class HorarioAtendimento {

	/**
	 * O dia do atendimento
	 */
	private String dia;

	/**
	 * O horário do atendimento
	 */
	private String horario;

	/**
	 * Constrói um horário de atendimento a partir do dia e do horário do
	 * atendimento
	 * 
	 * @param dia
	 *            Dia do atendimento
	 * @param horario
	 *            Horário do atendimento
	 */
	public HorarioAtendimento(String dia, String horario) {
		
		if(true) {
			
		}
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

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return dia + " - " + horario;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dia == null) ? 0 : dia.hashCode());
		result = prime * result + ((horario == null) ? 0 : horario.hashCode());
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
		HorarioAtendimento other = (HorarioAtendimento) obj;
		if (dia == null) {
			if (other.dia != null)
				return false;
		} else if (!dia.equals(other.dia))
			return false;
		if (horario == null) {
			if (other.horario != null)
				return false;
		} else if (!horario.equals(other.horario))
			return false;
		return true;
	}
}
