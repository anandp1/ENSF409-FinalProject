package backendclasses;

import java.util.Locale;

// enumeration used to specify the different types of quadrants used in the database.
public enum Quadrant {
	SW(1), NW(2), NE(3), SE(4);
	private int number;
	Quadrant(int i) {
		number = i;
	}

	// gets the enumeration as an integer value
	public int getInt() {
		return number;
	}

	// gets the enumeration from an integer
	static public Quadrant fromInt(int i) {
		switch(i) {
			case 1:
				return SW;
			case 2:
				return NW;
			case 3:
				return NE;
			case 4:
				return SE;
		}
		return null;
	}

	// gets the enumeration as an int from a string
	static public int fromString(String i) {
		switch(i.toUpperCase()) {
			case "SW":
				return SW.getInt();
			case "NW":
				return NW.getInt();
			case "NE":
				return NE.getInt();
			case "SE":
				return SE.getInt();
		}
		return -1;
	}
}
