/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.section;

import Model.Queries;
import View.Alerts;
import static View.Alerts.alert;
import static View.Alerts.isEmpty;
import static db.DBConnection.createConnection;
import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author muhammad awais 1
 */
public class add_new_program extends javax.swing.JPanel {

    /**
     * Creates new form add_new_program
     */

    public add_new_program() {
        initComponents();
        createConnection();
    }

    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel95 = new javax.swing.JLabel();
        semesters = new javax.swing.JTextField();
        jLabel96 = new javax.swing.JLabel();
        save = new javax.swing.JButton();
        jLabel97 = new javax.swing.JLabel();
        program_name = new javax.swing.JTextField();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 102, 153));
        jLabel95.setText("Number of semesters:");
        add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 200, 40));

        semesters.setForeground(new java.awt.Color(0, 102, 153));
        semesters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestersActionPerformed(evt);
            }
        });
        add(semesters, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 470, 40));

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 102, 153));
        jLabel96.setText("Add New Program Details:");
        add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 270, 40));

        save.setBackground(new java.awt.Color(0, 102, 153));
        save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("save program");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 440, 230, 60));

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 102, 153));
        jLabel97.setText("Program Title:");
        add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 190, 40));

        program_name.setForeground(new java.awt.Color(0, 102, 153));
        program_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                program_nameActionPerformed(evt);
            }
        });
        add(program_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 470, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void semestersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semestersActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semestersActionPerformed

    private void program_nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_program_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_program_nameActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        String program = program_name.getText();
        int total_semesters = 0;
        if (isEmpty(program)) {
            alert("Enter program name");
            return;
        }
        // check duplicate
        String query = "select * from program where program_name = '" + program + "'";
        if (Queries.duplicate(query)) {
            alert("Program name already exists");
            return;
        }
        
        String q = "insert into program "
                + "("
                + "program_id,"
                + "program_name"
                + ")"
                + " VALUES "
                + "(?, ?)";
        try {
            int programID = Queries.getRowCount("select * from program") + 1;
            total_semesters = Integer.parseInt(semesters.getText());
            if (total_semesters > 10) {
                alert("You can add maximum ten semesters");
                return;
            }
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(q);
            stmt.setInt(1, programID);
            stmt.setString(2, program);
            stmt.execute();
            for (int i = 1; i <= total_semesters; i++) {
                q = "insert into semester "
                        + "("
                        + "semester_no,"
                        + "program_id"
                        + ")"
                        + " VALUES "
                        + "(?, ?)";
                stmt = conn.prepareStatement(q);
                stmt.setInt(1, i);
                stmt.setInt(2, programID);
                stmt.execute();
            }
            alert("Program added successfully");
            program_name.setText("");
            semesters.setText("");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Semester Number should be integer!");
        } catch (SQLException ex) {
            Logger.getLogger(add_new_program.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JTextField program_name;
    private javax.swing.JButton save;
    private javax.swing.JTextField semesters;
    // End of variables declaration//GEN-END:variables
}
