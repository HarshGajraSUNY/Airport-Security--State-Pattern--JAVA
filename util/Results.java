package airportSecurityState.util;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;

import airportSecurityState.driver.Driver;
import airportSecurityState.util.MyLogger.DebugLevel;
import airportSecurityState.util.MyLogger;

/**
 *
 * @author HarshGajra
 */
public class Results implements FileDisplayInterface,StdoutDisplayInterface 
{
 //int index1=0;
   private String stringsArray ="";

  static ArrayList<String> opList= new ArrayList<String>();
 
    
 FileWriter output=null;
 
    public Results() {
	// TODO Auto-generated constructor stub
    //	opList= new ArrayList<String>();
    	MyLogger.writeMessage("Entering results class", DebugLevel.IN_RESULTS);
}

	@Override
    public void writeToFile(File f) {

 
 try{
   output= new FileWriter(f);
  BufferedWriter writer=new BufferedWriter(output);
  //String ss = String.valueOf(s);
  
 
  for(int k =0 ; k< opList.size() ; k++){
	  //System.out.println("op list "+opList.toString());
	  
	  writer.append(opList.get(k));
	  writer.newLine();
  }
  
 
  writer.close();
} catch (Exception e) {
  throw new RuntimeException(e);
}
	}
	
	public void writeToStdout( String s){
		System.out.println("The Operations Performed is "+s+"\n");
	}

public void popList(String s){
	
	opList.add(s);
}
        
    }
    
    
    
    
    
    


