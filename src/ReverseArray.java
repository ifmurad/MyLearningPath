import java.util.Arrays;
public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        reverse(array);
    }
    private static void reverse(int[] array) {
        int[] reversedArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversedArray[i] = array[i];
        }
        int temp;
        for(int i = 0; i < reversedArray.length/2; i++) {
            temp = reversedArray[i];
            reversedArray[i] = reversedArray[reversedArray.length-1-i];
            reversedArray[reversedArray.length-1-i] = temp;
        }
        System.out.println("Array = " + Arrays.toString(array));
        System.out.println("Reversed Array = " + Arrays.toString(reversedArray));
    }
}
