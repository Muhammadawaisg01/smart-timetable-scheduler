
package Model;

import Model.TimeSlot;
import java.util.ArrayList;

public class Day {  
    
    public int no  ; 
    public ArrayList<TimeSlot> timeslots ; 
    
    public Day( int no, ArrayList<TimeSlot> timeslots ) { 
        this.no = no ; 
        this.timeslots = timeslots ; 
    } 

    public Day() {
    }
    
    @Override
    public String toString() {
        return "Day{" + "No=" + no + ", timeslots=" + timeslots + '}';
    } 

    public int getNo() {
        return no;
    }

    public ArrayList<TimeSlot> getTimeslots() {
        return timeslots;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setTimeslots(ArrayList<TimeSlot> timeslots) {
        this.timeslots = timeslots;
    }
    
    
} 




