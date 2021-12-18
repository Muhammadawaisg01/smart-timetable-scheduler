package Model;

import Model.room.Room;
import Model.semester.Semester;
import Model.professor.ProfessorUtility;
import Model.professor.Professor;
import Model.student.Student;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Entities_Main_Arrays {

    public static ArrayList<Professor> professor_list = new ArrayList<>();

    public static ArrayList<Room> rooms = new ArrayList<>();

    public static ArrayList<Student> student_list = new ArrayList<>();

    public static ArrayList<Course> courses = null;

    public static ArrayList<Semester> semesters = new ArrayList<>();

    public static ArrayList<Program> programs = new ArrayList<>();

    public static void add_Data_to_Professor_List() {
        if (professor_list.isEmpty()) {
            professor_list = ProfessorUtility.readProfFile("Faculty.txt");
        }
    }

    public static void add_Data_to_Student_List() {
        if (student_list.isEmpty()) {
            student_list = Student.getData();
        }
    }

    public static void add_Data_to_Semester_List() {
        if (semesters.isEmpty()) {
            File file = new File("Semesters.txt");
            System.out.println("ffiillee\t\t" + file);
            // semester
            semesters = Semester.getSemesters(file);
            System.out.println(file.getAbsolutePath() + "\t\tpath");
//            System.exit(0);
        }
    }

    public static void add_Data_to_Program_List() {
//        File file = new File();
    }

    public static void readCourseFile() {
        File file = new File("Courses.txt");
        try {
            Scanner read = new Scanner(file);
            String[] line;
            while (read.hasNext()) {
                line = read.nextLine().split(",");
                courses.add(new Course(line[0], line[1]));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
