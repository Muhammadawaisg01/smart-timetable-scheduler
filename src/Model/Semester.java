
package Model;


import static Controller.Runner.semesters;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Semester {

    int no;
    ArrayList<Section> sections = new ArrayList<>();

    public Semester() {
    }

    public Semester(int no, ArrayList<Section> sections) {
        this.no = no;
        this.sections = sections;
    }

    public Semester(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Semester{" + "no=" + no + ", sections=" + sections.size() + '}';
    }

    public int getNo() {
        return no;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    private Section getSection(String name) {
        for (Section section : this.sections) {
            if (section.getId().equalsIgnoreCase(name)) {
                return section;
            }
        }
        return null;
    }

    public void createSection(String name) { 
        sections.add(new Section(name) ) ; 
    } 
    
//    public static ArrayList<Semester> getSemesters(File file) {
//        ArrayList<Semester> semesters = new ArrayList<>();
//        try {
//            Scanner read = new Scanner(file);
//            String[] arr;
//            while (read.hasNext()) {
//                arr = read.nextLine().split(",");
//                int semNo = Integer.parseInt(arr[0]);
//                Semester semester = null;
//                boolean duplicate = checkDuplication(semesters, semNo);
//                if (!duplicate) {
//                    semester = new Semester(semNo);
//                } else {
//                    for (Semester s : semesters) {
//                        if (s.getNo() == semNo) {
//                            semester = s;
//                            break;
//                        }
//                    }
//                }
////                semester.(arr[1]);
////                System.out.println(semNo + "" + semester.getSections().size() + "\t////////////");
//                for (int i = 2; i < arr.length; i++) {
//                    Objects.requireNonNull(semester.getSection(arr[1])).addCourse(new Course(arr[i]));
////                    System.out.println(semester.getSection(arr[1]).getCourses().size());
//                }
//                if (!duplicate) {
//                    semesters.add(semester);
//                }
//            }
//        } catch (FileNotFoundException ex) {
//            System.out.println(ex);
//        } catch (Exception ex) {
//            System.out.println(ex);
//        }
//        return semesters;
//    }
    
    public static ArrayList<Semester> getSemesters() {
        Connection conn = getConnection();
        ArrayList<Semester> semesters = new ArrayList<>();
        String q = "select * from semester where program_id = 1";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int semNo = rs.getInt("semester_no");
                ArrayList<Section> sections = Section.getSections(semNo);
                System.out.println(semNo + "\t" + sections.size());
                for (Section section: sections) {
                    ArrayList<Course> courses = Course.getCourses(section.getId());
                    section.setSectionCourses(courses);
                }
                semesters.add(new Semester(semNo, sections));
            }
            return semesters;
        } catch (SQLException ex) {
            Logger.getLogger(Semester.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static boolean checkDuplication(ArrayList<Semester> semesters, int semNo) {
        for (Semester semester : semesters) {
            if (semester.getNo() == semNo) {
                return true;
            }
        }
        return false;
    }

    public static void displayAllData() {
        for (Semester semester : semesters) {
            ArrayList<Section> sec = semester.getSections();
            int semNo = semester.getNo();
            for ( Section section : sec ) { 
//                System.out.println(semNo + "    " + section.getNo());
                ArrayList<Professor_Section_Allocation> allocations = section.getAllocations()  ;   
                  
//                ArrayList<Section> sections = semester.getSections();
                
//                for (Section s: sections) { 
//                    s.schedule.display();
                    section.displaySection(semNo) ; 
                    
                int var=0;
                for (Professor_Section_Allocation allocation: allocations) {
//                    if (allocation.ge)
                    System.out.println(allocation.toString()+"\t"+var) ;  var++;   
                } 
//                }
            }
        }
    }
}
