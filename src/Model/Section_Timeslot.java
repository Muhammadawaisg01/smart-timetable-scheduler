

package Model ; 

public class Section_Timeslot { 
 
    int slot_no;    
    String room;
    String course_code;
    int lecture_no;    
    boolean isLab;
    boolean check;          // this check is for checking that is this slot is available or not 
    
    
    public Section_Timeslot() {
        
    }

    public Section_Timeslot(String room, int slot_no, String course_code, int lecture_no, boolean check) {
        this.room = room;
        this.slot_no = slot_no;
        this.course_code = course_code;
        this.lecture_no = lecture_no;
        this.check = check;
    }
    
    
   
    @Override
    public String toString() {
        return "Section_Timeslot{" + "room=" + room + ", slot_no=" + slot_no + ", course=" + course_code + ", lecture_no=" + lecture_no + ",check=" + check + '}';     
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
    
    
    
    
}
