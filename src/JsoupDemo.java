import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupDemo {

	public static void main(String[] args) {
		
		try {
			
			Document doc = Jsoup.connect("https://www.imdb.com/list/ls053399670/").userAgent("Mozilla/17.0").get();
		
		
			Elements moviesList = doc.select("h3.lister-item-header");
			
			int i=0;
			for(Element movie: moviesList) {
				System.out.println(++i + ":" + movie.getElementsByTag("a").first().text());
			} 
		
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
