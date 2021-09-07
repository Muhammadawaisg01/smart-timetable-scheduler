

package Model;

import Model.Student_Timeslot;
import java.util.ArrayList;

public class Day_for_Student {
    int no ; 
    ArrayList<Student_Timeslot> timeslots ; 

    
    public Day_for_Student() {
        
    }

    public Day_for_Student(int no, ArrayList<Student_Timeslot> timeslots) {
        this.no = no ; 
        this.timeslots = timeslots  ;   
    }   
    
    
    public void fillingStudentTimeslot()
    {
    }
    
    @Override
    public String toString() {
        return "Day_for_Student{" + "no=" + no + ", timeslots=" + timeslots + '}';
    }
       
    
    
}
