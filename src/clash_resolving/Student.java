package clash_resolving;

import Controller.Algo_For_Student_Assigning;
import static Controller.Runner.days;
import static Model.Entities_Main_Arrays.semesters;
import static Model.Entities_Main_Arrays.student_list;
import static Model.Entities_Main_Arrays.rooms;

import Model.Clash;
import Model.Course;

import Model.room.Room;
import Model.room.Room_Day;
import Model.room.Room_Timeslot;
import Model.semester.Section;
import Model.semester.Section_Day;
import Model.semester.Section_Schedule;
import Model.semester.Section_Timeslot;
import Model.semester.Semester;
import Model.student.Student_lecture_clash;
import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {

//    public static ArrayList<Clash> clashes = new ArrayList<>();
    public void handleStudentClashes() {
        Semester.displayAllData();
        Model.student.Student.printAllStudents();
        Algo_For_Student_Assigning.printStudentClashes();
//        findClashes();
        System.out.println("/////////////////////////////////////// REMOVING CLAHSHES ///////////////////////////////////");
//        for ()
//        while (true) {
//            move();
//        }
        Scanner in = new Scanner(System.in);
        System.out.println("Resolve all clashes:");
        in.next();
        System.out.println("Resolve Clashes!");

        for (Model.student.Student student : student_list) {
            ArrayList<Student_lecture_clash> clashes = student.getClash_array();
            for (Student_lecture_clash clash : clashes) {
                if (!clash.isIsresolved()) {
                    circulateCourse(clash.getSection(), clash.getSemester(), clash.getCourse(), clash.getLecture_no());
                }
            }
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
                ArrayList<Course> courses = section.getCourses();
                for (Course course : courses) {
                    for (Model.student.Student student : student_list) {
                        ArrayList<Student_lecture_clash> student_lecture_clashs = student.getClash_array();
                        for (Student_lecture_clash student_lecture_clash : student_lecture_clashs) {
                            if (course.getTitle().equalsIgnoreCase(student_lecture_clash.getCourse())
                                    && student_lecture_clash.getSection().equalsIgnoreCase(section.getId())
                                    && student_lecture_clash.getSemester() == semester.getNo()) {
//                                clashes.add(new Clash(section, course, student));
                                section.incClash();
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
    private boolean circulateCourse(String section, int semNo, String course, int lecture) {
        boolean resolved = false;
        for (Semester semester : semesters) {
            if (semester.getNo() == semNo) {
                ArrayList<Section> sections = semester.getSections();
                for (Section sec : sections) {
                    if (sec.getId().equalsIgnoreCase(section)) {
                        Section_Schedule section_Schedule = sec.getSchedule();
                        ArrayList<Section_Day> section_Days = section_Schedule.getDays();
                        for (Section_Day d : section_Days) {
                            ArrayList<Section_Timeslot> section_Timeslots = d.getTimeslots();
                            for (Section_Timeslot section_Timeslot : section_Timeslots) {
                                // find lecture to move
                                if (section_Timeslot.getLecture_no() == lecture && section_Timeslot.getCourse().equalsIgnoreCase(course)) {
//                                    int currentClashes = Algo_For_Student_Assigning.calculateStudentClashes();
//                                    int dayWithMinClashes = d.getNo();
//                                    int slotWithMinClashes = section_Timeslot.getSlot_no();
//                                    String roomWithMinClashes = section_Timeslot.getRoom();
                                    System.out.println("Lecture Found!!!");
                                    // while 
                                    for (Room room : rooms) {
                                        for (Room_Day dayy : room.getDays()) {
                                            ArrayList<Room_Timeslot> room_Timeslots = dayy.getTimeslots();
                                            for (Room_Timeslot room_Timeslot : room_Timeslots) {
                                                // check room is free
                                                if (!room_Timeslot.isCheck()) {
                                                    // check section is free
                                                    if (!section_Schedule.getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).isCheck()) {
                                                        // check students are free
                                                        boolean freeStudents = true;
                                                        for (Model.student.Student student : student_list) {
                                                            if (student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).isCheck()) {
                                                                freeStudents = false;
                                                                break;
                                                            }
                                                        }
                                                        if (freeStudents) {
                                                            System.out.println("All found///////////////////////////////////////");
//                                                            moveLecture(section, semNo, course, dayy.getNo(), room.getName(), room_Timeslot.getNo(), lecture);
                                                            // move lecture in section schedule
                                                            // free section time slot
                                                            section_Timeslot.setCheck(false);
                                                            section_Timeslot.setCourse("");
                                                            section_Timeslot.setLecture_no(0);
                                                            section_Timeslot.setRoom("");
                                                            // assign new slot to lecture
                                                            sec.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setCheck(true);
                                                            sec.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setCourse(course);
                                                            sec.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setLecture_no(lecture);
                                                            sec.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setRoom(room.getName());
//                                                            sec.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).set(true);
//                                                            resolved = true;
                                                            // change student schedule
                                                            for (Model.student.Student student : student_list) {
//                                                                if (student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).isCheck()) {
//                                                                    freeStudents = false;
//                                                                    break;
//                                                                }
                                                                String stdSection = student.getSection_id();
                                                                ArrayList<Course> regCourses = student.getRegistered_courses();
                                                                for (Course c : regCourses) {
                                                                    // regular students of that section
                                                                    if (stdSection.equalsIgnoreCase(section) && c.getCourse_code().equalsIgnoreCase(course)) {
                                                                        // free slot

                                                                        // assign slot
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setCheck(true);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setCourse_code(course);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setLecture_no(lecture);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setRoom(room.getName());
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setSemester(semNo);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setIsLab(false);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setSection(section);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setSlot_no(room_Timeslot.getNo());

                                                                    }
                                                                }
                                                                // other students
                                                                ArrayList<Student_lecture_clash> student_lecture_clashs = student.getClash_array();
                                                                for (Student_lecture_clash slc : student_lecture_clashs) {
                                                                    if (slc.getCourse().equalsIgnoreCase(course)
                                                                            && slc.getSection().equalsIgnoreCase(section)
                                                                            && slc.getSemester() == semNo
                                                                            && slc.getLecture_no() == lecture) {
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setCheck(true);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setCourse_code(course);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setLecture_no(lecture);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setRoom(room.getName());
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setSemester(semNo);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setIsLab(false);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setSection(section);
                                                                        student.getSchedule().getDays().get(dayy.getNo()).getTimeslots().get(room_Timeslot.getNo()).setSlot_no(room_Timeslot.getNo());
                                                                        slc.setIsresolved(true);
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            return true;
//                                                            break;
                                                        }
                                                    }
//                                                    // move lecture to empty slot
//                                                    // i) free slot in section schedule
//                                                    // section_Schedule.freeDaySlot(d.getNo(), section_Timeslot.getSlot_no());
//                                                    // SET OLD TIME SLOT FALSE
//                                                    section_Timeslot.setCheck(false);
//                                                    section_Timeslot.setCourse("");
//                                                    section_Timeslot.setLecture_no(0);
//                                                    section_Timeslot.setRoom("");
//                                                    // set old room check to false
//                                                    room.getDays().get(d.getNo()).getTimeslots().get(section_Timeslot.getSlot_no()).setCheck(false);
//                                                    // ii) consume slot in section schedule
//                                                    // (day, slot, room, course, lecture)
//                                                    section_Schedule.consumeDaySlot(dayy.getNo(), room_Timeslot.getNo(), room.getName(), course, lecture);
//                                                    // free day slot in days schedule
//                                                    freeDaySlot(section_Timeslot.getRoom(), d.getNo(), section_Timeslot.getSlot_no());
//                                                    // consume slot in days schedule
////                                                    consumeDaySlot(room.getName(), dayy.getNo(), room_Timeslot.getNo());
//                                                    // map student to section schedules
//                                                    Algo_For_Student_Assigning.assign_Data_from_Section_to_Student_Schedule();
//                                                    // calculate clashes of students of that section
//                                                    int newClashes = Algo_For_Student_Assigning.calculateStudentClashes();
//                                                    System.out.println(newClashes);
//                                                    // if clashes are zero terminate further search
                                                    if (resolved) {
//                                                        resolved = true;
//                                                        Algo_For_Student_Assigning.assign_Data_from_Section_to_Student_Schedule();
                                                        // calculate clashes of students of that section
//                                                        Semester.displayAllData();
//                                                        Model.student.Student.printAllStudents();
//                                                        int newClashes = Algo_For_Student_Assigning.printStudentClashes();
//                                                        System.out.println(newClashes);
//                                                        return;
                                                    }
//                                                    else if (newClashes < currentClashes) {   // if clahes are less then current less clashes store day slot
//                                                        currentClashes = newClashes;
//                                                        dayWithMinClashes = dayy.getNo();
//                                                        slotWithMinClashes = room_Timeslot.getNo();
//                                                        roomWithMinClashes = room.getName();
//                                                    }
                                                }
                                            }
                                        }
                                    }
//                                    if (!resolved) {
//                                        // move lecture to empty slot
//                                        // i) free slot in section schedule
//                                        section_Schedule.freeDaySlot(d.getNo(), section_Timeslot.getSlot_no());
//                                        // ii) consume slot in section schedule
//                                        // (day, slot, room, course, lecture)
//                                        section_Schedule.consumeDaySlot(dayWithMinClashes, slotWithMinClashes, roomWithMinClashes, course, lecture);
//                                        // free day slot in days schedule
//                                        freeDaySlot(section_Timeslot.getRoom(), d.getNo(), section_Timeslot.getSlot_no());
//                                        // consume slot in days schedule
//                                        consumeDaySlot(roomWithMinClashes, dayWithMinClashes, slotWithMinClashes);
//                                        // map student to section schedules
//                                        Algo_For_Student_Assigning.assign_Data_from_Section_to_Student_Schedule();
//                                        // calculate clashes of students of that section
//                                        Semester.displayAllData();
//                                        Model.student.Student.printAllStudents();
//                                        int newClashes = Algo_For_Student_Assigning.printStudentClashes();
//                                        System.out.println(newClashes);
//                                        resolved = true;
//                                        return;
//                                    }
                                    // map student to section schedules
//                                    Algo_For_Student_Assigning.assign_Data_from_Section_to_Student_Schedule();
//                                    // calculate clashes of students of that section
//                                    Semester.displayAllData();
//                                    Model.student.Student.printAllStudents();
//                                    int newClashes = Algo_For_Student_Assigning.printStudentClashes();
//                                    System.out.println(newClashes);
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
        return false;
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
                        section_Days.forEach(d -> {
                            ArrayList<Section_Timeslot> section_Timeslots = d.getTimeslots();
                            for (Section_Timeslot section_Timeslot : section_Timeslots) {
                                if (section_Timeslot.getLecture_no() == lecture && section_Timeslot.getCourse().equalsIgnoreCase(course)) {
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
        Semester.displayAllData();
        Model.student.Student.printAllStudents();
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
        for (Model.student.Student student : student_list) {
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

    // temprary method to add data in database. Nothing to do with schedule or clashes
    public static void addStudentsToDb() {
        Connection connection = getConnection();
        String querry;
        int regNo = 851;
        for (int i = 1; i < 26; i++) {
            querry = "INSERT INTO students"
                    + "(registration_no,"
                    + "name,"
                    + "section_id) "
                    + "VALUES"
                    + "(?, ?, ?)";
            System.out.println(querry);
            try {
                PreparedStatement stmt = connection.prepareStatement(querry);
                stmt.setInt(1, regNo);
                stmt.setString(2, "Student" + regNo);
                stmt.setString(3, "8C");
                stmt.execute();
                regNo++;
            } catch (SQLException ex) {
                Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(1);
            }
        }
    }

    public static void addRegisteredCourses() {
//        PrintWriter pr = null;
//        File file = new File("Course Registration.txt");
        try {
//            pr = new PrintWriter(new FileOutputStream(file));
            int regNo;
//            String newLine;
            String q;
            Connection conn = getConnection();
            PreparedStatement stmt;
            regNo = 401;
            while (regNo <= 475) {
                for (int i = 16; i <= 20; i++) {
                    q = "INSERT into registered_courses (student_registration_no, course_code)"
                            + " VALUES "
                            + "(?, ?)";
                    stmt = conn.prepareStatement(q);
                    stmt.setInt(1, regNo);
                    stmt.setString(2, "cs" + i);
                    stmt.execute();
                }
//                newLine = regNo + ",ITM,PPIT,DCCN,AI,SRE\n";
//                pr.append(newLine);
                regNo++;
            }
            regNo = 501;
            while (regNo <= 575) {
                for (int i = 21; i <= 25; i++) {
                    q = "INSERT into registered_courses (student_registration_no, course_code)"
                            + " VALUES "
                            + "(?, ?)";
                    stmt = conn.prepareStatement(q);
                    stmt.setInt(1, regNo);
                    stmt.setString(2, "cs" + i);
                    stmt.execute();
                }
//                newLine = regNo + ",WEB,LA,VP,HCI,SQE\n";
//                pr.append(newLine);
                regNo++;
            }
            regNo = 601;
            while (regNo <= 675) {
                for (int i = 26; i <= 30; i++) {
                    q = "INSERT into registered_courses (student_registration_no, course_code)"
                            + " VALUES "
                            + "(?, ?)";
                    stmt = conn.prepareStatement(q);
                    stmt.setInt(1, regNo);
                    stmt.setString(2, "cs" + i);
                    stmt.execute();
                }
//                newLine = regNo + ",SDA,SPM,MAD,WEB Tech,DP\n";
//                pr.append(newLine);
                regNo++;
            }
            regNo = 701;
            while (regNo <= 775) {
                for (int i = 31; i <= 35; i++) {
                    q = "INSERT into registered_courses (student_registration_no, course_code)"
                            + " VALUES "
                            + "(?, ?)";
                    stmt = conn.prepareStatement(q);
                    stmt.setInt(1, regNo);
                    stmt.setString(2, "cs" + i);
                    stmt.execute();
                }
//                newLine = regNo + ",Testing,Research,French,Enterpreneurship,Calculus 2\n";
//                pr.append(newLine);
                regNo++;
            }
            regNo = 801;
            while (regNo <= 875) {
                for (int i = 36; i <= 40; i++) {
                    q = "INSERT into registered_courses (student_registration_no, course_code)"
                            + " VALUES "
                            + "(?, ?)";
                    stmt = conn.prepareStatement(q);
                    stmt.setInt(1, regNo);
                    stmt.setString(2, "cs" + i);
                    stmt.execute();
                }
//                newLine = regNo + ",ICT,ECA,Calculus,Course39,Course40\n";
//                pr.append(newLine);
                regNo++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
