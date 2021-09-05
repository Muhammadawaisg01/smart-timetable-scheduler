package Model ; 

import javax.security.sasl.SaslClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList ;
import java.util.Objects;
import java.util.Scanner;

public class Semester { 
    int no ; 
    ArrayList<Section> sections ; 
    
    public Semester() {
    }
    
    public Semester(int no, ArrayList<Section> sections) {
        this.no = no ;
        this.sections = sections ;
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
        for (Section section: this.sections) {
            if (section.getNo().equalsIgnoreCase(name)) {
                return section;
            }
        }
        return null;
    }

    public void createSection(String name) {
        this.sections.add(new Section(name));
    }

    public static ArrayList<Semester> getSemesters(File file) {
        ArrayList<Semester> semesters = new ArrayList<>();
        try  {
            Scanner read = new Scanner(file);
            String[] arr;
            while (read.hasNext()) {
                arr = read.nextLine().split(",");
                int semNo = Integer.parseInt(arr[0]);
                if (!checkDuplication(semesters, semNo)) {
                    Semester semester = new Semester(semNo);
                    semester.createSection(arr[1]);
                    for (int i = 2; i < arr.length; i++) {
                        Objects.requireNonNull(semester.getSection(arr[1])).addCourse(new Course(arr[i]));
                    }
                }
            }
        } catch (FileNotFoundException ex) {

        }
        return semesters;
    }

    private static boolean checkDuplication (ArrayList<Semester> semesters, int semNo) {
        for (Semester semester: semesters) {
            if (semester.getNo() == semNo) {
                return true;
            }
        }
        return false;
    }
    
    
}

