package db;

//import com.toedter.calendar.JDateChooser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class DBConnection {

    private static Connection conn;

    public static Connection getConnection() // method 
    {
        return conn;
    }

    public static void createConnection() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/server1?", "root", "tariq143");
            System.out.println("connection is successfull");
        } catch (Exception ex) {
//            ex.printStackTrace();
            System.out.println(ex);
            JOptionPane.showMessageDialog(null, "Error in Connecting to Database", "Error", JOptionPane.ERROR_MESSAGE);
//        return null ; 
        }
    }

    static int getting_Club_ID(String club_name) {
        int clubID = -1;
        String query1 = "select Club_id from league.club where name = ?  limit 1 ";
        try {
            PreparedStatement stmt1 = DBConnection.getConnection().prepareStatement(query1);  // searching Club ID Query 
            stmt1.setString(1, club_name);
            ResultSet rs = stmt1.executeQuery();
            if (rs.next()) {
                clubID = rs.getInt(1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error in FInding Key of Club", "Connection", JOptionPane.ERROR_MESSAGE);
        }
        return clubID;
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

} // main class

