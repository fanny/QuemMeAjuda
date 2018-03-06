package aluno;

import java.util.Comparator;

public class EmailComparator implements Comparator<Aluno>{

	@Override
	public int compare(Aluno a1, Aluno a2) {
		return a1.getEmail().compareTo(a2.getEmail());
	}
}