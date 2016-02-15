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
  private StringBuffer lm = new StringBuffer();             //in ihnen steht später die Notiz drin
  private StringBuffer titel = new StringBuffer();
  
  //Konstruktor
  public Notiz (String path, String titelpath){             //String der Path heißt, um zu wissen wo die Datei liegt
    FILE = new File (path);                                 //Verbingdung zur Textdatei in der die Notiz liegt
    TitelFile = new File(titelpath);
    laden();                                                //beim Programmstart (wenn Notiz erstellt wird) läd es den Text in das Feld
    titelladen();
  }
  
  public void set(String s){
    lm.delete(0,lm.capacity());                             //altes löschen von Zeile 0 bis capacity (soviel wurde belegt)
    lm.append(s);                                           //neues wird in die Variable s gelegt
    speichern();                                            //Notiztext in txt-Datei speichern
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
    String s = lm.toString();                             //Inhalt wird auf Variable s gespeichert
    return s;                                             //Inhalt (s) wird zurückgegeben (zum ausgeben)
  }
  
  public String gettitel(){
    String s = titel.toString();
    return s;
  }
  
  private  void laden() {
    try{
      in = new BufferedReader(new FileReader(FILE));                 //Buffered Reader/FileReader: benutzt man um Dateien auszulesen -hier:txt-Datei die in FILE hinterlegt ist
      String strLine;
      while((strLine = in.readLine()) != null)                      //in.readLine: liest Zeilen des Text, der in BufferedReader "kopiert" wurde aus -solange bis es keine Zeilen mit Inhalt mehr gibt
      {
        lm.append(strLine);                                          //neuer Eintrag im Objekt hinzufügen
        lm.append("\n");                                            //Zeilenumbruch
      }
      in.close();
      
    }catch(IOException e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
  }
  
  
  private  void titelladen() {
    try{
      in = new BufferedReader(new FileReader(TitelFile));
      String strLine;
      while((strLine = in.readLine()) != null)
      {
        titel.append(strLine);
      }
      in.close();
      
    }catch(IOException e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
  }
  
  public void speichern() {
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(FILE));          //BufferedWriter/FileWriter: Dateien beschreiben -hier:txt-Datei die in FILE hinterlegt ist
      BufferedWriter tout = new BufferedWriter(new FileWriter(TitelFile));
      out.write(lm.toString());                                               //alles wird in die Textdatei geladen
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
