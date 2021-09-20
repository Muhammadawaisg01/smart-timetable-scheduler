package schedule;

import Model.Lectures;
import java.sql.Connection;
import static Model.Professor_Section_Allocation.getData;   // allocations
import static Model.Professor.professorIsFree;
import static Model.Room.getRooms;
import static Model.Section.sectionIsFree;
import static db.DBConnection.getConnection;
import static db.DBConnection.createConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Schedule {

    Connection conn;
    private final static ArrayList<Integer> days = new ArrayList<>();
    private final static ArrayList<Integer> slots = new ArrayList<>();
    private static ArrayList<Lectures> lectureses = new ArrayList<>();

    public static void run() {
        ResultSet allocations = getData();
        try {
            String course, section;
            int profID;
            ArrayList<String> rooms = getRooms();
            System.out.println(rooms.size());
            while (allocations.next()) {
                // take a course
                boolean allocated = false;
                int lecture = 0; //  number of assigned lectures to this course
                course = allocations.getString("course_code");
                section = allocations.getString("section_id");
                profID = allocations.getInt("professor_id");
//                for (String room : rooms) {
                for (int slot : slots) {
                    // get a day from 1 to 5
                    for (int day : days) {
//                        System.out.println("Searching day: " + day + "" + slot + " " + course + " " + section + " " + profID);
                        // get a slot from 1 to 6
                        // check professor is free
                        ResultSet teachingCourses = professorIsFree(day, slot, profID);
                        if (teachingCourses != null && !teachingCourses.next()) {
//                            System.out.println("Porfessor is free_________________________________________________________");
                            // professor is free
                            // check section is free
                            ResultSet sectionLecture = sectionIsFree(day, slot);
                            if (sectionLecture != null && !sectionLecture.next()) {
                                // section is free
                                // find empty room at that slot
//                                System.out.println("Section is free_________________________________________________________");
                                int i = 0;
                                for (String room : rooms) {   // checking if room is empty in current day slot
                                    System.out.println(i++);
                                    boolean roomIsBusy = getRooms(day, slot, room);
                                    System.out.println(roomIsBusy + " " + room + " " + day + " " + slot);
                                    if (!roomIsBusy) {
                                        // empty room found in current day and slot
                                        createLecture(section, course, room, day, slot, false);
                                        lecture++;
                                        allocated = true;
                                        break;
                                    }
                                }
                                if (allocated) {    // course is allocated a slot
                                    // move to next course
                                    break;
                                }
                                // else find next slot
                            }
                        }
                    }
                    if (allocated && lecture == 2) {    // both lectures are allocated
                        break;
                    }
                }
//                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void createLecture(String sectionID, String courseCode, String roomNo, int day, int slot, boolean isLab) {
        lectureses.add(new Lectures(sectionID, courseCode, roomNo, day, slot, isLab));
//        System.out.println("Creating lecture%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        String q = "insert into lectures "
                + "('section_id',"
                + "'course_code',"
                + "'room_name',"
                + "'day_no',"
                + "'timeslot_no',"
                + "'isLab')"
                + " VALUES "
                + "( '" + sectionID + "',"
                + "'" + courseCode + "',"
                + "'" + roomNo + "',"
                + "" + day + ","
                + "" + slot + ","
                + "'" + isLab + "'"
                + ")";
        q = "INSERT INTO `lectures`(`section_id`, `course_code`, `room_name`, `day_no`, `timeslot_no`, `isLab`) VALUES ('" + sectionID + "','" + courseCode + "','" + roomNo + "','" + day + "','" + slot + "','false')";
        Connection con = getConnection();
//        System.out.println(q);
//        System.out.println(sectionID + " " + courseCode + " " + roomNo + " " + day + " " + slot + " " + isLab);
        PreparedStatement stmt;
        try {
            stmt = con.prepareStatement(q);
//            stmt.setString(1, sectionID);
//            stmt.setString(2, courseCode);
//            stmt.setString(3, roomNo);
//            stmt.setInt(4, day);
//            stmt.setInt(5, slot);
//            stmt.setString(6, isLab + "");

            stmt.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        days.add(1);
        days.add(2);
        days.add(3);
        days.add(4);
        days.add(5);

        slots.add(1);
        slots.add(2);
        slots.add(3);
        slots.add(4);
        slots.add(5);
        slots.add(6);
        createConnection(); // conection to db
        // Assigning professor to section
//        Runner.assignProfessorToSections(); 
        run();
        for (Lectures lectures : lectureses) {
            System.out.println(lectures.toString());
        }
    }
}
