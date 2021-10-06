package clash_resolving;

import Controller.Algo_For_Student_Assigning;
import static Controller.Runner.days;
import static Controller.Runner.semesters;
import Model.Clash;
import Model.Course;
import static Model.Entities_Main_Arrays.student_list;
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
//        moveLecture(section, semNo, course, day, room, slot, lecture);
//        moveLecture("3A", 3, "PPIT", 3, "102", 2, 1);
//        moveLecture("3A", 3, "PPIT", 3, "102", 1, 2);
//        moveLecture("6B", 6, "ICT", 2, "101", 5, 1);    // move ICT lecture 1 of 6B to (Monday 4th slot in room 101)
//        moveLecture("6B", 6, "ICT", 4, "104", 4, 2);    // move ICT lecture 1 of 6B to (Monday 4th slot in room 101)
//        moveLecture("6B", 6, "ECA", 4, "103", 4, 1);
//        moveLecture("6B", 6, "ECA", 2, "104", 4, 2);
//        moveLecture("2A", 2, "Pak Study", 2, "103", 4, 1);
//        moveLecture("2A", 2, "Pak Study", 3, "104", 4, 2);
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
        int h = 1;
        Scanner read = new Scanner(System.in);
        while (true) {
            System.out.println("1- Move Lectures");
            System.out.println("Enter any number to exit");
            h = read.nextInt();
            if (h == 1) {
                move();
                Algo_For_Student_Assigning.assign_Data_from_Section_to_Student_Schedule();
                Semester.displayAllData();
                Model.Student.printAllStudents();
                int totalClashes = Algo_For_Student_Assigning.printStudentClashes();
            } else {
                break;
            }
        }
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
                ArrayList<Course> courses = section.getCourses();
                for (Course course : courses) {
                    for (Model.Student student : student_list) {
                        ArrayList<Student_lecture_clash> student_lecture_clashs = student.getClash_array();
                        for (Student_lecture_clash student_lecture_clash : student_lecture_clashs) {
                            if (course.getTitle().equalsIgnoreCase(student_lecture_clash.getCourse())
                                    && student_lecture_clash.getSection().equalsIgnoreCase(section.getId())
                                    && student_lecture_clash.getSemester() == semester.getNo()) {
                                clashes.add(new Clash(section, course, student));
                                section.incClash();
                            }
                        }
                    }
                }
            }
        }
    }

    private void circulateCourse(Section section, Course course) {

    }

    /*
    @param section: section whose lecture to be moved
    @param semNo:   semester number
    @param course:  course whose lecture to be moved
    @param day: new day number where lecture will be moved
    @param room: room of the new day where lecture will be placed
    @param slot: slot of the day where lecture to be moved
    @param lecture: Lecture of the course that is moving to new place
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
                                    section_Timeslot.setSlotFree();
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
        freeDaySlot(day, slot);
    }

    private void move() {
        Scanner in = new Scanner(System.in);
        System.out.println("Section");
        String section = in.next();
        System.out.println("Semester");
        int sem = in.nextInt();
        System.out.println("Course");
        String crs = in.next();
        System.out.println("day");
        int day = in.nextInt();
        System.out.println("room");
        String room = in.next();
        System.out.println("slot");
        int slot = in.nextInt();
        System.out.println("lecture");
        int lec = in.nextInt();
        moveLecture(section, sem, crs, day, room, slot, lec);
    }

    private void freeDaySlot(int day, int slot) {
        // free day slot
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

    private void consumeDaySlot(int day, int slot) {
        // free day slot
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

    private void printClashes() {
        System.out.println("///////////////// All Clashes In The Schedule ///////////////////////////");
//        findClashes();
        clashes.forEach((clash) -> {
            System.out.println(clash.toString());
        });
        System.out.println("///////////////// END ///////////////////////////");
    }
}
