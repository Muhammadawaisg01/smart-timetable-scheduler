

package Model ; 

public class Room_Timeslot { 
    int no ; 
    boolean check ; 
    
//    String program;
//    int semester;
//    String section;
//    String professor;
//    String course;
//    int lecture_no;
    
    public Room_Timeslot(int no, boolean check ) { 
        this.no = no; 
        this.check = check ; 
    } 

    public Room_Timeslot() { 
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
