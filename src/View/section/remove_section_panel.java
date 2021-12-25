/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.section;

import Model.Queries;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author muhammad awais 1
 */
public class remove_section_panel extends javax.swing.JPanel {

    /**
     * Creates new form remove_section_panel
     */
    public remove_section_panel() {
        initComponents();
    }

    public static void fillSection(String[] sections) {
        section_id_dd.setModel(new DefaultComboBoxModel<>(sections));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel99 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        section_id_dd = new javax.swing.JComboBox<>();
        remove = new javax.swing.JButton();

        setBackground(new java.awt.Color(50, 50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel99.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 102, 153));
        jLabel99.setText("R e m o v e  S e c t i o n ");
        add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 290, 60));

        jLabel102.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(0, 102, 153));
        jLabel102.setText("Sections");
        add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 150, 40));

        section_id_dd.setBackground(new java.awt.Color(50, 50, 50));
        section_id_dd.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        section_id_dd.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"" }));
        section_id_dd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                section_id_ddActionPerformed(evt);
            }
        });
        add(section_id_dd, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 220, 510, 40));

        remove.setBackground(new java.awt.Color(0, 102, 153));
        remove.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        remove.setForeground(new java.awt.Color(255, 255, 255));
        remove.setText("Remove Section");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 360, 230, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void section_id_ddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_section_id_ddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_section_id_ddActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        String sectionID = section_id_dd.getSelectedItem().toString();
        String removeSection = "delete from section where section_id = '" + sectionID + "'";
        String removeSectionCourses = "delete from section_courses where section_id = '" + sectionID + "'";
        String removeSectionSchedule = "delete from section_schedule where section_id = '" + sectionID + "'";
        String removeSectionProfessorAllocation = "delete from section_professor_allocation where section_id = '" + sectionID + "'";
        Queries.execute(removeSection);
        Queries.execute(removeSectionCourses);
        Queries.execute(removeSectionProfessorAllocation);
        Queries.execute(removeSectionSchedule);
        JOptionPane.showMessageDialog(null, "Section Removed Successfully!");
        fillSection(Queries.getData("section_id", "section"));
    }//GEN-LAST:event_removeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JButton remove;
    private static javax.swing.JComboBox<String> section_id_dd;
    // End of variables declaration//GEN-END:variables
}
