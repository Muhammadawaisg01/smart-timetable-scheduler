/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package View.professor;

/**
 *
 * @author muhammad awais 1
 */
public class add_professor_panel extends javax.swing.JPanel {

    /** Creates new form add_professor_panel */
    public add_professor_panel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel96 = new javax.swing.JLabel();
        roomname = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        capacity = new javax.swing.JTextField();
        jLabel97 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 102, 153));
        jLabel96.setText("Professor Details:");
        add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 210, 30));

        roomname.setForeground(new java.awt.Color(0, 102, 153));
        add(roomname, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 360, 30));

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 102, 153));
        jLabel94.setText("Professor name:");
        add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 210, 30));

        capacity.setForeground(new java.awt.Color(0, 102, 153));
        add(capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 360, 30));

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 102, 153));
        jLabel97.setText("Professor ID:");
        add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 210, 30));

        jButton1.setBackground(new java.awt.Color(0, 102, 153));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("next");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 510, 220, 60));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField capacity;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JTextField roomname;
    // End of variables declaration//GEN-END:variables

}
