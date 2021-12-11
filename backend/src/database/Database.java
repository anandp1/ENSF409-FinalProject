package database;

import java.sql.*;
import java.util.*;
import backendclasses.*;

public class Database {
    // Hold the connection information from the database into the local component
    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;
    private Connection dbConnect;
    private ResultSet results;

    public Database(String DBURL, String USERNAME, String PASSWORD) {
        // constructor, get the information to connect to the database
        this.DBURL = DBURL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;

    }
    public void connect() throws SQLException {
        // establish connection to the database
        DriverManager.setLoginTimeout(5);
        dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);

    }
    public Connection getConnection() {
        // retrieve connection instance, used to pass into other functions
        return dbConnect;
    }

    public void disconnect() {
        // disconnect from the database
        try {
            dbConnect.close();

        }
        catch (Exception e) {
            System.err.println("Could not connect to database.Database!");
            e.printStackTrace();
        }
    }

    public ArrayList<Property> getAllProperties() {
        // Get all the properties (and connected listings and fees) from the database
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
        // get all of the renter names from the database
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
        // get all of the landlord names from the database
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
        // get all of the properties and listings that match a given criteria set,
        // only if the listing state is active
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
        // get the user type (renter, landlord, manager) and the user id from the database
        // given a login email and password. Return as a concatenated string.
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
        // get all of the properties that correspond to a given landlord
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
        // creates a new renter without a subscription state, setting default state to 1 (subscribed)
        return createNewRenter(fname, lname, email, password, 1);
    }

    public int createNewRenter(String fname, String lname, String email, String password, int subscriptionState) {
        // creates a new renter with a subscription state
        return createNewUser(0, fname, lname, email, password, subscriptionState);
    }

    public int createNewLandlord(String fname, String lname, String email, String password) {
        // create a new landlord
        return createNewUser(1, fname, lname, email, password, -1);
    }

    public int createNewManager(String fname, String lname, String email, String password) {
        // create a new manager
        return createNewUser(2, fname, lname, email, password, -1);
    }

    public int createNewUser(int user_type, String fname, String lname, String email, String password, int subscriptionState) {
        // insert a new user (renter, landlord, manager) into the database and return the user id
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
        // get all criteria corresponding to a registered renter
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
        // get the subscription state of a registered renter
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
        // insert a criteria of a renter into the database
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
        // update a property fee amount and period into the database
        try {
            String query = "UPDATE Listing SET FeeAmount = " + fee.getFeeAmount() + ", Period = " + fee.getPeriod() + " WHERE Property_id = " + property_id;
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
        // gets an array of landlord names, mapped to the input array of properties
        ArrayList<String> returnValue = new ArrayList<String>();
        for(var property: properties) {
            returnValue.add(getLandlordNameFromProperty(property.getPropertyID()));
        }
        return returnValue;
    }

    public String getLandlordNameFromProperty(int property_id) {
        // returns the landlord name of a single property
        String returnValue = "";
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("Select * FROM User, Property WHERE User.User_type = 1 AND User.User_id = Property.Landlord_id AND Property.Property_id = " + property_id);

            if (results.next()) {
                returnValue = results.getString("Fname") + " " + results.getString("Lname");
            }
            stmt.close();
            results.close();
        } catch (Exception e) {
            System.err.println("\nError in Database getLandlordNameFromProperty\n");
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean addMessage(int landlord_id, Message message) {
        // inserts a message into the database to communicate with a landlord
        try {
            String query = "INSERT INTO Message (Landlord_id, Renter_email, Message) VALUES (?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, landlord_id);
            myStmt.setString(2, message.getRenterEmail());
            myStmt.setString(3, message.getMessage());
            myStmt.executeUpdate();

            myStmt.close();

            return true;
        } catch (SQLException ex) {
            System.err.println("\nError in Database addMessage\n");
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Message> getAllMessages(int landlord_id) {
        // gets all of the messages to a landlord
        ArrayList<Message> returnValue = new ArrayList<Message>();
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("Select * FROM Message WHERE Landlord_id = " + landlord_id);

            while(results.next()) {
                Message tempMessage = new Message(results.getString("Renter_email"), results.getString("Message"));
                returnValue.add(tempMessage);
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getAllMessages\n");
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean addProperty(int landlord_id, Property property) {
        // inserts a property into the database, and then inserts a listing corresponding to that property
        // (default is inactive) for the manager to update the listing information
        try {
            String query = "INSERT INTO Property (Landlord_id, Property_address, Apartment_type, NoBedrooms, NoBathrooms, Quadrant, Furnished) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, landlord_id);
            myStmt.setString(2, property.getPropertyAddress());
            myStmt.setInt(3, property.getApartmentType().getInt());
            myStmt.setInt(4, property.getNumBed());
            myStmt.setInt(5, property.getNumBath());
            myStmt.setInt(6, property.getQuadrant().getInt());
            myStmt.setInt(7, property.getIsFurnished() ? 1:0);
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
        // returns the most-recently created property by a landlord from the database,
        // used by other functions to ensure that the property was successfully created
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
        // inserts a listing into the database, corresponding to a property
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

    public boolean setListingState(State listingState, int propertyID) {
        // changes the listing state of a property. If the state was set to active,
        // calls observables that notifies all registered renters of the new property,
        // if the property matches the criteria of the renters.
        try {
            String query = "UPDATE Listing SET ListingState = " + listingState.getInt() + " WHERE Property_id = " + propertyID;
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.executeUpdate();

            myStmt.close();

            if(listingState == State.ACTIVE) {
                return addNewProperty(propertyID);
            } else return true;
        } catch (SQLException ex) {
            System.err.println("\nError in Database setListingState\n");
            ex.printStackTrace();
            return false;
        }
    }

    public boolean addNewProperty(int property_id) {
        // used to call other functions to notify every renter with matching criteria that
        // a new property has been added into the database. Main observable structure.
        Property property = getProperty(property_id);
        if(property == null) return false;
        ArrayList<Integer> renter_ids = getMatchingCriteria(property);

        for(var renter: renter_ids) {
            if(!addNewProperty(renter, property_id)) return false;
        }

        return true;
    }

    public Integer getPropertyLandlord(int property_id) {
        // returns the landlord of an input property
        int returnValue = -1;
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("Select * FROM Property WHERE Property_id = " + property_id);

            if(results.next()) {
                returnValue = results.getInt("Landlord_id");
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getPropertyLandlord\n");
            e.printStackTrace();
        }
        return returnValue;
    }

    public Property getProperty(int property_id) {
        // returns the full property information of a property, given a property id
        Property returnValue = null;
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("Select * FROM Property WHERE Property_id = " + property_id);

            if(results.next()) {
                returnValue = new Property(ApartmentType.fromInt(results.getInt("Apartment_type")), results.getInt("NoBedrooms"), results.getInt("NoBathrooms"), Quadrant.fromInt(results.getInt("Quadrant")), results.getBoolean("Furnished"), null, property_id, results.getString("Property_address") );
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getProperty\n");
            e.printStackTrace();
        }
        return returnValue;
    }

    public ArrayList<Integer> getMatchingCriteria(Property property) {
        // returns a list of all criteria objects that match a given property
        ArrayList<Integer> returnValue = new ArrayList<Integer>();
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("Select * FROM Criteria " +
                    "WHERE Apartment_type = " + property.getApartmentType().getInt() + " AND " +
                    "NoBedrooms <= " + property.getNumBed() + " AND " +
                    "NoBathrooms <= " + property.getNumBath() + " AND " +
                    "Quadrant = " + property.getQuadrant().getInt() + " AND " +
                    "Furnished = " + (property.getIsFurnished() ? 1:0 ));

            while(results.next()) {
                returnValue.add(results.getInt("Renter_id"));
            }
            stmt.close();
            results.close();
        }
        catch(Exception e) {
            System.err.println("\nError in Database getMatchingCriteria\n");
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean addNewProperty(int renter_id, int property_id) {
        // inserts a new notification tag to the database to inform registered renters
        // of a newly-created property that matches their criteria
        try {
            String query = "INSERT INTO New_Property (Renter_id, Property_id) VALUES (?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setInt(1, renter_id);
            myStmt.setInt(2, property_id);
            myStmt.executeUpdate();

            myStmt.close();

            return true;
        } catch (SQLException ex) {
            System.err.println("\nError in Database addNewProperty\n");
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Property> getNewProperties(int renter_id) {
        // returns all new property notifications of a registered renter, and sets the
        // tag to ensure they only get notified once
        ArrayList<Property> returnValue = new ArrayList<Property>();
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("Select * FROM New_Property, Property, Listing " +
                    "WHERE New_Property.Property_id = Property.Property_id AND " +
                    "Property.Property_id = Listing.Property_id AND " +
                    "Listing.ListingState = 1 AND " +
                    "New_Property.Renter_id = " + renter_id);

            while(results.next()) {
                Fee tempFee = new Fee(results.getDouble("FeeAmount"), results.getInt("Period"));
                Listing tempListing = new Listing(State.fromInt(results.getInt("ListingState")), tempFee, results.getInt("DayCount"), this);
                Property tempProperty = new Property(ApartmentType.fromInt(results.getInt("Apartment_type")), results.getInt("NoBedrooms"), results.getInt("NoBathrooms"), Quadrant.fromInt(results.getInt("Quadrant")), results.getBoolean("Furnished"), tempListing, results.getInt("Property_id"), results.getString("Property_address") );
                returnValue.add(tempProperty);
            }
            stmt.close();
            results.close();

            removeNewProperties(renter_id);
        }
        catch(Exception e) {
            System.err.println("\nError in Database getNewProperties\n");
            e.printStackTrace();
        }
        return returnValue;
    }

    public boolean removeNewProperties(int renter_id) {
        // changes the tag of a renter notification to ensure that they are only notified
        // once of new properties that match their criteria
        try {
            String query = "UPDATE New_Property SET Is_new = " + 0 + " WHERE Renter_id = " + renter_id;
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

    public boolean increaseDay(){
        // used to locally increase the time of the database, to simulate a real-life increase in the database.
        // increases it by 1 day
        return increaseDay(1);
    }

    public boolean increaseDay(int numDays) {
        // used to locally increase the time of the database, to simulate a real-life increase in the database.
        if(increaseByDay(numDays)) {
            suspendByPeriod();
            return true;
        }
        else return false;
    }

    private boolean increaseByDay(int numDays) {
        // calls an update to the database to increase the number of days of all property postings, to ensure
        // that they have been posted only by their given period, specified in the listing
        try {
            String query = "UPDATE Listing SET DayCount = DayCount + " + numDays + " WHERE Property_id > 0 AND ListingState = 1 ";
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

    private boolean suspendByPeriod() {
        // cancels all the property listings that have an expired period, and resets the counter
        try {
            String query = "UPDATE Listing SET ListingState = 4, DayCount = 0 WHERE Property_id > 0 AND DayCount > Period";
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
    public boolean setSubscriptionState(int renter_id, boolean state) {
        // updates a given renter's subscription state. If they unsubscribe, removes any notification
        // observables of properties that may match their criteria.
        try {
            String query = "Update User Set Subscription_state = " + (state ? 1:0) + " WHERE User_type = 0 AND User_id = " + renter_id;

            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.executeUpdate();
            myStmt.close();
            if(!state) {
                removeAllCriteria(renter_id);
            }
            return true;
        }
        catch(Exception e) {
            System.err.println("\nError in Database setSubscriptionState\n");
            e.printStackTrace();
            return false;
        }
    }
    private boolean removeAllCriteria(int renter_id) {
        // removes all observables of a given renter.
        try {
            String query = "DELETE FROM Criteria WHERE Renter_id = " + renter_id;
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.executeUpdate();
            myStmt.close();

            return true;
        }
        catch(Exception e) {
            System.err.println("\nError in Login removeAllCriteria\n");
            e.printStackTrace();
            return false;
        }
    }
    public Property getPropertyWithListing(int property_id) {
        // returns the property and a listing of the property from the property id
        Property returnValue = null;
        try {
            Statement stmt = dbConnect.createStatement();
            results = stmt.executeQuery("SELECT * FROM Listing, Property WHERE Listing.Property_id = Property.Property_id AND Property.Property_id = " + property_id);

            if(results.next()) {
                Fee tempFee = new Fee(results.getDouble("FeeAmount"), results.getInt("Period"));
                Listing tempListing = new Listing(State.fromInt(results.getInt("ListingState")), tempFee, results.getInt("DayCount"), this);
                returnValue = new Property(ApartmentType.fromInt(results.getInt("Apartment_type")), results.getInt("NoBedrooms"), results.getInt("NoBathrooms"), Quadrant.fromInt(results.getInt("Quadrant")), results.getBoolean("Furnished"), tempListing, results.getInt("Property_id"), results.getString("Property_address") );
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

}