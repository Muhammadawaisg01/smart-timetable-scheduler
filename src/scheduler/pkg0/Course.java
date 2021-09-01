
package scheduler.pkg0 ; 

import java.util.ArrayList;

public class Course {
    
    String course_code ; 
    String title ; 
    String credit_hours ; 
    String lab ; 
    int semester ; 

    // maximum enrollment
    
//    ArrayList<String> program ; 
//    ArrayList<String> semester; 
    public Course() { 
        
    } 

    public Course(String course_code, String title, String credit_hours, String lab, int semester) {
        this.course_code = course_code;
        this.title = title;
        this.credit_hours = credit_hours;
        this.lab = lab;
        this.semester = semester;
    }     

}


