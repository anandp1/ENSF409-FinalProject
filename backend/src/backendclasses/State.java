package backendclasses;

public enum State {
	// enumeration used to specify the different types of listing states used in the database.
	ACTIVE(1), RENTED(2), CANCELLED(3), SUSPENDED(4);
	private int number;
	State(int i) {
		number = i;
	}

	// gets the enumeration as an integer value
	public int getInt() {
		return number;
	}



	// gets the enumeration from an integer
	static public State fromInt(int i) {
		switch(i) {
			case 1:
				return ACTIVE;
			case 2:
				return RENTED;
			case 3:
				return CANCELLED;
			case 4:
				return SUSPENDED;
		}
		return null;
	}

	// gets the enumeration as an int from a string
	static public int fromString(String i) {
		switch(i.toUpperCase()) {
			case "ACTIVE":
				return ACTIVE.getInt();
			case "RENTED":
				return RENTED.getInt();
			case "CANCELLED":
				return CANCELLED.getInt();
			case "SUSPENDED":
				return SUSPENDED.getInt();
		}
		return -1;
	}
}
