package tutor;

import java.util.Comparator;

public class EmailComparator implements Comparator<Tutor>{

	@Override
	public int compare(Tutor t1, Tutor t2) {
		return t1.getEmail().compareTo(t2.getEmail());
	}
}