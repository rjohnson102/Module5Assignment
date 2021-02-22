package edu.wctc.Classes;

import edu.wctc.Exceptions.InvalidBirthdayException;
import edu.wctc.Exceptions.MissingNameException;
import edu.wctc.Exceptions.UnknownGenderCodeException;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
	// write your code here
        RunMenu();
    }

    public static void RunMenu(){
        System.out.println("First Name: ");
        String firstName = scanner.nextLine().toUpperCase();
        System.out.println("Middle Initial");
        String middle = scanner.nextLine().toUpperCase();
        System.out.println("Last Name: ");
        String lastName = scanner.nextLine().toUpperCase();
        System.out.println("Birth year: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Birth month: ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Birth day: ");
        int day = Integer.parseInt(scanner.nextLine());
        System.out.println("Gender: (M or F)");
        char gender = scanner.next().toUpperCase().charAt(0);

        try{
            DriversLicense driversLicense = new DriversLicense();
            LastNameUtility lastNameUtility = new LastNameUtility();
            FirstNameUtility firstNameUtility = new FirstNameUtility();
            MonthDayGenderUtility monthDayGenderUtility = new MonthDayGenderUtility();
            WisconsinFormatter wisconsinFormatter = new WisconsinFormatter();
            FloridaFormatter floridaFormatter = new FloridaFormatter();

            driversLicense.setSSSS(lastNameUtility.encodeLastName(lastName));
            driversLicense.setFFF(firstNameUtility.encodeFirstName(firstName, middle));
            driversLicense.setYY(year);
            driversLicense.setDDD(monthDayGenderUtility.encodeMonthDayGender(year, month, day, gender));
            driversLicense.setNN(00);

            String wisconsin = wisconsinFormatter.formatLicenseNumber(driversLicense);
            String florida = floridaFormatter.formatLicenseNumber(driversLicense);
            System.out.println("Wisconsin: " + wisconsin);
            System.out.println("Florida: " + florida);
        }catch(InvalidBirthdayException e){
            System.out.println(e.getMessage());
        }
        catch(MissingNameException e){
            System.out.println(e.getMessage());
        }
        catch (UnknownGenderCodeException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            e.getMessage();
        }

    }
}
