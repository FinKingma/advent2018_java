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
    	
    	Integer differPos = 0;
    	
    	for (String item : allLines) {
    		for (String compareItem : allLines) {
    			Integer differences = 0;
    			for(int i=0; i < item.length(); i++)
    		    {    
    		    	if (item.charAt(i) != compareItem.charAt(i)) {
    		    		differences++;
    		    		differPos = i;
    		    	}
    		    	if (differences > 1) {
    		    		break;
    		    	}
    		    }
    			if (differences == 1) {
    				item = item.replace(String.valueOf(item.charAt(differPos)), "");
    				System.out.println( "answer is: " + item);
    			}
    		}
    	}
    	
    }
}
