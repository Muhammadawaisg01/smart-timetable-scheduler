package Model;

import Enums.Room_Type;
import Model.room.Room;
import Model.room.Room_Day;
import Model.room.Room_Timeslot;
import Model.semester.Section;
import Model.semester.Section_Day;
import Model.semester.Section_Schedule;
import Model.semester.Section_Timeslot;
import Model.semester.Semester;
import static db.DBConnection.getConnection;
import static db.DBConnection.createConnection;
import static View.Alerts.alert;
import db.DBConnection;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Queries {

    /**
     *
     * @param programName name of program
     * @return id of program
     */
    public static int getProgramID(String programName) {
        String q = "select program_id from program where program_name = '" + programName + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt("program_id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     *
     * @param courseName course name
     * @return course code
     */
    public static String getCourseCode(String courseName) {
        String q = "select course_code from course where title = '" + courseName + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("course_code");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     *
     * @param courseCode course code
     * @return course title
     */
    public static String getCourseTitle(String courseCode) {
        String q = "select title from course where course_code = '" + courseCode + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("title");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     *
     * @param courseCode course code
     * @return all course details
     */
    public static ResultSet getCourseDetails(String courseCode) {
        String q = "select * from course where course_code = '" + courseCode + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @return number of days in db
     */
    public static int getDaysCount() {
        String q = "select COUNT(*) from day";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return -1;
    }

    /**
     *
     * @return number of time slots in db
     */
    public static int getSlotCount() {
        String q = "select COUNT(*) from timeslot";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return -1;
    }

    /**
     *
     * @return name of all professors in database
     */
    public static ArrayList<String> getAllProfessors() {
        String q = "select name from professor";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        ArrayList<String> professors = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                professors.add(rs.getString(1));
            }
            return professors;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param name professor name
     * @return prof id
     */
    public static int getProfessorID(String name) {
        String q = "select professor_id from professor where name = '" + name + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     *
     * @param id professor name
     * @return prof id
     */
    public static String getProfessorName(int id) {
        String q = "select name from professor where professor_id = " + id + "";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     *
     * @return ResultSet of all students in database
     */
    public static ResultSet getAllStudent() {
        String q = "select * from students";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param regNo student registration number
     * @return student name
     */
    public static String getStudent(String regNo) {
        String q = "select name from students where registration_no = '" + regNo + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @param reg_no student registration number
     * @return ResultSet set of course codes of registered courses
     */
    public static ResultSet getStudentRegisteredCourses(String reg_no) {
        String q = "select course_code from registered_courses where student_registration_no = '" + reg_no + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        return null;
    }

    /**
     *
     * @return 2D data structure of rooms
     */
    public static ArrayList<Room> getAllRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        String name;
        int capacity;
        boolean isLab, isFull;
        // get all rooms from room table
        String getAllRooms = "select * from room";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(getAllRooms);
            ResultSet allRooms = stmt.executeQuery();
            while (allRooms.next()) {
                name = allRooms.getString("name");
                capacity = Integer.parseInt(allRooms.getString("capacity"));
                isLab = allRooms.getString("isLab").equalsIgnoreCase("true");
                isFull = allRooms.getString("isFull").equalsIgnoreCase("true");
                rooms.add(new Room(name, capacity, isFull, isLab ? Room_Type.LAB : Room_Type.LECTURE_ROOM));
            }
            String getDaysQuery, room_name, available;
            int day_no = 0, timeSlot;
            int total_days = getDaysCount();
            for (Room room : rooms) {
                ArrayList<Room_Day> room_days = new ArrayList<>();
                for (int day = 1; day <= total_days; day++) {
                    getDaysQuery = "select * from room_availabilty where room_name = '" + room.getName() + "'"
                            + " and day_no = " + day;
                    stmt = conn.prepareStatement(getDaysQuery);
                    ResultSet roomDays = stmt.executeQuery();
                    ArrayList<Room_Timeslot> room_Timeslots = new ArrayList<>();
                    while (roomDays.next()) {
                        room_name = roomDays.getString("room_name");
                        day_no = roomDays.getInt("day_no");
                        timeSlot = roomDays.getInt("timeslot_no");
                        available = roomDays.getString("is_available");
                        room_Timeslots.add(new Room_Timeslot(timeSlot, available.equalsIgnoreCase("true")));
//                    System.out.println(room_name + "\t" + day_no + "\t" + timeSlot + "\t" + available);
                    }
                    room_days.add(new Room_Day(day_no, room_Timeslots));
                }
                room.setDays(room_days);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Error in getting room data");
        }
        return rooms;
    }

    /**
     *
     * @return 2D data structure of programs > semester > sections
     */
    public static ArrayList<Program> getProgramsDatastructure() {
        ArrayList<Program> programs = new ArrayList<>();
        // get all pgrograms
        String getProgamsQuery = "select * from program";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(getProgamsQuery);
            ResultSet programsRS = stmt.executeQuery();
            String programName;
            int programID;
            while (programsRS.next()) {
                programName = programsRS.getString("program_name");
                programID = programsRS.getInt("program_id");
                programs.add(new Program(programID, programName));
            }
            // get semesters of each program
            String getSemesters;
            for (Program program : programs) {
                ArrayList<Semester> semesters = new ArrayList<>();
                getSemesters = "SELECT semester_no FROM semester where program_id = " + program.getId();
                stmt = conn.prepareStatement(getSemesters);
                ResultSet semestersRS = stmt.executeQuery();
                String getSection;
                int semesterNo;
                PreparedStatement stmt2 = null;
                while (semestersRS.next()) {
                    ArrayList<Section> sections = new ArrayList<>();
                    // get all seciton of semester
                    semesterNo = semestersRS.getInt(1);
                    getSection = "SELECT section_id, student_strength FROM section where semester_no = " + semesterNo + " and program_id = " + program.getId();
                    stmt2 = conn.prepareStatement(getSection);
                    ResultSet sectionsRS = stmt2.executeQuery();
                    String sectionID;
                    int strength;
                    while (sectionsRS.next()) {
                        sectionID = sectionsRS.getString("section_id");
                        strength = sectionsRS.getInt("student_strength");
                        // get courses from getSectionCourses() and add to sections list
                        Section s = new Section(sectionID, strength, getSectionCourses(sectionID), getSectionSchedule(sectionID));
                        sections.add(s);
                        // get section schedule from getSectionSchedule() and add to section list
                    }
                    semesters.add(new Semester(semesterNo, sections));
                }
                program.setSemesters(semesters);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showConfirmDialog(null, "Erros in getting program data");
        }
        return programs;
    }

    /**
     *
     * @param sectionID section id
     * @return list of section courses
     */
    public static ArrayList<Course> getSectionCourses(String sectionID) {
        String q = "select course_code from section_courses where section_id = '" + sectionID + "'";
        System.out.println(q);
        Connection conn = getConnection();
        ArrayList<Course> courses = new ArrayList<>();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String courseCode = rs.getString("course_code");
                ResultSet courseDetails = getCourseDetails(courseCode);
                String courseTitle = "";
                if (courseDetails.next()) {
                    courseTitle = courseDetails.getString("title");
                }

                courses.add(new Course(courseTitle));
            }
            return courses;

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param name attribute name to get
     * @param table table name from where data need to be fetched
     * @return String[] of attribute
     */
    public static String[] getData(String name, String table) {
        String q = "select " + name + " from " + table;
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            String[] list = null;
            if (rs.last()) {
                list = new String[rs.getRow()];
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    list[i] = rs.getString(1);
                    i++;
                }
                return list;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Something went wrong");
        }
        return null;
    }

    /**
     *
     * @param sectionID section id
     * @return section schedule > section days > section timeslots
     */
    public static Section_Schedule getSectionSchedule(String sectionID) {
        Section_Schedule section_Schedule = new Section_Schedule();
        section_Schedule.setDays(getSectionDay(sectionID));
        return section_Schedule;
    }

    /**
     *
     * @param sectionID section id
     * @return section days data structure
     */
    public static ArrayList<Section_Day> getSectionDay(String sectionID) {
        ArrayList<Section_Day> section_Days = new ArrayList<>();
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            int slot_no;
            String room;
            String course_code;
            int lecture_no;
            boolean isLab;
            int totalDays = getDaysCount();
            for (int day = 1; day <= totalDays; day++) {
                String query = "SELECT * FROM section_schedule where section_id='" + sectionID + "' and day_no = " + day;
                stmt = conn.prepareStatement(query);
                ResultSet rs = stmt.executeQuery();
                ArrayList<Section_Timeslot> section_Timeslots = new ArrayList<>();
                while (rs.next()) {
                    slot_no = rs.getInt("timeslot_no");
                    room = rs.getString("room_name");
                    course_code = rs.getString("course_code");
                    lecture_no = rs.getInt("lecture_no");
                    isLab = rs.getString("isLab").equalsIgnoreCase("true");
                    section_Timeslots.add(new Section_Timeslot(slot_no, room, course_code, lecture_no, isLab));
                }
                section_Days.add(new Section_Day(day, section_Timeslots));
            }
            return section_Days;
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @return AL
     */
    public static ResultSet getSectionScheduleRS(String table, String attributeName, String attributeValue) {
        String q = "SELECT * FROM " + table + " where " + attributeName + " = '" + attributeValue + "'";
        System.out.println(q);
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
//    SELECT day.name as Day, timeslot.starting_time as StartTime, timeslot.ending_time as EndTime, room_name as Room, course_code as Course  FROM server1.section_schedule join day using (day_no) join timeslot using (timeslot_no) where section_id="BCS-1A";

    /**
     *
     * @return AL
     */
    public static ResultSet getFinalSectionSchedule(String sectionID) {
        String q = "SELECT day.name as Day, timeslot.starting_time as StartTime, timeslot.ending_time as EndTime, room_name as Room, course_code as Course  FROM server1.section_schedule join day using (day_no) join timeslot using (timeslot_no) where section_id='" + sectionID + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void updateSchedule(ArrayList<Program> schedule) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        for (Program program : schedule) {
            String programName = program.name;
//            System.out.println(programName + "\tProgram Length: " + schedule.size());
            ArrayList<Semester> semesters = program.getSemesters();
            for (Semester semester : semesters) {
                int semesterNo = semester.getNo();
//                System.out.println("Semester Number: " + semesterNo + "\t Total Semester: " + semesters.size());
                ArrayList<Section> sections = semester.getSections();
//                System.out.println("Total Section of semester " + semesterNo + " are " + sections.size());
                for (Section section : sections) {
                    String sectionID = section.getId();
                    int sectionStrength = section.getStrength();
//                    System.out.println(sectionID + "\t" + sectionStrength);
                    Section_Schedule section_Schedules = section.getSchedule();
                    ArrayList<Section_Day> section_Days = section_Schedules.getDays();
                    for (Section_Day section_Day : section_Days) {
                        int sectionDayNo = section_Day.getNo();
//                        System.out.println("Section Day" + sectionDayNo);
                        ArrayList<Section_Timeslot> section_Timeslots = section_Day.getTimeslots();
                        for (Section_Timeslot section_Timeslot : section_Timeslots) {
//                            System.out.println(section_Timeslot.toString());
                            // update section schedule
                            String q = "UPDATE section_schedule SET "
                                    + "course_code = '" + section_Timeslot.getCourse_code() + "',"
                                    + "room_name= '" + section_Timeslot.getRoom() + "',"
                                    + "lecture_no = '" + section_Timeslot.getLecture_no() + "',"
                                    + "isLab = '" + section_Timeslot.getLecture() + "'"
                                    + " WHERE "
                                    + "section_id = '" + sectionID + "' and "
                                    + "day_no = " + sectionDayNo + " and "
                                    + "timeslot_no = " + section_Timeslot.getSlot_no();
                            // update room availability 
                            String updateRooms = "UPDATE room_availabilty SET "
                                    + "is_available = '" + section_Timeslot.isCheck() + "'"
                                    + " WHERE "
                                    + "room_name = '" + section_Timeslot.getRoom() + "' and "
                                    + "day_no = " + sectionDayNo + " and "
                                    + "timeslot_no = " + section_Timeslot.getSlot_no();
                            try {
                                stmt = conn.prepareStatement(q);
                                stmt.execute();
                                stmt = conn.prepareStatement(updateRooms);
                                stmt.execute();
                            } catch (SQLException ex) {
                                Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    System.out.println("\n\n\n\n");
                }
            }
        }
    }

    /**
     *
     * @param file Student registration file Add student in database and section
     * field is filled with "Section"
     */
    public static void addStudentsToDB(File file) {
        String addStudent = "insert into students "
                + "("
                + "registration_no,"
                + "name,"
                + "semester_no,"
                + "section_id"
                + ")"
                + " values "
                + "(?, ?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            Scanner read = new Scanner(file);
            while (read.hasNext()) {
                String line = read.nextLine();
                String[] list = line.split(",");
                String regNo = list[0];
                int semester = Integer.parseInt(list[2]);
                stmt = conn.prepareStatement(addStudent);
                stmt.setString(1, regNo);
                stmt.setString(2, "Student Name");
                stmt.setInt(3, semester);
                stmt.setString(4, "Section");
                stmt.execute();
                String addCourse = "insert into student_section_allocation"
                        + "("
                        + "student_registration_no,"
                        + "course_code,"
                        + "section_id"
                        + ")"
                        + " values "
                        + "(?, ?, ?)";
                for (int i = 3; i < list.length; i++) {
                    String courseTitle = list[i];
                    String courseCode = getCourseCode(courseTitle);
                    if (courseCode == null) {
                        courseCode = courseTitle;
                    }
                    stmt = conn.prepareStatement(addCourse);
                    stmt.setString(1, regNo);
                    stmt.setString(2, courseCode);
                    stmt.setString(3, "Section");
                    stmt.execute();
                }
            }
//            assignSectionToStudents(1);
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            System.out.println("Semeseter Number is invalid in file");
            System.out.println(ex);
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void assignSectionToStudents(int program_id) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        // get total semesters of program
        String getTotalSemester = "select COUNT(*) as total_semesters from semester where program_id = " + program_id;
        int totalSemester = 0;
        try {
            stmt = conn.prepareStatement(getTotalSemester);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            totalSemester = rs.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            alert("Can't get semesters");
            return;
        }
        // for each semester get sections of semester
        for (int semester = 1; semester < totalSemester + 1; semester++) {
            String[] sectionIDs = getSectionIDs(semester, program_id);
            // get students of eact semester
            String[] studentIDs = getStudentIDs(semester);
            System.out.println("gad");
            // get section strength of each section
            int student_in_each_section = -1;
            try {
                student_in_each_section = (int) studentIDs.length / sectionIDs.length;
            } catch (NullPointerException ex) {
                System.out.println(ex);
                continue;
            }
            int startIndex = 0;
            for (String sectionID : sectionIDs) {
//                int sectionStrength = getSectionStrength(sectionID);  should be like this
                int sectionStrength = student_in_each_section;
                allocateSections(sectionID, startIndex, sectionStrength, studentIDs);
                startIndex += sectionStrength;
            }
            // assign section to each student
        }
    }

    /**
     *
     * @param semester semester no
     * @return String[]: Registration numbers of semester
     */
    public static String[] getStudentIDs(int semester) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        String[] studendIDs;
        String q = "SELECT registration_no from students where semester_no = " + semester;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet students = stmt.executeQuery();
            if (students.last()) {
                studendIDs = new String[students.getRow()];
                students.beforeFirst();
                int id = 0;
                while (students.next()) {
                    studendIDs[id] = students.getString("registration_no");
                    id++;
                }
                return studendIDs;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            alert("Can't get students");
        }
        return null;
    }

    /**
     *
     * @param sectionID
     * @return strength of section
     */
    public static int getSectionStrength(String sectionID) {
        String q = "SELECT student_strength FROM section where section_id = '" + sectionID + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            return rs.getInt("student_strength");
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    /**
     *
     * @param semester_no
     * @param program_id
     * @return String[]: list of section IDs of semester_no and program_id
     */
    public static String[] getSectionIDs(int semester_no, int program_id) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        String[] sectionIDs;
        try {
            String q = "SELECT section_id FROM section where semester_no = " + semester_no + " and program_id = " + program_id;
            System.out.println(q);
            stmt = conn.prepareStatement(q);
            ResultSet sections = stmt.executeQuery();
            if (sections.last()) {
                sectionIDs = new String[sections.getRow()];
                sections.beforeFirst();
                int id = 0;
                while (sections.next()) {
                    sectionIDs[id] = sections.getString("section_id");
                    id++;
                }
                return sectionIDs;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param semester semester number
     * @return Integer total number of sections
     */
    public static int getSectionsOfSemester(int semester) {
        String q = "SELECT * FROM section where semester_no = " + semester;
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.last()) {
                return rs.getRow();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public static ResultSet getSectionProfessorAllocation(String sectionID) {
        String q = "SELECT * FROM section_professor_allocation where section_id = '" + sectionID + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();

        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static String[] getAllCourses() {
        String[] courses = null;
        String q = "select title from course";
        Connection conn = getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(q);
            ResultSet coursesRS = stmt.executeQuery();
            if (coursesRS.last()) {
                courses = new String[coursesRS.getRow()];
                coursesRS.beforeFirst();
                int i = 0;
                while (coursesRS.next()) {
                    courses[i] = coursesRS.getString("title");
                    i++;
                }
                return courses;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param query Valid SQL select query statement
     * @return Number of rows returned in query results -1 if case of exception
     */
    public static int getRowCount(String query) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.last()) {
                return rs.getRow();
            }
        } catch (SQLException ex) {

        }
        return -1;
    }

    /**
     *
     * @param query Valid SQL select query statement
     * @return ResultSet of query
     */
    public static ResultSet getRS(String query) {
        DBConnection.createConnection();
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return rs;
        } catch (SQLException ex) {

        }
        return null;
    }

    /**
     *
     * @param query Valid SQL select query statement will execute
     */
    public static void execute(String query) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(query);
            stmt.execute();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    /**
     *
     * @param query Valid SQL select query statement
     * @return true: if results found false if results not found
     */
    public static boolean duplicate(String query) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException ex) {

        }
        return false;
    }

    /**
     *
     * @param sectionID section ID to assign to students
     * @param startIndex start index for studentIDs
     * @param sectionStrength loop iteration
     * @param studentIDs list of students of specific semesters
     *
     * Assign section to students in studentIDs list from startIndex to strength
     */
    private static void allocateSections(String sectionID, int startIndex, int sectionStrength, String[] studentIDs) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            for (int i = 0; i < sectionStrength; i++, startIndex++) {
                String studentID = studentIDs[startIndex];
                String q = "update students SET "
                        + "section_id = '" + sectionID + "'"
                        + " WHERE "
                        + "registration_no = '" + studentID + "'";
                stmt = conn.prepareStatement(q);
                stmt.executeUpdate();
                q = "update student_section_allocation SET "
                        + "section_id = '" + sectionID + "'"
                        + " WHERE "
                        + "student_registration_no = '" + studentID + "'";
                stmt = conn.prepareStatement(q);
                stmt.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Creates empty schedule
     */
    public static void createInitialStudentSchedule() {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        int days = getDaysCount();
        int slots = getSlotCount();
        String query;
        ResultSet students = getAllStudent();
        try {
            String regNo, regularSection;
            System.out.println("Students found");
            while (students.next()) {
                regNo = students.getString("registration_no");
                regularSection = students.getString("section_id");
                for (int day = 1; day < days + 1; day++) {
                    for (int slot = 1; slot < slots + 1; slot++) {
                        query = "INSERT INTO student_schedule "
                                + "("
                                + "student_registration_no,"
                                + "day_no,"
                                + "timeslot_no,"
                                + "course_code,"
                                + "room_name,"
                                + "section_id,"
                                + "lecture_no,"
                                + "isLab"
                                + ")"
                                + " VALUES "
                                + "(?, ?, ?, ?, ?, ?, ?, ?)";
                        stmt = conn.prepareStatement(query);
                        stmt.setString(1, regNo);
                        stmt.setInt(2, day);
                        stmt.setInt(3, slot);
                        stmt.setString(4, "");
                        stmt.setString(5, "");
                        stmt.setString(6, regularSection);
                        stmt.setInt(7, 0);
                        stmt.setString(8, "false");
                        stmt.execute();
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Student schedule after schedule is generated
     */
    public static void mapSectionSchedule_ToStudents() {
        String query = "SELECT registration_no as RegNo, students.section_id as Section, course_code as Course, semester_no as Semester FROM students join student_section_allocation where \n"
                + "registration_no = student_registration_no and\n"
                + "students.section_id = student_section_allocation.section_ID";
        ResultSet students = getRS(query);
        String regNo, section, course;
        String courseTitle = "";
        try {
            while (students.next()) {
                regNo = students.getString("RegNo");
                section = students.getString("Section");
                course = students.getString("Course");
                ResultSet rs = getCourseDetails(course);
                if (rs.next()) {
                    courseTitle = rs.getString("title");
                }
                // try to get course from same section of student
                String getSchedule = "select * from section_schedule where course_code Like '" + courseTitle + "%' and section_id = '" + section + "'";
                ResultSet schedule = getRS(getSchedule);
                if (schedule.next()) {
                    schedule.beforeFirst();
                } else {
                    getSchedule = "select * from section_schedule where course_code Like '" + courseTitle + "%'";
                    schedule = getRS(getSchedule);
                    if (schedule.next()) {
                        String secID = schedule.getString("section_id");
                        getSchedule = "select * from section_schedule where course_code Like '" + courseTitle + "%' and section_id = '" + secID + "'";
                        schedule = getRS(getSchedule);
                    }
                }
                String sectionID, course_code, room_name, isLab;
                int day_no, timeslot_no, lecture_no;
                while (schedule.next()) {
                    sectionID = schedule.getString("section_id");
                    day_no = schedule.getInt("day_no");
                    timeslot_no = schedule.getInt("timeslot_no");
                    course_code = schedule.getString("course_code");
                    room_name = schedule.getString("room_name");
                    lecture_no = schedule.getInt("lecture_no");
                    isLab = schedule.getString("isLab");
                    // check if student has already some lecture
                    String checkClash = "select lecture_no "
                            + "from student_schedule "
                            + "where "
                            + "student_registration_no = '" + regNo + "' and "
                            + "day_no = " + day_no + " and "
                            + "timeslot_no = " + timeslot_no + " and "
                            + "lecture_no != 0";
                    System.out.println(checkClash);
                    ResultSet clash = getRS(checkClash);
                    if (clash != null && clash.next()) {
                        int lecture = clash.getInt("lecture_no");
                        System.out.println(lecture);
//                        alert("Clash");
                        if (lecture != 0) {
                            String q = "INSERT INTO student_schedule_clashes\n"
                                    + "(student_registration_no,\n"
                                    + "day_no,\n"
                                    + "timeslot_no,\n"
                                    + "course_code,\n"
                                    + "room_name,\n"
                                    + "section_ID,\n"
                                    + "lecture_no,\n"
                                    + "isLab,\n"
                                    + "isResolved)\n"
                                    + "VALUES "
                                    + "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
                            PreparedStatement stmt = getConnection().prepareStatement(q);
                            stmt.setString(1, regNo);
                            stmt.setInt(2, day_no);
                            stmt.setInt(3, timeslot_no);
                            stmt.setString(4, course_code);
                            stmt.setString(5, room_name);
                            stmt.setString(6, sectionID);
                            stmt.setInt(7, lecture_no);
                            stmt.setString(8, isLab);
                            stmt.setString(9, "false");
                            stmt.execute();
                            System.out.println("clash");
                            continue;
                        }
                    }
                    String updateStudentSchedule = "UPDATE student_schedule"
                            + " SET "
                            + "course_code = '" + course_code + "', "
                            + "room_name = '" + room_name + "', "
                            + "section_id = '" + sectionID + "', "
                            + "lecture_no = '" + lecture_no + "', "
                            + "isLab = '" + isLab + "'"
                            + " WHERE "
                            + "student_registration_no = '" + regNo + "' and "
                            + "day_no = " + day_no + " and "
                            + "timeslot_no = " + timeslot_no;
                    System.out.println(updateStudentSchedule);
                    execute(updateStudentSchedule);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String[] getStudentCourses(String regNo) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        String[] courses;
        String query = "SELECT * FROM student_section_allocation where student_registration_no = '" + regNo + "'";
        try {
            stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            if (rs.last()) {
                courses = new String[rs.getRow()];
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    courses[i] = rs.getString("course_code");
                    i++;
                }
                return courses;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void mapSectinoSchedule_ToProfessors() {
        // get all professor course allocations
        String professor_course_allocation = "SELECT * from section_professor_allocation";
        ResultSet professorAllocations = getRS(professor_course_allocation);
        try {
            // join with section schedule
            String professorID, courseCode, courseName = "";
            String getSchedule, updateSchedule;
            while (professorAllocations.next()) {
                professorID = professorAllocations.getString("professor_id");
                courseCode = professorAllocations.getString("course_code");
                ResultSet courseDetail = getCourseDetails(courseCode);
                if (courseDetail.next()) {
                    courseName = courseDetail.getString("title");
                }
                getSchedule = "SELECT * FROM section_professor_allocation join section_schedule using(section_id) where "
                        + "professor_id = " + professorID + " and section_professor_allocation.course_code = '" + courseCode + "' and section_schedule.course_code LIKE '%" + courseName + "%' and "
                        + "lab_or_theory = isLab";
                ResultSet result = getRS(getSchedule);
                String section_id, course_code, room_name, isLab;
                int lecture_no, day, slot;
                while (result.next()) {
                    section_id = result.getString("section_id");
                    course_code = result.getString("section_professor_allocation.course_code");
                    room_name = result.getString("room_name");
                    isLab = result.getString("isLab");
                    lecture_no = result.getInt("lecture_no");
                    day = result.getInt("day_no");
                    slot = result.getInt("timeslot_no");
                    updateSchedule = "UPDATE professor_schedule SET "
                            + "section_id = '" + section_id + "',"
                            + "course_code = '" + courseCode + "', "
                            + "room_name = '" + room_name + "', "
                            + "lecture_no = '" + lecture_no + "', "
                            + "isLab = '" + isLab + "' "
                            + " WHERE "
                            + "professor_id = '" + professorID + "' and "
                            + "day_no = " + day + " and "
                            + "timeslot_no = " + slot;
                    execute(updateSchedule);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static String getSlotDuration(int slot) {
        ResultSet rs = getRS("select starting_time, ending_time from timeslot where timeslot_no = " + slot);
        try {
            if (rs.next()) {
                String str = rs.getString(1).split(" ")[0] + " - " + rs.getString(2).split(" ")[0];
                return str;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    // lab scheduling
    public static void assignLabs() {
        // get all labs from sections
        String labs = "SELECT section_id, title "
                + "FROM section_professor_allocation join course using (course_code)"
                + " where "
                + "lab_or_theory='LAB'";
        ResultSet labsRS = getRS(labs);
        try {
            String sectionID, title;
            while (labsRS.next()) {
                sectionID = labsRS.getString("section_id");
                title = labsRS.getString("title");
                // get all slots where lab and sections are free
                ArrayList<FreeSlots> freeSlotsOfLabsAndSections = getTwoConsectiveFreeSlots(sectionID);
                if (freeSlotsOfLabsAndSections.size() < 1) {
                    System.out.println("No free slots");
                    alert("No free slots");
                    return;
                }
                System.out.println("Array Size: " + freeSlotsOfLabsAndSections.size());
                Random r = new Random(freeSlotsOfLabsAndSections.size());
                int randomNumber;
                int day, slot;
                String room;
                String updateQuery;

                while (true) {
                    // get a randome number in range of free slots array
                    randomNumber = (int) (Math.random() * freeSlotsOfLabsAndSections.size());
                    System.out.println(randomNumber);
                    day = freeSlotsOfLabsAndSections.get(randomNumber).getDay();
                    slot = freeSlotsOfLabsAndSections.get(randomNumber).getSlot();
                    room = freeSlotsOfLabsAndSections.get(randomNumber).getRoom();
                    // check if next slot is free?
                    if (nextSlotIsFree(day, slot, freeSlotsOfLabsAndSections)) {
                        // update section schedule
                        updateQuery = "update section_schedule "
                                + " SET "
                                + "course_code = '" + title + " LAB',"
                                + "room_name = '" + room + "',"
                                + "lecture_no = 3,"
                                + "isLab = 'true'"
                                + " WHERE "
                                + "section_id = '" + sectionID + "' and "
                                + "day_no = " + day + " and "
                                + "timeslot_no = " + slot;
                        execute(updateQuery);
                        updateQuery = "update section_schedule "
                                + " SET "
                                + "course_code = '" + title + " LAB',"
                                + "room_name = '" + room + "',"
                                + "lecture_no = 3,"
                                + "isLab = 'true'"
                                + " WHERE "
                                + "section_id = '" + sectionID + "' and "
                                + "day_no = " + day + " and "
                                + "timeslot_no = " + (slot + 1);
                        execute(updateQuery);
                        // update room_availability
                        updateQuery = "update room_availabilty "
                                + " SET "
                                + "is_available = 'true' "
                                + " WHERE "
                                + "room_name = '" + room + "' and "
                                + "day_no = " + day + " and "
                                + "timeslot_no = " + slot;
                        execute(updateQuery);
                        updateQuery = "update room_availabilty "
                                + " SET "
                                + "is_available = 'true' "
                                + " WHERE "
                                + "room_name = '" + room + "' and "
                                + "day_no = " + day + " and "
                                + "timeslot_no = " + (slot + 1);
                        execute(updateQuery);
                        break;
                    }
                    // assign sectionID and title to these slots    
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static boolean nextSlotIsFree(int day, int timeslot, ArrayList<FreeSlots> slots) {
        for (FreeSlots freeSlot : slots) {
            if (freeSlot.getDay() == day && freeSlot.getSlot() == timeslot + 1) {
                return true;
            }
        }
        return false;
    }

    // section and labs are free in ArrayList indexes of day and slot
    public static ArrayList<FreeSlots> getTwoConsectiveFreeSlots(String sectionID) {
        ArrayList<FreeSlots> freeLabs = new ArrayList<>();
        String getFreeLabs = "SELECT room_availabilty.room_name, section_schedule.day_no, section_schedule.timeslot_no FROM room_availabilty join room  join section_schedule\n"
                + "where\n"
                + "room_availabilty.day_no = section_schedule.day_no and\n"
                + "room_availabilty.timeslot_no = section_schedule.timeslot_no and\n"
                + "room_availabilty.room_name = name and\n"
                + "lecture_no = 0 and\n"
                + "room.isLab = 'true' and\n"
                + "is_available = 'false' and "
                + "section_id = '" + sectionID + "'";
        System.out.println(getFreeLabs);
        ResultSet rs = getRS(getFreeLabs);
        try {
            int day, slot;
            String room;
            while (rs.next()) {
                day = rs.getInt("day_no");
                slot = rs.getInt("timeslot_no");
                room = rs.getString("room_name");

                freeLabs.add(new FreeSlots(day, slot, room));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
        return freeLabs;
    }

    public static int get_Num_of_ExamDays() {
        int row_count = 0;
        String q = "select Count(*) as num_rows from exam_day";
        ResultSet rs = getRS(q);
        try {
            while (rs.next()) {
                row_count = rs.getInt("num_rows");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in getting number of exam days");
        }
        return row_count;
    }

    public static int get_Num_of_ExamTimeslots() {
        int row_count = 0;
        String q = "select Count(*) as num_rows from exam_timeslot";
        ResultSet rs = getRS(q);
        try {
            while (rs.next()) {
                row_count = rs.getInt("num_rows");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in getting number of exam timeeslots");
        }
        return row_count;
    }

    public static void add_Row_to_ExamDay(int day_no, String date, String weekday) {
        String q = "INSERT INTO exam_day"
                + " ("
                + "exam_day_no,"
                + "exam_date,"
                + "day"
                + ")"
                + " VALUES(?,?,?)";
        try {
            createConnection();
            PreparedStatement stmt = getConnection().prepareStatement(q);
            stmt.setInt(1, day_no);
            stmt.setString(2, date);
            stmt.setString(3, weekday);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void add_Row_to_ExamTimeslot(int slot_no, String start_time, String end_time) {
        String q = "INSERT INTO exam_timeslot"
                + " ("
                + "timeslot_no,"
                + "starting_time,"
                + "ending_time"
                + ")"
                + " VALUES(?,?,?)";
        try {
            createConnection();
            PreparedStatement stmt = getConnection().prepareStatement(q);
            stmt.setInt(1, slot_no);
            stmt.setString(2, start_time);
            stmt.setString(3, end_time);
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in adding exam timeslots in database");
        }
    }

    public static void add_Row_to_Datesheet(String rm_name, int day_no, int slot_no, String sec, String crs_code, int prof_id) {
        String q = "INSERT INTO datesheet"
                + " ("
                + "room_name,"
                + "exam_day_no,"
                + "timeslot_no,"
                + "section_id,"
                + "course_code,"
                + "professor_id"
                + ")"
                + " values(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(q);
            stmt.setString(1, rm_name);
            stmt.setInt(2, day_no);
            stmt.setInt(3, slot_no);
            stmt.setString(4, sec);
            stmt.setString(5, crs_code);
            stmt.setInt(6, prof_id);
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex + "   Error in adding row to the datesheet");
        }
    }

    public static ResultSet fetch_Complete_Datesheet() {
        createConnection();
        String q = "select exam_date as Date,"
                + " starting_time as start_time,"
                + " ending_time as end_time,"
                + " section_id as Section_id,"
                + " course_code as Title,"
                + " professor_id as Professor,"
                + " room_name as Room "
                + "from exam_day join datesheet using (exam_day_no) JOIN exam_timeslot using (timeslot_no) "
                + "where Section_id != \"\"\n"
                + "order by Date asc ";
        ResultSet rs = null;
        try {
            PreparedStatement stmt = getConnection().prepareStatement(q);
            rs = stmt.executeQuery();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Fetching Complete Datesheet");
        }
        return rs;
    }

    public static void add_ExaminationTitle(String title) {
        String q = "INSERT INTO examination"
                + " ("
                + "examination_id,"
                + "title"
                + ")"
                + " VALUES(?,?)";
        try {
            createConnection();
            PreparedStatement stmt = getConnection().prepareStatement(q);
            stmt.setInt(1, 1);
            stmt.setString(2, title);
            stmt.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in inserting examination Title");
        }

    }

    public static String get_Examination_Title() {
        String q = "select title from examination limit 1";
        ResultSet rs = null;
        String str = null;
        try {
            createConnection();
            PreparedStatement stmt = getConnection().prepareStatement(q);
            rs = stmt.executeQuery();
            while (rs.next()) {
                str = rs.getString("title");
                System.out.println(str);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in getting examination Title");
        }
        return str;
    }

}
