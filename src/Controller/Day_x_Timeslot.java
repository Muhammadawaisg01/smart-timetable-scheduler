


package Controller;

public class Day_x_Timeslot {
    int day ; 
    int timeslot ;

    public Day_x_Timeslot(int day, int timeslot) {
        this.day = day;
        this.timeslot = timeslot;
    }

    public Day_x_Timeslot() {
    }
    

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(int timeslot) {
        this.timeslot = timeslot;
    }

    @Override
    public String toString() {
        return "Day_x_Timeslot{" + "day=" + day + ", timeslot=" + timeslot + '}';
    }
    
    
    
}
