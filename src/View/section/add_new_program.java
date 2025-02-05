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

        setBackground(new java.awt.Color(50, 50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel95.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("Number of semesters");
        add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 200, 40));

        semesters.setBackground(new java.awt.Color(50, 50, 50));
        semesters.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        semesters.setForeground(new java.awt.Color(255, 255, 255));
        semesters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semestersActionPerformed(evt);
            }
        });
        add(semesters, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 260, 40));

        jLabel96.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("A d d   N e w   P r o g r a m   D e t a i l s");
        add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 460, 40));

        save.setBackground(new java.awt.Color(0, 102, 153));
        save.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setText("Add Program");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 170, 50));

        jLabel97.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(255, 255, 255));
        jLabel97.setText("Program Title");
        add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 150, 40));

        program_name.setBackground(new java.awt.Color(50, 50, 50));
        program_name.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        program_name.setForeground(new java.awt.Color(255, 255, 255));
        program_name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                program_nameActionPerformed(evt);
            }
        });
        add(program_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 260, 40));
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
