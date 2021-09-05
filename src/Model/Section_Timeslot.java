

package Model ; 

public class Section_Timeslot {
    
    String room;
    int slot_no;
    String course;
    int lecture_no;
    boolean check; 
    
    public Section_Timeslot() { 
        
    }

    public Section_Timeslot(String room, int slot_no, String course, int lecture_no, boolean check) {
        this.room = room;
        this.slot_no = slot_no;
        this.course = course;
        this.lecture_no = lecture_no;
        this.check = check;
    }
}
