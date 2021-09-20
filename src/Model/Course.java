

package Model ; 

import java.util.ArrayList ; 
import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
    
public class Course {   
    
    String course_code ; 
    String title ; 
    int credit_hours ;  
    boolean lab ;       
    
//     maximum enrollment variable          how msny students have enrolled in this course      

//    static ArrayList<Course> courses  =  CourseUtility.readCourseFile();    // read data          
    
    public Course(String title) {
        this.title = title;
    }

    public Course() {
        
    } 

    public Course(String course_code, String title) {
        this.course_code = course_code;
        this.title = title;
        credit_hours=3;
        this.lab=false;
    }

    
    public Course(String course_code, String title, int credit_hours, boolean lab) {
        this.course_code = course_code;
        this.title = title;
        this.credit_hours = credit_hours;
        this.lab = lab;
    }

    public String getCourse_code() {
        return course_code;
    }
    
    public static Course getCourse(ArrayList<Course> courses, String course_code){
        for(Course crs : courses)   {   
            if(crs.course_code.equalsIgnoreCase(course_code)){
                return crs ; 
            }
        }
        return null ; 
    }
    
    public String getTitle() {
        return title;
    }

    public int getCredit_hours() {
        return credit_hours;
    }

    public boolean isLab() {
        return lab;
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

    public void setLab(boolean lab) {
        this.lab = lab;
    }

    @Override
    public String toString() {
        return "Course{" + "course_code=" + course_code + ", title=" + title + ", credit_hours=" + credit_hours + ", lab=" + lab + '}';
    }
    
    /*
    @param course_code 
    @return Course Object
    */
    public static Course getCourse(String code) {
        Connection conn = getConnection();
        Course course = new Course();
        String q = "select * from course where course_code = '" + code + "'";
        try {
            PreparedStatement stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()) {
                course.setCourse_code(rs.getString("course_code"));
                course.setTitle(rs.getString("title"));
                course.setCredit_hours(rs.getInt("credit_hours"));
                course.setLab(rs.getString("hasLab").equalsIgnoreCase("true"));
                return course;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Course.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
 
}


