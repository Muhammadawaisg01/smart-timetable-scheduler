

package Model ; 

public class TimeSlot { 
    int no ; 
    boolean check ; 
    
//    String program;
//    int semester;
//    String section;
//    String professor;
//    String course;
//    int lecture_no;
    
    public TimeSlot(int no, boolean check ) { 
        this.no = no ; 
        this.check = check ; 
    } 

    public TimeSlot() { 
    } 

    @Override
    public String toString() {  
        return "TimeSlot{" + "no=" + no + ", check=" + check + '}'; 
    }   

    public int getNo() {
        return no;
    }

    public boolean isCheck() {
        return check;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    
    
    
}
