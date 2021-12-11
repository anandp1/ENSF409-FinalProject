package backendclasses;//package Main;
import database.Database;

import java.util.ArrayList;

public class Landlord {
    // attribute
    private final int landlordID;

    // local instantiation of the database
    private final Database db;

    // constructor
    public Landlord(int landlordID, Database db) {
        this.landlordID = landlordID;
        this.db = db;
    }

    public boolean registerProperty(Property property) {
        // requires that the property doesn't already exist in the database
    	return db.addProperty(landlordID, property);
    }
    // gets all messages from registered renters
    public ArrayList<Message> getAllMessages() {
        return db.getAllMessages(landlordID);
    }

    // updates the listing state of a landlord's property
    public boolean setListingState(int property_id, State propertyState) {
        return db.setListingState(propertyState, property_id);
    }

    // posts a property (ie updates the listing state
    // if there was a payment method, it would be added in the logic of this function
    public boolean postProperty(int propertyID) {
        Property property = db.getProperty(propertyID);
        if(property.getListing().getFee().getFeeAmount() > -1) return db.setListingState(State.ACTIVE, propertyID);
        else return false;
    }

    // posts the property with a corresponding listing (ie the property listing exists)
    public boolean postPropertyWithListing(int property_id) {
        Property property = db.getPropertyWithListing(property_id);
        if(property.getListing().getFee().getFeeAmount() > -1) return db.setListingState(State.ACTIVE, property_id);
        else return false;
    }

    // gets all of the messages of any landlord id from registered renters
    public ArrayList<Message> getMessages(int landlordID) {
        return db.getAllMessages(landlordID);
    }

    // gets all of the properties of a given landlord
    public ArrayList<Property> getProperty() {
        return db.getLandlordProperties(landlordID);
    }
}
