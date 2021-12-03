package Model.semester;

import Model.Course;
import java.util.ArrayList;

public class Section_Schedule {

    private ArrayList<Section_Day> days = new ArrayList<>();

    public Section_Schedule() {
        this.initialize_Section_Schedule();
    }

    public Section_Schedule(ArrayList<Course> sectionCourses) {

    }

    public void freeDaySlot(int day, int slot) {
        // set free day slot
        days.forEach(d -> {
            if (d.getNo() == day) {
                d.getTimeslots().forEach(sl -> {
                    if (sl.getSlot_no() == slot) {
                        sl.setCheck(false);
                        sl.setCourse("");
                        sl.setLecture_no(0);
                        sl.setRoom("");
                    }
                });
            }
        });
    }

    public void consumeDaySlot(int day, int slot, String room, String course, int lecture) {
        // free day slot
        days.forEach(d -> {
            if (d.getNo() == day) {
                d.getTimeslots().forEach(sl -> {
                    if (sl.getSlot_no() == slot) {
                        sl.setCheck(true);
                        sl.setCourse(course);
                        sl.setLecture_no(lecture);
                        sl.setRoom(room);
                    }
                });
            }
        });
    }

//    public Section_Schedule(ArrayList<Section_Day> days) {
//        this.days = days;
////        this.initialize_Section_Schedule();
//    }
    public void display() {
        for (Section_Day section_Day : days) {
            section_Day.display();
        }
    }

    public ArrayList<Section_Day> getDays() {
        return days;
    }

    public void setDays(ArrayList<Section_Day> days) {
        this.days = days;
    }

    public void initialize_Section_Schedule() {
        int c = 0;
        this.days = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Section_Day obj1 = new Section_Day();
            obj1.setTimeslots(new ArrayList<>());
            int slot_no = 0;
            String course = "";
            int lecture_no = 0;
            boolean check = false;
            String room = "";
            for (int j = 0; j < 6; j++) { // 6 timeslots
                Section_Timeslot obj = new Section_Timeslot(j++, room, course, lecture_no, check);
                obj1.timeslots.add(obj);
            }
            obj1.setNo(i);
            this.days.add(obj1);
        }
    }
}
