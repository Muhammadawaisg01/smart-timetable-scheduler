package live_tiling;

import java.sql.ResultSet;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;
import static live_tiling.DisplayUIPanel.getUIPanel;
public class TempRunner {
    public static final int PANEL_WIDTH = 1270;
    public static final int PANEL_HEIGHT = 700;
    TempRunner() {
        JFrame f = new JFrame("Panel Example");
        ResultSet rs = util.getSchedule();
        JPanel displayPane = getUIPanel(PANEL_WIDTH, PANEL_HEIGHT, rs);
        f.add(displayPane);
        f.setSize(PANEL_WIDTH, PANEL_HEIGHT);
        f.setLayout(null);
        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TempRunner();
    }
}
