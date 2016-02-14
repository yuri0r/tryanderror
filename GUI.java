import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.DefaultListModel;

public class GUI extends Frame {
  // Anfang Attribute
  private JPanel menue = new JPanel(null, true);
  private JButton todobutton = new JButton();
  private JButton logoklein = new JButton();
  private ImageIcon logokleinIcon = new ImageIcon("logok.jpg");
  private JButton startlogo = new JButton();
  private ImageIcon startlogoIcon = new ImageIcon("Startlogo.JPG");
  
  
  
  private JTextField todoEingabefeld = new JTextField();
  private JList todoAuflistung = new JList();
  private DefaultListModel todoAuflistungModel = new DefaultListModel();
  private JScrollPane todoAuflistungScrollPane = new JScrollPane(todoAuflistung);
  private JButton todoEintraghinzufuegen = new JButton();
  private JButton todoEintragLoeschen = new JButton();
  private JButton todoEintragAlleLoeschen = new JButton(); 
  
  lm = new DefaultListModel();
  
  //Referenzattribute
  private static Steuerung steuerung = new Steuerung();
  // Ende Attribute
  
  public GUI(String title) { 
    // Frame-Initialisierung
    super(title);
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 697; 
    int frameHeight = 518;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setResizable(false);                                      //false = MaximierButton ausblenden
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    
    cp.setBackground(new Color(0xEEEEEE));
    
    
    
    
    menue.setBounds(0, 0, 105, 489);
    menue.setOpaque(true);
    menue.setBackground(Color.GRAY);
    cp.add(menue);
    todobutton.setBounds(8, 136, 89, 25);
    todobutton.setText("Todo-Liste");
    todobutton.setMargin(new Insets(2, 2, 2, 2));
    todobutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        todobutton_ActionPerformed(evt);
      }
    });
    menue.add(todobutton);
    logoklein.setBounds(0, 16, 105, 81);
    logoklein.setText("");
    logoklein.setMargin(new Insets(2, 2, 2, 2));
    logoklein.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        logoklein_ActionPerformed(evt);
      }
    });
    logoklein.setIcon(logokleinIcon);
    logoklein.setBackground(Color.GRAY);
    
    logoklein.setBorderPainted(false);
    menue.add(logoklein);
    
    //**************************************************************************Startseite***
    startlogo.setBounds(200, 72, 377, 313);
    startlogo.setText("");
    startlogo.setMargin(new Insets(2, 2, 2, 2));
    startlogo.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        startlogo_ActionPerformed(evt);
      }
    });
    startlogo.setBorderPainted(false);
    startlogo.setIcon(startlogoIcon);
    startlogo.setVisible(true);                                //Sichtbarkeit: aus(=false)/an(=true)
    startlogo.setContentAreaFilled(false);
    cp.add(startlogo);
    
    //*************************************************************************Todo*********
    todoEingabefeld.setBounds(120, 16, 433, 41);
    todoEingabefeld.setVisible(false);
    cp.add(todoEingabefeld);
    
    todoAuflistung.setModel(todoAuflistungModel);
    todoAuflistungScrollPane.setBounds(120, 56, 545, 369);
    todoAuflistung.setVisible(false);
    todoAuflistungScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    cp.add(todoAuflistungScrollPane);
    
    
    todoEintraghinzufuegen.setBounds(552, 16, 113, 41);
    todoEintraghinzufuegen.setText("Hinzufügen");
    todoEintraghinzufuegen.setMargin(new Insets(2, 2, 2, 2));
    todoEintraghinzufuegen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        todoEintraghinzufuegen_ActionPerformed(evt);
      }
    });
    todoEintraghinzufuegen.setVisible(false);
    cp.add(todoEintraghinzufuegen);
    
    todoEintragLoeschen.setBounds(240, 432, 137, 33);
    todoEintragLoeschen.setText("Löschen");
    todoEintragLoeschen.setMargin(new Insets(2, 2, 2, 2));
    todoEintragLoeschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        todoEintragLoeschen_ActionPerformed(evt);
      }
    });
    todoEintragLoeschen.setVisible(false);
    cp.add(todoEintragLoeschen);
    
    todoEintragAlleLoeschen.setBounds(400, 432, 121, 33);
    todoEintragAlleLoeschen.setText("Alle Löschen");
    todoEintragAlleLoeschen.setMargin(new Insets(2, 2, 2, 2));
    todoEintragAlleLoeschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        todoEintragAlleLoeschen_ActionPerformed(evt);
      }
    });
    todoEintragAlleLoeschen.setVisible(false);
    cp.add(todoEintragAlleLoeschen);
    // Ende Komponenten
    
    setVisible(true);                                  //Sichtbarkeit: aus(=false)/an(=true)
  } // end of public GUI
  
  
  
  // Anfang Methoden
  public void todobutton_ActionPerformed(ActionEvent evt) {
    //sichtbar                                                      
    todoEingabefeld.setVisible(steuerung.todojetztsichtbar());
    todoEintraghinzufuegen.setVisible(steuerung.todojetztsichtbar());
    todoEintragLoeschen.setVisible(steuerung.todojetztsichtbar());
    todoEintragAlleLoeschen.setVisible(steuerung.todojetztsichtbar());
    
    //nicht sichtbar
    startlogo.setVisible(steuerung.todojetztnichtsichtbar());
    
  } // end of todobutton_ActionPerformed

  public void logoklein_ActionPerformed(ActionEvent evt) {
    // nicht notwenig - nur Bild!
  } // end of logoklein_ActionPerformed

  public void startlogo_ActionPerformed(ActionEvent evt) {
    // nicht notwenig - nur Bild!
  } // end of startlogo_ActionPerformed

  public void todoEintraghinzufuegen_ActionPerformed(ActionEvent evt) {
    steuerung.todoEintraghinzufuegen(todoEingabefeld.getText());
  } // end of todoEintraghinzufuegen_ActionPerformed

  public void todoEintragLoeschen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of todoEintragLoeschen_ActionPerformed

  public void todoEintragAlleLoeschen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of todoEintragAlleLoeschen_ActionPerformed

  // Ende Methoden
  
  public static void main(String[] args) {
    new Steuerung();
    
    lm = todo.load();
    
  } // end of main
  
} // end of class GUI
