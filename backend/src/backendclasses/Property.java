package backendclasses;//package Main;

public class Property {
    // used to hold the various attributes of a property
    private final ApartmentType apartmentType;
    private final Integer numBed;
    private final Integer numBath;
    private final Quadrant quadrant;
    private final boolean isFurnished;
    private Listing listing;
    private int propertyID;
    private final String propertyAddress;

    // constructor, used to set all of the attributes of the property.
    // sets all final variables and sets the listing and property id
    public Property(ApartmentType apartmentType, Integer numBed, Integer numBath, Quadrant quadrant, boolean isFurnished, Listing listing, int propertyID, String propertyAddress) {
        this.apartmentType = apartmentType;
        this.numBath = numBath;
        this.numBed = numBed;
        this.quadrant = quadrant;
        this.isFurnished = isFurnished;
        this.listing = listing;
        this.propertyID = propertyID;
        this.propertyAddress = propertyAddress;
    }

    // constructor, used to set all of the attributes of the property.
    // only sets all final variables
    public Property(ApartmentType apartmentType, Integer numBed, Integer numBath, Quadrant quadrant, boolean isFurnished, String propertyAddress) {
        this.apartmentType = apartmentType;
        this.numBath = numBath;
        this.numBed = numBed;
        this.quadrant = quadrant;
        this.isFurnished = isFurnished;
        this.propertyAddress = propertyAddress;
    }

    // returns the various attributes
    public ApartmentType getApartmentType() {
        return apartmentType;
    }
    public Integer getNumBed() {
        return numBed;
    }
    public Integer getNumBath() {
        return numBath;
    }
    public Quadrant getQuadrant() {
        return quadrant;
    }
    public boolean getIsFurnished() {
        return isFurnished;
    }
    public int getPropertyID() {
        return propertyID;
    }
    public String getPropertyAddress() {
        return propertyAddress;
    }
    public Listing getListing() {
        return listing;
    }
}
