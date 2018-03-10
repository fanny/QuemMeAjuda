package aluno;

import java.util.Comparator;

import util.Pessoa;

public class MatriculaComparator<T extends Pessoa> implements Comparator<T>{

	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return o1.getMatricula().compareTo(o2.getMatricula());
	}
}