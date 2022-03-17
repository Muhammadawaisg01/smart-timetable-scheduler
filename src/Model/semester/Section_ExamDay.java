
package Model.semester;

import java.util.ArrayList;


public class Section_ExamDay {
    
    int day_no;
    ArrayList<Section_ExamTimeslot> exam_timeslots = new ArrayList<>() ; 

    public Section_ExamDay() {
    }

    public int getDay_no() {
        return day_no;
    }

    public void setDay_no(int day_no) {
        this.day_no = day_no;
    }

    
   
    
    public ArrayList<Section_ExamTimeslot> getExam_timeslots() {
        return exam_timeslots;
    }

    public void setExam_timeslots(ArrayList<Section_ExamTimeslot> exam_timeslots) {
        this.exam_timeslots = exam_timeslots;
    }

    
}
