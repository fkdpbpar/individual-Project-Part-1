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
public class Course {

    private String title;
    private String stream;
    private String type;
    private String startDate;
    private String endDate;

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    

    public Course() {
    
    
    }
   

    public Course(String title, String stream, String type, String startDate, String endDate) {
        this.title=title;
        this.stream=stream;
        this.type=type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

   

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getStream() {
        return stream;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
    public void setCourseDetails(String title, String stream, String type, String startDate, String endDate){
        this.title=title;
        this.stream=stream;
        this.type=type;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", stream=" + stream + ", type=" + type + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
   

    
    
}
