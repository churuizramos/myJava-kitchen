import java.util.*;

public class Main {
    public static void main(String[] args) {
        double a, b, c;

        do {
            System.out.print("Enter side a: ");
            Scanner sc = new Scanner(System.in);
            a = sc.nextDouble();
            if (a < 1) {
                System.out.println("!Must be greater than 0!");
            }
        } while (a < 1);

        do {
            System.out.print("Enter side a: ");
            Scanner sc = new Scanner(System.in);
            b = sc.nextDouble();
            if (b < 1) {
                System.out.println("!Must be greater than 0!");
            }
        } while (b < 1);

        do {
            System.out.print("Enter side a: ");
            Scanner sc = new Scanner(System.in);
            c = sc.nextDouble();
            if (c < 1) {
                System.out.println("!Must be greater than 0!");
            }
        } while (c < 1);

        Triangle t = new Triangle(a, b, c);
    }
}