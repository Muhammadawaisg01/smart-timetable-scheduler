

package Model ; 

import java.util.ArrayList ; 

public class Course { 
    
    String course_code ; 
    String title ; 
    int credit_hours ;
    boolean lab ;        // make it boolean
    
//    int semester ;          // in which semester it is being offered
//    String program;
//     maximum enrollment variable  
    
//    ArrayList<String> program ; 
//    ArrayList<String> semester; 


    public Course(String title) {
        this.title = title;
    }

    public Course() {
        
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
    
    
 
}


