package db;

public class Queries_Design {

    public static String sectionSchedule(String sectionID, int slot) {
        String query = "SELECT course_code FROM section_schedule join day using (day_no) join timeslot using (timeslot_no)\n"
                + "where \n"
                + "section_id = '" + sectionID + "' and\n"
                + "timeslot_no = " + slot;
        return query;
    }
}
