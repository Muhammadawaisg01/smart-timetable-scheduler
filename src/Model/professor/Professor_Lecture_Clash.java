

package Model.professor;

import java.util.ArrayList  ;   

public class Professor_Lecture_Clash    {   
    
    // program 
    private int professor_id ; 
    private int semester;
    private String section;
    private String room ;
    private int day_no;
    private int slot_no;
    private String course;
    private boolean isresolved; 
    private int lecture_no ; 

    public Professor_Lecture_Clash() {
        
    }
    
    
    
    
    
    
    
    
    // setters and getters section

    public int getProfessor_id() {
        return professor_id;
    }

    public int getSemester() {
        return semester;
    }

    public String getSection() {
        return section;
    }

    public String getRoom() {
        return room;
    }

    public int getDay_no() {
        return day_no;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public String getCourse() {
        return course;
    }

    public boolean isIsresolved() {
        return isresolved;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setDay_no(int day_no) {
        this.day_no = day_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setIsresolved(boolean isresolved) {
        this.isresolved = isresolved;
    }

    public int getLecture_no() {
        return lecture_no;
    }

    public void setLecture_no(int lecture_no) {
        this.lecture_no = lecture_no;
    }
    
    
    
    
    
    
    
}   // Main Class 
