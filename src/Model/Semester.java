package Model;

import static scheduler.pkg0.Runner.semesters;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

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
        return "Semester{" + "no=" + no + ", sections=" + sections + '}';
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
            if (section.getNo().equalsIgnoreCase(name)) {
                return section;
            }
        }
        return null;
    }

    public void createSection(String name) { 
        sections.add(new Section(name) ) ; 
    } 

    public static ArrayList<Semester> getSemesters(File file) {
        ArrayList<Semester> semesters = new ArrayList<>();
        try {
            Scanner read = new Scanner(file);
            String[] arr;
            while (read.hasNext()) {
                arr = read.nextLine().split(",");
                int semNo = Integer.parseInt(arr[0]);
                Semester semester = null;
                boolean duplicate = checkDuplication(semesters, semNo);
                if (!duplicate) {
                    semester = new Semester(semNo);
                } else {
                    for (Semester s : semesters) {
                        if (s.getNo() == semNo) {
                            semester = s;
                            break;
                        }
                    }
                }
                semester.createSection(arr[1]);
                for (int i = 2; i < arr.length; i++) {
                    Objects.requireNonNull(semester.getSection(arr[1])).addCourse(new Course(arr[i]));
                }
                if (!duplicate) {
                    semesters.add(semester);
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return semesters;
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
