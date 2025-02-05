


package View.schedule_generation;

import Controller.NewAlgorithm;
import static View.MainFrame.first_panel_part21;

public class first_panel extends javax.swing.JPanel {

    /**
     * Creates new form first_panel
     */
    public first_panel() {
        initComponents();
        restricting_jspinner1() ;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        lec = new javax.swing.JSpinner();
        jLabel101 = new javax.swing.JLabel();
        back_lbl_02 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        lab = new javax.swing.JSpinner();
        jLabel103 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 102, 153));
        jLabel99.setText("Number of Timeslots");
        add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 160, 40));

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 102, 153));
        jLabel100.setText("Lab:");
        add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 180, 40));
        add(lec, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 210, 40));

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(0, 102, 153));
        jLabel101.setText("1st step by 3");
        add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 190, 40));

        back_lbl_02.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        back_lbl_02.setForeground(new java.awt.Color(0, 102, 153));
        back_lbl_02.setText("-->");
        back_lbl_02.setToolTipText("Logo");
        back_lbl_02.setAlignmentX(0.5F);
        back_lbl_02.setAutoscrolls(true);
        back_lbl_02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_lbl_02MouseClicked(evt);
            }
        });
        add(back_lbl_02, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 440, 70, 60));

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(0, 102, 153));
        jLabel102.setText("Lecture:");
        add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 180, 40));

        lab.setModel(new javax.swing.SpinnerNumberModel(1, 1, 3, 1));
        add(lab, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 210, 40));

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 102, 153));
        jLabel103.setText("Select duration for the lecture and lab in number of slots");
        add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 400, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void back_lbl_02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_lbl_02MouseClicked
        NewAlgorithm.consecutive_slots_per_lab = (int) lab.getValue();
        NewAlgorithm.consecutive_slots_per_lecture = (int) lec.getValue();
        this.setVisible(false);
        first_panel_part21.setVisible(true);

    }//GEN-LAST:event_back_lbl_02MouseClicked

    public void restricting_jspinner1(){
        lec.setValue(1) ;
        lec.setEnabled(false); 
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back_lbl_02;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JSpinner lab;
    private javax.swing.JSpinner lec;
    // End of variables declaration//GEN-END:variables
}
