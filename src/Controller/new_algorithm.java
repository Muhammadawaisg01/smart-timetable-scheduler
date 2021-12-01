

package Controller;

import Model.Course;
import static Model.Entities_Main_Arrays.programs;
import static Model.Entities_Main_Arrays.rooms;
import Model.Room;
import Model.Room_Timeslot;
import Model.Section;
import Model.Semester;
import java.util.ArrayList;


public class new_algorithm {
    
    int num_of_lectures = 2 ;               // based on user input entered in schedule generartion panel
    int consecutive_slots_per_lab = 2 ;     // based on user input entered in schedule generartion panel


    public void algorithm_first() {   
                                                // rooms has high priority than all other entities
        ArrayList<Section> high_priority_sections = new ArrayList<>() ; 
        
        boolean is_room_specified_for_courses = false   ;   
        
        for(int r = 0; r < rooms.size(); r++ ) { 
            Room room = rooms.get(r) ;  
            if(room.getSpecified_courses().isEmpty() ) {
                is_room_specified_for_courses = false ;  
            } 
            else { 
                is_room_specified_for_courses = true ;  
            }
        }
        
        if(is_room_specified_for_courses){            
           // check that if it has very less slots available or maximum slots are available of this room  
           
           ArrayList<Section> all_sections = retreive_all_sections() ; 
           // calculate number of slots of all section required for the specific_course 
           for(){
               
           }
        }
    }
    
//    private Course get_specified_course_of_room() { 
//        
//    }
    
    private int calculate_num_of_slots_of_room_available(Room rm){
        int count = 0;
        for(int i = 0 ; i < rm.getDays().size() ; i++){
            for(int j = 0 ; j < rm.getDays().get(i).getTimeslots().size() ; j++){
                Room_Timeslot slot = rm.getDays().get(i).getTimeslots().get(j) ;
                
                if(slot.isCheck()){
                    count++ ; 
                }
            }
        }
        return count;
    }
    
    private boolean check_if_room_is_available_in_less_slots(Room rm ) { 
        for(int i = 0 ; i < ){ 
            
        }
    }
    
    private Room get_room_having_compatible_capacity( int sec_strength ) { 
        Room rm = new Room() ; 
        
        for( int i = 0 ; i < rooms.size() ; i++ ) { 
            
            if(rooms.get(i).getCapacity() < sec_strength) {      
                
            }            
        } 
        return rm ; 
    }
    
    
    private ArrayList<Section> retreive_all_sections()  {         
        ArrayList<Section> all_sections = new ArrayList<>() ; 
        
        for(int i = 0 ; i < programs.size() ; i++)  {    
            ArrayList<Semester> semesters = programs.get(i).getSemesters(); 
            
            for(int j = 0 ; j < semesters.size() ; j++) { 
                ArrayList<Section> sections = semesters.get(j).getSections(); 
                
                for( int k = 0 ; k < sections.size() ; k++ ) { 
                    all_sections.add(sections.get(k)) ;
                }
            }
        }
        return all_sections ;
    }
    
    
    


} // CLASS Closing

