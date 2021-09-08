

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

    public ArrayList<Professor_Lecture_Clash> getClash_array() {
        return clash_array;
    }

    public void setClash_array(ArrayList<Professor_Lecture_Clash> clash_array) {
        this.clash_array = clash_array;
    }
        
    
    public void display_Professor() {  // display tabular data

        System.out.println("________________________________________");
        int i = 0, j = 0;
        Professor_Schedule schedule = this.getSchedule();
        System.out.println("Professor ID :   "+this.id)  ;   
        System.out.println("Professor Name :   "+this.name)  ;   
        
        
//        System.out.println("Semester No:\t" + semesterNo);
//        System.out.println("Section_no      " + sec_no);
        for (int k = 0; k < schedule.getDays().size(); k++) {
//            System.out.println(schedule.days.get(k).no);
//            String d = "Days", r = "Room", cc = "Course Code", l = "Lec No", s ="Slot No" ;
//            System.out.printf("%-7s%-7s%-25s%-7s%7s", d, r, cc, l, s);
//            System.out.println("\n");
            System.out.printf("%-7s", WeekDays.names[schedule.getDays().get(k).no]);
//            System.out.println(schedule.days.get(k).timeslots.size() + "\t//////////////////////////////////////////////");
            for (j = 0; j < schedule.getDays().get(k).timeslots.size(); j++) {
                System.out.printf("%-7s", schedule.getDays().get(k).timeslots.get(j).room);
                System.out.printf("%-15s", schedule.getDays().get(k).timeslots.get(j).course_code);
                System.out.printf("%-15s", schedule.getDays().get(k).timeslots.get(j).semester);
                System.out.printf("%-15s", schedule.getDays().get(k).timeslots.get(j).section);
                try {
                    System.out.printf("%7d<----------->", schedule.getDays().get(k).timeslots.get(j).slot_no);
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex);
//                        System.out.println(j + "\t" + k);
                    System.exit(0);
                }
                if (schedule.getDays().get(k).timeslots.get(j).check == false) {
                    System.out.print("__");
                } else {

//                        System.out.print( Course.getCourse(course,schedule.days.get(k).timeslots.get(j).course_code) + " ") ; 
                }
            }
            System.out.println();
        }
        System.out.println("_________________________My Clashes_____________________________________");
        for(int var = 0 ; var < this.getClash_array().size() ; var++) { 
            System.out.print("ID  : "+getClash_array().get(var).getProfessor_id()+"\t")  ; 
            System.out.print("Semester  : "+getClash_array().get(var).getSemester()+"\t" )  ; 
            System.out.print("Section  : "+getClash_array().get(var).getSection()+"\t")  ; 
            System.out.print("Room  : "+getClash_array().get(var).getRoom()+"\t")  ; 
            System.out.print("Day  : "+getClash_array().get(var).getDay_no()+"\t")  ; 
            System.out.print("Slot No  : "+getClash_array().get(var).getSlot_no()+"\t")  ; 
            System.out.print("Course  : "+getClash_array().get(var).getCourse()+"\t")  ; 
            System.out.print("isResolved  : "+getClash_array().get(var).isIsresolved()+"\t")  ; 
            System.out.println("");
        }         
//        for(int var=0; var<this.getAllocations().size(); var++){
//            System.out.println(this.getAllocations().get(i).toString());
//        }
    }
    
    
}



