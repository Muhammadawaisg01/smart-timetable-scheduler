
package scheduler.pkg0 ; 

import java.util.ArrayList;

public class Scheduler { 
    
//    String professor;
//    String program ; 
    
    public int semester_no ; 
    public String section ; 
    public String room ; 
    public int slot ; 
    public int day ;
    public String course ; 
    public int lecture_no;
    
    public Scheduler( String room, int sem_no,String section ,int day,int slot, String course,int lec_no ) {
        this.section = section;
        this.room = room;
        this.slot = slot;
        this.day = day;
        this.course = course;
        this.semester_no = sem_no;
        this.lecture_no=lec_no;
    }   

    public Scheduler() {
    }

    @Override
    public String toString() {
        return "scheduler{" + "semester_no=" + semester_no + ", section=" + section + ", room=" + room + ", slot=" + slot + ", day=" + day + ", course=" + course + ", lecture_no=" + lecture_no + '}';
    }


    
    
//    @Override 
//    public String toString( ) 
//    {
//        return "Scheduler{room=" + room + ", slot=" + slot + ", day=" + day + ", course=" + course + '}';
//    }

    public static void display(ArrayList<Scheduler> sch) {
        int room_no = 0;
        while (room_no < Runner.rooms.size()) {
            String room = Runner.rooms.get(room_no).getName() ; 
            for (int i = 0; i < sch.size(); i++) {
                if(room.equalsIgnoreCase(sch.get(i).room)) {
                    System.out.println(sch.get(i).toString());
                }
            }
            System.out.println("");
        }
//        for(int i = 0 ; i < sch.size() ; i++ ) 
//        {
//            String rm = sch.get(i).room ;
//            int var = i ;
//            while(!sch.get(var).room.equals(rm) ) 
//            {
//                sch.get(var)
//                var++ ; 
//            }
//            if(  ) 
//            {
//            for( int j = 0 ; j <  ; j++ ) 
//            {
//                
//            }
//
//                System.out.println("") ; 
//            }
//            System.out.println(Runner.days.get(i).name+"\t" ) ;
//        }
//        
//        for( int i = 0 ; i < Runner.days.size() ; i++ )
//        {
//            System.out.println(Runner.days.get(i).name+"\t" ) ; 
//        } 
    }
    
    
    
    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    // Setters and Getters      
    
    
    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    
    
}   // CLASS
