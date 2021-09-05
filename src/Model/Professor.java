

package Model ; 

import java.util.ArrayList ; 

public class Professor { 
    int id ;        
    String name ;   
    
    Professor_Schedule schedule ; 
    
    ArrayList<Professor_Timeslot> clash_array ; 
    
    public Professor( int id, String name ) { 
        this.id = id ; 
        this.name = name ; 
    }   
    

    public Professor() {
    }
    
    
    
}



