package Model;

import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Queries {

    /**
     *
     * @param programName name of program
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
    
    /**
     *
     * @param courseCode  course code
     * @return all course details
     */
    public static ResultSet getCourseDetails(String courseCode) {
        String q = "select * from course where course_code = '" + courseCode + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
            
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @return number of days in db
     */
    public static int getDaysCount() {
        String q = "select COUNT(*) from day";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return -1;
    }

    /**
     *
     * @return number of time slots in db
     */
    public static int getSlotCount() {
        String q = "select COUNT(*) from timeslot";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return -1;
    }

    /**
     *
     * @return name of all professors in database
     */
    public static ArrayList<String> getAllProfessors() {
        String q = "select name from professor";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        ArrayList<String> professors = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                professors.add(rs.getString(1));
            }
            return professors;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param name professor name
     * @return prof id
     */
    public static int getProfessorID(String name) {
        String q = "select professor_id from professor where name = '" + name + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ResultSet getAllStudent() {
        String q = "select * from students";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }
    
    /**
     * 
     * @param regNo student registration number
     * @return student name
     */
    public static String getStudent(String regNo) {
        String q = "select name from students where registration_no = '" + regNo + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    /**
     * 
     * @param reg_no student registration number
     * @return ResultSet set of course codes of registered courses
     */
    public static ResultSet getStudentRegisteredCourses(String reg_no) {
        String q = "select course_code from registered_courses where student_registration_no = " + reg_no;
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

}
