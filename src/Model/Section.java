
package Model;

import java.util.ArrayList;
import static scheduler.pkg0.Runner.course;

public class Section {

    String no;
//    int strength;           // student strength

    ArrayList<Course> sectionCourses = new ArrayList<>();
    ArrayList<Professor_Section_Allocation> allocations = new ArrayList<>();
    
    Section_Schedule schedule = new Section_Schedule();
    
    
    public ArrayList<Professor_Section_Allocation> getAllocations() {
        return this.allocations;
    }

    public void setDay(int index, int day_no) {
        schedule.days.get(index).no = day_no;
    }

    public void setRoom(int day_index, int slot_no, String room) {
        schedule.days.get(day_index).timeslots.get(slot_no).room = room;
    }

    public void set_lecture_no(int day_index, int slot_no, int lec_no) {
        schedule.days.get(day_index).timeslots.get(slot_no).lecture_no = lec_no;
    }

    public void set_course(int day_index, int slot_no, String course) {
//        System.out.println(schedule.days.get(day_index).timeslots.size() + "\tSlot Number: " + slot_no);

        schedule.days.get(day_index).timeslots.get(slot_no).course_code = course;
    }

    public void set_check(int day_index, int slot_no, boolean check) {
        schedule.days.get(day_index).timeslots.get(slot_no).check = check;
    }

    public void set_slot_no(int day_index, int slot_no) {
        schedule.days.get(day_index).timeslots.get(slot_no).slot_no = slot_no;
    }

    public void setAllocations(int profId, String sec, int sem, String course) {
//        System.out.println("Sectionnnnnnnn: \t\t"+sec);
//        System.out.println("Semesterrrrrrrrr: \t\t"+sem);
//        System.out.println("Professor ID:\t\t"+profId);
//        System.out.println("Course    "+course);
        this.allocations.add(new Professor_Section_Allocation(profId, sec, sem, course));
    }

    public Section_Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Section_Schedule schedule) {
        this.schedule = schedule;
    }

    public Section(String no) {
        this.no = no;
    }

    public Section() {
    }

    public String getNo() {
        return no;
    }

    public ArrayList<Course> getCourses() {
        return this.sectionCourses;
    }

    public void addCourse(Course crs) {
        this.sectionCourses.add(crs);
    }

    @Override
    public String toString() {
        return "Section{" + "no=" + no + '}';
    }

    public void displaySection(int semesterNo) {  // display tabular data

        System.out.println("________________________________________");
        int i = 0, j = 0;
        Section_Schedule schedule = this.getSchedule();
        System.out.println("Semester No:\t" + semesterNo);
        System.out.println("Section_no      " + this.no);
        for (int k = 0; k < schedule.days.size(); k++) {
//            System.out.println(schedule.days.get(k).no);
//            String d = "Days", r = "Room", cc = "Course Code", l = "Lec No", s ="Slot No" ;
//            System.out.printf("%-7s%-7s%-25s%-7s%7s", d, r, cc, l, s);
//            System.out.println("\n");
            System.out.printf("%-7s", WeekDays.names[schedule.days.get(k).no]);
//            System.out.println(schedule.days.get(k).timeslots.size() + "\t//////////////////////////////////////////////");
            for (j = 0; j < schedule.days.get(k).timeslots.size(); j++) {
                System.out.printf("%-7s", schedule.days.get(k).timeslots.get(j).room);
                System.out.printf("%-15s", schedule.days.get(k).timeslots.get(j).course_code);
//                System.out.printf("%-7s", schedule.days.get(k).timeslots.get(j).lecture_no);
//                    int check = 0;
                try {
//                        System.out.println(schedule.days.get(k).timeslots.get(j).slot_no + "\txxxxxxxxxxxxxxxx");
                    System.out.printf("%7d<----------->", schedule.days.get(k).timeslots.get(j).slot_no);
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex);
//                        System.out.println(j + "\t" + k);
                    System.exit(0);
                }
                if (schedule.days.get(k).timeslots.get(j).check == false) {
                    System.out.print("__");
                } else {

//                        System.out.print( Course.getCourse(course,schedule.days.get(k).timeslots.get(j).course_code) + " ") ; 
                }
            }
            System.out.println();
        }
        
//        for(int var=0; var<this.getAllocations().size(); var++){
//            System.out.println(this.getAllocations().get(i).toString());
//        }
    }
}

