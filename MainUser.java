package sample;

import java.util.Scanner;
import java.sql.SQLException;

public class MainUser {

    public static void mainPatient() {
        boolean runMainPatient = true;
        Scanner scanner = new Scanner(System.in);
        Login loginPatient = new Login();

        while (runMainPatient) {
            Scanner scanner3 = new Scanner(System.in);
            System.out.println("Welcome to you're Main");
            System.out.println("Welcome - choose between:"
                    + "(1) News" + "(2) Consent" + "(3) PersonalData\n"
                    + "(4) Contact doc" + "(5) Log off");

            Integer choice = Integer.parseInt(scanner3.nextLine());
            switch (choice) {
                case 1:
                    news.mutationList();
                    break;
                case 2:
                    boolean runmainConsent = true;
                    while (runmainConsent) {
                        consent.statusConsent(loginPatient.CPR);

                        System.out.print("Enter number to update status (1= true/0=false): ");
                        Integer status = Integer.parseInt(scanner.nextLine());
                        consent.updateConsent(status, loginPatient.CPR);
                        break;
                    }
                case 3:
                    patientData.addPatientData();

                case 4:
                    System.out.println("Contact Doc");
                case 5:
                    System.out.println("Logged of");
                    runMainPatient = false;
                    break;
            }
        }

    }

    public static void mainHealthProf() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean runMainHealthProf = true;
        while (runMainHealthProf) {

            System.out.println("Success Login - Welcome to you're Main");
            System.out.println("Welcome - choose between:"
                    + "(1) PatientData" + "(2) Mutation" + "(3) Log off");

            Integer choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("PatientData");
                case 2:
                    boolean runmainMutation = true;
                    while (runmainMutation) {

                        Mutation mutation = new Mutation();
                        System.out.print("(1) add "+ "(2) update" +"(3) Lookup Type");
                        Integer status = Integer.parseInt(scanner.nextLine());
                        if (status == 1)
                            System.out.print("Enter Type: ");
                        String type = scanner.nextLine();

                        System.out.print("Enter registreDate: ");
                        String sDate1 = scanner.nextLine();

                        System.out.print("Enter ZIPcode: ");
                        Integer ZIPcode = Integer.parseInt(scanner.nextLine());
                        mutation.addMutation(type, sDate1, ZIPcode);

                        if (status == 2)
                            System.out.print("Enter type1 to change: ");
                        String type1 = scanner.nextLine();

                        System.out.print("Enter type2 new type: ");
                        String type2 = scanner.nextLine();
                        mutation.updateMutation(type1, type2);

                        if (status == 3)
                            System.out.print("Enter type to look up");
                        String type3 = scanner.nextLine();
                        System.out.println(Mutation.isRegisterMutationType(type3));
                        break;
                    }
                case 3:
                    System.out.println("Logged of");
                    runMainHealthProf = false;
                    break;
            }
        }

    }


    public static void mainStakeHolder() {
        Scanner scanner = new Scanner(System.in);
        boolean runMainStakeHolder = true;
        while (runMainStakeHolder) {

            System.out.println("Success Login - Welcome to you're Main");
            System.out.println("Welcome - choose between:"
                    + "(1) XML report" + "(2) Log off");

            Integer choice4 = Integer.parseInt(scanner.nextLine());
            switch (choice4) {
                case 1:
                    System.out.println("XML Report");

                case 2:
                    System.out.println("Logged of");
                    runMainStakeHolder = false;
                    break;
            }
        }
    }
}
