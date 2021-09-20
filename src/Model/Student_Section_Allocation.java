

package Model;

public class Student_Section_Allocation {   
    
    String registration_no  ;   
    String course_code;
    String section_id;

    public Student_Section_Allocation() {   
        
    }
    
    
    
    
    
    // setters and getters section

    public String getRegistration_no() {
        return registration_no;
    }

    public void setRegistration_no(String registration_no) {
        this.registration_no = registration_no;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

//    public boolean isForLab_or_theory() {
//        return forLab;
//    }

//    public void setForLab_or_theory(boolean forLab) {
//        this.forLab = forLab;
//    }

    public String getSection_id() {
        return section_id;
    }

    public void setSection_id(String section_id) {
        this.section_id = section_id;
    }
    
    
}
