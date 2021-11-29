

package Model.student;

import java.util.ArrayList;

public class Student_Day {
    private int no ; 
    private ArrayList<Student_Timeslot> timeslots ; 


    public Student_Day(int no, ArrayList<Student_Timeslot> timeslots) {
        this.no = no ; 
        this.timeslots = timeslots  ;   
    }   

    Student_Day() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void fillingStudentTimeslot()
    {
    }
    
    @Override
    public String toString() {
        return "Day_for_Student{" + "no=" + no + ", timeslots=" + timeslots + '}';
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public ArrayList<Student_Timeslot> getTimeslots() {
        return timeslots;
    }

    public void setTimeslots(ArrayList<Student_Timeslot> timeslots) {
        this.timeslots = timeslots;
    }
    
    
    
}
