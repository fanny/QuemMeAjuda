package tutor;

import java.util.Comparator;

public class PontuacaoComparator implements Comparator<Tutor>{

	@Override
	public int compare(Tutor tutor1, Tutor tutor2) {
		
		int result = (int) tutor1.getNotaAvaliacao() - tutor2.getNotaAvaliacaoAluno();
		
		return result * (-1);
	}

}