/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.room;

/**
 *
 * @author muhammad awais 1
 */
public class room_input_panel extends javax.swing.JPanel {

    /**
     * Creates new form room_input_panel
     */
    public room_input_panel() {
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

        jLabel106 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        capacity = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        labcheckBox1 = new javax.swing.JCheckBox();
        jLabel60 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        roomname = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        labcheckBox3 = new javax.swing.JCheckBox();
        jButton8 = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel97 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jButton10 = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        labcheckBox6 = new javax.swing.JCheckBox();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1000, 2147483647));
        setMinimumSize(new java.awt.Dimension(760, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 102, 153));
        jLabel106.setText("Inputs for Room");
        add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 26, 210, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 102, 153));
        jLabel96.setText("Room name:");
        jPanel1.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 210, 30));

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 102, 153));
        jLabel94.setText("Room capacity:");
        jPanel1.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 210, 30));

        capacity.setForeground(new java.awt.Color(0, 102, 153));
        jPanel1.add(capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 360, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 770, -1));

        labcheckBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox1.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox1.setText("available for all courses");
        jPanel1.add(labcheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 390, 200, 30));

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 102, 153));
        jLabel60.setText("Room specification for course:");
        jPanel1.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 320, -1));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 102, 153));
        jLabel95.setText("NO need of this  section specification constraint");
        jPanel1.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 680, 540, 30));

        roomname.setForeground(new java.awt.Color(0, 102, 153));
        jPanel1.add(roomname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 360, 30));
        jPanel1.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 770, -1));

        labcheckBox3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox3.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox3.setText("Lab");
        jPanel1.add(labcheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 270, 80, 30));

        jButton8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 102, 153));
        jButton8.setText("specify");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 80, 30));
        jPanel1.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 940, 770, 10));

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 102, 153));
        jLabel97.setText("Course:");
        jPanel1.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 160, 30));

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"" }));
        jPanel1.add(jComboBox9, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 270, 380, 30));

        jButton10.setBackground(new java.awt.Color(0, 102, 153));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("next");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 990, 200, 60));

        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 102, 153));
        jLabel61.setText("Specify room for specific section:");
        jPanel1.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 610, 320, -1));

        jRadioButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(0, 102, 153));
        jRadioButton1.setText("Lab");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, 70, -1));

        jRadioButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(0, 102, 153));
        jRadioButton2.setText("Lecture room");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        labcheckBox6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox6.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox6.setText("Lecture");
        jPanel1.add(labcheckBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 270, 120, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 102, 153));
        jTextArea1.setRows(5);
        jTextArea1.setText("Specification results\n");
        jScrollPane3.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 840, 770, 80));

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(0, 102, 153));
        jTextArea2.setRows(5);
        jTextArea2.setText("Specification results\n");
        jScrollPane4.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 770, 80));

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 680, 440));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        if(jRadioButton2.isSelected()){
           jRadioButton1.setSelected(false); 
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton1.isSelected()){
            jRadioButton2.setSelected(false); 
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField capacity;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextArea jTextArea1;
    static javax.swing.JTextArea jTextArea2;
    private javax.swing.JCheckBox labcheckBox1;
    private javax.swing.JCheckBox labcheckBox3;
    private javax.swing.JCheckBox labcheckBox6;
    private javax.swing.JTextField roomname;
    // End of variables declaration//GEN-END:variables
}
