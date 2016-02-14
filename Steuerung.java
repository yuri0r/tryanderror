
public class Steuerung {
  //Referenzattribute
  private static GUI gui = new GUI("Kanotodo");               //static = Verbindung nur einmalig in eine Richtung 
  //private Kalender kalender = new Kalender();
  private Todo todo = new Todo();
  
  //Konstruktor
  public Steuerung(){;
    
  }
  
  //Methoden
  public boolean todojetztsichtbar() {
    return todo.todojetztsichtbar();
  } 
  public boolean todojetztnichtsichtbar() {
    return todo.todojetztnichtsichtbar();
  } 
  
  public int todoEintraghinzufuegen(){
    return todo.todoEintraghinzufuegen();
    }
} // end of class Steuerung
