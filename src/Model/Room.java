
package Model;

import Enums.Room_Type;
import db.DBConnection;
import java.util.ArrayList;
import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Room {     

    String name;
    int capacity;
    boolean isFull;    
    Room_Type room_type ;  
    
//    Array of specified courses, it means that only these courses will be taught in these rooms
    ArrayList<Course> specified_courses =  new ArrayList<>() ;    // a hard Constraint
    
//    ArrayList<Section> specified_sections =  new ArrayList<>() ;    // remove this array,  no much need of it
    
    ArrayList<Room_Day> days;
    
    public Room( String name, boolean isFull, ArrayList<Room_Day> days ) {
        this.name = name;
        this.isFull = isFull;
        this.days = days;   
    }   

    public Room(String name, int capacity, ArrayList<Room_Day> days) {
        this.name = name;
        this.capacity = capacity;                   // new constructor
        this.days = days;
        this.room_type = null; 
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public boolean isIsFull() {
        return isFull;
    }

    public void setIsFull(boolean isFull) {
        this.isFull = isFull;
    }

    public Room_Type getRoom_type() {
        return room_type;
    }

    public void setRoom_type(Room_Type room_type) {
        this.room_type = room_type;
    }
    
    


    public ArrayList<Course> getSpecified_courses() {
        return specified_courses;
    }

    public void setSpecified_courses(ArrayList<Course> specified_courses) {
        this.specified_courses = specified_courses;
    }

//    public ArrayList<Section> getSpecified_sections() {
//        return specified_sections;
//    }
//
//    public void setSpecified_sections(ArrayList<Section> specified_sections) {
//        this.specified_sections = specified_sections;
//    }
    
    
    

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
    public static int get_total_no_of_rooms() { 
        Connection conn = db.DBConnection.getConnection();
        int total_rooms = 0 ;
        String query = "select COUNT(*) from schedulerdb.room where isLab=? " ; 
        try{
        PreparedStatement stmt= conn.prepareStatement(query);
        stmt.setString(1, false+"");
        ResultSet rs = stmt.executeQuery();
        while(rs.next() ) {
            total_rooms=rs.getInt(1) ;
            }
        }
        catch (Exception ex){
            
        }
        return total_rooms;
    }
    public static int get_total_no_of_labs() { 
        Connection conn = db.DBConnection.getConnection();
        int total_labs = 0 ;
        String query = "select COUNT(*) from schedulerdb.room where isLab=?" ; 
        try{
        PreparedStatement stmt= conn.prepareStatement(query);
        stmt.setString(1, true+"");
        ResultSet rs = stmt.executeQuery();
        while(rs.next() ) {
            total_labs=rs.getInt(1) ;
            }
        }
        catch (Exception ex){
            
        }
        return total_labs;
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
    public static ResultSet get_all_rooms(){
        ResultSet rs=null;
        String query ="select * from schedulerdb.room where isLab=?" ; 
        try
        {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query) ;
            stmt1.setString(1, false+"");
            rs = stmt1.executeQuery() ;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error in Fetching Data of Rooms", "Room", JOptionPane.ERROR_MESSAGE) ; 
        }
        return rs;
    }
    public static ResultSet get_every_room(){
        ResultSet rs=null;
        String query ="select * from schedulerdb.room" ; 
        try
        {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query) ;
            rs = stmt1.executeQuery() ;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error in Fetching Data of Every Room", "Room", JOptionPane.ERROR_MESSAGE) ; 
        }
        return rs;
    }
    
        public static ResultSet get_all_labs(){
        ResultSet rs=null;
        String query ="select * from schedulerdb.room where isLab=?" ; 
        try
        {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query) ;
            stmt1.setString(1, true+"");
            rs = stmt1.executeQuery() ;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error in Fetching Data of Labs", "Room", JOptionPane.ERROR_MESSAGE) ; 
        }
        return rs;
    }
    public static boolean remove_room(String name) {
        boolean check=false;
        int no=0;
        String query = "delete from schedulerdb.room where name = ?"  ;
        try
        {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query) ;
            stmt1.setString(1, name);
            no = stmt1.executeUpdate();
            if(no != 0 ) { 
                check=true ; 
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error in removing a room ", "Room", JOptionPane.ERROR_MESSAGE) ; 
        }
        return check;
    }
    public static String search_room(String name) {
        boolean check=false;
        ResultSet rs =null;
        String rm_name = null ;
        int no=0;
        String query = "select name from room where name =?"  ;
        try
        {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query) ;
            stmt1.setString(1, name); 
            rs = stmt1.executeQuery(); 
            rs.next();
            rm_name = rs.getString(1);
        } 
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Didn't find a room with this name", "Room", JOptionPane.ERROR_MESSAGE) ; 
        }
        return rm_name;
    }
    
    public static void add_room(String room_name, int capacity, boolean isLab) {    
        String query = "Insert into schedulerdb.room values (?,?,?)" ; 
        try{
            PreparedStatement stmt= db.DBConnection.getConnection().prepareStatement(query);
            stmt.setString(1, room_name);
            stmt.setInt(2, capacity);
            stmt.setString(3, isLab+"");
            stmt.execute();
            JOptionPane.showMessageDialog(null, "New Room added Successfully");
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Error in adding Room in database ");
            ex.printStackTrace();
        }
    }
}// main class room



