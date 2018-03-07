package tutor;

import java.util.Comparator;

public class NomeComparator implements Comparator<Tutor>{

	@Override
	public int compare(Tutor t1, Tutor t2) {
		if(t1.getNome().compareTo(t2.getNome()) == 0) {
			t1.getMatricula().compareTo(t2.getMatricula());
		}
		
		return t1.getNome().compareTo(t2.getNome());
	}
}
