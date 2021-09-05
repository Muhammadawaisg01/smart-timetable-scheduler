
package scheduler.pkg0 ;

import Model.Room;
import static scheduler.pkg0.Scheduler0.rooms ;
import Model.Semester;
public class algorithm0 {

    public static void algorithm() {                    // algo

        boolean check1 = false;
        boolean check2 = false;

        int i = 0, j = 0, k = 0, l = 0, m = 0, n = 0, o = 0, r = 0, c = 0;
        c = rooms.size();
        String course_name, day_name = "" ;
        int var = 0, slot = 0 ;

        for (int sem = 0; sem < semesters.size(); sem++) {                // algo starts here

            if( sem >= 4 ) {
                j = 2 ;
                }
            else {
                j=0;
            }
            for ( k = 0; k < semesters.get(sem).sections.size(); k++ ) {
                Room rm = rooms.get(var) ;
                var++ ;
                if ( var == c ) {
                    var = 0 ;
                } ;
                for ( o = 0; o < 2; o++) // for credit hours/timeslots = 2
                {

                    for (int a = 0; a < semesters.get(sem).courses.size(); a++) {
                    if( sem >= 4 ) {
                        l = j;
                        } else {
                        l = 0 ;
                    }

                        for (l = j ; l < rm.days.get(0).timeslots.size(); l++) {

                            for (r = 0 ; r < rm.days.size() ; r++) {

                                if (rm.days.get(r).timeslots.get(l).check == false) {
                                    day_name = rm.days.get(r).name ;

                                    rm.days.get(r).timeslots.get(l).check = true ;

                                    course_name = semesters.get(sem).courses.get(a).title;
                                    scheduler.add(new scheduler(rm.name, semesters.get(sem).no , "" + (semesters.get(sem).sections.get(k).no),
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
    public static void methodA()
    {
        for(int i = 0 ; i < rooms.size() ; i++)
        {
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

}