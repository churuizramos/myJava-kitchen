import java.util.*;

public class Main {
    private static void requestValue(String letter, double [] array, int position) {
        do {
            System.out.print("Enter side " + letter + ": ");
            Scanner sc = new Scanner(System.in);
            array[position-1] = sc.nextDouble();
            if (array[position-1] < 1) {
                System.out.println("!Must be greater than 0!");
            }
        } while (array[position-1] < 1);
    }
    public static void main(String[] args) {
        double[] sidesArray = new double[3];

        requestValue("a", sidesArray, 1);
        requestValue("b", sidesArray, 2);
        requestValue("c", sidesArray, 3);

        Triangle t = new Triangle(sidesArray[0], sidesArray[1], sidesArray[2]);
    }
}