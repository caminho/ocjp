import java.util.*;
import java.io.*;

class DVDInfo implements Comparable<DVDInfo> {
	private String title;
	private String genre;
	private String leadActor;
	
	DVDInfo(String t, String g, String lA) {
		this.title = t;
		this.genre = g;
		this.leadActor = lA;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getGenre() {
		return genre;
	}
	
	public String getLeadActor() {
		return leadActor;
	}
	
	public int compareTo(DVDInfo other) {
		return getTitle().compareTo(other.getTitle());
	}
	
	public String toString() {
		return "\ntitle: " + getTitle() + ", genre: " + getGenre() +
			", lead actor: " + getLeadActor();
	}
}

class GenreSort implements Comparator<DVDInfo> {
	public int compare(DVDInfo one, DVDInfo two) {
		return one.getGenre().compareTo(two.getGenre());
	}
}

public class DVDInfoTest {
	static List<DVDInfo> populateList() {
		List<DVDInfo> resultList = new ArrayList<>();
		try (FileReader fr = new FileReader("dvdinfo.txt");
			BufferedReader br = new BufferedReader(fr)) {
			String line = null;
			while ((line = 	br.readLine()) != null) {
				String[] tokens = line.split("/");
				if (tokens.length == 3) {
					resultList.add(new DVDInfo(tokens[0], tokens[1], tokens[2]));
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return resultList;
	}
	
	public static void main(String[] args) {
		List<DVDInfo> dvdInfoList = new ArrayList<>();
		dvdInfoList = populateList();
		Collections.sort(dvdInfoList);
		System.out.println(dvdInfoList);
		
		GenreSort genreSort = new GenreSort();
		Collections.sort(dvdInfoList, genreSort);
		
		System.out.println(dvdInfoList);
	}
}
