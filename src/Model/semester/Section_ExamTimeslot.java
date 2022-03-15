
package Model.semester;

public class Section_ExamTimeslot {
    
    private int slot_no;
    private boolean check;

    public Section_ExamTimeslot() {
    }

    public Section_ExamTimeslot(int slot_no, boolean check) {
        this.slot_no = slot_no;
        this.check = check;
    }

    public int getSlot_no() {
        return slot_no;
    }

    public void setSlot_no(int slot_no) {
        this.slot_no = slot_no;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
    
    
}
