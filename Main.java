package sample;


import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {

        boolean runMain1 = true;
        while (runMain1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome - choose between:"
                    + "(1) Login "
                    + "(2) Create a User "
                    + "(3) Shutdown program ");
            System.out.println("You're choice: ");
            Integer choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    boolean runMain2 = true;
                    while (runMain2) {
                        Scanner scanner2 = new Scanner(System.in);
                        System.out.println("Login- choose between:"
                                + "(1) Patient "
                                + "(2) HealthProf "
                                + "(3) StakeHolder ");
                        System.out.println("You're choice: ");
                        Integer choice2 = Integer.parseInt(scanner2.nextLine());

                        switch (choice2) {
                            case 1:
                                Login loginPatient = new Login();
                                if (loginPatient.patientLogin()) {
                                    MainUser patientMain = new MainUser();
                                    patientMain.mainPatient();
                                }
                                else {
                                    System.out.println("User not in database - unable to login");
                                }
                                break;

                            case 2:
                                Login loginHealthProf = new Login();
                                if (loginHealthProf.healthProfLogin()) {
                                    MainUser healthProfMain = new MainUser();
                                    healthProfMain.mainHealthProf();
                                }
                                else {
                                    System.out.println("User not in database - unable to login");
                                }
                                break;

                            case 3:
                                Login loginStakeHolder = new Login();
                                if (loginStakeHolder.stakeHolderLogin()) {
                                    MainUser stakeHolderMain = new MainUser();
                                    stakeHolderMain.mainStakeHolder();
                                } else {
                                    System.out.println("User not in database - unable to login");
                                }
                                break;
                        }
                        runMain2 = false;
                    }
                    break;

                case 2:
                    boolean runMain3 = true;
                    while (runMain3) {
                        Scanner scanner3 = new Scanner(System.in);
                        System.out.println("Welcome - choose between:" +
                                "(1) Patient" +
                                "(2) HealthProf" +
                                "(3) StakeHolder");
                        System.out.println("You're choice: ");
                        Integer choice3 = Integer.parseInt(scanner3.nextLine());
                        switch (choice3) {

                            case 1:
                                CreateUser user = new CreateUser();
                                if (user.createPatient()) {
                                    System.out.println("User created - Go to login");
                                } else {
                                    System.out.println("User not created - Try again");
                                }
                                break;

                            case 2:
                                CreateUser userHealthProf = new CreateUser();
                                if (userHealthProf.createHealthProf()) {
                                    System.out.println("User created - Go to login");
                                } else {
                                    System.out.println("User not created - Try again");
                                }
                                break;

                            case 3:
                                CreateUser userStakeHold = new CreateUser();
                                if (userStakeHold.createStakeHolder()) {
                                    System.out.println("User created - Go to login");
                                } else {
                                    System.out.println("User not created - Try again");
                                }
                                break;
                        }
                    }
                    break;

                case 3:
                    System.out.println("System shutdown");
                    runMain1 = false;
            }
        }
    }
}
