/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.section;

import Model.Program;
import static Model.Program.get_all_programs;
import Model.Queries;
import static View.Alerts.alert;
import View.section.view_section_details_panel;
import View.TableViewUtility;
import static db.DBConnection.getConnection;
import static db.DBConnection.executeQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import pop_ups.SectionDetails;
import schedule.DisplayTable;

public class view_section_details_option_panel extends javax.swing.JPanel {

    private static String[] semesters_list = null;
    static String[] sectionIDs = null;

    public view_section_details_option_panel() {
        initComponents();
    }

    public static void init() {
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        String q = "";
        String[] programs = null;
        ResultSet rs = get_all_programs();
        try {
            if (rs.last()) {
                programs = new String[rs.getRow()];
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    programs[i] = rs.getString(1);
                    i++;
                }
            }
            programs_dropdown.setModel(new DefaultComboBoxModel<>(programs));

            q = "select * from semester where program_id = " + Queries.getProgramID(programs[0]);
            stmt = conn.prepareStatement(q);
            ResultSet semesters = stmt.executeQuery();
            if (semesters.last()) {
                int total_semesters = semesters.getRow();
                semesters.beforeFirst();
                semesters_list = new String[total_semesters];
            } else {
                JOptionPane.showMessageDialog(null, "Someting went wrong");
                return;
            }
            int i = 0;
            while (semesters.next()) {
                semesters_list[i] = semesters.getInt(1) + "";
                i++;
            }
            semesters_dropdown.setModel(new DefaultComboBoxModel<>(semesters_list));
        } catch (SQLException ex) {
            Logger.getLogger(view_section_details_option_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel98 = new javax.swing.JLabel();
        semesters_dropdown = new javax.swing.JComboBox<>();
        jLabel99 = new javax.swing.JLabel();
        programs_dropdown = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        section_detail_table = new JTable() {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        jLabel100 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(50, 50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 102, 153));
        jLabel98.setText("double-click on row will open view_section_details_panel");
        add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 410, 40));

        semesters_dropdown.setBackground(new java.awt.Color(50, 50, 50));
        semesters_dropdown.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        semesters_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"" }));
        semesters_dropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                semesters_dropdownItemStateChanged(evt);
            }
        });
        semesters_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semesters_dropdownActionPerformed(evt);
            }
        });
        add(semesters_dropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 160, 220, 40));

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 102, 153));
        jLabel99.setText("Program:");
        add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 150, 40));

        programs_dropdown.setBackground(new java.awt.Color(50, 50, 50));
        programs_dropdown.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        programs_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"" }));
        programs_dropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                programs_dropdownItemStateChanged(evt);
            }
        });
        programs_dropdown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                programs_dropdownActionPerformed(evt);
            }
        });
        add(programs_dropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 80, 220, 40));

        section_detail_table.setBackground(new java.awt.Color(50, 50, 50));
        section_detail_table.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        section_detail_table.setForeground(new java.awt.Color(255, 255, 255));
        section_detail_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Section ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        section_detail_table.setCellSelectionEnabled(true);
        section_detail_table.setEditingColumn(0);
        section_detail_table.setEditingRow(0);
        section_detail_table.setGridColor(new java.awt.Color(0, 102, 153));
        section_detail_table.setRowHeight(30);
        section_detail_table.setRowMargin(4);
        section_detail_table.setShowVerticalLines(false);
        section_detail_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                section_detail_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(section_detail_table);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 690, 130));

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 102, 153));
        jLabel100.setText("Semester:");
        add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 140, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void semesters_dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semesters_dropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semesters_dropdownActionPerformed

    private void programs_dropdownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_programs_dropdownActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_programs_dropdownActionPerformed

    private void programs_dropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_programs_dropdownItemStateChanged
        // get selected program
        String selecte_program = programs_dropdown.getSelectedItem().toString();
        // get program id from database
        int program_id = 0;
        String q = "select program_id from program where program_name = '" + selecte_program + "'";
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                program_id = rs.getInt(1);
            } else {
                JOptionPane.showMessageDialog(null, "Someting went wrong");
                return;
            }
            // get semesters of that program from semester table
            q = "select * from semester where program_id = " + program_id;
            stmt = conn.prepareStatement(q);
            ResultSet semesters = stmt.executeQuery();
            if (semesters.last()) {
                int total_semesters = semesters.getRow();
                semesters.beforeFirst();
                semesters_list = new String[total_semesters];
            } else {
                JOptionPane.showMessageDialog(null, "Someting went wrong");
                return;
            }
            int i = 0;
            while (semesters.next()) {
                semesters_list[i] = semesters.getInt(1) + "";
                i++;
            }
            semesters_dropdown.setModel(new DefaultComboBoxModel<>(semesters_list));
        } catch (SQLException ex) {
            Logger.getLogger(create_section_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_programs_dropdownItemStateChanged

    private void semesters_dropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_semesters_dropdownItemStateChanged
        int program_id = Program.program_id(programs_dropdown.getSelectedItem().toString());
        int semester_no = Integer.parseInt(semesters_dropdown.getSelectedItem().toString());
        String q = "select section_id as SectionID from section where program_id = " + program_id + " and semester_no = " + semester_no;
        ResultSet sections = executeQuery(q);
        try {
            if (sections.last()) {
                sectionIDs = new String[sections.getRow()];
                sections.beforeFirst();
                int i = 0;
                while (sections.next()) {
                    sectionIDs[i] = sections.getString(1);
                    i++;
                }
                sections.beforeFirst();
            }
        } catch (SQLException ex) {
            Logger.getLogger(view_section_details_option_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        section_detail_table.setModel(TableViewUtility.resultSetToTableModel(sections));
    }//GEN-LAST:event_semesters_dropdownItemStateChanged

    private void section_detail_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_section_detail_tableMouseClicked
//        System.out.println(evt.getClickCount());
        if (evt.getClickCount() == 2) {
            JTable target = (JTable) evt.getSource();
            int row = target.getSelectedRow();
            // section id
            String sectionID = sectionIDs[row];
            showSectionDetails(sectionID);

        }
    }

    public void showSectionDetails(String sectionID) {
        String getSectionStrength = "SELECT count(*) as strength FROM students where section_id = '" + sectionID + "'";
        ResultSet rs = Queries.getRS(getSectionStrength);
        try {
            rs.next();
            int sectionStrength = rs.getInt("strength");
            // section courses
            String getCourses = "SELECT title as 'Course Title', credit_hours as 'Credit Hours', hasLab as 'LAB' FROM section_courses join course using (course_code) where section_id = '" + sectionID + "'";
            ResultSet courses = Queries.getRS(getCourses);
            // section course allocation
            String getAllocations = "SELECT course_code as 'Course Code', title as 'Course Title', lab_or_theory as 'Lecture Type', name as 'Professor Name'\n"
                    + "FROM section_professor_allocation join professor using (professor_id)\n"
                    + "join course using (course_code)\n"
                    + "where section_id = '" + sectionID + "'";
            ResultSet allocations = Queries.getRS(getAllocations);
            SectionDetails s = new SectionDetails();
            s.show(sectionID, sectionStrength, courses, allocations);

        } catch (SQLException ex) {
            Logger.getLogger(view_section_details_option_panel.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_section_detail_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JComboBox<String> programs_dropdown;
    private javax.swing.JTable section_detail_table;
    private static javax.swing.JComboBox<String> semesters_dropdown;
    // End of variables declaration//GEN-END:variables
}
