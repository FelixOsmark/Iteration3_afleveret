package sample;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class patientData {
    //create/modify patients
    //add/edit tests,
    // and add/edit results of the tests.


    public static void addPatientData () {
        CreateUser user = new CreateUser();
        user.createPatient();

    }

    public static void setTestData (Boolean result, String type, String sDate1, Integer idHP, Integer CPR ){

        String url = "jdbc:mysql://127.0.0.1:3306/?user=root";
        String password = "Sveners3j5321!";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.parse(sDate1, formatter);
        Date birthdate = Date.valueOf(localDate);

        String insert = "INSERT INTO cdb.test ( result, type, testDate, idHP, CPR )" + " values ( ?, ?, ?, ?, ? )";


        try (Connection con = DriverManager.getConnection(url, null, password)) {

            PreparedStatement preparedStmt = con.prepareStatement(insert);
            preparedStmt.setBoolean(1, result);
            preparedStmt.setString(2, type);
            preparedStmt.setDate(3, birthdate);
            preparedStmt.setInt(4, idHP);
            preparedStmt.setInt(5, CPR);
            preparedStmt.execute();
            System.out.println("TestData set");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }


    public static void setGeoLocationData () {

    }
    public static void setSensorData () {


    }

    public static void updatePatientData () {
    }

    public static void resultPatientData (String Name, Integer CPR){
        // latest infection rates in a geographical area
        //provide information such as the postal code of the area
        //date range (e.g. from 1/01/21 to 01/02/21)


        //output
        //summary of how many patients in the postal area have been tested positive, and which mutation they have contracted

        //case the patient has provided consent, the system could use
        // geolocation to know whether the patient's last location appeared in the postal code,
        // otherwise, the system will use the postal code of the patient's address.
        // store the results in an XML file

    }
}
