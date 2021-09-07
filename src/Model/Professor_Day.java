
package Model;

import Model.Professor_Timeslot;
import java.util.ArrayList;

public class Professor_Day {
    int no ;
    ArrayList<Professor_Timeslot> timeslots ; 

    public Professor_Day(int no, ArrayList<Professor_Timeslot> timeslots) {
        this.no = no;
        this.timeslots = timeslots;
    } 

    public Professor_Day() {
    }
    

    public Professor_Day(int totalSlots) {
        no =0;
        for (int i = 0; i < totalSlots; i++) {
            timeslots.add(new Professor_Timeslot());
        }
    }

    public int getNo() {
        return no;
    }

    public ArrayList<Professor_Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setTimeslots(ArrayList<Professor_Timeslot> timeslots) {
        this.timeslots = timeslots;
    }
    
    

    
    
    
}
