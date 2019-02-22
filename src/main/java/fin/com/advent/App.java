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
    	List<Integer> historyLines = new ArrayList<Integer>();
    	
    	try {
			allLines = Files.readAllLines(Paths.get("/Users/finkingma/eclipse-workspace/advent/input.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}

    	Integer number = 0;
    	boolean finished = false;
    	Integer attempts = 0;
    	historyLines.add(number);
    	
    	do {
	    	for (String item : allLines) {
	    		Integer update = Integer.parseInt(item);
	    		number += update;
	    		
	    		if (historyLines.contains(number)) {
	    			System.out.println( "answer is: " + number );
	    			finished = true;
	    			break;
	    		}
	    		historyLines.add(number);
	    		attempts ++;
	    	}
    	}
	    while (finished == false && attempts < 1000000);
    }
}
