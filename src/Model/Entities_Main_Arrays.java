



package Model;

import java.io.File;
import java.util.ArrayList;

public class Entities_Main_Arrays {
    
    public static ArrayList<Professor> professor_list =  new ArrayList<>() ;  
    
    public static ArrayList<Room> rooms = new ArrayList<>() ;   

    public static ArrayList<Student> student_list = new ArrayList<>() ; 
    
    public static ArrayList<Course> courses = new ArrayList<>() ;     
    
    public static ArrayList<Semester> semesters = new ArrayList<>();
    
    public static ArrayList<Program> programs = new ArrayList<>() ;
    
    public static void add_Data_to_Professor_List(){    
        if(professor_list.isEmpty()){
            professor_list = ProfessorUtility.readProfFile("Faculty.txt") ; 
        }
    }

    public static void add_Data_to_Student_List()   {   
        if(student_list.isEmpty()){
            student_list = Student.getData() ;            
        }
    } 
    public static void add_Data_to_Semester_List()   {   
        if(semesters.isEmpty()){
//            File file = new File("Semesters.txt");
            // semester
            semesters = Semester.getSemesters();
            System.out.println(semesters.size());
//            System.exit(0);
        }
    }    
    
    public static void add_Data_to_Program_List()   {   
        
    }
    
}   
