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
  //Referenzattriubte
  
  
  //Konstruktor
  public Todo(){;
    
  }
  
  //Methoden
  public boolean todojetztsichtbar() {
    return true;
  } 
  public boolean todojetztnichtsichtbar() {
    return false;
  } 
  
  public void todoEintraghinzufuegen(String todoText){
    
  }
  
  private void save(DefaultListModel lm) {
    
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
  private DefaultListModel load() {
    DefaultListModel lm = new DefaultListModel();
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
