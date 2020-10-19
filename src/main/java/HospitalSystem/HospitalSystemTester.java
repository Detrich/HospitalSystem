package HospitalSystem;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HospitalSystemTester {
    public static void main(String[] args) {
        String file = "Employee.txt";
        Scanner input = new Scanner(System.in);
        System.out.println(
                "Hello and welcome to the hospital System!\n" +
                        "You can end this program at anytime by typing close.\n" +
                        "Would you like to:\n" +
                        "Display the employee List?(DI)\n" +
                        "Add an employee?(AD)\n" +
                        "Update the database?(UP)\n" +
                        "Delete an employee?(DE)");
        String info = input.nextLine();
        if (info.toUpperCase().equals("CLOSE")) {
            return;
        }
        switch (info.substring(0, 2).toUpperCase()) {
            case "DI":
                Reader(file);
                break;
            case "AD":
                Writer(file);
                break;
            case "UP":
                Updater(file);
                break;
            case "DE":
                Deleter(file);
                break;
            default:
                System.out.println("Please choose an answer given above.");
        }
    }

    private static void Deleter(String file) {
        try {
            File EmployeeList = new File(file);
            File tempFile = new File(EmployeeList.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            Scanner scanner = new Scanner(EmployeeList);
            System.out.println("Which Employee would you like to Delete?(insert Role[HEDNASRJ] and blazer ID here)");
            Scanner input = new Scanner(System.in);
            String info = input.nextLine();
            String line;
            if (info.toUpperCase().equals("CLOSE")) {
                return;
            }
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] Employee = line.split(" ");
                String[] ParseInfo = info.split(" ");
                if (!Employee[2].equals(ParseInfo[1])) {
                    pw.println(line);
                    pw.flush();
                } else {
                    System.out.printf("%s has been removed!\n\n", Employee[1]);
                }
            }
            scanner.close();
            pw.close();
            br.close();
            EmployeeList.delete();
            tempFile.renameTo(EmployeeList);
            main(null);
        } catch (IOException e) {
            System.out.println("The file does not exist.");
            e.printStackTrace();
        }

    }

    private static void Updater(String file) {
        try {
            File EmployeeList = new File(file);
            File tempFile = new File(EmployeeList.getAbsolutePath() + ".tmp");
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
            Scanner scanner = new Scanner(EmployeeList);
            System.out.println("Which Employee would you like to Update?(insert blazerID here)");
            Scanner input = new Scanner(System.in);
            String info = input.nextLine();
            String line;
            String blazerid = null;
            ArrayList<String> ListOfBlazerIDs = new ArrayList<>();
            if (info.toUpperCase().equals("CLOSE")) {
                return;
            }
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                String[] Employee = line.split(" ");
                ListOfBlazerIDs.add(Employee[2]);
                if (Employee[2].strip().equals(info)) {
                    System.out.printf("Please insert any new information about - %s\n", line);
                    blazerid = input.nextLine();
                }
                if (!Employee[2].strip().equals(info)) {
                    pw.println(line);
                    pw.flush();
                } else if (blazerid != null) {
                    pw.println(blazerid);
                    System.out.printf("%s has been Updated!\n\n", Employee[1]);
                } else {
                    System.out.println("Nothing To update!\n\n");
                }
            }
            if (!ListOfBlazerIDs.contains(info)) {
                System.out.printf("%s is not a valid BlazerID!!!\n\n", info);
                Updater(file);
            }
            scanner.close();
            pw.close();
            br.close();
            EmployeeList.delete();
            tempFile.renameTo(EmployeeList);
            main(null);
        } catch (IOException e) {
            System.out.println("The file does not exist.");
            e.printStackTrace();
        }
    }

    public static void Writer(String file) {
        try {

            System.out.println("If you would like to add an employee please use the following formatting:\n" +
                    "Job[HEDNASRJ] Name blazerID department/speciality Operating?\n" +
                    "So an entry will look like this:\n" +
                    "S John 11111 Brain Y");
            PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            Scanner input = new Scanner(System.in);
            String info = input.nextLine();
            if (info.toUpperCase().equals("CLOSE")) {
                return;
            }
            Pattern p = Pattern.compile("(^[HEDNASRJ]\\s[\\D]+\\s[\\d]+(\\s[\\w+]+(\\s[\\w]+)?)?)");
            Matcher m = p.matcher(info);
            boolean b = m.matches();
            if (b) {
                out.println(info.strip());
                System.out.printf("%s has been added as an Employee!\n\n", info);
            } else {
                System.out.println("Pattern does not match\n\n");
                Writer(file);
            }
            out.close();
            main(null);
        } catch (IOException e) {
            System.out.println("The file does not exist.");
            e.printStackTrace();
        }
    }

    public static void Reader(String file) {
        try {
            File EmployeeList = new File(file);
            Scanner scanner = new Scanner(EmployeeList);
            ArrayList<String> ArrayListOfEmployees = new ArrayList<>();
            ArrayList<String> Employees = new ArrayList<>();
            ArrayList<String> Doctors = new ArrayList<>();
            ArrayList<String> Nurses = new ArrayList<>();
            ArrayList<String> Admins = new ArrayList<>();
            ArrayList<String> Surgeons = new ArrayList<>();
            ArrayList<String> Receptionists = new ArrayList<>();
            ArrayList<String> Janitors = new ArrayList<>();
            System.out.println(
                    "**********************************\n" +
                            "Welcome to the Employee System\n" +
                            "**********************************\n" +
                            "The Hospital System has the following employees:\n"
            );
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] nospaces = line.split(" ");
                ArrayListOfEmployees.add(line);
                switch (nospaces[0]) {
                    case "E":
                        Employee HospitalEmployee = new Employee();
                        HospitalEmployee.setName(nospaces[1]);
                        HospitalEmployee.setBlazerID(nospaces[2]);
                        Employees.add(HospitalEmployee.toString());
                        break;
                    case "D":
                        Doctor doctor = new Doctor();
                        doctor.setName(nospaces[1]);
                        doctor.setBlazerID(nospaces[2]);
                        doctor.setSpeciality(nospaces[3]);
                        Doctors.add(doctor.toString());
                        break;
                    case "N":
                        Nurse nurse = new Nurse();
                        nurse.setName(nospaces[1]);
                        nurse.setBlazerID(nospaces[2]);
                        nurse.setNumberofpatients(nospaces[3]);
                        Nurses.add(nurse.toString());
                        break;
                    case "A":
                        Administrator admin = new Administrator();
                        admin.setName(nospaces[1]);
                        admin.setBlazerID(nospaces[2]);
                        admin.setDepartment(nospaces[3]);
                        Admins.add(admin.toString());
                        break;
                    case "S":
                        Surgeon surgeon = new Surgeon();
                        surgeon.setName(nospaces[1]);
                        surgeon.setBlazerID(nospaces[2]);
                        surgeon.setDepartment(nospaces[3]);
                        surgeon.setOperating(nospaces[4]);
                        Surgeons.add(surgeon.toString());
                        break;
                    case "R":
                        Receptionist receptionist = new Receptionist();
                        receptionist.setName(nospaces[1]);
                        receptionist.setBlazerID(nospaces[2]);
                        receptionist.setDepartment(nospaces[3]);
                        receptionist.setAnswering(nospaces[4]);
                        Receptionists.add(receptionist.toString());
                        break;
                    case "J":
                        Janitor janitor = new Janitor();
                        janitor.setName(nospaces[1]);
                        janitor.setBlazerID(nospaces[2]);
                        janitor.setDepartment(nospaces[3]);
                        janitor.setSweeping(nospaces[4]);
                        Janitors.add(janitor.toString());
                        break;
                    default:
                        System.out.println("Not an employee");
                }
            }
            scanner.close();
            System.out.printf("Total Number of Employees: %d\n\n", ArrayListOfEmployees.size());
            System.out.printf("Hospital Employees: %d\n", Employees.size());
            for (String employee : Employees) {
                System.out.println(employee);
            }
            System.out.printf("\nDoctors: %d\n", Doctors.size());
            for (String doctor : Doctors) {
                System.out.println(doctor);
            }
            System.out.printf("\nSurgeons: %d\n", Surgeons.size());
            for (String doctor : Doctors) {
                System.out.println(doctor);
            }
            System.out.printf("\nNurses: %d\n", Nurses.size());
            for (String nurse : Nurses) {
                System.out.println(nurse);
            }
            System.out.printf("\nAdministrators: %d\n", Admins.size());
            for (String admin : Admins) {
                System.out.println(admin);
            }
            System.out.printf("\nReceptionists: %d\n", Receptionists.size());
            for (String receptionist : Receptionists) {
                System.out.println(receptionist);
            }
            System.out.printf("\nJanitors: %d\n", Janitors.size());
            for (String janitor : Janitors) {
                System.out.println(janitor);
            }
            System.out.println("***********************************************************************\n");
            main(null);
        } catch (IOException e) {
            System.out.println("The file does not exist.");
            e.printStackTrace();
        }
    }
}
