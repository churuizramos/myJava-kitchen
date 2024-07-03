import java.text.DecimalFormat;
import java.text.Format;
import java.util.ArrayList;

/**
 * Maintaining information about a collection of transactions and providing some summary information about them
 */
public class TransactionDB {
    ArrayList<Transaction> transactionsList;

    /**
     * Initializes a new transactionList ArrayList
     */
    public TransactionDB() {
        transactionsList = new ArrayList<Transaction>();
    }

    /**
     * Adds a new Transaction to the transactionsList
     * @param newTr
     */
    public void add(Transaction newTr) {
        transactionsList.add(newTr);
    }

    /**
     * Returns the Transaction at a certain index
     * @param index integer pointing at which entry to read
     * @return String of the current Transaction under the index
     */
    public String getEntry(int index) {
        return transactionsList.get(index).toString();
    }

    /**
     * Returns all the Transactions in the transactionsList
     * @return transactionsList
     */
    public String toString() {
        String returnString = "";
        for (int i = 0; i < transactionsList.size(); i++) {
            returnString += (i+1) + ": " + (transactionsList.get(i).toString() + "\n");
        }
        return returnString;
    }

    /**
     * Sums up the total of all sales in the transactionsList
     * @return salesTotal double
     */
    public double totalCost() {
        double salesTotal = 0;
        for (int i = 0; i < transactionsList.size(); i++) {
            salesTotal += transactionsList.get(i).getSales();
        }
        return salesTotal;
    }

    public void printTrInDuration(int startYear, int endYear) {
        return;
    }
}
