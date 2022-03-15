package live_tiling;

import static Enums.ConstQuerries.GET_PROFESSOR_ALLOCATION;
import static Model.Queries.getCourseCode;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static live_tiling.util.getProfessorName;

public class DisplayUIPanel {

    private static final int BOX_WIDTH = 250;
    private static final int BOX_HEIGHT = 250;
    private static final int Y_GAP = 300;
    private static final int X_GAP = 300;

    public static JPanel getUIPanel(int width, int height, ResultSet schedule) {
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, width, height);
        panel.setBackground(Color.DARK_GRAY);
        panel.setLayout(new GridLayout(2, 4, 20, 20));
        int x = 20, y = 50;
        int i = 1;
        String course, section_id, courseCode, professor;
        try {
            while (schedule.next()) {
                JPanel p1 = new JPanel();
//                p1.setBounds(x, y, BOX_WIDTH, BOX_HEIGHT);
                p1.setBackground(Color.GRAY);
                p1.setLayout(null);
                JLabel roomName = new JLabel();
                roomName.setFont(new Font("Verdana", Font.BOLD, 18));
                roomName.setText(schedule.getString("room_name"));
                roomName.setForeground(Color.WHITE);
                roomName.setBounds(20, 10, 200, 50);
                JLabel courseName = new JLabel();
                courseName.setFont(new Font("Verdana", Font.BOLD, 18));
                courseName.setForeground(Color.WHITE);
                course = schedule.getString("course_code");
                courseName.setText(course.replaceAll("  LECTURE", ""));
                courseCode = getCourseCode(course.replaceAll("  LECTURE", "")); // get course code with course name
                courseName.setBounds(20, 70, 200, 50);
                JLabel sectionID = new JLabel();
                sectionID.setFont(new Font("Verdana", Font.BOLD, 18));
                sectionID.setForeground(Color.WHITE);
                section_id = schedule.getString("section_id");
                sectionID.setText(section_id);
                sectionID.setBounds(20, 130, 200, 50);
                professor = getProfessorName(courseCode, section_id);
                JLabel professorName = new JLabel();
                professorName.setForeground(Color.WHITE);
                professorName.setFont(new Font("Verdana", Font.BOLD, 18));
                professorName.setText(professor);
                professorName.setBounds(20, 190, 200, 50);
                p1.add(roomName);
                p1.add(courseName);
                p1.add(sectionID);
                p1.add(professorName);
                panel.add(p1);
//                if (i % 4 == 0) {
//                    y += Y_GAP;
//                    x = 20;
//                } else {
//                    x += X_GAP;
//                }
//                i++;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayUIPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return panel;
    }
}
