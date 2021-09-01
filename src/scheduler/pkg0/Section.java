
package scheduler.pkg0 ;

import java.util.ArrayList;

public class Section {   
    String no ; 
//    int strength;           // student strength
    
    ArrayList<Course> courses ;      
    
    ArrayList<Professor_Section_Allocation> allocations ;   
    
    Section_Schedule schedule ; 
    
    public Section( String no ) {   
        this.no = no ; 
    }   
    
    public Section() {
    }
    
    public String getNo() {
        return no;
    }
    
    @Override
    public String toString() {
        return "Section{" + "no=" + no + '}';
    }
    
}
