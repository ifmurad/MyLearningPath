public class SumOddRange {
    public static void main(String[] args) {
        System.out.println(sumOdd(1, 100));
        System.out.println(sumOdd(-1, 100));
        System.out.println(sumOdd(100, 100));
        System.out.println(sumOdd(13, 13));
    }
    public static boolean isOdd(int number) {
        if(number <= 0) {
            return false;
        }
        return number % 2 == 1;
    }
    public static int sumOdd(int start, int end) {
        if(start <= 0 || end <= 0 || start > end) {
            return -1;
        }
        int sum = 0;
        for(int i = start; i <= end; i++) {
            if(isOdd(i)) {
                sum += i;
            }
        }
        return sum;
    }
}
