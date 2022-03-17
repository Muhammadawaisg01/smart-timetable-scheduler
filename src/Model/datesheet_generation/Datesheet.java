
package Model.datesheet_generation;

import java.util.ArrayList;


public class Datesheet {
    
    private ArrayList<Exam_Day> days = new ArrayList<>(); 

    public Datesheet() {
        initialize_Datesheet();
    }

    public Datesheet(ArrayList<Exam_Day> days) {
        this.days = days;
    }
    
    public ArrayList<Exam_Day> getDays() {
        return days;
    }

    public void setDays(ArrayList<Exam_Day> days) {
        this.days = days;
    }    
    
    private void initialize_Datesheet(int days, int timeslots){
        for (int i = 0; i < days ; i++) {        
            Exam_Day day_obj = new Exam_Day();
            day_obj.day_no=i+1;
            boolean check = false;            
            for (int slots = 0; slots < timeslots ; slots++) { // 6 timeslots
                Exam_Timeslot timeslot_obj = new Exam_Timeslot(slots+1,"","","","" ) ;
                day_obj.getExam_timeslots().add(timeslot_obj);
            }
            this.days.add(day_obj) ;
        }
    }
}
