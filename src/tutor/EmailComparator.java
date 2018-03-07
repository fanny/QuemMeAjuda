package tutor;

import java.util.Comparator;

public class EmailComparator implements Comparator<Tutor>{

	@Override
	public int compare(Tutor t1, Tutor t2) {
		if(t1.getEmail().compareTo(t2.getEmail()) == 0) {
			t1.getMatricula().compareTo(t2.getMatricula());
		}
		
		return t1.getEmail().compareTo(t2.getEmail());
	}
}