package sample;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Mutation {


    public static void addMutation(String type, String sDate1, Integer ZIPcode) {

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.parse(sDate1, formatter);
        Date birthdate = Date.valueOf(localDate);

        String insert = "INSERT INTO cdb.mutation ( type, registerDate, ZIPcode)" + " values ( ?, ?, ? )";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            PreparedStatement preparedStmt = con.prepareStatement(insert);
            preparedStmt.setString(1, type);
            preparedStmt.setDate(2, birthdate);
            preparedStmt.setInt(3, ZIPcode);
            preparedStmt.execute();
            System.out.println("Mutation added");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void updateMutation(String type1, String type2) {

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        String update = "UPDATE cdb.mutation SET type = ? WHERE type =?";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            PreparedStatement preparedStmt = con.prepareStatement(update);
            preparedStmt.setString(1, type2);
            preparedStmt.setString(2, type1);
            preparedStmt.execute();
            System.out.println("Mutation updatet");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static boolean isRegisterMutationType(String type) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            Statement stmt = con.createStatement();
            String select = "SELECT * FROM cdb.mutation WHERE type =" + type;
            ResultSet rs = stmt.executeQuery(select);

            while (rs.next()) {

                return type != null;
            }


        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        }

        return false;
    }
}


