/**
 * Including information about a transaction involving any piece of art
 */
public class Transaction {
    private String pieceName;
    private double sales;
    private double year;

    private Collector seller, buyer;

    public Transaction(String pieceName, Collector seller, Collector buyer, double sales, int year) {
        this.pieceName = pieceName;
        this.seller = seller;
        this.buyer = buyer;
        this.sales = sales;
        this.year = year;
    }
    public String toString() {
        return "[" + pieceName + " sold by " + seller + " to " + buyer + " for $" + sales + " in " + year + "]";
    }
}
