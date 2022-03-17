package Model.semester;

import java.util.ArrayList;

public class Section_Day {

    int no;
    ArrayList<Section_Timeslot> timeslots = new ArrayList<>(); 
//  variable for favorite day or not
    public Section_Day() {
        
    }

    public Section_Day(int no, ArrayList<Section_Timeslot> timeslots) {
        this.no = no;
        this.timeslots = timeslots;
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
