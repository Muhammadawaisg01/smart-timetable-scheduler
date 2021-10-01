
package Model;

import java.util.ArrayList;
import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Room {     

    String name;
    int capacity;
    boolean isFull;
    boolean isLab;

//    ArrayList<Course> specific_courses =  new ArrayList<>() ; 
    
    
    ArrayList<Room_Day> days;
    
    public Room( String name, boolean isFull, ArrayList<Room_Day> days ) {
        this.name = name;
        this.isFull = isFull;
        this.days = days;   
    }   
    
    public Room() {     

    }

    public String getName() {
        return name;
    }

    public boolean isCheck() {
        return isFull;
    }

    public ArrayList<Room_Day> getDays() {
        return days;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCheck(boolean check) {
        this.isFull = check;
    }

    public void setDays(ArrayList<Room_Day> days) {
        this.days = days;
    }

    public boolean isIsLab() {
        return isLab;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setIsLab(boolean isLab) {
        this.isLab = isLab;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    

//    public static int check_fitness(Room_Day day) 
//    { 
//        int var = 0  ; 
//        for(int i = 0 ; i < day.timeslots.length ; i++) 
//        {
//            if(day.timeslots[i].check== false ) 
//            {
//                var++ ; 
//            }
//        }
//        return var ; 
//    }
    @Override
    public String toString() {

        return "Room{" + "name=" + name + ", check=" + isFull + ", days=" + days + '}';
//            for(int i = 0 ; i < this.days.size(); i++) 
//            {
//                System.out.println(this.days.get(i).name+"\t\t") ; 
//                for(int j = 0 ; j < this.days.get(i).timeslots.size() ; j++) 
//                { 
//                    System.out.println(this.days.get(i).name) ; 
//                    System.out.println(this.days.get(i).timeslots.get(j).no +"   "+this.days.get(i).timeslots.get(j).check ) ; 
//                }
//                System.out.println("") ; 
//            }
    }

    public void display() {
        System.out.println("Room" + "name=" + name + ", check=" + isFull);
//        for(int k=0; k < rooms.)
//        {
        for (int i = 0; i < this.days.size(); i++) {
            System.out.println(this.days.get(i).no + "\t\t");
            for (int j = 0; j < this.days.get(i).timeslots.size(); j++) {
                System.out.println(this.days.get(i).timeslots.get(j).no + "   " + this.days.get(i).timeslots.get(j).check);
            }
            System.out.println("");
        }
    }

    public static ArrayList<String> getRooms() {
        ArrayList<String> rooms = new ArrayList<>();
        String q = "select name from room";
        Connection conn = getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                rooms.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rooms;
    }

    public static boolean getRooms(int day, int slot, String roomNo) {
        String q = "select * from room join lectures where room.name = '" + roomNo + "' and lectures.room_name = '" + roomNo + "' and day_no = " + day + " and timeslot_no = " + slot;
        Connection conn = getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            boolean busy = rs.next();
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getString(3));
            return busy;

        } catch (SQLException ex) {
            Logger.getLogger(Room.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
//    public static Room getRoom(ArrayList<Room> rooms, Section section, int semester_no ) {   
//        
//        int capacity = section.getStrength()    ;   
//        int courses= section.getCourses().size() ;  
//        int lectures = courses * 2 ; 
//        
//        
//        for(int i = 0 ; i < rooms.size() ; i++ ) { 
//            if( rooms.get(i).getCapacity() >= capacity ) { 
//                
//                int free_slots = get_freeslots(rooms.get(i) ) ;  
//                if()    {   
//                    
//                }
//                return rooms.get(i) ; 
//            } 
//        } 
//        System.out.println("    null room is returned   ")  ;   
//        return null ; 

//        String query1 = "select room.name from room where capacity >= values ? "  ; 
//        try {   
//            PreparedStatement stmt = db.DBConnection.getConnection().prepareStatement(query1) ;  
//            stmt.setInt(1, capacity) ; 
//            ResultSet rs = stmt.executeQuery() ; 
//        }   
//        catch(Exception ex){
//            ex.printStackTrace();
//        }   
//    }   

public static int get_freeslots( Room rm ) { 
    int free_slots = 0  ; 
    for(Room_Day day  :  rm.getDays() ){
        for(Room_Timeslot slot : day.getTimeslots() ){  
            if(slot.isCheck() == false){    
                free_slots++;
            }
        }
    }
    return free_slots ; 
}   

//public static Room_Day get_Day()    {   
//    
////    return 
//}  
//// get_Day for lecture allocation   
//
//public static Room_Timeslot get_Timeslot()  {   
//    
//    return 
//}


}// main class room



