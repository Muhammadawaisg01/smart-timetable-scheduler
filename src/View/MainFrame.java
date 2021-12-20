package View;

import Model.Course;
import Model.professor.Professor;
import Model.Program;
import Model.Queries;
import Model.room.Room;
import View.room.search_by_capacity;
import static View.section.create_section_panel.getPrograms;
import static View.section.create_section_panel.getCourses;
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
import java.awt.HeadlessException;
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
//        programs_panels_list.add(view_section_details_option_panel);
        programs_panels_list.add(view_section_details_panel1);
        programs_panels_list.add(add_new_semester_panel1);
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
//        students_panels_list.add(view_student_details_panel);
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

//    @Override
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
        jLabel2 = new javax.swing.JLabel();
        MainPanel_ScrollPane = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
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
        students = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        Dept = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        course = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        scheduler_generation = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        view_timetable = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
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
        remove_faculty_member_lbl = new javax.swing.JLabel();
        add_roomlbl1 = new javax.swing.JLabel();
        all_rooms = new javax.swing.JLabel();
        add_roomlbl = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        search_slot_lbl = new javax.swing.JLabel();
        all_labs_lbl = new javax.swing.JLabel();
        view_all_roomslbl1 = new javax.swing.JLabel();
        view_all_faculty = new javax.swing.JLabel();
        add_new_professor = new javax.swing.JLabel();
        lab_view_schedule_lbl = new javax.swing.JLabel();
        view_schedule_lbl = new javax.swing.JLabel();
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
        jTextField3 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
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
        jPanel47 = new javax.swing.JPanel();
        all_programs_details_panel = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        programs_table = new javax.swing.JTable();
        create_section_panel1 = new View.section.create_section_panel();
        add_new_program1 = new View.section.add_new_program();
        view_section_details_panel1 = new View.section.view_section_details_panel();
        add_new_semester_panel1 = new View.section.add_new_semester_panel();
        remove_section_panel1 = new View.section.remove_section_panel();
        update_section_panel1 = new View.section.update_section_panel();
        view_schedule_of_section1 = new View.section.view_schedule_of_section();
        professor_course_allocation1 = new View.section.Professor_course_allocation();
        add_new_program = new View.section.add_new_program();
        Courses = new javax.swing.JPanel();
        jPanel49 = new javax.swing.JPanel();
        Dashboard_Courses = new javax.swing.JPanel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
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
        jTextField22 = new javax.swing.JTextField();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        room_wise_lbl = new javax.swing.JLabel();
        add_roomlbl9 = new javax.swing.JLabel();
        add_roomlbl10 = new javax.swing.JLabel();
        add_roomlbl11 = new javax.swing.JLabel();
        section_wise_lbl = new javax.swing.JLabel();
        professor_wise_lbl = new javax.swing.JLabel();
        std_wise_lbl = new javax.swing.JLabel();
        add_roomlbl17 = new javax.swing.JLabel();
        add_roomlbl12 = new javax.swing.JLabel();
        jPanel25 = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jPanel26 = new javax.swing.JPanel();
        view_generated_timetable_panel1 = new View.viewtimetable_panel.view_generated_timetable_panel();
        view_all_clashes_panel1 = new View.viewtimetable_panel.View_all_clashes_panel();
        students_management = new javax.swing.JPanel();
        jPanel56 = new javax.swing.JPanel();
        Dashboard_std_management = new javax.swing.JPanel();
        jTextField23 = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        home_std_lbl = new javax.swing.JLabel();
        update_section_lbl = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        jLabel118 = new javax.swing.JLabel();
        jPanel27 = new javax.swing.JPanel();
        update_section1 = new View.student.update_section();

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
        MainPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 230, 50));

        MainPanel_ScrollPane.setBorder(null);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel9.add(program, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 240, 130));

        students.setBackground(new java.awt.Color(255, 255, 255));
        students.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        students.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                studentsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                studentsMouseExited(evt);
            }
        });
        students.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 102, 153));
        jLabel9.setText("Students");
        students.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 22, 246, -1));

        jPanel9.add(students, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, 130));

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

        jPanel9.add(Dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 260, 130));

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

        jPanel9.add(course, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 260, 130));

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

        jPanel9.add(scheduler_generation, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 170, 400, 130));

        view_timetable.setBackground(new java.awt.Color(255, 255, 255));
        view_timetable.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 153), 2, true));
        view_timetable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_timetableMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                view_timetableMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                view_timetableMouseExited(evt);
            }
        });
        view_timetable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 102, 153));
        jLabel26.setText("View Timetable");
        view_timetable.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 290, -1));

        jPanel9.add(view_timetable, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, -1, 130));

        MainPanel_ScrollPane.setViewportView(jPanel9);

        MainPanel.add(MainPanel_ScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 1010, 440));

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

        jPanel45.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Dept.setBackground(new java.awt.Color(0, 102, 153));
        Dashboard_Dept.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel42.setText("Home");
        jLabel42.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel42.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel42MouseClicked(evt);
            }
        });
        Dashboard_Dept.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 240, 70));

        jPanel12.setBackground(new java.awt.Color(0, 102, 153));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel47.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("Department");
        jLabel47.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel47.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel47MouseClicked(evt);
            }
        });
        jPanel12.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 210, 40));

        remove_faculty_member_lbl.setBackground(new java.awt.Color(0, 102, 153));
        remove_faculty_member_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        remove_faculty_member_lbl.setForeground(new java.awt.Color(0, 102, 153));
        remove_faculty_member_lbl.setText("remove member");
        remove_faculty_member_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                remove_faculty_member_lblMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                remove_faculty_member_lblMouseEntered(evt);
            }
        });
        jPanel12.add(remove_faculty_member_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 170, 30));

        add_roomlbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_roomlbl1.setForeground(new java.awt.Color(0, 51, 51));
        add_roomlbl1.setText("Rooms                             -");
        add_roomlbl1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel12.add(add_roomlbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 230, 30));

        all_rooms.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        all_rooms.setForeground(new java.awt.Color(255, 255, 255));
        all_rooms.setText("All rooms");
        all_rooms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        all_rooms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_roomsMouseClicked(evt);
            }
        });
        jPanel12.add(all_rooms, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 200, 30));

        add_roomlbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_roomlbl.setForeground(new java.awt.Color(255, 255, 255));
        add_roomlbl.setText("Create new");
        add_roomlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_roomlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_roomlblMouseClicked(evt);
            }
        });
        jPanel12.add(add_roomlbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 210, 30));

        jLabel44.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(0, 51, 51));
        jLabel44.setText("Labs                                  -");
        jLabel44.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel12.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 230, 40));

        search_slot_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        search_slot_lbl.setForeground(new java.awt.Color(255, 255, 255));
        search_slot_lbl.setText("search Slot");
        search_slot_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        search_slot_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                search_slot_lblMouseClicked(evt);
            }
        });
        jPanel12.add(search_slot_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, 210, 40));

        all_labs_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        all_labs_lbl.setForeground(new java.awt.Color(255, 255, 255));
        all_labs_lbl.setText("All labs");
        all_labs_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        all_labs_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                all_labs_lblMouseClicked(evt);
            }
        });
        jPanel12.add(all_labs_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 220, 30));

        view_all_roomslbl1.setBackground(new java.awt.Color(0, 102, 153));
        view_all_roomslbl1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        view_all_roomslbl1.setForeground(new java.awt.Color(0, 51, 51));
        view_all_roomslbl1.setText("Faculty                           -");
        view_all_roomslbl1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        view_all_roomslbl1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_all_roomslbl1MouseClicked(evt);
            }
        });
        jPanel12.add(view_all_roomslbl1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 220, 40));

        view_all_faculty.setBackground(new java.awt.Color(0, 102, 153));
        view_all_faculty.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        view_all_faculty.setForeground(new java.awt.Color(255, 255, 255));
        view_all_faculty.setText("All members");
        view_all_faculty.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_all_faculty.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_all_facultyMouseClicked(evt);
            }
        });
        jPanel12.add(view_all_faculty, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 210, 30));

        add_new_professor.setBackground(new java.awt.Color(0, 102, 153));
        add_new_professor.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_new_professor.setForeground(new java.awt.Color(255, 255, 255));
        add_new_professor.setText("add new");
        add_new_professor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        add_new_professor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_new_professorMouseClicked(evt);
            }
        });
        jPanel12.add(add_new_professor, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 180, 30));

        lab_view_schedule_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lab_view_schedule_lbl.setForeground(new java.awt.Color(0, 102, 153));
        lab_view_schedule_lbl.setText("view Schedule");
        lab_view_schedule_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab_view_schedule_lblMouseClicked(evt);
            }
        });
        jPanel12.add(lab_view_schedule_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 150, 40));

        view_schedule_lbl.setBackground(new java.awt.Color(0, 102, 153));
        view_schedule_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        view_schedule_lbl.setForeground(new java.awt.Color(0, 102, 153));
        view_schedule_lbl.setText("view Schedule");
        view_schedule_lbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        view_schedule_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                view_schedule_lblMouseClicked(evt);
            }
        });
        jPanel12.add(view_schedule_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 150, 30));

        jScrollPane10.setViewportView(jPanel12);

        Dashboard_Dept.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 280, 430));

        jPanel45.add(Dashboard_Dept, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 570));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new java.awt.CardLayout());
        jPanel3.add(room_input_panel1, "card5");
        jPanel3.add(view_schedule_panel1, "card6");
        jPanel3.add(view_schedule_panel2, "card9");
        jPanel3.add(add_professor_panel1, "card8");
        jPanel3.add(search_free_slot_panel1, "card7");

        dept_details_panel.setBackground(new java.awt.Color(255, 255, 255));
        dept_details_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(0, 102, 153));
        jLabel46.setText("Faculty members:");
        dept_details_panel.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 232, 210, 30));

        dept_name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        dept_name.setForeground(new java.awt.Color(0, 102, 153));
        dept_name.setText("Department Name");
        dept_details_panel.add(dept_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 26, 440, 30));

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

        Dashboard_Programs.setBackground(new java.awt.Color(0, 102, 153));
        Dashboard_Programs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField3.setText("Programs");
        Dashboard_Programs.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 88, 210, 30));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Home");
        jLabel50.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel50MouseClicked(evt);
            }
        });
        Dashboard_Programs.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 200, 30));

        jPanel28.setBackground(new java.awt.Color(0, 102, 153));
        jPanel28.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(51, 0, 51));
        jLabel51.setText("Program                         -");
        jLabel51.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel28.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 220, 30));

        jLabel79.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel79.setForeground(new java.awt.Color(51, 0, 51));
        jLabel79.setText("Section                           - ");
        jLabel79.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel28.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 230, 30));

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel119.setForeground(new java.awt.Color(255, 255, 255));
        jLabel119.setText("Add New Program");
        jLabel119.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel119.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel119MouseClicked(evt);
            }
        });
        jPanel28.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 200, 30));

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel120.setForeground(new java.awt.Color(255, 255, 255));
        jLabel120.setText("Create New Section");
        jLabel120.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel120.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel120MouseClicked(evt);
            }
        });
        jPanel28.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 200, 30));

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel121.setForeground(new java.awt.Color(255, 255, 255));
        jLabel121.setText("View All Program");
        jLabel121.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel121.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel121MouseClicked(evt);
            }
        });
        jPanel28.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 200, 40));

        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel122.setForeground(new java.awt.Color(255, 255, 255));
        jLabel122.setText("Remove Section");
        jLabel122.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel122.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel122MouseClicked(evt);
            }
        });
        jPanel28.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 200, 40));

        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel125.setForeground(new java.awt.Color(255, 255, 255));
        jLabel125.setText("View Section Details");
        jLabel125.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel125.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel125MouseClicked(evt);
            }
        });
        jPanel28.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 200, 40));

        UpdateSection.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        UpdateSection.setForeground(new java.awt.Color(0, 102, 153));
        UpdateSection.setText("update details");
        UpdateSection.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UpdateSectionMouseClicked(evt);
            }
        });
        jPanel28.add(UpdateSection, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 200, 40));

        jScrollPane14.setViewportView(jPanel28);

        Dashboard_Programs.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 280, 430));

        jPanel2.add(Dashboard_Programs, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 570));

        jPanel47.setBackground(new java.awt.Color(255, 255, 255));
        jPanel47.setLayout(new java.awt.CardLayout());

        all_programs_details_panel.setBackground(new java.awt.Color(255, 255, 255));
        all_programs_details_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(0, 102, 153));
        jLabel54.setText("All Programs:");
        all_programs_details_panel.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 170, 30));

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

        all_programs_details_panel.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 650, 390));

        jPanel47.add(all_programs_details_panel, "card3");
        jPanel47.add(create_section_panel1, "card7");
        jPanel47.add(add_new_program1, "card3");
        jPanel47.add(view_section_details_panel1, "card5");
        jPanel47.add(add_new_semester_panel1, "card6");
        jPanel47.add(remove_section_panel1, "card8");
        jPanel47.add(update_section_panel1, "card9");
        jPanel47.add(view_schedule_of_section1, "card10");
        jPanel47.add(professor_course_allocation1, "card11");
        jPanel47.add(add_new_program, "card10");

        jPanel2.add(jPanel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 790, 570));

        Programs.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-2, 0, 1060, 570));

        getContentPane().add(Programs, "card5");

        Courses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel49.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Courses.setBackground(new java.awt.Color(0, 102, 153));
        Dashboard_Courses.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("View all ");
        jLabel55.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 200, 30));

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel56.setText("Home");
        jLabel56.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel56.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel56MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 210, 50));

        jLabel63.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Remove");
        jLabel63.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel63.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel63MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 200, 30));

        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel88.setForeground(new java.awt.Color(255, 255, 255));
        jLabel88.setText("Add new");
        jLabel88.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel88.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel88MouseClicked(evt);
            }
        });
        Dashboard_Courses.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 210, 40));

        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel95.setForeground(new java.awt.Color(0, 51, 51));
        jLabel95.setText("Courses                           -");
        jLabel95.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        Dashboard_Courses.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 230, 30));

        jLabel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Dashboard_Courses.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 280, 10));

        jPanel49.add(Dashboard_Courses, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 570));

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
        crs_code.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crs_codeActionPerformed(evt);
            }
        });
        addCourse.add(crs_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 360, 30));

        title.setForeground(new java.awt.Color(0, 102, 153));
        addCourse.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 220, 360, 30));

        credit_hours.setForeground(new java.awt.Color(0, 102, 153));
        addCourse.add(credit_hours, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 270, 360, 30));

        labcheckBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labcheckBox.setForeground(new java.awt.Color(0, 102, 153));
        labcheckBox.setText("has Lab");
        addCourse.add(labcheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 320, 110, 40));

        jButton6.setBackground(new java.awt.Color(0, 102, 153));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("add course");
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
        delCourse.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 190, 40));

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel110.setForeground(new java.awt.Color(0, 102, 153));
        jLabel110.setText("Remove Course");
        delCourse.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 210, 50));

        jButton10.setBackground(new java.awt.Color(0, 102, 153));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("Remove Course");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        delCourse.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 460, 240, 70));

        course_title_dropdown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        course_title_dropdown.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                course_title_dropdownItemStateChanged(evt);
            }
        });
        delCourse.add(course_title_dropdown, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 470, 40));

        course_details_textarea.setColumns(20);
        course_details_textarea.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        course_details_textarea.setForeground(new java.awt.Color(0, 102, 153));
        course_details_textarea.setRows(5);
        course_details_textarea.setText("Course Details:");
        jScrollPane15.setViewportView(course_details_textarea);

        delCourse.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 680, -1));

        jPanel6.add(delCourse, "card4");

        jPanel49.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 570));

        Courses.add(jPanel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 570));

        getContentPane().add(Courses, "card5");

        schedule_generation.setBackground(new java.awt.Color(255, 255, 255));
        schedule_generation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Dashboard_Dept1.setBackground(new java.awt.Color(0, 102, 153));
        Dashboard_Dept1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel68.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel68.setText("Home");
        jLabel68.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel68.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel68.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel68MouseClicked(evt);
            }
        });
        Dashboard_Dept1.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 210, 70));

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

        Dashboard_timetable.setBackground(new java.awt.Color(0, 102, 153));
        Dashboard_timetable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField22.setText(" ");
        Dashboard_timetable.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 88, 210, 30));

        jLabel45.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("   Home");
        jLabel45.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel45MouseClicked(evt);
            }
        });
        Dashboard_timetable.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 90, 50));

        jPanel22.setBackground(new java.awt.Color(0, 102, 153));
        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 51, 51));
        jLabel48.setText("Timetable                       -");
        jLabel48.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel48MouseClicked(evt);
            }
        });
        jPanel22.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 220, 40));

        room_wise_lbl.setBackground(new java.awt.Color(0, 102, 153));
        room_wise_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        room_wise_lbl.setForeground(new java.awt.Color(255, 255, 255));
        room_wise_lbl.setText("room-wise");
        room_wise_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                room_wise_lblMouseClicked(evt);
            }
        });
        jPanel22.add(room_wise_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 160, 30));

        add_roomlbl9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_roomlbl9.setForeground(new java.awt.Color(0, 102, 153));
        add_roomlbl9.setText("Clashes                             -");
        add_roomlbl9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_roomlbl9MouseClicked(evt);
            }
        });
        jPanel22.add(add_roomlbl9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 230, 30));

        add_roomlbl10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_roomlbl10.setForeground(new java.awt.Color(0, 102, 153));
        add_roomlbl10.setText("professor-wise");
        add_roomlbl10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_roomlbl10MouseClicked(evt);
            }
        });
        jPanel22.add(add_roomlbl10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 150, 30));

        add_roomlbl11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_roomlbl11.setForeground(new java.awt.Color(0, 102, 153));
        add_roomlbl11.setText("reassign professor");
        add_roomlbl11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_roomlbl11MouseClicked(evt);
            }
        });
        jPanel22.add(add_roomlbl11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 220, 30));

        section_wise_lbl.setBackground(new java.awt.Color(0, 102, 153));
        section_wise_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        section_wise_lbl.setForeground(new java.awt.Color(255, 255, 255));
        section_wise_lbl.setText("section-wise");
        section_wise_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                section_wise_lblMouseClicked(evt);
            }
        });
        jPanel22.add(section_wise_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 210, 30));

        professor_wise_lbl.setBackground(new java.awt.Color(0, 102, 153));
        professor_wise_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        professor_wise_lbl.setForeground(new java.awt.Color(255, 255, 255));
        professor_wise_lbl.setText("professor-wise");
        professor_wise_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                professor_wise_lblMouseClicked(evt);
            }
        });
        jPanel22.add(professor_wise_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 160, 30));

        std_wise_lbl.setBackground(new java.awt.Color(0, 102, 153));
        std_wise_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        std_wise_lbl.setForeground(new java.awt.Color(255, 255, 255));
        std_wise_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                std_wise_lblMouseClicked(evt);
            }
        });
        jPanel22.add(std_wise_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 170, 30));

        add_roomlbl17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_roomlbl17.setForeground(new java.awt.Color(0, 102, 153));
        add_roomlbl17.setText("Delete timetable");
        add_roomlbl17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_roomlbl17MouseClicked(evt);
            }
        });
        jPanel22.add(add_roomlbl17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 150, 30));

        add_roomlbl12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        add_roomlbl12.setForeground(new java.awt.Color(0, 102, 153));
        add_roomlbl12.setText("student-wise");
        add_roomlbl12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                add_roomlbl12MouseClicked(evt);
            }
        });
        jPanel22.add(add_roomlbl12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 170, 30));

        jScrollPane11.setViewportView(jPanel22);

        Dashboard_timetable.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 280, 440));

        jPanel13.add(Dashboard_timetable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 570));

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

        Dashboard_std_management.setBackground(new java.awt.Color(0, 102, 153));
        Dashboard_std_management.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextField23.setText("Students Panel");
        jTextField23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField23ActionPerformed(evt);
            }
        });
        Dashboard_std_management.add(jTextField23, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 88, 210, 30));

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("View all");
        jLabel59.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel59MouseClicked(evt);
            }
        });
        Dashboard_std_management.add(jLabel59, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 200, 30));

        home_std_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        home_std_lbl.setForeground(new java.awt.Color(255, 255, 255));
        home_std_lbl.setText("   Home");
        home_std_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                home_std_lblMouseClicked(evt);
            }
        });
        Dashboard_std_management.add(home_std_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 190, 30));

        update_section_lbl.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        update_section_lbl.setForeground(new java.awt.Color(255, 255, 255));
        update_section_lbl.setText("change section");
        update_section_lbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                update_section_lblMouseClicked(evt);
            }
        });
        Dashboard_std_management.add(update_section_lbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 200, 30));

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel115.setForeground(new java.awt.Color(255, 255, 255));
        jLabel115.setText("view_details");
        jLabel115.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel115MouseClicked(evt);
            }
        });
        Dashboard_std_management.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 190, 30));

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel118.setForeground(new java.awt.Color(255, 255, 255));
        jLabel118.setText("Students                           -");
        jLabel118.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel118MouseClicked(evt);
            }
        });
        Dashboard_std_management.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 230, 30));

        jPanel56.add(Dashboard_std_management, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 280, 580));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));
        jPanel27.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel27MouseClicked(evt);
            }
        });
        jPanel27.setLayout(new java.awt.CardLayout());
        jPanel27.add(update_section1, "card3");

        jPanel56.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 780, 580));

        students_management.add(jPanel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1060, 580));

        getContentPane().add(students_management, "card5");

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

    private void programMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programMouseEntered
        program.setBackground(new Color(0, 102, 153));
        jLabel25.setForeground(new Color(255, 255, 255));
//        Border brd = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED) ; 
//        program.setBorder(brd) ; 
    }//GEN-LAST:event_programMouseEntered

    private void courseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseMouseClicked
        MainPanel.setVisible(false);
        Courses.setVisible(true);
    }//GEN-LAST:event_courseMouseClicked

    private void courseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseMouseEntered
        course.setBackground(new Color(0, 102, 153));
        jLabel8.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_courseMouseEntered

    private void studentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseClicked

        students_management.setVisible(true);
        MainPanel.setVisible(false);
    }//GEN-LAST:event_studentsMouseClicked

    private void studentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseEntered
        students.setBackground(new Color(0, 102, 153));
        jLabel9.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_studentsMouseEntered

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

    private void scheduler_generationMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduler_generationMouseEntered
        scheduler_generation.setBackground(new Color(0, 102, 153));
        jLabel5.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_scheduler_generationMouseEntered

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

    private void view_timetableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_timetableMouseEntered
        view_timetable.setBackground(new Color(0, 102, 153));
        jLabel26.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_view_timetableMouseEntered

    private void programMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_programMouseExited
        program.setBackground(new Color(255, 255, 255));
        jLabel25.setForeground(new Color(0, 102, 153));

    }//GEN-LAST:event_programMouseExited

    private void DeptMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeptMouseEntered
        Dept.setBackground(new Color(0, 102, 153));
        jLabel6.setForeground(new Color(255, 255, 255));
    }//GEN-LAST:event_DeptMouseEntered

    private void DeptMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DeptMouseExited
        Dept.setBackground(new Color(255, 255, 255));
        jLabel6.setForeground(new Color(0, 102, 153));
    }//GEN-LAST:event_DeptMouseExited

    private void courseMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseMouseExited
        course.setBackground(new Color(255, 255, 255));
        jLabel8.setForeground(new Color(0, 102, 153));
    }//GEN-LAST:event_courseMouseExited

    private void add_roomlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_roomlblMouseClicked
        department_panel_visibility(room_input_panel1);
    }//GEN-LAST:event_add_roomlblMouseClicked

    private void remove_faculty_member_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove_faculty_member_lblMouseClicked
//        add_room.setVisible(false) ;
//        department_panel_visibility();
//        viewData.setVisible(true);
//        display_table.setModel(TableViewUtility.resultSetToTableModel(Room.get_every_room()));
    }//GEN-LAST:event_remove_faculty_member_lblMouseClicked

    private void jLabel68MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel68MouseClicked
        this.MainPanel.setVisible(true);
        this.Department.setVisible(false);
        this.Courses.setVisible(false);
        this.schedule_generation.setVisible(false);
    }//GEN-LAST:event_jLabel68MouseClicked

    private void scheduler_generationMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scheduler_generationMouseExited
        scheduler_generation.setBackground(new Color(255, 255, 255));
        jLabel5.setForeground(new Color(0, 102, 153));
    }//GEN-LAST:event_scheduler_generationMouseExited

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
//                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
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

    private void lab_view_schedule_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_view_schedule_lblMouseClicked
        department_panel_visibility(view_schedule_panel1);
    }//GEN-LAST:event_lab_view_schedule_lblMouseClicked

    private void delbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delbtnActionPerformed
        //        String room_name = room_name1.getText().trim() ;
        //        if(Room.remove_room(room_name)){
        //            JOptionPane.showMessageDialog(null, "Room removed successfully");
        //            room_name1.setText(null);
        //        }
    }//GEN-LAST:event_delbtnActionPerformed

    private void view_schedule_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_schedule_lblMouseClicked
        department_panel_visibility(view_schedule_panel1);
    }//GEN-LAST:event_view_schedule_lblMouseClicked

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
        view_schedule.entity_name_lbl.setText("Room  : ");
        view_timetable_panel_visibility(view_generated_timetable_panel1);
    }//GEN-LAST:event_room_wise_lblMouseClicked

    private void add_roomlbl9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_roomlbl9MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_add_roomlbl9MouseClicked

    private void add_roomlbl10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_roomlbl10MouseClicked
        view_timetable_panel_visibility(view_all_clashes_panel1);
        view_all_clashes_panel1.entity_name.setText("Professor-wise");
    }//GEN-LAST:event_add_roomlbl10MouseClicked

    private void add_roomlbl11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_roomlbl11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_add_roomlbl11MouseClicked

    private void section_wise_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_section_wise_lblMouseClicked
        String[] data = Queries.getData("section_id", "section");
        search_for_specific_entity.setDropdownData(data);
        view_generated_timetable_panel.entity_name_lbl.setText("Section-wise");
        search_for_specific_entity.entity_name_lbl.setText("Section :  ");
        view_schedule.entity_name_lbl.setText("Section : ");
        view_timetable_panel_visibility(view_generated_timetable_panel1);
    }//GEN-LAST:event_section_wise_lblMouseClicked

    private void professor_wise_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_professor_wise_lblMouseClicked
        String[] data = Queries.getData("name", "professor");
        search_for_specific_entity.setDropdownData(data);
        view_generated_timetable_panel.entity_name_lbl.setText("Professor-wise");
        search_for_specific_entity.entity_name_lbl.setText("Professor  :  ");
        view_schedule.entity_name_lbl.setText("Professor : ");
        view_timetable_panel_visibility(view_generated_timetable_panel1);
    }//GEN-LAST:event_professor_wise_lblMouseClicked

    private void std_wise_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_std_wise_lblMouseClicked
        String[] data = Queries.getData("registration_no", "students");
        search_for_specific_entity.setDropdownData(data);
        view_generated_timetable_panel.entity_name_lbl.setText("Student-wise");
        search_for_specific_entity.entity_name_lbl.setText("Student  :  ");
        view_schedule.entity_name_lbl.setText("Student : ");
        view_timetable_panel_visibility(view_generated_timetable_panel1);
    }//GEN-LAST:event_std_wise_lblMouseClicked

    private void add_roomlbl17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_roomlbl17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_add_roomlbl17MouseClicked

    private void add_roomlbl12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_roomlbl12MouseClicked
        view_timetable_panel_visibility(view_all_clashes_panel1);
        view_all_clashes_panel1.entity_name.setText("Student-wise");
    }//GEN-LAST:event_add_roomlbl12MouseClicked

    private void view_timetableMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_view_timetableMouseExited
        view_timetable.setBackground(new Color(255, 255, 255));
        jLabel26.setForeground(new Color(0, 102, 153));
    }//GEN-LAST:event_view_timetableMouseExited

    private void studentsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentsMouseExited
        students.setBackground(new Color(255, 255, 255));
        jLabel9.setForeground(new Color(0, 102, 153));
    }//GEN-LAST:event_studentsMouseExited

    private void crs_codeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crs_codeActionPerformed
    }//GEN-LAST:event_crs_codeActionPerformed

    private void jLabel59MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel59MouseClicked
//        students_panel_visibility(view_all_students_panel1);
    }//GEN-LAST:event_jLabel59MouseClicked

    private void home_std_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_home_std_lblMouseClicked
        MainPanel.setVisible(true);
        students_management.setVisible(false);
    }//GEN-LAST:event_home_std_lblMouseClicked

    private void update_section_lblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_update_section_lblMouseClicked
        students_panel_visibility(update_section1);
    }//GEN-LAST:event_update_section_lblMouseClicked

    private void jLabel115MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel115MouseClicked
//        students_panel_visibility(view_student_details_panel1);
    }//GEN-LAST:event_jLabel115MouseClicked

    private void jLabel118MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel118MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel118MouseClicked

    private void jPanel27MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel27MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel27MouseClicked

    private void jTextField23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField23ActionPerformed

    private void jLabel119MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel119MouseClicked
        programs_panel_visibility(add_new_program);
    }//GEN-LAST:event_jLabel119MouseClicked

    private void jLabel125MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel125MouseClicked
//        programs_panel_visibility(view_section_details_option_panel);
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
        // TODO add your handling code here:
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

    private void remove_faculty_member_lblMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_remove_faculty_member_lblMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_remove_faculty_member_lblMouseEntered

    private void course_title_dropdownItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_course_title_dropdownItemStateChanged
        String courseTitle = course_title_dropdown.getSelectedItem().toString();
        String courseCode = Queries.getCourseCode(courseTitle);
        ResultSet courseDetails = Queries.getCourseDetails(courseCode);

        String str = "Course Details:";
        try {
            if(courseDetails.next()) {
                str += "\nCourse Code: \t" + courseDetails.getString("course_code").toUpperCase();
                str += "\nCourse Title: \t" + courseDetails.getString("title").toUpperCase();
                str += "\nCredit Hours: \t" + courseDetails.getInt("credit_hours");
                if (courseDetails.getString("hasLab").equalsIgnoreCase("false")) {
                    str += "\nHas Lab: \tNO";
                } else {
                    str += "\nHas Lab: \tYES";
                }
                
                course_details_textarea.setText(str);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_course_title_dropdownItemStateChanged

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
                createConnection();
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
    private View.section.add_new_semester_panel add_new_semester_panel1;
    private View.professor.add_professor_panel add_professor_panel1;
    private javax.swing.JLabel add_roomlbl;
    private javax.swing.JLabel add_roomlbl1;
    private javax.swing.JLabel add_roomlbl10;
    private javax.swing.JLabel add_roomlbl11;
    private javax.swing.JLabel add_roomlbl12;
    private javax.swing.JLabel add_roomlbl17;
    private javax.swing.JLabel add_roomlbl9;
    private javax.swing.JLabel all_labs_lbl;
    private javax.swing.JPanel all_programs_details_panel;
    private javax.swing.JLabel all_rooms;
    private javax.swing.JLabel available_datalbl;
    private javax.swing.JLabel back_lbl_02;
    private javax.swing.JLabel back_lbl_1;
    private javax.swing.JPanel course;
    static javax.swing.JTextArea course_details_textarea;
    private javax.swing.JComboBox<String> course_title_dropdown;
    private javax.swing.JTable coursesTable;
    private javax.swing.JLabel courseslbl;
    public static View.section.create_section_panel create_section_panel1;
    private javax.swing.JTextField credit_hours;
    private javax.swing.JTextField crs_code;
    private javax.swing.JPanel delCourse;
    private javax.swing.JButton delbtn;
    private javax.swing.JTextField dep_name;
    private javax.swing.JPanel dept_details_panel;
    private javax.swing.JLabel dept_name;
    private javax.swing.JPanel dept_name_panel;
    private javax.swing.JTable display_table;
    private cambodia.raven.Time end;
    public static View.schedule_generation.excel_file_panel excel_file_panel1;
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
    private javax.swing.JLabel jLabel4;
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
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel99;
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
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel3;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField23;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JLabel lab_view_schedule_lbl;
    private javax.swing.JCheckBox labcheckBox;
    private javax.swing.JLabel labslbl;
    private javax.swing.JCheckBox mon;
    private javax.swing.JLabel nxt_lbl_1;
    private javax.swing.JLabel nxt_lbl_2;
    public static View.section.Professor_course_allocation professor_course_allocation1;
    private javax.swing.JLabel professor_wise_lbl;
    private javax.swing.JLabel professorslbl;
    private javax.swing.JPanel program;
    private javax.swing.JTable programs_table;
    private javax.swing.JLabel programslbl;
    private javax.swing.JLabel remove_faculty_member_lbl;
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
    private javax.swing.JLabel std_wise_lbl;
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
    private javax.swing.JLabel view_schedule_lbl;
    private View.section.view_schedule_of_section view_schedule_of_section1;
    private View.room.view_schedule_panel view_schedule_panel1;
    private View.professor.view_schedule_of_professor_panel view_schedule_panel2;
    private View.section.view_section_details_panel view_section_details_panel1;
    private javax.swing.JPanel view_timetable;
    private javax.swing.JCheckBox wed;
    private javax.swing.JPanel welcome_window;
    private javax.swing.JPanel working_days_panel;
    // End of variables declaration//GEN-END:variables
}
