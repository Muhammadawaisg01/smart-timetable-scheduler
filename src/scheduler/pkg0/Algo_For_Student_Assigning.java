package scheduler.pkg0;

import Model.Course;
import Model.Entities_Main_Arrays;
import Model.Section;
import Model.Section_Schedule;
import Model.Semester;
import static Model.StdUtility.student_list;
import Model.Student;
import Model.Student_Day;
import Model.Student_Schedule;
import Model.Student_Timeslot;
import java.util.ArrayList;
import static scheduler.pkg0.Runner.semesters;
import Model.Section_Day;
import Model.Section_Timeslot;

public class Algo_For_Student_Assigning {

    // assigning section schedule to all the students of the same sections  
    public static void assign_Data_from_Section_to_Student_Schedule() {   // assigning schedule to students     

        Student std = null;
        ArrayList<Student> student_list = Entities_Main_Arrays.student_list;
        ArrayList<Scheduler> schedule_array1 = Runner.scheduler;

//    ArrayList<Scheduler> schedule_array2 = new ArrayList<>() ;        
        for (int var1 = 0; var1 < student_list.size(); var1++) {          //start from picking from first student  
            std = student_list.get(var1);

            String std_sec_id = std.getSection_id();
            int semester_no = Section.get_Semester_of_Section(std_sec_id);

            ArrayList<Course> registered_courses = std.getRegistered_courses();          // it will contain all the courses that atudent has registered 
            ArrayList<Course> extra_courses = new ArrayList<>();   // in this array those courses will be stored which student has picked and offered in different semesters and sections not in his semester     

            section_to_Student_Timeslotting(std, std_sec_id, semester_no);       // method to assign regular courses to the student
// if his registered courses are completed then loop ends but if he has registered more courses then 
            // logic will be implemented 
            extra_courses = get_extra_courses_Student_has_picked(std, registered_courses);
            if (extra_courses.size() > 0) {
                // call the main algorithm method   
                find_compatible_section_for_student_extra_courses(std, extra_courses, semesters);
                System.out.println("/////////////////////////////////////////////////////////////");
                System.out.println("No courses registered" + std.getName());
//                System.exit(1);
            } else {
                System.out.println("No courses registered" + std.getName());
//                System.exit(1);
            }
        }
    }

    // get data from one timeslot of the scheduler and add that to the corresponding timeslot of the student
    public static void section_to_Student_Timeslotting(Student std, String std_sec_id, int semester_no) {

        Section sec = get_section(std_sec_id, semester_no);
        Section_Schedule sec_sch = sec.getSchedule();
        Student_Schedule std_sch = std.getSchedule();
        ArrayList<Course> registered_courses = std.getRegistered_courses();     // it will contain all the courses that atudent has registered 
        boolean isfound = false;
        for (Course crs : registered_courses) {
            isfound = find_course_in_section(crs, sec);
            if (isfound) {
                for (int var1 = 0; var1 < sec_sch.getDays().size(); var1++) {
                    Section_Day day = sec_sch.getDays().get(var1);
                    for (int var2 = 0; var2 < day.getTimeslots().size(); var2++) {
                        Section_Timeslot slot = day.getTimeslots().get(var2);
//                        System.out.println("I AM SLOT GET COURSE  hello WORLD" + slot.getCourse());
//                        System.out.println("I AM ONE OF THE REGISTERED COURSES     " + crs.getTitle());
                        if (slot.getCourse().equalsIgnoreCase(crs.getTitle())) {
                            add_Data_to_Student_Timeslot(std_sch, semester_no, std_sec_id, slot, var1, var2);
                        }
                    }
                }
            }
        }

    }

    public static void add_Data_to_Student_Timeslot(Student_Schedule std_sch, int semester_no, String sec_id, Section_Timeslot slot, int day_no, int slot_no) {

        String course = slot.getCourse();
        System.out.println("I AM THE COURSE      " + course);
        String rm = slot.getRoom();
        int lecture_no = slot.getLecture_no();

        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setSection(sec_id);
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setSemester(semester_no);
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setCheck(true);
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setSlot_no(slot_no);
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setCourse_code(course);
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setRoom(rm);
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setLecture_no(lecture_no);
        std_sch.getDays().get(day_no).getTimeslots().get(slot_no).setIsLab(false);
    }

    public static boolean find_course_in_section(Course course, Section sec) {
        for (int var1 = 0; var1 < sec.getCourses().size(); var1++) {
            Course sec_course = sec.getCourses().get(var1);
            if (sec_course.getTitle().equalsIgnoreCase(course.getTitle())) {
                System.out.println("I am ttrruuee");
                return true;
            }
        }
        System.out.println("I am ffaallssee");
        return false;
    }

    public static ArrayList<Course> get_extra_courses_Student_has_picked(Student std, ArrayList<Course> registered_courses) {        // parameters of this method

        boolean check;
        ArrayList<Course> extra_courses = new ArrayList<>();
        Student_Schedule std_sch = std.getSchedule();
        for (Course crs : registered_courses) {
            check = false;
            for (Student_Day std_day : std_sch.getDays()) {
                for (Student_Timeslot slot : std_day.getTimeslots()) {
//                    System.out.println("I am the Title   "+crs.getTitle());
//                    System.out.println("I am the course_code   "+slots.getCourse_code());
                    if (crs.getTitle().equalsIgnoreCase(slot.getCourse_code())) {
                        check = true;
                        break;
                    }
                }
                if (check) {
                    break;
                }
            }
            if (!check) {
                extra_courses.add(crs);
            }
        }
        return extra_courses;
    }

    public static void find_compatible_section_for_student_extra_courses(Student std, ArrayList<Course> extra_courses, ArrayList<Semester> semesters) {
        for (Course crs : extra_courses) {
            boolean check = false;
            for (Semester smstr : semesters) {
                ArrayList<Section> semester_sections = smstr.getSections();
                for (Section sec : semester_sections) {
                    ArrayList<Course> section_courses = sec.getCourses();
                    for (Course section_course : section_courses) {
                        if (section_course.getTitle().equalsIgnoreCase(crs.getTitle())) {

                            if (student_has_clash_with_this_section(std, sec, crs)) {
                                // check for other sections of other semesters of all programs in the department
//                                System.out.println("clash");
//                                System.exit(1);
                            } else if (!student_has_clash_with_this_section(std, sec, crs)) {       // if student has no clash with this section
                                // implement other checks like Lab and section strength and then add this student 
                                //to this section
//                                section_to_Student_Timeslotting(std, sec, crs ) ; 
//                                System.exit(1);=
                                check = true;
                                section_to_Student_Timeslotting(std, sec.getId(), smstr.getNo());
                                break;
                            }
                        }
                    }
                    if(check) {
                        break;
                    }
                }
                if (check) {
                    break;
                }
            }
        }
    }

//    public static boolean student_has_clash_with_this_section(Student std, Section sec){
//        Section_Schedule sec_sch = sec.getSchedule();
//        Student_Schedule std_sch = std.getSchedule();
//        for(){
//            
//        }
//    }
//    public static boolean student_has_clash_in_one_lecture(Student std, Section sec){ 
//    }
    public static boolean student_has_clash_with_this_section(Student std, Section sec, Course crs) {
        Section_Schedule sec_sch = sec.getSchedule();
        Student_Schedule std_sch = std.getSchedule();

        for (int var1 = 0; var1 < sec_sch.getDays().size(); var1++) {
            Section_Day day = sec_sch.getDays().get(var1);
            for (int var2 = 0; var2 < day.getTimeslots().size(); var2++) {
                Section_Timeslot slot = day.getTimeslots().get(var2);
                if (slot.getCourse().equalsIgnoreCase(crs.getTitle())) {
                    if (std_sch.getDays().get(var1).getTimeslots().get(var2).isCheck()) {
                        return true;
                    }
                }
            }
        }
        System.out.println("Section has been found in which student can study extra course without clashes");
        return false;
    }

//    public static void section_to_Student_Timeslotting(Student std, Section sec, Course crs)   {   
//        Section_Schedule sec_sch = sec.getSchedule();
//        Student_Schedule std_sch = std.getSchedule();
//        
//        for(int var1= 0; var1< sec_sch.getDays().size(); var1++){
//            Section_Day day = sec_sch.getDays().get(var1) ; 
//            for(int var2= 0; var2 < day.getTimeslots().size()  ; var2++){
//                Section_Timeslot slot = day.getTimeslots().get(var2) ;
//                if( slot.getCourse().equalsIgnoreCase(crs.getTitle() ) ) {
//                    
//                    String room = sec_sch.getDays().get(var1).getTimeslots().get(var2).getRoom() ; 
//                }
//            }    
//        }
//    }
    public static Section get_section(String section_id, int semester_no) {

//        for (Semester sem : semesters) {
        System.out.println(semesters.size());
        ArrayList<Section> sections = semesters.get(semester_no - 1).getSections();
        Semester.displayAllData();
        for (Section sec : sections) {
            sec.displaySection(semester_no);
            if (sec.getId().equalsIgnoreCase(section_id)) {
                return sec;
            }
        }
        System.exit(1);
//        }
        return null;
    }

}       // main class   
