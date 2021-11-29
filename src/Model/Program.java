
package Model ; 

<<<<<<< HEAD
import Model.semester.Semester;
=======
import db.DBConnection;
import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
>>>>>>> d8d42c20dd764eb319cffd41b0077ebf17c26e9f
import java.util.ArrayList ; 
import javax.swing.JOptionPane;

public class Program {
    String id ; 
    String name ; 
    ArrayList<Semester> semesters ; 

    public Program(String id, String name, ArrayList<Semester> semesters) { 
        this.id = id ;
        this.name = name ;
        this.semesters = semesters ;
    } 
    
    public Program() {
    }
    
    public static int get_total_no_of_programs() { 
        Connection conn = db.DBConnection.getConnection();
        int total_programs = 0 ;
        String query = "select COUNT(*) from schedulerdb.program " ; 
        try{
        PreparedStatement stmt= conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        while(rs.next() ) {
            total_programs=rs.getInt(1) ;
            }
        }
        catch (Exception ex){
            
        }
        return total_programs;
    }
    public static ResultSet get_all_programs(){
        ResultSet rs=null;
        String query ="select * from schedulerdb.program" ; 
        try
        {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query) ;
            rs = stmt1.executeQuery() ;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error in Fetching Data of programs", "Program", JOptionPane.ERROR_MESSAGE) ; 
        }
        return rs;
    }

    public static ResultSet get_all_data_of_programs()  {   
        ResultSet rs=null ; 
        String query ="select * from schedulerdb.program join (select Count(*) from semester where  )" ; 
        try
        {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query) ;
            rs = stmt1.executeQuery() ;
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error in Fetching all Data of programs", "Program", JOptionPane.ERROR_MESSAGE) ; 
        }
        return rs ; 
    }



}




