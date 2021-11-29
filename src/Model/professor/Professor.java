

package Model.professor ; 

<<<<<<< HEAD:src/Model/professor/Professor.java
import Model.WeekDays;
=======
import db.DBConnection;
>>>>>>> d8d42c20dd764eb319cffd41b0077ebf17c26e9f:src/Model/Professor.java
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList ; 
import static db.DBConnection.getConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class Professor { 
    
    private int id ;    
    private String name ;
    private Professor_Schedule schedule ;
    private ArrayList<Professor_Lecture_Clash> clash_array =  new ArrayList<>();
    public Professor( int id, String name ) { 
        this.id = id ; 
        this.name = name ; 
        schedule = new Professor_Schedule(5,6);
    }   
    
    public Professor() {
    }
    
    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", name=" + name + '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor_Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Professor_Schedule schedule) {
        this.schedule = schedule;
    }

    public ArrayList<Professor_Lecture_Clash> getClash_array() {
        return clash_array;
    }

    public void setClash_array(ArrayList<Professor_Lecture_Clash> clash_array) {
        this.clash_array = clash_array;
    }
        
    
    public void display_Professor() {  // display tabular data

        System.out.println("________________________________________")  ; 
        int i = 0, j = 0    ;   
        Professor_Schedule schedule = this.getSchedule() ; 
        System.out.println("Professor ID :   "+this.id)  ;   
        System.out.println("Professor Name :   "+this.name)  ;   
        
//        System.out.println("Semester No:\t" + semesterNo);
//        System.out.println("Section_no      " + sec_no);
        for (int k = 0; k < schedule.getDays().size(); k++) {
//            System.out.println(schedule.days.get(k).no);
//            String d = "Days", r = "Room", cc = "Course Code", l = "Lec No", s ="Slot No" ;
//            System.out.printf("%-7s%-7s%-25s%-7s%7s", d, r, cc, l, s);
//            System.out.println("\n");
            System.out.printf("%-7s", WeekDays.names[schedule.getDays().get(k).getNo()]);
//            System.out.println(schedule.days.get(k).timeslots.size() + "\t//////////////////////////////////////////////");
            for (j = 0; j < schedule.getDays().get(k).getTimeslots().size(); j++) {
                System.out.printf("%-7s", schedule.getDays().get(k).getTimeslots().get(j).getRoom());
                System.out.printf("%-15s", schedule.getDays().get(k).getTimeslots().get(j).getCourse_code());
                System.out.printf("%-15s", schedule.getDays().get(k).getTimeslots().get(j).getSemester());
                System.out.printf("%-15s", schedule.getDays().get(k).getTimeslots().get(j).getSection());
                try {
                    System.out.printf("%7d<----------->", schedule.getDays().get(k).getTimeslots().get(j).getSlot_No());
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex);
//                        System.out.println(j + "\t" + k);
                    System.exit(0);
                }
                if (schedule.getDays().get(k).getTimeslots().get(j).getCheck() == false) {
                    System.out.print("__");
                } else {

//                        System.out.print( Course.getCourse(course,schedule.days.get(k).timeslots.get(j).course_code) + " ") ; 
                }
            }
            System.out.println();
        }
        System.out.println("_________________________My Clashes_____________________________________");
        for(int var = 0 ; var < this.getClash_array().size() ; var++) { 
            System.out.print("ID  : "+getClash_array().get(var).getProfessor_id()+"\t")  ; 
            System.out.print("Clash_No  : "+getClash_array().get(var).getLecture_no()+"\t")  ;  
            System.out.print("Semester  : "+getClash_array().get(var).getSemester()+"\t" )  ; 
            System.out.print("Section  : "+getClash_array().get(var).getSection()+"\t")  ; 
            System.out.print("Room  : "+getClash_array().get(var).getRoom()+"\t")  ; 
            System.out.print("Day  : "+getClash_array().get(var).getDay_no()+"\t")  ; 
            System.out.print("Slot No  : "+getClash_array().get(var).getSlot_no()+"\t")  ; 
            System.out.print("Course  : "+getClash_array().get(var).getCourse()+"\t")  ;
            System.out.print("isResolved  : "+getClash_array().get(var).isIsresolved()+"\t")  ; 
            System.out.println("");
        }         
//        for(int var=0; var<this.getAllocations().size(); var++){
//            System.out.println(this.getAllocations().get(i).toString());
//        }
    }
    
    public static ResultSet professorIsFree(int day, int slot, int profID) {
        String q = "SELECT * FROM section_professor_allocation JOIN lectures WHERE section_professor_allocation.professor_id = " + profID + " AND section_professor_allocation.course_code = lectures.course_code AND section_professor_allocation.section_id = lectures.section_id AND lectures.day_no = " + day +" AND lectures.timeslot_no = " + slot;
        Connection conn = getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Professor.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
        public static int get_total_no_of_professors() { 
        Connection conn = db.DBConnection.getConnection();
        int total_professors = 0 ;
        String query = "select COUNT(*) from schedulerdb.professor " ; 
        try{
        PreparedStatement stmt= conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while(rs.next() ) {
            total_professors=rs.getInt(1) ;
            }
        }
        catch (Exception ex){
            
        }
        return total_professors;
    }
        public static ResultSet get_all_professors(){
        ResultSet rs=null;
        String query ="select * from schedulerdb.professor" ; 
        try
        {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query) ;
            rs = stmt1.executeQuery() ;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error in Fetching Data of Professors", "Professor", JOptionPane.ERROR_MESSAGE) ; 
        }
        return rs;
    }

}


