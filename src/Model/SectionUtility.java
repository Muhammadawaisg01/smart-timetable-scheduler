

package Model;
import static scheduler.pkg0.Runner.scheduler;
import static scheduler.pkg0.Runner.semesters;


import scheduler.pkg0.Scheduler;

import java.util.ArrayList;

public class SectionUtility {   
    
    public static void assign_schedule_to_section() {    
        for (int i = 0; i < scheduler.size(); i++) {   
            
            String sec = scheduler.get(i).section;
            Scheduler schedule= scheduler.get(i);
            int sem = scheduler.get(i).semester_no;
            
            for (Semester smstr: semesters) {
                if (smstr.no == sem) {
                    ArrayList<Section> sections = smstr.sections ;   
                    for (Section section: sections) {   
                        if (section.getNo().equalsIgnoreCase(sec)) {    
//                            System.out.println(""); 
                            section.set_course(schedule.day, schedule.slot, schedule.course);    
                            section.set_slot_no(schedule.day, schedule.slot) ;    
                            section.set_lecture_no(schedule.day, schedule.slot, schedule.lecture_no);    
                            section.setRoom(schedule.day, schedule.slot, schedule.room) ;    
                            section.set_check(schedule.day, schedule.slot, true) ;    
                        }
                    }
                }
            }
        }
    }
}


