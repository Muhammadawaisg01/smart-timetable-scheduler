/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.room;

import Model.Queries;
import View.Alerts;
import static View.Alerts.alert;
import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel96 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        room_capacity = new javax.swing.JTextField();
        room_name = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        isLab = new javax.swing.JRadioButton();
        lecture_radio = new javax.swing.JRadioButton();
        jLabel106 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(50, 50, 50));
        setMaximumSize(new java.awt.Dimension(1000, 2147483647));
        setMinimumSize(new java.awt.Dimension(760, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(255, 255, 255));
        jLabel96.setText("Room name:");
        jPanel1.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 210, 30));

        jLabel94.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(255, 255, 255));
        jLabel94.setText("Room capacity:");
        jPanel1.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 210, 30));

        room_capacity.setBackground(new java.awt.Color(50, 50, 50));
        room_capacity.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        room_capacity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(room_capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 360, 30));

        room_name.setBackground(new java.awt.Color(50, 50, 50));
        room_name.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        room_name.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(room_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, 360, 30));

        jButton10.setBackground(new java.awt.Color(0, 102, 153));
        jButton10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Create Room");
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 330, 200, 60));

        isLab.setBackground(new java.awt.Color(50, 50, 50));
        isLab.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        isLab.setForeground(new java.awt.Color(255, 255, 255));
        isLab.setText("Lab");
        isLab.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        isLab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isLabActionPerformed(evt);
            }
        });
        jPanel1.add(isLab, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 250, 70, -1));

        lecture_radio.setBackground(new java.awt.Color(50, 50, 50));
        lecture_radio.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        lecture_radio.setForeground(new java.awt.Color(255, 255, 255));
        lecture_radio.setText("Lecture room");
        lecture_radio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lecture_radio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecture_radioActionPerformed(evt);
            }
        });
        jPanel1.add(lecture_radio, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 250, -1, -1));

        jLabel106.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(255, 255, 255));
        jLabel106.setText("A d d   N e w   R o o m   o r   L a b");
        jPanel1.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 420, 40));

        jScrollPane1.setViewportView(jPanel1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 570));
    }// </editor-fold>//GEN-END:initComponents

    private void lecture_radioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lecture_radioActionPerformed
        if (lecture_radio.isSelected()) {
            isLab.setSelected(false);
        }
    }//GEN-LAST:event_lecture_radioActionPerformed

    private void isLabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isLabActionPerformed
        // TODO add your handling code here:
        if (isLab.isSelected()) {
            lecture_radio.setSelected(false);
        }
    }//GEN-LAST:event_isLabActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String roomName = room_name.getText();
        if (roomName.equalsIgnoreCase("")) {
            alert("Enter room name");
            return;
        }
        int roomCapicity;
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        boolean lab = isLab.isSelected();
        boolean lec = lecture_radio.isSelected();
        if (!lab && !lec) {
            alert("Please select room type");
            return;
        }
        String q = "insert into room"
                + "("
                + "name,"
                + "capacity,"
                + "isLab,"
                + "isFull"
                + ")"
                + " VALUES "
                + "(?, ?, ?, ?)";
        try {
            roomCapicity = Integer.parseInt(room_capacity.getText());
            stmt = conn.prepareStatement(q);
            stmt.setString(1, roomName);
            stmt.setInt(2, roomCapicity);
            stmt.setString(3, lab + "");
            stmt.setString(4, "false");
            stmt.execute();
            int days = Queries.getDaysCount();
            int slots = Queries.getSlotCount();
            // add empty professor schedule in db according to day and slot count
            String addTempSchedule = "insert into room_availabilty"
                    + "("
                    + "room_name,\n"
                    + "day_no,\n"
                    + "timeslot_no,\n"
                    + "is_available"
                    + ")"
                    + " VALUES "
                    + "(?, ?, ?, ?)";
            for (int day = 1; day <= days; day++) {
                for (int slot = 1; slot <= slots; slot++) {
                    stmt = conn.prepareStatement(addTempSchedule);
                    stmt.setString(1, roomName);
                    stmt.setInt(2, day);
                    stmt.setInt(3, slot);
                    stmt.setString(4, "false");
                    stmt.execute();
                }
            }
            room_name.setText("");
            room_capacity.setText("");
            isLab.setSelected(false);
            lecture_radio.setSelected(false);
            JOptionPane.showMessageDialog(null, "Room data added successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Room name already exists");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid Room Capacity!");
        }
    }//GEN-LAST:event_jButton10ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton isLab;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton lecture_radio;
    private javax.swing.JTextField room_capacity;
    private javax.swing.JTextField room_name;
    // End of variables declaration//GEN-END:variables
}
