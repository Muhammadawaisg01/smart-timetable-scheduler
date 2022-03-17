package live_tiling;

import static Model.Queries.getCourseCode;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import static live_tiling.util.getProfessorName;

public class ScrolePane extends JFrame {

    private static final int BOX_WIDTH = 250;
    private static final int BOX_HEIGHT = 250;

    public ScrolePane() {
        setTitle("Live Classes");
        setLayout(new BorderLayout());

        ResultSet rs = util.getSchedule();
        JPanel panel = createPanel(rs);
        add(BorderLayout.CENTER, new JScrollPane(panel));
        setSize(1250, 700);
        panel.setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JPanel createPanel(ResultSet schedule) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 4, 10, 10));
        JLabel heading = new JLabel("   Live Classes");
        heading.setForeground(new Color(150, 150, 250));
        heading.setFont(new Font("Times New Roman", Font.BOLD, 60));
        panel.add(heading);
        JLabel empty0 = new JLabel("");
        panel.add(empty0);
        String course, section_id, courseCode = "", professor;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    schedule.next();
                    JPanel p1 = new JPanel();
//                    p1.setBounds(x, y, BOX_WIDTH, BOX_HEIGHT);
                    p1.setBackground(Color.GRAY);
//                    p1.setBorder(new EmptyBorder(10, 10, 10, 10));
//                    p1.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
                    p1.setLayout(new GridLayout(4, 1, 10, 10));
                    JLabel roomName = new JLabel();
                    roomName.setFont(new Font("Verdana", Font.BOLD, 18));
                    roomName.setText("     " + schedule.getString("room_name"));
                    roomName.setForeground(Color.WHITE);
//                    roomName.setBounds(20, 10, 200, 50);
                    JLabel courseName = new JLabel();
                    courseName.setFont(new Font("Verdana", Font.BOLD, 18));
                    courseName.setForeground(Color.WHITE);
                    course = schedule.getString("course_code");
                    if (course.contains("LECTURE")) {
                        courseName.setText(course.replaceAll("  LECTURE", ""));
                        courseCode = getCourseCode(course.replaceAll("  LECTURE", "")); // get course code with course name
                    } else if (course.contains("LAB")) {
                        System.out.println(course);
                        courseName.setText(course.replaceAll(" LAB", ""));
                        courseCode = getCourseCode(course.replaceAll(" LAB", "")); // get course code with course name
                    }
//                    courseName.setBounds(20, 70, 200, 50);
                    JLabel sectionID = new JLabel();
                    sectionID.setFont(new Font("Verdana", Font.BOLD, 18));
                    sectionID.setForeground(Color.WHITE);
                    section_id = schedule.getString("section_id");
                    sectionID.setText("     " + section_id);
//                    sectionID.setBounds(20, 130, 200, 50);
                    professor = getProfessorName(courseCode, section_id);
                    JLabel professorName = new JLabel();
                    professorName.setForeground(Color.WHITE);
                    professorName.setFont(new Font("Verdana", Font.BOLD, 18));
                    professorName.setText(professor);
//                    professorName.setBounds(20, 190, 200, 50);
                    JLabel empty = new JLabel("");
                    p1.add(empty);
                    JLabel empty3 = new JLabel("");
                    p1.add(empty3);
                    p1.add(roomName);
                    p1.add(courseName);
                    p1.add(sectionID);
                    p1.add(professorName);
                    JLabel empty1 = new JLabel("");
                    p1.add(empty1);
                    panel.add(p1);
//             JPanel tempPanel = new JPanel();
//             tempPanel.setBackground(Color.red);
//             tempPanel.setBounds(X, Y, 100, 100);
////            JLabel label = new JLabel("label " + i + ", " + j);
////            label.setFont(new Font("Arial", Font.PLAIN, 20));
//            panel.add(tempPanel);
//            X += 120;
                } catch (SQLException ex) {
//                    System.out.println("END........................");
//                    Logger.getLogger(ScrolePane.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return panel;
    }

    public static void main(String[] args) {
        new ScrolePane();
    }
}
