/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.viewtimetable_panel;

import Model.Queries;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;
import schedule.DisplayTable;

/**
 *
 * @author muhammad awais 1
 */
public class search_for_specific_entity extends javax.swing.JPanel {

    /**
     * Creates new form search_for_specific_entity
     */
    public search_for_specific_entity() {
        initComponents();
    }
    
    public static void setDropdownData(String[] data) {
        general_dropdown.setModel(new DefaultComboBoxModel<>(data));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        entity_name_lbl = new javax.swing.JLabel();
        general_dropdown = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(50, 50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        entity_name_lbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        entity_name_lbl.setForeground(new java.awt.Color(0, 102, 153));
        entity_name_lbl.setText("Entity");
        add(entity_name_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 170, 40));

        general_dropdown.setBackground(new java.awt.Color(50, 50, 50));
        general_dropdown.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        general_dropdown.setForeground(new java.awt.Color(255, 255, 255));
        general_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        general_dropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                general_dropdownItemStateChanged(evt);
            }
        });
        general_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                general_dropdownActionPerformed(evt);
            }
        });
        add(general_dropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 250, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void general_dropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_general_dropdownItemStateChanged
        String stat = entity_name_lbl.getText();
        String value = general_dropdown.getSelectedItem().toString();
        ResultSet rs;
        if (stat.startsWith("Professor")) {
            int profID = Queries.getProfessorID(value);
            dt.DisplayProfessorSchedule(profID);
            dt.getFrame().setVisible(true);
        } else if (stat.startsWith("Student")) {
//            String studentSchedule = "select \n"
//                    + "student_registration_no as Student, \n"
//                    + "section_id as Section,\n"
//                    + "name as Day, course_code as Course,\n"
//                    + "starting_time as StartTime,\n"
//                    + "ending_time as EndTime, \n"
//                    + "room_name as Room\n"
//                    + "from "
//                    + "student_schedule join day using (day_no)"
//                    + " join timeslot using (timeslot_no) "
//                    + "where "
//                    + "student_registration_no = '" + value + "'";
//            
//            rs = Queries.getRS(studentSchedule);
            dt.DisplayStudentSchedule(value);
            dt.getFrame().setVisible(true);
//            schedule_table.setModel(TableViewUtility.resultSetToTableModel(rs));
        } else if (stat.startsWith("Section")) {
            dt.DisplayOneSectionSchedule(value);
            dt.getFrame().setVisible(true);
        } else if (stat.startsWith("Room")) {
            rs = Queries.getSectionScheduleRS("room_availabilty", "room_name", value + "");
//            schedule_table.setModel(TableViewUtility.resultSetToTableModel(rs));
        }
    }//GEN-LAST:event_general_dropdownItemStateChanged

    private void general_dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_general_dropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_general_dropdownActionPerformed
    
    DisplayTable dt = new DisplayTable();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel entity_name_lbl;
    private static javax.swing.JComboBox<String> general_dropdown;
    // End of variables declaration//GEN-END:variables
}
