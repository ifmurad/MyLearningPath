public class FlourPacker {
    public static void main(String[] args) {
        System.out.println(canPack(1, 0, 4));
        System.out.println(canPack(1, 0, 5));
        System.out.println(canPack(0, 5, 4));
        System.out.println(canPack(2, 2, 11));
        System.out.println(canPack(-3, 2, 12));
        System.out.println(canPack(2, 0, 9));
        System.out.println(canPack(1, 5, 9));
        System.out.println(canPack(2, 1, 5));
    }
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        int TotalKilos = 5 * bigCount + smallCount;
        int diffKilos = TotalKilos - goal;

        if(diffKilos == 0) {
            return true;
        } else if(diffKilos < 0) {
            return false;
        } else if(diffKilos <= smallCount) {
            return true;
        } else return diffKilos / 5 <= bigCount && diffKilos % 5 <= smallCount;
    }
}
/*Write a method named getLargestPrime with one parameter of type int named number.

If the number is negative or does not have any prime numbers, the method should return -1 to indicate an invalid value.


The method should calculate the largest prime factor of a given number and return it.


EXAMPLE INPUT/OUTPUT:

* getLargestPrime (21); should return 7 since 7 is the largest prime (3 * 7 = 21)

* getLargestPrime (217); should return 31 since 31 is the largest prime (7 * 31 = 217)

* getLargestPrime (0); should return -1 since 0 does not have any prime numbers

* getLargestPrime (45); should return 5 since 5 is the largest prime (3 * 3 * 5 = 45)

* getLargestPrime (-1); should return -1 since the parameter is negative


HINT: Since the numbers 0 and 1 are not considered prime numbers, they cannot contain prime numbers.

NOTE: The method getLargestPrime should be defined as public static like we have been doing so far in the course.

NOTE: Do not add a main method to the solution code.*/
