package backendclasses;//package Main;
import database.Database;

import java.util.ArrayList;

public class Landlord {
    private final ArrayList<Property> properties;
    private final String landlordName;
    private final Database db;
    Landlord(String landlordName, ArrayList<Property> properties, Database db) {
        this.landlordName = landlordName;
        this.properties = properties;
        this.db = db;
    }
    public void registerProperty(Property property) {
        // requires that the property doesn't already exist in the database
    	db.addProperty(landlordName, property);
    }
    public void messageRenter(String message, int renterID) {
        // save message for the renterID in the database
    	// where are we saving messages for renters?
    }
    public void processPayment() {
        // update the payment to 1 from 0 in the database indicating has paid
    	// not too sure where we are holding payments in the database
    }
    public void setListingState(String propertyName, String propertyState) {
        // get property that matches this name
        // update the property with the name with the new state in the database
    }
    public boolean postProperty() {
        // returns true if we were able to post if not then false
        // Can only post if fee is not equal to -1

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
        return true;
    }
    public ArrayList<Property> getProperty() {
        return properties;
    }



}
