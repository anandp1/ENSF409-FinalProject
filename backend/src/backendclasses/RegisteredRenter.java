package backendclasses;

import database.Database;

import java.util.ArrayList;

public class RegisteredRenter {
    private ArrayList<Criteria> criteria;
    private boolean subscriptionState;
    private int renterID;
    private final Database db;
    public RegisteredRenter(boolean subscriptionState, int renterID, Database db) {
        this.subscriptionState = subscriptionState;
        this.renterID = renterID;
        this.db = db;
    }
    public ArrayList<Property> searchResults(Criteria criteria) {
        // searches for any results that match the property and return any properties that match
        // from the database
        ArrayList<Property> matchedCriteria = db.getAllMatchingProperties(criteria);
        if(subscriptionState) {
            addCriteria(criteria);
        }
        // call addCriteria and save this property criteria as a subscription
        return matchedCriteria;
    }
    public ArrayList<Criteria> subscribedCriteria() {
        return db.getAllCriteria(renterID);
    }
    public void addCriteria(Criteria criteria) {
        db.addCriteria(renterID, criteria);
        // adds criteria to the database
        // adds the renterID to the criteria in the database
    }
    public ArrayList<Criteria> checkSubCriteria() {
        // ONLY if subscription state is set to true
        // add to new database table
        // database table has which renters are subscribed to this criteria
        /*
        We check the criteria against every single property if any of them matches
        AND it is marked as a 1 in the 'isNew' column then we add it to the arraylist and return
        it.
         */
        return new ArrayList<Criteria>();
    }
    public void removeCriteria(Criteria criteria) {
        // unsubscribes that criteria
        // removes the renterID from that criteria
    }
    public void setSubscriptionState(boolean val) {
        subscriptionState = val;
    }
}
