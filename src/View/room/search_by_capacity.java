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
import static View.room.search_free_slot_panel.jTextArea1;
public class search_by_capacity extends javax.swing.JPanel {

    /**
     * Creates new form search_for_capacity
     */
    public search_by_capacity() {
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

        jLabel96 = new javax.swing.JLabel();
        roomname = new javax.swing.JTextField();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel100 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel98 = new javax.swing.JLabel();
        search_btn = new javax.swing.JButton();
        jLabel101 = new javax.swing.JLabel();
        jComboBox4 = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 102, 153));
        jLabel96.setText("Capacity:");
        add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 160, 30));

        roomname.setForeground(new java.awt.Color(0, 102, 153));
        add(roomname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 360, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 310, 40));

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 102, 153));
        jLabel100.setText("Day:");
        add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 110, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 200, 40));

        jLabel98.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel98.setForeground(new java.awt.Color(0, 102, 153));
        jLabel98.setText("End time:");
        add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 110, 40));

        search_btn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        search_btn.setForeground(new java.awt.Color(0, 102, 153));
        search_btn.setText("search");
        search_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_btnActionPerformed(evt);
            }
        });
        add(search_btn, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 340, 80, 30));

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(0, 102, 153));
        jLabel101.setText("Start time:");
        add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 110, 40));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 200, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void search_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_btnActionPerformed
//        search();
    }//GEN-LAST:event_search_btnActionPerformed
    
    public static void search() {
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JTextField roomname;
    private javax.swing.JButton search_btn;
    // End of variables declaration//GEN-END:variables
}
