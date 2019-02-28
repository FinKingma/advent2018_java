package fin.com.advent;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    	Integer[][] multiArray = new Integer[1000][1000];
    	
    	String patternString = "#(\\d+) @ (\\d+),(\\d+): (\\d+)x(\\d+)";
    	Pattern pattern = Pattern.compile(patternString);
    	
    	for (String line : allLines) {
    		
            Matcher matcher = pattern.matcher(line);

            while(matcher.find()) {
            	int leftPos = Integer.parseInt(matcher.group(2));
            	int topPos = Integer.parseInt(matcher.group(3));
            	int width = Integer.parseInt(matcher.group(4));
            	int height = Integer.parseInt(matcher.group(5));
            	for (int x = leftPos; x < leftPos + width; x++) {
            		for (int y = topPos; y < topPos + height; y++) {
            			if (multiArray[x] != null && multiArray[x][y] != null) {
            				int currentValue = multiArray[x][y];
            				multiArray[x][y] = currentValue + 1;
            			} else {
            				multiArray[x][y] = 1;
            			}
            		}
            	}
            }
    	}
    	
		for (String line : allLines) {
			boolean overlap = false;
    		
            Matcher matcher = pattern.matcher(line);

            while(matcher.find()) {
            	int id = Integer.parseInt(matcher.group(1));
            	int leftPos = Integer.parseInt(matcher.group(2));
            	int topPos = Integer.parseInt(matcher.group(3));
            	int width = Integer.parseInt(matcher.group(4));
            	int height = Integer.parseInt(matcher.group(5));
            	for (int x = leftPos; x < leftPos + width; x++) {
            		for (int y = topPos; y < topPos + height; y++) {
            			if (multiArray[x][y] > 1) {
            				overlap = true;
            			}
            		}
            	}
            	if (!overlap) {
            		System.out.println( "answer is: " + id );
            	}
            }
    	}
    }
}
