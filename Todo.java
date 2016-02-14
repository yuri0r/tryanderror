import javax.swing.DefaultListModel;
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Todo {
  //Atributte
  private static final File FILE = new File ("Todo.txt");
  private DefaultListModel lm = new DefaultListModel(); 
  //Referenzattriubte
  
  
  //Konstruktor
  public Todo(){;
    lm = laden();
  }
  
  //Methoden
  
  public void Eintraghinzufuegen(String todoText){
    lm.insertElementAt(todoText,0);
  }
  
  public DefaultListModel get(){
    return lm;
  }
  
  public void loescheAlles(){
    lm.removeAllElements();
  }
  
  public void loeschen(int i){
    lm.removeElementAt(i);
  }
  
  public void speichern() {
    
    try {
      BufferedWriter out = new BufferedWriter(new FileWriter(FILE));    //Buffered Writer
      
      for(int i = 0; i < lm.getSize(); i++)
      {
        out.write((String)lm.getElementAt(i));
        out.newLine();
      }
      out.close();
    }
    catch(IOException e){
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
    }
    
  }
  // Funktion Load
  private  DefaultListModel laden() {
    
    try{
      BufferedReader in = new BufferedReader(new FileReader(FILE));    //Buffered Reader
      
      String strLine;
      while((strLine = in.readLine()) != null)
      {
        lm.addElement(strLine);
      }
      in.close();
      return lm;
    }
    catch(IOException e) {
      System.err.println("Error: " + e.getMessage());
      System.exit(1);
      return null;
    }
  }
} // end of class Todo
