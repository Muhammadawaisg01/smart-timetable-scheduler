/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.datesheet_generation;

import java.awt.Color;

/**
 *
 * @author Muhammad Awais
 */
public class title_panel extends javax.swing.JPanel {

    /**
     * Creates new form title_panel
     */
    public title_panel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        next = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jLabel102 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(50, 50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        title.setBackground(new java.awt.Color(50, 50, 50));
        title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        title.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });
        add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 660, 40));

        jLabel102.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel102.setText("E x a m i n a t i o n   T i t l e");
        add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 700, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        main_panel.title_panel1.setVisible(false);        
        main_panel.first_panel1.setVisible(true); 
    }//GEN-LAST:event_nextMouseClicked

    private void nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseEntered
        next.setBackground(new Color(0, 102, 153));
        next.setForeground(new Color(250, 250, 250));
    }//GEN-LAST:event_nextMouseEntered

    private void nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseExited
        next.setBackground(new Color(250, 250, 250));
        next.setForeground(new Color(0, 102, 153));
    }//GEN-LAST:event_nextMouseExited

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel102;
    public static javax.swing.JLabel next;
    public static javax.swing.JTextField title;
    // End of variables declaration//GEN-END:variables
}
