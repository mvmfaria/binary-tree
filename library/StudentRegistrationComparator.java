package library;
import java.util.Comparator;

public class StudentRegistrationComparator implements Comparator<Student>{
    @Override
    public int compare(Student obj0, Student obj1) {
        return Integer.compare(obj0.getRegistration(), obj1.getRegistration());
    }
}   
