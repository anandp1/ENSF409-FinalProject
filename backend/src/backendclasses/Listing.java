package backendclasses;//package Main;

import database.Database;

public class Listing {
    private State listingState;
    private Fee fee;
    private final Database db;
    private int daysCount;
    public Listing(State listingState, Fee fee, int daysCount, Database db) {
        this.listingState = listingState;
        this.fee = fee;
        this.db = db;
    }
    public void addDay() {
        daysCount++;
    }
    public void contactLandlords(String message) {
        // might change
    	// I have left this for now
    }
    public void setListingState(State listingState, int propertyID) {
    	db.setListingState(listingState, propertyID);
    }
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
