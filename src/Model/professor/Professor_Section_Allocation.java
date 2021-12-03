

package Model.professor;

import Enums.Professor_Allocation;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.ResultSet;
import static db.DBConnection.getConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Professor_Section_Allocation {     
    

    int prof_id ;   
    String section;
    int semester;
    String course_code ;
     Professor_Allocation allocation ;
    
    
    public Professor_Section_Allocation(int prof_id, String section, int semester, String course_code) {
        this.prof_id = prof_id;
        this.section = section;
        this.semester = semester;
        this.course_code = course_code;
    }
    
    
    public Professor_Section_Allocation(int prof_id, String course_code) {
        this.prof_id = prof_id;
        this.course_code = course_code;
    }
        
    public Professor_Section_Allocation() {     
        
    }
    
//    @Override
//    public String toString() {
//        return "Professor-to-Course{" + "prof_id=" + prof_id + ", course_code=" + course_code + '}';
//    }

    @Override
    public String toString() {
        return "Professor_Section_Allocation{" + "prof_id=" + prof_id + ", section=" + section + ", semester=" + semester + ", course_code=" + course_code + '}';
    }
    

    public int getProf_id() {
        return prof_id;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setProf_id(int prof_id) {
        this.prof_id = prof_id;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }
    
    public static ResultSet getData() {
        try {
            String q = "select * from section_professor_allocation";
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Professor_Section_Allocation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}



