

package Model ; 

import java.util.ArrayList  ;   


public class Professor_Schedule     {    
    
    private ArrayList<Professor_Day> days = new ArrayList<>();
    
    public Professor_Schedule() {
        this.initialize_Professor_Schedule();
    }
    
    // days and timeslots must be user input based 
    public void initialize_Professor_Schedule() {   
//        this.days = new ArrayList<>() ;     
        for (int i = 0; i < 5; i++) {   
            Professor_Day obj1 = new Professor_Day() ; 
            obj1.timeslots = new ArrayList<>();
            int slot_no = 0;
            String course = "";
//            int lecture_no = 0;
            boolean check = false   ;   
            String room = "" ;  
            int semester = 0 ;  
            String section=""   ;   
            for (int j = 0; j < 6; j++  ) { // 6 timeslots    
                Professor_Timeslot obj = new Professor_Timeslot(slot_no, semester, section, room, course, check )    ;   
                obj1.timeslots.add(obj) ;   
            }   
            obj1.no = i ;   
            this.days.add( obj1 ) ;   
        }    
//        for (Section_Day day : days) {
//            System.out.println(c + "        " + day.toString());
//            c++;
//        }
    }   

    public ArrayList<Professor_Day> getDays() {
        return days;
    }

    public void setDays(ArrayList<Professor_Day> days) {
        this.days = days;
    }
    
}




