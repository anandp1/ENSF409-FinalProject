public class Property {
    private final String apartmentType;
    private final Integer numBed;
    private final Integer numBath;
    private final String quadrant;
    private final boolean isFurnished;
    private Listing listing;
    private int propertyID;
    private final String propertyAddress;
    Property(String apartmentType, Integer numBed, Integer numBath, String quadrant, boolean isFurnished, Listing listing, int propertyID, String propertyAddress) {
        this.apartmentType = apartmentType;
        this.numBath = numBath;
        this.numBed = numBed;
        this.quadrant = quadrant;
        this.isFurnished = isFurnished;
        this.listing = listing;
        this.propertyID = propertyID;
        this.propertyAddress = propertyAddress;
    }
    Property(String apartmentType, Integer numBed, Integer numBath, String quadrant, boolean isFurnished, String propertyAddress) {
        this.apartmentType = apartmentType;
        this.numBath = numBath;
        this.numBed = numBed;
        this.quadrant = quadrant;
        this.isFurnished = isFurnished;
        this.propertyAddress = propertyAddress;
    }
    public String getApartmentType() {
        return apartmentType;
    }
    public Integer getNumBed() {
        return numBed;
    }
    public Integer getNumBath() {
        return numBath;
    }
    public String getQuadrant() {
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
