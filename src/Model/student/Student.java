package Model.student;


import static db.DBConnection.getConnection;

import Model.Course;
import Model.Entities_Main_Arrays;
import Model.WeekDays;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Student {

    private static Connection conn;
    
    private String registration_no;
    private String name;
    String section_id;

    Student_Schedule schedule;
    public ArrayList<Course> registered_courses = new ArrayList<>();

    private ArrayList<Student_lecture_clash> clash_array = new ArrayList<>();
    private ArrayList<Student_Section_Allocation> allocations = new ArrayList<>();

    public Student(String registration_no, String name, String section, ArrayList<Course> courses) {    // old constructor
        this.registration_no = registration_no;
        this.name = name;
        this.section_id = section;
        this.registered_courses = courses;
        schedule = new Student_Schedule(5, 6) ; 
    }
    
    public Student(String registration_no, String name, String section, ArrayList<Course> courses, int days, int slots) {
        this.registration_no = registration_no;
        this.name = name;                                       // new connstructor 
        this.section_id = section;
        this.registered_courses = courses ; 
        schedule = new Student_Schedule(days, slots) ; 
    } 

    public Student(String registration_no, String name, String section_id) {
        this.registration_no = registration_no;
        this.name = name;
        this.section_id = section_id;
    }
    
    
    
//    public Student(String registration_no, String name, int semester, String section) {
//        this.registration_no = registration_no;
//        this.name = name    ;   
//        this.semester = semester ;
//        this.section_id = section ;
//        schedule = new Student_Schedule(5,6);       // get days and slots from the admin
//    }   
    public void resetStudentClashArray() {
        clash_array.clear();
    }

    public void resetStudentScheduleArray(int days, int slots) {
        schedule.getDays().clear();
        schedule.initialize_Schedule(days, slots);
    }

    public void resetStudentAllocationArray() {
        allocations.clear();
    }

    public Student() {

    }

    @Override
    public String toString() {
        return "Student{" + "registration_no=" + registration_no + ", name=" + name + ", section_id=" + section_id + '}';
    }

    public void displayStudent() {
        System.out.println("Name   " + this.name);
        System.out.println("Registration No   " + this.registration_no);
//        System.out.println("Semester   " + this.semester);  
        System.out.println("Section   " + this.section_id);

        Student_Schedule schedule = this.getSchedule();

        for (int k = 0; k < schedule.getDays().size(); k++) {
            System.out.print(schedule.getDays().get(k).getNo() + "\t\t\t");
        }

    }

    public void display_Student() {  // display tabular data

        System.out.println("________________________________________");
        int i = 0, j = 0;
        Student_Schedule schedule = this.getSchedule();
        System.out.println("Student Name   " + this.name);
        System.out.println("Registration No  " + this.registration_no);
//        System.out.println("Semester   " + this.semester);  
        System.out.println("Section ID  :   " + this.getSection_id());

        display_registered_courses();
        for (int k = 0; k < schedule.getDays().size(); k++) {
//            System.out.println(schedule.days.get(k).no);
//            String d = "Days", r = "Room", cc = "Course Code", l = "Lec No", s ="Slot No" ;
//            System.out.printf("%-7s%-7s%-25s%-7s%7s", d, r, cc, l, s);
//            System.out.println("\n");
            System.out.printf("%-7s", WeekDays.names[schedule.getDays().get(k).getNo()]);
//            System.out.println(schedule.days.get(k).timeslots.size() + "\t//////////////////////////////////////////////");
            for (j = 0; j < schedule.getDays().get(k).getTimeslots().size(); j++) {
                System.out.printf("%-7s", schedule.getDays().get(k).getTimeslots().get(j).getRoom());
                System.out.printf("%-15s", schedule.getDays().get(k).getTimeslots().get(j).getCourse_code());
                System.out.printf("%-15s", schedule.getDays().get(k).getTimeslots().get(j).getSemester());
                System.out.printf("%-15s", schedule.getDays().get(k).getTimeslots().get(j).getSection());
                try {
                    System.out.printf("%7d<----------->", schedule.getDays().get(k).getTimeslots().get(j).getSlot_no());
                } catch (IndexOutOfBoundsException ex) {
                    System.out.println(ex);
//                        System.out.println(j + "\t" + k);
                    System.exit(0);
                }
                if (schedule.getDays().get(k).getTimeslots().get(j).isCheck()== false) {
                    System.out.print("__");
                } else {
//                        System.out.print( Course.getCourse(course,schedule.days.get(k).timeslots.get(j).course_code) + " ") ; 
                }
            }
            System.out.println();
        }
        System.out.println("_________________________My Clashes_____________________________________");
        for (int var = 0; var < this.getClash_array().size(); var++) {
            System.out.print("Registration_No  : " + getClash_array().get(var).getReg_no() + "\t");
            System.out.print("Semester  : " + getClash_array().get(var).getSemester() + "\t");
            System.out.print("Section  : " + getClash_array().get(var).getSection() + "\t");
            System.out.print("Room  : " + getClash_array().get(var).getRoom() + "\t");
            System.out.print("Day  : " + getClash_array().get(var).getDay_no() + "\t");
            System.out.print("Slot No  : " + getClash_array().get(var).getSlot_no() + "\t");
            System.out.print("Course  : " + getClash_array().get(var).getCourse() + "\t");
            System.out.print("isLab  : " + getClash_array().get(var).isIsLab() + "\t");
            System.out.print("Lecture No  : " + getClash_array().get(var).getLecture_no() + "\t");
            System.out.print("isResolved  : " + getClash_array().get(var).isIsresolved() + "\t");
            System.out.println("");
        }
//        for(int var=0; var<this.getAllocations().size(); var++){
//            System.out.println(this.getAllocations().get(i).toString());
//        }
    }

    public void display_registered_courses() {
        for (Course crs : registered_courses) {
            System.out.println(crs.toString());
        }
    }

    // setters and getters section        
    public String getRegistration_no() {
        return registration_no;
    }

    public void setRegistration_no(String registration_no) {
        this.registration_no = registration_no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public int getSemester(String section) {    
//        return semester;
//    }
//
//    public void setSemester(int semester) {
//        this.semester = semester;
//    }
    public String getSection_id() {
        return section_id;
    }

    public void setSection(String section_id) {
        this.section_id = section_id;
    }

    public Student_Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Student_Schedule schedule) {
        this.schedule = schedule;
    }

    public ArrayList<Course> getRegistered_courses() {
        return registered_courses;
    }

    public void setRegistered_courses(ArrayList<Course> registered_courses) {
        this.registered_courses = registered_courses;
    }

    public ArrayList<Student_lecture_clash> getClash_array() {
        return clash_array;
    }

    public void setClash_array(ArrayList<Student_lecture_clash> clash_array) {
        this.clash_array = clash_array;
    }

    public ArrayList<Student_Section_Allocation> getAllocations() {
        return allocations;
    }

    public void setAllocations(ArrayList<Student_Section_Allocation> allocations) {
        this.allocations = allocations;
    }

    public static void printAllStudents() {
        Entities_Main_Arrays.student_list.forEach((std) -> {
            std.display_Student();
        });
    }

    // querries
    private static ResultSet getStudents() {
        String q = "select * from students";
        try {
            PreparedStatement stmt = conn.prepareStatement(q);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    private static ArrayList<Course> getCourses(String stdRegNo) {
        ArrayList<Course> courses = new ArrayList<>();
        String q = "select * from registered_courses where student_registration_no = '" + stdRegNo + "'";
        try {
            PreparedStatement stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Course course = Course.getCourse(rs.getString("course_code"));
                courses.add(course);
            }
            return courses;

        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<Student> getData() {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Course> courses;
        conn = getConnection();
        ResultSet studentsRS = getStudents();
        String regNo, name, sectionID;
        try {
            while (studentsRS.next()) {
                regNo = studentsRS.getString("registration_no");
                name = studentsRS.getString("name");
                sectionID = studentsRS.getString("section_ID");
                courses = getCourses(regNo);
                students.add(new Student(regNo, name, sectionID, courses));
            }
            return students;
        } catch (SQLException ex) {
            Logger.getLogger(Student.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}   // Main Student Class

