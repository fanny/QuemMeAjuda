package util.comparators;

import java.util.Comparator;

public class MatriculaComparator<T extends Pessoa> implements Comparator<T>{

	@Override
	public int compare(T o1, T o2) {
		return o1.getMatricula().compareTo(o2.getMatricula());
	}
}