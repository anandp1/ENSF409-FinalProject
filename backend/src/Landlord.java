//package Main;
import java.sql.*;
import java.util.ArrayList;

public class Landlord {
    private final ArrayList<Property> properties;
    private final String landlordName;
    Landlord(String landlordName, ArrayList<Property> properties) {
        this.landlordName = landlordName;
        this.properties = properties;
    }
    public void registerProperty(Connection db, Property property) {
        // requires that the property doesn't already exist in the database
    	try {
			String query = "INSERT INTO Property (Landlord_login_id, Apartment_type, NoBedrooms, NoBathrooms, Quadrant, Furnished) VALUES (?,?,?,?,?,?)";
			PreparedStatement myStmt = db.prepareStatement(query);
	            
			myStmt.setInt(1, landlordID);
			myStmt.setString(2, property.getApartmentType());
			myStmt.setInt(3, property.getNumBed());
			myStmt.setInt(4, property.getNumBath());
			myStmt.setInt(5, property.getQuadrant().getInt());
			myStmt.setInt(6, property.getIsFurnished() ? 1:0);
			myStmt.executeUpdate();
	            
			myStmt.close();
	            
		} catch (SQLException ex) {
			System.err.println("\nError in Landlord RegisterProperty\n");
			ex.printStackTrace();
		}
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
      if(properties.get(index).getListing().getListingState()==State.SUSPENDED) {
        	properties.get(index).getListing().setListingState(db, State.ACTIVE, properties.get(index).getPropertyID());
        }
        return true;
    }
    public ArrayList<Property> getProperty() {
        return properties;
    }



}
