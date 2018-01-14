package airportSecurityState.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import airportSecurityState.driver.Driver;
import static airportSecurityState.util.FileProcessor.sc;

/**
 *
 * @author HarshGajra
 * 
 *         import java.io.BufferedReader; import java.io.File; import
 *         java.io.FileInputStream; import java.io.IOException; import
 *         java.io.InputStreamReader; import myArrayList.MyArrayList; import
 *         java.io.FileNotFoundException; import java.util.Scanner; import
 *         java.util.logging.Level; import java.util.logging.Logger;
 * 
 * 
 * 
 * 
 * 
 *         /**
 *
 * @author HarshGajra
 */
// FileProcessor to read values from file
public class FileProcessor {

	public static int lineCount = 0;
	String readInput = "";
	// String fp =
	// "C:\\Users\\HarshGajra\\Documents\\NetBeansProjects\\myArrayList\\src\\myarraylist\\File";

	File f;

	public static Scanner sc;

	public FileProcessor() throws FileNotFoundException {
		this.f = new File(Driver.input);

		sc = new Scanner(f);
		// int totalLineCount=setLineCount();
		// System.out.println("total linecount is "+getLineCount());
	}

	// readLine method to return every line read

	public String readLine() {

		while (sc.hasNext()) {
			// for(int i=-1;i<=lineCount;i++)
			// {
			// readInput = readInput+sc.nextLine()+".";
			// lineCount++;
			String readValue = sc.nextLine();
			lineCount++;
			// sc.nextLine();
			// System.out.println("linecount in fp"+getLineCount());
			return readValue;
			// }
			// System.out.println("readInput is " +readInput) ;
			// processLine(lineCount,readInput);

		}

		// System.out.println(readInput);

		return null;

	}

	// setters
	public int setLineCount() {
		while (sc.hasNext()) {

			// for(int i=-1;i<=lineCount;i++)
			// {
			// readInput = readInput+sc.nextLine()+".";
			String readValue1 = sc.nextLine();

		}
		return lineCount;
	}

	// getters
	public int getLineCount() {
		return lineCount;
	}

}