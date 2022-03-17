package pop_ups;

import javax.swing.JFrame;
import View.section.view_section_details_panel;
import java.sql.ResultSet;

public class SectionDetails {

    static JFrame frame;
    view_section_details_panel panel;

    public void show(String sectionID, int strength, ResultSet courses, ResultSet allocations) {
        panel.setSectionID(sectionID);
        panel.setStrength(strength);
        panel.setCoursesTable(courses);
        panel.setAllocationsTable(allocations);
        frame.setVisible(true);
        panel.setVisible(true);
    }

    public void hide() {
        frame.setVisible(false);
        panel.setVisible(false);
    }

    public SectionDetails() {
        frame = new JFrame("Section Details");
        panel = new view_section_details_panel();
        frame.add(panel);
        frame.getContentPane();
        frame.add(panel.getPanel());
        frame.pack();
        frame.setLocation(250, 10);
        frame.setSize(730, 720);
    }

    public JFrame getFrame() {
        return frame;
    }

}
