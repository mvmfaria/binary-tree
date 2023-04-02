public class Student implements Comparable<Student>{
    private String name;
    private int registration;
    private int grade;
    
    
    public Student(int registration ,String name, int grade){
        this.name = name;
        this.registration = registration;
        this.grade = grade;
    }
    
    @Override
    public boolean equals(Object a){
        if (a instanceof Student)
            return this.registration==((Student)a).registration;
        else
            return false;
    }
    
    @Override
    public int compareTo(Student a) {
        /* if (this.registration < a.registration)
            return -1;
        else
            if (this.registration > a.registration)
                return 1;
                else return 0;*/
        
        return Integer.compare(this.registration, a.registration);
        
    }

    /**
     * @return the name
     */
    public String getname() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setname(String name) {
        this.name = name;
    }

    /**
     * @return the registration
     */
    public int getRegistration() {
        return registration;
    }

    /**
     * @param registration the registration to set
     */
    public void setRegistration(int registration) {
        this.registration = registration;
    }

    /**
     * @return the grade
     */
    public int getgrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setgrade(int grade) {
        this.grade = grade;
    }
    
    public String toString(){
        return Integer.toString(registration);
    }
}
