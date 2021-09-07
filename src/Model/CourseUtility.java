/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class CourseUtility {
    
    public CourseUtility(){
    }
   
    
    
    public static ArrayList<Course> readCourseFile() {
        ArrayList<Course> list = new ArrayList<>();
        File file =  new File("Courses.txt") ;
        try{
        Scanner read =  new Scanner(file) ; 
        String[] line;
        while (read.hasNext()) {
                line = read.nextLine().split(",");
                list.add(new Course(line[0],line[1]) ) ; 
            }
            
        }catch (FileNotFoundException e) { 
            e.printStackTrace() ;   
        }
        return list;
    }
    
    
}
