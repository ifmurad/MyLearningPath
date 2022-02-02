public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 15));
        System.out.println(getGreatestCommonDivisor(12, 30));
        System.out.println(getGreatestCommonDivisor(9, 18));
        System.out.println(getGreatestCommonDivisor(81, 153));
    }
    public static int getGreatestCommonDivisor(int first, int second) {
        if(first < 10 || second < 10) {
            return -1;
        }
        int greatestCommonDivisor = 0;
        int minNum = Math.min(first, second);
        int maxNum = Math.max(first, second);
        for(int i = 1; i <= minNum; i++) {
            if(minNum % i == 0 && i > greatestCommonDivisor && maxNum % i == 0) {
                greatestCommonDivisor = i;
            }
        }
        return greatestCommonDivisor;
    }
}
