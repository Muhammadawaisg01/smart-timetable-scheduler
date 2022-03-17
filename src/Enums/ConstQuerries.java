package Enums;

public class ConstQuerries {

    public static final String GET_TIMESLOTS = "select * from timeslot";

    public static String GET_LIVE_CLASSES(int day, int timeslot) {
        return "SELECT room_name, course_code, section_id FROM section_schedule join room join day using (day_no) "
                + "where room_name = room.name and\n"
                + "day_no = " + day + " and\n"
                + "timeslot_no = " + timeslot + "";
    }

    public static String GET_PROFESSOR_ALLOCATION(String courseCode, String sectionID) {
        return "SELECT name FROM section_professor_allocation join professor using (professor_id) where course_code = '" + courseCode 
                + "' and section_id = '" + sectionID
                + "'";
    }

}
