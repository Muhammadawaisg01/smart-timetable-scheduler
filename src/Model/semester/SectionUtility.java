

package Model.semester;
import static Controller.Runner.scheduler;
import static Model.Entities_Main_Arrays.semesters;


import Model.Scheduler;

import java.util.ArrayList;

public class SectionUtility {   
    
    public static void assign_schedule_to_section() {           // assigns generated schedule to all the respective sections    
        for (int i = 0; i < scheduler.size(); i++) {    
            
            String sec = scheduler.get(i).getSection();
            Scheduler schedule= scheduler.get(i);
            int sem = scheduler.get(i).getSemester_no();
            
            for (Semester smstr: semesters  ) {     
                if (smstr.getNo() == sem) {
                    ArrayList<Section> sections = smstr.getSections() ;   
                    for (Section section: sections) {   
                        if (section.getId().equalsIgnoreCase(sec)) {  
                            section.set_course(schedule.getDay(), schedule.getSlot(), schedule.getCourse());    
                            section.set_slot_no(schedule.getDay(), schedule.getSlot()) ;    
                            section.set_lecture_no(schedule.getDay(), schedule.getSlot(), schedule.getLecture_no());    
                            section.setRoom(schedule.getDay(), schedule.getSlot(), schedule.getRoom()) ;    
                            section.set_check(schedule.getDay(), schedule.getSlot(), true) ;    
                        }
                    }
                }
            }
        }
    }
}


