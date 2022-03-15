
package View.datesheet_generation;

import Model.Queries;
import View.Alerts;
import static View.datesheet_generation.fourth_panel.tableDark1;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.SelectedDate;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class third_panel extends javax.swing.JPanel {

    public third_panel() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        time1 = new cambodia.raven.Time();
        time2 = new cambodia.raven.Time();
        next = new javax.swing.JLabel();
        back = new javax.swing.JLabel();

        setBackground(new java.awt.Color(50, 50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel110.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel110.setText("Ending Time:");
        add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 200, 70));

        jLabel111.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(255, 255, 255));
        jLabel111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel111.setText("Starting Time:");
        add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 200, 70));
        add(time1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, -1, -1));
        add(time2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, -1, -1));

        next.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        next.setForeground(new java.awt.Color(0, 102, 153));
        next.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        next.setText("N e x t ->");
        next.setToolTipText("Logo");
        next.setAlignmentX(0.5F);
        next.setAutoscrolls(true);
        next.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextMouseExited(evt);
            }
        });
        add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 440, 200, 60));

        back.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        back.setForeground(new java.awt.Color(0, 102, 153));
        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setText("<- B a c k");
        back.setToolTipText("Logo");
        back.setAlignmentX(0.5F);
        back.setAutoscrolls(true);
        back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backMouseExited(evt);
            }
        });
        add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 200, 60));
    }// </editor-fold>//GEN-END:initComponents

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        // show JOptionPane Confirmation message
        // calculate all slots and put that in JTABLE MODEL
        int a = JOptionPane.showConfirmDialog(null, "Are you sure?\nyou won't be able to go back");
        if(a==JOptionPane.NO_OPTION  || a==JOptionPane.CANCEL_OPTION) {             
        }
        else{            
            DefaultTableModel model = (DefaultTableModel) fourth_panel.tableDark1.getModel();
            model.setNumRows(0); 
            String start_date = first_panel.start_date_field.getText();//.substring(0, 2) ;
            String end_date = first_panel.end_date_field.getText();//.substring(0, 2) ;
    //        int s_date = Integer.parseInt(start_date);
    //        int e_date = Integer.parseInt(end_date);

            SelectedDate s_date = first_panel.dateChooser1.getSelectedDate() ;
            SelectedDate e_date = first_panel.dateChooser2.getSelectedDate() ;

            int diff = e_date.getDay() - s_date.getDay();
    //        Vector rows = new Vector() ; 
            int d = s_date.getDay();
            int m = s_date.getMonth() ;
            int y = s_date.getYear();

            int month_diff = e_date.getMonth() - s_date.getMonth() ; 
            if(month_diff == 1 ) { 

            }
            for(int i = 0; i < diff+1; i++) { 
                Vector v = new Vector()  ; 
                v.add(d+"/"+m+"/"+y) ; 
                v.add(get_WeekDay(d+"/"+m+"/"+y)); 
                d++;
                v.add(true) ;
                model.addRow(v);
    //            rows.add(v);
            }
    //            rows = model.getDataVector() ;

            main_panel.third_panel1.setVisible(false);
            main_panel.fourth_panel1.setVisible(true);
        }
    }//GEN-LAST:event_nextMouseClicked

//    private String[] get_Date(String start_date, String end_date , int difference) { 
//        String[] dates = new String[difference+1];
//        String[] s_array = start_date.split("/");
//        String[] e_array = end_date.split("/");
//
//        int s_date = Integer.parseInt(s_array[0]) ;
//        int s_month = Integer.parseInt(s_array[1]) ;
//        
//        int e_date = Integer.parseInt(e_array[0]) ;
//        int e_month = Integer.parseInt(e_array[1]) ;   
//        String var = null ; 
//        int month_diff = e_month- s_month;
//
//        for(int i = 0 ; i < difference+1 ; i++) { 
//            if(month_diff == 0){
//                
//            }
//        }
//    }
    
    private String get_WeekDay(String date){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", java.util.Locale.ENGLISH);
            Date myDate=null;
            try{
                 myDate= sdf.parse(date);
            }
            catch(Exception ex){
                Alerts.alert("there is some issue in finding day");
                System.out.println("there is some issue in finding day");
            }
            sdf.applyPattern("EEE, d MMM yyyy");
            String sMyDate = sdf.format(myDate);
            
            System.out.println(sMyDate.substring(0,3)+"         This is the DAY");
            return sMyDate.substring(0,3);
    }
    
    private void nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseEntered
        next.setBackground(new Color(0, 102, 153));
        next.setForeground(new Color(250, 250, 250));
    }//GEN-LAST:event_nextMouseEntered

    private void nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseExited
        next.setBackground(new Color(250, 250, 250));
        next.setForeground(new Color(0, 102, 153));
    }//GEN-LAST:event_nextMouseExited

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        main_panel.third_panel1.setVisible(false);
        main_panel.second_panel1.setVisible(true); 
    }//GEN-LAST:event_backMouseClicked

    private void backMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseEntered
        back.setBackground(new Color(0, 102, 153));
        back.setForeground(new Color(250, 250, 250));
    }//GEN-LAST:event_backMouseEntered

    private void backMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseExited
        back.setBackground(new Color(250, 250, 250));
        back.setForeground(new Color(0, 102, 153));
    }//GEN-LAST:event_backMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JLabel back;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    public static javax.swing.JLabel next;
    public static cambodia.raven.Time time1;
    public static cambodia.raven.Time time2;
    // End of variables declaration//GEN-END:variables
}
