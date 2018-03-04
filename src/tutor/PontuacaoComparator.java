package tutor;

import java.util.Comparator;

public class PontuacaoComparator implements Comparator<Tutor>{

	@Override
	public int compare(Tutor tutor1, Tutor tutor2) {
		
		int result = tutor1.getNotaAvaliacao().compareTo(tutor2.getNotaAvaliacao());
		
		return result * (-1);
	}

}