
package Model;
import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Queries {

    /**
     * 
     * @param programName   name of program
     * @return id of program
     */
    public static int getProgramID(String programName) {
        String q = "select program_id from program where program_name = '" + programName + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("program_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    
    /**
     * 
     * @param courseName course name
     * @return course code
     */
    public static String getCourseCode(String courseName) {
        String q = "select course_code from course where title = '" + courseName + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("course_code");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
