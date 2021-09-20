

package Model   ;   

public class Professor_Timeslot {   

    int slot_no ; 
    String program ;
    int semester ;
    String section;
    String room ; 
    String course_code; 
    Boolean check;
    int lecture_no;

    public Professor_Timeslot(int no, int semester, String section, String room, String course_code, Boolean check) {
        this.slot_no = no;
        this.section = section;
        this.room = room;
        this.course_code = course_code;
        this.check = check;
        this.semester = semester;
//        this.program = program;
    } 

    public Professor_Timeslot() {
        slot_no = 0;
//        program = "";
        semester = 0;
        room = "";
        course_code = "";
        check = false;
    }

    public int getSlot_No() {
        return slot_no;
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

    public String getCourse_code() {
        return course_code;
    }

    public Boolean getCheck() {
        return check;
    }

    public void setSlot_No(int no) {
        this.slot_no = no;
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

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public void setCheck(Boolean check) {
        this.check = check;
    }
    
    
}
