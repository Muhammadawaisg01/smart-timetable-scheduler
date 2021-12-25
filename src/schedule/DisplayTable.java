package schedule;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayTable {

    static JFrame frame = new JFrame("Schedule");
    DisplayTemplate panel;

    public void DisplayOneTable(String sectionID) {
        panel.displayOneSection(sectionID);
    }
    public void DisplayFullTable() {
        panel.displayAllSection();
    }

    public DisplayTable() {
        panel = new DisplayTemplate();
        frame.getContentPane();
        frame.add(panel.getPanel());
        frame.setSize(1100, 700);
    }
    public void showPanel(JPanel panel) {
        frame.add(panel);
        frame.setVisible(true);
    }
    
    public JFrame getFrame() {
        return frame;
    }
    
}
