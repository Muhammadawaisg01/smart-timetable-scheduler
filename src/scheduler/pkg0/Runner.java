package scheduler.pkg0;

import Model.Course;
import Model.CourseUtility;
import Model.Student;
import Model.Section;
import Model.Semester;
import Model.Day;
import Model.Entities_Main_Arrays;
import Model.Professor;
import Model.ProfessorUtility;
import Model.TimeSlot;
import Model.Room;
import Model.SectionUtility;
import Model.Section_Schedule;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.JOptionPane;
import Model.StdUtility;
import Model.WeekDays;
import clashe_resolving.ProfessorClashes;
import static clashe_resolving.ProfessorClashes.clashesResolved;

public class Runner {

    static ArrayList<Student> students = new ArrayList<>();

    public static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Room> labs = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static String[][] array = new String[6][6];
    public static ArrayList<Course> course = new ArrayList<>();
    static int sections = 0;
    static ArrayList<Day> days = new ArrayList<>();

    static ArrayList<TimeSlot> slots = new ArrayList<>();
    public static ArrayList<Scheduler> scheduler = new ArrayList<>();  //public

    public static ArrayList<Semester> semesters;

    static String course_name[] = {"ICT", "ISLAMIYAT", "CALCULUS", "English", " PF", "MULTICAL",
        "ECA", "Report", "Discrete Structures", "Pak Study", "Genetics",
        "Data structures", "OOP", "Comm. Skills", "SE", "Stats", "DLD", "OS",
        "OOSE", "ITM", "DB", "ppit", "dccn", "AI", "SRE", "WEB", "LA",
        "VP", "HCI", "SQE", "SDA", "SPM",
        "MAD", "WEB", "DP", "Testing",
        "Research", "French", "enterpreneurship", "CAL2"};

    public static void main(String[] args) {

        course = CourseUtility.readCourseFile();
        System.out.println(course.size() + "\tSize of courses");
//        Section_Schedule obj1 = new Section_Schedule();   

        File file = new File("Semesters.txt");
        // semester
        semesters = Semester.getSemesters(file);

        Entities_Main_Arrays.add_Data_to_Professor_List();
//        System.out.println(semesters.size());
//        for (Semester semester : semesters) {
//            System.out.println(semester.getSections().size());
//            for (Section section : semester.getSections()) {
//                System.out.println(section.getCourses().size());
//            }
//        }
//        System.out.println(course.size() + "\tSize of courses");

//        System.exit(0);
        inputForRooms_Labs(); // First Work  

        algorithm();

//        displaySlots();  
// uncomment 
//        int i = 0;
//        for (Scheduler sch : scheduler) {
//            System.out.println(sch.toString());
//        }
//        
        assignProfessorToSections();
        SectionUtility.assign_schedule_to_section();
        algo_for_Professor_assigning.section_to_Professor_Scheduling();
//        Semester.displayAllData();

             // 

        for (Professor prof : Entities_Main_Arrays.professor_list) {
            prof.display_Professor();
        }
        System.out.println("I am the number of CLASHES VARIABLE\t\t" + algo_for_Professor_assigning.variable);
        algo_for_Professor_assigning.variable = 0;
        ProfessorClashes.resolveClashes();
        System.out.println("_____________________________________________________________________________");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("_____________________________________________________________________________");
//        Semester.displayAllData();
        for (Professor prof : Entities_Main_Arrays.professor_list) {
            prof.display_Professor();
        }
        
        System.out.println("I am the number of CLASHES VARIABLE\t\t" + algo_for_Professor_assigning.variable);
        System.out.println("Clashes Resolved: " + clashesResolved);

// uncomment this
//        displayRoom() ; 
//        StdUtility obj = new StdUtility()  ; 
//        obj.assigning_Schedule_To_Student(); 
//        for(Student s1 : StdUtility.student_list) { 
//            s1.toString();
//            s1.displayStudent() ; 
//        }
//        Student s1 = new Student();
//        s1.initialize_Schedule();
//        s1.displayStudent();
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
    } // MAIN METHOD 

    public static void mainMenu() {
        System.out.println("SEMESTER WISE TIMETABLE");
        System.out.println("");
    }

    private static void assignProfessorToSections() {
        System.out.println(semesters.size());
        for (Semester semester : semesters) {
            ArrayList<Section> sec = semester.getSections();
            System.out.println(sec.size());
            int semNo = semester.getNo();
            for (Section section : sec) {
                int profId;
                ArrayList<Course> courses = section.getCourses();
                System.out.println(courses.size());
                for (Course crs : courses) {
//                    System.out.println("Semester: " + semNo + "\tSection: " + section.getNo() + "\tCourse: " + crs.getTitle());
//                    System.out.print("Enter Professor ID for above course: ");
//                    profId = in.nextInt();
                    profId = (int) (1 + Math.random() * 26);
//                    System.out.println("Professor_ID    "+profId);
                    ProfessorUtility.assignProfToSection(semester, section, crs.getTitle(), profId);
//                    section.setAllocations(crs.getTitle(), profId);
                }
            }
        }
    }

    public static void insertingData() {
        ArrayList<Course> course_temp = new ArrayList<>();
        for (int i = 0; i < semesters.size(); i++) {
//            for(int k = 0 ; k <   ; k++ ) 
            {

            }
            for (int j = 0; j < (int) (5 + Math.random() * 6); j++) {
                course_temp.add(new Course((j + 1) + "", course_name[j], 4, true));
            }
        }
    }
    static String day_name[] = {"Mon", "Tues", "Wed", "Thurs", "Fri", "Sat", "Sun"};
    static String slots_timing[] = {"08:30AM-10:00AM", "10:00AM-11:30AM", "11:30AM-01:00PM", "01:00PM-02:30PM", "2:30PM-04:00PM", "04:00PM-05:30PM"};

    public static void slotting(int room, int day, int slot) {
        for (int r = 0; r < room; r++) {
            Room rm = new Room();
            rm.setName("10 " + (r + 1));
            rm.setCheck(false);
            for (int d = 0; d < day; d++) {
                Day d1 = new Day();
                d1.no = d;
                for (int i = 0; i < slot; i++) {
                    TimeSlot st = new TimeSlot();
                    st.setCheck(false);
                    st.setNo(i);
                    slots.add(st);
                }

                ArrayList<TimeSlot> newarray1 = new ArrayList<>();
                newarray1.addAll(slots);
                slots.clear();
                d1.timeslots = newarray1;
                days.add(d1);
            }
            ArrayList<Day> newarray2 = new ArrayList<>();
            newarray2.addAll(days);
            days.clear();
            rm.setDays(newarray2);
            rooms.add(rm);
        }
    }

//    public static void inputting() {
//        ArrayList<Section> secs = new ArrayList<>() ; 
//
//        int sem = 0, num_sections = 0 ;
//        String name;
//        int counter = 0;
//        int num_of_courses;
//        System.out.print("Enter Title of Program  :   ");
//        name = in.next();
//        System.out.print("Enter Number of semesters   :   ");
//        sem = in.nextInt();
//        for (int p = 0; p < sem; p++) {
//            System.out.println("Enter  " + (p + 1) + " Semester Details  :  ");
//            System.out.print("Enter number of sections in this Semester  :   ");
//            num_sections = in.nextInt();
//
//            System.out.print("Number of Courses in Semester  :  ");
//            num_of_courses = in.nextInt();
//            
//            Semester smstr = new Semester();
//            smstr.no = p + 1;
//            for (int k = 0; k < num_sections; k++) {
//                Section sec = new Section("" + (k + 1));
//                secs.add(sec);
//            }
//            ArrayList<Section> newarray1 = new ArrayList<>();
//            newarray1.addAll(secs);
//            secs.clear() ; 
//            smstr.sections = newarray1 ; 
//            for (int m = 0; m < num_of_courses; m++) {
//                course.add(new Course(Integer.toString((m + 1)), course_name[counter], Integer.toString(4), true)) ; 
//                counter++ ; 
//                if (counter == course_name.length) { 
//                    counter = 0 ; 
//                } 
//            } 
//            ArrayList<Course> newarray2 = new ArrayList<>() ; 
//            newarray2.addAll(course) ; 
//            course.clear() ; 
//            smstr.sections.get(sem).courses = newarray2 ; 
//            semesters.add(smstr) ; 
//        }
//        System.out.println("");
//    }
    public static void inputForRooms_Labs() {
        System.out.print("Enter number of rooms in department  :  ");
        int input1 = in.nextInt();

//        System.out.println("Enter No. of labs  :   ") ; 
//        int input2 = in.nextInt() ; 
        System.out.print("Enter number of working days  ( < 7 ) :   ");
        int input3 = in.nextInt();

        System.out.print("Enter number of Timeslots in each day   :   ");
        int input4 = in.nextInt();
        slotting(input1, input3, input4);

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

            course.add(new Course(Integer.toString(n + 1), "Course " + (n + 1), 4, false));
            n++;
        }
//        checkingLab() ; 
        printCourse();
//        algorithm() ; 
    }

    static boolean[][] checks = new boolean[6][6];

    public static void input_Validation_Method() {
        int var2 = rooms.size();
        int var1 = rooms.get(0).getDays().size();
        int var3 = rooms.get(0).getDays().get(0).timeslots.size();            //timeslots     

        int total_slots = var1 * var2 * var3;

        int lectures = 0;
        int num1 = 0, num2, num3 = 0;
        for (int i = 0; i < semesters.size(); i++) {
//            num1 = semesters.get(i).courses.size() ; 
            num2 = semesters.get(i).getSections().size();
            num3 += num1 * num2;
        }
        System.out.println("I am Number 03          " + num3);
        lectures = num3 * 2;
        System.out.println("I am Number 03          " + lectures);
//        int diff = semesters
        int difference = total_slots - lectures;
        System.out.println("I am Differenece 02          " + difference);

        if (difference > 0) {
            System.out.println("ALL OK, SET TO GO FOR TIMETABLE \n\n\n");
        } else if (difference < 0) {
            System.out.println("ROOMS AND TIMESLOTS ARE LESS AND LECTURES ARE GREATER IN NUMBER , ");
        }
    }

    static ArrayList<String> Labs = new ArrayList<>();

    public static void algorithm() {

        boolean check1 = false;
        boolean check2 = false;

        int i = 0, j = 0, k = 0, l = 0, m = 0, n = 0, o = 0, r = 0, c = 0;
        c = rooms.size();
        String course_name, day_name = "";
        int var = 0, slot = 0;

        for (int sem = 0; sem < semesters.size(); sem++) {                // algo starts here  

            if (sem >= 4) {    // for first 4 semesters lecture will be in first 4 slots, for last 4 it will be at last 4 slots
                j = 2;
            } else {
                j = 0;
            }
            for (k = 0; k < semesters.get(sem).getSections().size(); k++) {
                Room rm = rooms.get(var);
                var++;
                if (var == c) {
                    var = 0;
                };
                for (o = 0; o < 2; o++) {// for credit hours/timeslots = 2

                    for (int a = 0; a < semesters.get(sem).getSections().get(k).getCourses().size(); a++) {
                        if (sem >= 4) {
                            l = j;
                        } else {
                            l = 0;
                        }
                        for (l = j; l < rm.getDays().get(0).getTimeslots().size(); l++) {

                            for (r = 0; r < rm.getDays().size(); r++) {

                                if (rm.getDays().get(r).getTimeslots().get(l).isCheck() == false) {
                                    day_name = WeekDays.names[r];

                                    rm.getDays().get(r).getTimeslots().get(l).setCheck(true);

                                    course_name = semesters.get(sem).getSections().get(k).getCourses().get(a).getTitle();

                                    scheduler.add(new Scheduler(rm.getName(), semesters.get(sem).getNo(), "" + (semesters.get(sem).getSections().get(k).getNo()),
                                            rm.getDays().get(r).no, rm.getDays().get(r).getTimeslots().get(l).getNo(), course_name, o + 1));

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
                    permute(semesters.get(sem).getSections().get(k).getCourses());

                }
//                    System.out.println("Section "+ (k+1)+"  TimeTable" ) ; 
            }
        }
    }

    public static void arrayCleaning() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = null;
                checks[i][j] = false;
            }
        }
    }

//    public static int Highest_CreditHours() {
//        int value = 0;
//        for (int i = 0; i < course.size(); i++) {
//            if (course.get(i).credit_hours > value) {
//                value = course.get(i).credit_hours;
//            }
//        }
//        return value;
//    }
    public static void roomChecking() {
    }

    public static void isRoomFull() {

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

    public static void displayInfo(int sem, String sec) {
        System.out.println("Schedule for:\nSemester: " + sem + "\nSection: " + sec);
        System.out.println("\n");
        for (Scheduler s : scheduler) {
            if (s.section.equalsIgnoreCase(sec) && s.semester_no == sem) {
                System.out.println(s.toString());
            }
        }
    }

//    public static void displaySlots() {
//        for (int i = 0; i < rooms.size(); i++) {
//            for (int j = 0; j < rooms.get(i).days.size(); j++) {
//                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//                System.out.println("Day: " + rooms.get(i).days.get(i).name);
//                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
//                for (int k = 0; k < rooms.get(i).days.get(j).timeslots.size(); k++) {
//                    System.out.print(rooms.get(i).days.get(j).timeslots.get(k).toString() + "\t");
//                }
//                System.out.println("");
//            }
//        }
//    }
    public static Room checkingFreeRoom(ArrayList<Room> rooms) {
        Room rm = null;
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).isCheck() == false) {
                rm = rooms.get(i);
                break;
            }
        }
        return rm;
    }

//    public static void displayRoom() { 
//        String[][] array =new String [6][7] ; 
//        String var="";
//        for( int i = 0 ; i < rooms.size() ; i++ ) 
//        { 
//            System.out.println("\n\t\t"+rooms.get(i).name+"\n" ) ; 
//            for(String day : day_name ) { 
//                System.out.print( day+"\t") ; 
//            }
//            System.out.println("");
////                System.out.print(rooms.get(i).days.get(j).name+ "\t" ) ; 
//                    for(int j = 0 ; j < rooms.get(i).days.size(); j++ ) { 
//
//                        for(int k = 0 ; k < rooms.get(i).days.get(0).timeslots.size(); k++ ){ 
//
//                    if( rooms.get(i).days.get(j).timeslots.get(k).check == false ) { 
//                        var = "__" ; 
//                    } 
//                    else{ 
//                        var = "Lecture" ; 
//                    } 
//                    array[k][j] = var;
////                    System.out.println( var+"\t" ) ; 
//                }
//                    }
//        for(int a = 0 ; a< array.length ; a++){
//          for(int b = 0 ; b < array[0].length ; b++){
//            System.out.print(array[a][b] + "\t") ; 
//        }
//        System.out.println("") ; 
//        } 
//            System.out.println("\n\n") ; 
//        }
//    } 
}   // main class 

