package testes;

import org.junit.*;

import tutor.HorarioAtendimento;

public class HorarioAtendimentoTeste {
	
	private HorarioAtendimento hr;

	@Before
	public void testHorarioAtendimento() {
		hr = new HorarioAtendimento("Quinta-Feira", "14:00");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHorarioAtendimentoComDiaNulo() {
		hr = new HorarioAtendimento(null, "14:00");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHorarioAtendimentoComDiaVazio() {
		hr = new HorarioAtendimento("", "14:00");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHorarioAtendimentoComHorarioNulo() {
		hr = new HorarioAtendimento("Quinta-Feira", null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHorarioAtendimentoComHorarioVazio() {
		hr = new HorarioAtendimento("Quinta-Feira", "");
	}

}
