import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Triangle area calculator.\nHow would you like to input the side lengths:\n1) Keyboard | 2) .txt File");
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                TriangleKBInput triangleKB = new TriangleKBInput();
                break;

            case 2:
                TriangleFileInput triangleFile = new TriangleFileInput();
        }
    }
}