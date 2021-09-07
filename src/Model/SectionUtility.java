

package Model;


import scheduler.pkg0.Scheduler;

import java.util.ArrayList;

public class SectionUtility {   
    
    public void assign_schedule_to_section(ArrayList<Scheduler> schedulers, ArrayList<Semester> semesters) {    
        for (int i = 0; i < schedulers.size(); i++) {   
            
            String sec = schedulers.get(i).section  ;   
            Scheduler scheduler = schedulers.get(i);
            int sem = schedulers.get(i).semester_no;
            
            for (Semester smstr: semesters) {
                if (smstr.no == sem) {
                    ArrayList<Section> sections = smstr.sections ;   
                    for (Section section: sections) {   
                        if (section.getNo().equalsIgnoreCase(sec)) {    
                            System.out.println(""); 
                            section.set_course(scheduler.day, scheduler.slot, scheduler.course);    
                            section.set_slot_no(scheduler.day, scheduler.slot) ;    
                            section.set_lecture_no(scheduler.day, scheduler.slot, scheduler.lecture_no);    
                            section.setRoom(scheduler.day, scheduler.slot, scheduler.room) ;    
                            section.set_check(scheduler.day, scheduler.slot, true) ;    
                        }
                    }
                }
            }
        }
    }
}


