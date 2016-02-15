import javax.swing.DefaultListModel;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Todo {
  //Atributte
  private static final File FILE = new File ("Todo.txt");      //txt-Datei auf Variable/Attribut FILE
  private DefaultListModel lm = new DefaultListModel();        //DefaultListModel: Dateityp -wird benutzt um Todoeinträge zu erstellen
  //Referenzattriubte
  
  
  //Konstruktor
  public Todo(){;
    laden();                                            //beim Programmstart (wenn Todo erstellt wird) läd es Text in das Feld
  }
  
  //Methoden
  
  public void Eintraghinzufuegen(String todoText){     //Text von Variable text auf Variable todoText laden
    lm.insertElementAt(todoText,0);                    //neuen Eintrag an oberer Stelle (0) hinzufügen
  }
  
  public DefaultListModel get(){
    return lm;                                         //Eintrag zurückgeben
  }
  
  public void loescheAlles(){
    lm.removeAllElements();                            //alle Einträge löschen
  }
  
  public void loeschen(int i){
    lm.removeElementAt(i);                            //Eintrag an bestimmter Stelle (i) entfernen
  }
  
  public void speichern() {
    
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(FILE));     //BufferedWriter/FileWriter: Dateien beschreiben -hier:txt-Datei die in FILE hinterlegt ist
      
      for(int i = 0; i < lm.getSize(); i++)                              //solange ich Zeilen hab (ersichtlich durch getSize())
      {
        out.write((String)lm.getElementAt(i));                           //alle Zeilen (Elemente) auf Textdatei schreiben (nacheinandern: Zeile für Zeile)
        out.newLine();                                                   //Macht nach jeden Element/Zeile einen Umbruch
      }
      out.close();
    }
    catch(IOException e){
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
    
  }
  // Funktion Load
  private  void laden() {           
    
    try{
      BufferedReader in = new BufferedReader(new FileReader(FILE));    //Buffered Reader/FileReader: benutzt man um Dateien auszulesen -hier:txt-Datei die in FILE hinterlegt ist
      
      String strLine;
      while((strLine = in.readLine()) != null)                         //in.readLine: liest Zeilen des Text, der in BufferedReader "kopiert" wurde aus -solange bis es keine Zeilen mit Inhalt mehr gibt
      {
        lm.addElement(strLine);                                        //neuer Eintrag im Objekt (Liste) hinzufügen
      }
      in.close();                                                      //Buffered Reader schließen da man ihn nicht mehr braucht
    }
    catch(IOException e) {                                             //wenns nicht geht Fehlermeldung ausgeben -Fehlermeldung in e abgelegt
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
  }
} // end of class Todo
