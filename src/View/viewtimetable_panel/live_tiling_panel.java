
package View.viewtimetable_panel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class live_tiling_panel extends javax.swing.JPanel {


    public live_tiling_panel() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(50, 50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(153, 153, 153));
        jPanel7.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Section:");
        jPanel7.add(jLabel2);
        jLabel2.setBounds(20, 40, 74, 22);

        add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 160, 140));

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));
        jPanel5.setLayout(null);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Room no:");
        jPanel5.add(jLabel6);
        jLabel6.setBounds(20, 80, 87, 22);

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Section:");
        jPanel6.add(jLabel7);
        jLabel7.setBounds(20, 40, 74, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Room no:");
        jPanel6.add(jLabel8);
        jLabel8.setBounds(110, 40, 87, 22);

        jPanel5.add(jPanel6);
        jPanel6.setBounds(0, 0, 0, 0);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setText("Section:");
        jPanel5.add(jLabel9);
        jLabel9.setBounds(20, 40, 74, 22);

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 200, 150));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Section:");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Room no:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 107, -1));

        add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 200, 160));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Section:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(20, 40, 74, 22);

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 150, 150));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Section:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 150, 120));
    }// </editor-fold>//GEN-END:initComponents
    
    
    public void getAllRooms(){  
        
    }   
    
    @Override 
    public void paint(Graphics g) { 
//        super.paintComponent(g); 
        Graphics2D g2 = (Graphics2D) g ; 
//        g2.setStroke(new BasicStroke(3)) ; 
        g2.setColor(Color.gray) ; 
        g2.drawLine(40, 0, 40, 1000) ; 
        g2.drawLine(50, 0, 43, 1000) ; 

        g2.drawLine(0, 30, 1000, 30) ;
        g2.drawLine(0, 33, 1000, 33) ;
        
    } 
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables
}
