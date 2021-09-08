

package Model ; 

import java.util.ArrayList ; 

public class Professor { 
    int id ;    
    String name ;   
    
    Professor_Schedule schedule ; 
    ArrayList<Professor_Lecture_Clash> clash_array =  new ArrayList<>();     
    
    public Professor( int id, String name ) { 
        this.id = id ; 
        this.name = name ; 
        schedule = new Professor_Schedule();
    }   
    
    public Professor() {
    }
    
    @Override
    public String toString() {
        return "Professor{" + "id=" + id + ", name=" + name + '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Professor_Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Professor_Schedule schedule) {
        this.schedule = schedule;
    }
    
    public void display_Professor() {  // display tabular data

        System.out.println("________________________________________");
        int i = 0, j = 0;
        Professor_Schedule schedule = this.getSchedule();
        System.out.println("Professor ID    "+this.id)  ;   
        System.out.println("Professor Name    "+this.name)  ;   
        
        
//        System.out.println("Semester No:\t" + semesterNo);
//        System.out.println("Section_no      " + sec_no);
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
                System.out.printf("%-15s", schedule.days.get(k).timeslots.get(j).semester);
                System.out.printf("%-15s", schedule.days.get(k).timeslots.get(j).section);
                try {
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



