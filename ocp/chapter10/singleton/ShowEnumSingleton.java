import java.util.*;

enum Show {
	INSTANCE;
	
	private Set<String> availableSeats;
	
	private Show() {
		availableSeats = new HashSet<String>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}
	
	public boolean bookSeat(String seat) {
		return availableSeats.remove(seat);
	}
}

public class ShowEnumSingleton {
	
	public static void main(String[] args) {
		ticketAgentBooks("1A");
		ticketAgentBooks("1A");
	}
	
	private static void ticketAgentBooks(String seat) {
		Show show = Show.INSTANCE;
		System.out.println(show.bookSeat(seat));
	}
}
