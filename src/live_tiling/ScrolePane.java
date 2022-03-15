package live_tiling;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
public class ScrolePane extends JFrame {
   public ScrolePane() {
      setTitle("JScrollablePanel Test");
      setLayout(new BorderLayout());
      ResultSet rs = util.getSchedule();
      JPanel panel = createPanel();
      add(BorderLayout.CENTER, new JScrollPane(panel));
      setSize(300, 200);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }
   public static JPanel createPanel() {
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(10, 4, 10, 10));
      for (int i=0; i < 10; i++) {
         for (int j=0; j < 4; j++) {
            JLabel label = new JLabel("label " + i + ", " + j);
            label.setFont(new Font("Arial", Font.PLAIN, 20));
            panel.add(label);
         }
      }
      return panel;
   }
   public static void main(String [] args) {
      new ScrolePane();
   }
}