
package Model ;    

import java.util.ArrayList; 

public class Student {  
    
    String registration_no ; 
    String name;

//    String program ;
    String semester;    // make it int 
    String section;
    
    ArrayList<Day_for_Student> days ; 
    
//    Student_Schedule schedule;

    ArrayList<Course> registered_courses= new ArrayList<>() ; 

    public Student(String registration_no, String name, String semester, String section, ArrayList<Day_for_Student> days, ArrayList<Course> courses) {
        this.registration_no = registration_no;
        this.name = name;
        this.semester = semester;
        this.section = section;
        this.days = days;   
        this.registered_courses = courses;
    }

    public Student(String registration_no, String name, String semester, String section) {
        this.registration_no = registration_no;
        this.name = name;
        this.semester = semester ;
        this.section = section ;
        this.initialize_Schedule() ;
    }
    
    public Student() {
    }

//    public void regCourses(String[] arr) {
//        for (String str : arr) {
//            System.out.print(str + " ");
//            this.courses.add(str);
//        }
//        System.out.print("\"");
//        System.out.println("");
//    }

    @Override
    public String toString() {
        return "Student{" + "registration_no=" + registration_no + ", name=" + name + ", semester=" + semester + ", section=" + section + ", days=" + days + ", courses=" + registered_courses + '}';
    }
    
    static String day_name[] = {"Mon", "Tues", "Wed", "Thurs", "Fri", "Sat", "Sun"} ; 
    //  add no. of days and timeslots dynamically   
    public void initialize_Schedule() { // initializing student days and slots with null values 
        this.days = new ArrayList<>() ; 
        
        for(int i = 0 ; i < 5 ; i++ ){ 
            Day_for_Student obj1 = new Day_for_Student();
            obj1.name= day_name[i];
            obj1.timeslots =  new ArrayList<>() ; 
        
        int semester=0;
        String section="";
        int slot_no=0;
        String course="";
        int lecture_no=0 ; 
        boolean check=false;
        String room="";
        for(int j = 0; j < 6; j++) { // 6 timeslots 
            Student_Timeslot obj = new Student_Timeslot( semester, section, j+1, course, lecture_no, check, room);
            obj1.timeslots.add(obj) ;
        }
        this.days.add(obj1) ; 
        }
//        for(Day_for_Student day: days){
//            System.out.println(day.toString()) ; 
//        }
    } 
    
    
    public void displayStudent(){
        int i = 0 , j = 0 ;
        System.out.println("Name   " + this.name);
        System.out.println("Registration No   " + this.registration_no);
        System.out.println("Semester   " + this.semester);
        System.out.println("Section   " + this.section);

        for(int k = 0 ; k< this.days.size(); k++){
            System.out.print(days.get(k).name + "\t\t\t") ; 
        } 
        System.out.println("");
        for( j = 0 ; j < this.days.get(0).timeslots.size(); j++) { 
    
        for( i = 0 ; i < this.days.size() ; i++ ) { 
            System.out.print(days.get(i).timeslots.get(j).room+" ") ;
            System.out.print(days.get(i).timeslots.get(j).semester+" " ) ;
            System.out.print(days.get(i).timeslots.get(j).section+" " );
            System.out.print(days.get(i).timeslots.get(j).course +" ") ;
            System.out.print(days.get(i).timeslots.get(j).lecture_no+" " ) ;
            System.out.print(days.get(i).timeslots.get(j).slot_no +" ") ;
            System.out.print(days.get(i).timeslots.get(j).check +" ") ;
            } 
            System.out.println() ; 
        } 
    }
}   // Main Student Class

