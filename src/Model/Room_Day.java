
package Model;

import Model.Room_Timeslot;
import java.util.ArrayList;
import static db.DBConnection.getConnection;
public class Room_Day {  
    
    public int no  ; 
    public ArrayList<Room_Timeslot> timeslots ; 
    
    public Room_Day( int no, ArrayList<Room_Timeslot> timeslots ) { 
        this.no = no ; 
        this.timeslots = timeslots ; 
    } 

    public Room_Day() {
    }
    
    @Override
    public String toString() {
        return "Day{" + "No=" + no + ", timeslots=" + timeslots + '}';
    } 

    public int getNo() {
        return no;
    }

    public ArrayList<Room_Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setTimeslots(ArrayList<Room_Timeslot> timeslots) {
        this.timeslots = timeslots;
    }
    
//    public static 
    
} 




