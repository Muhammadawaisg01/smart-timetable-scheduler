package Controller;

import static db.DBConnection.getConnection;
import Model.Course;
import Model.CourseUtility;
import Model.Student;
import Model.Section;
import Model.Semester;
import Model.Room_Day;
import Model.Entities_Main_Arrays;
import Model.Room_Timeslot;
import Model.Room;
import Model.SectionUtility;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.sql.Connection;
import static db.DBConnection.createConnection;

public class Runner {

    public static ArrayList<Room> rooms = Entities_Main_Arrays.rooms;
    static ArrayList<Room> labs = new ArrayList<>();
    static Scanner in = new Scanner(System.in);
    static String[][] array = new String[6][6];
    public static ArrayList<Course> course = new ArrayList<>();
    static int sections = 0;
    public static ArrayList<Room_Day> days = new ArrayList<>();

    static ArrayList<Room_Timeslot> slots = new ArrayList<>();
    public static ArrayList<Scheduler> scheduler = new ArrayList<>();  //public

    public static ArrayList<Semester> semesters;

    public static void main(String[] args) {                                    // MAIN METHOD  
        createConnection(); // creating connection with database    
        Entities_Main_Arrays.add_Data_to_Student_List();
        Entities_Main_Arrays.add_Data_to_Semester_List();
        semesters = Entities_Main_Arrays.semesters;
        clash_resolving.Student student = new clash_resolving.Student();
//        System.out.println(Entities_Main_Arrays.student_list.size() ) ; 
//        System.out.println(Entities_Main_Arrays.student_list.get(0).toString());
//        System.exit(0); 

        course = CourseUtility.readCourseFile();
        System.out.println(course.size() + "\tSize of courses");
//        Section_Schedule obj1 = new Section_Schedule();   

        Entities_Main_Arrays.add_Data_to_Professor_List();

//        System.out.println(semesters.size());
//        for (Semester semester : semesters) {
//            System.out.println(semester.getSections().size() + "\t number of section");
//            for (Section section : semester.getSections()) {
//                System.out.println(section.getCourses().size());
//            }
//        }
//        System.out.println(course.size() + "\tSize of courses");
//        System.exit(0);
        inputForRooms_Labs(); // First Work  
        is_all_slots_available_for_slotting();          // ask user if he want to close any timeslot for lecture scheduling     
        System.out.println(is_scheduling_possible());
        main_algorithm();
        System.out.println("Scheduler        SIze      " + scheduler.size());
        for (Scheduler sch : scheduler) {
            System.out.println(sch.toString());
        }
        assignProfessorToSections();
        SectionUtility.assign_schedule_to_section();
        Algo_for_Professor_assigning.section_to_Professor_Scheduling();
        Algo_For_Student_Assigning.assign_Data_from_Section_to_Student_Schedule();
        student.handleStudentClashes();
//        student.handleStudentClashes(2);
//        System.out.println("\n\n\n\n\n\n\n\n\n\n");
//        Algo_For_Student_Assigning.assign_Data_from_Section_to_Student_Schedule();
//        for (Student std : Entities_Main_Arrays.student_list) {
//            std.display_Student();
//        }
//        student.handleStudentClashes(2);
//        for (Student std : Entities_Main_Arrays.student_list) {
//            std.display_Student();
//        }
//        for (Professor prof : Entities_Main_Arrays.professor_list) {
//            prof.display_Professor();
//        }
//        System.out.println("I am the number of CLASHES VARIABLE\t\t" + Algo_for_Professor_assigning.clashes_variable);
//        Algo_for_Professor_assigning.clashes_variable = 0;
//        ProfessorClashes.resolveClashes();
//        System.out.println("_____________________________________________________________________________");
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
//        System.out.println("_____________________________________________________________________________");
//        Semester.displayAllData();
//        for (Professor prof : Entities_Main_Arrays.professor_list) {
//            prof.display_Professor();
//        }
//        System.out.println("I am the number of CLASHES VARIABLE\t\t" + Algo_for_Professor_assigning.clashes_variable);
//        System.out.println("Clashes Resolved: " + clashesResolved);
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
//        Section.calFittness();
    } // MAIN METHOD 

    public static void mainMenu() {
        System.out.println("SEMESTER WISE TIMETABLE");
        System.out.println("");
    }

    public static void assignProfessorToSections() {
        File file = new File("Semesters.txt");
//        semesters = Semester.getSemesters(file);
        Connection conn = getConnection();
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
//                    profId = (int) (1 + Math.random() * 26);
//                    System.out.println("Professor_ID    "+profId);
//                    String q = "insert into section_professor_allocation "
//                            + "VALUES "
//                            + "(?, ?, ?)";
//                    PreparedStatement stmt;
//                    try {
//                        stmt = conn.prepareStatement(q);
//                        stmt.setString(1, semNo + "" + section.getNo());
//                        stmt.setString(2, crs.getTitle());
//                        stmt.setInt(3, profId);
//                        stmt.execute();
//
//                    } catch (SQLException ex) {
//                        Logger.getLogger(Runner.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                    ProfessorUtility.assignProfToSection(semester, section, crs.getTitle(), profId);
//                    section.setAllocations(crs.getTitle(), profId);
                }
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
                Room_Day d1 = new Room_Day();
                d1.no = d;
                for (int i = 0; i < slot; i++) {
                    Room_Timeslot st = new Room_Timeslot();
                    st.setCheck(false);
                    st.setNo(i);
                    slots.add(st);
                }

                ArrayList<Room_Timeslot> newarray1 = new ArrayList<>();
                newarray1.addAll(slots);
                slots.clear();
                d1.timeslots = newarray1;
                days.add(d1);
            }
            ArrayList<Room_Day> newarray2 = new ArrayList<>();
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
//        algorithm() ; 
    }

//    public static void fittness_function()  {   
//        //      
//    }   
    public static void main_algorithm() {       // scheduling algorithm         

        boolean check1 = false;
//        boolean check2 = false ;

        int i = 0, j = 0, k = 0, m = 0, n = 0, o = 0, r = 0, c = 0, sec = 0;
        c = rooms.size();
        String course_name, day_name = "";
        int var = 0, slot_no = 0, day_value = 0, day_no = 0;
        // for multi programs another loop will be created above semesters loop
        for (int sem = 0; sem < semesters.size(); sem++) {                // algo starts here     
            if (sem >= 4) {    // for first 4 semesters lecture will be in first 4 slots, for last 4 it will be at last 4 slots
                j = 2;
            } else {
                j = 0;
            }

            for (sec = 0; sec < semesters.get(sem).getSections().size(); sec++) {
                // check here the room size at (var) position
                // check here the section size
                // then compare them both
                // implement an sql query for above comparisons 

                Room rm = rooms.get(var);
                var++;
                if (var == rooms.size()) {
                    var = 0;
                }

                for (o = 0; o < 2; o++) {// for credit hours/timeslots = 2      
                    Section section = semesters.get(sem).getSections().get(sec);

                    for (int a = 0; a < section.getCourses().size(); a++) {

//                        Room rm = Room.getRoom(rooms , section , sem+1) ; 
//                        Room_Day day = Room.get_Day() ;   
//                        Room_Timeslot slot = Room.get_Timeslot() ;    
                        for (slot_no = j; slot_no < rm.getDays().get(0).getTimeslots().size(); slot_no++) {

                            for (day_no = 0; day_no < rm.getDays().size(); day_no++) {
                                if (rm.getDays().get(day_no).getTimeslots().get(slot_no).isCheck() == false) {
//                                    day_name = WeekDays.names[day_no];   

                                    rm.getDays().get(day_no).getTimeslots().get(slot_no).setCheck(true);

                                    course_name = semesters.get(sem).getSections().get(sec).getCourses().get(a).getTitle();
                                    System.out.println("main alog");
                                    scheduler.add(new Scheduler(rm.getName(), semesters.get(sem).getNo(),
                                            "" + (semesters.get(sem).getSections().get(sec).getId()),
                                            rm.getDays().get(day_no).getNo(), rm.getDays().get(day_no).getTimeslots().get(slot_no).getNo(), course_name, o + 1));

                                    check1 = true;
                                    break;
                                }
                            }
                            if (check1) {
                                check1 = false;
                                break;
                            }
                        }
                        permute(semesters.get(sem).getSections().get(sec).getCourses());
                    } //slot=0 ; 
                }
//                    System.out.println("Section "+ (k+1)+"  TimeTable" ) ; 
            }
        }
    }

    public static void arrayCleaning() {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = null;
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

//    public static void addingStudent() {
//        String query1 = " select * from scheduler01 ";
//        int id = 0;
//        String name = "";
//        double marks = 0;
//        try {
//            System.out.println("hello-00");
//            PreparedStatement stmt1 = getConnection().prepareStatement(query1);
//            System.out.println("hello1");
//            ResultSet rs = stmt1.executeQuery();
//            System.out.println("hello2");
//            while (rs.next()) {
//                System.out.println(rs.getInt(1) + "   " + rs.getString(2));
////                id = rs.getInt(1) ; 
////                name = rs.getString(2); 
////                marks= rs.getDouble(3); 
////                students.add(new Student(id,name,marks) ) ; 
//            }
//            for (int i = 0; i < students.size(); i++) {
//                System.out.println(students.get(i).toString());
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Error in Fetching data from Students Table", "Student Table", JOptionPane.ERROR_MESSAGE);
//        }
//    }
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
//                System.out.println("Room_Day: " + rooms.get(i).days.get(i).name);
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
    public static boolean is_scheduling_possible() {
        int lectures_capacity = 0;
        int lectures_rooms = 0;
        int labs = 0;

        for (Room rm : rooms) {
            if (rm.isIsLab()) {
                labs++;
            }
        }
        for (Room rm : rooms) {
            if (!rm.isIsLab()) {
                lectures_rooms++;
            }
        }

        for (int i = 0; i < rooms.size(); i++) {
            for (int j = 0; j < rooms.get(i).getDays().size(); j++) {
                for (int k = 0; k < rooms.get(i).getDays().get(j).getTimeslots().size(); k++) {
                    Room_Timeslot slot = rooms.get(i).getDays().get(j).getTimeslots().get(k);
                    if (!slot.isCheck()) {
                        lectures_capacity++;
                    }
                }
            }
        }

//    int days = rooms.get(0).getDays().size();
//    int timeslots = rooms.get(0).getDays().get(0).getTimeslots().size() ;       
//    lectures_capacity = lectures_rooms * days * timeslots ;         // for theory lectures  
        System.out.println("slots available are\t\t" + lectures_capacity);
        int course_lectures = 0;

        int course_num = 0;
        for (Semester sem : semesters) {
            for (Section sec : sem.getSections()) {
                for (Course crs : sec.getCourses()) {
                    course_num++;
                }
            }
        }

        course_lectures = course_num * 2;
        System.out.println("lectures  are  \t\t" + course_lectures);
        int difference = lectures_capacity - course_lectures;
        System.out.println("diff is  \t\t" + difference);

        if (difference >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void is_all_slots_available_for_slotting() {
// ask admin that if he want any timeslot to be closed for scheduling in all rooms or not
        int day_no, slot_no;
        System.out.print("All slots in all day are available for lecture scheduling  (0/1)   :   ");
        int input1 = in.nextInt();
        if (input1 == 0) {
            System.out.print("Enter day no    :   ");
            day_no = in.nextInt();
            System.out.print("Enter timeslot_no    :   ");
            slot_no = in.nextInt();
            for (Room rm : rooms) {
                rm.getDays().get(day_no - 1).getTimeslots().get(slot_no - 1).setCheck(true);
            }
        } else if (input1 == 1) {
            System.out.println("All Slots will be picked up for scheduling...");
        }

    }

    public static void m1() {

    }

}   // main class 

