

package Model.room ; 

import java.util.ArrayList ; 

public class Room_ExamDay { 
    
    int day_no;
    ArrayList<Room_ExamTimeslot> exam_timeslots = new ArrayList<>() ; 

    public Room_ExamDay() {
    }

    public int getDay_no() {
        return day_no;
    }

    public void setDay_no(int day_no) {
        this.day_no = day_no;
    }


    public ArrayList<Room_ExamTimeslot> getExam_timeslots() {
        return exam_timeslots;
    }

    public void setExam_timeslots(ArrayList<Room_ExamTimeslot> exam_timeslots) {
        this.exam_timeslots = exam_timeslots;
    }

  

    
    
    
}
