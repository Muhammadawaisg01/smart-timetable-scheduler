package db;

//import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DBConnection {

    private static Connection conn;

    public static Connection getConnection() // method 
    {
        return conn;
    }

    public static void createConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/schedulerdb", "newuser", "password");
            System.out.println("connection is successfull");
        } catch (SQLException ex) {
//            ex.printStackTrace();
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error in Connecting to Database", "Error", JOptionPane.ERROR_MESSAGE);
//        return null ; 
        }
    }

 

    static ResultSet searching_City(String city_name) {
        ResultSet rs = null;
        String query4 = "select City_id from league.city where name = ? ";
        try {
            PreparedStatement stmt;
            stmt = DBConnection.getConnection().prepareStatement(query4);
            stmt.setString(1, city_name);
            rs = stmt.executeQuery();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in Getting Data From City Table", "DBConnection Class(M1)", JOptionPane.ERROR_MESSAGE);
        }
        return rs;
    }
    
    public static ResultSet executeQuery(String query) {
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            return stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void execute(String query) {
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String[] rsToList(ResultSet rs) {
        String[] list = null;
        try {
            if (rs.last()) {
                list = new String[rs.getRow()];
                rs.beforeFirst();
                int i = 0;
                while (rs.next()) {
                    list[i] = rs.getString(1);
                    i++;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new String[1];
    }

} // main class

