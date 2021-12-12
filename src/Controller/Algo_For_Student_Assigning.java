package Controller;

import java.util.ArrayList;

import Model.Course;
import Model.Entities_Main_Arrays;
import Model.semester.Section;
import Model.semester.Section_Schedule;
import Model.semester.Semester;
import Model.student.Student;
import Model.student.Student_Day;
import Model.student.Student_Schedule;
import Model.student.Student_Timeslot;
import Model.semester.Section_Day;
import Model.semester.Section_Timeslot;
import Model.student.StudentClash;
import Model.student.Student_lecture_clash;

import static Model.Entities_Main_Arrays.semesters;
import static Model.Entities_Main_Arrays.student_list;

public class Algo_For_Student_Assigning {

    // assigning section schedule to all the students of the same sections  
    public static void assign_Data_from_Section_to_Student_Schedule() {   // assigning schedule to students     
        Student std = null;
        for (int var1 = 0; var1 < student_list.size(); var1++) {          //start from picking from first student  
            std = student_list.get(var1);
            std.resetStudentClashArray();   // empty clash array
            std.resetStudentScheduleArray(5, 6);    // empty schedule   (change 5 days,6 slots to veriables)
            std.resetStudentAllocationArray();  // empty allocations

            String std_sec_id = std.getSection_id();

            ArrayList<Course> registered_courses = std.getRegistered_courses();          // it will contain all the courses that student has registered 
            ArrayList<Course> extra_courses = get_extra_courses_Student_has_picked(std, registered_courses);   // in this array those courses will be stored which student has picked and offered in different semesters and sections not in his semester     
            section_to_Student_Timeslotting(std, std_sec_id);       // method to assign regular courses to the student
            // if his registered courses are completed then loop ends but if he has registered more courses then 
            // logic will be implemented 
            if (extra_courses.size() > 0) {     // student has registered extra courses
                // call the main algorithm method   
                find_compatible_section_for_student_extra_courses(std, extra_courses, semesters);
            }
        }
    }

    // get data from one timeslot of the scheduler and add that to the corresponding timeslot of the student
    private static void section_to_Student_Timeslotting(Student std, String std_sec_id) {
        int semester_no = Section.get_Semester_of_Section(std_sec_id);
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
                        if (slot.getCourse().equalsIgnoreCase(crs.getTitle())) {
                            add_Data_to_Student_Timeslot(std_sch, semester_no, std_sec_id, slot, var1, var2);
                        }
                    }
                }
            }
        }
    }

    private static void assign_sec_to_extra_course_with_no_clash(Section section, Student student, Course course) {
        int semester_no = Section.get_Semester_of_Section(section.getId());
        Section sec = get_section(section.getId(), semester_no);
        Section_Schedule sec_sch = sec.getSchedule();
        Student_Schedule std_sch = student.getSchedule();
        for (int var1 = 0; var1 < sec_sch.getDays().size(); var1++) {
            Section_Day day = sec_sch.getDays().get(var1);
            for (int var2 = 0; var2 < day.getTimeslots().size(); var2++) {
                Section_Timeslot slot = day.getTimeslots().get(var2);
                if (slot.getCourse().equalsIgnoreCase(course.getTitle())) {
                    add_Data_to_Student_Timeslot(std_sch, semester_no, sec.getId(), slot, var1, var2);
                }
            }
        }
    }

    private static void assign_sec_to_extra_course_with_one_clash(Section section, Student student, Course course) {
        int semester_no = Section.get_Semester_of_Section(section.getId());
        Section sec = get_section(section.getId(), semester_no);
        Section_Schedule sec_sch = sec.getSchedule();
        Student_Schedule std_sch = student.getSchedule();
        for (int var1 = 0; var1 < sec_sch.getDays().size(); var1++) {
            Section_Day day = sec_sch.getDays().get(var1);
            for (int var2 = 0; var2 < day.getTimeslots().size(); var2++) {
                Section_Timeslot slot = day.getTimeslots().get(var2);
                if (slot.getCourse().equalsIgnoreCase(course.getTitle())) {
                    if (!student.getSchedule().getDays().get(var1).getTimeslots().get(var2).isCheck()) {
                        add_Data_to_Student_Timeslot(std_sch, semester_no, section.getId(), slot, var1, var2);
                    }
                }
            }
        }
    }

    private static void add_Data_to_Student_Timeslot(Student_Schedule std_sch, int semester_no, String sec_id, Section_Timeslot slot, int day_no, int slot_no) {

        String course = slot.getCourse();
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
        for (int var1 = 0; var1 < sec.getSectionCourses().size(); var1++) {
            Course sec_course = sec.getSectionCourses().get(var1);
            if (sec_course.getTitle().equalsIgnoreCase(course.getTitle())) {
                return true;
            }
        }
//        System.out.println("I am ffaallssee");
        return false;
    }

    private static ArrayList<Course> get_extra_courses_Student_has_picked(Student std, ArrayList<Course> registered_courses) {        // parameters of this method

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

    private static void find_compatible_section_for_student_extra_courses(Student std, ArrayList<Course> extra_courses, ArrayList<Semester> semesters) {

        for (Course crs : extra_courses) {  // extra courses
            ArrayList<Section> sections = getSections(crs, semesters);  // section offering course
            ArrayList<StudentClash> clashes = new ArrayList<>();    // store student course clash with sections
            ArrayList<Integer> clash_with_section = null;
            boolean allocated = false;
            boolean clash = false;
            for (Section section : sections) {
                ArrayList<Course> courses = section.getSectionCourses();
                clash_with_section = has_student_clash_with_this_section(std, section, crs);
                for (Course course : courses) {
                    if (crs.getTitle().equalsIgnoreCase(course.getTitle())) {
                        int noOfClashes = clash_with_section.size() / 2;
                        if (noOfClashes == 0) { // no clashes
                            // check strength as well
//                            section_to_Student_Timeslotting(std, section.getId());
                            assign_sec_to_extra_course_with_no_clash(section, std, course);
                            allocated = true;
                            break;
                        }
                        if (noOfClashes == 1) { // no clashes
//                            System.out.println("One Clash: " + std.getName() + "\t" + crs.getCourse_code());
                            // check strength as well
//                            section_to_Student_Timeslotting(std, section.getId());
                            assign_sec_to_extra_course_with_one_clash(section, std, course);
                            clashes.add(new StudentClash(section, crs, std, noOfClashes)); // store clash with count
                            clash = true;
                        }
                        if (noOfClashes == 2) {
//                            System.out.println("Two Clash: " + std.getName() + "\t" + crs.getCourse_code());
                            clash = true;
                            clashes.add(new StudentClash(section, crs, std, noOfClashes)); // store clash with count
                        }
                    }
                }
                if (allocated) {
                    break;
                }
            }
            if (!allocated && clash) {   // student has clash with all sections
                // find section with minimum clashes
                boolean oneClash = false;
                for (StudentClash clashh : clashes) {
                    if (clashh.getClashes() == 1) {
                        newClash(clashh.getStudent(), clashh.getSection(), clashh.getCourse(), clash_with_section.get(0), clash_with_section.get(1));
                        oneClash = true;
                        break;
                    }
                }

                if (!oneClash) {
                    for (StudentClash clashh : clashes) {
                        if (clashh.getClashes() == 2) {
                            newClash(clashh.getStudent(), clashh.getSection(), clashh.getCourse(), clash_with_section.get(0), clash_with_section.get(1));
                            newClash(clashh.getStudent(), clashh.getSection(), clashh.getCourse(), clash_with_section.get(2), clash_with_section.get(3));
                            break;
                        }
                    }
                }
//                });

            }
        }
    }

    /////////////////////////////////////////// WORKING ON CLASH RESOLVING //////////////////////////////////////////
    public static void updateStudentClashes() {   // assigning schedule to students 
        ArrayList<Student> student_list = Entities_Main_Arrays.student_list;
        for (Student std : student_list) {          //start from picking from first student
            ArrayList<Course> registered_courses = std.getRegistered_courses();          // it will contain all the courses that student has registered
            std.resetStudentClashArray();
            studentClashes(std, registered_courses);
        }
    }

    private static void studentClashes(Student std, ArrayList<Course> registeredCourses) {
        for (Course crs : registeredCourses) {  // registered courses
            ArrayList<Section> sections = getSections(crs, semesters);  // section offering course
            ArrayList<StudentClash> clashes = new ArrayList<>();    // store student course clash with sections
            ArrayList<Integer> clash_with_section = null;
            boolean allocated = false;
            boolean clash = false;
            for (Section section : sections) {
                ArrayList<Course> courses = section.getSectionCourses();
                clash_with_section = has_student_clash_with_this_section(std, section, crs);
                for (Course course : courses) {
                    if (crs.getTitle().equalsIgnoreCase(course.getTitle())) {
                        int noOfClashes = clash_with_section.size() / 2;
                        if (noOfClashes == 1) {
                            clashes.add(new StudentClash(section, crs, std, noOfClashes)); // store clash with count
                            clash = true;
                        }
                        if (noOfClashes == 2) {
                            clash = true;
                            clashes.add(new StudentClash(section, crs, std, noOfClashes)); // store clash with count
                        }
                    }
                }
                if (allocated) {
                    break;
                }
            }
            if (!allocated && clash) {   // student has clash with all sections
                // find section with minimum clashes
                boolean oneClash = false;
                for (StudentClash clashh : clashes) {
                    if (clashh.getClashes() == 1) {
//                        System.out.println("One clash");
                        newClash(clashh.getStudent(), clashh.getSection(), clashh.getCourse(), clash_with_section.get(0), clash_with_section.get(1));
                        oneClash = true;
                        break;
                    }
                }

                if (!oneClash) {
                    for (StudentClash clashh : clashes) {
                        if (clashh.getClashes() == 2) {
//                            System.out.println("Two clashes");
                            newClash(clashh.getStudent(), clashh.getSection(), clashh.getCourse(), clash_with_section.get(0), clash_with_section.get(1));
                            newClash(clashh.getStudent(), clashh.getSection(), clashh.getCourse(), clash_with_section.get(2), clash_with_section.get(3));
                            break;
                        }
                    }
                }
            }
        }
    }

    public static int printStudentClashes() {
        int total = 0;
        ArrayList<Student> students = Entities_Main_Arrays.student_list;
        for (Student student : students) {
            ArrayList<Student_lecture_clash> clashes = student.getClash_array();
            total += clashes.size();
            clashes.forEach(clash -> {
                System.out.println(clash.toString());
            });
        }
        return total;
    }

    public static int calculateStudentClashes() {
        int total = 0;
        ArrayList<Student> students = Entities_Main_Arrays.student_list;
        for (Student student : students) {
            ArrayList<Student_lecture_clash> clashes = student.getClash_array();
            total += clashes.size();
        }
        return total;
    }

/////////////////////////////////////////////////////////////// END OF WORKING ON CLASH RESOLVING /////////////////////////////////////

    /*
    @param student student has clash
    @param section student has clash with section
    @param course student has clash of course in section
    add new clash in clash array of student
     */
    private static void newClash(Student std, Section sec, Course crs, int day, int slot) {
        String reg_no = std.getRegistration_no();
        int semester = Section.get_Semester_of_Section(sec.getId());
        String section = sec.getId();
        String room = sec.getSchedule().getDays().get(day).getTimeslots().get(slot).getRoom();
        int day_no = sec.getSchedule().getDays().get(day).getNo();
        int slot_no = sec.getSchedule().getDays().get(day).getTimeslots().get(slot).getSlot_no();
        String course = sec.getSchedule().getDays().get(day).getTimeslots().get(slot).getCourse();
        int lecture_no = sec.getSchedule().getDays().get(day).getTimeslots().get(slot).getLecture_no();
        boolean isLab = false;
        std.getClash_array().add(new Student_lecture_clash(reg_no, semester, section, room, day_no, slot_no, course, lecture_no, isLab));
    }

    /*
    @param course find course
    @param ArrayList<Semester> which section is offering this course
    @return ArrayList<Section> a list of all sections offering that course
     */
    private static ArrayList<Section> getSections(Course course, ArrayList<Semester> semesters) {
        ArrayList<Section> offeringSection = new ArrayList<>();
        for (Semester semester : semesters) {
            ArrayList<Section> sections = semester.getSections();
            for (Section section : sections) {
                ArrayList<Course> courses = section.getSectionCourses();
                for (Course crs : courses) {
                    if (crs.getTitle().equalsIgnoreCase(course.getTitle())) {
                        offeringSection.add(section);
                        break;
                    }
                }
            }
        }
        return offeringSection;
    }

    private static ArrayList<Integer> has_student_clash_with_this_section(Student std, Section sec, Course crs) {
        ArrayList<Integer> array = new ArrayList<>();
        Section_Schedule sec_sch = sec.getSchedule();
        Student_Schedule std_sch = std.getSchedule();

        for (int var1 = 0; var1 < sec_sch.getDays().size(); var1++) {
            Section_Day day = sec_sch.getDays().get(var1);
            for (int var2 = 0; var2 < day.getTimeslots().size(); var2++) {
                Section_Timeslot slot = day.getTimeslots().get(var2);
                if (slot.getCourse().equalsIgnoreCase(crs.getTitle())) {
                    System.out.println(slot.getCourse());
                    if (slot.getCourse().equalsIgnoreCase(std_sch.getDays().get(var1).getTimeslots().get(var2).getCourse_code())) {
                    } else {
                        if (std_sch.getDays().get(var1).getTimeslots().get(var2).isCheck()) {
//                            System.out.println(var1 + "\t" + var2);
                            array.add(var1);
                            array.add(var2);
                        }
                    }

                }
            }
        }
//        System.exit(0);
//        System.out.println("Section has been found in which student can study extra course without clashes");
        return array;
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
    private static Section get_section(String section_id, int semester_no) {

//        for (Semester sem : semesters) {
//        System.out.println(semesters.size());
        ArrayList<Section> sections = semesters.get(semester_no - 1).getSections();
//        Semester.displayAllData();
        for (Section sec : sections) {
//            sec.displaySection(semester_no);
            if (sec.getId().equalsIgnoreCase(section_id)) {
                return sec;
            }
        }
//        }
        return null;
    }

}       // main class   
