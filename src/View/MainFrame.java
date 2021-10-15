package View;

import Model.Course;
import Model.Professor;
import Model.Program;
import Model.Room;
import db.DBConnection;
import static db.DBConnection.createConnection;
import static db.DBConnection.getConnection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
public class MainFrame extends javax.swing.JFrame {
    public MainFrame() {
        initComponents();   
        this.setLocationRelativeTo(null);   
        createConnection();
        System.out.println("I am connection      "+getConnection()) ; 
    }   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        Dept = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        program = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel21 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        course = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        students = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        scheduler_generation = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        datesheet_generation = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Department = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        Dashboard_Dept = new javax.swing.JPanel();
        jTextField2 = new javax.swing.JTextField();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        view_all_roomslbl = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        add_roomlbl = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        dept_details_panel = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        dept_name = new javax.swing.JLabel();
        programslbl = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        roomslbl = new javax.swing.JLabel();
        labslbl = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel103 = new javax.swing.JLabel();
        professorslbl = new javax.swing.JLabel();
        view_labsbtn = new javax.swing.JButton();
        view_roomsbtn = new javax.swing.JButton();
        view_programsbtn = new javax.swing.JButton();
        view_facultybtn = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        courseslbl = new javax.swing.JLabel();
        view_coursesbtn = new javax.swing.JButton();
        add_room = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        labcheckBox1 = new javax.swing.JCheckBox();
        roomname = new javax.swing.JTextField();
        capacity = new javax.swing.JTextField();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel96 = new javax.swing.JLabel();
        jComboBox8 = new javax.swing.JComboBox<>();
        labcheckBox2 = new javax.swing.JCheckBox();
        add_roombtn = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        labcheckBox3 = new javax.swing.JCheckBox();
        viewData = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        display_table = new javax.swing.JTable();
        available_datalbl = new javax.swing.JLabel();
        delete_room = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        room_name1 = new javax.swing.JTextField();
        jLabel93 = new javax.swing.JLabel();
        find_del_panelbtn = new javax.swing.JButton();
        delbtn = new javax.swing.JButton();
        Programs = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Dashboard_Programs = new javax.swing.JPanel();
        jTextField3 = new javax.swing.JTextField();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        all_programs_panel = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        programs_table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel46 = new javax.swing.JPanel();
        jLabel58 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel87 = new javax.swing.JLabel();
        jPanel50 = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel51 = new javax.swing.JPanel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel52 = new javax.swing.JPanel();
        jLabel75 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel53 = new javax.swing.JPanel();
        jLabel80 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jComboBox4 = new javax.swing.JComboBox<>();
        jLabel82 = new javax.swing.JLabel();
        jComboBox5 = new javax.swing.JComboBox<>();
        jPanel54 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel55 = new javax.swing.JPanel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jComboBox6 = new javax.swing.JComboBox<>();
        jLabel86 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        Courses = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        Dashboard_Courses = new javax.swing.JPanel();
        jTextField13 = new javax.swing.JTextField();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        addCourse = new javax.swing.JPanel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        crs_code = new javax.swing.JTextField();
        title = new javax.swing.JTextField();
        credit_hours = new javax.swing.JTextField();
        labcheckBox = new javax.swing.JCheckBox();
        jButton6 = new javax.swing.JButton();
        viewAllCourses = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        coursesTable = new javax.swing.JTable();
        delCourse = new javax.swing.JPanel();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        title1 = new javax.swing.JTextField();
        crs_code1 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        updateCourse = new javax.swing.JPanel();
        update_coursebtn = new javax.swing.JButton();
        labcheckBox5 = new javax.swing.JCheckBox();
        credit_hours2 = new javax.swing.JTextField();
        title2 = new javax.swing.JTextField();
        crs_code2 = new javax.swing.JTextField();
        jLabel111 = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jLabel114 = new javax.swing.JLabel();
        schedule_generation = new javax.swing.JPanel();
        jPanel23container = new javax.swing.JPanel();
        Dashboard_Dept1 = new javax.swing.JPanel();
        jTextField16 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jTextField15 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        labcheckBox4 = new javax.swing.JCheckBox();
        labcheckBox6 = new javax.swing.JCheckBox();
        labcheckBox7 = new javax.swing.JCheckBox();
        labcheckBox8 = new javax.swing.JCheckBox();
        labcheckBox9 = new javax.swing.JCheckBox();
        labcheckBox10 = new javax.swing.JCheckBox();
        labcheckBox11 = new javax.swing.JCheckBox();
        jPanel23 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        MainPanel.setBackground(new java.awt.Color(255, 255, 255));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 153));
        jLabel2.setText("TimeTable Scheduler");
        jLabel2.setToolTipText("Logo");
        jLabel2.setAlignmentX(0.5F);
        jLabel2.setAutoscrolls(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        MainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 230, 50));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 102, 153));
        jLabel10.setText(" THE FIRST Panel(Main)");
        jLabel10.setToolTipText("Logo");
        jLabel10.setAlignmentX(0.5F);
        jLabel10.setAutoscrolls(true);
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel10MouseEntered(evt);
            }
        });
        MainPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 270, 40));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 102, 153));
        jLabel4.setText("X");
        MainPanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1040, 0, 20, 30));

        jTextField1.setText("Search");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        MainPanel.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 110, 330, 30));

        Dept.setBackground(new java.awt.Color(255, 255, 255));
        Dept.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        Dept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeptMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                DeptMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                DeptMouseExited(evt);
            }
        });
        Dept.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 102, 153));
        jLabel6.setText("Department");
        Dept.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        MainPanel.add(Dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 260, 130));

        program.setBackground(new java.awt.Color(255, 255, 255));
        program.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        program.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                programMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                programMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                programMouseExited(evt);
            }
        });
        program.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 102, 153));
        jLabel25.setText("Programs");
        program.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 200, -1));

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        jPanel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel14MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel14MouseEntered(evt);
            }
        });
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 153));
        jLabel17.setText("Programs");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        jPanel15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel15MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel15MouseEntered(evt);
            }
        });
        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 102, 153));
        jLabel18.setText("Programs");
        jPanel15.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        jPanel14.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 260, 130));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        jPanel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel16MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel16MouseEntered(evt);
            }
        });
        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 102, 153));
        jLabel19.setText("Programs");
        jPanel16.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        jPanel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel17MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel17MouseEntered(evt);
            }
        });
        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 102, 153));
        jLabel20.setText("Programs");
        jPanel17.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        jPanel16.add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 260, 130));

        jPanel14.add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 260, 130));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        jPanel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel18MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel18MouseEntered(evt);
            }
        });
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 102, 153));
        jLabel21.setText("Programs");
        jPanel18.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        jPanel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel19MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel19MouseEntered(evt);
            }
        });
        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 102, 153));
        jLabel22.setText("Programs");
        jPanel19.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        jPanel18.add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 260, 130));

        jPanel20.setBackground(new java.awt.Color(255, 255, 255));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        jPanel20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel20MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel20MouseEntered(evt);
            }
        });
        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 102, 153));
        jLabel23.setText("Programs");
        jPanel20.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        jPanel21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel21MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel21MouseEntered(evt);
            }
        });
        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 102, 153));
        jLabel24.setText("Programs");
        jPanel21.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        jPanel20.add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 260, 130));

        jPanel18.add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 260, 130));

        jPanel14.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 260, 130));

        program.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 260, 130));

        MainPanel.add(program, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 160, 240, 130));

        course.setBackground(new java.awt.Color(255, 255, 255));
        course.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                courseMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                courseMouseExited(evt);
            }
        });
        course.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 153));
        jLabel8.setText("Courses");
        course.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        MainPanel.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 260, 130));

        students.setBackground(new java.awt.Color(255, 255, 255));
        students.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentsMouseEntered(evt);
            }
        });
        students.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setText("Students");
        students.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        MainPanel.add(students, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, 130));

        scheduler_generation.setBackground(new java.awt.Color(255, 255, 255));
        scheduler_generation.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        scheduler_generation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scheduler_generationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                scheduler_generationMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                scheduler_generationMouseExited(evt);
            }
        });
        scheduler_generation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 153));
        jLabel5.setText("Schedule Generation");
        scheduler_generation.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 380, -1));

        MainPanel.add(scheduler_generation, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 400, 130));

        datesheet_generation.setBackground(new java.awt.Color(255, 255, 255));
        datesheet_generation.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        datesheet_generation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datesheet_generationMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                datesheet_generationMouseEntered(evt);
            }
        });
        datesheet_generation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 153));
        jLabel26.setText("Datesheet");
        datesheet_generation.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 200, -1));

        MainPanel.add(datesheet_generation, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 310, 260, 130));

        getContentPane().add(MainPanel, "card2");

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("          LOGO");
        jLabel1.setToolTipText("Logo");
        jLabel1.setAlignmentX(0.5F);
        jLabel1.setAutoscrolls(true);
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel1MouseEntered(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dashboard");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel3MouseEntered(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(844, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addComponent(jLabel3)
                .addContainerGap(354, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        Department.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Dept.setBackground(new java.awt.Color(0, 102, 153));
        Dashboard_Dept.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField2.setText("Search");
        Dashboard_Dept.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 88, 210, 30));

        jLabel41.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("view free slots in a room");
        Dashboard_Dept.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 240, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("   Home");
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        Dashboard_Dept.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 80, 30));

        view_all_roomslbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        view_all_roomslbl.setForeground(new java.awt.Color(255, 255, 255));
        view_all_roomslbl.setText("View all rooms");
        view_all_roomslbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_all_roomslblMouseClicked(evt);
            }
        });
        Dashboard_Dept.add(view_all_roomslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 160, 40));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("//update room details");
        Dashboard_Dept.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 210, 40));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("View schedule of a room");
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
        });
        Dashboard_Dept.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 230, 30));

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("view department details");
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });
        Dashboard_Dept.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 250, 40));

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("remove room");
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        Dashboard_Dept.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 150, 30));

        add_roomlbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_roomlbl.setForeground(new java.awt.Color(255, 255, 255));
        add_roomlbl.setText("add room");
        add_roomlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_roomlblMouseClicked(evt);
            }
        });
        Dashboard_Dept.add(add_roomlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 150, 30));

        jPanel45.add(Dashboard_Dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 560));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.CardLayout());

        dept_details_panel.setBackground(new java.awt.Color(255, 255, 255));
        dept_details_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 102, 153));
        jLabel46.setText("Faculty members:");
        dept_details_panel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 232, 210, 30));

        dept_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dept_name.setForeground(new java.awt.Color(0, 102, 153));
        dept_name.setText("Department Name");
        dept_details_panel.add(dept_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 26, 560, 30));

        programslbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        programslbl.setForeground(new java.awt.Color(0, 102, 153));
        programslbl.setText("1");
        dept_details_panel.add(programslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 100, 30));

        jLabel99.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(0, 102, 153));
        jLabel99.setText("Total Labs:");
        dept_details_panel.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 172, 210, 30));

        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(0, 102, 153));
        jLabel100.setText("No. of Programs:");
        dept_details_panel.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 210, -1));

        roomslbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        roomslbl.setForeground(new java.awt.Color(0, 102, 153));
        roomslbl.setText("1");
        dept_details_panel.add(roomslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 60, 30));

        labslbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labslbl.setForeground(new java.awt.Color(0, 102, 153));
        labslbl.setText("1");
        dept_details_panel.add(labslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 50, 30));
        dept_details_panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 690, -1));

        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(0, 102, 153));
        jLabel103.setText("Total Rooms:");
        dept_details_panel.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 210, -1));

        professorslbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        professorslbl.setForeground(new java.awt.Color(0, 102, 153));
        professorslbl.setText("1");
        dept_details_panel.add(professorslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 50, 30));

        view_labsbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        view_labsbtn.setForeground(new java.awt.Color(0, 102, 153));
        view_labsbtn.setText("view all");
        view_labsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_labsbtnActionPerformed(evt);
            }
        });
        dept_details_panel.add(view_labsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 110, 40));

        view_roomsbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        view_roomsbtn.setForeground(new java.awt.Color(0, 102, 153));
        view_roomsbtn.setText("view all");
        view_roomsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_roomsbtnActionPerformed(evt);
            }
        });
        dept_details_panel.add(view_roomsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 110, 40));

        view_programsbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        view_programsbtn.setForeground(new java.awt.Color(0, 102, 153));
        view_programsbtn.setText("view all");
        view_programsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_programsbtnActionPerformed(evt);
            }
        });
        dept_details_panel.add(view_programsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 110, 40));

        view_facultybtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        view_facultybtn.setForeground(new java.awt.Color(0, 102, 153));
        view_facultybtn.setText("view all");
        view_facultybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_facultybtnActionPerformed(evt);
            }
        });
        dept_details_panel.add(view_facultybtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 110, 40));

        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(0, 102, 153));
        jLabel105.setText("No. of Courses offered:");
        dept_details_panel.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 220, -1));

        courseslbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        courseslbl.setForeground(new java.awt.Color(0, 102, 153));
        courseslbl.setText("1");
        dept_details_panel.add(courseslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 380, 100, 30));

        view_coursesbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        view_coursesbtn.setForeground(new java.awt.Color(0, 102, 153));
        view_coursesbtn.setText("view all");
        view_coursesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_coursesbtnActionPerformed(evt);
            }
        });
        dept_details_panel.add(view_coursesbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 110, 40));

        jPanel3.add(dept_details_panel, "card3");

        add_room.setBackground(new java.awt.Color(255, 255, 255));
        add_room.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(0, 102, 153));
        jLabel59.setText("Room specification for course:");
        add_room.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 320, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 102, 153));
        jButton7.setText("specify");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        add_room.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 80, 30));

        labcheckBox1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox1.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox1.setText("Lecture");
        add_room.add(labcheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 80, 30));

        roomname.setForeground(new java.awt.Color(0, 102, 153));
        add_room.add(roomname, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 360, 30));

        capacity.setForeground(new java.awt.Color(0, 102, 153));
        add_room.add(capacity, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 140, 360, 30));

        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel94.setForeground(new java.awt.Color(0, 102, 153));
        jLabel94.setText("Room capacity:");
        add_room.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 210, 30));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 102, 153));
        jLabel95.setText("Course:");
        add_room.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 160, 30));

        jLabel69.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(0, 102, 153));
        jLabel69.setText("Room Details:");
        add_room.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 26, 210, -1));

        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel96.setForeground(new java.awt.Color(0, 102, 153));
        jLabel96.setText("Room name:");
        add_room.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 210, 30));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"" }));
        add_room.add(jComboBox8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 340, 380, 30));

        labcheckBox2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox2.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox2.setText(" is Lab");
        add_room.add(labcheckBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 200, 110, 40));

        add_roombtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        add_roombtn.setForeground(new java.awt.Color(0, 102, 153));
        add_roombtn.setText("add room");
        add_roombtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_roombtnActionPerformed(evt);
            }
        });
        add_room.add(add_roombtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 180, 60));
        add_room.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 690, -1));

        labcheckBox3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox3.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox3.setText("Lab");
        add_room.add(labcheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, 80, 30));

        jPanel3.add(add_room, "card2");

        viewData.setBackground(new java.awt.Color(255, 255, 255));
        viewData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        display_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane6.setViewportView(display_table);

        viewData.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 660, 370));

        available_datalbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        available_datalbl.setForeground(new java.awt.Color(0, 102, 153));
        available_datalbl.setText("Available Data:");
        viewData.add(available_datalbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 40));

        jPanel3.add(viewData, "card4");

        delete_room.setBackground(new java.awt.Color(255, 255, 255));
        delete_room.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 102, 153));
        jLabel97.setText("Room name:");
        delete_room.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 210, 30));

        room_name1.setForeground(new java.awt.Color(0, 102, 153));
        delete_room.add(room_name1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 90, 360, 30));

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 102, 153));
        jLabel93.setText("Enter Room Details:");
        delete_room.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 26, 210, -1));

        find_del_panelbtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        find_del_panelbtn.setForeground(new java.awt.Color(0, 102, 153));
        find_del_panelbtn.setText("find");
        find_del_panelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                find_del_panelbtnActionPerformed(evt);
            }
        });
        delete_room.add(find_del_panelbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, 80, 30));

        delbtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        delbtn.setForeground(new java.awt.Color(0, 102, 153));
        delbtn.setText("delete room");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });
        delete_room.add(delbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 480, 180, 60));

        jPanel3.add(delete_room, "card5");

        jPanel45.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 560));

        Department.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 560));

        getContentPane().add(Department, "card5");

        Programs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Programs.setBackground(new java.awt.Color(0, 102, 153));
        Dashboard_Programs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField3.setText("Search");
        Dashboard_Programs.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 88, 210, 30));

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("Search/");
        Dashboard_Programs.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 200, 30));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("   Home For Programs");
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        Dashboard_Programs.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 200, 30));

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("all programs");
        jLabel51.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel51MouseClicked(evt);
            }
        });
        Dashboard_Programs.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 30));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Labs");
        Dashboard_Programs.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 80, 30));

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("View Schedule for Section");
        Dashboard_Programs.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 240, 30));

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("Assigning Professors");
        jLabel57.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel57MouseClicked(evt);
            }
        });
        Dashboard_Programs.add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 230, 30));

        jLabel78.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel78.setForeground(new java.awt.Color(255, 255, 255));
        jLabel78.setText("Semesters");
        Dashboard_Programs.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 120, 30));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(255, 255, 255));
        jLabel79.setText("Sections");
        Dashboard_Programs.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 160, 30));

        jPanel2.add(Dashboard_Programs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 560));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setLayout(new java.awt.CardLayout());

        all_programs_panel.setBackground(new java.awt.Color(255, 255, 255));
        all_programs_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 102, 153));
        jLabel54.setText("Current available Programs");
        all_programs_panel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 26, 290, 30));

        programs_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(programs_table);

        all_programs_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 650, 340));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 102, 153));
        jButton1.setText("+");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        all_programs_panel.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 470, 70, 60));

        jPanel47.add(all_programs_panel, "card3");

        jPanel46.setBackground(new java.awt.Color(255, 255, 255));
        jPanel46.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel58.setBackground(new java.awt.Color(255, 255, 255));
        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 78)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(0, 102, 153));
        jLabel58.setText(">>");
        jPanel46.add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 150, 110));

        jLabel60.setBackground(new java.awt.Color(255, 255, 255));
        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(0, 102, 153));
        jLabel60.setText("Semester No: ");
        jPanel46.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 140, 30));

        jLabel61.setBackground(new java.awt.Color(255, 255, 255));
        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(0, 102, 153));
        jLabel61.setText("Program:");
        jPanel46.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 90, 30));

        jLabel62.setBackground(new java.awt.Color(255, 255, 255));
        jLabel62.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(0, 102, 153));
        jLabel62.setText("BSCS");
        jPanel46.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 50, 30));

        jLabel64.setBackground(new java.awt.Color(255, 255, 255));
        jLabel64.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(0, 102, 153));
        jLabel64.setText("Professors:");
        jPanel46.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, 130, 30));

        jLabel66.setBackground(new java.awt.Color(255, 255, 255));
        jLabel66.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(0, 102, 153));
        jLabel66.setText("Section No:");
        jPanel46.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 120, 30));

        jLabel70.setBackground(new java.awt.Color(255, 255, 255));
        jLabel70.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel70.setForeground(new java.awt.Color(0, 102, 153));
        jLabel70.setText("found");
        jPanel46.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 90, 30));

        jLabel71.setBackground(new java.awt.Color(255, 255, 255));
        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(0, 102, 153));
        jLabel71.setText("Professor:");
        jPanel46.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 180, 30));

        jTextField6.setText(" ");
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel46.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 180, 30));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel46.add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 240, 190, 40));

        jLabel72.setBackground(new java.awt.Color(255, 255, 255));
        jLabel72.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(0, 102, 153));
        jLabel72.setText("Courses:");
        jPanel46.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 90, 30));

        jLabel73.setBackground(new java.awt.Color(255, 255, 255));
        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 102, 153));
        jLabel73.setText("Course:");
        jPanel46.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 90, 30));

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel46.add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 190, 40));
        jPanel46.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, 80, 30));
        jPanel46.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 80, 30));

        jButton5.setText("Get");
        jPanel46.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 123, -1, 30));

        jLabel87.setBackground(new java.awt.Color(255, 255, 255));
        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel87.setForeground(new java.awt.Color(0, 102, 153));
        jLabel87.setText("C 1");
        jPanel46.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 90, 30));

        jPanel47.add(jPanel46, "card3");

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 102, 153));
        jLabel74.setText("Add Program Details:");
        jPanel50.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 26, 210, -1));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 102, 153));
        jButton2.setText("Add");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel50.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 120, 50));

        jPanel51.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel76.setBackground(new java.awt.Color(255, 255, 255));
        jLabel76.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(0, 102, 153));
        jLabel76.setText("Program Name:");
        jPanel51.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 28));

        jLabel77.setBackground(new java.awt.Color(255, 255, 255));
        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel77.setForeground(new java.awt.Color(0, 102, 153));
        jLabel77.setText("No of Semesters:");
        jPanel51.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, 28));

        jTextField4.setText(" ");
        jPanel51.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 120, 30));

        jTextField10.setText(" ");
        jPanel51.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 300, 30));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel51.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 150, 30));

        jScrollPane2.setViewportView(jPanel51);

        jPanel50.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 680, 340));

        jPanel47.add(jPanel50, "card3");

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel75.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(0, 102, 153));
        jLabel75.setText("Add Semester Details:");
        jPanel52.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 102, 153));
        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel52.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 120, 50));

        jPanel53.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel80.setBackground(new java.awt.Color(255, 255, 255));
        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 102, 153));
        jLabel80.setText("Semester No:");
        jPanel53.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 28));

        jLabel81.setBackground(new java.awt.Color(255, 255, 255));
        jLabel81.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel81.setForeground(new java.awt.Color(0, 102, 153));
        jLabel81.setText("No of Sections:");
        jPanel53.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 170, 28));

        jTextField5.setText(" ");
        jPanel53.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 120, 30));

        jTextField11.setText(" ");
        jPanel53.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 120, 30));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel53.add(jComboBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 150, 30));

        jScrollPane3.setViewportView(jPanel53);

        jPanel52.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 680, 340));

        jLabel82.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel82.setForeground(new java.awt.Color(0, 102, 153));
        jLabel82.setText("Enter Program Name:");
        jPanel52.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 18, 210, 30));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel52.add(jComboBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 200, 30));

        jPanel47.add(jPanel52, "card3");

        jPanel54.setBackground(new java.awt.Color(255, 255, 255));
        jPanel54.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel83.setForeground(new java.awt.Color(0, 102, 153));
        jLabel83.setText("Add Semester Details:");
        jPanel54.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, -1));

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 32)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 102, 153));
        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel54.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 120, 50));

        jPanel55.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel84.setBackground(new java.awt.Color(255, 255, 255));
        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel84.setForeground(new java.awt.Color(0, 102, 153));
        jLabel84.setText("Section No:");
        jPanel55.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 120, 28));

        jLabel85.setBackground(new java.awt.Color(255, 255, 255));
        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel85.setForeground(new java.awt.Color(0, 102, 153));
        jLabel85.setText("No of Courses:");
        jPanel55.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 130, 28));

        jTextField7.setText(" ");
        jPanel55.add(jTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 120, 30));

        jTextField12.setText(" ");
        jPanel55.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 120, 30));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel55.add(jComboBox6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 60, 150, 30));

        jScrollPane4.setViewportView(jPanel55);

        jPanel54.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 680, 340));

        jLabel86.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel86.setForeground(new java.awt.Color(0, 102, 153));
        jLabel86.setText("Enter Program Name:");
        jPanel54.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 18, 210, 30));

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel54.add(jComboBox7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 200, 30));

        jPanel47.add(jPanel54, "card3");

        jPanel2.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 790, 560));

        Programs.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 1060, -1));

        getContentPane().add(Programs, "card5");

        Courses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Courses.setBackground(new java.awt.Color(0, 102, 153));
        Dashboard_Courses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField13.setText("Search");
        Dashboard_Courses.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 88, 210, 30));

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("View all courses");
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 200, 30));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("   Home");
        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 80, 30));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Delete course");
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 200, 30));

        jLabel65.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("Update course");
        jLabel65.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel65MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 190, 30));

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Add new course");
        jLabel88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel88MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 210, 30));

        jPanel49.add(Dashboard_Courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 560));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new java.awt.CardLayout());

        addCourse.setBackground(new java.awt.Color(255, 255, 255));
        addCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(0, 102, 153));
        jLabel89.setText("Enter Details below");
        addCourse.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 50));

        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(0, 102, 153));
        jLabel90.setText("Course Code:");
        addCourse.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 210, 30));

        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(0, 102, 153));
        jLabel91.setText("Course Title:");
        addCourse.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 210, 30));

        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(0, 102, 153));
        jLabel92.setText("Credit hours:");
        addCourse.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 210, 30));

        crs_code.setForeground(new java.awt.Color(0, 102, 153));
        addCourse.add(crs_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 360, 30));

        title.setForeground(new java.awt.Color(0, 102, 153));
        addCourse.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 360, 30));

        credit_hours.setForeground(new java.awt.Color(0, 102, 153));
        addCourse.add(credit_hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 360, 30));

        labcheckBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox.setText("Lab");
        addCourse.add(labcheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 110, 40));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(0, 102, 153));
        jButton6.setText("save course");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        addCourse.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 200, 60));

        jPanel6.add(addCourse, "card2");

        viewAllCourses.setBackground(new java.awt.Color(255, 255, 255));
        viewAllCourses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(0, 102, 153));
        jLabel67.setText("All courses available:");
        viewAllCourses.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 30));

        coursesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ));
        jScrollPane5.setViewportView(coursesTable);

        viewAllCourses.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 700, 360));

        jPanel6.add(viewAllCourses, "card3");

        delCourse.setBackground(new java.awt.Color(255, 255, 255));
        delCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(0, 102, 153));
        jLabel108.setText("Course Title:");
        delCourse.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 210, 30));

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel109.setForeground(new java.awt.Color(0, 102, 153));
        jLabel109.setText("Course Code:");
        delCourse.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 210, 30));

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 102, 153));
        jLabel110.setText("Enter Details below");
        delCourse.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 50));

        title1.setForeground(new java.awt.Color(0, 102, 153));
        delCourse.add(title1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 360, 30));

        crs_code1.setForeground(new java.awt.Color(0, 102, 153));
        delCourse.add(crs_code1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 360, 30));

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(0, 102, 153));
        jButton15.setText("find");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });
        delCourse.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 110, 30));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(0, 102, 153));
        jButton10.setText("Delete course");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        delCourse.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 460, 200, 60));

        jPanel6.add(delCourse, "card4");

        updateCourse.setBackground(new java.awt.Color(255, 255, 255));
        updateCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        update_coursebtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        update_coursebtn.setForeground(new java.awt.Color(0, 102, 153));
        update_coursebtn.setText("update course");
        update_coursebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_coursebtnActionPerformed(evt);
            }
        });
        updateCourse.add(update_coursebtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 460, 230, 60));

        labcheckBox5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox5.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox5.setText("Lab");
        updateCourse.add(labcheckBox5, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 110, 40));

        credit_hours2.setForeground(new java.awt.Color(0, 102, 153));
        updateCourse.add(credit_hours2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 360, 30));

        title2.setForeground(new java.awt.Color(0, 102, 153));
        updateCourse.add(title2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 360, 30));

        crs_code2.setForeground(new java.awt.Color(0, 102, 153));
        updateCourse.add(crs_code2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 360, 30));

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel111.setForeground(new java.awt.Color(0, 102, 153));
        jLabel111.setText("Course Code:");
        updateCourse.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 210, 30));

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel112.setForeground(new java.awt.Color(0, 102, 153));
        jLabel112.setText("Course Title:");
        updateCourse.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 210, 30));

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel113.setForeground(new java.awt.Color(0, 102, 153));
        jLabel113.setText("Credit hours:");
        updateCourse.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 210, 30));

        jButton17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton17.setForeground(new java.awt.Color(0, 102, 153));
        jButton17.setText("find");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });
        updateCourse.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 110, 30));

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel114.setForeground(new java.awt.Color(0, 102, 153));
        jLabel114.setText("Enter Details below");
        updateCourse.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 50));

        jPanel6.add(updateCourse, "card5");

        jPanel49.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 560));

        Courses.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 550));

        getContentPane().add(Courses, "card5");

        schedule_generation.setBackground(new java.awt.Color(255, 255, 255));
        schedule_generation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Dept1.setBackground(new java.awt.Color(0, 102, 153));
        Dashboard_Dept1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField16.setText("Search");
        Dashboard_Dept1.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 88, 210, 30));

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("   Home");
        jLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel68MouseClicked(evt);
            }
        });
        Dashboard_Dept1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 80, 30));

        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel102.setForeground(new java.awt.Color(255, 255, 255));
        jLabel102.setText("Room");
        jLabel102.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel102MouseClicked(evt);
            }
        });
        Dashboard_Dept1.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 250, 40));

        jPanel23container.add(Dashboard_Dept1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 560));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setLayout(new java.awt.CardLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 102, 153));
        jLabel27.setText("-->");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 500, 50, 40));

        jTextField14.setText("jTextField14");
        jPanel4.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 360, 280, 40));
        jPanel4.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 280, 40));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 153));
        jLabel28.setText("Schedule Generation  Inputs");
        jPanel4.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 280, 70));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 102, 153));
        jLabel29.setText("Working Days Information Panel: ");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 340, 50));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 102, 153));
        jLabel30.setText("No. of Working days:");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 260, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 153));
        jLabel31.setText("Timeslot:");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, 260, 30));

        labcheckBox4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox4.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox4.setText("Monday");
        jPanel5.add(labcheckBox4);

        labcheckBox6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox6.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox6.setText("Tuesday");
        jPanel5.add(labcheckBox6);

        labcheckBox7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox7.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox7.setText("Wednesday");
        jPanel5.add(labcheckBox7);

        labcheckBox8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox8.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox8.setText("Thursday");
        jPanel5.add(labcheckBox8);

        labcheckBox9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox9.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox9.setText("Friday");
        jPanel5.add(labcheckBox9);

        labcheckBox10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox10.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox10.setText("Saturday");
        jPanel5.add(labcheckBox10);

        labcheckBox11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox11.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox11.setText("Sunday");
        jPanel5.add(labcheckBox11);

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 520, 110));

        jPanel24.add(jPanel4, "card2");

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jPanel24.add(jPanel23, "card5");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 780, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );

        jPanel24.add(jPanel7, "card3");

        jPanel23container.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, -1));

        schedule_generation.add(jPanel23container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(schedule_generation, "card7");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setForeground(Color.red) ; 
        
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void programMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programMouseClicked
        this.MainPanel.setVisible(false) ; 
        this.Programs.setVisible(true) ;
        programs_table.setModel(TableViewUtility.resultSetToTableModel(Program.get_all_data_of_programs() ) ) ; 
        
    }//GEN-LAST:event_programMouseClicked

    private void programMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programMouseEntered
        program.setBackground(new Color(0,102,153) );  
        jLabel25.setForeground(new Color(255,255,255) );
//        Border brd = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED) ; 
//        program.setBorder(brd) ; 
    }//GEN-LAST:event_programMouseEntered

    private void courseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseMouseClicked
        MainPanel.setVisible(false) ;   
        Courses.setVisible(true) ;      
    }//GEN-LAST:event_courseMouseClicked

    private void courseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseMouseEntered
        course.setBackground(new Color(0,102,153) );   
        jLabel8.setForeground(new Color(255,255,255) ) ;
    }//GEN-LAST:event_courseMouseEntered

    private void studentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_studentsMouseClicked

    private void studentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_studentsMouseEntered

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseEntered

    private void jLabel10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel10MouseEntered

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
//        this.jTextField1.

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jPanel15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseClicked

    private void jPanel15MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel15MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel15MouseEntered

    private void jPanel17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseClicked

    private void jPanel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel17MouseEntered

    private void jPanel16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseClicked

    private void jPanel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel16MouseEntered

    private void jPanel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseClicked

    private void jPanel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel19MouseEntered

    private void jPanel21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseClicked

    private void jPanel21MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel21MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel21MouseEntered

    private void jPanel20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseClicked

    private void jPanel20MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel20MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel20MouseEntered

    private void jPanel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseClicked

    private void jPanel18MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel18MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel18MouseEntered

    private void jPanel14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseClicked

    private void jPanel14MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel14MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel14MouseEntered

    private void scheduler_generationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduler_generationMouseClicked
        this.MainPanel.setVisible(false) ;
        schedule_generation.setVisible(true); 
    }//GEN-LAST:event_scheduler_generationMouseClicked

    private void scheduler_generationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduler_generationMouseEntered
        scheduler_generation.setBackground(new Color(0,102,153) );  
        jLabel5.setForeground(new Color(255,255,255) );
    }//GEN-LAST:event_scheduler_generationMouseEntered

    private void DeptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeptMouseClicked
        this.Department.setVisible(true) ; 
        this.MainPanel.setVisible(false) ; 
        
        String name = Model.Department.get_department_name() ; 
        dept_name.setText(name);
        
        professorslbl.setText(Professor.get_total_no_of_professors()+"");
        programslbl.setText(Program.get_total_no_of_programs()+"");
        courseslbl.setText(Course.get_total_no_of_courses()+"");
        roomslbl.setText(Room.get_total_no_of_rooms()+"");
        labslbl.setText(Room.get_total_no_of_labs()+"");
        
    }//GEN-LAST:event_DeptMouseClicked

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jLabel57MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel57MouseClicked
        this.jPanel46.setVisible(true); 
        this.all_programs_panel.setVisible(false);
    }//GEN-LAST:event_jLabel57MouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        this.MainPanel.setVisible(true);  
        this.Programs.setVisible(false) ; 
    }//GEN-LAST:event_jLabel50MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        this.jPanel50.setVisible(true) ;          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel51MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel51MouseClicked
        this.all_programs_panel.setVisible(true); 
//        programs_table
    }//GEN-LAST:event_jLabel51MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed
    public boolean isInteger(String str){
        try { 
        Integer.parseInt(str); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    // only got here if we didn't return false
    return true;
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String course_code = crs_code.getText();
        String crs_title = title.getText();
        String crs_hours = credit_hours.getText();
        if(!isInteger(crs_hours)){
            JOptionPane.showMessageDialog(null, "Enter credit hours correctly") ; 
        }
        else{
            int hours = Integer.parseInt(crs_hours) ; 
            boolean haslab = labcheckBox.isSelected();

            if(! Course.check_duplication_in_database(course_code, crs_title) ) { 
                Course.add_Course_in_database(course_code, crs_title, hours, haslab) ; 
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jLabel88MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel88MouseClicked
        viewAllCourses.setVisible(false); 
        addCourse.setVisible(true);
        delCourse.setVisible(false);
    }//GEN-LAST:event_jLabel88MouseClicked

    private void jLabel42MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel42MouseClicked
        // TODO add your handling code here:
        this.MainPanel.setVisible(true);  
        this.Department.setVisible(false) ; 
        this.Courses.setVisible(false); 
        
    }//GEN-LAST:event_jLabel42MouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void add_roombtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_roombtnActionPerformed
        String rm_name = roomname.getText().trim() ; 
        int rm_capacity = Integer.parseInt( capacity.getText().trim() ) ; 
        boolean isLab = labcheckBox2.isSelected();
        Room.add_room(rm_name,rm_capacity,isLab) ;
    }//GEN-LAST:event_add_roombtnActionPerformed

    private void view_labsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_labsbtnActionPerformed
        // TODO add your handling code here:
        dept_details_panel.setVisible(false);
        viewData.setVisible(true); 
        display_table.setModel(TableViewUtility.resultSetToTableModel(Room.get_all_labs()) ) ;        
        
    }//GEN-LAST:event_view_labsbtnActionPerformed

    private void view_roomsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_roomsbtnActionPerformed
        dept_details_panel.setVisible(false); 
        viewData.setVisible(true); 
        display_table.setModel(TableViewUtility.resultSetToTableModel(Room.get_all_rooms()) ) ; 
    }//GEN-LAST:event_view_roomsbtnActionPerformed

    private void view_programsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_programsbtnActionPerformed
        dept_details_panel.setVisible(false);
        viewData.setVisible(true); 
        display_table.setModel(TableViewUtility.resultSetToTableModel(Program.get_all_programs()) ) ;        
        
    }//GEN-LAST:event_view_programsbtnActionPerformed

    private void view_facultybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_facultybtnActionPerformed
        dept_details_panel.setVisible(false);
        viewData.setVisible(true); 
        display_table.setModel(TableViewUtility.resultSetToTableModel(Professor.get_all_professors())) ;        

    }//GEN-LAST:event_view_facultybtnActionPerformed

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        dept_details_panel.setVisible(true);
        
    }//GEN-LAST:event_jLabel47MouseClicked

    private void view_coursesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_coursesbtnActionPerformed
        dept_details_panel.setVisible(false); 
        viewData.setVisible(true);
        display_table.setModel(TableViewUtility.resultSetToTableModel(Course.get_all_courses())) ;        
    }//GEN-LAST:event_view_coursesbtnActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        String code = crs_code1.getText().trim() ;
        String title = title1.getText() ;
//        If(code){
//            
//        }
        
        Course crs_by_title=null;
        Course crs_by_code = null;
        if(code.equalsIgnoreCase("")){
            crs_by_title = Course.get_course_by_title(title);            
        }
        else if(title.equalsIgnoreCase("")){
            crs_by_code = Course.getCourse(code); 
        }
        
        if(crs_by_code == null ) { 
            JOptionPane.showMessageDialog(null , "No course found with this code"  ) ; 
        } 
        else{
//            title1.setText(.getTitle() ) ; 
            crs_code1.setText(code) ; 
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String code = crs_code1.getText().trim() ; 
        String title = title1.getText() ; 
        String query = "delete from course where course_code = ?" ; 
        try
        {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query) ;
            stmt1.setString(1, code); 
            int rowCount = stmt1.executeUpdate();
            if(rowCount==0){
                JOptionPane.showMessageDialog(null, "This Course doesn't exists in database."
                    + " Row Count returned is  "+rowCount) ; 
            }
            else{
                JOptionPane.showMessageDialog(null, "Course is deleted successfully."
                    + " Row Count returned is  "+rowCount);    
            }
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Error in deleting the course", "Table", JOptionPane.ERROR_MESSAGE) ; 
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        viewAllCourses.setVisible(true); 
        addCourse.setVisible(false);
        delCourse.setVisible(false);
        updateCourse.setVisible(false); 

        coursesTable.setModel(TableViewUtility.resultSetToTableModel(Course.get_all_courses()) ) ; 
        
        // get data of all Courses;
        
    }//GEN-LAST:event_jLabel55MouseClicked

    private void jLabel65MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel65MouseClicked
        viewAllCourses.setVisible(false); 
        addCourse.setVisible(false);
        delCourse.setVisible(false); 
        updateCourse.setVisible(true); 
    }//GEN-LAST:event_jLabel65MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseClicked

    private void update_coursebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_coursebtnActionPerformed
        String code = crs_code2.getText().trim();
//        Course
    }//GEN-LAST:event_update_coursebtnActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        viewAllCourses.setVisible(false); 
        addCourse.setVisible(false);
        updateCourse.setVisible(false); 
        delCourse.setVisible(true); 
    }//GEN-LAST:event_jLabel63MouseClicked

    private void jLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel56MouseClicked
        this.MainPanel.setVisible(true);  
        this.Department.setVisible(false) ; 
        this.Courses.setVisible(false); 
    }//GEN-LAST:event_jLabel56MouseClicked

    private void datesheet_generationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datesheet_generationMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_datesheet_generationMouseClicked

    private void datesheet_generationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datesheet_generationMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_datesheet_generationMouseEntered

    private void programMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programMouseExited
        program.setBackground(new Color(255,255,255) );   
        jLabel25.setForeground(new Color(0,102,153) ) ; 
        
    }//GEN-LAST:event_programMouseExited

    private void DeptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeptMouseEntered
        Dept.setBackground(new Color(0,102,153) );  
        jLabel6.setForeground(new Color(255,255,255) );
    }//GEN-LAST:event_DeptMouseEntered

    private void DeptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeptMouseExited
        Dept.setBackground(new Color(255,255,255) );   
        jLabel6.setForeground(new Color(0,102,153) ) ;
    }//GEN-LAST:event_DeptMouseExited

    private void courseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseMouseExited
        course.setBackground(new Color(255,255,255) );   
        jLabel8.setForeground(new Color(0,102,153) ) ;
    }//GEN-LAST:event_courseMouseExited

    private void add_roomlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_roomlblMouseClicked
        add_room.setVisible(true) ;
        dept_details_panel.setVisible(false); 
        viewData.setVisible(false);
        delete_room.setVisible(false); 
    }//GEN-LAST:event_add_roomlblMouseClicked

    private void view_all_roomslblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_all_roomslblMouseClicked
        add_room.setVisible(false) ;
        dept_details_panel.setVisible(false); 
        viewData.setVisible(true); 
        display_table.setModel(TableViewUtility.resultSetToTableModel(Room.get_every_room() )) ; 
    }//GEN-LAST:event_view_all_roomslblMouseClicked

    private void find_del_panelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_find_del_panelbtnActionPerformed
        String room_name = room_name1.getText().trim() ; 
        String req_name = Room.search_room(room_name) ;
        if(req_name !=null ) {  
            JOptionPane.showMessageDialog(null, "Room found"); 
        }
//        else{ 
//            JOptionPane.showMessageDialog(null, "Room did not found"); 
//        }
    }//GEN-LAST:event_find_del_panelbtnActionPerformed

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        String room_name = room_name1.getText().trim() ; 
        if(Room.remove_room(room_name)){ 
            JOptionPane.showMessageDialog(null, "Room removed successfully"); 
            room_name1.setText(null);
        }
    }//GEN-LAST:event_delbtnActionPerformed

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        delete_room.setVisible(true); 
        add_room.setVisible(false) ;
        dept_details_panel.setVisible(false); 
        viewData.setVisible(false);
    }//GEN-LAST:event_jLabel48MouseClicked

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        // query for viewing scheduling of a room accordingly
        
//        viewData.setVisible(true); 
//        display_table.setModel(TableViewUtility.resultSetToTableModel(Room.get_every_room()) ) ; 
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel68MouseClicked
        this.MainPanel.setVisible(true);  
        this.Department.setVisible(false) ; 
        this.Courses.setVisible(false); 
        this.schedule_generation.setVisible(false); 
    }//GEN-LAST:event_jLabel68MouseClicked

    private void jLabel102MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel102MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel102MouseClicked

    private void scheduler_generationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduler_generationMouseExited
        scheduler_generation.setBackground(new Color(255,255,255) );  
        jLabel5.setForeground(new Color(0,102,153) ) ; 
    }//GEN-LAST:event_scheduler_generationMouseExited

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Courses;
    private javax.swing.JPanel Dashboard_Courses;
    private javax.swing.JPanel Dashboard_Dept;
    private javax.swing.JPanel Dashboard_Dept1;
    private javax.swing.JPanel Dashboard_Programs;
    private javax.swing.JPanel Department;
    private javax.swing.JPanel Dept;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JPanel Programs;
    private javax.swing.JPanel addCourse;
    private javax.swing.JPanel add_room;
    private javax.swing.JButton add_roombtn;
    private javax.swing.JLabel add_roomlbl;
    private javax.swing.JPanel all_programs_panel;
    private javax.swing.JLabel available_datalbl;
    private javax.swing.JTextField capacity;
    private javax.swing.JPanel course;
    private javax.swing.JTable coursesTable;
    private javax.swing.JLabel courseslbl;
    private javax.swing.JTextField credit_hours;
    private javax.swing.JTextField credit_hours2;
    private javax.swing.JTextField crs_code;
    private javax.swing.JTextField crs_code1;
    private javax.swing.JTextField crs_code2;
    private javax.swing.JPanel datesheet_generation;
    private javax.swing.JPanel delCourse;
    private javax.swing.JButton delbtn;
    private javax.swing.JPanel delete_room;
    private javax.swing.JPanel dept_details_panel;
    private javax.swing.JLabel dept_name;
    private javax.swing.JTable display_table;
    private javax.swing.JButton find_del_panelbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel23container;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel46;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JCheckBox labcheckBox;
    private javax.swing.JCheckBox labcheckBox1;
    private javax.swing.JCheckBox labcheckBox10;
    private javax.swing.JCheckBox labcheckBox11;
    private javax.swing.JCheckBox labcheckBox2;
    private javax.swing.JCheckBox labcheckBox3;
    private javax.swing.JCheckBox labcheckBox4;
    private javax.swing.JCheckBox labcheckBox5;
    private javax.swing.JCheckBox labcheckBox6;
    private javax.swing.JCheckBox labcheckBox7;
    private javax.swing.JCheckBox labcheckBox8;
    private javax.swing.JCheckBox labcheckBox9;
    private javax.swing.JLabel labslbl;
    private javax.swing.JLabel professorslbl;
    private javax.swing.JPanel program;
    private javax.swing.JTable programs_table;
    private javax.swing.JLabel programslbl;
    private javax.swing.JTextField room_name1;
    private javax.swing.JTextField roomname;
    private javax.swing.JLabel roomslbl;
    private javax.swing.JPanel schedule_generation;
    private javax.swing.JPanel scheduler_generation;
    private javax.swing.JPanel students;
    private javax.swing.JTextField title;
    private javax.swing.JTextField title1;
    private javax.swing.JTextField title2;
    private javax.swing.JPanel updateCourse;
    private javax.swing.JButton update_coursebtn;
    private javax.swing.JPanel viewAllCourses;
    private javax.swing.JPanel viewData;
    private javax.swing.JLabel view_all_roomslbl;
    private javax.swing.JButton view_coursesbtn;
    private javax.swing.JButton view_facultybtn;
    private javax.swing.JButton view_labsbtn;
    private javax.swing.JButton view_programsbtn;
    private javax.swing.JButton view_roomsbtn;
    // End of variables declaration//GEN-END:variables
}
