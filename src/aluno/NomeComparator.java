package aluno;

import java.util.Comparator;

public class NomeComparator implements Comparator<Aluno>{

	@Override
	public int compare(Aluno a1, Aluno a2) {
		if(a1.getNome().compareTo(a2.getNome()) == 0) {
			a1.getMatricula().compareTo(a2.getMatricula());
		}
		
		return a1.getNome().compareTo(a2.getNome());
	}
}
