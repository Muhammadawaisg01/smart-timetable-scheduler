package Model.semester;

import Enums.Lecture;
import Enums.Priority;

public class Section_Timeslot {

    private int slot_no;
    private String room;
    String course_code;
    private int lecture_no;
    private boolean isLab;
    private boolean check;          // this check is for checking that is this slot is available or not 

    Priority priority;
    Lecture lecture;

    public Section_Timeslot() {

    }

    public Section_Timeslot(String room, int slot_no, String course_code, int lecture_no, boolean check) {
        this.room = room;
        this.slot_no = slot_no;
        this.course_code = course_code;
        this.lecture_no = lecture_no;
        this.check = check;
    }

    public Section_Timeslot(int slot_no, String room, String course_code, int lecture_no, boolean check) {
        this.slot_no = slot_no;
        this.room = room;
        this.course_code = course_code;                         // new constructor  
        this.lecture_no = lecture_no;
        this.priority = null;
        this.lecture = null;
        this.check = check;
    }

    @Override
    public String toString() {
        return "Section_Timeslot{" + "slot_no=" + slot_no + ", room=" + room + ", course_code=" + course_code + ", lecture_no=" + lecture_no + ", check=" + check + ", priority=" + priority + ", lecture=" + lecture + '}';
    }

    // setters and getters section
    public String getRoom() {
        return room;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public String getCourse() {
        return course_code;
    }

    public int getLecture_no() {
        return lecture_no;
    }

    public boolean isCheck() {
        return check;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public void setCourse(String course_code) {
        this.course_code = course_code;
    }

    public void setLecture_no(int lecture_no) {
        this.lecture_no = lecture_no;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Lecture getLecture() {
        return lecture;
    }

    public void setLecture(Lecture lecture) {
        this.lecture = lecture;
    }

    public boolean isLab() {
        return isLab;
    }

    public void setIsLab(boolean isLab) {
        this.isLab = isLab;
    }
    

}
