
package scheduler.pkg0;

public class Professor_Timeslot {

    int no ; 
    String program ;
    int semester ;
    String section;
    String room ; 
    String course; 
    Boolean check;
    
    public Professor_Timeslot(int no, String section, String room, String course, Boolean check, int semester, String program) {
        this.no = no;
        this.section = section;
        this.room = room;
        this.course = course;
        this.check = check;
        this.semester = semester;
        this.program = program;
    }

    public Professor_Timeslot() {
    }
    
    
}
