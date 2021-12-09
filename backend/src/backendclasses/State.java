package backendclasses;

public enum State {
	ACTIVE(1), RENTED(2), CANCELLED(3), SUSPENDED(4);

	private int number;
	
	public int getInt() {
		return number;
	}
	
	State(int i) {
		number = i;
	}


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

	static public int fromString(String i) {
		switch(i) {
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
