/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schedule;

import Model.Queries;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER
 */
public class DisplayTemplate extends javax.swing.JPanel {

    /**
     * Creates new form DisplayTemplate
     */
    public DisplayTemplate() {
        initComponents();
        table.setShowGrid(false);
        table.setBackground(new Color(50, 50, 50));
        table.setForeground(Color.WHITE);
        table.setFont(new Font("Arial", Font.BOLD, 14));
        table.setRowHeight(30);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void displayOneSection(String SectionID) {
        emptyTable();
        displaySectionDetails(SectionID);
    }

    public void displayAllSection() {
        emptyTable();
        ResultSet sections = Queries.getRS("select section_id from section");
        try {
            while (sections.next()) {
                displaySectionDetails(sections.getString("section_id"));
                addRow(new String[7]);
                addRow(new String[7]);
                addRow(new String[7]);
                addRow(new String[7]);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void displayProfessorSchedule(int professorID) {
        String name = Queries.getProfessorName(professorID);
        emptyTable();
        String[] professorName = {"", "", "", name, "", "", ""};
        addRow(professorName);
        int slots = Queries.getSlotCount();
        for (int slot = 1; slot < slots + 1; slot++) {
            String q = "select course_code from professor_schedule"
                    + " where professor_id = " + professorID + " and timeslot_no = " + slot;
            try {
                String[] courses = createCoursesRow(Queries.getRS(q));
                if (courses != null) {
                    print(courses);
                } else {
                    System.out.println("courses are null");
                }
                courses[0] = Queries.getSlotDuration(slot);
                addRow(courses);
                q = "select room_name from professor_schedule where professor_id = '" + professorID + "' and timeslot_no = " + slot;
                String[] rooms = createRow(Queries.getRS(q));
                if (rooms != null) {
                    print(rooms);
                } else {
                    System.out.println("rooms are null");
                }
                rooms[0] = "Room #";
                addRow(rooms);
            } catch (NullPointerException ex) {
            }

        }
        addRow(new String[7]);
        addRow(new String[7]);
        addRow(new String[7]);
        // display professor courses

        String coursesAllocations = "SELECT * FROM section_professor_allocation join course using (course_code) where professor_id = " + professorID;
        ResultSet allocations = Queries.getRS(coursesAllocations);
        try {
            String[] allocationsHeaders = {"Course Code", "Title", "", "", "Type", "", "Section ID"};
            addRow(allocationsHeaders);
            String courseCode, title, sectionID, lab;
            while (allocations.next()) {
                courseCode = allocations.getString("course_code");
                title = allocations.getString("title");
                sectionID = allocations.getString("section_id");
                lab = allocations.getString("lab_or_theory");
                String[] newRow = {courseCode, title, "", "", lab, "", sectionID};
                addRow(newRow);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void displayStudentSchedule(String regNo) {
        String name = Queries.getStudent(regNo);
        emptyTable();
        String[] studentName = {"", "", "", name, "", "", ""};
        addRow(studentName);
        int slots = Queries.getSlotCount();
        for (int slot = 1; slot < slots + 1; slot++) {
            String q = "select course_code from student_schedule"
                    + " where student_registration_no = '" + regNo + "' and timeslot_no = " + slot;
            try {
                String[] courses = createRow(Queries.getRS(q));
                courses[0] = Queries.getSlotDuration(slot);
                addRow(courses);
                String getRooms = "select room_name from student_schedule where student_registration_no = '" + regNo + "' and timeslot_no = " + slot;
                String[] rooms = createRow(Queries.getRS(getRooms));
                rooms[0] = "Room #";
                addRow(rooms);
            } catch (NullPointerException ex) {
//                System.out.println("");
            }

        }
        addRow(new String[7]);
        addRow(new String[7]);
        addRow(new String[7]);
        // display professor courses

        String coursesAllocations = "SELECT course_code, section_ID, title, credit_hours, hasLab "
                + "FROM student_section_allocation join course using (course_code) "
                + "where student_registration_no='" + regNo + "';";
        ResultSet allocations = Queries.getRS(coursesAllocations);
        try {
            String[] allocationsHeaders = {"Course Code", "Title", "", "Credit Hours", "Type", "", "Section ID"};
            addRow(allocationsHeaders);
            String courseCode, title, sectionID, lab;
            int creditHours;
            while (allocations.next()) {
                courseCode = allocations.getString("course_code");
                title = allocations.getString("title");
                sectionID = allocations.getString("section_ID");
                creditHours = allocations.getInt("credit_hours");
                lab = allocations.getString("hasLab");
                String[] newRow = {courseCode, title, "", creditHours + "", lab, "", sectionID};
                addRow(newRow);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayTemplate.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NullPointerException ex) {
            Logger.getLogger(DisplayTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void displaySectionDetails(String sectionID) {
        String[] sectionName = {"", "", "", sectionID, "", "", ""};
        addRow(sectionName);
        addHR();
        int slots = Queries.getSlotCount();
        for (int slot = 1; slot < slots + 1; slot++) {
            String q = "select course_code from section_schedule where section_id = '" + sectionID + "' and timeslot_no = " + slot;
            String[] courses = createRow(Queries.getRS(q));
            courses[0] = Queries.getSlotDuration(slot);
            addRow(courses);
            q = "select room_name from section_schedule where section_id = '" + sectionID + "' and timeslot_no = " + slot;
            String[] rooms = createRow(Queries.getRS(q));
            rooms[0] = "Room #";
            addRow(rooms);
            addHR();
        }
        addRow(new String[7]);
        String getProfessors = "SELECT "
                + "course_code, title, hasLab, name, credit_hours "
                + "FROM "
                + "section_professor_allocation join course using (course_code)"
                + " join professor using (professor_id)"
                + " where "
                + "section_id = '" + sectionID + "'";
        ResultSet courseAllocations = Queries.getRS(getProfessors);
        try {
            String[] allocations = {"Course Code", "Title", "", "Credit Hours", "Lab", "", "Professor"};
            addRow(allocations);
            while (courseAllocations.next()) {
                allocations = new String[7];
                allocations[0] = courseAllocations.getString("course_code");
                allocations[1] = courseAllocations.getString("title");
                allocations[3] = courseAllocations.getString("credit_hours");
                allocations[4] = courseAllocations.getString("hasLab");
                allocations[6] = courseAllocations.getString("name");
                addRow(allocations);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DisplayTemplate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String[] createRow(ResultSet res) {
        String[] list = null;
        try {
            if (res.last()) {
                list = new String[res.getRow() + 1];
                res.beforeFirst();
                int i = 1;
                while (res.next()) {
                    list[i] = res.getString(1);
                    i++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Template2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private String[] createCoursesRow(ResultSet courseCodes) {
        String[] list = null;
        try {
            if (courseCodes.last()) {
                list = new String[courseCodes.getRow() + 1];
                courseCodes.beforeFirst();
                int i = 1;
                while (courseCodes.next()) {
                    String course_code = courseCodes.getString("course_code");
                    if (course_code.equals("")) {
                        list[i] = "";
                    } else {
                        list[i] = Queries.getCourseTitle(course_code);
                    }
                    i++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Template2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    private void addRow(String[] row) {
        DefaultTableModel table2 = (DefaultTableModel) table.getModel();
        table2.addRow(row);
    }

    private void addHR() {
        String[] HR = {"____________", "____________", "____________", "____________", "____________",
            "___________", "____________"};
        addRow(HR);
    }

    private void emptyTable() {
        System.out.println("Empty");
        DefaultTableModel dm = (DefaultTableModel) table.getModel();
        while (dm.getRowCount() > 0) {
            dm.removeRow(0);
        }
    }

    private void print(String[] arr) {
        for (String st : arr) {
            System.out.print(st + " ");
        }
        System.out.println("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Monday", "Tuesday", "Wednessday", "Thrusday", "Friday", "Satuerday"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(102, 0, 102));
        table.setRowHeight(30);
        table.setRowMargin(3);
        jScrollPane1.setViewportView(table);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 955, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panel;
    private static javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
