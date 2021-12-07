package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Listing {
    private State listingState;
    private Fee fee;

    private int daysCount;
    Listing(State listingState, Fee fee, int daysCount) {
        this.listingState = listingState;
        this.fee = fee;
        this.daysCount = daysCount;

    }
    public void addDay() {
        daysCount++;
    }
    public void contactLandlords(String message) {
        // might change
    	// I have left this for now
    }
    public void setListingState(Connection db, State listingState, int propertyID) {
    	try {
			String query = "UPDATE Listing SET listingState = " + listingState.getInt() + " WHERE Property_id = " + propertyID;
			PreparedStatement myStmt = db.prepareStatement(query);
			myStmt.executeUpdate();
	            
			myStmt.close();
	            
		} catch (SQLException ex) {
			System.err.println("\nError in Listing setListingState\n");
			ex.printStackTrace();
		}
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
