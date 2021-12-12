

package Model;

import Enums.Room_Type;
import java.io.File;
import java.util.ArrayList;

public class TestData {
    public static ArrayList<Room> rooms = new ArrayList<>();
    public static ArrayList<Program> programs = new ArrayList<>();
    
    
    public static ArrayList<Room_Day> slotting(int day, int slot) {
        ArrayList<Room_Timeslot> slots = new ArrayList<>();
        ArrayList<Room_Day> days = new ArrayList<>();          
            for (int d = 0; d < day; d++) {
                Room_Day d1 = new Room_Day();
                d1.no = d+1;
                for (int i = 0; i < slot; i++) {
                    Room_Timeslot st = new Room_Timeslot();
                    st.setCheck(false);
                    st.setNo(i);
                    slots.add(st);
                }
                ArrayList<Room_Timeslot> newarray1 = new ArrayList<>();
                newarray1.addAll(slots);
                slots.clear();
                d1.timeslots = newarray1;
                days.add(d1);
            }
        return days ; 
    }
    
    
    public static ArrayList<Room> rooms(){
        ArrayList<Room> rooms = new ArrayList<>();
        rooms.add(new Room("101", 50, Room_Type.LAB, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LAB, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LAB, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LAB, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LECTURE_ROOM, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LECTURE_ROOM, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LECTURE_ROOM, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LECTURE_ROOM, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LECTURE_ROOM, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LECTURE_ROOM, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LECTURE_ROOM, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LECTURE_ROOM, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LECTURE_ROOM, slotting(5,6)));
        rooms.add(new Room("101", 50, Room_Type.LECTURE_ROOM, slotting(5,6)));    
        return rooms;
    }
    public TestData() {
        rooms = rooms();
        programs = program();
    }
    
    public static ArrayList<Program> program() { 
        Program p1 = new Program();
        p1.setId("1"); 
        p1.setName("ABCD"); 
        p1.setSemesters(Semester.getSemesters(new File("Semesters.txt")));
        ArrayList<Program> programs = new ArrayList<>();
        programs.add(p1) ;
        return programs;
        
    }


}
