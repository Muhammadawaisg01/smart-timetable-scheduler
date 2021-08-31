
package scheduler.pkg0;

public class Timeslot_for_Professor {

    String no ; 
    String duration ;
    String program ;
    String semester ;
    String section;
    String room ; 
    String course; 
    Boolean check;
    
    public Timeslot_for_Professor(String no, String duration, String section, String room, String course, Boolean check, String semester, String program) {
        this.no = no;
        this.duration = duration;
        this.section = section;
        this.room = room;
        this.course = course;
        this.check = check;
        this.semester = semester;
        this.program = program;
    }

    public Timeslot_for_Professor() {
    }
    
    
}
