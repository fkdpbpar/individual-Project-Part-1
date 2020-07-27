/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package individualprojectbrief.part1;

import java.util.ArrayList;

/**
 *
 * @author 30694
 */
public class Trainer {

    private String firstName;
    private String lastName;
    private String subject;
    

 

 
    public Trainer() {
    
    }

    public Trainer(String firstName, String lastName, String subject) {
        this.firstName=firstName;
        this.lastName=lastName;
        this.subject=subject;
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

    public String getLastName() {
        return lastName;
    }
      public void setTrainerDetails(String firstName, String lastName){
        setFirstName(firstName);
        setLastName(lastName);
      
}  

    @Override
    public String toString() {
        return "Trainer{" + "firstName=" + firstName + ", lastName=" + lastName + ", subject=" + subject + '}';
    }
      
    }
