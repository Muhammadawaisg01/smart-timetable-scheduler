package View.student;

import Model.Queries;
import View.TableViewUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;

/**
 *
 * @author muhammad awais 1
 */
public class view_student_details_panel extends javax.swing.JPanel {

    /**
     * Creates new form view_student_details_panel
     */
    public view_student_details_panel() {
        initComponents();
    }

    public static void fillStudents() {
        String[] students = null;
        ResultSet rs = Queries.getAllStudent();
        try {
            if (rs.last()) {
                students = new String[rs.getRow()];
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    students[i] = rs.getString("registration_no");
                    i++;
                }
                all_students.setModel(new DefaultComboBoxModel(students));
            }
        } catch (SQLException ex) {
            Logger.getLogger(view_student_details_panel.class.getName()).log(Level.SEVERE, null, ex);
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

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel102 = new javax.swing.JLabel();
        semester_label = new javax.swing.JLabel();
        all_students = new javax.swing.JComboBox<>();
        jLabel95 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        student_courses_table = new JTable() {
            public boolean editCellAt(int row, int column, java.util.EventObject e) {
                return false;
            }
        };
        student_name_label = new javax.swing.JLabel();
        section_label = new javax.swing.JLabel();
        section_id = new javax.swing.JLabel();
        student_name = new javax.swing.JLabel();
        semester = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(50, 50, 50));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel102.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setText("S t u d e n t  D e t a i l s");
        jPanel1.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 230, 30));

        semester_label.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        semester_label.setForeground(new java.awt.Color(0, 102, 153));
        semester_label.setText("Semester");
        jPanel1.add(semester_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 170, 40));

        all_students.setBackground(new java.awt.Color(50, 50, 50));
        all_students.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        all_students.setForeground(new java.awt.Color(255, 255, 255));
        all_students.setMaximumRowCount(7);
        all_students.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Students" }));
        all_students.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                all_studentsItemStateChanged(evt);
            }
        });
        all_students.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                all_studentsPropertyChange(evt);
            }
        });
        jPanel1.add(all_students, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 390, 40));

        jLabel95.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(255, 255, 255));
        jLabel95.setText("S t u d e n t  R e g i s t r a t e d  C o u r s e s");
        jPanel1.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 370, 40));

        jLabel96.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 102, 153));
        jLabel96.setText("Student Registration No");
        jPanel1.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 180, 40));

        student_courses_table.setBackground(new java.awt.Color(50, 50, 50));
        student_courses_table.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        student_courses_table.setForeground(new java.awt.Color(255, 255, 255));
        student_courses_table.setModel(new javax.swing.table.DefaultTableModel(
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
        student_courses_table.setCellSelectionEnabled(true);
        student_courses_table.setEditingColumn(0);
        student_courses_table.setEditingRow(0);
        student_courses_table.setGridColor(new java.awt.Color(0, 102, 153));
        student_courses_table.setRowHeight(30);
        student_courses_table.setRowMargin(4);
        student_courses_table.setShowVerticalLines(false);
        student_courses_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                student_courses_tableMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(student_courses_table);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 650, 190));

        student_name_label.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        student_name_label.setForeground(new java.awt.Color(0, 102, 153));
        student_name_label.setText("Student Name");
        jPanel1.add(student_name_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 160, 40));

        section_label.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        section_label.setForeground(new java.awt.Color(0, 102, 153));
        section_label.setText("Section");
        jPanel1.add(section_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 150, 40));

        section_id.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        section_id.setForeground(new java.awt.Color(255, 255, 255));
        section_id.setText("Section");
        jPanel1.add(section_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 250, 30));

        student_name.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        student_name.setForeground(new java.awt.Color(255, 255, 255));
        student_name.setText("Student Name");
        jPanel1.add(student_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 150, 250, 40));

        semester.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        semester.setForeground(new java.awt.Color(255, 255, 255));
        semester.setText("Semester");
        jPanel1.add(semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 230, 230, 30));

        jScrollPane2.setViewportView(jPanel1);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 580));
    }// </editor-fold>//GEN-END:initComponents

    private void all_studentsPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_all_studentsPropertyChange

    }//GEN-LAST:event_all_studentsPropertyChange

    private void all_studentsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_all_studentsItemStateChanged
        String regNo = all_students.getSelectedItem().toString();
        String studentCourseDetails = "SELECT course_code as 'Course Code', title as 'Course Title', credit_hours as 'Credit Hours', hasLab as 'Lab'\n"
                + " FROM students join student_section_allocation \n"
                + "join course using (course_code)\n"
                + "where\n"
                + "registration_no = student_registration_no and \n"
                + "registration_no = '" + regNo + "'";
        String studentDetails = "select name, students.section_id, semester_no from students join student_section_allocation where registration_no = '"+ regNo +"'";
        System.out.println(studentDetails);
        ResultSet student = Queries.getRS(studentDetails);
        try {
            if (student.next()) {
                student_name.setText(student.getString("name"));
                section_id.setText(student.getString("section_id"));
                semester.setText(student.getInt("semester_no") + "");
            }
        } catch (SQLException ex) {
            Logger.getLogger(view_student_details_panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ResultSet rs = Queries.getRS(studentCourseDetails);
        student_courses_table.setModel(TableViewUtility.resultSetToTableModel(rs));
//        String[] registeredCourses = null;
//        try {
//            String regNo = all_students.getSelectedItem().toString();
//            String name = Queries.getStudent(regNo);
//            System.out.println(name);
//            student_name.setText("Student Name: \t" + name);
//            // get student's registered courses
//            ResultSet registeredCoursesCode = Queries.getStudentRegisteredCourses(regNo);
//            if (registeredCoursesCode.last()) {
//                registeredCourses = new String[registeredCoursesCode.getRow()];
//                registeredCoursesCode.beforeFirst();
//                int i = 0;
//                while (registeredCoursesCode.next()) {
//                    String courseCode = registeredCoursesCode.getString(1);
//                    ResultSet courseDetails = Queries.getCourseDetails(courseCode);
//                    if (courseDetails.next()) {
//                        registeredCourses[i] = courseDetails.getString("title");
//                        i++;
//                    }
//                }
//                // show courses in textarea
////                registered_courses_textarea.setText("");
//                System.out.println(registeredCourses.length);
//                for (String course : registeredCourses) {
////                    registered_courses_textarea.append("\n" + course);
//                }
//
//            } else {
//                System.out.println("No reg course");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(view_student_details_panel.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_all_studentsItemStateChanged

    private void student_courses_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_courses_tableMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_student_courses_tableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox<String> all_students;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel section_id;
    private javax.swing.JLabel section_label;
    private javax.swing.JLabel semester;
    private javax.swing.JLabel semester_label;
    private static javax.swing.JTable student_courses_table;
    private javax.swing.JLabel student_name;
    private javax.swing.JLabel student_name_label;
    // End of variables declaration//GEN-END:variables
}
