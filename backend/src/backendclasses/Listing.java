package backendclasses;//package Main;

import database.Database;

public class Listing {
    // attributes
    private State listingState;
    private Fee fee;
    private int daysCount;

    // local instantiation of the database
    private final Database db;

    // constructor
    public Listing(State listingState, Fee fee, int daysCount, Database db) {
        this.listingState = listingState;
        this.fee = fee;
        this.db = db;
    }

    // increases the day duration locally
    public void addDay() {
        daysCount++;
    }

    // setter
    public void setListingState(State listingState, int propertyID) {
    	db.setListingState(listingState, propertyID);
    }

    // getters
    public State getListingState() {
        return listingState;
    }
    public Fee getFee() {
        return fee;
    }
    public int getDaysCount() {
        return daysCount;
    }

}
