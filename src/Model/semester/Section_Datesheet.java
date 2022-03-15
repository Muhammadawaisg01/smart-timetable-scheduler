
package Model.semester;

import java.util.ArrayList;


public class Section_Datesheet {
        
    ArrayList<Section_ExamDay> days = new ArrayList<>();

    public Section_Datesheet(int days, int slots) {
        this.initialize_Section_Datesheet(days, slots);
    }    

    public Section_Datesheet() {
    }
    
    public ArrayList<Section_ExamDay> getDays() {
        return days;
    }

    public void setDays(ArrayList<Section_ExamDay> days) {
        this.days = days;
    }
    
    private void initialize_Section_Datesheet(int days, int timeslots){
        for (int i = 0; i < days ; i++) {        
            Section_ExamDay day_obj = new Section_ExamDay();
            day_obj.day_no=i+1;
            boolean check = false;
            for (int slots = 0; slots < timeslots ; slots++) { // 6 timeslots
                Section_ExamTimeslot timeslot_obj = new Section_ExamTimeslot(slots+1, check ) ;
                day_obj.getExam_timeslots().add(timeslot_obj);
            }
            this.days.add(day_obj) ;
        }
    }
    

}
