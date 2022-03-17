
package Model.room;

import Model.semester.Section_ExamTimeslot;
import java.util.ArrayList;


public class Room_Datesheet {
    
    ArrayList<Room_ExamDay> days = new ArrayList<>() ; 
    
    public Room_Datesheet(int days, int slots) {
        this.initialize_Room_Datesheet(days, slots);
    }
    
    public ArrayList<Room_ExamDay> getDays() {
        return days;
    }

    public Room_Datesheet() {
    }
    
    public void setDays(ArrayList<Room_ExamDay> days) {
        this.days = days;
    }
    
    public void initialize_Room_Datesheet(int days, int timeslots) {
    for (int i = 0; i < days ; i++) {        
        Room_ExamDay day_obj = new Room_ExamDay();
        day_obj.day_no=i+1;
        boolean check = false;
        for (int slots = 0; slots < timeslots ; slots++) { // 6 timeslots
            Room_ExamTimeslot timeslot_obj = new Room_ExamTimeslot(slots+1,"","",0, check);
            day_obj.getExam_timeslots().add(timeslot_obj);
        }
        this.days.add(day_obj) ; 
    }
}


    
}
