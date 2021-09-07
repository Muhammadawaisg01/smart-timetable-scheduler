

package Model;


public class Professor_Section_Allocation {
    
    int prof_id ;   
    String section;
    int semester;
    String course_code ; 

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
    
}



