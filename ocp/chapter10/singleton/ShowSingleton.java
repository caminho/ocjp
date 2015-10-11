import java.util.*;

class Show {
	private static final Show INSTANCE = new Show();
	
	public static Show getInstance() {
		return INSTANCE;
	}
	
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

public class ShowSingleton {
	
	public static void main(String[] args) {
		ticketAgentBooks("1A");
		ticketAgentBooks("1A");
	}
	
	private static void ticketAgentBooks(String seat) {
		Show show = Show.getInstance();
		System.out.println(show.bookSeat(seat));
	}
}
