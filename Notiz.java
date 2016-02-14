import javax.swing.DefaultListModel;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Notiz {
  private File FILE ; 
  private BufferedReader in; 
  private StringBuffer lm = new StringBuffer();  
  
  public Notiz (String path){
    FILE = new File (path);
    lm = laden();
  }
  
  public void set(String s){
    lm.delete(0,lm.capacity());
    lm.append(s);
    speichern();
  }
  
  public void loesche(){
    lm.delete(0,lm.capacity());
    speichern();
  }
  
  public String get(){
    String s = lm.toString();
    return s;
  }
  
  private  StringBuffer laden() {
    try{
      in = new BufferedReader(new FileReader(FILE));
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
  
  public void speichern() {
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(FILE));    //Buffered Writer
      out.write(lm.toString());
      out.close();
    }
    catch(IOException e){
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
    
  }  
} // end of class Notiz
