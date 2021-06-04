package sample;

import java.sql.SQLException;
import java.util.Scanner;

public class Login {

    private static String HealthProfName;
    private static String patientName;
    private static String StakeHolderName;
    Integer CPR;

    public boolean patientLogin() throws SQLException {
        boolean run = true;

        while (run) {

            Scanner scanner = new Scanner(System.in);

            boolean correct = true;
            while (correct) {
                System.out.print("Enter Username: ");
                patientName = scanner.nextLine();
                System.out.print("Enter CPR: ");
                CPR = Integer.parseInt(scanner.nextLine());

                return Validator.isRegisterPatient(patientName) && Validator.isRegisterPatientCPR(CPR);

            }
            run = false;
        }
        return false;
    }

    public boolean healthProfLogin() throws SQLException {
        boolean run = true;

        while (run) {

            Scanner scanner = new Scanner(System.in);

            boolean correct = true;
            while (correct) {
                System.out.print("Enter HealthProfName: ");
                HealthProfName = scanner.nextLine();

                return Validator.isRegisterHealthProf(HealthProfName);

            }
            run = false;
        }
        return false;
    }

    public boolean stakeHolderLogin() throws SQLException {
        boolean run = true;

        while (run) {

            Scanner scanner = new Scanner(System.in);

            boolean correct = true;
            while (correct) {
                System.out.print("Enter StakeHolderName: ");
                StakeHolderName = scanner.nextLine();
                System.out.print("Enter CPR: ");
                CPR = Integer.parseInt(scanner.nextLine());

                return Validator.isRegisterStakeHolder(StakeHolderName) && Validator.isRegisterStakeHolderCPR(CPR);

            }
            run = false;
        }
        return false;
    }

}


