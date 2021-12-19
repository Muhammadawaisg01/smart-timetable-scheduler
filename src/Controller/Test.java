package Controller;

import Model.Program;
import Model.Queries;
import static db.DBConnection.createConnection;
import java.io.File;
import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        createConnection();
//        Queries.mapSectionSchedule_ToStudents();
//        File file = new File("Student Registration.csv");
//        Queries.addStudentsToDB(file);
//          Queries.assignSectionToStudents(1);
//        Queries.createInitialStudentSchedule();
        Queries.mapSectinoSchedule_ToProfessors();

//        createConnection();
//        ArrayList<Program> programs1 = NewAlgorithm.algorithm_based_on_randomization();
//        System.out.println("\n\n\n\n\n\n\n\n\n\n");
//        System.out.println("____________________________________________________________________________");
//        Queries.updateSchedule(programs1);
    }
}
