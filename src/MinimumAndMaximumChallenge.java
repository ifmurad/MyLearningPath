import java.util.Scanner;

public class MinimumAndMaximumChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        int min = 0;
        int max = 0;
        int userInput;
        while(true) {
            System.out.println("Enter number:");
            if(scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                if(counter == 0 || userInput < min) {
                    min = userInput;
                }
                if(counter == 0 || userInput > max) {
                    max = userInput;
                }
            } else {
                break;
            }
            scanner.nextLine();
            counter++;
        }
        System.out.println("Minimum number = " + min);
        System.out.println("Maximum number = " + max);

        scanner.close();
    }
}
