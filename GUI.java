import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.DefaultListModel;

public class GUI extends Frame {
  // Anfang Attribute
  private JPanel menue = new JPanel(null, true);
  private JButton logoklein = new JButton();
  private ImageIcon logokleinIcon = new ImageIcon("logok.jpg");
  private JButton startlogo = new JButton();
  private ImageIcon startlogoIcon = new ImageIcon("Startlogo.JPG");
  private JButton todobutton = new JButton();
  private JButton notizbutton = new JButton();
  private JButton programmbutton = new JButton();
  
          //Todosworld************************************
  private JTextField todoEingabefeld = new JTextField();
  private JButton todoEintraghinzufuegen = new JButton();
  private JButton todoEintragLoeschen = new JButton();
  private JButton todoEintragAlleLoeschen = new JButton(); 
  private JButton todoSpeichern = new JButton();
  private JList todoAuflistung = new JList();
  private DefaultListModel todoAuflistungModel = new DefaultListModel();
  private JScrollPane todoAuflistungScrollPane = new JScrollPane(todoAuflistung);
          //Notizensworld********************************
  private JList programmtext = new JList();
  private DefaultListModel programmtextModel = new DefaultListModel();
  private JScrollPane programmtextScrollPane = new JScrollPane(programmtext);
  
  //Referenzattribute
  private Steuerung steuerung = new Steuerung();
  private DefaultListModel lm = steuerung.todoLaden();
  
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
    
    
    
    
    menue.setBounds(0, 0, 105, 497);
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
    todobutton.setBorderPainted(true);
    todobutton.setContentAreaFilled(true);
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
    startlogo.setBounds(104, 0, 593, 497);
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
    startlogo.setContentAreaFilled(true);
    startlogo.setBackground(Color.GRAY);
    
    cp.add(startlogo);
    
    //*************************************************************************Todo*********
    todoEingabefeld.setBounds(152, 16, 385, 41);
    todoEingabefeld.setVisible(false);                                          
    cp.add(todoEingabefeld);
    
    
    
    
    
    todoEintraghinzufuegen.setBounds(536, 16, 113, 41);
    todoEintraghinzufuegen.setText("Hinzufügen");
    todoEintraghinzufuegen.setMargin(new Insets(2, 2, 2, 2));
    todoEintraghinzufuegen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        todoEintraghinzufuegen_ActionPerformed(evt);
      }
    });
    todoEintraghinzufuegen.setVisible(false);
    cp.add(todoEintraghinzufuegen);
    
    todoEintragLoeschen.setBounds(536, 304, 113, 49);
    todoEintragLoeschen.setText("Löschen");
    todoEintragLoeschen.setMargin(new Insets(2, 2, 2, 2));
    todoEintragLoeschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        todoEintragLoeschen_ActionPerformed(evt);
      }
    });
    todoEintragLoeschen.setVisible(false);
    cp.add(todoEintragLoeschen);
    
    todoEintragAlleLoeschen.setBounds(536, 376, 113, 49);
    todoEintragAlleLoeschen.setText("Alle Löschen");
    todoEintragAlleLoeschen.setMargin(new Insets(2, 2, 2, 2));
    todoEintragAlleLoeschen.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        todoEintragAlleLoeschen_ActionPerformed(evt);
      }
    });
    todoEintragAlleLoeschen.setVisible(false);
    cp.add(todoEintragAlleLoeschen);
    
    todoSpeichern.setBounds(536, 64, 113, 49);
    todoSpeichern.setText("Speichern");
    todoSpeichern.setMargin(new Insets(2, 2, 2, 2));
    todoSpeichern.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        todoSpeichern_ActionPerformed(evt);
      }
    });
    todoSpeichern.setVisible(false); 
    cp.add(todoSpeichern);
    
    todoAuflistung.setModel(todoAuflistungModel);
    todoAuflistungScrollPane.setBounds(152, 64, 385, 361);
    todoAuflistungScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    //todoAuflistungScrollPane.setVisible(false);                                  //warum geht das niicht?
    cp.add(todoAuflistungScrollPane);
    
    notizbutton.setBounds(8, 176, 89, 25);
    notizbutton.setText("Notizen");
    notizbutton.setMargin(new Insets(2, 2, 2, 2));
    notizbutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        notizbutton_ActionPerformed(evt);
      }
    });
    notizbutton.setVisible(true);
    menue.add(notizbutton);
    
    programmbutton.setBounds(8, 392, 81, 25);
    programmbutton.setText("Programm");
    programmbutton.setMargin(new Insets(2, 2, 2, 2));
    programmbutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        programmbutton_ActionPerformed(evt);
      }
    });
    programmbutton.setVisible(true);
    menue.add(programmbutton);
    
    programmtext.setModel(programmtextModel);
    programmtextScrollPane.setBounds(152, 64, 497, 161);
    programmtextScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    programmtextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    programmtextScrollPane.setVisible(false);                                   //warum geht das niicht?
    cp.add(programmtextScrollPane);
    // Ende Komponenten
    
    setVisible(true);                                  //Sichtbarkeit: aus(=false)/an(=true)
  } // end of public GUI
  
  
  
  // Anfang Methoden
  public void todobutton_ActionPerformed(ActionEvent evt) {
    //sichtbar 
    todoEingabefeld.setVisible(true);
    todoEintraghinzufuegen.setVisible(true);
    todoEintragLoeschen.setVisible(true);
    todoEintragAlleLoeschen.setVisible(true);
    todoSpeichern.setVisible(true); 
    
    todoAuflistung.setVisible(true);
    todoAuflistung.setModel(steuerung.todoLaden());
    
    //nicht sichtbar
    startlogo.setVisible(false);
    
  } // end of todobutton_ActionPerformed
  
  public void logoklein_ActionPerformed(ActionEvent evt) {
    // nicht notwenig - nur Bild!
  } // end of logoklein_ActionPerformed
  
  public void startlogo_ActionPerformed(ActionEvent evt) {
    // nicht notwenig - nur Bild!
  } // end of startlogo_ActionPerformed
  
  public void todoEintraghinzufuegen_ActionPerformed(ActionEvent evt) {
    steuerung.todoEintraghinzufuegen(todoEingabefeld.getText());
    todoEingabefeld.setText("");
  } // end of todoEintraghinzufuegen_ActionPerformed
  
  public void todoEintragLoeschen_ActionPerformed(ActionEvent evt) {    
    int pos = todoAuflistung.getSelectedIndex();    
    steuerung.todoLoeschen(pos);    
  } // end of todoEintragLoeschen_ActionPerformed
  
  public void todoEintragAlleLoeschen_ActionPerformed(ActionEvent evt) {
    steuerung.todoLoescheAlles();
  } // end of todoEintragAlleLoeschen_ActionPerformed
  
  public void todoSpeichern_ActionPerformed(ActionEvent evt) {
    steuerung.allesSpeichern();
  } // end of todoEingabefeld_ActionPerformed
  // end of todoSpeichern_ActionPerformed
  
  public void todoEingabefeld_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of todoEingabefeld_ActionPerformed
  
  public void notizbutton_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
  } // end of notizbutton_ActionPerformed

  public void programmbutton_ActionPerformed(ActionEvent evt) {
    //sichtbar
    programmtextScrollPane.setVisible(true);
    
    
    //nicht sichtbar
    startlogo.setVisible(false);
    todoEingabefeld.setVisible(false);
    todoEintraghinzufuegen.setVisible(false);
    todoEintragLoeschen.setVisible(false);
    todoEintragAlleLoeschen.setVisible(false);
    todoSpeichern.setVisible(false); 
    todoAuflistung.setVisible(false);
    
  } // end of programmbutton_ActionPerformed

  // Ende Methoden
  
  public static void main(String[] args) {
    new GUI("Kanotodo");
    
    
  } // end of main
  
} // end of class GUI
