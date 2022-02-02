public class LastDigitChecker {
    public static void main(String[] args) {
        System.out.println(hasSameLastDigit(41, 22, 71));
        System.out.println(hasSameLastDigit(23, 32, 42));
        System.out.println(hasSameLastDigit(9, 99, 999));
    }
    public static boolean hasSameLastDigit(int num1, int num2, int num3) {
        if(!isValid(num1) || !isValid(num2) || !isValid(num3)) {
            return false;
        }
        return (num1 % 10 == num2 % 10) || (num2 % 10 == num3 % 10) || (num1 % 10 == num3 % 10);
    }
    public static boolean isValid(int number) {
        return number >= 10 && number <= 1000;
    }
}
