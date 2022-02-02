import java.util.Scanner;

public class ReadingUserInputChallenge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int counter = 1;
        int sum = 0;
        while(counter < 11) {
            System.out.println("Enter number #" + counter);
            if(scanner.hasNextInt()){
                int userNumber = scanner.nextInt();
                scanner.nextLine();
                sum += userNumber;
                counter++;
            } else {
                System.out.println("Invalid Number. Please, try again.");
                scanner.nextLine();
            }
        }
        System.out.println("Sum of entered numbers = " + sum);

        scanner.close();
    }
}
