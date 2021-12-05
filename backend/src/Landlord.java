import java.util.ArrayList;

public class Landlord {
    private final ArrayList<Property> properties;
    private final int landlordID;
    Landlord(int landlordID, ArrayList<Property> properties) {
        this.landlordID = landlordID;
        this.properties = properties;
    }
    public void registerProperty(Property property) {
        // call database using landlordID and save all this info
        // add it to all the properties in the database
        // in the database each property has a id to it indicating the landlord that in charge of it

    }
    public void messageRenter(String message, int renterID) {
        // save message for the renterID in the database
    }
    public void processPayment() {
        // update the payment to 1 from 0 in the database indicating has paid
    }
    public void postProperty() {
        // turns the property that is associated with this landlords id
        // into active only if it its currently suspended
    }
    public ArrayList<Property> getProperty() {
        return properties;
    }



}
