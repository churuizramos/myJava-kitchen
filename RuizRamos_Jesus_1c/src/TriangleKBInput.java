import java.util.Scanner;

public class TriangleKBInput {
    public TriangleKBInput(double a, double b, double c) {
        System.out.println("The triangle has:");
        double semiPerimeter = ((a + b + c)*0.5);
        System.out.println("Semiperimeter: " + semiPerimeter);
        System.out.println("Area: " + Math.sqrt(semiPerimeter*(semiPerimeter-a)*(semiPerimeter-b)*(semiPerimeter-c)));
    }
//    private static void requestValue(String letter, double [] array, int position) {
//        do {
//            System.out.print("Enter side " + letter + ": ");
//            Scanner sc = new Scanner(System.in);
//            array[position-1] = sc.nextDouble();
//            if (array[position-1] < 1) {
//                System.out.println("!Must be greater than 0!");
//            }
//        } while (array[position-1] < 1);
//    }
}
