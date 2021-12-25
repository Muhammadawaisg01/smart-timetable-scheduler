package View.student;

public class update_section extends javax.swing.JPanel {

    public update_section() {
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

        jLabel108 = new javax.swing.JLabel();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        update_section_for_extra_courses1 = new View.student.update_section_for_extra_courses();
        update_regular_section1 = new View.student.update_regular_section();

        setBackground(new java.awt.Color(50, 50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setText("U p d a t e  S e c t i o n");
        add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 230, 40));

        jRadioButton2.setBackground(new java.awt.Color(50, 50, 50));
        jRadioButton2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(0, 102, 153));
        jRadioButton2.setText("Change Regular Section");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 40));

        jRadioButton1.setBackground(new java.awt.Color(50, 50, 50));
        jRadioButton1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(0, 102, 153));
        jRadioButton1.setText("Change Section For Extra Courses");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, -1, 40));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.CardLayout());
        jPanel3.add(update_section_for_extra_courses1, "card3");
        jPanel3.add(update_regular_section1, "card2");

        jScrollPane2.setViewportView(jPanel3);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 730, 520));
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if (jRadioButton1.isSelected()) {
            jRadioButton2.setSelected(false);
            update_section_for_extra_courses1.setVisible(true);
            update_regular_section1.setVisible(false);

        }

    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if (jRadioButton2.isSelected()) {
            jRadioButton1.setSelected(false);
            update_regular_section1.setVisible(true);
            update_section_for_extra_courses1.setVisible(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel108;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane2;
    private View.student.update_regular_section update_regular_section1;
    private View.student.update_section_for_extra_courses update_section_for_extra_courses1;
    // End of variables declaration//GEN-END:variables
}
