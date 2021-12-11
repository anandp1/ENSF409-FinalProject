package backendclasses;//package Main;

import java.sql.*;
import GUIFrames.BaseFrame;
import database.Database;

public class MainApplication {
    public static void main(String[] args) throws Exception {
    	 Database database = new Database("jdbc:mysql://localhost/RENTAL_PROPERTY_MANAGEMENT_SYSTEM", "Jett", "SecondUser");
    	 database.connect();
    	
    	 Connection db = database.getConnection();
		 //database.increaseDay();
		new BaseFrame(database).setVisible(true);
    	System.out.println("Program Terminated.");
    }
}
