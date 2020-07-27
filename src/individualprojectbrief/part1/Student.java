/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrief.part1;

/**
 *
 * @author 30694
 */
public class Student {

    private String firstName;
    private String lastName;
    private int tuitionFees;
    private String dateOfBirth;

    public Student() {
   
    }
    
    public Student(String firstName, String lastName, String course, String dateOfBirth){
        
    }

    Student(String giorgos, String arvanitis, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Student(String firstName, String lastName, int tuitionFees, String dateOfBirth) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.tuitionFees=tuitionFees;
        this.dateOfBirth=dateOfBirth;
    }

    

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastNAme() {
        return lastName;
    }

    public void setFees(int tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    public int getFees() {
        return tuitionFees;
    }
    public void setStudentDetails(String firstName, String lastName, int tuitionFees, String dateOfBirth){
        setFirstName(firstName);
        setLastName(lastName);
        setFees(tuitionFees);
        setDateOfBirth(dateOfBirth);
      
}  

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", tuitionFees=" + tuitionFees + ", dateOfBirth=" + dateOfBirth + '}';
    }

    
    
}
