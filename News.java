package sample;

import java.sql.*;


public class News {
    public static void main(String[] args) {
        mutationList();
    }

    public static void mutationList() {
        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        String select = "SELECT * FROM cdb.mutation";

        try (Connection con = DriverManager.getConnection(url, null, password);
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(select)) {

            while (rs.next()) {

                String type = rs.getString("type");

                System.out.println("type:" + type);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}