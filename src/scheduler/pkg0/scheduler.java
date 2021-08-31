
package scheduler.pkg0 ; 

import java.util.ArrayList;

public class scheduler { 
    
//    String professor;
//    String program ; 
    
    int semester_no ; 
    String section ; 
    String room ; 
    int slot ; 
    String day ; 
    String course ; 
    int lecture_no;
    
    public scheduler( String room, int sem_no,String section ,String day,int slot, String course,int lec_no ) { 
        this.section = section;
        this.room = room;
        this.slot = slot;
        this.day = day;
        this.course = course;
        this.semester_no = sem_no;
        this.lecture_no=lec_no;
    }   

    public scheduler() {
    }

    @Override
    public String toString() {
        return "scheduler{" + "semester_no=" + semester_no + ", section=" + section + ", room=" + room + ", slot=" + slot + ", day=" + day + ", course=" + course + ", lecture_no=" + lecture_no + '}';
    }


    
    
//    @Override 
//    public String toString( ) 
//    {
//        return "scheduler{room=" + room + ", slot=" + slot + ", day=" + day + ", course=" + course + '}';
//    }

    public static void display(ArrayList<scheduler> sch) {
        int room_no = 0;
        while (room_no < Scheduler0.rooms.size()) {
            String room = Scheduler0.rooms.get(room_no).name;
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
//            System.out.println(Scheduler0.days.get(i).name+"\t" ) ;
//        }
//        
//        for( int i = 0 ; i < Scheduler0.days.size() ; i++ )
//        {
//            System.out.println(Scheduler0.days.get(i).name+"\t" ) ; 
//        } 
    }
    
    
}   // class
