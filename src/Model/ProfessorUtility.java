
package Model;

import Model.Section;
import Model.Semester;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProfessorUtility {     

    /*
    @param fileName: Name of text file to read
    @return ArrayList of professor class
     */
    
    public static ArrayList<Professor> readProfFile(String fileName) {  
        ArrayList<Professor> list = new ArrayList<>();
        File file = new File(fileName);
        try {
            Scanner read = new Scanner(file);
            String[] line;
            while (read.hasNext()) {
                line = read.nextLine().split(",");
                list.add(new Professor(Integer.parseInt(line[0]), line[1]));
            }   
        } catch (FileNotFoundException e) { 
            e.printStackTrace() ;   
        }
        return list;
    }

    /*
    Assigning Professors to Sections
    @param Semester semester: Semester to which professor will be assign
    @param int Section: Section number of that semester to which professor will be assign
    @param Course: Course of that section to which ...
    @param Professor: Name of Professor to be assign
     */

    public static void assignProfToSection (Semester semester, Section section, String course, int profId) {
                section.setAllocations(profId, section.getNo(), semester.getNo(), course ) ; 
            }
        }
 

