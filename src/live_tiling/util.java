package live_tiling;

import Enums.ConstQuerries;
import static Enums.ConstQuerries.GET_PROFESSOR_ALLOCATION;
import static Enums.ConstQuerries.GET_TIMESLOTS;
import Model.Queries;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class util {

    static String currentTime = "02:20:00";
    public static int getCurrentSlot() {
        ResultSet rs = Queries.getRS(GET_TIMESLOTS);
        String start, end;
        int slotNo;
        try {
            while (rs.next()) {
                start = filterTime(rs.getString("starting_time"));
                end = filterTime(rs.getString("ending_time"));
                slotNo = rs.getInt("timeslot_no");
                if (isCurrentSlot(start, end)) {
                    return slotNo;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(util.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        return -1;
    }

    public static String filterTime(String time) {
        return time.substring(0, 5) + ":00";
    }

    public static boolean isCurrentSlot(String startTime, String endTime) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
//        currentTime = dtf.format(now);
        LocalTime target = LocalTime.parse(currentTime);
        System.out.println(target);
        System.out.println(startTime);
        System.out.println(endTime);
        Boolean targetInZone = (target.isAfter(LocalTime.parse(startTime))
                && target.isBefore(LocalTime.parse(endTime)));
        System.out.println(targetInZone);
        return targetInZone;
    }

    public static ResultSet getSchedule() {
        System.out.println(getCurrentSlot());
        String query = ConstQuerries.GET_LIVE_CLASSES(2, 1);
        ResultSet rs = Queries.getRS(query);
        return rs;
    }
    
    public static String getProfessorName(String courseCode, String section_id) {
        String query = GET_PROFESSOR_ALLOCATION(courseCode, section_id);
        ResultSet rs = Queries.getRS(query);
        try {
            if (rs.next()) {
                return rs.getString("name");
            }
        } catch (SQLException ex) {
            Logger.getLogger(util.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return null;
    }
}
