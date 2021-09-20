

package scheduler.pkg0;

import Model.Course;
import Model.Entities_Main_Arrays;
import static Model.Entities_Main_Arrays.semesters;
import Model.Section;
import Model.Section_Schedule;
import Model.Semester;
import static Model.StdUtility.student_list;
import Model.Student;
import Model.Student_Schedule;
import java.util.ArrayList;

public class Algo_For_Student_Assigning {   
    
    
    
    // assigning section schedule to all the students of the same sections  
    public static void assign_Data_from_Section_to_Student_Schedule() {   // assigning schedule to students       
    
    Student std = null;
        
        ArrayList<Student> student_list = Entities_Main_Arrays.student_list ;
        ArrayList<Scheduler> schedule_array1 = Runner.scheduler; 
        
        for ( int var1 = 0; var1 < student_list.size(); var1++ ) { 
            std =  student_list.get(var1) ; 
            String std_sec_id =  std.getSection_id() ;    
            int semester_no = Section.get_Semester_of_Section(std_sec_id) ; 
            System.out.println("");
            ArrayList<Course> registered_courses =  std.getRegistered_courses() ;
            ArrayList<Scheduler> schedule_array2 = new ArrayList<>() ; 
            
            for (int var2=0 ; var2 < schedule_array1.size() ; var2++ ) {    

                if (schedule_array1.get(var2).getSection().equalsIgnoreCase(std_sec_id ) && schedule_array1.get(var2).getSemester_no() == semester_no ) { 
                    System.out.println(schedule_array1.get(var2).toString()+"HEEElllo");
                    schedule_array2.add( schedule_array1.get(var2) ) ; 
                }
            }

            for(int var3 = 0 ; var3 < schedule_array2.size() ; var3++)  {               

                for(int var4 = 0 ; var4 < registered_courses.size() ; var4++ )  {   
                    Course crs = registered_courses.get(var4) ; 
                    Student_Schedule std_sch = std.getSchedule() ;
                    if(crs.getTitle().equalsIgnoreCase(schedule_array2.get(var3).getCourse() ) ) { 
                        // add data from one timeslot of scheduler array to student corresponding timeslot
                        // below method will do this job
                        section_to_Student_Timeslotting(schedule_array2.get(var3) , std_sch, std_sec_id ,semester_no) ; 
                    }
                }
                // if his registered courses are completed then loop ends but if he has registered more courses then 
                // logic will be implemented below
                
            }
        }    
    }    
    // get data from one timeslot of the scheduler and add that to the corresponding timeslot of the student
    public static void section_to_Student_Timeslotting(Scheduler sch, Student_Schedule std_sch, String std_sec_id, int semester_no ){
        int day_no = sch.getDay();
        int slot_no = sch.getSlot() ; 
        String course = sch.getCourse() ;
        String rm = sch.getRoom() ; 
        int lecture_no = sch.getLecture_no() ;                            

        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setCheck(true);
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setSlot_no(slot_no); 
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setCourse_code(course); 
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setRoom(rm);
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setLecture_no(lecture_no);  
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setSection(std_sec_id);  
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setSemester(semester_no); 
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setIsLab(false);         
    }
    
}       // main class   
