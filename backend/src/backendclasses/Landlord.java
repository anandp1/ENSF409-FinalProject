package backendclasses;//package Main;
import database.Database;

import java.util.ArrayList;

public class Landlord {
    private final int landlordID;
    private final Database db;
    public Landlord(int landlordID, Database db) {
        this.landlordID = landlordID;
        this.db = db;
    }
    public boolean registerProperty(Property property) {
        // requires that the property doesn't already exist in the database
    	return db.addProperty(landlordID, property);
    }
    public ArrayList<Message> getAllMessages() {
        return db.getAllMessages(landlordID);
    }
    public boolean setListingState(int property_id, State propertyState) {
        return db.setListingState(propertyState, property_id);
    }
    public boolean postProperty(int propertyID) {
        Property property = db.getProperty(propertyID);
        if(property.getListing().getFee().getFeeAmount() > -1) return db.setListingState(State.ACTIVE, propertyID);
        else return false;
        // return false if property doesn't exist or if its active and its already active

        // turns the property that is associated with this landlords id
        // into active only if it its currently suspended
        /*
        One option to notify registeredrenters make a new column in the database
        called isNew, whenever we add a new property we mark it as a 1 and all the original
        properties is a 0. See RegisteredRenters class for more.
         */
      
      
      /////////
      // Jett's code, incomplete:
    //   if(properties.get(index).getListing().getListingState()==backendclasses.State.SUSPENDED) {
    //     	properties.get(index).getListing().setListingState(db, backendclasses.State.ACTIVE, properties.get(index).getPropertyID());
    //     }
    }
    public boolean postPropertyWithListing(int property_id) {
        Property property = db.getPropertyWithListing(property_id);
        if(property.getListing().getFee().getFeeAmount() > -1) return db.setListingState(State.ACTIVE, property_id);
        else return false;
    }
    public ArrayList<Message> getMessages(int landlordID) {
        return db.getAllMessages(landlordID);
    }
    public ArrayList<Property> getProperty() {
        return db.getLandlordProperties(landlordID);
    }



}
