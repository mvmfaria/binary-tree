package library;
import java.util.Comparator;

public class StudentNameComparator implements Comparator<Student>{
    @Override
    public int compare(Student obj0, Student obj1) {
        return obj0.getName().compareTo(obj1.getName());
    }
}   
