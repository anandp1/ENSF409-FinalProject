import java.sql.*;
import java.util.*;

public class Database {
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;
    public Database(String DBURL, String USERNAME, String PASSWORD) {
        this.DBURL = DBURL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;

    }
    public void connect() throws SQLException {
        DriverManager.setLoginTimeout(5);
        dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

    }
    public Connection getConnection() {
    	return dbConnect;
    }
    
    public void disconnect() {
        try {
            dbConnect.close();

        }
        catch (Exception e) {
            System.err.println("Could not connect to Database!");
            e.printStackTrace();
        }
    }
    // @Jett
    // if anything is unclear let me know but these are all the functions
    // that I think we need to make the program work

    // function to get all the properties names <-- returns ArrayList<Property>
    // function that returns all renters name <-- returns ArrayList<String>
    // function that returns all landlord names <-- returns ArrayList<String>
    // (Property property) <-- function that returns all properties that match this function returns a arraylist
    // (email,password) <-- function that returns which landlord, manager or registered renter it is as a string (identified as a id)
                            // add a "l" at the end of the integer value for landlord, "m" for manager and "r" for renter
                            // returns empty string if none of the above
    // (landlordID) <-- function that returns properties owned by landlord
                         // return a ArrayList<Property> with all the properties
                         // returns any mail that landlord has if the id is of a landlord
   // DONE  // (Property, landlordId) <-- saves property into properties in the database with that landlord id
                                    // set fee and period to -1 manually because it is not set yet (manager sets it)
    // (Property, landlordId) <-- turns property associsated with that landlordid into active only if its currently suspended if it
                                    // is already active return -1 to indicate error
    // (firstName, lastName, email, password) <-- function that saves all this info into the database for the renter
    // (message, emailAddressOfRenter) <-- saves message in landlord email in the database of that renter
    // (Criteria criteria) <-- checks if this any properties matches this criteria and
                                // returns the same criteria as input if it does
                                // return empty ArrayList<Criteria> if none exist
    // (RenterId) <-- returns ArrayList<Criteria> of all criteria that match this renter
    // (RenterId) <-- returns subscriptionState of the renter as a boolean
    // (Criteria criteria) <-- adds criteria to the database

    // (PropertyID, fee) <-- updates fee of that property
    // (PropertyID, period) <-- updates period of that property
    // (ArrayList<Property>) <-- return landlord name next to each property (just use the propertyID to check)
                            // return as ArrayList<String>


    public void addProperty(String landlordName, Property property) {
        try {
            String query = "INSERT INTO Property (Landlord_login_id, Apartment_type, NoBedrooms, NoBathrooms, Quadrant, Furnished) VALUES (?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, landlordName);
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
    public void setListingState(State listingState, int propertyID) {
        try {
            String query = "UPDATE Listing SET listingState = " + listingState.getInt() + " WHERE Property_id = " + propertyID;
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.executeUpdate();

            myStmt.close();

        } catch (SQLException ex) {
            System.err.println("\nError in Listing setListingState\n");
            ex.printStackTrace();
        }
    }

}