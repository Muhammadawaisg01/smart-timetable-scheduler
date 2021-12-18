package Controller;

import Enums.Lab;
import Enums.Priority;
import Model.Course;
import static Model.Entities_Main_Arrays.programs;
import static Model.Entities_Main_Arrays.rooms;
import Model.room.Room;
import Model.room.Room_Timeslot;
import Model.room.Room_Day; 
import Model.semester.Section;
import Model.semester.Semester;
import java.util.ArrayList;

public class new_algorithm {

    int consecutive_slots_per_lecture = 1;        // always be one     // based on user input entered in schedule generartion panel
    int num_of_lectures_per_week = 2;     //always must be <= 3     // based on user input entered in schedule generartion panel

    int consecutive_slots_per_lab = 2;     // based on user input entered in schedule generartion panel
    int num_of_labs_per_week = 1;             // always must be <= 2  // based on user input entered in schedule generartion panel

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
//                specific_course = specific_room.getSpecified_courses().get(0);
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

    private boolean check_if_room_is_available_in_less_slots(Room rm) {
        return true;
    }

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

    private ArrayList<Day_x_Timeslot> get_available_slots_of_room_for_scheduling(Room room) {
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

} // CLASS Closing
