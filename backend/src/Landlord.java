package Main;
import java.sql.*;
import java.util.ArrayList;

public class Landlord {
    private final ArrayList<Property> properties;
    private final int landlordID;
    Landlord(int landlordID, ArrayList<Property> properties) {
        this.landlordID = landlordID;
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
			System.err.println("\nError in Login createLogin\n");
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
    public void postProperty(Connection db, int index) {
    	// requires that you know which property you want to post from the array list, please help me out here
    	// also you're going to need the property_id
        if(properties.get(index).getListing().getListingState()==State.SUSPENDED) {
        	properties.get(index).getListing().setListingState(db, State.ACTIVE, properties.get(index).getPropertyID());
        }
    }
    public ArrayList<Property> getProperty() {
        return properties;
    }



}
