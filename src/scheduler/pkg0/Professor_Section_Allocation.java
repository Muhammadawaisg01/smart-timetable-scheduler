

package scheduler.pkg0;


public class Professor_Section_Allocation {
    
    int prof_id ;   
    String course_code ; 

    public Professor_Section_Allocation(int prof_id, String course_code) {
        this.prof_id = prof_id;
        this.course_code = course_code;
    }
    
    
    public Professor_Section_Allocation() {     
        
    }
    
    @Override
    public String toString() {
        return "Professor_Section_Allocation{" + "prof_id=" + prof_id + ", course_code=" + course_code + '}';
    }
    
}
