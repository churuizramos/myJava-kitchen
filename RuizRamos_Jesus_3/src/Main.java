public class Main {
    public static void main(String [] args)
    {
        Collector col1 = new Collector(1,"B&B Bros",'C');
        Collector col2 = new Collector(2,"Metro M",'G');
        Collector col3 = new Collector(3,"Rare Goods",'C');
        Collector col4 = new Collector(4,"FA Ctr",'N');
        Collector col5 = new Collector(5,"Mason C",'N');
        Collector col6 = new Collector(6,"CL Fabrics",'C');
        Transaction[] testtr = {new Transaction("AtlVase",col2,col1,0,2020),
                new Transaction("GldSilk",col6,col3,300000,2017),
                new Transaction("GldSilk",col5,col6,50000,2004),
                new Transaction("AtlVase",col5,col3,100000,2014),
                new Transaction("GldSilk",col3,col5,150000,2013),
                new Transaction("MPBracelet",col4,col5,0,2008)};
        TransactionDB testdb = new TransactionDB();

        System.out.println("-------------- Before Adding Transactions --------------");
        System.out.println(testdb);
        java.text.DecimalFormat dF = new java.text.DecimalFormat("0.00");
        System.out.println("A grand total of $" + dF.format(testdb.totalCost()) +
                " was spent prior to adding transactions to the DB.\n");

        for (Transaction titem : testtr)
        {
            testdb.add(titem);
        }
        System.out.println("-------------- After Adding Transactions --------------");
        System.out.println(testdb);
        System.out.println("A grand total of $" + dF.format(testdb.totalCost()) +
                " was spent on transactions in the database.\n");
        System.out.println("List of transactions occurring between 2013 and 2017:");
        testdb.printTrInDuration(2013,2017);
    }
}
