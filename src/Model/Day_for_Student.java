
package Model;

import Model.Student_Timeslot;
import java.util.ArrayList;

public class Day_for_Student {
//    String no ; 
    String name ; 
    ArrayList<Student_Timeslot> timeslots ; 

    
    public Day_for_Student() {
        
    }

    public Day_for_Student(String name, ArrayList<Student_Timeslot> timeslots) {
        this.name = name;
        this.timeslots = timeslots;
    }
    
    
    public void fillingStudentTimeslot()
    {
    }
    
    @Override
    public String toString() {
        return "Day_for_Student{" + "name=" + name + ", timeslots=" + timeslots + '}';
    }
       
    
    
}
