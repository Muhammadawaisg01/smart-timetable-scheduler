package colors;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import javax.swing.JPanel;

public class Gradient extends JPanel {

    public static JPanel getPanel() {
        return new javax.swing.JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                if (g instanceof Graphics2D) {
                    final int R = 28;
                    final int G = 30;
                    final int B = 48;
                    Paint p = new GradientPaint(0.0f, 0.0f, new Color(R, G, B, 0),
                            getWidth(), getHeight(), new Color(85, 93, 98, 255), true);
                    Graphics2D g2d = (Graphics2D) g;
                    g2d.setPaint(p);
                    g2d.fillRect(0, 0, getWidth(), getHeight());
                } else {
                    super.paintComponent(g);
                }
            }
        };
    }
}
