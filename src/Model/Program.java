package Model;

import Model.semester.Semester;
import db.DBConnection;
import static db.DBConnection.getConnection;
import static db.DBConnection.createConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Program {

    int id;
    String name;
    ArrayList<Semester> semesters;

    public Program(int id, String name, ArrayList<Semester> semesters) {
        this.id = id;
        this.name = name;
        this.semesters = semesters;
    }

    public Program(int id, String name) {
        this.id = id;
        this.name = name;
    }
    

    public Program() {
    }

    public static int get_total_no_of_programs() {
        Connection conn = db.DBConnection.getConnection();
        int total_programs = 0;
        String query = "select COUNT(*) from schedulerdb.program ";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                total_programs = rs.getInt(1);
            }
        } catch (Exception ex) {

        }
        return total_programs;
    }

    public static ResultSet get_all_programs() {
        ResultSet rs = null;
        String query = "select program_name as 'Program Name' from program";
        try {
            PreparedStatement stmt1 = getConnection().prepareStatement(query);
            rs = stmt1.executeQuery();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Fetching Data of programs", "Program", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    /**
     *
     * @param program_name
     * @return
     */
    public static int program_id(String program_name) {
        String q = "select program_id from program where program_name = '" + program_name + "'";
        try {
            PreparedStatement stmt = getConnection().prepareStatement(q);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Fetching all Data of programs", "Program", JOptionPane.ERROR_MESSAGE);
        }
        return -1;
    }

    public static ResultSet get_all_data_of_programs() {
        ResultSet rs = null;
        String query = "SELECT program_name as 'Program Name', COUNT(*) as Semesters FROM program join semester where semester.program_id = program.program_id group by program_name;";
        try {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query);
            rs = stmt1.executeQuery();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Fetching all Data of programs", "Program", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(ArrayList<Semester> semesters) {
        this.semesters = semesters;
    }

    @Override
    public String toString() {
        return "Program{" + "id=" + id + ", name=" + name + ", semesters=" + semesters + '}';
    }
    

}
