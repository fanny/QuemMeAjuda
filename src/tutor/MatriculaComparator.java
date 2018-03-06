package tutor;

import java.util.Comparator;

public class MatriculaComparator implements Comparator<Tutor>{

	@Override
	public int compare(Tutor t1, Tutor t2) {
		return t1.getMatricula().compareTo(t2.getMatricula());
	}
}