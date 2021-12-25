package Controller;

import Model.Program;
import Model.Queries;
import Model.Reset;
import static db.DBConnection.createConnection;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Test {

    public static void main(String[] args) {
        String query = "SELECT registration_no as RegNo, students.section_id as Section, course_code as Course, semester_no as Semester FROM server1.students join student_section_allocation where \n"
                + "registration_no = student_registration_no and\n"
                + "students.section_id = student_section_allocation.section_ID";
        System.out.println(query);
        createConnection();
//        Reset.resetSchedule();
//        Reset.resetStudents();
//        int choice = JOptionPane.showConfirmDialog(null, "Make sure you added all information. Entities added or modified after this won't effect schedule");
//        System.out.println(choice);
//        JFileChooser chooser = new JFileChooser("/");
//        int f = chooser.showSaveDialog(null);
//        if (f == JFileChooser.APPROVE_OPTION) {
//            String file = chooser.getSelectedFile().getAbsolutePath();
//            System.out.println(file);
//            File file2 = new File(file);
//            Queries.addStudentsToDB(file2);
//        }
//        createConnection();
        Queries.mapSectionSchedule_ToStudents();
        //        File file = new File("Student Registration.csv");
        //        Queries.addStudentsToDB(file);
//                  Queries.assignSectionToStudents(1);
//                Queries.createInitialStudentSchedule();
        //        Queries.mapSectinoSchedule_ToProfessors();
        //        createConnection();

        //        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        //        System.out.println("____________________________________________________________________________");
//        ArrayList<Program> programs1 = NewAlgorithm.algorithm_based_on_randomization();
//        Queries.updateSchedule(programs1);
    }
}
