package clash_resolving;

import Controller.Algo_For_Student_Assigning;
import static Controller.Runner.days;
import static Controller.Runner.semesters;
import Model.Clash;
import Model.Course;
import static Model.Entities_Main_Arrays.student_list;
import Model.Room;
import Model.Room_Day;
import Model.Room_Timeslot;
import static Model.Entities_Main_Arrays.rooms;
import Model.Section;
import Model.Section_Day;
import Model.Section_Schedule;
import Model.Section_Timeslot;
import Model.Semester;
import Model.Student_lecture_clash;
import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    public static ArrayList<Clash> clashes = new ArrayList<>();

    public void handleStudentClashes() {
        Semester.displayAllData();
        Model.Student.printAllStudents();
        Algo_For_Student_Assigning.printStudentClashes();
//        findClashes();
        System.out.println("/////////////////////////////////////// REMOVING CLAHSHES ///////////////////////////////////");
        while (true) {
            move();
        }
//        moveLecture(section, semNo, course, day, room, slot, lecture);
//        moveLecture("3A", 3, "PPIT", 3, "102", 2, 1);
//        moveLecture("3A", 3, "PPIT", 3, "102", 1, 2);
//        moveLecture("6B", 6, "ICT", 2, "101", 5, 1);    // move ICT lecture 1 of 6B to (Monday 4th slot in room 101)
//        moveLecture("6B", 6, "ICT", 4, "104", 4, 2);    // move ICT lecture 1 of 6B to (Monday 4th slot in room 101)
//        moveLecture("6B", 6, "ECA", 4, "103", 4, 1);
//        moveLecture("6B", 6, "ECA", 2, "104", 4, 2);
//        moveLecture("2A", 2, "Pak Study", 2, "103", 4, 1);
//        moveLecture("2A", 2, "Pak Study", 3, "104", 4, 2);
//        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
//        int h = 1;
//        Scanner read = new Scanner(System.in);
//        while (true) {
//            System.out.println("1- Move Lectures");
//            System.out.println("Enter any number to exit");
//            h = read.nextInt();
//            if (h == 1) {
//                move();
//                Algo_For_Student_Assigning.assign_Data_from_Section_to_Student_Schedule();
//                Semester.displayAllData();
//                Model.Student.printAllStudents();
//                int totalClashes = Algo_For_Student_Assigning.printStudentClashes();
//                System.out.println("Total Number of clashes: \b" + totalClashes);
//            } else {
//                break;
//            }
//        }
//        h = 1;
//        while (true) {
//            System.out.println("Enter Section ID: ");
//            String secID = read.next();
//            System.out.println("Enter course title: ");
//            String course = read.next();
//            Section section = Section.getSection(secID);
//            System.out.println(section.toString() + "SECTIONS");
//            Course crs = Course.getCourse(course);
//            System.out.println(crs.toString() + "CRS");
//            ArrayList<Clash> clashs = getStudentClashesOfASection(section, crs);
//            printClashes(clashs, "Student clashes of specific section");
//        }
//        System.out.println("/////////////////////////////////////// REMOVING CLAHSHES ///////////////////////////////////");
//        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
//        System.out.println("/////////////////////////////////////// Printing CLAHSHES ///////////////////////////////////");
//        Algo_For_Student_Assigning.updateStudentClashes();
//        Algo_For_Student_Assigning.printStudentClashes();
    }

    private void findClashes() {
        for (Semester semester : semesters) {
            ArrayList<Section> sections = semester.getSections();
            for (Section section : sections) {
                ArrayList<Course> courses = section.getSectionCourses();
                for (Course course : courses) {
                    for (Model.Student student : student_list) {
                        ArrayList<Student_lecture_clash> student_lecture_clashs = student.getClash_array();
                        for (Student_lecture_clash student_lecture_clash : student_lecture_clashs) {
                            if (course.getTitle().equalsIgnoreCase(student_lecture_clash.getCourse())
                                    && student_lecture_clash.getSection().equalsIgnoreCase(section.getId())
                                    && student_lecture_clash.getSemester() == semester.getNo()) {
                                clashes.add(new Clash(section, course, student));
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param sec
     * @param crs
     * @param sem
     */
    private void circulateCourse(String section, int semNo, String course, int lecture) {
        boolean resolved = false;
        for (Semester semester : semesters) {
            if (semester.getNo() == semNo) {
                ArrayList<Section> sections = semester.getSections();
                for (Section sec : sections) {
                    if (sec.getId().equalsIgnoreCase(section)) {
                        Section_Schedule section_Schedule = sec.getSchedule();
                        ArrayList<Section_Day> section_Days = section_Schedule.getDays();
                        // SET OLD TIME SLOT FALSE
//                        System.out.println(lecture + "\t Lecture Number" + "\tCourse: " + course + "\touter ");
//                        section_Days.forEach(d -> 
                        for (Section_Day d : section_Days) {
//                            System.out.println(lecture + "\t Lecture Number" + "\tCourse: " + course + "\tInner");
                            ArrayList<Section_Timeslot> section_Timeslots = d.getTimeslots();
                            for (Section_Timeslot section_Timeslot : section_Timeslots) {
                                // find lecture to move
                                if (section_Timeslot.getLecture_no() == lecture && section_Timeslot.getCourse().equalsIgnoreCase(course)) {
                                    int currentClashes = Algo_For_Student_Assigning.calculateStudentClashes();
                                    System.out.println(currentClashes);
                                    int dayWithMinClashes = d.getNo();
                                    int slotWithMinClashes = section_Timeslot.getSlot_no();
                                    String roomWithMinClashes = section_Timeslot.getRoom();

                                    // while 
                                    for (Room room : rooms) {
                                        for (Room_Day dayy : room.getDays()) {
                                            ArrayList<Room_Timeslot> room_Timeslots = dayy.getTimeslots();
                                            for (Room_Timeslot room_Timeslot : room_Timeslots) {
                                                if (!room_Timeslot.isCheck()) {
                                                    // move lecture to empty slot
                                                    // i) free slot in section schedule
                                                    section_Schedule.freeDaySlot(d.getNo(), section_Timeslot.getSlot_no());
                                                    // ii) consume slot in section schedule
                                                    // (day, slot, room, course, lecture)
                                                    section_Schedule.consumeDaySlot(dayy.getNo(), room_Timeslot.getNo(), room.getName(), course, lecture);
                                                    // free day slot in days schedule
                                                    freeDaySlot(section_Timeslot.getRoom(), d.getNo(), section_Timeslot.getSlot_no());
                                                    // consume slot in days schedule
                                                    consumeDaySlot(room.getName(), dayy.getNo(), room_Timeslot.getNo());
                                                    // map student to section schedules
                                                    Algo_For_Student_Assigning.assign_Data_from_Section_to_Student_Schedule();
                                                    // calculate clashes of students of that section
                                                    int newClashes = Algo_For_Student_Assigning.calculateStudentClashes();
                                                    System.out.println(newClashes);
                                                    // if clashes are zero terminate further search
                                                    if (newClashes == 0) {
                                                        resolved = true;
                                                        break;
                                                    } else if (newClashes < currentClashes) {   // if clahes are less then current less clashes store day slot
                                                        currentClashes = newClashes;
                                                        dayWithMinClashes = dayy.getNo();
                                                        slotWithMinClashes = room_Timeslot.getNo();
                                                        roomWithMinClashes = room.getName();
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    if (!resolved) {
                                        // move lecture to empty slot
                                        // i) free slot in section schedule
                                        section_Schedule.freeDaySlot(d.getNo(), section_Timeslot.getSlot_no());
                                        // ii) consume slot in section schedule
                                        // (day, slot, room, course, lecture)
                                        section_Schedule.consumeDaySlot(dayWithMinClashes, slotWithMinClashes, roomWithMinClashes, course, lecture);
                                        // free day slot in days schedule
                                        freeDaySlot(section_Timeslot.getRoom(), d.getNo(), section_Timeslot.getSlot_no());
                                        // consume slot in days schedule
                                        consumeDaySlot(roomWithMinClashes, dayWithMinClashes, slotWithMinClashes);
                                        // map student to section schedules
                                        Algo_For_Student_Assigning.assign_Data_from_Section_to_Student_Schedule();
                                        // calculate clashes of students of that section
                                        Semester.displayAllData();
                                        Model.Student.printAllStudents();
                                        int newClashes = Algo_For_Student_Assigning.printStudentClashes();
                                        System.out.println(newClashes);
                                        resolved = true;
                                        return;
                                    }
                                    break;
                                }
                            }
                            // SETTING LECTURE TO NEW DAY SLOT
//                            if (d.getNo() == day) {
//                            for (Section_Timeslot section_Timeslot : section_Timeslots) {
////                                    if (section_Timeslot.getSlot_no() == slot) {
//                                section_Timeslot.setCheck(true);
//                                section_Timeslot.setCourse(course);
//                                section_Timeslot.setLecture_no(lecture);
//                                section_Timeslot.setRoom(room);
////                                        section_Timeslot.setSlot_no(slot);
////                                    }
//                            }
//                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * @param section: section whose lecture to be moved
     * @param semNo: semester number
     * @param course: course whose lecture to be moved
     * @param day: new day number where lecture will be moved
     * @param room: room of the new day where lecture will be placed
     * @param slot: slot of the day where lecture to be moved
     * @param lecture: Lecture of the course that is moving to new place
     */
    private void moveLecture(String section, int semNo, String course, int day, String room, int slot, int lecture) {
        for (Semester semester : semesters) {
            if (semester.getNo() == semNo) {
                ArrayList<Section> sections = semester.getSections();
                for (Section sec : sections) {
                    if (sec.getId().equalsIgnoreCase(section)) {
                        Section_Schedule section_Schedules = sec.getSchedule();
                        ArrayList<Section_Day> section_Days = section_Schedules.getDays();
                        // SET OLD TIME SLOT FALSE
                        System.out.println(lecture + "\t Lecture Number" + "\tCourse: " + course + "\touter ");
                        section_Days.forEach(d -> {
                            System.out.println(lecture + "\t Lecture Number" + "\tCourse: " + course + "\tInner");
                            ArrayList<Section_Timeslot> section_Timeslots = d.getTimeslots();
                            for (Section_Timeslot section_Timeslot : section_Timeslots) {
                                if (section_Timeslot.getLecture_no() == lecture && section_Timeslot.getCourse().equalsIgnoreCase(course)) {
                                    System.out.println(course + "\t" + lecture + "t\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
                                    section_Schedules.freeDaySlot(day, slot);
                                    break;
                                }
                            }
                            // SETTING LECTURE TO NEW DAY SLOT
                            if (d.getNo() == day) {
                                for (Section_Timeslot section_Timeslot : section_Timeslots) {
                                    if (section_Timeslot.getSlot_no() == slot) {
                                        section_Timeslot.setCheck(true);
                                        section_Timeslot.setCourse(course);
                                        section_Timeslot.setLecture_no(lecture);
                                        section_Timeslot.setRoom(room);
//                                        section_Timeslot.setSlot_no(slot);
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }
        freeDaySlot(room, day, slot);
    }

    private void move() {
        Scanner in = new Scanner(System.in);
        System.out.println("Section");
        String section = in.next();
        System.out.println("Semester");
        int sem = in.nextInt();
        System.out.println("Course");
        String crs = in.next();
//        System.out.println("day");
//        int day = in.nextInt();
//        System.out.println("room");
//        String room = in.next();
//        System.out.println("slot");
//        int slot = in.nextInt();
        System.out.println("lecture");
        int lec = in.nextInt();
        circulateCourse(section, sem, crs, lec);
//        moveLecture(section, sem, crs, day, room, slot, lec);
    }

    /**
     * free slot in room schedule
     *
     * @param room
     * @param day
     * @param slot
     */
    private void freeDaySlot(String room, int day, int slot) {
        rooms.forEach(r -> {
            // free day slot
            if (r.getName().equalsIgnoreCase(room)) {
                days.forEach(d -> {
                    if (d.getNo() == day) {
                        d.getTimeslots().forEach(sl -> {
                            if (sl.getNo() == slot) {
                                sl.setCheck(false);
                            }
                        });
                    }
                });
            }
        });
    }

    /**
     * consume slot in room schedule
     *
     * @param room
     * @param day
     * @param slot
     */
    private void consumeDaySlot(String room, int day, int slot) {
        rooms.forEach(r -> {
            // free day slot
            if (r.getName().equalsIgnoreCase(room)) {
                days.forEach(d -> {
                    if (d.getNo() == day) {
                        d.getTimeslots().forEach(sl -> {
                            if (sl.getNo() == slot) {
                                sl.setCheck(true);
                            }
                        });
                    }
                });
            }
        });
    }

    /**
     *
     * @return String[] of size three array[0] roomNumber array[1] day number
     * array[2] slot number
     */
    private String[] getEmptyRoom() {
        String[] roomInfo = new String[3];
        for (Room room : rooms) {
            for (Room_Day d : days) {
                ArrayList<Room_Timeslot> room_Timeslots = d.getTimeslots();
                for (Room_Timeslot room_Timeslot : room_Timeslots) {
                    if (!room_Timeslot.isCheck()) {
                        roomInfo[0] = room.getName();
                        roomInfo[1] = d.toString();
                        roomInfo[2] = room_Timeslot.getNo() + "";
                        return roomInfo;
                    }
                }
            }
        }
        return null;
    }

    /**
     *
     * @param section section whose students will be looked for clashes
     * @return list of students of section having at least one clash
     */
    private ArrayList<Clash> getStudentClashesOfASection(Section section, Course course) {
        ArrayList<Clash> studentsClashes = new ArrayList<>();
        for (Model.Student student : student_list) {
            ArrayList<Course> studentCourses = student.getRegistered_courses();
            for (Course c : studentCourses) {
                if (c.getTitle().equalsIgnoreCase(course.getTitle())) {
                    studentsClashes.add(new Clash(section, course, student));
                }
            }
        }
        return studentsClashes;
    }

    private void printClashes(ArrayList<Clash> studentsClashes, String msg) {
        System.out.println("///////////////// " + msg + " ///////////////////////////");
        studentsClashes.forEach((clash) -> {
            System.out.println(clash.toString());
            clash.getStudent().getClash_array().forEach(action -> {
                System.out.println(action.toString());
            });
        });
        System.out.println("///////////////// END ///////////////////////////");
    }
}
