package fin.com.advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	List<String> allLines = new ArrayList<String>();
    	
    	try {
			allLines = Files.readAllLines(Paths.get("/Users/finkingma/eclipse-workspace/advent/input.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

    	Integer number = 0;
    	
    	for (String item : allLines) {
    		Integer update = Integer.parseInt(item);
    		number += update;
    	}
    	
        System.out.println( "answer is: " + number );
    }
}
