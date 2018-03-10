package util.comparators;

import java.util.Comparator;

import tutor.Tutor;

public class PontuacaoComparator implements Comparator<Tutor>{

	@Override
	public int compare(Tutor tutor1, Tutor tutor2) {
		
		int result = (int) (tutor1.getNotaAvaliacao() - tutor2.getNotaAvaliacaoAluno());
		
		return result * (-1);
	}

}