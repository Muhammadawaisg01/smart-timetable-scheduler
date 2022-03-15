
package View.datesheet_generation;

import Controller.datesheet_generation.Datesheet_generation_algorithm;
import Model.Queries;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

public class fifth_panel extends javax.swing.JPanel {

    public fifth_panel() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generate_datesheet = new javax.swing.JButton();
        jLabel102 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(50, 50, 50));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        generate_datesheet.setBackground(new java.awt.Color(0, 102, 153));
        generate_datesheet.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        generate_datesheet.setForeground(new java.awt.Color(255, 255, 255));
        generate_datesheet.setText("Generate Datesheet");
        generate_datesheet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generate_datesheetActionPerformed(evt);
            }
        });
        add(generate_datesheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 360, 80));

        jLabel102.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setText("G e n e r a t e   D a t e s h e e t ");
        add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 360, 40));
    }// </editor-fold>//GEN-END:initComponents

//    private void 
    private void add_ExamDay(Vector vector){
        int var=0;
        for(int vec = 0 ; vec < vector.size(); vec++){
            String s = vector.get(vec).toString();
            String s1 = s.substring(1, s.length()-1 ) ;
            String[] s2 = s1.split(", ") ;
            System.out.println(s2[0]);
            System.out.println(s2[1]);
            System.out.println(s2[2]);
            if(s2[2].equals("true")){
                Queries.add_Row_to_ExamDay(++var, s2[0], s2[1]) ; 
            }
            
        }
    }

    private int calculate_Num_of_Slots(String start_time, String end_time, int duration){
        int var1 = 0 ; 
        String[] s1 = start_time.split(" ");
        String[] s2 = end_time.split(" ") ;
        String am_pm = s2[1];               // check whether ending time is am or pm

        if(am_pm.equals("PM")){
            String[] s3 = s1[0].split(":");
            String[] s4 = s2[0].split(":");            
            int var2 = (Integer.parseInt(s4[0])+12) - Integer.parseInt(s3[0]) ;
            int var3 = var2*60 ;
            int var4 = (Integer.parseInt(s4[1])) - Integer.parseInt(s3[1]);
            int var5 = var3+var4;
            var1 = var5/duration;
        }
        return var1;
    }

    private void create_slots(String start_time, String end_time, int duration){
        int num_slots= calculate_Num_of_Slots(start_time, end_time, duration) ;
        
        String time1 = start_time.split(" ")[0] ;
        for(int slot_no = 0 ; slot_no < num_slots ; slot_no++){
            try{
                SimpleDateFormat df = new SimpleDateFormat("HH:mm");
                Date d = df.parse(time1);
                Calendar cal = Calendar.getInstance();
                cal.setTime(d);
                cal.add(Calendar.MINUTE, duration) ; 
                String time2 = df.format(cal.getTime());
//                System.out.println(time2);
                String time3 = time2;
//                time1 = time2;
                Date d1 = df.parse(time3);
                Calendar cal1 = Calendar.getInstance();
                cal1.setTime(d1);
                cal1.add(Calendar.MINUTE, 15) ; 
                String time4 = df.format(cal1.getTime());
                
                System.out.println(slot_no+"    "+ time1+"    "+time3) ;  
                Queries.add_Row_to_ExamTimeslot(slot_no+1,time1,time3);
                time1 = time4;                
            }
            catch(Exception ex ){
                System.out.println("Exception in create slots method");
                ex.printStackTrace();
            }
        }
        
        


    }
    private void generate_datesheetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generate_datesheetActionPerformed
        // implement all logic here
        
        Queries.add_ExaminationTitle(title_panel.title.getText());          // Set examination title
        
        DefaultTableModel model = (DefaultTableModel) fourth_panel.tableDark1.getModel();
        Vector vector = model.getDataVector();
        add_ExamDay(vector);                           // add Exam Days to the Database
        
        String exam_duration= (String)second_panel.time_duration.getSelectedItem();
        String start_time = third_panel.time1.getText();
        String end_time = third_panel.time2.getText();        
        create_slots(start_time, end_time, Integer.parseInt(exam_duration));                // add timeslots 
        
        Datesheet_generation_algorithm.main_algorithm();                    // call generating main algorithm        
        ViewDatesheetFrame frame = new ViewDatesheetFrame();; 
        frame.setVisible(true);
    }//GEN-LAST:event_generate_datesheetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton generate_datesheet;
    private javax.swing.JLabel jLabel102;
    // End of variables declaration//GEN-END:variables
}