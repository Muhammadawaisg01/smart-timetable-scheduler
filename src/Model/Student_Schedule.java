

package Model;

import java.util.ArrayList;

public class Student_Schedule {
    
    ArrayList<Day_for_Student> days ; 

    public Student_Schedule(int days, int slots) {
        this.initialize_Schedule(days, slots);
    }
    
    public ArrayList<Day_for_Student> getDays() {
        return days;
    }

    public void setDays(ArrayList<Day_for_Student> days) {
        this.days = days;
    }
        
    public void initialize_Schedule(int days, int slots) { // initializing student days and slots with null values     
        this.days = new ArrayList<>() ; 
        
        for(int i = 0 ; i < days ; i++ ){ 
        Day_for_Student obj1 = new Day_for_Student();
        obj1.no=  i ;
        obj1.timeslots =  new ArrayList<>() ; 
        
        int semester=0;
        String section="";
        String course="";
        int lecture_no=0 ; 
        boolean check=false;
        String room="";
        for(int j = 0; j < slots; j++) { // 6 timeslots 
            Student_Timeslot obj = new Student_Timeslot( j, semester, section , course, lecture_no, check, room, false);
            obj1.timeslots.add(obj) ;
        }
        this.days.add(obj1) ; 
        }        
    } 
    
    
    
}
    


