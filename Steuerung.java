import javax.swing.DefaultListModel;

public class Steuerung {
  //Referenzattribute
  private Todo todo = new Todo();
  private Programm programm = new Programm();
  private Hilfe hilfe = new Hilfe();
  public int aktiveNotiz = 1;
  private Notiz notiz1 = new Notiz("Notizeins.txt","Notiz1Button.txt");
  private Notiz notiz2 = new Notiz("Notizzwei.txt","Notiz2Button.txt");
  private Notiz notiz3 = new Notiz("Notizdrei.txt","Notiz3Button.txt");
  private Notiz notiz4 = new Notiz("Notizvier.txt","Notiz4Button.txt"); 
  
  
  //Konstruktor
  public Steuerung(){;
    
  }
  
  //Methoden
  public void allesSpeichern(){
    todo.speichern();
    notizenSpeichern();
  }
  
  public void setAktiveNotiz(int i){
    aktiveNotiz = i;
  }
  
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
  
  
  
  //ENDE___TODOSWORLD:3***
  
  //NotizsWORLD*****************************************************************Notiz
  
  public String notizLaden(int i){
    switch (i) {
      case  1: return notiz1.get();     
      case  2: return notiz2.get(); 
      case  3: return notiz3.get(); 
      case  4: return notiz4.get(); 
      default: return null; 
    } // end of switch
  }
  
  public String notizTitelLaden(int i){
    switch (i) {
      case  1: return notiz1.gettitel();     
      case  2: return notiz2.gettitel(); 
      case  3: return notiz3.gettitel(); 
      case  4: return notiz4.gettitel(); 
      default: return null; 
    } // end of switch
  }
  
  public void notizSetzen(String s){
    switch (aktiveNotiz) {
      case  1: notiz1.set(s); 
      break;    
      case  2: notiz2.set(s);
      break; 
      case  3: notiz3.set(s);
      break;
      case  4: notiz4.set(s);
      break;
      default: break;  
    } // end of switch
  }
  
  public void notizTitelSetzen(String s){
    switch (aktiveNotiz) {
      case  1: notiz1.settitel(s); 
      break;    
      case  2: notiz2.settitel(s);
      break; 
      case  3: notiz3.settitel(s);
      break;
      case  4: notiz4.settitel(s);
      break;
      default: break;  
    } // end of switch
  }
  
  public void notizLoeschen(){
    switch (aktiveNotiz) {
      case  1: notiz1.loesche(); 
      break;    
      case  2: notiz2.loesche();
      break; 
      case  3: notiz3.loesche();
      break;
      case  4: notiz4.loesche();
      break;
      default: break;  
    } // end of switch
  }
  
  public void notizenSpeichern(){
    notiz1.speichern();
    notiz2.speichern();
    notiz3.speichern();
    notiz4.speichern();
  }
  
  
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
