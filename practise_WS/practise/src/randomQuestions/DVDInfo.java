package randomQuestions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

public class DVDInfo {

	String title;
	String genre;
	String leadActor;
	
	public DVDInfo(String title, String genre, String leadActor) {
		super();
		this.title = title;
		this.genre = genre;
		this.leadActor = leadActor;
	}
	
	public DVDInfo() {
		
	}

	@Override
	public String toString() {
		return "DVDInfo [title=" + title + ", genre=" + genre + ", leadActor=" + leadActor + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}
	
	public static void main(String[] args) {
		
		List<DVDInfo> dvds = loadDvds("/Users/abhinashjha/Desktop/streamFIle.txt");
		//dvds.forEach(System.out::println);
	}
	
	private static List<DVDInfo> loadDvds(String filePath){
		List<DVDInfo> dvds = null;
		try(Stream<String> streams = Files.lines(Paths.get(filePath))) {
			
		}catch(IOException e) {
			System.out.println("IOException caught!!!"+e);
		}
		return dvds;
	}
	
}
