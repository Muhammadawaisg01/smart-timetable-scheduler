
package Model.room;

import Enums.Lab;

public class Room_ExamTimeslot {
    
    private int slot_no;
    private String sectionid;
    private String course_code ; 
    private Lab lab ; 
    private int professor_id;      // who is teaching the course
    private boolean check ; 
    
    
    public Room_ExamTimeslot() {
        
    }

    public Room_ExamTimeslot(int slot_no, boolean check) {
        this.slot_no = slot_no;
        this.check = check;
    }

    public Room_ExamTimeslot(int slot_no, String sectionid, String course_code, int professor_id, boolean check) {
        this.slot_no = slot_no;
        this.sectionid = sectionid;
        this.course_code = course_code;
        this.professor_id = professor_id;
        this.check = check;
    }
    
    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
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

    public int getProfessor_id() {
        return professor_id;
    }

    public void setProfessor_id(int professor_id) {
        this.professor_id = professor_id;
    }

 
    
    
}
