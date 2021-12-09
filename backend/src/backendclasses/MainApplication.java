package backendclasses;//package Main;

import java.sql.*;
import GUIFrames.BaseFrame;


public class MainApplication {
    public static void main(String[] args) throws Exception {
        
    	// System.out.println("Program Started");
    	 database.Database database = new database.Database("jdbc:mysql://localhost/RENTAL_PROPERTY_MANAGEMENT_SYSTEM", "Jett", "SecondUser");
    	 database.connect();
    	
    	 Connection db = database.getConnection();
    	// final backendclasses.Quadrant quadrant = backendclasses.Quadrant.SW;
    	// System.out.println(quadrant.getInt());
    	// database.disconnect();
		new BaseFrame(db).setVisible(true);
    	System.out.println("Program Terminated.");
    }
}
