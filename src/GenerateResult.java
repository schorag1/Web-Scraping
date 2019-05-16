import java.io.*;
import java.util.List;

import com.opencsv.CSVWriter;

public class GenerateResult {
	
	private final String path = "./result.csv";
	
	void addDataToCSV(List<String> movies) {
		
		String[] moviesList = movies.toArray(new String[movies.size()]);
		
		// First create file object for file placed at location specified by filepath
		File file = new File(path);
		
		try {
			
			// Create FileWriter object with file as parameter
			FileWriter outputFile = new FileWriter(file);
			
			// Create CSVWriter with the default "," delimiter
			CSVWriter writer = new CSVWriter(outputFile);
			
			// Add the movies list to writer object
			writer.writeNext(moviesList);
			
			// Closing the connection
			writer.close();
			
		} catch (IOException e) {
			
			System.out.println("File Creation Failed!!!!");
			e.printStackTrace();
		}
		
		
		System.out.println("File Successfully Created!!!!!!");
	}
}
