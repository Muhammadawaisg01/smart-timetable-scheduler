
package Model ;

import java.util.ArrayList;

public class Section {   

    String no ; 
//    int strength;           // student strength
    
    ArrayList<Course> courses ;      
    
    ArrayList<Professor_Section_Allocation> allocations ;   
    
    Section_Schedule schedule ;



    public ArrayList<Professor_Section_Allocation> getAllocations() {
        return allocations;
    }
    public void setDay(int index , int day_no){
        schedule.days.get(index).no = day_no;
    }

    public void setRoom(int day_index,int slot_no, String room )  {
        schedule.days.get(day_index).timeslots.get(slot_no).room = room  ;
    }
    public void set_lecture_no(int day_index,int slot_no , int lec_no )  {
        schedule.days.get(day_index).timeslots.get(slot_no).lecture_no = lec_no  ;
    }
    public void set_course(int day_index,int slot_no, String course )  {
        schedule.days.get(day_index).timeslots.get(slot_no).course = course  ;
    }
    public void set_check(int day_index,int slot_no ,boolean check)  {
        schedule.days.get(day_index).timeslots.get(slot_no).check = check  ;
    }
    public void set_slot_no(int day_index,int slot_no)  {
        schedule.days.get(day_index).timeslots.get(slot_no).slot_no = slot_no  ;
    }

    public void setAllocations(String course, int profId) {
        this.allocations.add(new Professor_Section_Allocation(profId, course));
    }

    public Section_Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Section_Schedule schedule) {
        this.schedule = schedule;
    }

    public Section(String no ) {
        this.no = no ; 
    }   
    
    public Section() {
    }
    
    public String getNo() {
        return no;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }
    
    @Override
    public String toString() {
        return "Section{" + "no=" + no + '}';
    }
    
}
