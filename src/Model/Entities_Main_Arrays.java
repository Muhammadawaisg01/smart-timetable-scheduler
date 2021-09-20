



package Model;

import java.util.ArrayList;

public class Entities_Main_Arrays {
    
    public static ArrayList<Professor> professor_list ;  
    
    public static ArrayList<Room> rooms = new ArrayList<>() ;   

    public static ArrayList<Student> student_list = new ArrayList<>() ; 

    public static ArrayList<Course> courses = new ArrayList<>() ;     
    
    public static ArrayList<Semester> semesters;

    
    public static void add_Data_to_Professor_List(){    
        professor_list = ProfessorUtility.readProfFile("Faculty.txt") ; 
    } 

    public static void add_Data_to_Student_List()   {   
        student_list = Student.getData() ; 
    } 
    
    
}   
