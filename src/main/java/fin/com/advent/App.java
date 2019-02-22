package fin.com.advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    	
    	Integer twoOccurances = 0;
    	Integer threeOccurances = 0;
    	
    	boolean twoCounted = false;
    	boolean threeCounted = false;
    	
    	for (String item : allLines) {
    		twoCounted = false;
    		threeCounted = false;
    		do {
    		    char c = item.charAt(0);
    		    int count = 0;
    		    for(int j=0; j < item.length(); j++)
    		    {    
    		    	if(item.charAt(j) == c)
    		            count++;
    		    }
    		    item = item.replace(String.valueOf(c), "");
    		    if (count == 2 && twoCounted == false) {
    		    	twoOccurances++;
    		    	twoCounted = true;
    		    }
    		    if (count == 3 && threeCounted == false) {
    		    	threeOccurances++;
    		    	threeCounted = true;
    		    }
    		} while (item.length() > 0);
    	}
    	
    	System.out.println( "answer is: " + twoOccurances * threeOccurances );
    }
}
