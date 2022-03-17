
package Model;

public class FreeSlots {
    private int day;
    private int slot;
    private String room;

    public FreeSlots(int day, int slot, String room) {
        this.day = day;
        this.slot = slot;
        this.room = room;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }
    
    
}
