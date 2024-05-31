import java.util.Scanner;

public class TriangleKBInput {
    public TriangleKBInput() {
        double[] sides = new double[3];

        requestValue("a", sides, 0);
        requestValue("b", sides, 1);
        requestValue("c", sides, 2);

        System.out.println("The triangle has:");
        double semiPerimeter = ((sides[0] + sides[1] + sides[2])*0.5);
        System.out.println("Semiperimeter: " + semiPerimeter);
        System.out.println("Area: " + Math.sqrt(semiPerimeter*(semiPerimeter-sides[0])*(semiPerimeter-sides[1])*(semiPerimeter-sides[2])));
    }
    private static void requestValue(String letter, double [] array, int position) {
        do {
            System.out.print("Enter side " + letter + ": ");
            Scanner sc = new Scanner(System.in);
            array[position] = sc.nextDouble();
            if (array[position] < 1) {
                System.out.println("!Must be greater than 0!");
            }
        } while (array[position] < 1);
    }
}
