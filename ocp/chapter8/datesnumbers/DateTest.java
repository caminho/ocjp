import java.util.Date;

public class DateTest {
	public static void main(String[] args) {
		Date d1 = new Date(1_000_000_000_000L);
		System.out.println("1st date: " + d1);
		
		d1.setTime(d1.getTime() + 3_600_000);
		System.out.println("new time: " + d1);
		
		Date now = new Date();
		System.out.println("now: " + now);
		System.out.println("now (in milis.): " + now.getTime());
	}
}
