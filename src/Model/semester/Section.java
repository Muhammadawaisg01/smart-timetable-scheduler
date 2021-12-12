package Model.semester;

import Model.Course;
import Model.WeekDays;
import Model.professor.Professor_Section_Allocation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import static Model.Entities_Main_Arrays.semesters;
import static db.DBConnection.getConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Section {  // GA POPULATION
//    private int clashes;   // number of clashes

    private String id;
    private int student_strength;           // student strength

    ArrayList<Course> sectionCourses = new ArrayList<>();           // courses offered in this section  
    ArrayList<Professor_Section_Allocation> allocations = new ArrayList<>();            // this professor is assigned to which course
    Section_Schedule schedule = new Section_Schedule();
    ArrayList<Section_Schedule> randomSchedules = new ArrayList<>();    // GA INDIVIDUALS 

    public ArrayList<Professor_Section_Allocation> getAllocations() {
        return this.allocations;
    }

    public Section_Schedule createNewSchedule() {
        return new Section_Schedule();
    }

//    private void setFittness(int fittness) {
//        this.clashes = fittness;
//    }
    public void setDay(int index, int day_no) {
        schedule.getDays().get(index).setNo(day_no);
    }

    public void setRoom(int day_index, int slot_no, String room) {
        schedule.getDays().get(day_index).getTimeslots().get(slot_no).setRoom(room);
    }

    public void set_lecture_no(int day_index, int slot_no, int lec_no) {
        schedule.getDays().get(day_index).getTimeslots().get(slot_no).setLecture_no(lec_no);
    }

    public void set_course(int day_index, int slot_no, String course) {
//        System.out.println(schedule.days.get(day_index).timeslots.size() + "\tSlot Number: " + slot_no);
        schedule.getDays().get(day_index).getTimeslots().get(slot_no).course_code = course;
    }

    public void set_check(int day_index, int slot_no, boolean check) {
        schedule.getDays().get(day_index).getTimeslots().get(slot_no).setCheck(check);
    }

    public void set_slot_no(int day_index, int slot_no) {
        schedule.getDays().get(day_index).getTimeslots().get(slot_no).setSlot_no(slot_no);
    }

    public void setAllocations(int profId, String sec, int sem, String course) {
        this.allocations.add(new Professor_Section_Allocation(profId, sec, sem, course));
    }

    public Section_Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Section_Schedule schedule) {
        this.schedule = schedule;
    }

    public Section(String id) {
        this.id = id;
//        this.fittness = 0;
    }

    public String getId() {
        return id;
    }

    public int getStrength() {
        return student_strength;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setStudent_strength(int student_strength) {
        this.student_strength = student_strength;
    }

    public void setSectionCourses(ArrayList<Course> sectionCourses) {
        this.sectionCourses = sectionCourses;
    }

    public void setAllocations(ArrayList<Professor_Section_Allocation> allocations) {
        this.allocations = allocations;
    }

    public ArrayList<Course> getSectionCourses() {
        return sectionCourses;
    }


    public void addCourse(Course crs) {
        this.sectionCourses.add(crs);
    }

    @Override
    public String toString() {
        return "Section{" + "ID=" + id + '}';
    }

    public void displaySection(int semesterNo) {  // display tabular data

        System.out.println("________________________________________");
        int i = 0, j = 0;
        Section_Schedule schedule = this.getSchedule();
        System.out.println("Semester No:\t" + semesterNo);
        System.out.println("Section_no      " + this.id);
        for (int k = 0; k < schedule.getDays().size(); k++) {
//            System.out.println(schedule.days.get(k).no);
//            String d = "Days", r = "Room", cc = "Course Code", l = "Lec No", s ="Slot No" ;
//            System.out.printf("%-7s%-7s%-25s%-7s%7s", d, r, cc, l, s);
//            System.out.println("\n");
            System.out.printf("%-7s", WeekDays.names[schedule.getDays().get(k).getNo()]);
//            System.out.println(schedule.days.get(k).timeslots.size() + "\t//////////////////////////////////////////////");
            for (j = 0; j < schedule.getDays().get(k).getTimeslots().size(); j++) {
                System.out.printf("%-7s", schedule.getDays().get(k).getTimeslots().get(j).getRoom());
                System.out.printf("%-15s", schedule.getDays().get(k).getTimeslots().get(j).course_code);
//                System.out.printf("%-7s", schedule.days.get(k).timeslots.get(j).lecture_no);
//                    int check = 0;
                try {
//                        System.out.println(schedule.days.get(k).timeslots.get(j).slot_no + "\txxxxxxxxxxxxxxxx");
                    System.out.printf("%7d<----------->", schedule.getDays().get(k).getTimeslots().get(j).getSlot_no());
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex);
//                        System.out.println(j + "\t" + k);
                    System.exit(0);
                }
                if (schedule.getDays().get(k).getTimeslots().get(j).isCheck() == false) {
                    System.out.print("__");
                } else {

//                        System.out.print( Course.getCourse(course,schedule.days.get(k).timeslots.get(j).course_code) + " ") ; 
                }
            }
            System.out.println();
        }

//        for(int var=0; var<this.getAllocations().size(); var++){
//            System.out.println(this.getAllocations().get(i).toString());
//        }
    }

    public static ResultSet sectionIsFree(int day, int slot) {
        String q = "select section_id, course_code, room_name from lectures where "
                + "day_no = " + day + " and "
                + "timeslot_no = " + slot;
        Connection conn = getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Section.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static int get_Semester_of_Section(String section) {
        String q = "select semester_no from section where section_id  = '" + section + "'";
//        System.out.println(q);
        int semester_no = 0;
        Connection conn = getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                semester_no = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("error in getting semester no of the section in the section details  ");
            ex.printStackTrace();
        }
//        System.out.println("i am the semester no  :  " + semester_no);
        return semester_no;
    }

    public static int get_Strength_of_Section(String section) {
        String q = "select student_strength from section where section_id  = " + section;
        int strength = 0;
        Connection conn = getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            strength = rs.getInt("semester_no");
        } catch (SQLException ex) {
            System.out.println("error in getting semester no of the section in the section details  ");
            ex.printStackTrace();
        }
        return strength;
    }

    /*
    @param semNo
    @return section of semNo
     */
    public static ArrayList<Section> getSections(int semNo) {
        Connection conn = getConnection();
        String q = "select section_id from section where semester_no = " + semNo;
        ArrayList<Section> sections = new ArrayList<>();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                String secId = rs.getString(1);
                sections.add(new Section(secId));
            }
            return sections;
        } catch (SQLException ex) {
            Logger.getLogger(Semester.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param secID search for secID in semester list
     * @return Section with secID
     */
    public static Section getSection(String secID) {
        for (Semester semester : semesters) {
            ArrayList<Section> sections = semester.getSections();
            for (Section sec : sections) {
                if (sec.getId().equalsIgnoreCase(secID)) {
                    return sec;
                }
            }
        }
        return null;
    }

    public static void writeToDatabase(ArrayList<Section> section) {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        int day, timeSlot, lectureNo;
        String courseCode, roomName, q;
        boolean isLab;
        for (Section schedule : section) {
            Section_Schedule section_Schedule = schedule.getSchedule();
            ArrayList<Section_Day> section_Days = section_Schedule.getDays();
            for (Section_Day section_Day : section_Days) {
                day = section_Day.getNo();
                ArrayList<Section_Timeslot> section_Timeslots = section_Day.getTimeslots();
                for (Section_Timeslot section_Timeslot : section_Timeslots) {
                    timeSlot = section_Timeslot.getSlot_no();
                    lectureNo = section_Timeslot.getLecture_no();
                    courseCode = section_Timeslot.getCourse_code();
                    roomName = section_Timeslot.getRoom();
                    isLab = section_Timeslot.isLab();
                    q = "Insert into section_schedule"
                            + "("
                            + "day_no,"
                            + "timeslot_no,"
                            + "course_code,"
                            + "room_name,"
                            + "lecture_no,"
                            + "isLab"
                            + ")"
                            + " VALUES "
                            + "(?, ?, ?, ?, ?, ?)";
                    try {
                        stmt = conn.prepareStatement(q);
                        stmt.setInt(1, day);
                        stmt.setInt(2, timeSlot);
                        stmt.setString(3, courseCode);
                        stmt.setString(4, roomName);
                        stmt.setInt(5, lectureNo);
                        stmt.setString(6, isLab + "");
                    } catch (SQLException ex) {
                        System.out.println(ex);
                        JOptionPane.showMessageDialog(null, "Something went wrong!");
                    }
                }
            }
        }
    }

    public void initializePopulation() {
        for (int i = 0; i < 10; i++) {
            randomSchedules.add(new Section_Schedule());
        }
    }

}
