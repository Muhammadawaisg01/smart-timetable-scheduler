

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


public class algo_for_Professor_assigning { 
    
//    ArrayList<Course> courses  =  CourseUtility.readCourseFile();    // read data
    
    
    public ArrayList<Professor> professor_list = ProfessorUtility.readProfFile("Faculty.txt")   ;  
    
    
    
public void professor_Scheduling_Algorithm()  {    // algo  for Professor assigning

    ArrayList<Semester> semesters = Runner.semesters    ;   
    Professor prof;
    String course_code;
//    for(int i = 0 ; i < professor_list.size() ; i++ ) {       
//        System.out.println(professor_list.get(i).toString())    ;   
//    }
        
        for(int j = 0 ; j < semesters.size(); j++)  {   
            Semester smstr = semesters.get(j) ; 
            for( int k = 0 ; k < smstr.getSections().size(); k++ ) {    
                
                ArrayList<Section> sections = smstr.getSections() ; 
                for(int var = 0; var < sections.size(); var++ ) { 
                    ArrayList<Professor_Section_Allocation> allocations = sections.get(var).getAllocations() ; 
                    
                    for(int l = 0 ; l < allocations.size(); l++ ) { 
                    int prof_id = allocations.get(l).getProf_id() , m=0 ;   
                    course_code = allocations.get(l).getCourse_code() ; 
                    boolean check = false ;       
                    for( m = 0; m < professor_list.size(); m++ ) {  
                        if(prof_id == professor_list.get(m).getId() )    {   
                            prof = professor_list.get(m);
                            check = true    ;   
                            break   ;
                        }           
                    }
                    if(check){
                        Section_Schedule sec_schedule =  sections.get(var).getSchedule();
                        Professor_Schedule prof_schedule =professor_list.get(m).getSchedule();
                        section_to_Professor_Scheduling(sec_schedule,prof_schedule) ; 
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
                    String crs_code = get_Course_Code( courses, timeslots.get(j).getCourse() ) ; 
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
    
    public void add_Data_to_Professor_Timeslot(Section_Timeslot slot, Section_Day day,  Professor_Schedule prof_sch) {  
        int day_no= day.getNo();    
        int slot_no = slot.getSlot_no() ;   

        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setCheck(true)  ; 
        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setNo(slot_no)  ; 
        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setRoom(slot.getRoom() ) ;    
        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setSection(slot.)  ; 
        prof_sch.days.get(day_no).getTimeslots().get(slot_no).setCheck(true)  ; 
        
    }
    
    public void section_to_Professor_Scheduling(Section_Schedule sec_sch , Professor_Schedule prof_sch ) {
        
        for(int i = 0 ; i < sec_sch.getDays().size() ; i++) {             //
            for(int j = 0 ; j < sec_sch.getDays().get(i).getTimeslots().size() ; j++) { 
                ArrayList<Section_Timeslot> timeslots = sec_sch.getDays().get(i).getTimeslots() ;                  
                
                if( timeslots.get(j).isCheck() )  {   
                    add_Data_to_Professor_Timeslot(timeslots.get(j), sec_sch.getDays().get(i), prof_sch ) ; 
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
