////package Controller;
////
////import Enums.Lab;
////import Enums.Lecture;
////import Enums.Priority;
////import Enums.Room_Type;
////import Model.Course;
////import Model.Program;
////import static Model.Queries.getAllRooms;
////import static Model.Queries.getProgramsDatastructure;
//////import static Model.Entities_Main_Arrays.programs;
//////import static Model.Entities_Main_Arrays.rooms;
////import static Model.TestData.rooms;
////import static Model.TestData.programs;
////import Model.room.Room;
////import Model.room.Room_Day;
////import Model.room.Room_Timeslot;
////import Model.semester.Section;
////import Model.semester.Section_Timeslot;
////import Model.semester.Semester;
////import java.util.ArrayList;
////
////public class NewAlgorithm {
////
////    public static int consecutive_slots_per_lecture = 1;        // always be one     // based on user input entered in schedule generartion panel
////    public static int num_of_lectures_per_week = 2;     //always must be <= 3     // based on user input entered in schedule generartion panel
////
////    public static int consecutive_slots_per_lab = 2;     // based on user input entered in schedule generartion panel
////    public static int num_of_labs_per_week = 1;             // always must one  // based on user input entered in schedule generartion panel
////
////    public static int num_of_days = 5;
////    public static int num_of_timeslots = 6;
////
//////    public void algorithm_first() {
//////        // rooms has high priority than all other entities
//////
//////        ArrayList<Section> req_section_array_1 = new ArrayList<>();            // store sections that are reading the room specific course
//////
//////        ArrayList<Room> course_specified_rooms = new ArrayList<>();
//////        Course specific_course = null;
//////        boolean specific_room_found = false;
//////        boolean is_room_specified_for_courses = false;
//////        boolean room_specified_for_lab_or_lecture = false;
//////
//////        for (int r = 0; r < rooms.size(); r++) {
//////            Room specific_room = rooms.get(r);
//////            if (!specific_room.getSpecified_courses().isEmpty()) {     // if it is not empty, means this room is specified for a course lecture or lab
//////                course_specified_rooms.add(specific_room);
//////                specific_room_found = true;
//////            }
//////            // else part of above if will start a new floww of the algorithm
////////            else{}
//////
//////            if (specific_room_found) {
////////                specific_course = specific_room.getSpecified_courses().get(0);
//////                if (specific_course.getLab() == Lab.YES) {            // check if room is specified for lab or lecture of that course
//////                    room_specified_for_lab_or_lecture = true;
//////                } else {
//////                    room_specified_for_lab_or_lecture = false;
//////                }
//////                // now find the section that are reading that course
//////                req_section_array_1 = get_sections_having_this_course(specific_course);        // it has all sections that have this course
//////
//////                specific_room_found = false;
//////            }       // extend this condition to last
//////
//////            int no_of_consecutive_slots = 0;
//////            int no_of_lectures = 0;
//////            if (room_specified_for_lab_or_lecture) {
//////                no_of_consecutive_slots = consecutive_slots_per_lab;
//////                no_of_lectures = num_of_labs_per_week;
//////            } else {
//////                no_of_consecutive_slots = consecutive_slots_per_lecture;
//////                no_of_lectures = num_of_lectures_per_week;
//////            }
//////
//////            for (int k = 0; k < req_section_array_1.size(); k++) {
//////
//////                int num_of_total_slots_required = req_section_array_1.size() * no_of_consecutive_slots * no_of_lectures;
//////
//////                // now calculate number of available slots of room and compare them with sections 
//////                // and check if all sections can be accomodated or it has less slots
//////                int available_slots_in_room = calculate_num_of_slots_of_room_available(specific_room);
//////
//////                if (available_slots_in_room >= num_of_total_slots_required) {             // leave this if condition for a while
//////                    // all good to go, go to scheduling based on priority   
//////
//////                    // get sections having high priority and matched with the rooms available timeslots
//////                    // then schedule lecture or lab  
//////                    // getting all available slots of the room then check the high availability sections in those slots
//////                    ArrayList<Day_x_Timeslot> all_available_slots = get_available_slots_of_room_for_scheduling(specific_room);
//////
//////                    for (int slot = 0; slot < all_available_slots.size(); slot++) {
//////                        int day = all_available_slots.get(slot).getDay();
//////                        int timeslot = all_available_slots.get(slot).getTimeslot();
//////
//////                        ArrayList<Section> high_priority_sections = get_all_sections_having_high_priority_on_consecutive_timeslots(req_section_array_1, day, timeslot, no_of_consecutive_slots);
//////
//////                        if (high_priority_sections.size() == req_section_array_1.size()) {
//////                            // check that enough slots are available
//////
//////                        } else if (high_priority_sections.size() < req_section_array_1.size()) {
//////                            ArrayList<Section> medium_priority_sections = get_all_sections_having_medium_priority_on_consecutive_timeslots(req_section_array_1, day, timeslot, no_of_consecutive_slots);
//////
//////                            // if medium + high priority 
//////                        }
//////                    }
//////                    // get high priority Section     
//////
//////                    if (room_specified_for_lab_or_lecture) {
//////                        // place lecture in consecutive order
//////
//////                    } else {
//////                        // placement can be done randomly   
//////                    }
//////                } else {   // slots are very less available for all sections to accomodate
//////                    // show message to the user if slots are less and sections are more for that course (message in JTextArea for the admin)               
//////                }
//////
//////            }
//////
////////            if(is_room_specified_for_courses){            
////////               // check that if it has very less slots available or maximum slots are available of this room  
////////              
////////              ArrayList<Section> all_sections = retreive_all_sections() ; 
////////               // calculate number of slots of all section required for the specific_course 
////////            }
//////        }
//////    }
////    private ArrayList<Section> get_sections_having_this_course(Course crs) {
////        ArrayList<Section> sections = retreive_all_sections();
////        ArrayList<Section> sections_having_this_course = new ArrayList<>();
////
////        for (int i = 0; i < sections.size(); i++) {
////            Section sec = sections.get(i);
////            for (int j = 0; j < sec.getSectionCourses().size(); j++) {
////                Course course = sec.getSectionCourses().get(j);
////                if (course.getCourse_code().equalsIgnoreCase(crs.getCourse_code())) {       // I have matched with course code
////                    sections_having_this_course.add(sec);
////                    break;
////                }
////            }
////        }
////        return sections_having_this_course;
////    }
////
////    private int calculate_num_of_slots_of_room_available(Room rm) {
////        int count = 0;
////        for (int i = 0; i < rm.getDays().size(); i++) {
////            for (int j = 0; j < rm.getDays().get(i).getTimeslots().size(); j++) {
////                Room_Timeslot slot = rm.getDays().get(i).getTimeslots().get(j);
////
////                if (!slot.isCheck()) {
////                    count++;
////                }
////            }
////        }
////        return count;
////    }
////
//////    private boolean check_if_room_is_available_in_less_slots(Room rm ) { 
//////        for(int i = 0 ; i < sections.size() ; i){ 
//////            
//////        }
//////    }
////    private Room get_room_having_compatible_capacity(int sec_strength) {
////        Room rm = new Room();
////
////        for (int i = 0; i < rooms.size(); i++) {
////
////            if (rooms.get(i).getCapacity() < sec_strength) {
////
////            }
////        }
////        return rm;
////    }
////
////    private ArrayList<Section> get_all_sections_having_high_priority_on_particular_timeslot(ArrayList<Section> sections_array, int day, int timeslot) {
////        ArrayList<Section> new_sections_array = new ArrayList<>();
////
////        for (int i = 0; i < sections_array.size(); i++) {
////            Section sec = new_sections_array.get(i);
////            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.HIGH) {
////                new_sections_array.add(sec);
////            }
////        }
////        return new_sections_array;
////    }
////
////    private ArrayList<Section> get_all_sections_having_medium_priority_on_particular_timeslot(ArrayList<Section> sections_array, int day, int timeslot) {
////        ArrayList<Section> new_sections_array = new ArrayList<>();
////
////        for (int i = 0; i < sections_array.size(); i++) {
////            Section sec = new_sections_array.get(i);
////            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.MEDIUM) {
////                new_sections_array.add(sec);
////            }
////        }
////        return new_sections_array;
////    }
////
////    private ArrayList<Section> get_all_sections_having_low_priority_on_particular_timeslot(ArrayList<Section> sections_array, int day, int timeslot) {
////        ArrayList<Section> new_sections_array = new ArrayList<>();
////
////        for (int i = 0; i < sections_array.size(); i++) {
////            Section sec = new_sections_array.get(i);
////            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.LOW) {
////                new_sections_array.add(sec);
////            }
////        }
////        return new_sections_array;
////    }
////
////    private ArrayList<Section> get_all_sections_having_high_priority_on_consecutive_timeslots(ArrayList<Section> sections_array, int day, int timeslot, int num_of_consecutive_slots) {
////        ArrayList<Section> new_sections_array = new ArrayList<>();
////
////        for (int i = 0; i < sections_array.size(); i++) {
////            Section sec = new_sections_array.get(i);
////            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.HIGH) {
////                new_sections_array.add(sec);
////            }
////        }
////        return new_sections_array;
////    }
////
////    private ArrayList<Section> get_all_sections_having_medium_priority_on_consecutive_timeslots(ArrayList<Section> sections_array, int day, int timeslot, int num_of_consecutive_slots) {
////        ArrayList<Section> new_sections_array = new ArrayList<>();
////
////        for (int i = 0; i < sections_array.size(); i++) {
////            Section sec = new_sections_array.get(i);
////            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.MEDIUM) {
////                new_sections_array.add(sec);
////            }
////        }
////        return new_sections_array;
////    }
////
////    private ArrayList<Section> get_all_sections_having_low_priority_on_consecutive_timeslots(ArrayList<Section> sections_array, int day, int timeslot, int num_of_consecutive_slots) {
////        ArrayList<Section> new_sections_array = new ArrayList<>();
////
////        for (int i = 0; i < sections_array.size(); i++) {
////            Section sec = new_sections_array.get(i);
////            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.LOW) {
////                new_sections_array.add(sec);
////            }
////        }
////        return new_sections_array;
////    }
////
////    private ArrayList<Section> retreive_all_sections() {
////        ArrayList<Section> all_sections = new ArrayList<>();
////
////        for (int i = 0; i < programs.size(); i++) {
////            ArrayList<Semester> semesters = programs.get(i).getSemesters();
////
////            for (int j = 0; j < semesters.size(); j++) {
////                ArrayList<Section> sections = semesters.get(j).getSections();
////
////                for (int k = 0; k < sections.size(); k++) {
////                    all_sections.add(sections.get(k));
////                }
////            }
////        }
////        return all_sections;
////    }
////
////    private ArrayList<Day_x_Timeslot> get_available_slots_of_room_for_scheduling(Room room) {
////        ArrayList<Day_x_Timeslot> slots = new ArrayList<>();
////
////        for (int i = 0; i < room.getDays().size(); i++) {
////            Day_x_Timeslot obj = new Day_x_Timeslot();
////            Room_Day day = room.getDays().get(i);
////            for (int j = 0; j < day.getTimeslots().size(); j++) {
////                Room_Timeslot slot = day.getTimeslots().get(j);
////
////                if (!slot.isCheck()) {          // if room slot is false, means it is unallocated and available 
////                    obj.setDay(i);
////                    obj.setTimeslot(j);
////                }
////            }
////            slots.add(obj);
////        }
////        return slots;
////    }
////
////    public static ArrayList<Program> algorithm_based_on_randomization() {
////        ArrayList<Program> programs = getProgramsDatastructure();
////        ArrayList<Room> rooms = getAllRooms();
////
////        int day = 0, timeslot = 0;
////        int num_of_tries = 0;
////        for (int program_index = 0; program_index < programs.size(); program_index++) {
////            for (int sem_index = 0; sem_index < programs.get(program_index).getSemesters().size(); sem_index++) {
////                Semester smstr = programs.get(program_index).getSemesters().get(sem_index);
////
////                for (int sec_index = 0; sec_index < smstr.getSections().size(); sec_index++) {
////                    Section sec = smstr.getSections().get(sec_index);
////                    for (int course_index = 0; course_index < sec.getSectionCourses().size(); course_index++) {
////                        Course course = sec.getSectionCourses().get(course_index);
////
////                        for (int lecture = 0; lecture < num_of_lectures_per_week; lecture++) {
////                            day = 0;
////                            timeslot = 0;
////                            num_of_tries = 0;
////                            Room rm;
////                            while (num_of_tries <= 10) {
////                                day = generate_day(0);                               // generate a day
////                                timeslot = generate_timeslot(smstr.getNo(), 0);     // generate a slot
////
////                                System.out.println("I am number of day   " + day);
////                                System.out.println("I am number of slot   " + timeslot);
////                                System.out.println("num of tries   " + num_of_tries);
////
////                                System.out.println(!is_room_available(day, timeslot) + "\t\thello world");
////
////                                if (!is_room_available(day, timeslot)) {
////                                    System.out.println("try    " + num_of_tries);
////                                    num_of_tries++;
////                                } else {
////                                    if (is_room_available(day, timeslot)) {
////                                        rm = get_room(day, timeslot);
//////                                        System.out.println("I AM ROOOM AFTER    FOUND\t\t" + rm.getName());
//////                                        System.out.println("Section availability condition  \t\t     " + is_section_free(sec, day, timeslot));
//////                                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@\t" + day + "\t" + timeslot);
//////                                        System.out.println(is_section_free(sec, day, timeslot));
//////                                        System.exit(0);
////                                        if (is_section_free(sec, day, timeslot)) {
////                                            System.out.println("hello world hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//////                                            System.exit(0);
////                                            System.out.println("SECTION\t\t\t" + sec.getId());
////                                            Section_Timeslot section_slot = sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot);
////                                            section_slot.setCheck(true);
////                                            section_slot.setCourse_code(course.getTitle() + "  " + Lecture.LECTURE);
////                                            section_slot.setLecture_no(lecture + 1);
////                                            section_slot.setRoom(rm.getName());
////                                            section_slot.setLecture(Lecture.LECTURE);
////                                            rm.getDays().get(day).getTimeslots().get(timeslot).setCheck(true);
////                                            num_of_tries++;
////                                            break;
////                                        } else {
//////                                        // put in section lecture in clash data structure
//////                                        // or second option is that search by incrementing or decrementing
////                                            num_of_tries++;
////                                        }
////                                    } else {
////                                        num_of_tries++;
////                                    }
////                                }
////                            }
////                        }
////                    }
////                    assigning_labs(smstr.getNo(), sec, num_of_labs_per_week, consecutive_slots_per_lab);
////                }
////            }
////        }
////        return programs;
////    }
////
////    private static int generate_day(int limit) {
////        int day = (int) (Math.random() * (num_of_days - limit));
////        return day;
////    }
////
////    private static int generate_timeslot(int semester_no, int limit) {                  // limit is for lab
////        int timeslot = 0;
////        if (semester_no <= 3) {
////            timeslot = (int) (Math.random() * (num_of_timeslots - 2 - limit));
////        }
////        return timeslot;
////    }
////
////    private static boolean is_room_available(int day, int timeslot) {
////        Room rm = null;
////        boolean check = false;
////        for (int room_index = 0; room_index < get_rooms(rooms).size(); room_index++) {
////            rm = get_rooms(rooms).get(room_index);
////            System.out.println("ssiizzee    " + get_rooms(rooms).size());
////            if (!rm.getDays().get(day).getTimeslots().get(timeslot).isCheck()) {
////                check = true;
////                System.out.println("Value of check  " + check);
////                System.out.println("ROOMMM    " + rm.getName());
////                break;
////            }
////        }
////        return check;
////    }
////
////    private static Room get_room(int day, int timeslot) {
////        Room rm = null;
////        boolean check = false;
////        for (int room_index = 0; room_index < get_rooms(rooms).size(); room_index++) {
////            rm = get_rooms(rooms).get(room_index);
////            if (!rm.getDays().get(day).getTimeslots().get(timeslot).isCheck()) {
////                check = true;
////                break;
////            }
////        }
////        return rm;
////    }
////
////    private static void assigning_labs(int sem_no, Section sec, int num_of_labs_per_week, int num_of_consecutive_slots_per_lab) {
////        ArrayList<Course> lab_courses = get_courses_with_labs(sec);                //getting all lab courses wit labs
////        ArrayList<Room> labs = get_labs(rooms);                         // getting all labs
////
////        int day = 0, timeslot = 0;
////
////        for (int lab_index = 0; lab_index < lab_courses.size(); lab_index++) {
////            Course course = lab_courses.get(lab_index);
////
////            for (int num_of_labs = 0; num_of_labs < num_of_labs_per_week; num_of_labs++) {
////                boolean is_available = false;
////                int num_of_tries = 0;
////                while (!is_available) {
////                    if (num_of_tries == 2) {
////                        break;
////
////                    } else {
////                        if (sem_no <= 3) {                        // for first 3 semesters try in first 3 slots   
////                            day = (int) (Math.random() * num_of_days);
////                            timeslot = (int) (Math.random() * (num_of_timeslots - 2 - num_of_consecutive_slots_per_lab));
////                        } else {
////                            day = (int) (Math.random() * num_of_days);
////                            timeslot = (int) (Math.random() * num_of_timeslots - num_of_consecutive_slots_per_lab);
////                        }
////                    }
////                    Room lab = null;
////                    for (int i = 0; i < labs.size(); i++) {
////                        lab = labs.get(i);
////                        boolean lab_consecutiveness = false;
////                        if (!lab.getDays().get(day).getTimeslots().get(timeslot).isCheck()) {
////                            //here we can also implement check of capacity as well 
////                            for (int k = 0; k < num_of_consecutive_slots_per_lab; k++) {
////                                if (!lab.getDays().get(day).getTimeslots().get(timeslot + (k + 1)).isCheck()) {
////                                    lab_consecutiveness = true;
////                                } else {
////                                    lab_consecutiveness = false;
////                                    break;
////                                }
////                            }
////                            if (lab_consecutiveness) {
////                                is_available = true;
////                                break;
////                            } else {
////                                is_available = false;
////                            }
////                        } else {
////                            //lab is not available in this slot
//////                                continue;
////                        }
////                    }
////                    if (is_available) {
////                        boolean section_consecutiveness = false;
////                        // check that consecutive slots are available or not
////                        for (int i = 0; i < num_of_consecutive_slots_per_lab; i++) {
////                            if (is_section_free(sec, day, timeslot + (i + 1))) {
////                                section_consecutiveness = true;
////                            } else {
////                                section_consecutiveness = false;
////                                break;
////                            }
////                        }
////                        if (section_consecutiveness) {
////                            for (int plotting = 0; plotting < num_of_consecutive_slots_per_lab; plotting++) {
////                                Section_Timeslot section_slot = sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot + (plotting + 1));
////                                section_slot.setCheck(true);
////                                section_slot.setCourse_code(course.getTitle() + " " + Lecture.LAB);
////                                section_slot.setLecture_no(plotting + 1);
////                                section_slot.setRoom(lab.getName());
////                                section_slot.setLecture(Lecture.LAB);
////                            }
////                            break;
//////                            is_available= false;
////                        } else {
////                            is_available = false;
////                            // put in section lecture in clash data structure
////                            // or second option is that search by incrementing or decrementing
////                            System.out.println(" Consecutive slots not found for section, try number    " + num_of_tries);
////                        }
////                    } else {
////                        num_of_tries++;     //continue;
////                    }
////                }
////            }
////        }
////    }
////
////    private static ArrayList<Course> get_courses_with_labs(Section sec) {
////        ArrayList<Course> lab_courses = new ArrayList<>();
////        for (int i = 0; i < sec.getSectionCourses().size(); i++) {
////            Course crs = sec.getSectionCourses().get(i);
////            if (crs.getLab() == Lab.YES) {
////                lab_courses.add(crs);
////            }
////        }
////        return lab_courses;
////    }
////
////    private static ArrayList<Room> get_rooms(ArrayList<Room> rooms) {
////        ArrayList<Room> array = new ArrayList<>();
////        for (Room room : rooms) {
////            if (room.getRoom_type() == Room_Type.LECTURE_ROOM) {
////                array.add(room);
////            }
////        }
////        return array;
////    }
////
////    private static ArrayList<Room> get_labs(ArrayList<Room> rooms) {
////        ArrayList<Room> array = new ArrayList<>();
////        for (Room room : rooms) {
////            if (room.getRoom_type() == Room_Type.LAB) {
////                array.add(room);
////            }
////        }
////        return array;
////    }
////
////    private static boolean is_section_free(Section sec, int day, int timeslot) {
//////        System.out.println("CHECKKKKKKKKK\t\t\t\t" + sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).isCheck());
////        boolean check = false;
////        try {
////            check = !sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).isCheck();
////        } catch (IndexOutOfBoundsException ex) {
////            
////        }
////        return check;
//////        return true;
////    }
////
////    public int get_total_no_of_lectures_of_a_section(Section sec, int num_of_lectures_per_week) {
////        int courses = sec.getSectionCourses().size();
////        int lectures = courses * num_of_lectures_per_week;
////        return lectures;
////    }
////
////} // CLASS ENDS HERE
////
//
//package Controller;
//
//import Enums.Lab;
//import Enums.Lecture;
//import Enums.Priority;
//import Enums.Room_Type;
//import Model.Course;
//import Model.Program;
//import static Model.Queries.getAllRooms;
//import static Model.Queries.getProgramsDatastructure;
////import static Model.Entities_Main_Arrays.programs;
////import static Model.Entities_Main_Arrays.rooms;
//import static Model.TestData.rooms;
//import static Model.TestData.programs;
//
////import Model.room.Room;
////import Model.room.Room_Timeslot;
////import Model.room.Room_Day; 
////import Model.semester.Section;
////import Model.semester.Semester;
//
//import Model.room.Room;
//import Model.room.Room_Timeslot;
//import Model.room.Room_Day; 
//import Model.semester.Section;
//import Model.semester.Semester;
//import Model.semester.Section_Timeslot;
//
//
//import java.util.ArrayList;
//
//public class NewAlgorithm {
//
//    public static int consecutive_slots_per_lecture = 1;        // always be one     // based on user input entered in schedule generartion panel
//    public static int num_of_lectures_per_week = 2;     //always must be <= 3     // based on user input entered in schedule generartion panel
//
//    public static int consecutive_slots_per_lab = 2;     // based on user input entered in schedule generartion panel
//    public static int num_of_labs_per_week = 1;             // always must one  // based on user input entered in schedule generartion panel
//
//    public static int num_of_days = 5;
//    public static int num_of_timeslots = 6;
//    private ArrayList<Section> get_sections_having_this_course(Course crs) {
//        ArrayList<Section> sections = retreive_all_sections();
//        ArrayList<Section> sections_having_this_course = new ArrayList<>();
//
//        for (int i = 0; i < sections.size(); i++) {
//            Section sec = sections.get(i);
//            for (int j = 0; j < sec.getSectionCourses().size(); j++) {
//                Course course = sec.getSectionCourses().get(j);
//                if (course.getCourse_code().equalsIgnoreCase(crs.getCourse_code())) {       // I have matched with course code
//                    sections_having_this_course.add(sec);
//                    break;
//                }
//            }
//        }
//        return sections_having_this_course;
//    }
//
//    private int calculate_num_of_slots_of_room_available(Room rm) {
//        int count = 0;
//        for (int i = 0; i < rm.getDays().size(); i++) {
//            for (int j = 0; j < rm.getDays().get(i).getTimeslots().size(); j++) {
//                Room_Timeslot slot = rm.getDays().get(i).getTimeslots().get(j);
//
//                if (!slot.isCheck()) {
//                    count++;
//                }
//            }
//        }
//        return count;
//    }
//
////    private boolean check_if_room_is_available_in_less_slots(Room rm ) { 
////        for(int i = 0 ; i < sections.size() ; i){ 
////            
////        }
////    }
//    private Room get_room_having_compatible_capacity(int sec_strength) {
//        Room rm = new Room();
//
//        for (int i = 0; i < rooms.size(); i++) {
//
//            if (rooms.get(i).getCapacity() < sec_strength) {
//
//            }
//        }
//        return rm;
//    }
//
//    private ArrayList<Section> get_all_sections_having_high_priority_on_particular_timeslot(ArrayList<Section> sections_array, int day, int timeslot) {
//        ArrayList<Section> new_sections_array = new ArrayList<>();
//
//        for (int i = 0; i < sections_array.size(); i++) {
//            Section sec = new_sections_array.get(i);
//            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.HIGH) {
//                new_sections_array.add(sec);
//            }
//        }
//        return new_sections_array;
//    }
//
//    private ArrayList<Section> get_all_sections_having_medium_priority_on_particular_timeslot(ArrayList<Section> sections_array, int day, int timeslot) {
//        ArrayList<Section> new_sections_array = new ArrayList<>();
//
//        for (int i = 0; i < sections_array.size(); i++) {
//            Section sec = new_sections_array.get(i);
//            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.MEDIUM) {
//                new_sections_array.add(sec);
//            }
//        }
//        return new_sections_array;
//    }
//
//    private ArrayList<Section> get_all_sections_having_low_priority_on_particular_timeslot(ArrayList<Section> sections_array, int day, int timeslot) {
//        ArrayList<Section> new_sections_array = new ArrayList<>();
//
//        for (int i = 0; i < sections_array.size(); i++) {
//            Section sec = new_sections_array.get(i);
//            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.LOW) {
//                new_sections_array.add(sec);
//            }
//        }
//        return new_sections_array;
//    }
//
//    private ArrayList<Section> get_all_sections_having_high_priority_on_consecutive_timeslots(ArrayList<Section> sections_array, int day, int timeslot, int num_of_consecutive_slots) {
//        ArrayList<Section> new_sections_array = new ArrayList<>();
//
//        for (int i = 0; i < sections_array.size(); i++) {
//            Section sec = new_sections_array.get(i);
//            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.HIGH) {
//                new_sections_array.add(sec);
//            }
//        }
//        return new_sections_array;
//    }
//
//    private ArrayList<Section> get_all_sections_having_medium_priority_on_consecutive_timeslots(ArrayList<Section> sections_array, int day, int timeslot, int num_of_consecutive_slots) {
//        ArrayList<Section> new_sections_array = new ArrayList<>();
//
//        for (int i = 0; i < sections_array.size(); i++) {
//            Section sec = new_sections_array.get(i);
//            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.MEDIUM) {
//                new_sections_array.add(sec);
//            }
//        }
//        return new_sections_array;
//    }
//
//    private ArrayList<Section> get_all_sections_having_low_priority_on_consecutive_timeslots(ArrayList<Section> sections_array, int day, int timeslot, int num_of_consecutive_slots) {
//        ArrayList<Section> new_sections_array = new ArrayList<>();
//
//        for (int i = 0; i < sections_array.size(); i++) {
//            Section sec = new_sections_array.get(i);
//            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.LOW) {
//                new_sections_array.add(sec);
//            }
//        }
//        return new_sections_array;
//    }
//
//    private ArrayList<Section> retreive_all_sections() {
//        ArrayList<Section> all_sections = new ArrayList<>();
//
//        for (int i = 0; i < programs.size(); i++) {
//            ArrayList<Semester> semesters = programs.get(i).getSemesters();
//
//            for (int j = 0; j < semesters.size(); j++) {
//                ArrayList<Section> sections = semesters.get(j).getSections();
//
//                for (int k = 0; k < sections.size(); k++) {
//                    all_sections.add(sections.get(k));
//                }
//            }
//        }
//        return all_sections;
//    }
//
//    private static ArrayList<Day_x_Timeslot> get_available_slots_of_room_for_scheduling(Room room) {
//        ArrayList<Day_x_Timeslot> slots = new ArrayList<>();
//
//        for (int i = 0; i < room.getDays().size(); i++) {
//            Day_x_Timeslot obj = new Day_x_Timeslot();
//            Room_Day day = room.getDays().get(i);
//            for (int j = 0; j < day.getTimeslots().size(); j++) {
//                Room_Timeslot slot = day.getTimeslots().get(j);
//
//                if (!slot.isCheck()) {          // if room slot is false, means it is unallocated and available 
//                    obj.setDay(i);
//                    obj.setTimeslot(j);
//                }
//            }
//            slots.add(obj);
//        }
//        return slots;
//    }
//
//    public static ArrayList<Program> algorithm_based_on_randomization() {       
//        ArrayList<Program> programs = getProgramsDatastructure();
//        ArrayList<Room> rooms = getAllRooms();
//        
//        for (int program_index = 0; program_index < programs.size(); program_index++) {
//            for (int sem_index = 0; sem_index < programs.get(program_index).getSemesters().size(); sem_index++) {
//                Semester smstr = programs.get(program_index).getSemesters().get(sem_index);
//                
//                for (int sec_index = 0; sec_index < smstr.getSections().size(); sec_index++) {
//                    Section sec = smstr.getSections().get(sec_index);
//                    
//                    assigning_labs(smstr.getNo(), sec, num_of_labs_per_week, consecutive_slots_per_lab);                    // assign labs first
//                }
//            }
//        }
//        
//        int day = 0, timeslot = 0;
//        int num_of_tries = 0, counter= 0, index=0  ; 
//        boolean is_lecture_placed = false;
//        for (int program_index = 0; program_index < programs.size(); program_index++) {
//            for (int sem_index = 0; sem_index < programs.get(program_index).getSemesters().size(); sem_index++) {
//                Semester smstr = programs.get(program_index).getSemesters().get(sem_index);
//                
//                for (int sec_index = 0; sec_index < smstr.getSections().size(); sec_index++) {
//                    Section sec = smstr.getSections().get(sec_index);
//                    
//                    for (int course_index = 0; course_index < sec.getSectionCourses().size(); course_index++) {
//                        Course course = sec.getSectionCourses().get(course_index);
//                        
//                        for (int lecture = 0; lecture < num_of_lectures_per_week; lecture++) {
//                            day = 0;
//                            timeslot = 0;
//                            num_of_tries = 0;
//                            Room rm = null;
//                            is_lecture_placed = false ; 
//                            
//                            while (!is_lecture_placed) {                   // untill lecture is placed, loop will continue
//                                if ( num_of_tries < 10 )   {
//                                    day = generate_day(0);                               // generate a day
//                                    timeslot = generate_timeslot(smstr.getNo(), 0);     // generate a slot                                    
//                                }
//                                else if (num_of_tries >= 10) {
//                                    if( num_of_tries % 2 == 0 ) {                                         // implement second logic of incrementing and decrementing
//                                        if(timeslot+1 == num_of_timeslots ) {
//                                            counter++;
//                                            timeslot-- ;
//                                        }
//                                        else{
//                                            counter++;
//                                            timeslot++;
//                                        }
//                                    }
//                                    else if(num_of_tries % 2 != 0 ){
//                                        if(day+1 == num_of_days ) {
//                                            counter++;
//                                            day-- ;
//                                        }
//                                        else{
//                                            counter++;
//                                            day++;
//                                        }
//                                    }
//                                }
//                                else if ( num_of_tries >= 20 ){
////                                    for(int i = 0 ; i < 10 ; i++ ){
////                                        
////                                    }
//                                    ArrayList<Day_x_Timeslot> slots = get_available_slots_of_room_for_scheduling(rm) ;         // implement third logic here of finding all free slots
//                                    if(index < slots.size()) { 
//                                        day = slots.get(index).getDay() ; 
//                                        timeslot = slots.get(index).getTimeslot() ;
//                                        index++;
//                                    }
//                                }
//                                else{
//                                                                    // now search in all rooms in any slot 
//                                }
//
//                                if (!is_room_available(day, timeslot)) {
//                                    num_of_tries++;
//                                } else {
//                                    if (is_room_available(day, timeslot)) {     
//                                        rm = get_room(day, timeslot);
////                                        System.exit(0);
//                                        if (is_section_free(sec, day, timeslot)) {
//                                            Section_Timeslot section_slot = sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot);
//                                            section_slot.setCheck(true);
//                                            section_slot.setCourse_code(course.getTitle() + "  " + Lecture.LECTURE);
//                                            section_slot.setLecture_no(lecture + 1);
//                                            section_slot.setRoom(rm.getName());
//                                            section_slot.setLecture(Lecture.LECTURE);
//                                            rm.getDays().get(day).getTimeslots().get(timeslot).setCheck(true);
//                                            is_lecture_placed = true ; 
////                                            num_of_tries++ ; 
////                                            break;
//                                        } else {
////                                        // put in section lecture in clash data structure
////                                        // or second option is that search by incrementing or decrementing
//                                            num_of_tries++;
//                                        }
//                                    } else {
//                                        num_of_tries++;
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        return programs;
//    }
//
//    private static int generate_day(int limit) {
//        int day = (int) (Math.random() * (num_of_days - limit));
//        return day;
//    }
//    
//    private static int generate_timeslot(int semester_no, int limit) {                  // limit is for lab
//        int timeslot = 0;
//        if (semester_no <= 3) {
//            timeslot = (int) (Math.random() * (num_of_timeslots - 2 - limit));
//        }
//        else{
//            timeslot = (int) (Math.random() * (num_of_timeslots - limit));
//        }
//        return timeslot;
//    }
//
//    private static boolean is_room_available(int day, int timeslot) {
//        Room rm = null;
//        boolean check = false;
//        for (int room_index = 0; room_index < get_rooms(rooms).size(); room_index++) {
//            rm = get_rooms(rooms).get(room_index);
//            if (!rm.getDays().get(day).getTimeslots().get(timeslot).isCheck()) {
//                check = true;
//                break;
//            }
//        }
//        return check;
//    }
//
//    private static Room get_room(int day, int timeslot) {
//        Room rm = null;
//        boolean check = false;
//        for (int room_index = 0; room_index < get_rooms(rooms).size(); room_index++) {
//            rm = get_rooms(rooms).get(room_index);
//            if (!rm.getDays().get(day).getTimeslots().get(timeslot).isCheck()) {
//                check = true;
//                break;
//            }
//        }
//        return rm;
//    }
//
//    private static void assigning_labs(int sem_no, Section sec, int num_of_labs_per_week, int num_of_consecutive_slots_per_lab) {
//        ArrayList<Course> lab_courses = get_courses_with_labs(sec);                //getting all lab courses wit labs
//        ArrayList<Room> labs = get_labs(rooms);                         // getting all labs
//        
//        int day = 0, timeslot = 0 ; 
//        boolean is_lab_placed = false ; 
//        for (int lab_index = 0; lab_index < lab_courses.size(); lab_index++) {
//            Course course = lab_courses.get(lab_index);
//
//            for (int num_of_labs = 0; num_of_labs < num_of_labs_per_week; num_of_labs++) {
//                boolean is_available = false ; 
//                int num_of_tries = 0 ; 
//                while (num_of_tries <= 10) {
//                    day = generate_day(0);                               // generate a day
//                    timeslot = generate_timeslot(sem_no, num_of_consecutive_slots_per_lab);     // generate a slot
//                                        
//                    Room lab = null;
//                    for (int i = 0; i < labs.size(); i++) {
//                        lab = labs.get(i);
//                        boolean lab_consecutiveness = false;
//                        if (!lab.getDays().get(day).getTimeslots().get(timeslot).isCheck()) {
//                            //here we can also implement check of capacity as well 
//                            for (int k = 0; k < num_of_consecutive_slots_per_lab; k++) {
//                                if (!lab.getDays().get(day).getTimeslots().get(timeslot + (k + 1)).isCheck()) {
//                                    lab_consecutiveness = true;
//                                } else {
//                                    lab_consecutiveness = false;
//                                    break;
//                                }
//                            }
//                            if (lab_consecutiveness) {
//                                is_available = true;
//                                break;
//                            } else {
//                                is_available = false;
//                            }
//                        } else {
//                            //lab is not available in this slot
////                          continue;
//                        }
//                    }
//                    if (is_available) {
//                        boolean section_consecutiveness = false;
//                        // check that consecutive slots are available or not
//                        for (int i = 0; i < num_of_consecutive_slots_per_lab; i++) {
//                            if (is_section_free(sec, day, timeslot + (i + 1))) {
//                                section_consecutiveness = true;
//                            } else {
//                                section_consecutiveness = false;
//                                break;
//                            }
//                        }
//                        if (section_consecutiveness) {
//                            for (int plotting = 0; plotting < num_of_consecutive_slots_per_lab; plotting++) {
//                                Section_Timeslot section_slot = sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot + (plotting + 1));
//                                section_slot.setCheck(true);
//                                section_slot.setCourse_code(course.getTitle() + " " + Lecture.LAB);
//                                section_slot.setLecture_no(plotting + 1);
//                                section_slot.setRoom(lab.getName());
//                                section_slot.setLecture(Lecture.LAB);
//                                lab.getDays().get(day).getTimeslots().get(timeslot).setCheck(true);
//                            }
//                            is_lab_placed = true ;                            
//                            break;
//                        } else {
//                            is_available = false;
//                            num_of_tries++;
//                            // put in section lecture in clash data structure
//                            // or second option is that search by incrementing or decrementing
//                            System.out.println(" Consecutive slots not found for section, try number    " + num_of_tries);
//                        }
//                    } else {
//                        num_of_tries++;     //continue;
//                    }
//                }
//            }
//        }
//    }
//
//    private static ArrayList<Course> get_courses_with_labs(Section sec) {
//        ArrayList<Course> lab_courses = new ArrayList<>();
//        for (int i = 0; i < sec.getSectionCourses().size(); i++) {
//            Course crs = sec.getSectionCourses().get(i);
//            if (crs.getLab() == Lab.YES) {
//                lab_courses.add(crs);
//            }
//        }
//        return lab_courses;
//    }
//
//    private static ArrayList<Room> get_rooms(ArrayList<Room> rooms) {
//        ArrayList<Room> array = new ArrayList<>();
//        for (Room room : rooms) {
//            if (room.getRoom_type() == Room_Type.LECTURE_ROOM) {
//                array.add(room);
//            }
//        }
//        return array;
//    }
//
//    private static ArrayList<Room> get_labs(ArrayList<Room> rooms) {
//        ArrayList<Room> array = new ArrayList<>();
//        for (Room room : rooms) {
//            if (room.getRoom_type() == Room_Type.LAB) {
//                array.add(room);
//            }
//        }
//        return array;
//    }
//
//    private static boolean is_section_free(Section sec, int day, int timeslot) {
//        boolean check = false;
//        try {
//            check = !sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).isCheck();
//        } catch (IndexOutOfBoundsException ex) {
//            
//        }
//        return check;
////        return true;
//    }
//
//    public int get_total_no_of_lectures_of_a_section(Section sec, int num_of_lectures_per_week) {
//        int courses = sec.getSectionCourses().size();
//        int lectures = courses * num_of_lectures_per_week;
//        return lectures;
//    }
//
//} // CLASS ENDS HERE
//

package Controller;

import Enums.Lab;
import Enums.Lecture;
import Enums.Priority;
import Enums.Room_Type;
import Model.Course;
import Model.Program;
import static Model.Queries.getAllRooms;
import static Model.Queries.getProgramsDatastructure;
//import static Model.Entities_Main_Arrays.programs;
//import static Model.Entities_Main_Arrays.rooms;
import static Model.TestData.rooms;
import static Model.TestData.programs;

//import Model.room.Room;
//import Model.room.Room_Timeslot;
//import Model.room.Room_Day; 
//import Model.semester.Section;
//import Model.semester.Semester;

import Model.room.Room;
import Model.room.Room_Timeslot;
import Model.room.Room_Day; 
import Model.semester.Section;
import Model.semester.Section_Timeslot;
import Model.semester.Semester;


import java.util.ArrayList;

public class NewAlgorithm {

    public static int consecutive_slots_per_lecture = 1;        // always be one     // based on user input entered in schedule generartion panel
    public static int num_of_lectures_per_week = 2;     //always must be <= 3     // based on user input entered in schedule generartion panel

    public static int consecutive_slots_per_lab = 2;     // based on user input entered in schedule generartion panel
    public static int num_of_labs_per_week = 1;             // always must one  // based on user input entered in schedule generartion panel

    public static int num_of_days = 5;
    public static int num_of_timeslots = 6;

//    public void algorithm_first() {
//        // rooms has high priority than all other entities
//
//        ArrayList<Section> req_section_array_1 = new ArrayList<>();            // store sections that are reading the room specific course
//
//        ArrayList<Room> course_specified_rooms = new ArrayList<>();
//        Course specific_course = null;
//        boolean specific_room_found = false;
//        boolean is_room_specified_for_courses = false;
//        boolean room_specified_for_lab_or_lecture = false;
//
//        for (int r = 0; r < rooms.size(); r++) {
//            Room specific_room = rooms.get(r);
//            if (!specific_room.getSpecified_courses().isEmpty()) {     // if it is not empty, means this room is specified for a course lecture or lab
//                course_specified_rooms.add(specific_room);
//                specific_room_found = true;
//            }
//            // else part of above if will start a new floww of the algorithm
////            else{}
//
//            if (specific_room_found) {
////                specific_course = specific_room.getSpecified_courses().get(0);
//                if (specific_course.getLab() == Lab.YES) {            // check if room is specified for lab or lecture of that course
//                    room_specified_for_lab_or_lecture = true;
//                } else {
//                    room_specified_for_lab_or_lecture = false;
//                }
//                // now find the section that are reading that course
//                req_section_array_1 = get_sections_having_this_course(specific_course);        // it has all sections that have this course
//
//                specific_room_found = false;
//            }       // extend this condition to last
//
//            int no_of_consecutive_slots = 0;
//            int no_of_lectures = 0;
//            if (room_specified_for_lab_or_lecture) {
//                no_of_consecutive_slots = consecutive_slots_per_lab;
//                no_of_lectures = num_of_labs_per_week;
//            } else {
//                no_of_consecutive_slots = consecutive_slots_per_lecture;
//                no_of_lectures = num_of_lectures_per_week;
//            }
//
//            for (int k = 0; k < req_section_array_1.size(); k++) {
//
//                int num_of_total_slots_required = req_section_array_1.size() * no_of_consecutive_slots * no_of_lectures;
//
//                // now calculate number of available slots of room and compare them with sections 
//                // and check if all sections can be accomodated or it has less slots
//                int available_slots_in_room = calculate_num_of_slots_of_room_available(specific_room);
//
//                if (available_slots_in_room >= num_of_total_slots_required) {             // leave this if condition for a while
//                    // all good to go, go to scheduling based on priority   
//
//                    // get sections having high priority and matched with the rooms available timeslots
//                    // then schedule lecture or lab  
//                    // getting all available slots of the room then check the high availability sections in those slots
//                    ArrayList<Day_x_Timeslot> all_available_slots = get_available_slots_of_room_for_scheduling(specific_room);
//
//                    for (int slot = 0; slot < all_available_slots.size(); slot++) {
//                        int day = all_available_slots.get(slot).getDay();
//                        int timeslot = all_available_slots.get(slot).getTimeslot();
//
//                        ArrayList<Section> high_priority_sections = get_all_sections_having_high_priority_on_consecutive_timeslots(req_section_array_1, day, timeslot, no_of_consecutive_slots);
//
//                        if (high_priority_sections.size() == req_section_array_1.size()) {
//                            // check that enough slots are available
//
//                        } else if (high_priority_sections.size() < req_section_array_1.size()) {
//                            ArrayList<Section> medium_priority_sections = get_all_sections_having_medium_priority_on_consecutive_timeslots(req_section_array_1, day, timeslot, no_of_consecutive_slots);
//
//                            // if medium + high priority 
//                        }
//                    }
//                    // get high priority Section     
//
//                    if (room_specified_for_lab_or_lecture) {
//                        // place lecture in consecutive order
//
//                    } else {
//                        // placement can be done randomly   
//                    }
//                } else {   // slots are very less available for all sections to accomodate
//                    // show message to the user if slots are less and sections are more for that course (message in JTextArea for the admin)               
//                }
//
//            }
//
////            if(is_room_specified_for_courses){            
////               // check that if it has very less slots available or maximum slots are available of this room  
////              
////              ArrayList<Section> all_sections = retreive_all_sections() ; 
////               // calculate number of slots of all section required for the specific_course 
////            }
//        }
//    }

    private ArrayList<Section> get_sections_having_this_course(Course crs) {
        ArrayList<Section> sections = retreive_all_sections();
        ArrayList<Section> sections_having_this_course = new ArrayList<>();

        for (int i = 0; i < sections.size(); i++) {
            Section sec = sections.get(i);
            for (int j = 0; j < sec.getSectionCourses().size(); j++) {
                Course course = sec.getSectionCourses().get(j);
                if (course.getCourse_code().equalsIgnoreCase(crs.getCourse_code())) {       // I have matched with course code
                    sections_having_this_course.add(sec);
                    break;
                }
            }
        }
        return sections_having_this_course;
    }

    private int calculate_num_of_slots_of_room_available(Room rm) {
        int count = 0;
        for (int i = 0; i < rm.getDays().size(); i++) {
            for (int j = 0; j < rm.getDays().get(i).getTimeslots().size(); j++) {
                Room_Timeslot slot = rm.getDays().get(i).getTimeslots().get(j);

                if (!slot.isCheck()) {
                    count++;
                }
            }
        }
        return count;
    }

//    private boolean check_if_room_is_available_in_less_slots(Room rm ) { 
//        for(int i = 0 ; i < sections.size() ; i){ 
//            
//        }
//    }
    private Room get_room_having_compatible_capacity(int sec_strength) {
        Room rm = new Room();

        for (int i = 0; i < rooms.size(); i++) {

            if (rooms.get(i).getCapacity() < sec_strength) {

            }
        }
        return rm;
    }

    private ArrayList<Section> get_all_sections_having_high_priority_on_particular_timeslot(ArrayList<Section> sections_array, int day, int timeslot) {
        ArrayList<Section> new_sections_array = new ArrayList<>();

        for (int i = 0; i < sections_array.size(); i++) {
            Section sec = new_sections_array.get(i);
            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.HIGH) {
                new_sections_array.add(sec);
            }
        }
        return new_sections_array;
    }

    private ArrayList<Section> get_all_sections_having_medium_priority_on_particular_timeslot(ArrayList<Section> sections_array, int day, int timeslot) {
        ArrayList<Section> new_sections_array = new ArrayList<>();

        for (int i = 0; i < sections_array.size(); i++) {
            Section sec = new_sections_array.get(i);
            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.MEDIUM) {
                new_sections_array.add(sec);
            }
        }
        return new_sections_array;
    }

    private ArrayList<Section> get_all_sections_having_low_priority_on_particular_timeslot(ArrayList<Section> sections_array, int day, int timeslot) {
        ArrayList<Section> new_sections_array = new ArrayList<>();

        for (int i = 0; i < sections_array.size(); i++) {
            Section sec = new_sections_array.get(i);
            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.LOW) {
                new_sections_array.add(sec);
            }
        }
        return new_sections_array;
    }

    private ArrayList<Section> get_all_sections_having_high_priority_on_consecutive_timeslots(ArrayList<Section> sections_array, int day, int timeslot, int num_of_consecutive_slots) {
        ArrayList<Section> new_sections_array = new ArrayList<>();

        for (int i = 0; i < sections_array.size(); i++) {
            Section sec = new_sections_array.get(i);
            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.HIGH) {
                new_sections_array.add(sec);
            }
        }
        return new_sections_array;
    }

    private ArrayList<Section> get_all_sections_having_medium_priority_on_consecutive_timeslots(ArrayList<Section> sections_array, int day, int timeslot, int num_of_consecutive_slots) {
        ArrayList<Section> new_sections_array = new ArrayList<>();

        for (int i = 0; i < sections_array.size(); i++) {
            Section sec = new_sections_array.get(i);
            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.MEDIUM) {
                new_sections_array.add(sec);
            }
        }
        return new_sections_array;
    }

    private ArrayList<Section> get_all_sections_having_low_priority_on_consecutive_timeslots(ArrayList<Section> sections_array, int day, int timeslot, int num_of_consecutive_slots) {
        ArrayList<Section> new_sections_array = new ArrayList<>();

        for (int i = 0; i < sections_array.size(); i++) {
            Section sec = new_sections_array.get(i);
            if (sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).getPriority() == Priority.LOW) {
                new_sections_array.add(sec);
            }
        }
        return new_sections_array;
    }

    private ArrayList<Section> retreive_all_sections() {
        ArrayList<Section> all_sections = new ArrayList<>();

        for (int i = 0; i < programs.size(); i++) {
            ArrayList<Semester> semesters = programs.get(i).getSemesters();

            for (int j = 0; j < semesters.size(); j++) {
                ArrayList<Section> sections = semesters.get(j).getSections();

                for (int k = 0; k < sections.size(); k++) {
                    all_sections.add(sections.get(k));
                }
            }
        }
        return all_sections;
    }

    private static ArrayList<Day_x_Timeslot> get_available_slots_of_room_for_scheduling(Room room) {
        ArrayList<Day_x_Timeslot> slots = new ArrayList<>();

        for (int i = 0; i < room.getDays().size(); i++) {
            Day_x_Timeslot obj = new Day_x_Timeslot();
            Room_Day day = room.getDays().get(i);
            for (int j = 0; j < day.getTimeslots().size(); j++) {
                Room_Timeslot slot = day.getTimeslots().get(j);

                if (!slot.isCheck()) {          // if room slot is false, means it is unallocated and available 
                    obj.setDay(i);
                    obj.setTimeslot(j);
                }
            }
            slots.add(obj);
        }
        return slots;
    }

    public static ArrayList<Program> algorithm_based_on_randomization() {       
        ArrayList<Program> programs = getProgramsDatastructure();
        ArrayList<Room> rooms = getAllRooms();
        
        for (int program_index = 0; program_index < programs.size(); program_index++) {
            for (int sem_index = 0; sem_index < programs.get(program_index).getSemesters().size(); sem_index++) {
                Semester smstr = programs.get(program_index).getSemesters().get(sem_index);
                
                for (int sec_index = 0; sec_index < smstr.getSections().size(); sec_index++) {
                    Section sec = smstr.getSections().get(sec_index);
                    
                    assigning_labs(smstr.getNo(), sec, num_of_labs_per_week, consecutive_slots_per_lab);                    // assign labs first
                }
            }
        }
        
        int day = 0, timeslot = 0;
        int num_of_tries = 0, counter= 0, index=0  ; 
        boolean is_lecture_placed = false;
        for (int program_index = 0; program_index < programs.size(); program_index++) {
            for (int sem_index = 0; sem_index < programs.get(program_index).getSemesters().size(); sem_index++) {
                Semester smstr = programs.get(program_index).getSemesters().get(sem_index);
                
                for (int sec_index = 0; sec_index < smstr.getSections().size(); sec_index++) {
                    Section sec = smstr.getSections().get(sec_index);
                    
                    for (int course_index = 0; course_index < sec.getSectionCourses().size(); course_index++) {
                        Course course = sec.getSectionCourses().get(course_index);
                        
                        for (int lecture = 0; lecture < num_of_lectures_per_week; lecture++) {
                            day = 0;
                            timeslot = 0;
                            num_of_tries = 0;
                            Room rm = null;
                            is_lecture_placed = false ; 
                            
                            while (!is_lecture_placed) {                   // untill lecture is placed, loop will continue
                                if ( num_of_tries < 10 )   {
                                    day = generate_day(0);                               // generate a day
                                    timeslot = generate_timeslot(smstr.getNo(), 0);     // generate a slot                                    
                                }
                                else if (num_of_tries >= 10) {
                                    if( num_of_tries % 2 == 0 ) {                                         // implement second logic of incrementing and decrementing
                                        if(timeslot+1 == num_of_timeslots ) {
                                            counter++;
                                            timeslot-- ;
                                        }
                                        else{
                                            counter++;
                                            timeslot++;
                                        }
                                    }
                                    else if(num_of_tries % 2 != 0 ){
                                        if(day+1 == num_of_days ) {
                                            counter++;
                                            day-- ;
                                        }
                                        else{
                                            counter++;
                                            day++;
                                        }
                                    }
                                }
                                else if ( num_of_tries >= 20 ){
//                                    for(int i = 0 ; i < 10 ; i++ ){
//                                        
//                                    }
                                    ArrayList<Day_x_Timeslot> slots = get_available_slots_of_room_for_scheduling(rm) ;         // implement third logic here of finding all free slots
                                    if(index < slots.size()) { 
                                        day = slots.get(index).getDay() ; 
                                        timeslot = slots.get(index).getTimeslot() ;
                                        index++;
                                    }
                                }
                                else{
                                                                    // now search in all rooms in any slot 
                                }
                                System.out.println("I am number of day   " + day);
                                System.out.println("I am number of slot   " + timeslot);
                                System.out.println("Num of tries   " + num_of_tries);

                                System.out.println(!is_room_available(day, timeslot) + "\t\thello world");

                                if (!is_room_available(day, timeslot)) {
                                    System.out.println("try    :" + num_of_tries);
                                    num_of_tries++;
                                } else {
                                    if (is_room_available(day, timeslot)) {     
                                        rm = get_room(day, timeslot);
//                                        System.out.println("I AM ROOM AFTER    FOUND\t\t" + rm.getName());
//                                        System.out.println("Section_availability condition  \t\t     " + is_section_free(sec, day, timeslot));
//                                        System.out.println("@@@@@@@@@@@@@@@@@@@@@@\t" + day + "\t" + timeslot);
//                                        System.out.println(is_section_free(sec, day, timeslot));
//                                        System.exit(0);
                                        if (is_section_free(sec, day, timeslot)) {
                                            System.out.println("hello world hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
//                                            System.exit(0);
                                            System.out.println("SECTION\t\t\t" + sec.getId());
                                            Section_Timeslot section_slot = sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot);
                                            section_slot.setCheck(true);
                                            section_slot.setCourse_code(course.getTitle() + "  " + Lecture.LECTURE);
                                            section_slot.setLecture_no(lecture + 1);
                                            section_slot.setRoom(rm.getName());
                                            section_slot.setLecture(Lecture.LECTURE);
                                            rm.getDays().get(day).getTimeslots().get(timeslot).setCheck(true);
                                            is_lecture_placed = true ; 
//                                            num_of_tries++ ; 
//                                            break;
                                        } else {
//                                        // put in section lecture in clash data structure
//                                        // or second option is that search by incrementing or decrementing
                                            num_of_tries++;
                                        }
                                    } else {
                                        num_of_tries++;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return programs;
    }

    private static int generate_day(int limit) {
        int day = (int) (Math.random() * (num_of_days - limit));
        return day;
    }
    
    private static int generate_timeslot(int semester_no, int limit) {                  // limit is for lab
        int timeslot = 0;
        if (semester_no <= 3) {
            timeslot = (int) (Math.random() * (num_of_timeslots - 2 - limit));
        }
        else{
            timeslot = (int) (Math.random() * (num_of_timeslots - limit));
        }
        return timeslot;
    }

    private static boolean is_room_available(int day, int timeslot) {
        Room rm = null;
        boolean check = false;
        for (int room_index = 0; room_index < get_rooms(rooms).size(); room_index++) {
            rm = get_rooms(rooms).get(room_index);
            System.out.println("ssiizzee    " + get_rooms(rooms).size());
            if (!rm.getDays().get(day).getTimeslots().get(timeslot).isCheck()) {
                check = true;
                System.out.println("Value of check  " + check);
                System.out.println("ROOM Name  :  " + rm.getName());
                break;
            }
        }
        return check;
    }

    private static Room get_room(int day, int timeslot) {
        Room rm = null;
        boolean check = false;
        for (int room_index = 0; room_index < get_rooms(rooms).size(); room_index++) {
            rm = get_rooms(rooms).get(room_index);
            if (!rm.getDays().get(day).getTimeslots().get(timeslot).isCheck()) {
                check = true;
                break;
            }
        }
        return rm;
    }

    private static void assigning_labs(int sem_no, Section sec, int num_of_labs_per_week, int num_of_consecutive_slots_per_lab) {
        ArrayList<Course> lab_courses = get_courses_with_labs(sec);                //getting all lab courses wit labs
        ArrayList<Room> labs = get_labs(rooms);                         // getting all labs
        
        int day = 0, timeslot = 0 ; 
        boolean is_lab_placed = false ; 
        for (int lab_index = 0; lab_index < lab_courses.size(); lab_index++) {
            Course course = lab_courses.get(lab_index);

            for (int num_of_labs = 0; num_of_labs < num_of_labs_per_week; num_of_labs++) {
                boolean is_available = false ; 
                int num_of_tries = 0 ; 
                while (num_of_tries <= 10) {
                    day = generate_day(0);                               // generate a day
                    timeslot = generate_timeslot(sem_no, num_of_consecutive_slots_per_lab);     // generate a slot
                                        
                    Room lab = null;
                    for (int i = 0; i < labs.size(); i++) {
                        lab = labs.get(i);
                        boolean lab_consecutiveness = false;
                        if (!lab.getDays().get(day).getTimeslots().get(timeslot).isCheck()) {
                            //here we can also implement check of capacity as well 
                            for (int k = 0; k < num_of_consecutive_slots_per_lab; k++) {
                                if (!lab.getDays().get(day).getTimeslots().get(timeslot + (k + 1)).isCheck()) {
                                    lab_consecutiveness = true;
                                } else {
                                    lab_consecutiveness = false;
                                    break;
                                }
                            }
                            if (lab_consecutiveness) {
                                is_available = true;
                                break;
                            } else {
                                is_available = false;
                            }
                        } else {
                            //lab is not available in this slot
//                          continue;
                        }
                    }
                    if (is_available) {
                        boolean section_consecutiveness = false;
                        // check that consecutive slots are available or not
                        for (int i = 0; i < num_of_consecutive_slots_per_lab; i++) {
                            if (is_section_free(sec, day, timeslot + (i + 1))) {
                                section_consecutiveness = true;
                            } else {
                                section_consecutiveness = false;
                                break;
                            }
                        }
                        if (section_consecutiveness) {
                            for (int plotting = 0; plotting < num_of_consecutive_slots_per_lab; plotting++) {
                                Section_Timeslot section_slot = sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot + (plotting + 1));
                                section_slot.setCheck(true);
                                section_slot.setCourse_code(course.getTitle() + " " + Lecture.LAB);
                                section_slot.setLecture_no(plotting + 1);
                                section_slot.setRoom(lab.getName());
                                section_slot.setLecture(Lecture.LAB);
                                lab.getDays().get(day).getTimeslots().get(timeslot).setCheck(true);
                            }
                            is_lab_placed = true ;                            
                            break;
                        } else {
                            is_available = false;
                            num_of_tries++;
                            // put in section lecture in clash data structure
                            // or second option is that search by incrementing or decrementing
                            System.out.println(" Consecutive slots not found for section, try number    " + num_of_tries);
                        }
                    } else {
                        num_of_tries++;     //continue;
                    }
                }
            }
        }
    }

    private static ArrayList<Course> get_courses_with_labs(Section sec) {
        ArrayList<Course> lab_courses = new ArrayList<>();
        for (int i = 0; i < sec.getSectionCourses().size(); i++) {
            Course crs = sec.getSectionCourses().get(i);
            if (crs.getLab() == Lab.YES) {
                lab_courses.add(crs);
            }
        }
        return lab_courses;
    }

    private static ArrayList<Room> get_rooms(ArrayList<Room> rooms) {
        ArrayList<Room> array = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoom_type() == Room_Type.LECTURE_ROOM) {
                array.add(room);
            }
        }
        return array;
    }

    private static ArrayList<Room> get_labs(ArrayList<Room> rooms) {
        ArrayList<Room> array = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getRoom_type() == Room_Type.LAB) {
                array.add(room);
            }
        }
        return array;
    }

    private static boolean is_section_free(Section sec, int day, int timeslot) {
//        System.out.println("CHECKKKKKKKKK\t\t\t\t" + sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).isCheck());
        boolean check = false;
        try {
            check = !sec.getSchedule().getDays().get(day).getTimeslots().get(timeslot).isCheck();
        } catch (IndexOutOfBoundsException ex) {
            
        }
        return check;
//        return true;
    }

    public int get_total_no_of_lectures_of_a_section(Section sec, int num_of_lectures_per_week) {
        int courses = sec.getSectionCourses().size();
        int lectures = courses * num_of_lectures_per_week;
        return lectures;
    }

} // CLASS ENDS HERE

