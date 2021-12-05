public class Property {
    private final String apartmentType;
    private final Integer numBed;
    private final Integer numBath;
    private final String quadrant;
    private final boolean isFurnished;
    private final Listing listing;
    Property(String apartmentType, Integer numBed, Integer numBath, String quadrant, boolean isFurnished, Listing listing) {
        this.apartmentType = apartmentType;
        this.numBath = numBath;
        this.numBed = numBed;
        this.quadrant = quadrant;
        this.isFurnished = isFurnished;
        this.listing = listing;
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

    public Listing getListing() {
        return listing;
    }
}
