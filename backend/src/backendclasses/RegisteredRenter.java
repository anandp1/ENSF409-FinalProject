package backendclasses;

import database.Database;

import java.util.ArrayList;

public class RegisteredRenter {
    private ArrayList<Criteria> criteria; // holds criteria that the renter is subscribed too
    private boolean subscriptionState; // holds state of subscription
    private int renterID; // the renters unique ID
    private final Database db; // local connection, as to not consistently pass in a connection into functions

    // constructor that requires database, renter unique ID, subscription state of the renter
    public RegisteredRenter(boolean subscriptionState, int renterID, Database db) {
        this.subscriptionState = subscriptionState;
        this.renterID = renterID;
        this.db = db;
    }

    // function that requires criteria that is being searched
    // promises to return all properties that match the search
    public ArrayList<Property> searchResults(Criteria criteria) {
        // searches for any results that match the property and return any properties that match
        // from the database
        ArrayList<Property> matchedCriteria = db.getAllMatchingProperties(criteria);
        if(subscriptionState) {
            addCriteria(criteria); // add this criteria to the subscription if they are subscribed
        }
        // call addCriteria and save this property criteria as a subscription
        return matchedCriteria;
    }
    // gets all subscribed criteria from the database
    public ArrayList<Criteria> getSubscribedCriteria() {
        return db.getAllCriteria(renterID);
    }
    // adds the criteria that the user wants to subscribe to
    public void addCriteria(Criteria criteria) {
        db.addCriteria(renterID, criteria);
    }

    // setter method
    // requires the new subscription state to set to
    // updates the database
    public void setSubscriptionState(boolean val) {
        subscriptionState = val;
        db.setSubscriptionState(renterID, val);
    }
}
