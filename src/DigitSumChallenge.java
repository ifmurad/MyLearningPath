public class DigitSumChallenge {
    public static void main(String[] args) {
        System.out.println(sumDigits(125));
        System.out.println(sumDigits(-125));
        System.out.println(sumDigits(4));
        System.out.println(sumDigits(32123));
    }
    public static int sumDigits(int number) {
        if(number < 10) {
            return -1;
        }
        int digitSum = 0;
        while (number > 0) {
            digitSum += number % 10;
            number /= 10;
        }
        return digitSum;
    }
}
