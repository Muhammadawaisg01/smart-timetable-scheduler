

package Model ; 

import Model.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import scheduler.pkg0.Runner;
import scheduler.pkg0.Scheduler;


public class StdUtility {
    ArrayList<Scheduler> scheduler = Runner.scheduler;
    public static ArrayList<Student> student_list = Entities_Main_Arrays.student_list;
    ArrayList<String> array = new ArrayList<>();

public void reading_Student_From_DB() { 
    
}
    
//    public void readingCourseRegistration() {   
//        String line = "", arr[];
//        int i = 1;
//        int j = 0;
//        File f = new File("Course_registration.txt");
//        try {
//            Scanner file = new Scanner(f);
//            while (file.hasNext() ) {
//                i = 1 ;
//                line = file.next() ;
//                arr = line.split(",");
//                while (i < arr.length) {
//                    student_list.get(j).registered_courses.add(new Course(arr[i] ) ) ; 
//                    i++;
//                }
//                arr = null;
//                i = 1;
//                j++;
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
////        for (String str : array) {
////            System.out.println(str);
////        }
//    }
//    public StdUtility() {
//        int i = 1;
//        String sec = "1";
//        String[] arr;
//        String line;
//        File f = new File("Students.txt");
//        try {
//            Scanner file = new Scanner(f);
//            while (file.hasNext()) {
//                line = file.nextLine();
//                arr = line.split(", ");
//                if (i <= 10) {
//                    sec = "1";
//                }
//                if (i <= 20 && i > 10) {
//                    sec = "2";
//                }
//                if (i <= 30 && i > 20) {
//                    sec = "3";
//                }
//                if (i <= 40 && i > 30) {
//                    sec = "4";
//                }
//
////                student_list.add(new Student(arr[0], arr[1], 7, sec)) ; 
//                i++ ; 
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex);
//        }
//        readingCourseRegistration();
//
//        for (int j = 0; j < student_list.size(); j++) { 
//            System.out.println(student_list.get(j).toString() ) ; 
//        } 
//
////        Student_Timeslot std_slot = new Student_Timeslot();
////        std_slot.semester = "";
////        std_slot.section = "";
////        std_slot.slot_no = 0;
////        std_slot.check = false;
////        std_slot.course = "";
////        std_slot.lecture_no = 0;
////        std_slot.room = "";
////        Day_for_Student std_day = new Day_for_Student();
////        std_day.name = "Mon";
////        std.add(new Student("01","Ali","7",1, )  )  
//    }
    
    public void section_to_Student_Scheduling() {   // assigning schedule to students   

        ArrayList<Student> new_std_array = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<Scheduler> new_schedule_array = new ArrayList<>() ; 
        
        String room, course, section ; 
        int sem_no = 0, lec_no = 0, timeslot,day ; 
        String[] sections = {"1", "2", "3", "4"} ; 
        
        for(int k = 0 ; k < scheduler.size(); k++) { 
            new_schedule_array.add(scheduler.get(k) ) ;
        }
        
        for ( int i = 0; i < scheduler.size(); i++ ) { 
//            if (scheduler.get(i).semester_no == 7 ) {   
                
                for (int sec = 0; sec < sections.length; sec++ ) { 
                    if (scheduler.get(i).section.equalsIgnoreCase(sections[sec] ) ) { 
                        
                        section = scheduler.get(i).section;
//                                   getting data from schedule array
                        room = scheduler.get(i).room; 
                        day = scheduler.get(i).day;
                        timeslot = scheduler.get(i).slot;
                        course = scheduler.get(i).course;
                        sem_no = scheduler.get(i).semester_no;
                        lec_no = scheduler.get(i).lecture_no;
                        for (int var = 0; var < student_list.size(); var++) {
                            if (student_list.get(var).section_id.equalsIgnoreCase(sections[sec])) {
                                Student std = student_list.get(var);
                                Student_Schedule std_sch = std.getSchedule();
                                System.out.println(std.toString());
//                                indexes.add(var);
                                for (int k = 0; k < std_sch.days.size(); k++) {
//                            student_list.get(j).days.get(k).name = day;
                                    for (int m = 0; m < std_sch.days.get(k).timeslots.size(); m++) {
                            
                            if (timeslot == std_sch.days.get(k).timeslots.get(m).slot_no && 
                                    std_sch.days.get(k).timeslots.get(m).check==false &&
                                    std_sch.days.get(k).no ==day  )  { 
//                                            System.out.println(student_list.get(j).days.get(k).timeslots.get(m));
                                            std_sch.days.get(k).timeslots.get(m).check = true;
//                                            System.out.println("I am the course \t\n"+course+"\n");
                                            std_sch.days.get(k).timeslots.get(m).lecture_no = lec_no;
                                            std_sch.days.get(k).timeslots.get(m).room = room;
                                            std_sch.days.get(k).timeslots.get(m).course_code = course;
                                            std_sch.days.get(k).timeslots.get(m).semester = sem_no;
                                            std_sch.days.get(k).timeslots.get(m).section = section;
//                                            System.out.println(student_list.get(j).days.get(k).timeslots.get(m));
//                                            System.out.println(std.toString());
                                        }
                                    }

                                }
                            }
                        }
                    }
                }
                // adding Schedule data to the student Schedule
//                for (int j = 0; j < student_list.size(); j++) {
//                    if (student_list.get(j).section.equalsIgnoreCase("1")) {
//                        for (int k = 0; k < student_list.get(j).days.size(); k++) {
////                            student_list.get(j).days.get(k).name = day;
//                            for (int m = 0; m < student_list.get(j).days.get(k).timeslots.size(); m++) {
//                                if (timeslot == student_list.get(j).days.get(k).timeslots.get(m).slot_no) {
//                                    System.out.println(student_list.get(j).days.get(k).timeslots.get(m));
//                                    student_list.get(j).days.get(k).timeslots.get(m).check = true;
//                                    student_list.get(j).days.get(k).timeslots.get(m).course = course;
//                                    student_list.get(j).days.get(k).timeslots.get(m).lecture_no = lec_no;
//                                    student_list.get(j).days.get(k).timeslots.get(m).room = room;
//                                    student_list.get(j).days.get(k).timeslots.get(m).course = course;
//                                    student_list.get(j).days.get(k).timeslots.get(m).semester = sem_no;
//                                    student_list.get(j).days.get(k).timeslots.get(m).section = section;
//                                    System.out.println(student_list.get(j).days.get(k).timeslots.get(m));
//                                }
//                            }
//
//                        }
//                    }
//                }
//            } else {
//                continue;
//            }
        }
    }

}
