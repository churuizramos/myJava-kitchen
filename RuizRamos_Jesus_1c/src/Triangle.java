public class Triangle {
    public Triangle(double a, double b, double c) {
        System.out.println("The triangle has:");
        double semiPerimeter = ((a + b + c)*0.5);
        System.out.println("Semiperimeter: " + semiPerimeter);
        System.out.println("Area: " + Math.sqrt(semiPerimeter*(semiPerimeter-a)*(semiPerimeter-b)*(semiPerimeter-c)));
    }
}
