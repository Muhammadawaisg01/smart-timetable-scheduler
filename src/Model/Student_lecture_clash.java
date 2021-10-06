


package Model;


public class Student_lecture_clash {
    
    String reg_no;
//    int program_id ;
    int semester;
    String section;
    String room ;
    int day_no;
    int slot_no;
    String course;
    int lecture_no ;
    boolean isLab;    
    boolean isresolved; 

    public Student_lecture_clash(String reg_no, int semester, String section, String room, int day_no, int slot_no, String course, int lecture_no, boolean isLab) {
        this.reg_no = reg_no;
        this.semester = semester;
        this.section = section;
        this.room = room;
        this.day_no = day_no;
        this.slot_no = slot_no;
        this.course = course;
        this.lecture_no = lecture_no;
        this.isLab = isLab;
        this.isresolved = false;
    }
    
    public Student_lecture_clash()  {   
    
    }   
    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getDay_no() {
        return day_no;
    }

    public void setDay_no(int day_no) {
        this.day_no = day_no;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getLecture_no() {
        return lecture_no;
    }

    public void setLecture_no(int lecture_no) {
        this.lecture_no = lecture_no;
    }
    public boolean isIsresolved() {
        return isresolved;
    }

    public void setIsresolved(boolean isresolved) {
        this.isresolved = isresolved;
    }

    public boolean getisLab() {
        return isLab;
    }

    public void setLab_or_lec(boolean lab) {
        this.isLab = lab ; 
    }

    public String getReg_no() {
        return reg_no;
    }

    public void setReg_no(String reg_no) {
        this.reg_no = reg_no;
    }

    public boolean isIsLab() {
        return isLab;
    }

    public void setIsLab(boolean isLab) {
        this.isLab = isLab;
    }

    @Override
    public String toString() {
        return "Student_lecture_clash{" + "reg_no=" + reg_no + ", semester=" + semester + ", section=" + section + ", room=" + room + ", day_no=" + day_no + ", slot_no=" + slot_no + ", course=" + course + ", lecture_no=" + lecture_no + ", isLab=" + isLab + ", isresolved=" + isresolved + '}';
    }
    
    
    
    
}
