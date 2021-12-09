package database;

import java.sql.*;
import java.util.*;
import backendclasses.*;

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
            System.err.println("Could not connect to database.Database!");
            e.printStackTrace();
        }
    }

    public ArrayList<Property> getAllActiveProperties() {
        // presumes all states are active, otherwise set the first input for listing as results.getInt("ListingState")
        // honestly might throw an error - no idea how to verify if this is working right. Basically I call getBoolean on a result that might be an integer.
        ArrayList<Property> returnValue = new ArrayList<Property>();
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("SELECT * FROM Listing, Property WHERE Listing.Property_id = Property.Property_id AND Listing.ListingState = 1");

            while(results.next()) {
                Fee tempFee = new Fee(results.getDouble("Login_id"), results.getInt("Period"));
                Listing tempListing = new Listing(State.ACTIVE, tempFee, results.getInt("DayCount"), this);
                Property tempProperty = new Property(ApartmentType.fromInt(results.getInt("Apartment_type")), results.getInt("NoBedrooms"), results.getInt("NoBathrooms"), Quadrant.fromInt(results.getInt("Quadrant")), results.getBoolean("Furnished"), tempListing, results.getInt("Property_id"), results.getString("Property_address") );
                returnValue.add(tempProperty);
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getAllActiveProperties\n");
            e.printStackTrace();
        }

        return returnValue;
    }

    public ArrayList<String> getAllRenterNames() {
        ArrayList<String> returnValue = new ArrayList<String>();
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("SELECT * FROM User WHERE User_type = 1");

            while(results.next()) {
                returnValue.add(results.getString("Fname") + " " + results.getString("Lname"));
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getAllRenterNames\n");
            e.printStackTrace();
        }

        return returnValue;
    }

    public ArrayList<String> getAllLandlordNames() {
        ArrayList<String> returnValue = new ArrayList<String>();
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("SELECT * FROM User WHERE User_type = 0");

            while(results.next()) {
                returnValue.add(results.getString("Fname") + " " + results.getString("Lname"));
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getAllLandlordNames\n");
            e.printStackTrace();
        }

        return returnValue;
    }

    public ArrayList<Property> getAllMatchingProperties(Criteria criteria) {
        ArrayList<Property> returnValue = new ArrayList<Property>();
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("SELECT * FROM Listing as L, Property as P WHERE L.Property_id = P.Property_id AND " +
                    "P.ApartmentType = " + criteria.getApartmentType() + " AND " +
                    "P.NoBedrooms >= " + criteria.getNumBed() + " AND " +
                    "P.NoBathrooms >= " + criteria.getNumBath() + " AND " +
                    "P.Quadrant = " + criteria.getQuadrant().getInt() + " AND " +
                    "P.isFurnished = " + criteria.intIsFurnished() + " AND " +
                    "L.ListingState = 1");

            while(results.next()) {
                Fee tempFee = new Fee(results.getDouble("Login_id"), results.getInt("Period"));
                Listing tempListing = new Listing(State.ACTIVE, tempFee, results.getInt("DayCount"), this);
                Property tempProperty = new Property(ApartmentType.fromInt(results.getInt("Apartment_type")), results.getInt("NoBedrooms"), results.getInt("NoBathrooms"), Quadrant.fromInt(results.getInt("Quadrant")), results.getBoolean("Furnished"), tempListing, results.getInt("Property_id"), results.getString("Property_address") );
                returnValue.add(tempProperty);
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getAllMatchingProperties\n");
            e.printStackTrace();
        }

        return returnValue;
    }


    /* Jett's progress comments.
       I have implemented the following functions, as per the specifications below:
       1. function to get all the properties names <-- returns ArrayList<backendclasses.Property>
       2. function that returns all renters name <-- returns ArrayList<String>
       3. function that returns all landlord names <-- returns ArrayList<String>
       4. (Criteria criteria) <-- function that returns all properties that match this function returns a arraylist<Criteria>
     */


    // @Jett
    // if anything is unclear let me know but these are all the functions
    // that I think we need to make the program work

            // function to get all the properties names <-- returns ArrayList<backendclasses.Property>
            // function that returns all renters name <-- returns ArrayList<String>
            // function that returns all landlord names <-- returns ArrayList<String>
            // (Criteria criteria) <-- function that returns all properties that match this function returns a arraylist<Criteria>
    // (email,password) <-- function that returns which landlord, manager or registered renter it is as a string (identified as a id)
                            // add a "l" at the end of the integer value for landlord, "m" for manager and "r" for renter
                            // returns empty string if none of the above
    // (landlordID) <-- function that returns properties owned by landlord
                         // return a ArrayList<backendclasses.Property> with all the properties
                         // returns any mail that landlord has if the id is of a landlord
   // DONE  // (backendclasses.Property, landlordId) <-- saves property into properties in the database with that landlord id
                                    // set fee and period to -1 manually because it is not set yet (manager sets it)
    // (backendclasses.Property, landlordId) <-- turns property associsated with that landlordid into active only if its currently suspended if it
                                    // is already active return -1 to indicate error
    // (firstName, lastName, email, password) <-- function that saves all this info into the database for the renter
    // (message, emailAddressOfRenter) <-- saves message in landlord email in the database of that renter
    // (backendclasses.Criteria criteria) <-- checks if this any properties matches this criteria and
                                // returns the same criteria as input if it does
                                // return empty ArrayList<backendclasses.Criteria> if none exist
    // (RenterId) <-- returns ArrayList<backendclasses.Criteria> of all criteria that match this renter
    // (RenterId) <-- returns subscriptionState of the renter as a boolean
    // (backendclasses.Criteria criteria) <-- adds criteria to the database

    // (PropertyID, fee) <-- updates fee of that property
    // (PropertyID, period) <-- updates period of that property
    // (ArrayList<backendclasses.Property>) <-- return landlord name next to each property (just use the propertyID to check)
                            // return as ArrayList<String>


    public void addProperty(String landlordName, Property property) {
        try {
            String query = "INSERT INTO backendclasses.Property (Landlord_login_id, Apartment_type, NoBedrooms, NoBathrooms, backendclasses.Quadrant, Furnished) VALUES (?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, landlordName);
            // myStmt.setString(2, property.getApartmentType()); it is a enum now.
            myStmt.setInt(3, property.getNumBed());
            myStmt.setInt(4, property.getNumBath());
            myStmt.setInt(5, property.getQuadrant().getInt());
            myStmt.setInt(6, property.getIsFurnished() ? 1:0);
            myStmt.executeUpdate();

            myStmt.close();

        } catch (SQLException ex) {
            System.err.println("\nError in backendclasses.Landlord RegisterProperty\n");
            ex.printStackTrace();
        }
    }
    public void setListingState(State listingState, int propertyID) {
        try {
            String query = "UPDATE backendclasses.Listing SET listingState = " + listingState.getInt() + " WHERE Property_id = " + propertyID;
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.executeUpdate();

            myStmt.close();

        } catch (SQLException ex) {
            System.err.println("\nError in backendclasses.Listing setListingState\n");
            ex.printStackTrace();
        }
    }

}