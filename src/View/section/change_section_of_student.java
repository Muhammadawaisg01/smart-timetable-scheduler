/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.section;

/**
 *
 * @author muhammad awais 1
 */
public class change_section_of_student extends javax.swing.JPanel {

    /**
     * Creates new form change_section
     */
    public change_section_of_student() {
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

        roomname = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roomname.setForeground(new java.awt.Color(0, 102, 153));
        add(roomname, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 380, 40));

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 102, 153));
        jLabel94.setText("Student Registration No:");
        add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 240, 40));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 102, 153));
        jButton8.setText("search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 80, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JTextField roomname;
    private javax.swing.JButton search_btn;
    private javax.swing.JButton search_btn1;
    private javax.swing.JButton search_btn2;
    private javax.swing.JButton search_btn3;
    private javax.swing.JButton search_btn4;
    private javax.swing.JButton search_btn5;
    // End of variables declaration//GEN-END:variables
}
