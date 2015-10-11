import java.util.*;

class Show {
	private Set<String> availableSeats;
	
	public Show() {
		availableSeats = new HashSet<String>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}
	
	public boolean bookSeat(String seat) {
		return availableSeats.remove(seat);
	}
}

public class WrongShow {
	
	public static void main(String[] args) {
		ticketAgentBooks("1A");
		ticketAgentBooks("1A");
	}
	
	private static void ticketAgentBooks(String seat) {
		Show show = new Show();
		System.out.println(show.bookSeat(seat));
	}
}
