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
    laden();
  }
  
  //Methoden
  
  public String get(){
    String s = lm.toString();               //TextInhalt wird auf Variable s gespeichert
    return s;                              //Inhalt (s) wird zurückgegeben (zum ausgeben)
  }
  
  // Funktion Load
  private  void laden() {
    
    try{
      BufferedReader in = new BufferedReader(new FileReader(FILE));    ///Buffered Reader/FileReader: benutzt man um Dateien auszulesen -hier:txt-Datei die in FILE hinterlegt ist
      
      String strLine;
      while((strLine = in.readLine()) != null)                         //in.readLine: liest Zeilen des Text, der in BufferedReader "kopiert" wurde aus -solange bis es keine Zeilen mit Inhalt mehr gibt
      {
        lm.append(strLine);                                            //neuer Eintrag im Objekt hinzufügen
        lm.append("\n");                                               //Zeilenumbruch
      }
      in.close();
      
    }catch(IOException e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
  }
  
  
} // end of class Hilfe
