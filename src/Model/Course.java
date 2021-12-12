package Model;

import Enums.Lab;
import db.DBConnection;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Course {

    String course_code;
    String title;
    int credit_hours;
    Lab lab;

//     maximum enrollment variable          how msny students have enrolled in this course      
//    static ArrayList<Course> courses  =  CourseUtility.readCourseFile();    // read data          
    static Connection conn;

    public Course(String title) {
        this.title = title;
    }

    public Course() {

    }

    public Course(String course_code, String title) {
        this.course_code = course_code;
        this.title = title;
        credit_hours = 3;
        this.lab = null;
    }

    public Course(String course_code, String title, int credit_hours, Lab lab) {
        this.course_code = course_code;
        this.title = title;
        this.credit_hours = credit_hours;
        this.lab = lab;
    }

    public String getCourse_code() {
        return course_code;
    }

    public static Course getCourse(ArrayList<Course> courses, String course_code) {
        for (Course crs : courses) {
            if (crs.course_code.equalsIgnoreCase(course_code)) {
                return crs;
            }
        }
        return null;
    }

    public String getTitle() {
        return title;
    }

    public int getCredit_hours() {
        return credit_hours;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCredit_hours(int credit_hours) {
        this.credit_hours = credit_hours;
    }

    public Lab getLab() {
        return lab;
    }

    public void setLab(Lab lab) {
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "Course{" + "course_code=" + course_code + ", title=" + title + ", credit_hours=" + credit_hours + ", lab=" + lab + '}';
    }

    /**
     * @param course_code
     * @return Course Object
     */
    public static Course getCourse(String code) {
        conn = db.DBConnection.getConnection();
        Course course = new Course();
        String q = "select * from course where course_code = '" + code + "'";
        try {
            PreparedStatement stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                course.setCourse_code(rs.getString("course_code"));
                course.setTitle(rs.getString("title"));
                course.setCredit_hours(rs.getInt("credit_hours"));
                if (rs.getString("hasLab").equalsIgnoreCase("true")) {
                    course.setLab(Lab.YES);
                } else {
                    course.setLab(Lab.NO);
                }
                return course;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Course> getCourses(String secId) {
        ArrayList<Course> courses = new ArrayList<>();
        String q = "select course_code from section_courses where section_id = '" + secId + "'";
        try {
            PreparedStatement stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String course_code = rs.getString(1);
                courses.add(getCourse(course_code));
            }
            return courses;
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void add_Course_in_database(String code, String title, int hours, boolean lab) {
        conn = db.DBConnection.getConnection();
        String query = "insert into schedulerdb.course values(?,?,?,?)";
        try {
            if (conn == null) {
                System.out.println(" I AM NULL");
            }
            System.out.println(conn == null ? "CLOSED" : "NOT CLOSED");
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, code);
            stmt.setString(2, title);
            stmt.setInt(3, hours);
            stmt.setString(4, "" + lab);
            stmt.execute();
            JOptionPane.showMessageDialog(null, "New Course Saved Successfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in adding Data of Course in database ");
            ex.printStackTrace();
        }
    }

    public static boolean check_duplication_in_database(String crs_code, String title) {
        conn = db.DBConnection.getConnection();
        boolean check = false;
        String query = "select * from course where course_code = ? and title = ?  ";
        try {
            if (conn == null) {
                System.out.println("I AM NULL  in  method check_duplication_in_database");
            }
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, crs_code);
            stmt.setString(2, title);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                if (rs.next()) {
                    check = true;
                    JOptionPane.showMessageDialog(null, "This Course exists before ");
                } else {
                    check = false;
                }
            }
        } catch (Exception ex) {

        }
        return check;
    }

    public static Course get_course_by_title(String title) {
        conn = db.DBConnection.getConnection();
        Course course = new Course();
        String q = "select * from course where course_code = '" + title + "'";
        try {
            PreparedStatement stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                course.setCourse_code(rs.getString("course_code"));
                course.setTitle(rs.getString("title"));
                course.setCredit_hours(rs.getInt("credit_hours"));
                if (rs.getString("hasLab").equalsIgnoreCase("true")) {
                    course.setLab(Lab.YES);
                } else {
                    course.setLab(Lab.NO);
                }
                return course;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int get_total_no_of_courses() {
        conn = db.DBConnection.getConnection();
        int total_courses = 0;
        String query = "select COUNT(*) from schedulerdb.course ";
        try {
//            if(conn == null){
//                System.out.println("I AM NULL  in  method check_duplication_in_database");
//            }
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
//            if(rs.next()){
                total_courses = rs.getInt(1);
//            }
//            else{
//               check =  false;
//            }
            }
        } catch (Exception ex) {

        }
        return total_courses;
    }

    public static ResultSet get_all_courses() {
        ResultSet rs = null;
        String query = "select * from course";
        try {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query);
            rs = stmt1.executeQuery();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Fetching Data of Courses", "Course", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    public static boolean update_course(String crs_code, String title, String crecit_hours, String lab) {
        String query = "update from course where course_code = ?";
        boolean check = false;
        try {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query);
            stmt1.setString(1, crs_code);
            int rowCount = stmt1.executeUpdate();

            if (rowCount == 0) {
                JOptionPane.showMessageDialog(null, "This Course doesn't exists in database."
                        + " Row Count returned is  " + rowCount);
            } else {
                JOptionPane.showMessageDialog(null, "Course is Updates successfully."
                        + " Row Count returned is  " + rowCount);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in updating the course", "Course", JOptionPane.ERROR_MESSAGE);
        }
        return check;
    }

}
