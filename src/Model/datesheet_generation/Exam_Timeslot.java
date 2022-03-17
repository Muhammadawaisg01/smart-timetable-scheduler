
package Model.datesheet_generation;

import Enums.Lab;


public class Exam_Timeslot {    
    
    
    int slot_no;
    String sectionid;
    String course_code ; 
    Lab lab ; 
    String professor_name;      // who is teaching the course

    public Exam_Timeslot() {
        
    }

    public Exam_Timeslot(int slot_no, String sectionid, String course_code, String professor_name) {
        this.slot_no = slot_no;
        this.sectionid = sectionid;
        this.course_code = course_code;
        this.professor_name = professor_name;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public String getSectionid() {
        return sectionid;
    }

    public void setSectionid(String sectionid) {
        this.sectionid = sectionid;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    public String getProfessor_name() {
        return professor_name;
    }

    public void setProfessor_name(String professor_name) {
        this.professor_name = professor_name;
    }
    
}   
