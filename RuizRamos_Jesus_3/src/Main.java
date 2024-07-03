import java.util.*;
import java.text.*;

public class Main {
    public static void main(String[] args) {
        TransactionDB trDB = new TransactionDB();

        trDB.add(new Transaction(
                "Mona Lisa",
                new Collector(123,"John",'C'),
                new Collector(124, "Joe",'C'),
                2000,
                2014
        ));
        trDB.add(new Transaction(
                "David",
                new Collector(124,"Joe",'C'),
                new Collector(125,"Mike",'N'),
                30000,
                1996
        ));

        System.out.println(trDB.getEntry(0));
        System.out.println(trDB.toString());
    }
}
