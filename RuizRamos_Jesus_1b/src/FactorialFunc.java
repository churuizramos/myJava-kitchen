import java.util.Scanner;

public class FactorialFunc {
    int fact;
    public FactorialFunc(int n) {
        fact = 1;
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " * ");
            fact = fact * i;
        }
    }
    public int getFact()
    {
        return fact;
    }
}
