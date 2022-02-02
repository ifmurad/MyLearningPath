public class FirstLastDigitSum {
    public static void main(String[] args) {
        System.out.println(sumFirstAndLastDigit(252));
        System.out.println(sumFirstAndLastDigit(257));
        System.out.println(sumFirstAndLastDigit(0));
        System.out.println(sumFirstAndLastDigit(5));
        System.out.println(sumFirstAndLastDigit(-10));
    }
    public static int sumFirstAndLastDigit(int number) {
        if(number < 0) {
            return -1;
        }
        int digitLast = number % 10;
        int digitFirst = number % 10;
        while(number > 0) {
            digitFirst = number % 10;
            number /= 10;
        }
        return digitFirst + digitLast;
    }
}
