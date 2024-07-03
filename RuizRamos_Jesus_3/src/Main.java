public class Main {
    public static void main(String[] args) {
        Collector John = new Collector(1,"John",'a');
        Collector Joe = new Collector(2,"Joe",'b');
        System.out.println(John.toString());
        System.out.println(Joe.toString());

        Transaction trans1 = new Transaction("Michelangelo", John, Joe, 2000, 2013);
        System.out.println(trans1.toString());
    }
}
