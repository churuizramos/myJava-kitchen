import java.text.DecimalFormat;

/**
 * Including information about a transaction involving any piece of art
 */
public class Transaction {
    private String pieceName;
    private double sales;
    private int year;

    private Collector seller, buyer;

    /**
     * Creates a Transaction object to be stored in the TransactionDB class
     * @param pieceName Name of the piece being sold
     * @param seller The Collector object providing the piece
     * @param buyer The Collector object receiving the piece
     * @param sales double value representing the cost of the Transaction
     * @param year integer value representing the date
     */
    public Transaction(String pieceName, Collector seller, Collector buyer, double sales, int year) {
        this.pieceName = pieceName;
        this.seller = seller;
        this.buyer = buyer;
        this.sales = sales;
        this.year = year;
    }

    /**
     * Prints all the Transaction info as String
     * @return String in format [pieceName sold by seller to buyer for $sales in year]
     */
    public String toString() {
        DecimalFormat salesFormat = new DecimalFormat("0.00");
        return "[" + pieceName + " sold by " + seller + " to " + buyer + " for $" + salesFormat.format(sales) + " in " + year + "]";
    }

    /**
     * Getters
     */
    public double getSales() {
        return sales;
    }
    public int getYear() {
        return year;
    }
}
