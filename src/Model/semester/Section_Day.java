package Model.semester;

import java.util.ArrayList;

public class Section_Day {
<<<<<<< HEAD:src/Model/semester/Section_Day.java

    private int no;
    private ArrayList<Section_Timeslot> timeslots = new ArrayList<>();

=======
    
    int no;
    ArrayList<Section_Timeslot> timeslots = new ArrayList<>() ; 
//  variable for favorite day or not
    
>>>>>>> d8d42c20dd764eb319cffd41b0077ebf17c26e9f:src/Model/Section_Day.java
    public Section_Day() {

    }

    public void display() {
        for (Section_Timeslot section_Timeslot : timeslots) {
            System.out.println(section_Timeslot.toString());
        }
    }

    

    @Override
    public String toString() {
        return "Section_Day{" + "no=" + no + ", timeslots=" + timeslots + '}';
    }

    public int getNo() {
        return no;
    }

    public ArrayList<Section_Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setTimeslots(ArrayList<Section_Timeslot> timeslots) {
        this.timeslots = timeslots;
    }

}
