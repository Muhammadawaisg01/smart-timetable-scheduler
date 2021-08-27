package scheduler.pkg0;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Scheduler0 {

    static ArrayList<Student> students = new ArrayList<>();

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<String> labs = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static String[][] array = new String[6][6];
    static ArrayList<Course> course = new ArrayList<>();
    static int sections = 0;
    static ArrayList<Day> days = new ArrayList<>();

    static ArrayList<TimeSlot> slots = new ArrayList<>();
    static ArrayList<scheduler> scheduler = new ArrayList<>();

    static ArrayList<Semester> semesters = new ArrayList<>();

    static String course_name[] = {"ICT", "ISLAMIYAT", "CALCULUS", "English", " PF", "MULTICAL",
        "ECA", "Report", "Discrete Structures", "Pak Study", "Genetics",
         "Data structures", "OOP", "Comm. Skills", "SE", "Stats", "DLD", "OS",
         "OOSE", "ITM", "DB", "ppit", "dccn", "AI", "SRE", "WEB", "LA",
        "VP", "HCI", "SQE", "SDA", "SPM",
        "MAD", "web", "DP", "Testing",
        "Research", "French", "enterpreneurship", "CAL2"};

    public static void main(String[] args) {

        inputForRooms_Labs(); // First Work  
//        method1();
        inputting();
        input_Validation_Method();
//
        algorithm();
////        displaySlots();
//
        for ( scheduler sch : scheduler ) { 
            System.out.println(sch.toString() ) ; 
        } 
                displayRoom();

//        boolean run = true;
//        String sec;
//        String sem;
//        while (run) {
//            System.out.println("Enter Semester Number") ; 
//            sem = in.next() ; 
//            System.out.println("Enter Section Number") ; 
//            sec = in.next() ; 
//            displayInfo(sem, sec) ; 
//        }

//        int n=0 ; 

//        permute(course) ; 
//        System.out.println("SIZE    "+course.size() ) ; 
//        for(int i = 0 ; i < course.size() ; i++)    
//        {
//            System.out.println("Num :   "+i+"   "+course.get(i).toString() ) ; 
//        }
//        viewModel() ; 
    } // MAIN METHOD 

    public static void mainMenu() {
        System.out.println("SEMESTER WISE TIMETABLE") ; 
        System.out.println("") ; 
    }

    public static void insertingData() {
        ArrayList<Course> course_temp = new ArrayList<>();
        for (int i = 0; i < semesters.size(); i++) {
//            for(int k = 0 ; k <   ; k++ ) 
            {

            }
            for (int j = 0; j < (int) (5 + Math.random() * 6); j++) {
                course_temp.add(new Course((j + 1), course_name[j], 4, "y"));
            }
        }
    }

    static String day_name[] = {"Mon", "Tues", "Wed", "Thurs", "Fri", "Sat", "Sun"} ; 
    static String slots_timing[] = {"08:30AM-10:00AM","10:00AM-11:30AM","11:30AM-01:00PM","01:00PM-02:30PM","2:30PM-04:00PM","04:00PM-05:30PM" } ;  
    public static void slotting(int room, int day, int slot) { 
        for (int r = 0; r < room; r++) { 
            Room rm = new Room() ; 
            rm.name = "1 0 " + (r + 1) ; 
            rm.check = false ; 
            for (int d = 0; d < day; d++) {
                Day d1 = new Day();
                d1.id = d + 1;
                d1.name = day_name[d];
                for (int i = 0; i < slot; i++) {
                    TimeSlot st = new TimeSlot();
                    st.duration = slots_timing[i];
                    st.check = false;
                    st.no = i + 1;
                    slots.add(st);
                }

                ArrayList<TimeSlot> newarray1 = new ArrayList<>() ; 
                newarray1.addAll(slots) ; 
                slots.clear() ; 
                d1.timeslots = newarray1 ; 
                days.add( d1 ) ; 
            } 
            ArrayList<Day> newarray2 = new ArrayList<>() ; 
            newarray2.addAll(days) ; 
            days.clear() ; 
            rm.days = newarray2 ; 
            rooms.add(rm) ; 
        } 
    } 

    public static void inputting() {
        ArrayList<Section> secs = new ArrayList<>() ; 

        int sem = 0, num_sections = 0 ; 
        String name;
        int counter = 0;
        int num_of_courses;
        System.out.print("Enter Title of Program  :   ");
        name = in.next();
        System.out.print("Enter Number of semesters   :   ");
        sem = in.nextInt();
        for (int p = 0; p < sem; p++) {
            System.out.println("Enter  " + (p + 1) + " Semester Details  :  ");
            System.out.print("Enter number of sections in this Semester  :   ");
            num_sections = in.nextInt();

            System.out.print("Number of Courses in Semester  :  ");
            num_of_courses = in.nextInt();

            Semester smstr = new Semester();
            smstr.no = p + 1;
            for (int k = 0; k < num_sections; k++) {
                Section sec = new Section("" + (k + 1));
                secs.add(sec);
            }
            ArrayList<Section> newarray1 = new ArrayList<>();
            newarray1.addAll(secs);
            secs.clear();
            smstr.sections = newarray1;
            for (int m = 0; m < num_of_courses; m++) {
                course.add(new Course((m + 1), course_name[counter], 4, "y"));
                counter++ ; 
                if (counter == course_name.length) { 
                    counter = 0 ; 
                } 
            } 
            ArrayList<Course> newarray2 = new ArrayList<>();
            newarray2.addAll(course);
            course.clear();
            smstr.courses = newarray2;
            semesters.add(smstr);
        }
        System.out.println("");
    }

    public static void inputForRooms_Labs() { 
        System.out.print("Enter number of rooms in department  :  ") ; 
        int input1 = in.nextInt() ;

//        System.out.println("Enter No. of labs  :   ") ; 
//        int input2 = in.nextInt() ; 
        System.out.print("Enter number of working days  ( < 7 ) :   ");
        int input3 = in.nextInt();

        System.out.print("Enter number of Timeslots in each day   :   ") ; 
        int input4 = in.nextInt() ; 
        slotting(input1, input3, input4) ; 

//        for(int i = 0 ; i < input2 ; i++ ) 
//        { 
//            labs.add("LAB "+(i+1) ) ; 
//        } 
    } 

    public static void method1() {
        System.out.println("Enter number of students  :  ");
        int input1 = in.nextInt();
        System.out.println("Enter No. of Sections you want to make  :   ");
        sections = in.nextInt();

        System.out.println("Number of sections are  :    " + sections + "\tapproximately number of students in each section  are   " + (input1 / sections));

        System.out.println("    Enter Courses Details  :   \n\n");
        System.out.print("Enter No. of courses  being taught in each section  :   ");
        int input3 = in.nextInt();

        int n = 0;
        while (n < input3) {
//            System.out.print("Enter Name  :  ") ; 
//            String input4 = in.next() ; 
//            System.out.print("Enter Credit Hours  :  ") ; 
//            int input5 = in.nextInt() ; 
//            System.out.print("Course is with Lab or Not (y/n) :   ") ; 
//            String input6 = in.next() ; 

            course.add(new Course(n + 1, "Course " + (n + 1), 4, "y"));
            n++;
        }
//        checkingLab() ; 
        printCourse();
//        algorithm() ; 
    }

    static boolean[][] checks = new boolean[6][6];

    public static void input_Validation_Method() {
        int var2 = rooms.size();
        int var1 = rooms.get(0).days.size();
        int var3 = rooms.get(0).days.get(0).timeslots.size();            //timeslots     

        int total_slots = var1 * var2 * var3;

        int total_credithours = course.size();
        int lectures = 2 * total_credithours;

//        int diff = semesters
        int difference = total_slots - (50 * lectures);

        if (difference > 0) {
            System.out.println("ALL OK, SET TO GO FOR TIMETABLE \n\n\n");
        } else if (difference < 0) {
            System.out.println("ROOMS AND TIMESLOTS ARE LESS AND LECTURES ARE GREATER IN NUMBER , ");
        }
    }

    static ArrayList<String> Labs = new ArrayList<>();

    public static void checkingLab() {
        for (int i = 0; i < course.size(); i++) {
            if (course.get(i).lab.equals("y")) {
                Labs.add(course.get(i).title + "  LAB");
                Labs.add(course.get(i).title + "  LAB");
            }
        }
    }

    public static void algorithm() {
        boolean check1 = false;
        boolean check2 = false;

        int i = 0, j = 0, k = 0, l = 0, m = 0, n = 0, o = 0, r = 0, c = 0;
        c = rooms.size();
        String course_name, day_name = "";
        int var = 0, slot = 0;

        for (int sem = 0; sem < semesters.size(); sem++) {                // algo starts here  

            for (k = 0; k < semesters.get(sem).sections.size(); k++) {
                Room rm = rooms.get(var);
                var++;
                if (var == c) {
                    var = 0;
                } ; 

                for (o = 0; o < 2; o++) // for credit hours/timeslots = 2    
                {
                    for (int a = 0; a < semesters.get(sem).courses.size(); a++) {

                        for (l = 0; l < rm.days.get(0).timeslots.size(); l++) {

                            for (r = 0; r < rm.days.size(); r++) {

                                if (rm.days.get(r).timeslots.get(l).check == false) {

                                    day_name = rm.days.get(r).name;

                                    rm.days.get(r).timeslots.get(l).check = true;

                                    course_name = semesters.get(sem).courses.get(a).title;
                                    scheduler.add(new scheduler(rm.name, semesters.get(sem).no+"" , "" + (semesters.get(sem).sections.get(k).no),
                                            day_name, rm.days.get(r).timeslots.get(l).duration, course_name));

                                    check1 = true;
                                    break;
                                }
                            }
                            if (check1) {
                                check1 = false;
                                break;
                            }
                        }

                    } //slot=0 ; 
                    permute(semesters.get(sem).courses);

                }
//                    System.out.println("Section "+ (k+1)+"  TimeTable" ) ; 
            }
        }
    } // algorithm 

    public static void arrayCleaning() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = null;
                checks[i][j] = false;
            }
        }
    }

    public static void methodA() {
        for (int i = 0; i < rooms.size(); i++) {
            System.out.println(rooms.get(i).toString());
//            rooms.get(i).display() ;
        }
    }

    public static int Highest_CreditHours() {
        int value = 0;
        for (int i = 0; i < course.size(); i++) {
            if (course.get(i).credit_hours > value) {
                value = course.get(i).credit_hours;
            }
        }
        return value;
    }

    public static void roomChecking() {
    }

    public static void methodRequired() {
        System.out.print("Enter the number of sections  :  (max 4) :  ");
        int input = in.nextInt();

        for (int i = 0; i < input; i++) {
//            if( i == 0 ) 
//            { 

            System.out.println("Schedule for Section No:   " + (i + 1));
            System.out.print("\t\t");

//                    printDays() ; 
            for (int var = 0; var < 2; var++) {
                System.out.print("TimeSlot : " + (var + 1) + "\t");
                for (int m = 0; m < array[var].length; m++) {
                    System.out.print(array[var][m] + "\t");
                }
                System.out.println("");
            }
        }
    }

    public static void printCourse() {
        for (int m = 0; m < course.size(); m++) {
            System.out.println(course.get(m).toString());
        }
        System.out.println("");
    }

    public static void addingStudent() {
        String query1 = " select * from scheduler01 ";
        int id = 0;
        String name = "";
        double marks = 0;
        try {
            System.out.println("hello-00");
            PreparedStatement stmt1 = DBConnection.init().prepareStatement(query1);
            System.out.println("hello1");
            ResultSet rs = stmt1.executeQuery();
            System.out.println("hello2");
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "   " + rs.getString(2));
//                id = rs.getInt(1) ; 
//                name = rs.getString(2); 
//                marks= rs.getDouble(3); 
//                students.add(new Student(id,name,marks) ) ; 
            }
            for (int i = 0; i < students.size(); i++) {
                System.out.println(students.get(i).toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in Fetching data from Students Table", "Student Table", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void viewModel() {
        for (int i = 0; i < scheduler.size(); i++) {
            System.out.print(scheduler.get(i).toString());
        }
//        System.out.println("") ; 
//        for(int i = 0 ; i < array.length;i++) 
//        { 
//            for(int j = 0; j < array[i].length;j++) 
//            { 
//                System.out.print(array[i][j]+"  ") ; 
//            } 
//            System.out.println("") ; 
//        } 
    }

    private static void permute(ArrayList<Course> array) {
        Course c = array.get(0);
        array.remove(0);
        array.add(array.size() - 1, c);
    }

    public static void displayInfo(String sem, String sec) {
        System.out.println("Schedule for:\nSemester: " + sem + "\nSection: " + sec) ;
        System.out.println("\n") ; 
        for (scheduler s : scheduler) { 
            if (s.section.equalsIgnoreCase(sec) && s.semester_no.equalsIgnoreCase(sem) ) { 
                System.out.println(s.toString()) ; 
            }
        }
    }

    public static void displaySlots() {
        for (int i = 0; i < rooms.size(); i++) {
            for (int j = 0; j < rooms.get(i).days.size(); j++) {
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                System.out.println("Day: " + rooms.get(i).days.get(i).name);
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
                for (int k = 0; k < rooms.get(i).days.get(j).timeslots.size(); k++) {
                    System.out.print(rooms.get(i).days.get(j).timeslots.get(k).toString() + "\t");
                }
                System.out.println("");
            }
        }
    }
    
    public static void displayRoom() 
    { 
        String[][] array =new String [6][7] ; 
        String var="";
        for( int i = 0 ; i < rooms.size() ; i++ ) 
        { 
            System.out.println("\n\t\t"+rooms.get(i).name+"\n" ) ; 
            for(String day : day_name ) { 
                System.out.print( day+"\t") ; 
            }
            System.out.println("");
//                System.out.print(rooms.get(i).days.get(j).name+ "\t" ) ; 
                    for(int j = 0 ; j < rooms.get(i).days.size(); j++ ) { 

                        for(int k = 0 ; k < rooms.get(i).days.get(0).timeslots.size(); k++ ){ 

                    if( rooms.get(i).days.get(j).timeslots.get(k).check == false ) { 
                        var = "__" ; 
                    } 
                    else{ 
                        var = "Lecture" ; 
                    } 
                    array[k][j] = var;
//                    System.out.println( var+"\t" ) ; 
                }
                    }
        for(int a = 0 ; a< array.length ; a++){
          for(int b = 0 ; b < array[0].length ; b++){
            System.out.print(array[a][b] + "\t") ; 
        }
        System.out.println("") ; 
        } 
            System.out.println("\n\n") ; 
        }
    } 

}   // main class 


