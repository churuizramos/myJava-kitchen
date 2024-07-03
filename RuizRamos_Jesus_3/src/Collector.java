/**
 * CreatesDetailing information about buyers and sellers of art
 */
public class Collector {
    private int colID;
    private String colName;
    private char category; // C for commercial, N for nonprofit

    public Collector(int colID, String colName, char category) {
        this.colID = colID;
        this.colName = colName;
        this.category = category;
    }
    public String getColName() {
        return colName;
    }
    public String toString() {
        return "{ID: " + colID + " | Name: " + colName + " | Cat: " + category + "}";
    }
}
