//package Main;

import java.sql.*;
import GUIFrames.BaseFrame;


public class MainApplication {
    public static void main(String[] args) throws Exception {
        
    	// System.out.println("Program Started");
    	// Database database = new Database("jdbc:mysql://localhost/RENTAL_PROPERTY_MANAGEMENT_SYSTEM", "Jett", "SecondUser");
    	// database.connect();
    	
    	// Connection db = database.getConnection();
    	// final Quadrant quadrant = Quadrant.SW;
    	// System.out.println(quadrant.getInt());
    	// database.disconnect();
		new BaseFrame().setVisible(true);
    	System.out.println("Program Terminated.");
    }
}
