import java.util.Scanner;

public class MinimumElement {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(findMin(readElements(readInteger())));
    }
    public static int readInteger() {
        int myInt = -1;
        boolean flag = true;
        System.out.println("Enter an integer:");
        while (flag){
            if(scanner.hasNextInt()) {
                myInt = scanner.nextInt();
                scanner.nextLine();
                flag = false;
            } else {
                System.out.println("Integer value has to be entered.");
            }
        }
        return myInt;
    }
    public static int findMin(int[] array) {
        int min = array[0];
        for(int i : array) {
            if(i < min) {
                min = i;
            }
        }
        return min;
    }
    public static int[] readElements(int count) {
        int[] myArray = new int[count];
        System.out.println("Enter " + count + " integers:");
        for(int i = 0; i < count; i++) {
            if(scanner.hasNextInt()) {
                myArray[i] = scanner.nextInt();
            } else {
                System.out.println("Integer value has to be entered.");
                i--;
            }
            scanner.nextLine();
        }
        return myArray;
    }
}
/*Write a method called readInteger() that has no parameters and returns an int.

It needs to read in an integer from the user - this represents how many elements the user needs to enter.

Write another method called readElements() that has one parameter of type int

The method needs to read from the console until all the elements are entered, and then return an array containing the elements entered.

And finally, write a method called findMin() with one parameter of type int[]. The method needs to return the minimum value in the array.

The scenario is:

1. readInteger() is called.

2. The number returned by readInteger() is then used to call readElements().

3. The array returned from readElements() is used to call findMin().

4. findMin() returns the minimum number.

[Do not try and implement this. It is to give you an idea of how the methods will be used]

TIP: Assume that the user will only enter numbers, never letters.

TIP: Instantiate (create) the Scanner object inside the method. There are two scanner objects, one for each of the two methods that are reading in input from the user.

TIP: Be extremely careful about spaces in the printed message.

NOTE: All methods should be defined as private static.

NOTE: Do not add a main method to the solution code.

*/