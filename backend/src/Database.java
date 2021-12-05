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

}
