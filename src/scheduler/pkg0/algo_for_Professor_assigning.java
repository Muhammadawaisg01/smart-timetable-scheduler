

package scheduler.pkg0 ; 

import Model.Course;
import Model.CourseUtility;
import Model.Professor  ;   
import Model.ProfessorUtility   ;  
import Model.Professor_Schedule;
import Model.Professor_Section_Allocation;
import Model.Section;
import Model.Section_Schedule;
import Model.Section_Day;
import Model.Section_Timeslot;
import Model.Semester;
import java.util.ArrayList  ;   
import scheduler.pkg0.Runner ; 
import Model.Entities_Main_Arrays;

public class algo_for_Professor_assigning { 
    
//    ArrayList<Course> courses  =  CourseUtility.readCourseFile();    // read data 
    
    public ArrayList<Professor> professor_list = Entities_Main_Arrays.professor_list;  
    
    
    public void section_to_Professor_Scheduling()  {    // algo for Professor assigning     
    
    ArrayList<Semester> semesters = Runner.semesters ; 
    Professor prof =null ;   
    String course_code;
    int sem_no;
    String section_no;
    
//    for(int i = 0 ; i < professor_list.size() ; i++ ) {       
//        System.out.println(professor_list.get(i).toString())    ;   
//    }
        
        for(int var1 = 0 ; var1 < semesters.size(); var1++)  {   
            Semester smstr = semesters.get(var1) ; 
            sem_no = smstr.getNo()  ;   
            for( int var2 = 0 ; var2 < smstr.getSections().size(); var2++ ) {   
                
                ArrayList<Section> sections = smstr.getSections() ; 
                for(int var3 = 0; var3 < sections.size(); var3++ ) { 
                    ArrayList<Professor_Section_Allocation> allocations = sections.get(var3).getAllocations() ; 
                    
                    section_no = sections.get(var3).getNo() ;   
                    
                    for(int var4 = 0 ; var4 < allocations.size(); var4++ ) { 
                    int prof_id = allocations.get(var4).getProf_id() , var5=0 ; 
                    course_code = allocations.get(var4).getCourse_code() ; 
                    boolean check = false ;     
                    for( var5 = 0; var5 < professor_list.size(); var5++ ) {     
                        if(prof_id == professor_list.get(var5).getId() )    {   
                            prof = professor_list.get(var5);
                            check = true    ;   
                            break   ;
                        }   
                    }
                    if(check)   {   
                        Section_Schedule sec_schedule =  sections.get(var3).getSchedule();
                        Professor_Schedule prof_schedule = prof.getSchedule();
                        section_to_Professor_Timeslotting(sem_no, section_no, sec_schedule, prof_schedule) ;   // int sem_no , String section
                    }
                }
            }
        }
    }    
}

    public String get_Course_Code(ArrayList<Course> courses , String course) {  
        Course crs = new Course();  
        for(int i = 0 ; i < courses.size() ; i++){  
            if(courses.get(i).getTitle().equalsIgnoreCase(course) )  {   
                crs = courses.get(i);   
                break;
            }
        }
        return crs.getCourse_code();
    }   
    
    
    public Section_Day[] search_Day(Section sec, String course_code ) { 
        Section_Day[] days = new Section_Day[2]; 
        int var = 0 ; 
        for(int i = 0 ; i < sec.getSchedule().getDays().size(); i++) { 
            for(int j = 0 ; j < sec.getSchedule().getDays().get(i).getTimeslots().size(); j++){ 
            ArrayList<Section_Timeslot> timeslots= sec.getSchedule().getDays().get(i).getTimeslots();   
                if( timeslots.get(j).isCheck() )    {
//                    String crs_code = get_Course_Code( courses, timeslots.get(j).getCourse() ) ; 
                    if(crs_code.equalsIgnoreCase(course_code) )     {   
                    days[var] =  sec.getSchedule().getDays().get(i) ;   var++;
                    }
                }
            }
        }
        return days ;
    }
    
    public Section_Timeslot[] search_Timeslot(Section sec, String course_code ) {   
        Section_Timeslot[] slots = new Section_Timeslot[2]; 
        int var = 0 ; 
        for(int i = 0 ; i < sec.getSchedule().getDays().size(); i++) { 
            for(int j = 0 ; j < sec.getSchedule().getDays().get(i).getTimeslots().size(); j++){ 
            ArrayList<Section_Timeslot> timeslots= sec.getSchedule().getDays().get(i).getTimeslots(); 
            
                String crs_code = get_Course_Code( courses, timeslots.get(j).getCourse() ) ; 
                if(crs_code.equalsIgnoreCase(course_code) )     {   
//                    slots[var] =  sec.getSchedule().getDays().get(i).getTimeslots() ;   var++ ; 
                }
            }
        }
        return slots ;
    }
    
    public void add_Data_to_Professor_Timeslot(int sem_no, String section_no, Section_Timeslot slot, Section_Day day,  Professor_Schedule prof_sch) {  
        int day_no= day.getNo();    
        int slot_no = slot.getSlot_no() ;   
        String crs_code=slot.getCourse() ;
        String room= slot.getRoom(); 
//        boolean check = false;
//        if(){}
        
        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setCheck(true)  ; 
        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setNo(slot_no)  ; 
        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setCourse_code(crs_code) ; 
        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setRoom(room) ; 
        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setSection(section_no) ; 
        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setSemester(sem_no) ; 
                
    }
    
    public void section_to_Professor_Timeslotting
        (int sem_no, String sec_no, Section_Schedule sec_sch , Professor_Schedule prof_sch ) {
        
        for(int i = 0 ; i < sec_sch.getDays().size() ; i++) {             //
            for(int j = 0 ; j < sec_sch.getDays().get(i).getTimeslots().size() ; j++) { 
                ArrayList<Section_Timeslot> timeslots = sec_sch.getDays().get(i).getTimeslots() ;   
                
                if( timeslots.get(j).isCheck() )  {   
                    add_Data_to_Professor_Timeslot(sem_no, sec_no,  timeslots.get(j), sec_sch.getDays().get(i), prof_sch ) ; 
                }
            }   
//            sec_sch.getDays().get(i)
        }
    }
    
    
//    public static void main( String[] args ) {    
//        algo_for_Professor_assigning obj  = new algo_for_Professor_assigning() ;   
//        obj.professor_Scheduling_Algorithm();
//    }
    
    public algo_for_Professor_assigning() { 
    }   

    
}   // Main Class
