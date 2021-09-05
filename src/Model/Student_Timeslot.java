
package Model ; 

public class Student_Timeslot { 
    
//    String program;
    int semester;
    String section;
    int slot_no;
    String course;
    int lecture_no ; 
    boolean check;
    String room;
    
    public Student_Timeslot() {
        
    }

    public Student_Timeslot(int semester, String section, int slot_no, String course, int lecture_no, boolean check, String room) {
        this.semester = semester;
        this.section = section;
        this.slot_no = slot_no;
        this.course = course;
        this.lecture_no = lecture_no;
        this.check = check;
        this.room = room;
    }

    @Override
    public String toString() {
        return "Student_Timeslot{" + "semester=" + semester + ", section=" + section + ", slot_no=" + slot_no + ", course=" + course + ", lecture_no=" + lecture_no + ", check=" + check + ", room=" + room + '}';
    }
    
    
}// main class

