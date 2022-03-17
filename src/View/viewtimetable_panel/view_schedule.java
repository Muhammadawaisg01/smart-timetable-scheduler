/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.viewtimetable_panel;

/**
 *
 * @author muhammad awais 1
 */
public class view_schedule extends javax.swing.JPanel {

    /**
     * Creates new form view_schedule
     */
    public view_schedule() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel107 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        entity_name_lbl = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 102, 153));
        jLabel107.setText("View Schedule for all:");
        add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 210, 40));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 660, 310));

        entity_name_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        entity_name_lbl.setForeground(new java.awt.Color(0, 102, 153));
        entity_name_lbl.setText("Entity:");
        add(entity_name_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 40));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel entity_name_lbl;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
