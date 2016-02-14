import javax.swing.DefaultListModel;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.StringBuffer;

public class Hilfe {
  //Atributte
  private static final File FILE = new File ("Hilfe.txt");
  private StringBuffer lm = new StringBuffer(); 
  
  //Referenzattriubte
  
  //Konstruktor
  public Hilfe(){;
    lm = laden();
    }
  
  //Methoden
  
  public String get(){
  String s = lm.toString();
  return s;
  }
  
   // Funktion Load
  private  StringBuffer laden() {
    
    try{
      BufferedReader in = new BufferedReader(new FileReader(FILE));    //Buffered Reader
      
      String strLine;
      while((strLine = in.readLine()) != null)
        {
        lm.append(strLine);
        lm.append("\n"); 
      }
      in.close();
      return lm;
      
    }catch(IOException e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
      return null;
    }
  }
  

} // end of class Hilfe
