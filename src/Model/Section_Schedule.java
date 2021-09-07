package Model;

import java.util.ArrayList;

public class Section_Schedule {

    ArrayList<Section_Day> days = new ArrayList<>() ; 

    public Section_Schedule() {
        this.initialize_Section_Schedule();
    }

    public Section_Schedule(ArrayList<Section_Day> days) {
        this.days = days;
//        this.initialize_Section_Schedule();
    }

    public void display() {
        for (Section_Day section_Day : days) {
            section_Day.display();
        }
    }

    public ArrayList<Section_Day> getDays() {
        return days;
    }

    public void setDays(ArrayList<Section_Day> days) {
        this.days = days;
    }
    
    

    public void initialize_Section_Schedule() {
        int c = 0;
        this.days = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Section_Day obj1 = new Section_Day();
            obj1.timeslots = new ArrayList<>();
            int slot_no = 0;
            String course = "";
            int lecture_no = 0;
            boolean check = false;
            String room = "";
            for (int j = 0; j < 6; j++) { // 6 timeslots
                Section_Timeslot obj = new Section_Timeslot(room, j, course, lecture_no, check);
                obj1.timeslots.add(obj);
            }
            obj1.no = i;
            this.days.add(obj1);
        }
//        for (Section_Day day : days) {
//            System.out.println(c + "        " + day.toString());
//            c++;
//        }
    }
}
