package tutor;

import java.util.Comparator;

public class NomeComparator implements Comparator<Tutor>{

	@Override
	public int compare(Tutor t1, Tutor t2) {
		return t1.getNome().compareTo(t2.getNome());
	}
}
