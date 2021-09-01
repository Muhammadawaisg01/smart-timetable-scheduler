

package scheduler.pkg0 ; 

import java.util.ArrayList ; 

public class Professor { 
    int id ; 
    String name ;
    ProfessorSchedule professorSchedule = new ProfessorSchedule();
//    ArrayList<Professor_Timeslot> clash_array ;

    public Professor(int id, String name, int workingDays) {
        this.id = id;
        this.name = name;
        for (int i = 0; i < workingDays; i++) {
            professorSchedule.day.add(new Day_for_Professor(6));
        }
    }
    public Professor() {
    }
    
    
}



