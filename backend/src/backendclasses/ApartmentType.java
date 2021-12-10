package backendclasses;

import java.util.Locale;

public enum ApartmentType {
    ATTACHED(1), DETACHED(2), TOWNHOUSE(3), APARTMENT(4);

    private int num;

    public int getInt() {
        return num;
    }
    ApartmentType(int num) {
        this.num = num;
    }

    static public ApartmentType fromInt(int i) {
        switch(i) {
            case 1:
                return ATTACHED;
            case 2:
                return DETACHED;
            case 3:
                return TOWNHOUSE;
            case 4:
                return APARTMENT;
        }
        return null;
    }
    static public int fromString(String i) {
        switch(i.toUpperCase()) {
            case "ATTACHED":
                return ATTACHED.getInt();
            case "DETACHED":
                return DETACHED.getInt();
            case "TOWNHOUSE":
                return TOWNHOUSE.getInt();
            case "APARTMENT":
                return APARTMENT.getInt();
        }
        return -1;
    }
}
