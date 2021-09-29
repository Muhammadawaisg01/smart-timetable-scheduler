
package Model ; 

import java.util.ArrayList ; 

public class Program {
    String id ; 
    String name ; 
    ArrayList<Semester> semesters ; 

    public Program(String id, String name, ArrayList<Semester> semesters) { 
        this.id = id ;
        this.name = name ;
        this.semesters = semesters ;
    } 
    
    public Program() {
    }

}

