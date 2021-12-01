



package Model;

public class Lectures {
    private String sectionID;
    private String coursCode;
    private String roomNo;
    private int day;
    private int slot;
    private boolean isLab;

    public Lectures(String sectionID, String coursCode, String roomNo, int day, int slot, boolean isLab) {
        this.sectionID = sectionID;
        this.coursCode = coursCode;
        this.roomNo = roomNo;
        this.day = day;
        this.slot = slot;
        this.isLab = isLab;
    }

    @Override
    public String toString() {
        return "Lectures{" + "sectionID=" + sectionID + ", coursCode=" + coursCode + ", roomNo=" + roomNo + ", day=" + day + ", slot=" + slot + ", isLab=" + isLab + '}';
    }
    
}
