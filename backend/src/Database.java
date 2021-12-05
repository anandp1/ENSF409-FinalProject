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
    public void disconnect() {
        try {
            dbConnect.close();

        }
        catch (Exception e) {
            System.err.println("Could not connect to Database!");
            e.printStackTrace();
        }
    }
    // function to get all the properties available
    // function that returns all renters
    // function that returns all managers
    // (apartmentType, numBath, numBed, cityQuad, furnishedState) <-- function that returns all properties that match this function returns a arraylist
    // (email,password) <-- function that returns which landlord, manager or registered renter it is as a string (identified as a id)
                            // add a "l" at the end of the integer value for landlord, "m" for manager and "r" for renter
                            // returns empty string if none of the above
    // (IDofperson, "landlord") <-- function that returns properties owned by landlord if the id is of a landlord
                                        // return a ArrayList<Property> with all the properties
                                        // returns any mail that landlord has if the id is of a landlord

    // (firstName, lastName, email, password) <-- function that saves all this info into the database for the renter
    // (message, emailAddressOfRenter) <-- saves message in landlord email in the database of that renter
}