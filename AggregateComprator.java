package practice.comparators;

import java.util.Comparator;

import practice.collectionpojos.Student;

public class AggregateComprator implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		if(o1.getAgg()<o2.getAgg())
			return 1;
		else if(o1.getAgg()>o2.getAgg())
			return -1;
		else
			return 0;
	}

}
