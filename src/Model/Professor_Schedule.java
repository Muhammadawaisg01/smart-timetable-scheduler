

package Model ; 

import java.util.ArrayList  ;   


public class Professor_Schedule     {    
    
    private ArrayList<Professor_Day> days = new ArrayList<>();
    
    public Professor_Schedule(int days, int slots) {
        this.initialize_Professor_Schedule(days, slots);
    }
    
    // days and timeslots must be user input based 
    public void initialize_Professor_Schedule(int days, int slots) {   
//        this.days = new ArrayList<>() ;     
        for (int i = 0; i < days; i++) {   
            Professor_Day obj1 = new Professor_Day() ; 
            obj1.timeslots = new ArrayList<>();
//            int slot_no = 0;
            String course_code = "";
            int lecture_no = 0;
            boolean check = false   ;   
            String room = "" ;  
            int program = 0 ;
            int semester = 0 ;  
            String section=""   ;   
            for (int j = 0; j < slots; j++  ) { // 6 timeslots    
                Professor_Timeslot obj = new Professor_Timeslot(j+1, program, semester, section, room, course_code, lecture_no, check )    ;   
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




