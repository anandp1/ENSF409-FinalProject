package backendclasses;

import database.Database;

import java.util.ArrayList;
import java.util.Objects;

public class Manager {
    private ArrayList<Property> allProperties;
    private final Database db;
    public Manager(Database db) {
        this.db = db;
    }
    public ArrayList<Property> getProperties() {
        // calls database to return all properties

        return db.getAllproperties();
    }
    public ArrayList<String> getRenters() {
        // calls database to return all renters name
        return db.getAllRenterNames();
    }
    public ArrayList<String> getLandlords() {
        // calls database to return all renters name
        return db.getAllLandlordNames();
    }
    public void updateFee(int propertyID, double fee) {
        // get property that matches this name
        // update fee of this property name in the database
    }
    public void updatePeriod(int propertyID, int period) {
        // get property that matches this name
        // update the period in the database with the same property name
    }
    public void setSummaryInfo(int period) {
        // call database to get all properties that match this period
        allProperties = new ArrayList<Property>();
        for(Property property : getProperties()) {
            if(property.getListing().getFee().getPeriod() == period) {
                allProperties.add(property);
            }
        }
    }
    public int getNumListed() {
        // use allProperties to get number of properties in the period
        return allProperties.size();
    }
    public int getNumRented() {
        // use allProperties to get number of properties rented in that period
        int numRented = 0;
        for(Property property : allProperties) {
            if(property.getListing().getListingState().getInt() == 2) {
                numRented++;
            }
        }
        return numRented;
    }
    public int getNumActive() {
        // use allProperties to get number of properties listed as rented
        int numActive = 0;
        for(Property property : allProperties) {
            if(property.getListing().getListingState().getInt() == 1) {
                numActive++;
            }
        }
        return numActive;
    }
    public ArrayList<ArrayList<String>> listNumRented() {
        // TO DO:
        // Add landlords name to the array

        ArrayList<ArrayList<String>> listNumRented = new ArrayList<>();
        int i = 0;
        for(Property property : allProperties) {
            if(property.getListing().getListingState().getInt() == 2) {
                listNumRented.add(new ArrayList<>());
                listNumRented.get(i).add(
                        "Property ID: " + String.valueOf(property.getPropertyID()) +
                        " Address: " + property.getPropertyAddress()
                );
                i++;
            }
        }
        // ONLY RENTED
        // make a new arraylist with only properties that are rented
        // call database to return landlord name that matches properties of the arraylist
            // basically pass the arraylist as a argument
        // uses allProperties to get property id number and append it to the arraylist
        // uses allProperties to get property address and append it to the arraylist
        return listNumRented;
    }
    public void setListingState(int propertyID, String propertyState) {
        // get property that matches this name
        // update the property with the name with the new state in the database
        db.setListingState(Objects.requireNonNull(State.fromInt(State.fromString(propertyState))), propertyID);
    }
}
