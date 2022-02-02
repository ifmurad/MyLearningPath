public class DiagonalStar {
    public static void main(String[] args) {
        printSquareStar(20);
    }
    public static void printSquareStar(int number) {
        if(number < 5) {
            System.out.println("Invalid Value");
        } else {
            for(int rowNo = 1; rowNo <= number; rowNo++) {
                for(int columnNo = 1; columnNo <= number; columnNo++) {
                    if (rowNo == 1 || rowNo == number || columnNo == 1 ||
                            columnNo == number || rowNo == columnNo ||
                            columnNo == number-rowNo+1) {
                        System.out.print("*");
                    } else {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
        }
    }
}
