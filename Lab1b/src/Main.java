import java.util.*;

public class Main {
    public static void main(String[] args) {
        int fact;
        do {
            System.out.print("Enter number for factorial: ");
            Scanner input = new Scanner(System.in);
            fact = input.nextInt();

            if (fact < 1) {
                System.out.println("The value you entered is not valied");
            }
        } while (fact < 1);

        System.out.print(fact + "! = ");
        FactorialFunc factorial = new FactorialFunc(fact);
        System.out.println("= " + factorial.getFact());
    }
}