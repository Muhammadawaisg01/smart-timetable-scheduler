
package View.datesheet_generation;

import DarkTable.ScrollBarCustom;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class fourth_panel extends javax.swing.JPanel {
 
    public fourth_panel() {
        initComponents();
        tableDark1.fixTable(jScrollPane2);
    } 
    
    public void fixTable(JScrollPane scroll) { 
        scroll.setVerticalScrollBar(new ScrollBarCustom() ) ; 
        JPanel panel = new JPanel();
        panel.setBackground(new Color(30,30,30) ) ; 
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, panel); 
        scroll.getViewport().setBackground(new Color(30,30,30)); 
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tableDark1 = new DarkTable.TableDark();
        next = new javax.swing.JLabel();
        back = new javax.swing.JLabel();
        jLabel108 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(50, 50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tableDark1.setBackground(new java.awt.Color(50, 50, 50));
        tableDark1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Date", "Day", "Availability"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tableDark1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 550, 300));

        next.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        next.setForeground(new java.awt.Color(0, 102, 153));
        next.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next.setText("N e x t ->");
        next.setToolTipText("Logo");
        next.setAlignmentX(0.5F);
        next.setAutoscrolls(true);
        next.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextMouseExited(evt);
            }
        });
        add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 200, 60));

        back.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        back.setForeground(new java.awt.Color(0, 102, 153));
        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setText("//<- B a c k");
        back.setToolTipText("Logo");
        back.setAlignmentX(0.5F);
        back.setAutoscrolls(true);
        back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 200, 60));

        jLabel108.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setText("select if exams can be conducted in all days");
        add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 570, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        main_panel.fourth_panel1.setVisible(false);
        main_panel.fifth_panel1.setVisible(true);
    }//GEN-LAST:event_nextMouseClicked

    private void nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseEntered
        next.setBackground(new Color(0, 102, 153));
        next.setForeground(new Color(250, 250, 250));
    }//GEN-LAST:event_nextMouseEntered

    private void nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseExited
        next.setBackground(new Color(250, 250, 250));
        next.setForeground(new Color(0, 102, 153));
    }//GEN-LAST:event_nextMouseExited

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        main_panel.fourth_panel1.setVisible(false);
        main_panel.third_panel1.setVisible(true); 

    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        back.setBackground(new Color(0, 102, 153));
        back.setForeground(new Color(250, 250, 250));
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        back.setBackground(new Color(250, 250, 250));
        back.setForeground(new Color(0, 102, 153));
    }//GEN-LAST:event_backMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel back;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel next;
    public static DarkTable.TableDark tableDark1;
    // End of variables declaration//GEN-END:variables
}
