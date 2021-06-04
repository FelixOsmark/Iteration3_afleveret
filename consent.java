package sample;

import java.sql.*;
import java.util.Scanner;

public class consent {


    public static void setConsent(Integer Status, Integer CPR) {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        String insert = "INSERT INTO cdb.consent ( status, CPR)" + " values ( ?, ? )";


        try (Connection con = DriverManager.getConnection(url, null, password)) {


            PreparedStatement preparedStmt = con.prepareStatement(insert);
            preparedStmt.setInt(1, Status);
            preparedStmt.setInt(2, CPR);
            preparedStmt.execute();
            System.out.println("Consent given");
        }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void statusConsent(Integer CPR) {

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        String select = "Select * FROM cdb.consent Where CPR =" + CPR;
        try (Connection con = DriverManager.getConnection(url, null, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select)) {

            while (rs.next()) {
                Integer status = rs.getInt(2);
                System.out.println("Youre Consent status (1= true 0=false): " + status);
            }
        }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void updateConsent(Integer Status, Integer CPR) {

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        String update = "UPDATE cdb.consent SET status = ? WHERE CPR =?";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            PreparedStatement preparedStmt = con.prepareStatement(update);
            preparedStmt.setInt(1, Status);
            preparedStmt.setInt(2, CPR);
            preparedStmt.execute();
            System.out.println("Status updatet");


        }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
