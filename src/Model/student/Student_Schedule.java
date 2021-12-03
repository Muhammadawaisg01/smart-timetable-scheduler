

package Model.student;

import java.util.ArrayList;

public class Student_Schedule {
    
    private ArrayList<Student_Day> days ; 

    public Student_Schedule(int days, int slots) {
        this.initialize_Schedule(days, slots);
    }
    
    public ArrayList<Student_Day> getDays() {
        return days;
    }

    public void setDays(ArrayList<Student_Day> days) {
        this.days = days;
    }
        
    public void initialize_Schedule(int days, int slots) { // initializing student days and slots with null values     
        this.days = new ArrayList<>() ; 
        
        for(int i = 0 ; i < days ; i++ ){ 
        Student_Day obj1 = new Student_Day();
        obj1.setNo(i);
        obj1.setTimeslots(new ArrayList<>()); 
        
        int program = 0;
        int semester=0;
        String section="";
        String course_code="";
        int lecture_no=0 ; 
        String room="";
        for(int j = 0; j < slots; j++) { // 6 timeslots 
            Student_Timeslot obj = new Student_Timeslot( j+1, program, semester, section , room, course_code, lecture_no, false);
            obj1.timeslots.add(obj) ;
        }
        this.days.add(obj1) ; 
        }        
    } 
    
    
    
}
    


