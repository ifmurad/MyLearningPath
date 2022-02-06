import java.util.Arrays;
import java.util.Scanner;

public class SortedArray {
    public static void main(String[] args) {
        int[] myIntegers = getIntegers(5);
        printArray(sortIntegers(myIntegers));
    }
    public static int[] sortIntegers(int [] array) {
        int[] sortedArray = Arrays.copyOf(array, array.length);
        boolean flag = true;
        int temp;
        while (flag) {
            flag = false;
            for(int i=0; i<sortedArray.length-1; i++) {
                if(sortedArray[i] < sortedArray[i+1]) {
                    temp = sortedArray[i];
                    sortedArray[i] = sortedArray[i+1];
                    sortedArray[i+1] = temp;
                    flag = true;
                }
            }
        }
        return sortedArray;
    }
    public static void printArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " contents " + array[i]);
        }
    }
    public static int[] getIntegers(int number) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter " + number + " values.");
        int [] array = new int[number];
        for(int i = 0; i < array.length; i++) {
            if(scanner.hasNextInt()) {
                array[i] = scanner.nextInt();
            } else {
                System.out.println("Entered value has to be an integer.");
                i--;
            }
            scanner.nextLine();
        }
        scanner.close();
        return array;
    }
}
