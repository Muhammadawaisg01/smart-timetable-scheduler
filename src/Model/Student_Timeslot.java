

package Model ; 

import Enums.Lecture;

public class Student_Timeslot {     

    
    int slot_no;
    int program;
    int semester;
    String section;
    String room;
    String course_code;
    boolean isLab ;             // check that lecture is of lab or theory
    int lecture_no ;            // lecture number is for lecture of the course i.e. first or second or third    
    boolean check;   
    
    Lecture lecture ;
    
    public Student_Timeslot() {
        
    }
    public Student_Timeslot(int slot_no , int semester, String section , String course, int lecture_no, boolean check, String room, boolean isLab) {     
        this.slot_no = slot_no;
        this.semester = semester;
        this.section = section;
        this.course_code = course;
        this.lecture_no = lecture_no;
        this.check = check;
        this.room = room;
        this.isLab = isLab;
    }
    
    public Student_Timeslot(int slot_no ,int program, int semester, String section , String room, 
        String course_code, int lecture_no , boolean check) {                      // this constructor to be use now    
        
        this.slot_no = slot_no;
        this.program = program;
        this.semester = semester;
        this.section = section;
        this.room = room;
        this.course_code = course_code;
        this.lecture_no = lecture_no;
        this.lecture = null ; 
        this.check = check;
    }
    

    @Override
    public String toString() {
        return "Student_Timeslot{" + "semester=" + semester + ", section=" + section + ", slot_no=" + slot_no + ", course=" + course_code + ", lecture_no=" + lecture_no + ", check=" + check + ", room=" + room + '}';
    }
    
    
    // getters and setters

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public int getLecture_no() {
        return lecture_no;
    }

    public void setLecture_no(int lecture_no) {
        this.lecture_no = lecture_no;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public boolean isIsLab() {
        return isLab;
    }

    public void setIsLab(boolean isLab) {
        this.isLab = isLab;
    }
    public int getProgram() {
        return program;
    }

    public void setProgram(int program) {
        this.program = program;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }
    
    
}// main class

