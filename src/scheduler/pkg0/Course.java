
package scheduler.pkg0 ; 

import java.util.ArrayList ; 

public class Course { 
    
    String course_code ; 
    String title ; 
    String credit_hours ; 
    String lab ; 
    
    int semester ; 
//    String program;
//     maximum enrollment variable  
    
//    ArrayList<String> program ; 
//    ArrayList<String> semester; 
    public Course() { 
        
    } 

    public Course(String course_code, String title, String credit_hours, String lab) {
        this.course_code = course_code;
        this.title = title;
        this.credit_hours = credit_hours;
        this.lab = lab;
    }   

}


