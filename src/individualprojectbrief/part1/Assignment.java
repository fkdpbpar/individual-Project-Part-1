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
public class Assignment {

    private String title;
    private String description;
    private int totalMark;
    private String subDateTime;
    

    public Assignment() {

    }

    public String getSubDateTime() {
        return subDateTime;
    }

    public void setSubDateTime(String subDateTime) {
        this.subDateTime = subDateTime;
    }

    public Assignment(String title, String description, int totalMark, String subDateTime) {
        this.title = title;
        this.description = description;
        this.totalMark = totalMark;
        this.subDateTime = subDateTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void setAssignmentDetails(String title, String description, int totalMark, String subDateTime) {
        setTitle(title);
        setDescription(description);
        setTotalMark(totalMark);
        setSubDateTime(subDateTime);

    }

    @Override
    public String toString() {
        return "Assignment{" + "title=" + title + ", description=" + description + ", totalMark=" + totalMark + ", subDateTime=" + subDateTime + '}';
    }

  

    

}
