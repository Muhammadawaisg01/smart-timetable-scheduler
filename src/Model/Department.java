package Model;

import static db.DBConnection.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Department {

    int dept_id;
    String name;

    public Department(int dept_id, String name) {
        this.dept_id = dept_id;
        this.name = name;
    }

    public int getDept_id() {
        return dept_id;
    }

    public void setDept_id(int dept_id) {
        this.dept_id = dept_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String get_department_name() {
        String query = "select department_name from department where department_id=1";
        String name = "";
        Connection conn = getConnection();
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error in fetching name of the department");
            System.out.println(ex);
        }
        return name;
    }
}
