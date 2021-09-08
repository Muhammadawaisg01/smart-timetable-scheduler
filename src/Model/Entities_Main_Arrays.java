


package Model;

import java.util.ArrayList;

public class Entities_Main_Arrays {
    
    
    public static ArrayList<Professor> professor_list ;  
    
    public static void add_Data_to_Professor_List(){
        professor_list = ProfessorUtility.readProfFile("Faculty.txt") ; 
    } 
    
}
