package comparators;
import java.util.Comparator;

import users.Student;

public class GpaComparator implements Comparator<Student> {
    public int compare(Student s1, Student s2) {
    	if(s1.viewTranscript().getGpa() > s2.viewTranscript().getGpa())
            return 1;
        else if(s1.viewTranscript().getGpa() < s1.viewTranscript().getGpa())
            return -1;
        else
            return 0;
    }
}
         

