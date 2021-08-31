

package scheduler.pkg0 ; 

import java.util.ArrayList ; 

public class Professor { 
    int id ; 
    String name ; 
    ArrayList<Day_for_Professor> days ; 
    
    ArrayList<Professor_Timeslot> clash_array ; 
    
    public Professor(int id, String name, ArrayList<Day_for_Professor> days) {
        this.id = id;
        this.name = name;
        this.days = days;
    }

    public Professor() {
    }
    
    
    
}



