

package Controller;

import static Model.Entities_Main_Arrays.programs;
import static Model.Entities_Main_Arrays.rooms;
import Model.Room;
import Model.Section;
import Model.Semester;
import java.util.ArrayList;


public class new_algorithm {
    
    
    
    int num_of_lectures = 2 ;               // based on user input entered in schedule generartion panel
    int consecutive_slots_per_lab = 2 ;     // based on user input entered in schedule generartion panel

    
    public void algorithm_first() {   
                                                // rooms has high priority than all other entities
        ArrayList<Section> high_priority_sections = new ArrayList<>() ; 
        
        boolean is_room_specified_for_courses = false;
        
        for(int r = 0; r < rooms.size(); r++ ) { 
            Room room = rooms.get(r) ;  
            if(rooms.get(r).getSpecified_courses().isEmpty() ) {  
                
                is_room_specified_for_courses = false ;  
            } 
            else { 
                is_room_specified_for_courses = true ;  
            }
        }
        
        
        if(is_room_specified_for_courses){
           // check that if it has very less slots available or maximum slots are available of this room  
           
        }
        
        for(int i = 0 ; i < programs.size() ; i++)  {    
            ArrayList<Semester> semesters = programs.get(i).getSemesters(); 
            
            for(int j = 0 ; j < semesters.size() ; j++) { 
                ArrayList<Section> sections = semesters.get(j).getSections(); 
                
                for( int k = 0 ; k < sections.size() ; k++ ) {  
                    
                    if(sections.get(k)  )  {    
                        
                    }
                }
            }
        }
    }
    
    
    private boolean check_if_room_is_available_in_less_slots(){
        
    }
    private Room get_room_having_compatible_capacity( int sec_strength ) { 
        Room rm = new Room() ; 
        for( int i = 0 ; i < rooms.size() ; i++ ) { 
            
        } 
        return rm ; 
    }
    
}
