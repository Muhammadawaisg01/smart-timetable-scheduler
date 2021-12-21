package Model;

import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Reset {

    public static void resetStudents() {
        Queries.execute("delete from students");
        Queries.execute("delete from student_section_allocation");
        Queries.execute("delete from student_schedule");
        uploadStudentFile(0);
    }

    public static void resetSchedule() {
        String query = "Update section_schedule SET course_code = '', room_name = '', lecture_no = 0, isLab = 'false' \n"
                + "where \n"
                + "section_id in (select section_id from section)";
        Queries.execute(query);
        generateSchedule(0);
    }

    public static boolean scheduleGenerated() {
        ResultSet rs = Queries.getRS("select schedule_generated from checks");
        try {
            if (rs.next()) {
                int n = rs.getInt("schedule_generated");
                return n == 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reset.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static boolean studentFileUploaded() {
        ResultSet rs = Queries.getRS("select fileUpload from checks");
        try {
            if (rs.next()) {
                int n = rs.getInt("fileUpload");
                return n == 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Reset.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public static void generateSchedule(int n) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        String q = "insert into checks (schedule_generated) VALUES (?)";
        try {
            stmt = conn.prepareStatement(q);
            stmt.setInt(1, n);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Reset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void uploadStudentFile(int n) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        String q = "insert into checks (fileUpload) VALUES (?)";
        try {
            stmt = conn.prepareStatement(q);
            stmt.setInt(1, n);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Reset.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
