
package Controller;

import Model.Course;
import Model.Professor;
import Model.ProfessorUtility;
import Model.Professor_Schedule;
import Model.Professor_Section_Allocation;
import Model.Section;
import Model.Section_Schedule;
import Model.Section_Day;
import Model.Section_Timeslot;
import Model.Semester;
import java.util.ArrayList;
import Model.Entities_Main_Arrays;
import Model.Professor_Lecture_Clash;
import static Controller.Runner.semesters;

public class Algo_for_Professor_assigning {
    
    static int clashes_variable = 0;
    public static ArrayList<Professor> professor_list = Entities_Main_Arrays.professor_list;
//  this method will add data (lecture's data) to the professor which are assigned to the section means day timeslot..s
    public static void section_to_Professor_Scheduling() {    // algo for Professor assigning     
        Professor prof = null;
        String course_code;
        int sem_no;
        String section_no;
        
        for (int var1 = 0; var1 < semesters.size(); var1++) {
            Semester smstr = semesters.get(var1);
            sem_no = smstr.getNo();
            for (int var2 = 0; var2 < smstr.getSections().size(); var2++) {     
                
                Section section = smstr.getSections().get(var2) ; 
                section_no = section.getId();
                
                ArrayList<Professor_Section_Allocation> allocations = section.getAllocations();
                    
                    for (int var4 = 0; var4 < allocations.size(); var4++) {
                        int prof_id = allocations.get(var4).getProf_id();
                        course_code = allocations.get(var4).getCourse_code();
                        boolean check = false;
                        for (int var5 = 0; var5 < professor_list.size(); var5++) {  
                            if (prof_id == professor_list.get(var5).getId()) {
                                prof = professor_list.get(var5);
                                check = true;
                                break;
                            }
                        }
                        if (check) {
                            Section_Schedule sec_schedule = section.getSchedule();
                            section_to_Professor_Timeslotting(sem_no, section_no, course_code, sec_schedule, prof ) ;    // int sem_no , String section
                        }
                    }
            }
        }
    }

    public String get_Course_Code(ArrayList<Course> courses, String course) {
        Course crs = new Course();
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getTitle().equalsIgnoreCase(course)) {
                crs = courses.get(i);
                break;
            }
        }
        return crs.getCourse_code();
    }


    //  This Method will take every slot of the section and assign them to the professor respective timeslot 
        public static void section_to_Professor_Timeslotting(int sem_no, String sec_no, String course_code, Section_Schedule sec_sch, Professor prof ) {
        for (int i = 0; i < sec_sch.getDays().size(); i++) {             //
            ArrayList<Section_Timeslot> timeslots = sec_sch.getDays().get(i).getTimeslots();
            for (int j = 0; j < timeslots.size(); j++) {
                if (timeslots.get(j).getCourse().equalsIgnoreCase(course_code)) { 
                    add_Data_to_Professor_Timeslot(sem_no, sec_no, timeslots.get(j), course_code, sec_sch.getDays().get(i), prof ) ; 
                }
            }
//            sec_sch.getDays().get(i)
        }
    }
        // add data to one Timeslot 
    public static void add_Data_to_Professor_Timeslot(int sem_no, String section_no ,Section_Timeslot slot, String course_code, Section_Day day, Professor prof) {
        Professor_Schedule prof_sch = prof.getSchedule();
        int day_no = day.getNo();
        int slot_no = slot.getSlot_no();
        String crs_code = course_code;
        String room = slot.getRoom();
        
        if (prof_sch.getDays().get(day_no).getTimeslots().get(slot_no).getCheck() == false) {  
            
            prof_sch.getDays().get(day_no).getTimeslots().get(slot_no).setCheck(true);
            prof_sch.getDays().get(day_no).getTimeslots().get(slot_no).setSlot_No(slot_no);
            prof_sch.getDays().get(day_no).getTimeslots().get(slot_no).setCourse_code(crs_code);
            prof_sch.getDays().get(day_no).getTimeslots().get(slot_no).setRoom(room);
            prof_sch.getDays().get(day_no).getTimeslots().get(slot_no).setSection(section_no);
            prof_sch.getDays().get(day_no).getTimeslots().get(slot_no).setSemester(sem_no);
        } else {                
                Professor_Lecture_Clash  clash_obj = new Professor_Lecture_Clash()  ;   
                clash_obj.setProfessor_id(prof.getId()) ; 
                clash_obj.setSemester(sem_no); 
                clash_obj.setSection(section_no) ;
                clash_obj.setCourse(course_code);
                clash_obj.setDay_no(day_no);
                clash_obj.setSlot_no(slot_no);
                clash_obj.setRoom(room);
                clash_obj.setIsresolved(false); 
                clash_obj.setLecture_no(slot.getLecture_no()); // lecture No
                prof.getClash_array().add(clash_obj) ;
                clashes_variable++  ;   
        }
    }
    
//public finding_Professor_Having_Clashes(){    
//}
        
//    public static void main( String[] args ) {    
//        Algo_for_Professor_assigning obj  = new Algo_for_Professor_assigning() ;   
//        obj.professor_Scheduling_Algorithm();
//    }
    public Algo_for_Professor_assigning() { 
        
    }

}   // Main Class

