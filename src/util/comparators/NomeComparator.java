package util.comparators;

import java.util.Comparator;

public class NomeComparator<T extends Pessoa> implements Comparator<T>{

	@Override
	public int compare(T o1, T o2) {
		
		if(o1.getNome().compareTo(o2.getNome()) == 0) {
			o1.getMatricula().compareTo(o2.getMatricula());
		}
		
		return o1.getNome().compareTo(o2.getNome());
	}

	
}
