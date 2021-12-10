package backendclasses;

import java.util.Locale;

public enum Quadrant {
	SW(1), NW(2), NE(3), SE(4);

	private int number;
	
	public int getInt() {
		return number;
	}
	
	Quadrant(int i) {
		number = i;
	}

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
