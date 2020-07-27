
package individualprojectbrief.part1;


import java.util.List;
import java.util.Objects;


public class StudentsInCourse {
    private List<Student>students;
    private List<Trainer>trainers;
    private List<Assignment>assignments;
    
     public StudentsInCourse (List<Student>students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
    
  

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.students);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final StudentsInCourse other = (StudentsInCourse) obj;
        return true;
    }

    @Override
    public String toString() {
        return "StudentsInCourse{" + "students=" + students + '}';
    }
    

}

