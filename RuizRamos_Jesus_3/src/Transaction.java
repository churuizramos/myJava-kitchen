import java.text.DecimalFormat;

/**
 * Including information about a transaction involving any piece of art
 */
public class Transaction {
    private String pieceName;
    private double sales;
    private int year;

    private Collector seller, buyer;

    public Transaction(String pieceName, Collector seller, Collector buyer, double sales, int year) {
        this.pieceName = pieceName;
        this.seller = seller;
        this.buyer = buyer;
        this.sales = sales;
        this.year = year;
    }
    public String toString() {
        DecimalFormat salesFormat = new DecimalFormat("0.00");
        return "[" + pieceName + " sold by " + seller + " to " + buyer + " for $" + salesFormat.format(sales) + " in " + year + "]";
    }

    /**
     * Getters
     */
    public String getBuyer() {
        return buyer.toString();
    }
    public String getSeller() {
        return seller.toString();
    }
    public double getSales() {
        return sales;
    }
    public int getYear() {
        return year;
    }
}
