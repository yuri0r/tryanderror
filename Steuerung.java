import javax.swing.DefaultListModel;

public class Steuerung {
  //Referenzattribute
  private Todo todo = new Todo();
  private Programm programm = new Programm();
  private Hilfe hilfe = new Hilfe();
  private Notiz notiz1 = new Notiz();
  private Notiz notiz2 = new Notiz();
  private Notiz notiz3 = new Notiz();
  private Notiz notiz4 = new Notiz();
  
  //Konstruktor
  public Steuerung(){;
    
  }
  
  //Methoden
  
  //TODOSWORLD:3****************************************************************TODO
  
  public void todoEintraghinzufuegen(String text){
    todo.Eintraghinzufuegen(text);
  }
  
  public DefaultListModel todoLaden(){
    return todo.get();
  }
  
  public void todoLoeschen(int i){
    todo.loeschen(i);
  }
  
  public void todoLoescheAlles(){
    todo.loescheAlles();
  }
  
  public void allesSpeichern(){
    todo.speichern();
  }
  
  //ENDE___TODOSWORLD:3***
  
  //NotizsWORLD*****************************************************************Notiz
  
  
  //END__NotizsWORLD***
  
  //ProgrammsWORLD**************************************************************Programm
  public String programmLaden(){
    return programm.get();
  }
  //ENDE__ProgrammsWORLD****
  
  //HilfesWORLD*****************************************************************Hilfe
  public String hilfeLaden(){
    return hilfe.get();
  }
  //END__HilfesWORLD***
  
} // end of class Steuerung
