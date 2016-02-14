import javax.swing.DefaultListModel;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Notiz {
  private File FILE ; 
  private File TitelFile;
  private BufferedReader in; 
  private StringBuffer lm = new StringBuffer();             //in denen steht sp‰ter alles drin
  private StringBuffer titel = new StringBuffer();
  
  //Konstruktor
  public Notiz (String path, String titelpath){             //String der Path heiﬂt um zu wissen wo die Datei liegt
    FILE = new File (path);                                 //Verbingdung zur Datei
    TitelFile = new File(titelpath);
    lm = laden();                                           //lm Datei in der die Notizen stehen
    titel = titelladen();
  }
  
  public void set(String s){
    lm.delete(0,lm.capacity());
    lm.append(s);
    speichern();
  }
  
  public void settitel(String s){
    titel.delete(0,lm.capacity());
    titel.append(s);
    speichern();
  }
  
  public void loesche(){
    lm.delete(0,lm.capacity());
    titel.delete(0,titel.capacity());
    titel.append("leere Notiz");
    speichern();
  }
  
  public String get(){
    String s = lm.toString();
    return s;
  }
  
  public String gettitel(){
    String s = titel.toString();
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
  
  private  StringBuffer titelladen() {
    try{
      in = new BufferedReader(new FileReader(TitelFile));
      String strLine;
      while((strLine = in.readLine()) != null)
        {
        titel.append(strLine);
        titel.append("\n"); 
      }
      in.close();
      return titel;
      
    }catch(IOException e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
      return null;
    }
  }
  
  public void speichern() {
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(FILE));    //Buffered Writer
      BufferedWriter tout = new BufferedWriter(new FileWriter(TitelFile));
      out.write(lm.toString());
      tout.write(titel.toString());
      out.close();
      tout.close();
    }
    catch(IOException e){
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
    
  }  
} // end of class Notiz
