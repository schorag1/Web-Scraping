import java.io.IOException;
import java.util.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo {

	public static void main(String[] args) {
		
		try {
			// 'connect' initiates a connection to the specified url
			// 'userAgent' is used to mock a connection as if a browser is requesting it
			Document doc = Jsoup.connect("https://www.imdb.com/list/ls053399670/").userAgent("Mozilla/17.0").get();
		
			// Get all the elements with h3 that have name of the movies
			Elements moviesList = doc.select("h3.lister-item-header");
			
			List<String> movies = new ArrayList<>();
			
			// Extracting the name of each movie and storing it in a list
			for(Element movie: moviesList) {
				movies.add(movie.getElementsByTag("a").first().text());
			} 
			
			// A separate class which takes care of writing the data into a csv file
			GenerateResult generate = new GenerateResult();
			generate.addDataToCSV(movies);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
