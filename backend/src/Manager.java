import java.sql.Array;
import java.util.ArrayList;

public class Manager {
    private ArrayList<Property> allProperties;
    private final Database db;
    Manager(Database db) {
        this.db = db;
    }
    public ArrayList<Property> getProperties() {
        // calls database to return all properties
        return new ArrayList<Property>();
    }
    public ArrayList<String> getRenters() {
        // calls database to return all renters name
        return new ArrayList<String>();
    }
    public ArrayList<String> getLandlords() {
        // calls database to return all renters name
        return new ArrayList<String>();
    }
    public void updateFee(int propertyID, double fee) {
        // get property that matches this name
        // update fee of this property name in the database
    }
    public void updatePeriod(int propertyID, int period) {
        // get property that matches this name
        // update the period in the database with the same property name
    }
    public void setSummaryInfo(int period) {
        // call database to get all properties that match this period
        allProperties = new ArrayList<Property>();
    }
    public int getNumListed() {
        // use allProperties to get number of properties in the period
        return 1;
    }
    public int getNumRented() {
        // use allProperties to get number of properties rented in that period
        return 1;
    }
    public int getNumActive() {
        // use allProperties to get number of properties listed as rented
        return 1;
    }
    public ArrayList<ArrayList<String>> listNumRented() {
        // ONLY RENTED
        // make a new arraylist with only properties that are rented
        // call database to return landlord name that matches properties of the arraylist
            // basically pass the arraylist as a argument
        // uses allProperties to get property id number and append it to the arraylist
        // uses allProperties to get property address and append it to the arraylist
        return new ArrayList<ArrayList<String>>();
    }
    public void setListingState(String propertyName, String propertyState) {
        // get property that matches this name
        // update the property with the name with the new state in the database
    }
}
