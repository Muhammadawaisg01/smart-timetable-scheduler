package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import static Model.Entities_Main_Arrays.student_list;
import static Controller.Runner.semesters;
import static db.DBConnection.getConnection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Section {

    private int fittness;   // number of clashes
    private String id;
    private int student_strength;           // student strength

    ArrayList<Course> sectionCourses = new ArrayList<>();           // courses offered in this section  
    ArrayList<Professor_Section_Allocation> allocations = new ArrayList<>();            // this professor is assigned to which course

    Section_Schedule schedule = new Section_Schedule();

    public ArrayList<Professor_Section_Allocation> getAllocations() {
        return this.allocations;
    }

    public int getFittness() {
        return fittness;
    }

    private void setFittness(int fittness) {
        this.fittness = fittness;
    }

    public void setDay(int index, int day_no) {
        schedule.days.get(index).no = day_no;
    }

    public void setRoom(int day_index, int slot_no, String room) {
        schedule.days.get(day_index).timeslots.get(slot_no).room = room;
    }

    public void set_lecture_no(int day_index, int slot_no, int lec_no) {
        schedule.days.get(day_index).timeslots.get(slot_no).lecture_no = lec_no;
    }

    public void set_course(int day_index, int slot_no, String course) {
//        System.out.println(schedule.days.get(day_index).timeslots.size() + "\tSlot Number: " + slot_no);
        schedule.days.get(day_index).timeslots.get(slot_no).course_code = course;
    }

    public void set_check(int day_index, int slot_no, boolean check) {
        schedule.days.get(day_index).timeslots.get(slot_no).check = check;
    }

    public void set_slot_no(int day_index, int slot_no) {
        schedule.days.get(day_index).timeslots.get(slot_no).slot_no = slot_no;
    }

    public void setAllocations(int profId, String sec, int sem, String course) {
//        System.out.println("Sectionnnnnnnn: \t\t"+sec);
//        System.out.println("Semesterrrrrrrrr: \t\t"+sem);
//        System.out.println("Professor ID:\t\t"+profId);
//        System.out.println("Course    "+course);
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
        this.fittness = 0;
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

    public ArrayList<Course> getCourses() {
        return this.sectionCourses;
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
        for (int k = 0; k < schedule.days.size(); k++) {
//            System.out.println(schedule.days.get(k).no);
//            String d = "Days", r = "Room", cc = "Course Code", l = "Lec No", s ="Slot No" ;
//            System.out.printf("%-7s%-7s%-25s%-7s%7s", d, r, cc, l, s);
//            System.out.println("\n");
            System.out.printf("%-7s", WeekDays.names[schedule.days.get(k).no]);
//            System.out.println(schedule.days.get(k).timeslots.size() + "\t//////////////////////////////////////////////");
            for (j = 0; j < schedule.days.get(k).timeslots.size(); j++) {
                System.out.printf("%-7s", schedule.days.get(k).timeslots.get(j).room);
                System.out.printf("%-15s", schedule.days.get(k).timeslots.get(j).course_code);
//                System.out.printf("%-7s", schedule.days.get(k).timeslots.get(j).lecture_no);
//                    int check = 0;
                try {
//                        System.out.println(schedule.days.get(k).timeslots.get(j).slot_no + "\txxxxxxxxxxxxxxxx");
                    System.out.printf("%7d<----------->", schedule.days.get(k).timeslots.get(j).slot_no);
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex);
//                        System.out.println(j + "\t" + k);
                    System.exit(0);
                }
                if (schedule.days.get(k).timeslots.get(j).check == false) {
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
        System.out.println(q);
        int semester_no = 0;
        Connection conn = getConnection();
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            semester_no = rs.getInt(1);
        } catch (SQLException ex) {
            System.out.println("error in getting semester no of the section in the section details  ");
            ex.printStackTrace();
        }
        System.out.println("i am the semester no  :  " + semester_no);
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
        System.out.println(q);
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

    public void calFittness() {
        resetFitnes();
//        System.out.println("RESET FITTNESS");
//        printFittness();
        for (Semester semester : semesters) {
            ArrayList<Section> sections = semester.getSections();
            for (Section section : sections) {
                ArrayList<Course> courses = section.getCourses();
                for (Course course : courses) {
                    for (Student student : student_list) {
                        ArrayList<Student_lecture_clash> student_lecture_clashs = student.getClash_array();
                        for (Student_lecture_clash student_lecture_clash : student_lecture_clashs) {
                            if (course.getTitle().equalsIgnoreCase(student_lecture_clash.getCourse())
                                    && student_lecture_clash.getSection().equalsIgnoreCase(section.getId())
                                    && student_lecture_clash.getSemester() == semester.getNo()) {
                                section.fittness++;
                            }
                        }
                    }
                }
            }
        }
        System.out.println("After calculations");
        printFittness();
    }

    public void printFittness() {
        for (Semester semester : semesters) {
            ArrayList<Section> sections = semester.getSections();
            for (Section section : sections) {
                System.out.println(section.getId() + "\t" + section.fittness);
            }
        }
    }

    public void resetFitnes() {
        for (Semester semester : semesters) {
            ArrayList<Section> sections = semester.getSections();
            for (Section section : sections) {
                section.setFittness(0);
            }
        }
    }

}
