import javax.swing.DefaultListModel;
public class Steuerung {
  //Referenzattribute
  //private static GUI gui = new GUI("Kanotodo");               //static = Verbindung nur einmalig in eine Richtung 
  //private Kalender kalender = new Kalender();
  private Todo todo = new Todo();
  
  //Konstruktor
  public Steuerung(){;
    
  }
  
  //Methoden
  
  //TODOSWORLD:3******************************************************
  
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
  
  //ENDE___TODOSWORLD:3******************************************************
  public void allesSpeichern(){
    todo.speichern();
  }
} // end of class Steuerung
