package aluno;

import java.util.Comparator;

public class EmailComparator implements Comparator<Aluno>{

	@Override
	public int compare(Aluno a1, Aluno a2) {
		if(a1.getEmail().compareTo(a2.getEmail()) == 0) {
			a1.getMatricula().compareTo(a2.getMatricula());
		}
		
		return a1.getEmail().compareTo(a2.getEmail());
	}
}