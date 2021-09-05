
package Model;

import Model.Professor_Timeslot;
import java.util.ArrayList;

public class Day_for_Professor {
    String no ;
    ArrayList<Professor_Timeslot> timeslots ; 

    public Day_for_Professor(String no, ArrayList<Professor_Timeslot> timeslots) {
        this.no = no;
        this.timeslots = timeslots;
    }
    

    public Day_for_Professor(int totalSlots) {
        no = "";
        for (int i = 0; i < totalSlots; i++) {
            timeslots.add(new Professor_Timeslot());
        }
    }
    
    

    
    
    
}
