
package Controller.datesheet_generation ; 

import Model.Course;
import Model.Program;
import Model.Queries;
import static db.DBConnection.createConnection;
import static db.DBConnection.getConnection;

import static Model.Queries.getAllRooms;
import static Model.Queries.getProgramsDatastructure;
import Model.datesheet_generation.Datesheet;
import Model.datesheet_generation.Exam_Day;
import Model.datesheet_generation.Exam_Timeslot;
import Model.room.Room;
import Model.room.Room_Datesheet;
import Model.semester.Section;
import Model.semester.Section_Datesheet;
import Model.semester.Section_ExamDay;
import Model.semester.Section_ExamTimeslot;
import java.util.ArrayList ; 
import org.junit.runners.Parameterized;

public class Datesheet_generation_algorithm { 
    
    static int days;        
    static int timeslots;
    static ArrayList<Program> programs ;
    static ArrayList<Room> rooms ; 
    static Datesheet datesheet ; 

    
    public static void main_algorithm() {
        /* 
        execute query here to get number of days and timeslots for examination and initialize the datastructures
        */
        days = Queries.get_Num_of_ExamDays();
        timeslots = Queries.get_Num_of_ExamTimeslots();
        System.out.println("DAYS     "+days);
        System.out.println("TIMESLOTSS         "+timeslots);
        programs = Queries.getProgramsDatastructure() ;
        rooms = Queries.getAllRooms();
        filling_Section_DataStructure(days, timeslots);
        filling_Room_DataStructure(days, timeslots);
//        int iterator=0;
        for (int i = 0 ; i < programs.size();i++) {
            for(int j = 0 ; j < programs.get(i).getSemesters().size();j++) {
                for(int k = 0 ; k < programs.get(i).getSemesters().get(j).getSections().size();k++ ){   
                    // getting sections
                    Section section = programs.get(i).getSemesters().get(j).getSections().get(k) ;
                    
                    ArrayList<Course> section_courses = section.getSectionCourses() ;                   // get all courses of sections one-by-one   
                    int day_index=0,slot_index=0;
                    for(int course_index = 0 ; course_index < section_courses.size() ; course_index++ ) { 
                        Course course = section_courses.get(course_index) ; 
                        boolean check = false ;
                        Room rm = null;
//                        iterator=course_index;
                        for(day_index = course_index%days ; day_index< days; day_index++){
                            for(slot_index = 0 ; slot_index < timeslots; slot_index++){
                                rm = get_Room(day_index, slot_index) ;
                                if(rm != null){
                                    check = true;
                                    if(check){
                                        break;
                                    }
                                }
                            }
                            if(check){
                                break ;
                            }
                        }
                        //      assign the course 
                        assignation(rm, section, course, day_index, slot_index);
                    }
                }
            }
        }
//         run query here to put all data from rooms to the database/
        add_Data_to_Database(rooms);
    }
    private static void assignation(Room rm, Section sec, Course crs, int day, int slot){
        rm.getDatesheet().getDays().get(day).getExam_timeslots().get(slot).setCheck(true) ; 
        rm.getDatesheet().getDays().get(day).getExam_timeslots().get(slot).setCourse_code(crs.getTitle()) ; 
        rm.getDatesheet().getDays().get(day).getExam_timeslots().get(slot).setSectionid(sec.getId()); 
        int prof_id=0;
        for(int i = 0 ; i < sec.getAllocations().size(); i++){
            if(crs.getCourse_code().equals(sec.getAllocations().get(i).getCourse_code()))
                prof_id = sec.getAllocations().get(i).getProf_id() ; 
                break; 
        }
        rm.getDatesheet().getDays().get(day).getExam_timeslots().get(slot).setProfessor_id(prof_id) ;
        System.out.println("PROF ID       "+prof_id);
        sec.getSection_datesheet().getDays().get(day).getExam_timeslots().get(slot).setCheck(true) ;
    }
    private static Room get_Room(int day, int slot)  {   
        for(int rm_index = 0 ; rm_index < rooms.size(); rm_index++) {   
            Room rm = rooms.get(rm_index);
            if(!  rm.getDatesheet().getDays().get(day).getExam_timeslots().get(slot).isCheck()){      // if check is false
                return rm;
            }
        }
        return null;
    }    
    private static void filling_Section_DataStructure(int days, int slots){
        for (int i = 0 ; i < programs.size();i++) {
            for(int j = 0 ; j < programs.get(i).getSemesters().size();j++) { 
                for(int k = 0 ; k < programs.get(i).getSemesters().get(j).getSections().size();k++ ){
                    
                    Section section = programs.get(i).getSemesters().get(j).getSections().get(k) ;

                    Section_Datesheet sec_datesheet = new Section_Datesheet(days, slots) ; 
                    section.setSection_datesheet(sec_datesheet) ;  
                }
            }
        }        
    }    
    private static void filling_Room_DataStructure(int days, int slots) { 
        for(int i = 0 ; i < rooms.size() ; i++ ) { 
            Room_Datesheet datesheet = new Room_Datesheet(days, slots);
            rooms.get(i).setDatesheet(datesheet) ; 
        }
        
    }
    
    private static void add_Data_to_Database(ArrayList<Room> rooms){
        for(int i = 0 ; i < rooms.size();i++) {
            for(int j = 0 ; j < rooms.get(i).getDatesheet().getDays().size();j++){
                for(int k = 0 ; k < rooms.get(i).getDatesheet().getDays().get(j).getExam_timeslots().size();k++ ){
                    String rm_name=rooms.get(i).getName();
                    int day_no= rooms.get(i).getDatesheet().getDays().get(j).getDay_no();
                    int slot_no = rooms.get(i).getDatesheet().getDays().get(j).getExam_timeslots().get(k).getSlot_no(); 
                    String sec_id = rooms.get(i).getDatesheet().getDays().get(j).getExam_timeslots().get(k).getSectionid();
                    String crs_code = rooms.get(i).getDatesheet().getDays().get(j).getExam_timeslots().get(k).getCourse_code();
                    int prof_id = rooms.get(i).getDatesheet().getDays().get(j).getExam_timeslots().get(k).getProfessor_id();
                    Queries.add_Row_to_Datesheet(rm_name, day_no, slot_no, sec_id, crs_code, prof_id);        // add Data to database
                }
            }
        }
    }
}


