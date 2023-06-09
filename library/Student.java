package library;
public class Student implements Comparable<Student>{
    private String name;
    private int registration;
    private int grade;
    
    public Student(int registration, String name, int grade){
        this.name = name;
        this.registration = registration;
        this.grade = grade;
    }

    public Student(String name){
        this.name = name;
    }
    
    public Student(int registration) {
        this.registration = registration;
    }
    
    @Override
    public boolean equals(Object a){
        if (a instanceof Student)
            return this.registration==((Student)a).registration;
        else
            return false;
    }
    
    @Override
    public int compareTo(Student a){
        return Integer.compare(this.registration, a.registration);
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getRegistration(){
        return registration;
    }

    public void setRegistration(int registration){
        this.registration = registration;
    }

    public int getGrade(){
        return grade;
    }

    public void setGrade(int grade){
        this.grade = grade;
    }
    
    public String toString(){
        // return Integer.toString(registration);
        return name;
    }
}
