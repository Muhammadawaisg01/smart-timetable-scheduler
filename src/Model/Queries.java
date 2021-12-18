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
import Model.student.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
        return null;
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
        String q = "select course_code from registered_courses where student_registration_no = " + reg_no;
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
     * @return section schedule > section days > sectino timeslots
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

    public static void addStudentsToDB(File file) {
        String addStudent = "insert into students "
                + "("
                + "registration_no,"
                + "name,"
                + "semester_no"
                + ")"
                + " values "
                + "(?, ?, ?)";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            Scanner read = new Scanner(file);
            while (read.hasNext()) {
                String line = read.nextLine();
                String[] list = line.split(",");
                String regNo = list[0];
                System.out.println(line);
                int semester = Integer.parseInt(list[2]);
                stmt = conn.prepareStatement(addStudent);
                stmt.setString(1, regNo);
                stmt.setString(2, "Student Name");
                stmt.setInt(3, semester);
//                stmt.execute();
                String addCourse = "insert into student_section_allocation"
                        + "("
                        + "student_registration_no,"
                        + "course_code"
                        + ")"
                        + " values "
                        + "(?, ?)";
                for (int i = 3; i < list.length; i++) {
                    String courseTitle = list[i];
                    String courseCode = getCourseCode(courseTitle);
                    if (courseCode == null) {
                        courseCode = courseTitle;
                    }
                    stmt = conn.prepareStatement(addCourse);
                    stmt.setString(1, regNo);
                    stmt.setString(2, courseCode);
                }
            }
        } catch (FileNotFoundException | SQLException ex) {
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException ex) {
            System.out.println("Semeseter Number is invalid in file");
            System.out.println(ex);
            Logger.getLogger(Queries.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(1);
        }
    }

    /**
     *
     * @param semester semester number
     * @return total sections
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
     * @return Number of rows returned in query results
     *         -1 if case of exception
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
     * @return true: if results found
     *         false if results not found
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
    
//    public static boolean hasLab(String courseCode) {
//        String q = "select * from course where cours_code = '" + courseCode + "' and hasLab = 'true'"; 
//        Connection conn = getConnection();
//        Prepa
//    }
}
