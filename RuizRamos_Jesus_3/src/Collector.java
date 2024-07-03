/**
 * CreatesDetailing information about buyers and sellers of art
 */
public class Collector {
    private int colID;
    private String colName;
    private char category; // C for commercial, N for nonprofit

    /**
     * Creates a Collector object to be used with a Transaction
     * @param colID Identifying integer
     * @param colName Name of the Collector
     * @param category Category value
     */
    public Collector(int colID, String colName, char category) {
        this.colID = colID;
        this.colName = colName;
        this.category = category;
    }

    /**
     * Getter for the Collector name variable
     * @return String colName
     */
    public String getColName() {
        return colName;
    }

    /**
     * Prints the collector info as a String
     * @return String in format {ID: colID | Name: colName | Cat: category}
     */
    public String toString() {
        return "{ID: " + colID + " | Name: " + colName + " | Cat: " + category + "}";
    }
}
