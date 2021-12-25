package schedule;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class CustomTemplate {

    static String[] days = {"Monday", "Tuesday", "Wedenssday", "Thrusday", "Friday", "Satuerday"};
    static String[] slots = {"08:30-10:00", "08:30-10:00", "08:30-10:00", "08:30-10:00", "08:30-10:00", "08:30-10:00"};
    static JFrame frame = new JFrame("Schedule");

    public static void main(String[] args) {
        show(days, slots);
    }

    public static void show(String[] days, String[] slots) {
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        frame.getContentPane();
        JLabel HR = new JLabel("___________________________________________________________________________________________________________");
        JLabel HR2 = new JLabel("___________________________________________________________________________________________________________");
        JLabel header = new JLabel("BSCS-1A");
        Dimension headerSize = header.getPreferredSize();
        header.setBounds(10, 30, headerSize.width, headerSize.height);
        Dimension HRSize = HR.getPreferredSize();
        HR.setBounds(120, 50, HRSize.width, HRSize.height);
        Dimension HR2Size = HR.getPreferredSize();
        HR2.setBounds(120, 80, HR2Size.width, HR2Size.height);
        panel.add(header);
        panel.add(HR);
        panel.add(HR2);
        // print days
        int dayX = 130, dayY = 70;
        for (String day : days) {
            JLabel l = new JLabel(day);
            l.setBounds(dayX, dayY, 100, 20);
            panel.add(l);
            dayX += 130;
        }
        dayX = 10;
        dayY = 130;
        for (String slot : slots) {
            JLabel l = new JLabel(slot);
            l.setBounds(dayX, dayY, 100, 20);
            for (int i = 0; i < 6; i++) {
                JLabel courseTitle = new JLabel("Course Name");
//                courseTitle.setBounds(dayX + );
            }
            dayY += 40;
            JLabel HRAboveRoom = new JLabel("________________________________________________________________________________________________________________________");
            JLabel HRBelowRoom = new JLabel("________________________________________________________________________________________________________________________");
            Dimension HRAboveRoomSize = HRAboveRoom.getPreferredSize();
            HRAboveRoom.setBounds(dayX, dayY - 20, HRAboveRoomSize.width, HRAboveRoomSize.height);
            Dimension HRBelowRoomSize = HR.getPreferredSize();
            HRBelowRoom.setBounds(dayX, dayY + 10, HRAboveRoomSize.width, HRAboveRoomSize.height);
            JLabel room = new JLabel("Room #");
            room.setBounds(dayX, dayY, 100, 20);
            panel.add(l);
            panel.add(room);
            panel.add(HRAboveRoom);
            panel.add(HRBelowRoom);
            dayY += 40;
        }

        ///////////////////////////////////////
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(900, 700);
        frame.setVisible(true);
        try {
            Printer.print(panel);
        } catch (PrinterException ex) {
            Logger.getLogger(CustomTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
