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

    public ArrayList<Property> getAllproperties() {
        // presumes all states are active, otherwise set the first input for listing as results.getInt("ListingState")
        // honestly might throw an error - no idea how to verify if this is working right. Basically I call getBoolean on a result that might be an integer.
        ArrayList<Property> returnValue = new ArrayList<Property>();
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("SELECT * FROM Listing, Property WHERE Listing.Property_id = Property.Property_id");

            while(results.next()) {
                Fee tempFee = new Fee(results.getDouble("FeeAmount"), results.getInt("Period"));
                Listing tempListing = new Listing(State.fromInt(results.getInt("ListingState")), tempFee, results.getInt("DayCount"), this);
                Property tempProperty = new Property(ApartmentType.fromInt(results.getInt("Apartment_type")), results.getInt("NoBedrooms"), results.getInt("NoBathrooms"), Quadrant.fromInt(results.getInt("Quadrant")), results.getBoolean("Furnished"), tempListing, results.getInt("Property_id"), results.getString("Property_address") );
                returnValue.add(tempProperty);
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getAllproperties\n");
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
            results = stmt.executeQuery("SELECT * FROM Listing AS L, Property AS P WHERE L.Property_id = P.Property_id AND " +
                    "P.Apartment_type = " + criteria.getApartmentType().getInt() + " AND " +
                    "P.NoBedrooms >= " + criteria.getNumBed() + " AND " +
                    "P.NoBathrooms >= " + criteria.getNumBath() + " AND " +
                    "P.Quadrant = " + criteria.getQuadrant().getInt() + " AND " +
                    "P.Furnished = " + criteria.intIsFurnished() + " AND " +
                    "L.ListingState = 1");

            while(results.next()) {
                Fee tempFee = new Fee(results.getDouble("FeeAmount"), results.getInt("Period"));
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

    public String getUserType(String email, String password) {
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("SELECT * FROM User WHERE Email = \'" + email + "\' AND Password = \'" + password + "\'");
            int userType = -1;
            int id = -1;
            if (results.next()) {
                id = results.getInt("User_id");
                userType = results.getInt("User_type");
            }

            stmt.close();
            results.close();
            if (userType != -1) {
                if (userType == 0) return String.valueOf(id) + "r";
                else if (userType == 1) return String.valueOf(id) + "l";
                else if (userType == 2) return String.valueOf(id) + "m";
            }
            return null;
        } catch (Exception e) {
            System.err.println("\nError in Database getUserType\n");
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Property> getLandlordProperties (int landlord_id) {
        ArrayList<Property> returnValue = new ArrayList<Property>();
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("SELECT * FROM User, Property AS P LEFT JOIN Listing AS L " +
                    "ON P.Property_id = L.Property_id " +
                    "WHERE User.User_type = 1 AND " +
                    "P.Landlord_id = User.User_id AND " +
                    "User.User_id = " + landlord_id);

            while(results.next()) {
                int listingState = results.getInt("ListingState");
                Listing tempListing = null;
                if(listingState != 0) {
                    Fee tempFee = new Fee(results.getDouble("FeeAmount"), results.getInt("Period"));
                    tempListing = new Listing(State.fromInt(results.getInt("ListingState")), tempFee, results.getInt("DayCount"), this);
                }
                Property tempProperty = new Property(ApartmentType.fromInt(results.getInt("Apartment_type")), results.getInt("NoBedrooms"), results.getInt("NoBathrooms"), Quadrant.fromInt(results.getInt("Quadrant")), results.getBoolean("Furnished"), tempListing, results.getInt("Property_id"), results.getString("Property_address") );
                returnValue.add(tempProperty);
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getLandlordProperties\n");
            e.printStackTrace();
        }

        return returnValue;
    }

    public int createNewRenter(String fname, String lname, String email, String password) {
        return createNewRenter(fname, lname, email, password, 1);
    }

    public int createNewRenter(String fname, String lname, String email, String password, int subscriptionState) {
        return createNewUser(0, fname, lname, email, password, subscriptionState);
    }

    public int createNewLandlord(String fname, String lname, String email, String password) {
        return createNewUser(1, fname, lname, email, password, -1);
    }

    public int createNewManager(String fname, String lname, String email, String password) {
        return createNewUser(2, fname, lname, email, password, -1);
    }

    public int createNewUser(int user_type, String fname, String lname, String email, String password, int subscriptionState) {
        int returnValue = -1;
        try {
            String query = "INSERT INTO User (User_type, Fname, Lname, Email, Password";
            if(subscriptionState != -1 ) query += ", Subscription_state";
            query += ") VALUES (" + user_type + ",\'" + fname + "\',\'" + lname + "\',\'" + email + "\',\'" + password + "\'";
            if(subscriptionState != -1) query += "," + subscriptionState;
            query += ")";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);


            myStmt.executeUpdate();
            myStmt.close();

            String userInfo = getUserType(email, password);
            returnValue = Integer.valueOf(userInfo.substring(0, userInfo.length()-1));
        } catch (SQLException ex) {
            System.err.println("\nError in Database createNewUser\n");
            ex.printStackTrace();
        }
        return returnValue;
    }

    public ArrayList<Criteria> getAllCriteria (int renter_id) {
        ArrayList<Criteria> returnValue = new ArrayList<Criteria>();
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("Select * FROM Criteria WHERE Renter_id = " + renter_id);

            while(results.next()) {
                Criteria tempCriteria = new Criteria(ApartmentType.fromInt(results.getInt("Apartment_type")), results.getInt("NoBedrooms"), results.getInt("NoBathrooms"), Quadrant.fromInt(results.getInt("Quadrant")), results.getInt("Furnished") == 1);
                returnValue.add(tempCriteria);
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getAllCriteria\n");
            e.printStackTrace();
        }

        return returnValue;
    }

    public boolean getSubscriptionState(int renter_id) {
        boolean returnValue = false;
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("Select * FROM User WHERE User_type = 0 AND User_id = " + renter_id);

            if(results.next()) {
                int temp = results.getInt("Subscription_state");
                returnValue = temp == 1;
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getSubscriptionState\n");
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean addCriteria(int renter_id, Criteria criteria) {
        try {
            String query = "INSERT INTO Criteria (Renter_id, Apartment_type, NoBedrooms, NoBathrooms, Quadrant, Furnished) VALUES (?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, renter_id);
            myStmt.setInt(2, criteria.getApartmentType().getInt());
            myStmt.setInt(3, criteria.getNumBed());
            myStmt.setInt(4, criteria.getNumBath());
            myStmt.setInt(5, criteria.getQuadrant().getInt());
            myStmt.setInt(6, criteria.getIsFurnished() ? 1:0);

            myStmt.executeUpdate();
            myStmt.close();

            return true;
        } catch (SQLException ex) {
            System.err.println("\nError in Database addCriteria\n");
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updatePropertyFee(int property_id, Fee fee) {
        /* ANAND: I have combined the update fee and period into one function (as I figured you would
        always pass in the entire fee object and you could just set the old value.

        Would you rather I split the function?
         */
        try {
            String query = "UPDATE Listing Set FeeAmount = " + fee.getFeeAmount() + ", Period = " + fee.getPeriod() + " WHERE Property_id = " + property_id;
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.executeUpdate();
            myStmt.close();

            return true;
        }
        catch(Exception e) {
            System.err.println("\nError in Login updatePropertyFee\n");
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<String> getLandlordNamesFromProperties (ArrayList<Property> properties) {
        ArrayList<String> returnValue = new ArrayList<String>();
        for(var property: properties) {
            returnValue.add(getLandlordNameFromProperty(property.getPropertyID()));
        }
        return returnValue;
    }

    public String getLandlordNameFromProperty(int property_id) {
        String returnValue = "";
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("Select * FROM User, Property WHERE User.User_type = 1 AND User.User_id = Property.Landlord_id AND Property.Property_id = " + property_id);

            if(results.next()) {
                 returnValue = results.getString("Fname") + " " + results.getString("Lname");
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getLandlordNameFromProperty\n");
            e.printStackTrace();
        }
        return returnValue;
    }

    /* Jett's progress comments.
     I have implemented the following functions, as per the specifications below:
       1. function to get all the properties names <-- returns ArrayList<Property>
       2. function that returns all renters name <-- returns ArrayList<String>
       3. function that returns all landlord names <-- returns ArrayList<String>
       4. (Criteria criteria) <-- function that returns all properties that match this function returns a arraylist<Criteria>
       5. (email,password) <-- function that returns which landlord, manager or registered renter it is as a string (identified as a id)
       6. (landlordID) <-- function that returns properties owned by landlord
       7. (firstName, lastName, email, password) <-- function that saves all this info into the database for the renter
       8. (RenterId) <-- returns ArrayList<Criteria> of all criteria that match this renter
       9. (RenterId) <-- returns subscriptionState of the renter as a boolean
       10. (Criteria criteria) <-- adds criteria to the database
       11. (PropertyID, fee) <-- updates fee of that property
       12. (ArrayList<Property>) <-- return landlord name next to each property (just use the propertyID to check)
     */


    // @Jett
    // if anything is unclear let me know but these are all the functions
    // that I think we need to make the program work

            // function to get all the properties names <-- returns ArrayList<Property>
            // function that returns all renters name <-- returns ArrayList<String>
            // function that returns all landlord names <-- returns ArrayList<String>
            // (Criteria criteria) <-- function that returns all properties that match this function returns a arraylist<Criteria>
            // (email,password) <-- function that returns which landlord, manager or registered renter it is as a string (identified as a id)
                    // add a "l" at the end of the integer value for landlord, "m" for manager and "r" for renter
                    // returns empty string if none of the above
            // (landlordID) <-- function that returns properties owned by landlord
                    // return a ArrayList<Property> with all the properties
            // (firstName, lastName, email, password) <-- function that saves all this info into the database for the renter
            // (RenterId) <-- returns ArrayList<Criteria> of all criteria that match this renter
            // (RenterId) <-- returns subscriptionState of the renter as a boolean
            // (Criteria criteria) <-- adds criteria to the database
            // (PropertyID, fee) <-- updates fee of that property
    // (PropertyID, period) <-- updates period of that property
            // (ArrayList<Property>) <-- return landlord name next to each property (just use the propertyID to check)
                    // return as ArrayList<String>

    // (landlordID) <-- returns any mail that landlord has if the id is of a landlord
    // (message, emailAddressOfRenter) <-- saves message in landlord email in the database of that renter

            // DONE  // (Property, landlordId) <-- saves property into properties in the database with that landlord id
                    // set fee and period to -1 manually because it is not set yet (manager sets it)





    // need to redo these to match the database attributes - will otherwise throw some errors
    public boolean addProperty(int landlord_id, Property property) {
        try {
            String query = "INSERT INTO Property (Landlord_id, Apartment_type, NoBedrooms, NoBathrooms, Quadrant, Furnished) VALUES (?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, landlord_id);
            myStmt.setInt(2, property.getApartmentType().getInt());
            myStmt.setInt(3, property.getNumBed());
            myStmt.setInt(4, property.getNumBath());
            myStmt.setInt(5, property.getQuadrant().getInt());
            myStmt.setInt(6, property.getIsFurnished() ? 1:0);
            myStmt.executeUpdate();

            myStmt.close();

            return addListing(getMaxPropertyId(landlord_id), new Fee(-1, -1), -1, State.fromInt(3));
        } catch (SQLException ex) {
            System.err.println("\nError in Database addProperty\n");
            ex.printStackTrace();
            return false;
        }
    }

    private int getMaxPropertyId(int landlord_id) {
        int returnValue = -1;
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("Select MAX(Property_id) FROM Property WHERE Landlord_id = " + landlord_id);

            if(results.next()) {
                returnValue = results.getInt("Property_id");
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getMaxPropertyId\n");
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean addListing(int property_id, Fee fee, int dayCount, State listingState) {
        try {
            String query = "INSERT INTO Listing (Property_id, FeeAmount, Period, DayCount, ListingState) VALUES (?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, property_id);
            myStmt.setDouble(2, fee.getFeeAmount());
            myStmt.setInt(3, fee.getPeriod());
            myStmt.setInt(4, dayCount);
            myStmt.setInt(5, listingState.getInt());
            myStmt.executeUpdate();

            myStmt.close();

            return true;
        } catch (SQLException ex) {
            System.err.println("\nError in Database addListing\n");
            ex.printStackTrace();
            return false;
        }
    }

    public void setListingState(State listingState, int propertyID) {
        try {
            String query = "UPDATE Listing SET ListingState = " + listingState.getInt() + " WHERE Property_id = " + propertyID;
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.executeUpdate();

            myStmt.close();

        } catch (SQLException ex) {
            System.err.println("\nError in Database setListingState\n");
            ex.printStackTrace();
        }
    }

}