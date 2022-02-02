import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year of birth: ");


        if(scanner.hasNextInt()) {
            int yearOfBirth = scanner.nextInt();
            scanner.nextLine();
            int currentYear = 2022;
            int age = currentYear-yearOfBirth;

            System.out.println("Enter you name: ");
            String name = scanner.nextLine();

            if(age >= 0 && age <= 100) {
                System.out.println("Your name is " + name + ", and you are " +
                        age + " years old");
            } else {
                System.out.println("Invalid year of birth");
            }
        } else {
            System.out.println("Unable to parse year of birth.");
        }
        scanner.close();
    }
}