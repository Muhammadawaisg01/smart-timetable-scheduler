
package Model.datesheet_generation;

import java.util.ArrayList;

public class Exam_Day { 
    
    int day_no;
    private ArrayList<Exam_Timeslot> exam_timeslots = new ArrayList<>() ;
    
    public Exam_Day() {
        
    }

    public int getDay_no() {
        return day_no;
    }

    public void setDay_no(int day_no) {
        this.day_no = day_no;
    }

    public ArrayList<Exam_Timeslot> getExam_timeslots() {
        return exam_timeslots;
    }

    public void setExam_timeslots(ArrayList<Exam_Timeslot> exam_timeslots) {
        this.exam_timeslots = exam_timeslots;
    }

   
    
    
}   
