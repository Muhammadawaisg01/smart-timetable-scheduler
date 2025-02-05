package View;

import Model.Course;
import Model.professor.Professor;
import Model.Program;
import Model.Queries;
import Model.room.Room;
import View.room.search_by_capacity;
import static View.section.create_section_panel.getPrograms;
import static View.section.create_section_panel.getCourses;
import View.section.remove_section_panel;
import static View.section.view_section_details_option_panel.init;
import View.student.update_regular_section;
import View.student.view_all_students_panel;
import View.student.view_student_details_panel;
import View.viewtimetable_panel.view_generated_timetable_panel;
import static db.DBConnection.createConnection;
import static db.DBConnection.getConnection;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import View.viewtimetable_panel.search_for_specific_entity;
import View.viewtimetable_panel.view_schedule;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import static View.viewtimetable_panel.View_all_clashes_panel.entity_name;
import colors.Gradient;
//import colors.Gradient;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Paint;
import java.sql.ResultSet;
import javax.swing.DefaultComboBoxModel;

public class MainFrame extends javax.swing.JFrame implements Panels_Management {

    private static int slotNum = 1;
    private static int numberOfDays = 0;

    public MainFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        createConnection();
        add_all_panels_of_programs_to_list();
        add_all_panels_of_department_to_list();
        add_all_panels_of_students_to_list();
        add_all_panels_of_courses_to_list();
        add_all_panels_of_view_timetable_to_list();
        add_all_panels_of_schedule_generation_to_list();
    }

//    class Gradient extends JPanel {
//
//        protected void paintPanel(Graphics g) {
//            Graphics2D g2d = (Graphics2D) g;
//            int width = getWidth();
//            int height = getHeight();
//            Color c1 = new Color(52, 143, 80);
//            Color c2 = new Color(86, 180, 211);
//            GradientPaint gp = new GradientPaint(0, 0, c1, 180, height, c2);
//            g2d.setPaint(gp);
//            g2d.fillRect(0, 0, width, height);
//        }
//    }

    // These array consists of all panels in the different option on the MainPanel 
    ArrayList<JPanel> programs_panels_list = new ArrayList<>();
    ArrayList<JPanel> department_panels_list = new ArrayList<>();
    ArrayList<JPanel> view_timetable_panels_list = new ArrayList<>();
    ArrayList<JPanel> students_panels_list = new ArrayList<>();
    ArrayList<JPanel> courses_panels_list = new ArrayList<>();
    ArrayList<JPanel> schedule_generation_panels_list = new ArrayList<>();

    // Implementing Methods of Panels Management section
    @Override
    public void add_all_panels_of_programs_to_list() {
        programs_panels_list.add(create_section_panel1);
        programs_panels_list.add(view_section_details_option_panel1);
        programs_panels_list.add(view_section_details_panel1);
//        programs_panels_list.add(add_new_semester_panel1);
        programs_panels_list.add(update_section_panel1);
        programs_panels_list.add(all_programs_details_panel);
        programs_panels_list.add(remove_section_panel1);
        programs_panels_list.add(add_new_program);
        programs_panels_list.add(view_schedule_of_section1);
        programs_panels_list.add(professor_course_allocation1);
    }

    @Override
    public void add_all_panels_of_department_to_list() {
        department_panels_list.add(room_input_panel1);
        department_panels_list.add(search_free_slot_panel1);
        department_panels_list.add(add_professor_panel1);
        department_panels_list.add(view_schedule_panel1);
        department_panels_list.add(view_schedule_panel2);
        department_panels_list.add(dept_details_panel);
        department_panels_list.add(viewData);
        department_panels_list.add(room_details);
    }

    @Override
    public void add_all_panels_of_students_to_list() {

        students_panels_list.add(update_section1);
//        students_panels_list.add(view_all_students_panel);

        students_panels_list.add(view_student_details_panel1);
    }

    @Override
    public void add_all_panels_of_courses_to_list() {
        courses_panels_list.add(addCourse);
        courses_panels_list.add(viewAllCourses);
        courses_panels_list.add(delCourse);
    }

    @Override
    public void add_all_panels_of_view_timetable_to_list() {
        view_timetable_panels_list.add(view_generated_timetable_panel1);
        view_timetable_panels_list.add(view_all_clashes_panel1);

    }

    @Override
    public void add_all_panels_of_schedule_generation_to_list() {
        schedule_generation_panels_list.add(excel_file_panel1);
        schedule_generation_panels_list.add(first_panel1);
        schedule_generation_panels_list.add(first_panel_part21);
        schedule_generation_panels_list.add(second_panel1);
        schedule_generation_panels_list.add(third_panel1);
        schedule_generation_panels_list.add(final_panel1);
    }

    @Override
    public void programs_panel_visibility(JPanel panel) {
        for (int i = 0; i < programs_panels_list.size(); i++) {
            if (programs_panels_list.get(i) == panel) {
                programs_panels_list.get(i).setVisible(true);
            } else {
                programs_panels_list.get(i).setVisible(false);
            }
        }
    }

    @Override
    public void department_panel_visibility(JPanel panel) {
        for (int i = 0; i < department_panels_list.size(); i++) {
            if (department_panels_list.get(i) == panel) {
                department_panels_list.get(i).setVisible(true);
            } else {
                department_panels_list.get(i).setVisible(false);
            }
        }
    }

    @Override
    public void students_panel_visibility(JPanel panel) {
        for (int i = 0; i < students_panels_list.size(); i++) {
            if (students_panels_list.get(i) == panel) {
                students_panels_list.get(i).setVisible(true);
            } else {
                students_panels_list.get(i).setVisible(false);
            }
        }
    }

    @Override
    public void courses_panel_visibility(JPanel panel) {
        for (int i = 0; i < courses_panels_list.size(); i++) {
            if (courses_panels_list.get(i) == panel) {
                courses_panels_list.get(i).setVisible(true);
            } else {
                courses_panels_list.get(i).setVisible(false);
            }
        }
    }

    @Override
    public void view_timetable_panel_visibility(JPanel panel) {
        for (int i = 0; i < view_timetable_panels_list.size(); i++) {
            if (view_timetable_panels_list.get(i) == panel) {
                view_timetable_panels_list.get(i).setVisible(true);
            } else {
                view_timetable_panels_list.get(i).setVisible(false);
            }
        }
    }

    @Override
    public void schedule_generation_panel_visibility(JPanel panel) {
        for (int i = 0; i < schedule_generation_panels_list.size(); i++) {
            if (schedule_generation_panels_list.get(i) == panel) {
                schedule_generation_panels_list.get(i).setVisible(true);
            } else {
                schedule_generation_panels_list.get(i).setVisible(false);
            }
        }
    }

    //      PANELS MANAGEMENT Ends Here, all methods of the interface panels management are implemented in above section
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        MainPanel = new javax.swing.JPanel();
        MainPanel_ScrollPane = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        program = new JPanel();
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
        students = new JPanel();
        std_label = new javax.swing.JLabel();
        Dept = new JPanel();
        jLabel6 = new javax.swing.JLabel();
        course = new JPanel();
        jLabel8 = new javax.swing.JLabel();
        datesheet = new JPanel();
        jLabel7 = new javax.swing.JLabel();
        scheduler_generation = new JPanel();
        jLabel5 = new javax.swing.JLabel();
        view_timetable = new JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        welcome_window = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        dept_name_panel = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        nxt_lbl_1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        dep_name = new javax.swing.JTextField();
        working_days_panel = new javax.swing.JPanel();
        back_lbl_1 = new javax.swing.JLabel();
        nxt_lbl_2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        tues = new javax.swing.JCheckBox();
        jLabel32 = new javax.swing.JLabel();
        wed = new javax.swing.JCheckBox();
        thurs = new javax.swing.JCheckBox();
        fri = new javax.swing.JCheckBox();
        sat = new javax.swing.JCheckBox();
        sun = new javax.swing.JCheckBox();
        mon = new javax.swing.JCheckBox();
        jLabel33 = new javax.swing.JLabel();
        timeslots_panel = new javax.swing.JPanel();
        back_lbl_02 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        jPanel11 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        start = new cambodia.raven.Time();
        jScrollPane4 = new javax.swing.JScrollPane();
        slot_preview = new javax.swing.JTextArea();
        add_button1 = new javax.swing.JButton();
        end = new cambodia.raven.Time();
        jLabel38 = new javax.swing.JLabel();
        sv_btn1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Department = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        Dashboard_Dept = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jPanel12 = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        add_roomlbl1 = new javax.swing.JLabel();
        all_rooms = new javax.swing.JLabel();
        add_roomlbl = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        search_slot_lbl = new javax.swing.JLabel();
        all_labs_lbl = new javax.swing.JLabel();
        view_all_roomslbl1 = new javax.swing.JLabel();
        view_all_faculty = new javax.swing.JLabel();
        add_new_professor = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        room_input_panel1 = new View.room.room_input_panel();
        view_schedule_panel1 = new View.room.view_schedule_panel();
        view_schedule_panel2 = new View.professor.view_schedule_of_professor_panel();
        add_professor_panel1 = new View.professor.add_professor_panel();
        search_free_slot_panel1 = new View.room.search_free_slot_panel();
        dept_details_panel = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        dept_name = new javax.swing.JLabel();
        programslbl = new javax.swing.JLabel();
        jLabel99 = new javax.swing.JLabel();
        jLabel100 = new javax.swing.JLabel();
        roomslbl = new javax.swing.JLabel();
        labslbl = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        professorslbl = new javax.swing.JLabel();
        view_labsbtn = new javax.swing.JButton();
        view_roomsbtn = new javax.swing.JButton();
        view_programsbtn = new javax.swing.JButton();
        view_facultybtn = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        courseslbl = new javax.swing.JLabel();
        view_coursesbtn = new javax.swing.JButton();
        viewData = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        display_table = new javax.swing.JTable();
        available_datalbl = new javax.swing.JLabel();
        room_details = new javax.swing.JPanel();
        jLabel97 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        delbtn = new javax.swing.JButton();
        jLabel101 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel104 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        Programs = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Dashboard_Programs = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jPanel28 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        jLabel120 = new javax.swing.JLabel();
        jLabel121 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        UpdateSection = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jPanel47 = new javax.swing.JPanel();
        all_programs_details_panel = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        programs_table = new javax.swing.JTable();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        create_section_panel1 = new View.section.create_section_panel();
        add_new_program1 = new View.section.add_new_program();
        view_section_details_panel1 = new View.section.view_section_details_panel();
        remove_section_panel1 = new View.section.remove_section_panel();
        update_section_panel1 = new View.section.update_section_panel();
        view_schedule_of_section1 = new View.section.view_schedule_of_section();
        professor_course_allocation1 = new View.section.Professor_course_allocation();
        add_new_program = new View.section.add_new_program();
        view_section_details_option_panel1 = new View.section.view_section_details_option_panel();
        Courses = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        Dashboard_Courses = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
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
        jLabel110 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        course_title_dropdown = new javax.swing.JComboBox<>();
        jScrollPane15 = new javax.swing.JScrollPane();
        course_details_textarea = new javax.swing.JTextArea();
        schedule_generation = new javax.swing.JPanel();
        jPanel23container = new javax.swing.JPanel();
        Dashboard_Dept1 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        excel_file_panel1 = new View.schedule_generation.excel_file_panel();
        first_panel1 = new View.schedule_generation.first_panel();
        first_panel_part21 = new View.schedule_generation.first_panel_part2();
        second_panel1 = new View.schedule_generation.second_panel();
        third_panel1 = new View.schedule_generation.third_panel();
        final_panel1 = new View.schedule_generation.final_panel();
        timetable_management = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        Dashboard_timetable = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        room_wise_lbl = new javax.swing.JLabel();
        clash_lbl = new javax.swing.JLabel();
        professor_clasheslbl = new javax.swing.JLabel();
        section_wise_lbl = new javax.swing.JLabel();
        professor_wise_lbl = new javax.swing.JLabel();
        std_wise_lbl = new javax.swing.JLabel();
        student_clasheslbl = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jPanel26 = new javax.swing.JPanel();
        view_generated_timetable_panel1 = new View.viewtimetable_panel.view_generated_timetable_panel();
        view_all_clashes_panel1 = new View.viewtimetable_panel.View_all_clashes_panel();
        students_management = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        Dashboard_std_management = new javax.swing.JPanel();
        home_std_lbl = new javax.swing.JLabel();
        update_section_lbl = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        view_student_details_panel1 = new View.student.view_student_details_panel();
        update_section1 = new View.student.update_section();
        datesheet_generation = new javax.swing.JPanel();
        jPanel23container1 = new javax.swing.JPanel();
        Dashboard_Datesheet = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        jPanel29 = new javax.swing.JPanel();
        excel_file_panel2 = new View.schedule_generation.excel_file_panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        MainPanel.setBackground(new java.awt.Color(50, 50, 50));
        MainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        MainPanel_ScrollPane.setBorder(null);

        jPanel9.setBackground(new java.awt.Color(50, 50, 50));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        program.setBackground(new java.awt.Color(204, 204, 204));
        program.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        program.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        program.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                programMouseClicked(evt);
            }
        });
        program.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Programs");
        program.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, 30));

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

        jPanel9.add(program, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, 350, 50));

        students.setBackground(new java.awt.Color(204, 204, 204));
        students.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        students.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                student_mouse_entered(evt);
            }
        });
        students.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        std_label.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        std_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        std_label.setText("Students");
        students.add(std_label, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, 30));

        jPanel9.add(students, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 200, 350, 50));

        Dept.setBackground(new java.awt.Color(204, 204, 204));
        Dept.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        Dept.setForeground(new java.awt.Color(102, 102, 102));
        Dept.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Dept.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DeptMouseClicked(evt);
            }
        });
        Dept.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Department");
        Dept.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, -1));

        jPanel9.add(Dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 80, 350, 50));

        course.setBackground(new java.awt.Color(204, 204, 204));
        course.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        course.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        course.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseMouseClicked(evt);
            }
        });
        course.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Courses");
        course.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, -1));

        jPanel9.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 140, 350, 50));

        datesheet.setBackground(new java.awt.Color(204, 204, 204));
        datesheet.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        datesheet.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        datesheet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datesheetMouseClicked(evt);
            }
        });
        datesheet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Datesheet Generation");
        datesheet.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, -1));

        jPanel9.add(datesheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 440, 350, 50));

        scheduler_generation.setBackground(new java.awt.Color(204, 204, 204));
        scheduler_generation.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        scheduler_generation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        scheduler_generation.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scheduler_generationMouseClicked(evt);
            }
        });
        scheduler_generation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Schedule Generation");
        scheduler_generation.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, -1));

        jPanel9.add(scheduler_generation, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, 350, 50));

        view_timetable.setBackground(new java.awt.Color(204, 204, 204));
        view_timetable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        view_timetable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_timetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_timetableMouseClicked(evt);
            }
        });
        view_timetable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("View Timetable");
        view_timetable.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 350, -1));

        jPanel9.add(view_timetable, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 320, 350, 50));

        jPanel4.setBackground(new java.awt.Color(50, 50, 50));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        jPanel9.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 10, 420));

        jTextArea2.setEditable(false);
        jTextArea2.setBackground(new java.awt.Color(80, 80, 80));
        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jTextArea2.setForeground(new java.awt.Color(255, 255, 255));
        jTextArea2.setRows(5);
        jTextArea2.setText("                    \n                An application designed for the \n                           purpose of generating a \n                          comprehensive timetable \n                              for the students of CUI.");
        jTextArea2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 50, 50)));
        jScrollPane2.setViewportView(jTextArea2);

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 360, 170));

        MainPanel_ScrollPane.setViewportView(jPanel9);

        MainPanel.add(MainPanel_ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1010, 450));

        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 42)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Smart Time-Table Scheduler");
        jLabel2.setToolTipText("Logo");
        jLabel2.setAlignmentX(0.5F);
        jLabel2.setAutoscrolls(true);
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });
        MainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 1010, 50));

        getContentPane().add(MainPanel, "card2");

        welcome_window.setLayout(new java.awt.CardLayout());

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.CardLayout());

        dept_name_panel.setBackground(new java.awt.Color(255, 255, 255));
        dept_name_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 102, 153));
        jLabel11.setText("Enter name of your department:");
        jLabel11.setToolTipText("Logo");
        jLabel11.setAlignmentX(0.5F);
        jLabel11.setAutoscrolls(true);
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel11MouseEntered(evt);
            }
        });
        dept_name_panel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 340, 70));

        nxt_lbl_1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nxt_lbl_1.setForeground(new java.awt.Color(0, 102, 153));
        nxt_lbl_1.setText("-->");
        nxt_lbl_1.setToolTipText("Logo");
        nxt_lbl_1.setAlignmentX(0.5F);
        nxt_lbl_1.setAutoscrolls(true);
        nxt_lbl_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nxt_lbl_1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nxt_lbl_1MouseEntered(evt);
            }
        });
        dept_name_panel.add(nxt_lbl_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 480, 70, 70));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 102, 153));
        jLabel13.setText("Department Details:");
        jLabel13.setToolTipText("Logo");
        jLabel13.setAlignmentX(0.5F);
        jLabel13.setAutoscrolls(true);
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel13MouseEntered(evt);
            }
        });
        dept_name_panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 270, 70));

        dep_name.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        dep_name.setForeground(new java.awt.Color(0, 102, 153));
        dept_name_panel.add(dep_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 170, 660, 60));

        jPanel8.add(dept_name_panel, "card2");

        working_days_panel.setBackground(new java.awt.Color(255, 255, 255));
        working_days_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_lbl_1.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        back_lbl_1.setForeground(new java.awt.Color(0, 102, 153));
        back_lbl_1.setText("<--");
        back_lbl_1.setToolTipText("Logo");
        back_lbl_1.setAlignmentX(0.5F);
        back_lbl_1.setAutoscrolls(true);
        back_lbl_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_lbl_1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back_lbl_1MouseEntered(evt);
            }
        });
        working_days_panel.add(back_lbl_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 70, 60));

        nxt_lbl_2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        nxt_lbl_2.setForeground(new java.awt.Color(0, 102, 153));
        nxt_lbl_2.setText("-->");
        nxt_lbl_2.setToolTipText("Logo");
        nxt_lbl_2.setAlignmentX(0.5F);
        nxt_lbl_2.setAutoscrolls(true);
        nxt_lbl_2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nxt_lbl_2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nxt_lbl_2MouseEntered(evt);
            }
        });
        working_days_panel.add(nxt_lbl_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 500, 70, 60));

        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tues.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        tues.setForeground(new java.awt.Color(0, 102, 153));
        tues.setText("Tuesday");
        tues.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tuesActionPerformed(evt);
            }
        });
        jPanel10.add(tues, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, 40));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 102, 153));
        jLabel32.setText("Select the days in which lectures will be conducted");
        jLabel32.setToolTipText("Logo");
        jLabel32.setAlignmentX(0.5F);
        jLabel32.setAutoscrolls(true);
        jLabel32.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel32MouseEntered(evt);
            }
        });
        jPanel10.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 560, 70));

        wed.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        wed.setForeground(new java.awt.Color(0, 102, 153));
        wed.setText("Wednesday");
        wed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wedActionPerformed(evt);
            }
        });
        jPanel10.add(wed, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, 40));

        thurs.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        thurs.setForeground(new java.awt.Color(0, 102, 153));
        thurs.setText("Thursday");
        thurs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thursActionPerformed(evt);
            }
        });
        jPanel10.add(thurs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, -1, 40));

        fri.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        fri.setForeground(new java.awt.Color(0, 102, 153));
        fri.setText("Friday");
        fri.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                friActionPerformed(evt);
            }
        });
        jPanel10.add(fri, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, 40));

        sat.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        sat.setForeground(new java.awt.Color(0, 102, 153));
        sat.setText("Saturday");
        sat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satActionPerformed(evt);
            }
        });
        jPanel10.add(sat, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, 40));

        sun.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        sun.setForeground(new java.awt.Color(0, 102, 153));
        sun.setText("Sunday");
        sun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sunActionPerformed(evt);
            }
        });
        jPanel10.add(sun, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, 40));

        mon.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        mon.setForeground(new java.awt.Color(0, 102, 153));
        mon.setText("Monday");
        mon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monActionPerformed(evt);
            }
        });
        jPanel10.add(mon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, 40));

        working_days_panel.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 610, 360));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 102, 153));
        jLabel33.setText("Working Days Panel");
        jLabel33.setToolTipText("Logo");
        jLabel33.setAlignmentX(0.5F);
        jLabel33.setAutoscrolls(true);
        jLabel33.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel33MouseEntered(evt);
            }
        });
        working_days_panel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 270, 70));

        jPanel8.add(working_days_panel, "card3");

        timeslots_panel.setBackground(new java.awt.Color(255, 255, 255));
        timeslots_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back_lbl_02.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        back_lbl_02.setForeground(new java.awt.Color(0, 102, 153));
        back_lbl_02.setText("<--");
        back_lbl_02.setToolTipText("Logo");
        back_lbl_02.setAlignmentX(0.5F);
        back_lbl_02.setAutoscrolls(true);
        back_lbl_02.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                back_lbl_02MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                back_lbl_02MouseEntered(evt);
            }
        });
        timeslots_panel.add(back_lbl_02, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 70, 70));

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(0, 102, 153));
        jLabel34.setText("create timeslots for timetable in which classes will be conducted");
        jLabel34.setToolTipText("Logo");
        jLabel34.setAlignmentX(0.5F);
        jLabel34.setAutoscrolls(true);
        jLabel34.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel34MouseEntered(evt);
            }
        });
        jPanel11.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 660, 50));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(0, 102, 153));
        jLabel37.setText("End Duration:");
        jLabel37.setToolTipText("Logo");
        jLabel37.setAlignmentX(0.5F);
        jLabel37.setAutoscrolls(true);
        jLabel37.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel37MouseEntered(evt);
            }
        });
        jPanel11.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 160, 50));

        jLabel40.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 153));
        jLabel40.setText("Start Duration:");
        jLabel40.setToolTipText("Logo");
        jLabel40.setAlignmentX(0.5F);
        jLabel40.setAutoscrolls(true);
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel40MouseEntered(evt);
            }
        });
        jPanel11.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 160, 50));
        jPanel11.add(start, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 120, 70));

        slot_preview.setColumns(20);
        slot_preview.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        slot_preview.setForeground(new java.awt.Color(0, 102, 153));
        slot_preview.setRows(5);
        slot_preview.setText("Timeslot preview");
        slot_preview.setEnabled(false);
        jScrollPane4.setViewportView(slot_preview);

        jPanel11.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 640, 120));

        add_button1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add_button1.setForeground(new java.awt.Color(0, 102, 153));
        add_button1.setText("Add");
        add_button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_button1ActionPerformed(evt);
            }
        });
        jPanel11.add(add_button1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 100, 40));
        jPanel11.add(end, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 130, -1, -1));

        jScrollPane7.setViewportView(jPanel11);

        timeslots_panel.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 680, 420));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 102, 153));
        jLabel38.setText("Timeslots instruction Panel");
        jLabel38.setToolTipText("Logo");
        jLabel38.setAlignmentX(0.5F);
        jLabel38.setAutoscrolls(true);
        jLabel38.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel38MouseEntered(evt);
            }
        });
        timeslots_panel.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 300, 60));

        sv_btn1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        sv_btn1.setForeground(new java.awt.Color(0, 102, 153));
        sv_btn1.setText("NEXT");
        sv_btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sv_btn1ActionPerformed(evt);
            }
        });
        timeslots_panel.add(sv_btn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 520, 150, 40));

        jPanel8.add(timeslots_panel, "card4");

        welcome_window.add(jPanel8, "card2");

        getContentPane().add(welcome_window, "card8");

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
                .addContainerGap(369, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, "card2");

        Department.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel45.setBackground(new java.awt.Color(0, 0, 0));
        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Dept.setBackground(new java.awt.Color(0, 0, 0));
        Dashboard_Dept.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setBackground(new java.awt.Color(0, 0, 0));
        jLabel42.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel42.setText("   <- R e t u r n");
        jLabel42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        Dashboard_Dept.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 110));

        jPanel12.setBackground(new java.awt.Color(0, 0, 0));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Department");
        jLabel47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 250, 50));

        add_roomlbl1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        add_roomlbl1.setForeground(new java.awt.Color(0, 102, 153));
        add_roomlbl1.setText("  Rooms                 ");
        add_roomlbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        add_roomlbl1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel12.add(add_roomlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 270, 40));

        all_rooms.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        all_rooms.setForeground(new java.awt.Color(255, 255, 255));
        all_rooms.setText("View All Rooms");
        all_rooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        all_rooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_roomsMouseClicked(evt);
            }
        });
        jPanel12.add(all_rooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 250, 40));

        add_roomlbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        add_roomlbl.setForeground(new java.awt.Color(255, 255, 255));
        add_roomlbl.setText("Add New Room");
        add_roomlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_roomlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_roomlblMouseClicked(evt);
            }
        });
        jPanel12.add(add_roomlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 250, 40));

        jLabel44.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 102, 153));
        jLabel44.setText("  Labs            ");
        jLabel44.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel44.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel12.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 260, 40));

        search_slot_lbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        search_slot_lbl.setForeground(new java.awt.Color(255, 255, 255));
        search_slot_lbl.setText("Search Free Slot");
        search_slot_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search_slot_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_slot_lblMouseClicked(evt);
            }
        });
        jPanel12.add(search_slot_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 250, 40));

        all_labs_lbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        all_labs_lbl.setForeground(new java.awt.Color(255, 255, 255));
        all_labs_lbl.setText("View All Labs");
        all_labs_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        all_labs_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_labs_lblMouseClicked(evt);
            }
        });
        jPanel12.add(all_labs_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 250, 40));

        view_all_roomslbl1.setBackground(new java.awt.Color(0, 102, 153));
        view_all_roomslbl1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        view_all_roomslbl1.setForeground(new java.awt.Color(0, 102, 153));
        view_all_roomslbl1.setText("  Faculty             ");
        view_all_roomslbl1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        view_all_roomslbl1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        view_all_roomslbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_all_roomslbl1MouseClicked(evt);
            }
        });
        jPanel12.add(view_all_roomslbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 270, 40));

        view_all_faculty.setBackground(new java.awt.Color(0, 102, 153));
        view_all_faculty.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        view_all_faculty.setForeground(new java.awt.Color(255, 255, 255));
        view_all_faculty.setText("View All Professors");
        view_all_faculty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_all_faculty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_all_facultyMouseClicked(evt);
            }
        });
        jPanel12.add(view_all_faculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 250, 40));

        add_new_professor.setBackground(new java.awt.Color(0, 102, 153));
        add_new_professor.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        add_new_professor.setForeground(new java.awt.Color(255, 255, 255));
        add_new_professor.setText("Add New Professor");
        add_new_professor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_new_professor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_new_professorMouseClicked(evt);
            }
        });
        jPanel12.add(add_new_professor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 250, 40));

        jScrollPane10.setViewportView(jPanel12);

        Dashboard_Dept.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 280, 470));

        jPanel45.add(Dashboard_Dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 570));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.CardLayout());
        jPanel3.add(room_input_panel1, "card5");
        jPanel3.add(view_schedule_panel1, "card6");
        jPanel3.add(view_schedule_panel2, "card9");
        jPanel3.add(add_professor_panel1, "card8");
        jPanel3.add(search_free_slot_panel1, "card7");

        dept_details_panel.setBackground(new java.awt.Color(50, 50, 50));
        dept_details_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Faculty members:");
        dept_details_panel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 232, 210, 30));

        dept_name.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        dept_name.setForeground(new java.awt.Color(255, 255, 255));
        dept_name.setText("D e p a r t m e n t   N a m e ");
        dept_details_panel.add(dept_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 26, 440, 50));

        programslbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        programslbl.setForeground(new java.awt.Color(255, 255, 255));
        programslbl.setText("1");
        dept_details_panel.add(programslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 300, 100, 30));

        jLabel99.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel99.setForeground(new java.awt.Color(255, 255, 255));
        jLabel99.setText("Total Labs:");
        dept_details_panel.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 172, 210, 30));

        jLabel100.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel100.setForeground(new java.awt.Color(255, 255, 255));
        jLabel100.setText("No. of Programs:");
        dept_details_panel.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 210, -1));

        roomslbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        roomslbl.setForeground(new java.awt.Color(255, 255, 255));
        roomslbl.setText("1");
        dept_details_panel.add(roomslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 60, 30));

        labslbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        labslbl.setForeground(new java.awt.Color(255, 255, 255));
        labslbl.setText("1");
        dept_details_panel.add(labslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 50, 30));

        jLabel103.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel103.setForeground(new java.awt.Color(255, 255, 255));
        jLabel103.setText("Total Rooms:");
        dept_details_panel.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 210, -1));

        professorslbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        professorslbl.setForeground(new java.awt.Color(255, 255, 255));
        professorslbl.setText("1");
        dept_details_panel.add(professorslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 50, 30));

        view_labsbtn.setBackground(new java.awt.Color(0, 102, 153));
        view_labsbtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        view_labsbtn.setForeground(new java.awt.Color(255, 255, 255));
        view_labsbtn.setText("View ");
        view_labsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_labsbtnActionPerformed(evt);
            }
        });
        dept_details_panel.add(view_labsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, 110, 40));

        view_roomsbtn.setBackground(new java.awt.Color(0, 102, 153));
        view_roomsbtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        view_roomsbtn.setForeground(new java.awt.Color(255, 255, 255));
        view_roomsbtn.setText("View");
        view_roomsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_roomsbtnActionPerformed(evt);
            }
        });
        dept_details_panel.add(view_roomsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 110, 40));

        view_programsbtn.setBackground(new java.awt.Color(0, 102, 153));
        view_programsbtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        view_programsbtn.setForeground(new java.awt.Color(255, 255, 255));
        view_programsbtn.setText("View");
        view_programsbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_programsbtnActionPerformed(evt);
            }
        });
        dept_details_panel.add(view_programsbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 110, 40));

        view_facultybtn.setBackground(new java.awt.Color(0, 102, 153));
        view_facultybtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        view_facultybtn.setForeground(new java.awt.Color(255, 255, 255));
        view_facultybtn.setText("View");
        view_facultybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_facultybtnActionPerformed(evt);
            }
        });
        dept_details_panel.add(view_facultybtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 110, 40));

        jLabel105.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel105.setForeground(new java.awt.Color(255, 255, 255));
        jLabel105.setText("No. of Courses offered:");
        dept_details_panel.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 220, -1));

        courseslbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        courseslbl.setForeground(new java.awt.Color(255, 255, 255));
        courseslbl.setText("1");
        dept_details_panel.add(courseslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 100, 30));

        view_coursesbtn.setBackground(new java.awt.Color(0, 102, 153));
        view_coursesbtn.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        view_coursesbtn.setForeground(new java.awt.Color(255, 255, 255));
        view_coursesbtn.setText("View");
        view_coursesbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                view_coursesbtnActionPerformed(evt);
            }
        });
        dept_details_panel.add(view_coursesbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 350, 110, 40));

        jPanel3.add(dept_details_panel, "card3");

        viewData.setBackground(new java.awt.Color(50, 50, 50));
        viewData.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        display_table.setBackground(new java.awt.Color(50, 50, 50));
        display_table.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        display_table.setForeground(new java.awt.Color(255, 255, 255));
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
        display_table.setGridColor(new java.awt.Color(0, 51, 204));
        display_table.setRowHeight(30);
        display_table.setRowMargin(4);
        display_table.setShowVerticalLines(false);
        jScrollPane6.setViewportView(display_table);

        viewData.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 780, 470));

        available_datalbl.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        available_datalbl.setForeground(new java.awt.Color(255, 255, 255));
        available_datalbl.setText("V i e w ");
        viewData.add(available_datalbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 40));

        jPanel3.add(viewData, "card4");

        room_details.setBackground(new java.awt.Color(255, 255, 255));
        room_details.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel97.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel97.setForeground(new java.awt.Color(0, 102, 153));
        jLabel97.setText("Room capacity:");
        room_details.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 210, 30));

        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel93.setForeground(new java.awt.Color(0, 102, 153));
        jLabel93.setText("101");
        room_details.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 70, 30));

        delbtn.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        delbtn.setForeground(new java.awt.Color(0, 102, 153));
        delbtn.setText("view details pnl");
        delbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delbtnActionPerformed(evt);
            }
        });
        room_details.add(delbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 490, 240, 60));

        jLabel101.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel101.setForeground(new java.awt.Color(0, 102, 153));
        jLabel101.setText("Room name:");
        room_details.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 210, 30));

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 102, 153));
        jTextArea1.setRows(5);
        jTextArea1.setText("Room Specification:");
        jScrollPane8.setViewportView(jTextArea1);

        room_details.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, 240, 150));

        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel104.setForeground(new java.awt.Color(0, 102, 153));
        jLabel104.setText("101");
        room_details.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 90, 70, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "", "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setFocusable(false);
        jTable1.setIntercellSpacing(new java.awt.Dimension(0, 0));
        jTable1.setRowHeight(25);
        jTable1.setSelectionBackground(new java.awt.Color(0, 102, 153));
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane9.setViewportView(jTable1);

        room_details.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 740, 150));

        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel106.setForeground(new java.awt.Color(0, 102, 153));
        jLabel106.setText("Room Details:");
        room_details.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 26, 210, 30));

        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel107.setForeground(new java.awt.Color(0, 102, 153));
        jLabel107.setText("Room Schedule:");
        room_details.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 210, 30));

        jPanel3.add(room_details, "card5");

        jPanel45.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 570));

        Department.add(jPanel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, -1));

        getContentPane().add(Department, "card5");

        Programs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Programs.setBackground(new java.awt.Color(0, 0, 0));
        Dashboard_Programs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel28.setBackground(new java.awt.Color(0, 0, 0));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 102, 153));
        jLabel51.setText("  Program     ");
        jLabel51.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel51.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel28.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 278, 40));

        jLabel79.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(0, 102, 153));
        jLabel79.setText("  Section  ");
        jLabel79.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel79.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel28.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 278, 40));

        jLabel119.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setText("Add New Program");
        jLabel119.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel119.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel119MouseClicked(evt);
            }
        });
        jPanel28.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 260, 40));

        jLabel120.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setText("Create New Section");
        jLabel120.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel120MouseClicked(evt);
            }
        });
        jPanel28.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 260, 40));

        jLabel121.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setText("View All Program");
        jLabel121.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel121.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel121MouseClicked(evt);
            }
        });
        jPanel28.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 260, 40));

        jLabel122.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setText("Remove Section");
        jLabel122.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel122.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel122MouseClicked(evt);
            }
        });
        jPanel28.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 260, 40));

        jLabel125.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setText("View Section Details");
        jLabel125.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel125.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel125MouseClicked(evt);
            }
        });
        jPanel28.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 260, 40));

        UpdateSection.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        UpdateSection.setText("Update Details");
        UpdateSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateSectionMouseClicked(evt);
            }
        });
        jPanel28.add(UpdateSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 260, 40));

        jScrollPane14.setViewportView(jPanel28);

        Dashboard_Programs.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, 480));

        jLabel50.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel50.setText("   <-  R e t u r n");
        jLabel50.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        Dashboard_Programs.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 90));

        jPanel2.add(Dashboard_Programs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 570));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setLayout(new java.awt.CardLayout());

        all_programs_details_panel.setBackground(new java.awt.Color(50, 50, 50));
        all_programs_details_panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        all_programs_details_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("A l l   P r o g r a m s");
        all_programs_details_panel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 230, 30));

        programs_table.setBackground(new java.awt.Color(50, 50, 50));
        programs_table.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        programs_table.setForeground(new java.awt.Color(255, 255, 255));
        programs_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},

            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        programs_table.setGridColor(new java.awt.Color(0, 128, 153));
        programs_table.setRowHeight(30);
        programs_table.setRowMargin(4);
        programs_table.setSelectionBackground(new java.awt.Color(0, 128, 153));
        programs_table.setShowVerticalLines(false);
        jScrollPane1.setViewportView(programs_table);

        all_programs_details_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 780, 390));

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        all_programs_details_panel.add(jLayeredPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, -1));

        jPanel47.add(all_programs_details_panel, "card3");
        jPanel47.add(create_section_panel1, "card7");
        jPanel47.add(add_new_program1, "card3");
        jPanel47.add(view_section_details_panel1, "card5");
        jPanel47.add(remove_section_panel1, "card8");
        jPanel47.add(update_section_panel1, "card9");
        jPanel47.add(view_schedule_of_section1, "card10");
        jPanel47.add(professor_course_allocation1, "card11");
        jPanel47.add(add_new_program, "card10");
        jPanel47.add(view_section_details_option_panel1, "card12");

        jPanel2.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 790, 570));

        Programs.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 1060, 570));

        getContentPane().add(Programs, "card5");

        Courses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Courses.setBackground(new java.awt.Color(0, 0, 0));
        Dashboard_Courses.setForeground(new java.awt.Color(0, 102, 153));
        Dashboard_Courses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("View All Courses");
        jLabel55.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 260, 40));

        jLabel56.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel56.setText("   <- R e t u r n");
        jLabel56.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 100));

        jLabel63.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Remove Course");
        jLabel63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 260, 40));

        jLabel88.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Add New Course");
        jLabel88.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel88MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 260, 40));

        jLabel95.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 102, 153));
        jLabel95.setText("    Courses         ");
        jLabel95.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel95.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Dashboard_Courses.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 280, 40));

        jPanel49.add(Dashboard_Courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 570));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel6MouseClicked(evt);
            }
        });
        jPanel6.setLayout(new java.awt.CardLayout());

        addCourse.setBackground(new java.awt.Color(50, 50, 50));
        addCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel89.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel89.setForeground(new java.awt.Color(255, 255, 255));
        jLabel89.setText("A d d   N e w   C o u r s e");
        addCourse.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 310, 50));

        jLabel90.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel90.setForeground(new java.awt.Color(255, 255, 255));
        jLabel90.setText("Course Code:");
        addCourse.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 210, 30));

        jLabel91.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel91.setForeground(new java.awt.Color(255, 255, 255));
        jLabel91.setText("Course Title:");
        addCourse.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 210, 30));

        jLabel92.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel92.setForeground(new java.awt.Color(255, 255, 255));
        jLabel92.setText("Credit hours:");
        addCourse.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 210, 30));

        crs_code.setBackground(new java.awt.Color(50, 50, 50));
        crs_code.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        crs_code.setForeground(new java.awt.Color(255, 255, 255));
        crs_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crs_codeActionPerformed(evt);
            }
        });
        addCourse.add(crs_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, 360, 30));

        title.setBackground(new java.awt.Color(50, 50, 50));
        title.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        addCourse.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 360, 30));

        credit_hours.setBackground(new java.awt.Color(50, 50, 50));
        credit_hours.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        credit_hours.setForeground(new java.awt.Color(255, 255, 255));
        addCourse.add(credit_hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 360, 30));

        labcheckBox.setBackground(new java.awt.Color(50, 50, 50));
        labcheckBox.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        labcheckBox.setForeground(new java.awt.Color(255, 255, 255));
        labcheckBox.setText("Has Lab");
        addCourse.add(labcheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 310, 110, 40));

        jButton6.setBackground(new java.awt.Color(0, 102, 153));
        jButton6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Add Course");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        addCourse.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 200, 50));

        jPanel6.add(addCourse, "card2");

        viewAllCourses.setBackground(new java.awt.Color(50, 50, 50));
        viewAllCourses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel67.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("A l l   C o u r s e s   A v a i l a b l e");
        viewAllCourses.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 400, 50));

        coursesTable.setBackground(new java.awt.Color(50, 50, 50));
        coursesTable.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        coursesTable.setForeground(new java.awt.Color(255, 255, 255));
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
        coursesTable.setRowHeight(30);
        coursesTable.setRowMargin(4);
        coursesTable.setShowVerticalLines(false);
        jScrollPane5.setViewportView(coursesTable);

        viewAllCourses.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 730, 430));

        jPanel6.add(viewAllCourses, "card3");

        delCourse.setBackground(new java.awt.Color(50, 50, 50));
        delCourse.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel108.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel108.setForeground(new java.awt.Color(255, 255, 255));
        jLabel108.setText("Course Title:");
        delCourse.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 180, 40));

        jLabel110.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(255, 255, 255));
        jLabel110.setText("R e m o v e   C o u r s e");
        delCourse.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 290, 50));

        jButton10.setBackground(new java.awt.Color(0, 102, 153));
        jButton10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Remove Course");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        delCourse.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 400, 230, 50));

        course_title_dropdown.setBackground(new java.awt.Color(50, 50, 50));
        course_title_dropdown.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        course_title_dropdown.setForeground(new java.awt.Color(255, 255, 255));
        course_title_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        course_title_dropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                course_title_dropdownItemStateChanged(evt);
            }
        });
        delCourse.add(course_title_dropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 300, 40));

        course_details_textarea.setEditable(false);
        course_details_textarea.setBackground(new java.awt.Color(50, 50, 50));
        course_details_textarea.setColumns(20);
        course_details_textarea.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        course_details_textarea.setForeground(new java.awt.Color(255, 255, 255));
        course_details_textarea.setRows(5);
        course_details_textarea.setText("Course Details:");
        jScrollPane15.setViewportView(course_details_textarea);

        delCourse.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 690, 190));

        jPanel6.add(delCourse, "card4");

        jPanel49.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 570));

        Courses.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 570));

        getContentPane().add(Courses, "card5");

        schedule_generation.setBackground(new java.awt.Color(255, 255, 255));
        schedule_generation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Dept1.setBackground(new java.awt.Color(0, 0, 0));
        Dashboard_Dept1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel68.setText("   <- R e t u r n");
        jLabel68.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel68.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel68.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel68MouseClicked(evt);
            }
        });
        Dashboard_Dept1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 90));

        jPanel23container.add(Dashboard_Dept1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 580));

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));
        jPanel24.setLayout(new java.awt.CardLayout());
        jPanel24.add(excel_file_panel1, "card7");
        jPanel24.add(first_panel1, "card3");
        jPanel24.add(first_panel_part21, "card4");
        jPanel24.add(second_panel1, "card5");
        jPanel24.add(third_panel1, "card6");
        jPanel24.add(final_panel1, "card7");

        jPanel23container.add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 580));

        schedule_generation.add(jPanel23container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(schedule_generation, "card7");

        timetable_management.setBackground(new java.awt.Color(255, 255, 255));

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_timetable.setBackground(new java.awt.Color(0, 0, 0));
        Dashboard_timetable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel45.setBackground(new java.awt.Color(0, 0, 0));
        jLabel45.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel45.setText("   <- R e t u r n");
        jLabel45.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
        });
        Dashboard_timetable.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 90));

        jPanel22.setBackground(new java.awt.Color(0, 0, 0));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 102, 153));
        jLabel48.setText("    Timetable                    ");
        jLabel48.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel48.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        jPanel22.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 40));

        room_wise_lbl.setBackground(new java.awt.Color(0, 102, 153));
        room_wise_lbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        room_wise_lbl.setText("Room Information");
        room_wise_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        room_wise_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                room_wise_lblMouseClicked(evt);
            }
        });
        jPanel22.add(room_wise_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 260, 40));

        clash_lbl.setBackground(new java.awt.Color(0, 102, 153));
        clash_lbl.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        clash_lbl.setForeground(new java.awt.Color(0, 102, 153));
        clash_lbl.setText("   Clashes                ");
        clash_lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        clash_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        clash_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clash_lblMouseClicked(evt);
            }
        });
        jPanel22.add(clash_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 280, 40));

        professor_clasheslbl.setBackground(new java.awt.Color(0, 102, 153));
        professor_clasheslbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        professor_clasheslbl.setForeground(new java.awt.Color(255, 255, 255));
        professor_clasheslbl.setText("Professor Clashes");
        professor_clasheslbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        professor_clasheslbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                professor_clasheslblMouseClicked(evt);
            }
        });
        jPanel22.add(professor_clasheslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 260, 40));

        section_wise_lbl.setBackground(new java.awt.Color(0, 102, 153));
        section_wise_lbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        section_wise_lbl.setForeground(new java.awt.Color(255, 255, 255));
        section_wise_lbl.setText("Section Schedule");
        section_wise_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        section_wise_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                section_wise_lblMouseClicked(evt);
            }
        });
        jPanel22.add(section_wise_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 40));

        professor_wise_lbl.setBackground(new java.awt.Color(0, 102, 153));
        professor_wise_lbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        professor_wise_lbl.setForeground(new java.awt.Color(255, 255, 255));
        professor_wise_lbl.setText("Professor Schedule");
        professor_wise_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        professor_wise_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                professor_wise_lblMouseClicked(evt);
            }
        });
        jPanel22.add(professor_wise_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 260, 40));

        std_wise_lbl.setBackground(new java.awt.Color(0, 102, 153));
        std_wise_lbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        std_wise_lbl.setForeground(new java.awt.Color(255, 255, 255));
        std_wise_lbl.setText("Student Schedule");
        std_wise_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        std_wise_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                std_wise_lblMouseClicked(evt);
            }
        });
        jPanel22.add(std_wise_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 260, 40));

        student_clasheslbl.setBackground(new java.awt.Color(0, 102, 153));
        student_clasheslbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        student_clasheslbl.setForeground(new java.awt.Color(255, 255, 255));
        student_clasheslbl.setText("Student Clashes");
        student_clasheslbl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        student_clasheslbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                student_clasheslblMouseClicked(evt);
            }
        });
        jPanel22.add(student_clasheslbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 260, 40));

        jScrollPane11.setViewportView(jPanel22);

        Dashboard_timetable.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, 480));

        jPanel13.add(Dashboard_timetable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 580));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setLayout(new java.awt.CardLayout());

        jPanel26.setBackground(new java.awt.Color(255, 255, 255));
        jPanel26.setLayout(new java.awt.CardLayout());
        jPanel26.add(view_generated_timetable_panel1, "card2");
        jPanel26.add(view_all_clashes_panel1, "card3");

        jScrollPane13.setViewportView(jPanel26);

        jPanel25.add(jScrollPane13, "card3");

        jPanel13.add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 630));

        javax.swing.GroupLayout timetable_managementLayout = new javax.swing.GroupLayout(timetable_management);
        timetable_management.setLayout(timetable_managementLayout);
        timetable_managementLayout.setHorizontalGroup(
            timetable_managementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1060, Short.MAX_VALUE)
            .addGroup(timetable_managementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        timetable_managementLayout.setVerticalGroup(
            timetable_managementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
            .addGroup(timetable_managementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(timetable_managementLayout.createSequentialGroup()
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        getContentPane().add(timetable_management, "card9");

        students_management.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel56.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_std_management.setBackground(new java.awt.Color(0, 0, 0));
        Dashboard_std_management.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Dashboard_std_management.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        home_std_lbl.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        home_std_lbl.setForeground(new java.awt.Color(255, 255, 255));
        home_std_lbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        home_std_lbl.setText("   <- R e t u r n");
        home_std_lbl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        home_std_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home_std_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_std_lblMouseClicked(evt);
            }
        });
        Dashboard_std_management.add(home_std_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 100));

        update_section_lbl.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        update_section_lbl.setText("     Change Section");
        update_section_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        update_section_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_section_lblMouseClicked(evt);
            }
        });
        Dashboard_std_management.add(update_section_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 280, 50));

        jLabel115.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setText("     Student Details");
        jLabel115.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel115MouseClicked(evt);
            }
        });
        Dashboard_std_management.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 280, 50));

        jLabel118.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(0, 102, 153));
        jLabel118.setText("    Students  ");
        jLabel118.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel118.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jLabel118.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel118MouseClicked(evt);
            }
        });
        Dashboard_std_management.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 280, 60));

        jPanel56.add(Dashboard_std_management, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 580));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel27MouseClicked(evt);
            }
        });
        jPanel27.setLayout(new java.awt.CardLayout());
        jPanel27.add(view_student_details_panel1, "card3");
        jPanel27.add(update_section1, "card3");

        jPanel56.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 580));

        students_management.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 580));

        getContentPane().add(students_management, "card5");

        datesheet_generation.setBackground(new java.awt.Color(255, 255, 255));
        datesheet_generation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23container1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Datesheet.setBackground(new java.awt.Color(0, 0, 0));
        Dashboard_Datesheet.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel69.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel69.setText("   <- R e t u r n");
        jLabel69.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jLabel69.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel69.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel69.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel69MouseClicked(evt);
            }
        });
        Dashboard_Datesheet.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 90));

        jPanel23container1.add(Dashboard_Datesheet, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 580));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));
        jPanel29.setLayout(new java.awt.CardLayout());
        jPanel29.add(excel_file_panel2, "card7");

        jPanel23container1.add(jPanel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 580));

        datesheet_generation.add(jPanel23container1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(datesheet_generation, "card7");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseEntered
        // TODO add your handling code here:
        jLabel1.setForeground(Color.red);
    }//GEN-LAST:event_jLabel1MouseEntered

    private void jLabel3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseEntered

    private void programMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programMouseClicked
        this.MainPanel.setVisible(false);
        this.Programs.setVisible(true);
        programs_table.setModel(TableViewUtility.resultSetToTableModel(Program.get_all_data_of_programs()));

    }//GEN-LAST:event_programMouseClicked

    private void courseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseMouseClicked
        MainPanel.setVisible(false);
        Courses.setVisible(true);
    }//GEN-LAST:event_courseMouseClicked

    private void studentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseClicked

        students_management.setVisible(true);
        MainPanel.setVisible(false);
    }//GEN-LAST:event_studentsMouseClicked

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseEntered

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
        this.MainPanel.setVisible(false);
        schedule_generation.setVisible(true);

        schedule_generation_panel_visibility(excel_file_panel1);
    }//GEN-LAST:event_scheduler_generationMouseClicked

    private void DeptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeptMouseClicked
        String name = Model.Department.get_department_name();
        dept_name.setText(name);
        String pr = Professor.get_total_no_of_professors() + "";
        professorslbl.setText(pr);
        programslbl.setText(Program.get_total_no_of_programs() + "");
        courseslbl.setText(Course.get_total_no_of_courses() + "");
        roomslbl.setText(Room.get_total_no_of_rooms() + "");
        labslbl.setText(Room.get_total_no_of_labs() + "");
        ResultSet rs = Course.get_all_courses();
        try {
            if (rs.last()) {
                courseslbl.setText(rs.getRow() + "");
            }
            rs = Program.get_all_programs();
            if (rs.last()) {
                programslbl.setText(rs.getRow() + "");
            }
            rs = Room.get_all_rooms();
            if (rs.last()) {
                roomslbl.setText(rs.getRow() + "");
            }
            rs = Room.get_all_labs();
            if (rs.last()) {
                labslbl.setText(rs.getRow() + "");
            }
            rs = Professor.get_all_professors();
            if (rs.last()) {
                professorslbl.setText(rs.getRow() + "");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.Department.setVisible(true);
        this.MainPanel.setVisible(false);
        department_panel_visibility(dept_details_panel);
    }//GEN-LAST:event_DeptMouseClicked

    private void jLabel50MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel50MouseClicked
        this.MainPanel.setVisible(true);
        this.Programs.setVisible(false);
    }//GEN-LAST:event_jLabel50MouseClicked
    public boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        } catch (NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }
    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        String course_code = crs_code.getText();
        String crs_title = title.getText();
        String crs_hours = credit_hours.getText();
        if (course_code.equals("") || crs_title.equals("")) {
            JOptionPane.showMessageDialog(null, "Course code and Course title can not be empty");
            return;
        }
        if (!isInteger(crs_hours)) {
            JOptionPane.showMessageDialog(null, "Enter credit hours correctly");
        } else {
            int hours = Integer.parseInt(crs_hours);
            boolean haslab = labcheckBox.isSelected();

            if (!Course.check_duplication_in_database(course_code, crs_title)) {
                Course.add_Course_in_database(course_code, crs_title, hours, haslab);
                crs_code.setText("");
                title.setText("");
                credit_hours.setText("");
                labcheckBox.setSelected(false);
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
        this.Department.setVisible(false);
        this.Courses.setVisible(false);

    }//GEN-LAST:event_jLabel42MouseClicked

    private void view_labsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_labsbtnActionPerformed
        // TODO add your handling code here:
        dept_details_panel.setVisible(false);
        viewData.setVisible(true);
        display_table.setModel(TableViewUtility.resultSetToTableModel(Room.get_all_labs()));

    }//GEN-LAST:event_view_labsbtnActionPerformed

    private void view_roomsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_roomsbtnActionPerformed
        dept_details_panel.setVisible(false);
        viewData.setVisible(true);
        display_table.setModel(TableViewUtility.resultSetToTableModel(Room.get_all_rooms()));
    }//GEN-LAST:event_view_roomsbtnActionPerformed

    private void view_programsbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_programsbtnActionPerformed
        dept_details_panel.setVisible(false);
        viewData.setVisible(true);
        display_table.setModel(TableViewUtility.resultSetToTableModel(Program.get_all_programs()));

    }//GEN-LAST:event_view_programsbtnActionPerformed

    private void view_facultybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_facultybtnActionPerformed
        dept_details_panel.setVisible(false);
        viewData.setVisible(true);
        display_table.setModel(TableViewUtility.resultSetToTableModel(Professor.get_all_professors()));

    }//GEN-LAST:event_view_facultybtnActionPerformed

    private void jLabel47MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel47MouseClicked
        ResultSet rs = Course.get_all_courses();
        try {
            if (rs.last()) {
                courseslbl.setText(rs.getRow() + "");
            }
            rs = Program.get_all_programs();
            if (rs.last()) {
                programslbl.setText(rs.getRow() + "");
            }
            rs = Room.get_all_rooms();
            if (rs.last()) {
                roomslbl.setText(rs.getRow() + "");
            }
            rs = Room.get_all_labs();
            if (rs.last()) {
                labslbl.setText(rs.getRow() + "");
            }
            rs = Professor.get_all_professors();
            if (rs.last()) {
                professorslbl.setText(rs.getRow() + "");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        department_panel_visibility(dept_details_panel);
    }//GEN-LAST:event_jLabel47MouseClicked

    private void view_coursesbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_view_coursesbtnActionPerformed
        dept_details_panel.setVisible(false);
        viewData.setVisible(true);
        display_table.setModel(TableViewUtility.resultSetToTableModel(Course.get_all_courses()));
    }//GEN-LAST:event_view_coursesbtnActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        String courseTitle = course_title_dropdown.getSelectedItem().toString();
        String courseCode = Queries.getCourseCode(courseTitle);
        String query = "delete from course where  course_code = '" + courseCode + "'";
        try {
            PreparedStatement stmt1 = getConnection().prepareStatement(query);
            stmt1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Course deleted successfully");
            String[] courses = Queries.getAllCourses();
            course_title_dropdown.setModel(new DefaultComboBoxModel<>(courses));
            course_details_textarea.setText("Course Details:");
        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in deleting the course", "Table", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton10ActionPerformed

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        viewAllCourses.setVisible(true);
        addCourse.setVisible(false);
        delCourse.setVisible(false);
        coursesTable.setModel(TableViewUtility.resultSetToTableModel(Course.get_all_courses()));

        // get data of all Courses;

    }//GEN-LAST:event_jLabel55MouseClicked

    private void jPanel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel6MouseClicked

    private void jLabel63MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel63MouseClicked
        String[] courses = Queries.getAllCourses();
        course_title_dropdown.setModel(new DefaultComboBoxModel<>(courses));
        viewAllCourses.setVisible(false);
        addCourse.setVisible(false);
        delCourse.setVisible(true);
    }//GEN-LAST:event_jLabel63MouseClicked

    private void jLabel56MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel56MouseClicked
        this.MainPanel.setVisible(true);
        this.Department.setVisible(false);
        this.Courses.setVisible(false);
    }//GEN-LAST:event_jLabel56MouseClicked

    private void view_timetableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_timetableMouseClicked
        this.timetable_management.setVisible(true);
        this.MainPanel.setVisible(false);
    }//GEN-LAST:event_view_timetableMouseClicked

    private void add_roomlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_roomlblMouseClicked
        department_panel_visibility(room_input_panel1);
    }//GEN-LAST:event_add_roomlblMouseClicked

    private void jLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel68MouseClicked
        this.MainPanel.setVisible(true);
        this.Department.setVisible(false);
        this.Courses.setVisible(false);
        this.schedule_generation.setVisible(false);
    }//GEN-LAST:event_jLabel68MouseClicked

    private void jLabel11MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel11MouseEntered

    private void nxt_lbl_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nxt_lbl_1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nxt_lbl_1MouseEntered

    private void jLabel13MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel13MouseEntered

    private void back_lbl_1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_lbl_1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_back_lbl_1MouseEntered

    private void nxt_lbl_2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nxt_lbl_2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_nxt_lbl_2MouseEntered

    private void jLabel32MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel32MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel32MouseEntered

    private void jLabel33MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel33MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel33MouseEntered

    private void tuesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tuesActionPerformed
        if (tues.isSelected()) {
            numberOfDays++;
        } else {
            numberOfDays--;
        }
    }//GEN-LAST:event_tuesActionPerformed

    private void jLabel34MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel34MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel34MouseEntered

    private void back_lbl_02MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_lbl_02MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_back_lbl_02MouseEntered

    private void jLabel37MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel37MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel37MouseEntered

    private void jLabel38MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel38MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel38MouseEntered

    private void jLabel40MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel40MouseEntered

//    ArrayList<JPanel> welcome_window_panels= new ArrayList<>();

    private void nxt_lbl_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nxt_lbl_1MouseClicked
        if (dep_name.getText().length() < 5) {
            JOptionPane.showMessageDialog(null, "Department name  should have at least five characters");
            return;
        }
        numberOfDays = 0;
        Connection conn = getConnection();
        String q = "insert into department VALUES "
                + "(?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(q);
            stmt.setInt(1, 1);
            stmt.setString(2, dep_name.getText());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Department Added Successfuly");
        } catch (SQLException ex) {
            String update = "UPDATE department SET "
                    + "department_name = '" + dep_name.getText() + "' "
                    + " WHERE "
                    + "department_id = 1";
            try {
                stmt = conn.prepareStatement(update);
                stmt.execute();
                JOptionPane.showMessageDialog(null, "Department Added Successfuly");
            } catch (SQLException ex1) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        dept_name_panel.setVisible(false);
        working_days_panel.setVisible(true);
    }//GEN-LAST:event_nxt_lbl_1MouseClicked

    private void back_lbl_1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_lbl_1MouseClicked
        dept_name_panel.setVisible(true);
        working_days_panel.setVisible(false);
    }//GEN-LAST:event_back_lbl_1MouseClicked

    private void nxt_lbl_2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nxt_lbl_2MouseClicked
        if (numberOfDays < 4) {
            JOptionPane.showMessageDialog(null, "Select at least four days");
            return;
        }
        Connection conn = getConnection();
        String q;
        if (mon.isSelected()) {
            q = "insert into day VALUES "
                    + "(?, ?)";
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(q);
                stmt.setInt(1, 1);
                stmt.setString(2, "Monday");
                stmt.execute();
            } catch (SQLException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (tues.isSelected()) {
            q = "insert into day VALUES "
                    + "(?, ?)";
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(q);
                stmt.setInt(1, 2);
                stmt.setString(2, "Tuesday");
                stmt.execute();
            } catch (SQLException ex) {
            }
        }
        if (wed.isSelected()) {
            q = "insert into day VALUES "
                    + "(?, ?)";
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(q);
                stmt.setInt(1, 3);
                stmt.setString(2, "Wednesday");
                stmt.execute();
            } catch (SQLException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (thurs.isSelected()) {
            q = "insert into day VALUES "
                    + "(?, ?)";
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(q);
                stmt.setInt(1, 4);
                stmt.setString(2, "Thursday");
                stmt.execute();
            } catch (SQLException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (fri.isSelected()) {
            q = "insert into day VALUES "
                    + "(?, ?)";
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(q);
                stmt.setInt(1, 5);
                stmt.setString(2, "Friday");
                stmt.execute();
            } catch (SQLException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (sat.isSelected()) {
            q = "insert into day VALUES "
                    + "(?, ?)";
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(q);
                stmt.setInt(1, 6);
                stmt.setString(2, "Saturday");
                stmt.execute();
            } catch (SQLException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (sun.isSelected()) {
            q = "insert into day VALUES "
                    + "(?, ?)";
            PreparedStatement stmt = null;
            try {
                stmt = conn.prepareStatement(q);
                stmt.setInt(1, 7);
                stmt.setString(2, "Sunday");
                stmt.execute();
            } catch (SQLException ex) {
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        working_days_panel.setVisible(false);
        timeslots_panel.setVisible(true);
    }//GEN-LAST:event_nxt_lbl_2MouseClicked

    private void back_lbl_02MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_back_lbl_02MouseClicked
        numberOfDays = 0;
        working_days_panel.setVisible(true);
        timeslots_panel.setVisible(false);
    }//GEN-LAST:event_back_lbl_02MouseClicked

    private void sv_btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sv_btn1ActionPerformed
        JOptionPane.showMessageDialog(null, numberOfDays + " Slots added for scheduling");
        MainPanel.setVisible(true);
        welcome_window.setVisible(false);
    }//GEN-LAST:event_sv_btn1ActionPerformed

    private void all_roomsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_roomsMouseClicked
        // TODO add your handling code here:
        display_table.setModel(TableViewUtility.resultSetToTableModel(Room.get_all_rooms()));
        viewData.setVisible(true);
        room_input_panel1.setVisible(false);
        dept_details_panel.setVisible(false);
    }//GEN-LAST:event_all_roomsMouseClicked

    private void search_slot_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_slot_lblMouseClicked
        String[] days = Queries.getData("name", "day");
        String[] start_slots = Queries.getData("starting_time", "timeslot");
        String[] end_slots = Queries.getData("ending_time", "timeslot");
        search_by_capacity.setDays(days);
        search_by_capacity.setEndTime(end_slots);
        search_by_capacity.setStartTime(start_slots);
        department_panel_visibility(search_free_slot_panel1);
    }//GEN-LAST:event_search_slot_lblMouseClicked

    private void all_labs_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_all_labs_lblMouseClicked
        display_table.setModel(TableViewUtility.resultSetToTableModel(Room.get_all_labs()));
        department_panel_visibility(viewData);
    }//GEN-LAST:event_all_labs_lblMouseClicked

    private void view_all_roomslbl1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_all_roomslbl1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_view_all_roomslbl1MouseClicked

    private void view_all_facultyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_all_facultyMouseClicked
        display_table.setModel(TableViewUtility.resultSetToTableModel(Professor.get_all_professors()));
        department_panel_visibility(viewData);
    }//GEN-LAST:event_view_all_facultyMouseClicked

    private void add_new_professorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_new_professorMouseClicked
        department_panel_visibility(add_professor_panel1);
    }//GEN-LAST:event_add_new_professorMouseClicked

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        //        String room_name = room_name1.getText().trim() ;
        //        if(Room.remove_room(room_name)){
        //            JOptionPane.showMessageDialog(null, "Room removed successfully");
        //            room_name1.setText(null);
        //        }
    }//GEN-LAST:event_delbtnActionPerformed

    private void jLabel45MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel45MouseClicked
        MainPanel.setVisible(true);
        timetable_management.setVisible(false);
    }//GEN-LAST:event_jLabel45MouseClicked

    private void jLabel48MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel48MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel48MouseClicked

    private void room_wise_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_room_wise_lblMouseClicked
        String[] data = Queries.getData("name", "room");
        search_for_specific_entity.setDropdownData(data);
        view_generated_timetable_panel.entity_name_lbl.setText("Room-wise");
        search_for_specific_entity.entity_name_lbl.setText("Room  :  ");
//        view_schedule.entity_name_lbl.setText("Room  : ");
        view_timetable_panel_visibility(view_generated_timetable_panel1);
    }//GEN-LAST:event_room_wise_lblMouseClicked

    private void clash_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clash_lblMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_clash_lblMouseClicked

    private void professor_clasheslblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_professor_clasheslblMouseClicked
        view_timetable_panel_visibility(view_all_clashes_panel1);
        view_all_clashes_panel1.entity_name.setText("Professor-wise");
        
        
    }//GEN-LAST:event_professor_clasheslblMouseClicked

    private void section_wise_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_section_wise_lblMouseClicked
        String[] data = Queries.getData("section_id", "section");
        search_for_specific_entity.setDropdownData(data);
        view_generated_timetable_panel.entity_name_lbl.setText("S e c t i o n   S c h e d u l e");
        search_for_specific_entity.entity_name_lbl.setText("Section :  ");
//        view_schedule.entity_name_lbl.setText("Section : ");
        view_timetable_panel_visibility(view_generated_timetable_panel1);
    }//GEN-LAST:event_section_wise_lblMouseClicked

    private void professor_wise_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_professor_wise_lblMouseClicked
        String[] data = Queries.getData("name", "professor");
        search_for_specific_entity.setDropdownData(data);
        view_generated_timetable_panel.entity_name_lbl.setText("P r o f e s s o r  S c h e d u l e");
        search_for_specific_entity.entity_name_lbl.setText("Professor  :  ");
//        view_schedule.entity_name_lbl.setText("Professor : ");
        view_timetable_panel_visibility(view_generated_timetable_panel1);
    }//GEN-LAST:event_professor_wise_lblMouseClicked

    private void std_wise_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_std_wise_lblMouseClicked
        String[] data = Queries.getData("registration_no", "students");
        search_for_specific_entity.setDropdownData(data);
        view_generated_timetable_panel.entity_name_lbl.setText("S t u d e n t   S c h e d u l e");
        search_for_specific_entity.entity_name_lbl.setText("Student  :  ");
//        view_schedule.entity_name_lbl.setText("Student : ");
        view_timetable_panel_visibility(view_generated_timetable_panel1);
    }//GEN-LAST:event_std_wise_lblMouseClicked

    private void student_clasheslblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_clasheslblMouseClicked
        view_timetable_panel_visibility(view_all_clashes_panel1);
        view_all_clashes_panel1.entity_name.setText("Student-wise");
    }//GEN-LAST:event_student_clasheslblMouseClicked

    private void crs_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crs_codeActionPerformed
    }//GEN-LAST:event_crs_codeActionPerformed

    private void home_std_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_std_lblMouseClicked
        MainPanel.setVisible(true);
        students_management.setVisible(false);
    }//GEN-LAST:event_home_std_lblMouseClicked

    private void update_section_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_section_lblMouseClicked
        update_regular_section.fillStudents();
        students_panel_visibility(update_section1);
    }//GEN-LAST:event_update_section_lblMouseClicked

    private void jLabel115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel115MouseClicked
        view_student_details_panel.fillStudents();
        students_panel_visibility(view_student_details_panel1);
    }//GEN-LAST:event_jLabel115MouseClicked

    private void jLabel118MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel118MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel118MouseClicked

    private void jPanel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel27MouseClicked

    private void jLabel119MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel119MouseClicked
        programs_panel_visibility(add_new_program);
    }//GEN-LAST:event_jLabel119MouseClicked

    private void jLabel125MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel125MouseClicked
        init();
        programs_panel_visibility(view_section_details_option_panel1);
    }//GEN-LAST:event_jLabel125MouseClicked

    private void jLabel121MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel121MouseClicked
        programs_panel_visibility(all_programs_details_panel);
    }//GEN-LAST:event_jLabel121MouseClicked

    private void jLabel120MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel120MouseClicked
        getPrograms();
        getCourses();
        create_section_panel1.fillSemesters();
        programs_panel_visibility(create_section_panel1);
    }//GEN-LAST:event_jLabel120MouseClicked

    private void UpdateSectionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UpdateSectionMouseClicked
        // TODO add your handling code here:
        programs_panel_visibility(update_section_panel1);
        
    }//GEN-LAST:event_UpdateSectionMouseClicked

    private void jLabel122MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel122MouseClicked
        remove_section_panel.fillSection(Queries.getData("section_id", "section"));
        programs_panel_visibility(remove_section_panel1);
    }//GEN-LAST:event_jLabel122MouseClicked

    private void add_button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_button1ActionPerformed
        String start_time = start.getText();
        String end_time = end.getText();
        Connection conn = getConnection();
        PreparedStatement stmt = null;
        String q = "insert into timeslot "
                + "(timeslot_no, "
                + "starting_time,"
                + "ending_time) "
                + " VALUES "
                + "(?, ?, ?)";
        try {
            stmt = conn.prepareStatement(q);
            stmt.setInt(1, Queries.getSlotCount() + 1);
            stmt.setString(2, start_time);
            stmt.setString(3, end_time);
            stmt.execute();
            slot_preview.append("\n" + slotNum++ + "\t" + start_time + "-" + end_time);

        } catch (SQLException ex) {
//            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_add_button1ActionPerformed


    private void monActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monActionPerformed
        if (mon.isSelected()) {
            numberOfDays++;
        } else {
            numberOfDays--;
        }
    }//GEN-LAST:event_monActionPerformed

    private void wedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wedActionPerformed
        if (wed.isSelected()) {
            numberOfDays++;
        } else {
            numberOfDays--;
        }
    }//GEN-LAST:event_wedActionPerformed

    private void thursActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thursActionPerformed
        if (thurs.isSelected()) {
            numberOfDays++;
        } else {
            numberOfDays--;
        }
    }//GEN-LAST:event_thursActionPerformed

    private void friActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_friActionPerformed
        if (fri.isSelected()) {
            numberOfDays++;
        } else {
            numberOfDays--;
        }
    }//GEN-LAST:event_friActionPerformed

    private void satActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satActionPerformed
        if (sat.isSelected()) {
            numberOfDays++;
        } else {
            numberOfDays--;
        }
    }//GEN-LAST:event_satActionPerformed

    private void sunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sunActionPerformed
        if (sun.isSelected()) {
            numberOfDays++;
        } else {
            numberOfDays--;
        }
    }//GEN-LAST:event_sunActionPerformed

    private void course_title_dropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_course_title_dropdownItemStateChanged
        String courseTitle = course_title_dropdown.getSelectedItem().toString();
        String courseCode = Queries.getCourseCode(courseTitle);
        ResultSet courseDetails = Queries.getCourseDetails(courseCode);

        String str = "C o u r s e   D e t a i l s\n";
        try {
            if (courseDetails.next()) {
                str += "\nCourse Code: \t\t" + courseDetails.getString("course_code").toUpperCase();
                str += "\nCourse Title: \t\t" + courseDetails.getString("title").toUpperCase();
                str += "\nCredit Hours: \t\t" + courseDetails.getInt("credit_hours");
                if (courseDetails.getString("hasLab").equalsIgnoreCase("false")) {
                    str += "\nHas Lab: \t\tNO";
                } else {
                    str += "\nHas Lab: \t\tYES";
                }

                course_details_textarea.setText(str);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_course_title_dropdownItemStateChanged

    private void student_mouse_entered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_student_mouse_entered
//        students.setBackground(new Color(89, 89, 89));
//std_label.setForeground(Color.WHITE);
    }//GEN-LAST:event_student_mouse_entered

    private void datesheetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datesheetMouseClicked
        this.MainPanel.setVisible(false);
        datesheet_generation.setVisible(true);

    }//GEN-LAST:event_datesheetMouseClicked

    private void jLabel69MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel69MouseClicked
        this.MainPanel.setVisible(true) ; 
        datesheet_generation.setVisible(false);

    }//GEN-LAST:event_jLabel69MouseClicked

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
                createConnection();
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Courses;
    private javax.swing.JPanel Dashboard_Courses;
    private javax.swing.JPanel Dashboard_Datesheet;
    private javax.swing.JPanel Dashboard_Dept;
    private javax.swing.JPanel Dashboard_Dept1;
    private javax.swing.JPanel Dashboard_Programs;
    private javax.swing.JPanel Dashboard_std_management;
    private javax.swing.JPanel Dashboard_timetable;
    private javax.swing.JPanel Department;
    private javax.swing.JPanel Dept;
    private javax.swing.JPanel MainPanel;
    private javax.swing.JScrollPane MainPanel_ScrollPane;
    private javax.swing.JPanel Programs;
    private javax.swing.JLabel UpdateSection;
    private javax.swing.JPanel addCourse;
    private javax.swing.JButton add_button1;
    private javax.swing.JLabel add_new_professor;
    private View.section.add_new_program add_new_program;
    private View.section.add_new_program add_new_program1;
    private View.professor.add_professor_panel add_professor_panel1;
    private javax.swing.JLabel add_roomlbl;
    private javax.swing.JLabel add_roomlbl1;
    private javax.swing.JLabel all_labs_lbl;
    private javax.swing.JPanel all_programs_details_panel;
    private javax.swing.JLabel all_rooms;
    private javax.swing.JLabel available_datalbl;
    private javax.swing.JLabel back_lbl_02;
    private javax.swing.JLabel back_lbl_1;
    private javax.swing.JLabel clash_lbl;
    private javax.swing.JPanel course;
    static javax.swing.JTextArea course_details_textarea;
    private javax.swing.JComboBox<String> course_title_dropdown;
    private javax.swing.JTable coursesTable;
    private javax.swing.JLabel courseslbl;
    public static View.section.create_section_panel create_section_panel1;
    private javax.swing.JTextField credit_hours;
    private javax.swing.JTextField crs_code;
    private javax.swing.JPanel datesheet;
    private javax.swing.JPanel datesheet_generation;
    private javax.swing.JPanel delCourse;
    private javax.swing.JButton delbtn;
    private javax.swing.JTextField dep_name;
    private javax.swing.JPanel dept_details_panel;
    private javax.swing.JLabel dept_name;
    private javax.swing.JPanel dept_name_panel;
    private javax.swing.JTable display_table;
    private cambodia.raven.Time end;
    public static View.schedule_generation.excel_file_panel excel_file_panel1;
    public static View.schedule_generation.excel_file_panel excel_file_panel2;
    public static View.schedule_generation.final_panel final_panel1;
    public static View.schedule_generation.first_panel first_panel1;
    public static View.schedule_generation.first_panel_part2 first_panel_part21;
    private javax.swing.JCheckBox fri;
    private javax.swing.JLabel home_std_lbl;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23container;
    private javax.swing.JPanel jPanel23container1;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel49;
    private javax.swing.JPanel jPanel56;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JCheckBox labcheckBox;
    private javax.swing.JLabel labslbl;
    private javax.swing.JCheckBox mon;
    private javax.swing.JLabel nxt_lbl_1;
    private javax.swing.JLabel nxt_lbl_2;
    private javax.swing.JLabel professor_clasheslbl;
    public static View.section.Professor_course_allocation professor_course_allocation1;
    private javax.swing.JLabel professor_wise_lbl;
    private javax.swing.JLabel professorslbl;
    private javax.swing.JPanel program;
    private javax.swing.JTable programs_table;
    private javax.swing.JLabel programslbl;
    private View.section.remove_section_panel remove_section_panel1;
    private javax.swing.JPanel room_details;
    private View.room.room_input_panel room_input_panel1;
    private javax.swing.JLabel room_wise_lbl;
    private javax.swing.JLabel roomslbl;
    private javax.swing.JCheckBox sat;
    private javax.swing.JPanel schedule_generation;
    private javax.swing.JPanel scheduler_generation;
    private View.room.search_free_slot_panel search_free_slot_panel1;
    private javax.swing.JLabel search_slot_lbl;
    public static View.schedule_generation.second_panel second_panel1;
    private javax.swing.JLabel section_wise_lbl;
    private javax.swing.JTextArea slot_preview;
    private cambodia.raven.Time start;
    private javax.swing.JLabel std_label;
    private javax.swing.JLabel std_wise_lbl;
    private javax.swing.JLabel student_clasheslbl;
    private javax.swing.JPanel students;
    private javax.swing.JPanel students_management;
    private javax.swing.JCheckBox sun;
    private javax.swing.JButton sv_btn1;
    public static View.schedule_generation.third_panel third_panel1;
    private javax.swing.JCheckBox thurs;
    private javax.swing.JPanel timeslots_panel;
    private javax.swing.JPanel timetable_management;
    private javax.swing.JTextField title;
    private javax.swing.JCheckBox tues;
    private View.student.update_section update_section1;
    private javax.swing.JLabel update_section_lbl;
    private View.section.update_section_panel update_section_panel1;
    private javax.swing.JPanel viewAllCourses;
    private javax.swing.JPanel viewData;
    private View.viewtimetable_panel.View_all_clashes_panel view_all_clashes_panel1;
    private javax.swing.JLabel view_all_faculty;
    private javax.swing.JLabel view_all_roomslbl1;
    private javax.swing.JButton view_coursesbtn;
    private javax.swing.JButton view_facultybtn;
    private View.viewtimetable_panel.view_generated_timetable_panel view_generated_timetable_panel1;
    private javax.swing.JButton view_labsbtn;
    private javax.swing.JButton view_programsbtn;
    private javax.swing.JButton view_roomsbtn;
    private View.section.view_schedule_of_section view_schedule_of_section1;
    private View.room.view_schedule_panel view_schedule_panel1;
    private View.professor.view_schedule_of_professor_panel view_schedule_panel2;
    private View.section.view_section_details_option_panel view_section_details_option_panel1;
    private View.section.view_section_details_panel view_section_details_panel1;
    private View.student.view_student_details_panel view_student_details_panel1;
    private javax.swing.JPanel view_timetable;
    private javax.swing.JCheckBox wed;
    private javax.swing.JPanel welcome_window;
    private javax.swing.JPanel working_days_panel;
    // End of variables declaration//GEN-END:variables
}
