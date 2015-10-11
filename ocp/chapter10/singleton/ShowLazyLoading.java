import java.util.*;

class Show {
	private static Show INSTANCE;
	
	public static Show getInstance() {
		if (INSTANCE == null) {
			System.out.println("creating singleton");
			INSTANCE = new Show();
		}
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

public class ShowLazyLoading {
	
	public static void main(String[] args) {
		System.out.println("Booking 1A twice: ");
		ticketAgentBooks("1A");
		ticketAgentBooks("1A");
	}
	
	private static void ticketAgentBooks(String seat) {
		Show show = Show.getInstance();
		System.out.println(show.bookSeat(seat));
	}
}
