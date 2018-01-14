package airportSecurityState.driver;

import java.io.File;
import java.io.FileNotFoundException;

import airportSecurityState.util.FileProcessor;
import airportSecurityState.util.MyLogger;
import airportSecurityState.util.Results;
import airportSecurityState.util.MyLogger.DebugLevel;
import airportSecurityState.airportStates.StateChangerContext;
import airportSecurityState.util.MyLogger;

public class Driver {
	
	//global variables
	public  static int numberOfTravellers = 0;
	public static String input;
	public static int day = 0;
	public static int prohibitedItems = 0;
	public static String output;

	//main class
	public static void main(String[] args) throws FileNotFoundException {
		
		if ((args[0].contains("${arg")) || (args[1].contains("${arg")) ||(args[2].contains("${arg"))) {
			System.out.println("The  Arguments provided is incorrect.Please enter input.txt,output.txt ,debug value as arguments ");
			System.exit(1);

		}
		int debugNo=Integer.parseInt(args[2]);
		if ((debugNo<0 )|| (debugNo>4)){
			System.out.println("Enter debug value between 0 and 4 ");
			System.exit(1);
		}
		MyLogger.setDebugValue(debugNo);
		
		//setDebugValue(1);
		input = args[0];
		output = args[1];
		FileProcessor fpInstance = new FileProcessor();
		File f1 = new File(output);
		StateChangerContext stc = new StateChangerContext();
		while (fpInstance.sc.hasNext()) {
			String readValue = fpInstance.readLine();
			String[] parts;
			parts = readValue.split(";");

			String[] DayString;
			DayString = parts[0].split(":");

			day = Integer.parseInt(DayString[1]);
			//System.out.println("Day is " + day);

			String[] TODString;
			TODString = parts[1].split(":");
			String tod;
			tod = (TODString[1] + TODString[2]);
			//System.out.println("Time is " + tod);

			String[] airlineString;
			airlineString = parts[2].split(":");
			String airlineName;
			airlineName = airlineString[1];
			//System.out.println("Airline is " + airlineName);

			String[] itemString;
			itemString = parts[3].split(":");
			String itemName;
			itemName = itemString[1];
			//System.out.println("item is " + itemName);
			// System.out.println(" ");
			if ((itemName.equalsIgnoreCase("Gun")) || (itemName.equalsIgnoreCase("Blade"))
					|| (itemName.equalsIgnoreCase("NailCutter")) || (itemName.equalsIgnoreCase("Knife"))) {
				prohibitedItems++;
				MyLogger.writeMessage("Prohibited item found", DebugLevel.FROM_RESULTS);
			}

			// System.out.println("LineCount is " + fpInstance.lineCount);

			float averageTrafficPerDay = 0;
			averageTrafficPerDay = fpInstance.lineCount / day;
			//System.out.println("average traffic per day = " + averageTrafficPerDay);

			float averageProhibitedItemsPerDay = 0;
			averageProhibitedItemsPerDay = prohibitedItems / day;
			//System.out.println("average prohibitem items per day " + averageProhibitedItemsPerDay);
			//calling context class
	///		
			String resultString;
			resultString = stc.tightenOrLoosenSecurity(averageTrafficPerDay, averageProhibitedItemsPerDay);
			//populating results
			
			Results r1 = new Results();
			r1.popList(resultString);

			// writing results to file
			r1.writeToStdout(resultString);
			MyLogger.writeMessage("Program released ", DebugLevel.RELEASE);
			r1.writeToFile(f1);
			
			
		//	MyLogger.DebugLevel.IN_RESULTS
		}
		
	}

}
