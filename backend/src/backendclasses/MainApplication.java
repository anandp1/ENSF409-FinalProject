package backendclasses;//package Main;

import java.sql.*;
import GUIFrames.BaseFrame;
import database.Database;

public class MainApplication {
    public static void main(String[] args) throws Exception {
        
    	// System.out.println("Program Started");
    	 Database database = new Database("jdbc:mysql://localhost/RENTAL_PROPERTY_MANAGEMENT_SYSTEM", "root", "radvb1009");
    	 database.connect();
    	
    	 Connection db = database.getConnection();
    	// final backendclasses.Quadrant quadrant = backendclasses.Quadrant.SW;
    	// System.out.println(quadrant.getInt());
    	// database.disconnect();
		new BaseFrame(database).setVisible(true);
    	System.out.println("Program Terminated.");
    }
}
