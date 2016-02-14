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
  private JButton kalenderbutton = new JButton();
  private JButton programmbutton = new JButton();
  private JButton hilfebutton = new JButton();
  
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
  private JTextArea notiztextfeld = new JTextArea("");
  private JScrollPane notiztextfeldScrollPane = new JScrollPane(notiztextfeld);
  private JTextField notiztitelfeld = new JTextField();
  private JButton notiztitelhinzufuegenbutton = new JButton();
  private JButton notizspeichernbutton = new JButton();
  private JButton notizeinsbutton = new JButton();
  private JButton notizzweibutton = new JButton();
  private JButton notizdreibutton = new JButton();
  private JButton notizvierbutton = new JButton();
  private JButton notizloeschenbutton = new JButton();  
           //Kalendersworld******************************                                   //Kalenderattribute hier!!!!!!!!!!!!!!!!!!!!!
        
        
          //Programmsworld*******************************
  private JTextArea programmtext = new JTextArea("");
  private JScrollPane programmtextScrollPane = new JScrollPane(programmtext);
  private JLabel programmueberschrift = new JLabel();        
          //Hilfesworld**********************************
  private JTextArea hilfetext = new JTextArea("");
  private JScrollPane hilfetextScrollPane = new JScrollPane(hilfetext);
  private JLabel hilfeueberschrift = new JLabel();
          
  
  
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
    int frameWidth = 713; 
    int frameHeight = 526;
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
    
    
    //Menueleiste***************************************************************Menü
    menue.setBounds(0, 0, 105, 497);
    menue.setOpaque(true);
    menue.setBackground(Color.GRAY);
    cp.add(menue);
    
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
    
    //Buttons***********
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
    
    kalenderbutton.setBounds(8, 216, 89, 25);
    kalenderbutton.setText("Kalender");
    kalenderbutton.setMargin(new Insets(2, 2, 2, 2));
    kalenderbutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        kalenderbutton_ActionPerformed(evt);
      }
    });
    kalenderbutton.setVisible(true);
    menue.add(kalenderbutton);
    
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
    
    hilfebutton.setBounds(8, 432, 81, 25);
    hilfebutton.setText("Hilfe");
    hilfebutton.setMargin(new Insets(2, 2, 2, 2));
    hilfebutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        hilfebutton_ActionPerformed(evt);
      }
    });
    hilfebutton.setVisible(true);
    menue.add(hilfebutton);
    
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
    
    //**************************************************************************Todo
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
    todoAuflistungScrollPane.setVisible(false);                                  //?
    cp.add(todoAuflistungScrollPane);
    
    //**************************************************************************Notizen
    notiztextfeldScrollPane.setBounds(152, 56, 417, 409);
    notiztextfeldScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
    notiztextfeldScrollPane.setVisible(false);
    notiztextfeld.setText("wähle eine Notiz!");
    cp.add(notiztextfeldScrollPane);
    
    notiztitelfeld.setBounds(152, 8, 417, 33);
    notiztitelfeld.setVisible(false); 
    cp.add(notiztitelfeld);
    
    notiztitelhinzufuegenbutton.setBounds(576, 8, 89, 33);
    notiztitelhinzufuegenbutton.setText("Titel setzten");
    notiztitelhinzufuegenbutton.setMargin(new Insets(2, 2, 2, 2));
    notiztitelhinzufuegenbutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        notiztitelhinzufuegenbutton_ActionPerformed(evt);
      }
    });
    notiztitelhinzufuegenbutton.setVisible(false); 
    cp.add(notiztitelhinzufuegenbutton);
    
    notizspeichernbutton.setBounds(576, 56, 89, 33);
    notizspeichernbutton.setText("Speichern");
    notizspeichernbutton.setMargin(new Insets(2, 2, 2, 2));
    notizspeichernbutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        notizspeichernbutton_ActionPerformed(evt);
      }
    });
    notizspeichernbutton.setVisible(false);
    cp.add(notizspeichernbutton);
    
    notizeinsbutton.setBounds(576, 120, 89, 33);
    notizeinsbutton.setText("Notiz eins");
    notizeinsbutton.setMargin(new Insets(2, 2, 2, 2));
    notizeinsbutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        notizeinsbutton_ActionPerformed(evt);
      }
    });
    notizeinsbutton.setVisible(false);
    cp.add(notizeinsbutton);
    
    notizzweibutton.setBounds(576, 160, 89, 33);
    notizzweibutton.setText("Notiz zwei");
    notizzweibutton.setMargin(new Insets(2, 2, 2, 2));
    notizzweibutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        notizzweibutton_ActionPerformed(evt);
      }
    });
    notizzweibutton.setVisible(false); 
    cp.add(notizzweibutton);
    
    notizdreibutton.setBounds(576, 200, 89, 33);
    notizdreibutton.setText("Notiz drei");
    notizdreibutton.setMargin(new Insets(2, 2, 2, 2));
    notizdreibutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        notizdreibutton_ActionPerformed(evt);
      }
    });
    notizdreibutton.setVisible(false); 
    cp.add(notizdreibutton);
    
    notizvierbutton.setBounds(576, 240, 89, 33);
    notizvierbutton.setText("Notiz vier");
    notizvierbutton.setMargin(new Insets(2, 2, 2, 2));
    notizvierbutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        notizvierbutton_ActionPerformed(evt);
      }
    });
    notizvierbutton.setVisible(false); 
    cp.add(notizvierbutton);
    
    notizloeschenbutton.setBounds(576, 432, 89, 33);
    notizloeschenbutton.setText("Löschen");
    notizloeschenbutton.setMargin(new Insets(2, 2, 2, 2));
    notizloeschenbutton.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        notizloeschenbutton_ActionPerformed(evt);
      }
    });
    notizloeschenbutton.setVisible(false); 
    cp.add(notizloeschenbutton);
    refresh();
    
    //**************************************************************************Kalender                 //hier Kalenderkomponenten!!!!!!!!!!!!!
    
    
    
    
    
    
    
    //**************************************************************************Programm
    programmtextScrollPane.setBounds(152, 64, 497, 249);
    programmtextScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    programmtextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
    programmtextScrollPane.setVisible(false);
    programmtext.setEditable(false);
    programmtext.setText("");
    programmtext.setWrapStyleWord(true);
    cp.add(programmtextScrollPane);
    
    programmueberschrift.setBounds(208, 8, 330, 49);
    programmueberschrift.setText("Über das Programm");
    programmueberschrift.setBackground(new Color(0xEEEEEE));
    programmueberschrift.setOpaque(true);
    programmueberschrift.setHorizontalAlignment(SwingConstants.CENTER);
    programmueberschrift.setFont(new Font("Arial", Font.PLAIN, 28));
    programmueberschrift.setVisible(false);
    cp.add(programmueberschrift);
    
    //**************************************************************************Hilfe
    hilfetextScrollPane.setBounds(152, 56, 497, 369);
    hilfetextScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    hilfetextScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    hilfetextScrollPane.setVisible(false);
    hilfetext.setEditable(false);
    cp.add(hilfetextScrollPane);
    
    hilfeueberschrift.setBounds(320, 8, 163, 45);
    hilfeueberschrift.setText("Hilfe");
    hilfeueberschrift.setBackground(new Color(0xEEEEEE));
    hilfeueberschrift.setOpaque(true);
    hilfeueberschrift.setHorizontalAlignment(SwingConstants.CENTER);
    hilfeueberschrift.setVisible(false);
    hilfeueberschrift.setFont(new Font("Arial", Font.PLAIN, 28));
    cp.add(hilfeueberschrift);
    
    
    // Ende Komponenten
    
    setVisible(true);                      //Sichtbarkeit: aus(=false)/an(=true)
  } // end of public GUI
  
  
  
  // Anfang Methoden***************************************************************************************Methoden
  public void logoklein_ActionPerformed(ActionEvent evt) {                                                 //Kalender später sichtbarkeit ergänzen!!!!!!
    // nicht notwenig - nur Bild!
  } 
  
  public void startlogo_ActionPerformed(ActionEvent evt) {
    // nicht notwenig - nur Bild!
  } 
  
  
  //TODO************************************************************************TODO
  public void todobutton_ActionPerformed(ActionEvent evt) {
    //sichtbar 
    todoEingabefeld.setVisible(true);
    todoEintraghinzufuegen.setVisible(true);
    todoEintragLoeschen.setVisible(true);
    todoEintragAlleLoeschen.setVisible(true);
    todoSpeichern.setVisible(true); 
    todoAuflistungScrollPane.setVisible(true); 
    todoAuflistung.setModel(steuerung.todoLaden());
    
    //nicht sichtbar
    startlogo.setVisible(false);
    programmtextScrollPane.setVisible(false); 
    programmueberschrift.setVisible(false);
    hilfetextScrollPane.setVisible(false);
    hilfeueberschrift.setVisible(false);
    notiztitelfeld.setVisible(false); 
    notiztitelhinzufuegenbutton.setVisible(false); 
    notizspeichernbutton.setVisible(false); 
    notizeinsbutton.setVisible(false); 
    notizzweibutton.setVisible(false); 
    notizdreibutton.setVisible(false);
    notizvierbutton.setVisible(false); 
    notizloeschenbutton.setVisible(false); 
    notiztextfeldScrollPane.setVisible(false);
  } 
  
  public void todoEintraghinzufuegen_ActionPerformed(ActionEvent evt) {
    steuerung.todoEintraghinzufuegen(todoEingabefeld.getText());
    todoEingabefeld.setText("");
  } 
  
  public void todoEintragLoeschen_ActionPerformed(ActionEvent evt) {    
    int pos = todoAuflistung.getSelectedIndex();    
    steuerung.todoLoeschen(pos);    
  } 
  
  public void todoEintragAlleLoeschen_ActionPerformed(ActionEvent evt) {
    steuerung.todoLoescheAlles();
  } 
  
  public void todoSpeichern_ActionPerformed(ActionEvent evt) {
    steuerung.allesSpeichern();
  } 
  
  
  public void todoEingabefeld_ActionPerformed(ActionEvent evt) {
    
  } 
  
  
  //Notiz***********************************************************************Notiz
  public void notizbutton_ActionPerformed(ActionEvent evt) {
    //sichtbar
    notiztitelfeld.setVisible(true); 
    notiztitelhinzufuegenbutton.setVisible(true); 
    notizspeichernbutton.setVisible(true); 
    notizeinsbutton.setVisible(true); 
    notizzweibutton.setVisible(true); 
    notizdreibutton.setVisible(true);
    notizvierbutton.setVisible(true); 
    notizloeschenbutton.setVisible(true);
    notiztextfeldScrollPane.setVisible(true);
    
    //nicht sichtbar
    startlogo.setVisible(false); 
    programmtextScrollPane.setVisible(false);
    programmueberschrift.setVisible(false);
    todoEingabefeld.setVisible(false);
    todoEintraghinzufuegen.setVisible(false);
    todoEintragLoeschen.setVisible(false);
    todoEintragAlleLoeschen.setVisible(false);
    todoSpeichern.setVisible(false); 
    todoAuflistungScrollPane.setVisible(false); 
    hilfetextScrollPane.setVisible(false);
    hilfeueberschrift.setVisible(false);
  } 
  
  public void notiztitelhinzufuegenbutton_ActionPerformed(ActionEvent evt) {
    steuerung.notizTitelSetzen(notiztitelfeld.getText());
    refresh();                                               
  } 
  
  public void notizspeichernbutton_ActionPerformed(ActionEvent evt) {
    steuerung.notizSetzen(notiztextfeld.getText());
  } 
  
  public void notizeinsbutton_ActionPerformed(ActionEvent evt) {
    steuerung.setAktiveNotiz(1);
    notiztextfeld.setText(steuerung.notizLaden(1));
    notiztitelfeld.setText(steuerung.notizTitelLaden(1));
  } 
  
  public void notizzweibutton_ActionPerformed(ActionEvent evt) {
    steuerung.setAktiveNotiz(2);
    notiztextfeld.setText(steuerung.notizLaden(2));
    notiztitelfeld.setText(steuerung.notizTitelLaden(2));
  } 
  
  public void notizdreibutton_ActionPerformed(ActionEvent evt) {
    steuerung.setAktiveNotiz(3);
    notiztextfeld.setText(steuerung.notizLaden(3));
    notiztitelfeld.setText(steuerung.notizTitelLaden(3));
  } 
  
  public void notizvierbutton_ActionPerformed(ActionEvent evt) {
    steuerung.setAktiveNotiz(4);
    notiztextfeld.setText(steuerung.notizLaden(4));
    notiztitelfeld.setText(steuerung.notizTitelLaden(4));
  } 
  
  public void notizloeschenbutton_ActionPerformed(ActionEvent evt) {
    steuerung.notizLoeschen();
    notiztextfeld.setText("");
    notiztitelfeld.setText("");
    refresh();
  } 
  
  public void refresh(){
    notizeinsbutton.setText(steuerung.notizTitelLaden(1));
    notizzweibutton.setText(steuerung.notizTitelLaden(2));
    notizdreibutton.setText(steuerung.notizTitelLaden(3));
    notizvierbutton.setText(steuerung.notizTitelLaden(4));
  }
  
  //Programm********************************************************************Kalender                    //Kalendermethoden hier!!!!!!!!!!
  public void kalenderbutton_ActionPerformed(ActionEvent evt) {
    //sichtbar
    
    
    
    
    //nicht sichtbar
    startlogo.setVisible(false);
    todoEingabefeld.setVisible(false);
    todoEintraghinzufuegen.setVisible(false);
    todoEintragLoeschen.setVisible(false);
    todoEintragAlleLoeschen.setVisible(false);
    todoSpeichern.setVisible(false); 
    todoAuflistungScrollPane.setVisible(false); 
    notiztitelfeld.setVisible(false); 
    notiztitelhinzufuegenbutton.setVisible(false); 
    notizspeichernbutton.setVisible(false); 
    notizeinsbutton.setVisible(false); 
    notizzweibutton.setVisible(false); 
    notizdreibutton.setVisible(false);
    notizvierbutton.setVisible(false); 
    notizloeschenbutton.setVisible(false);
    notiztextfeldScrollPane.setVisible(false);
    programmtextScrollPane.setVisible(false);
    programmueberschrift.setVisible(false);
    hilfetextScrollPane.setVisible(false);
    hilfeueberschrift.setVisible(false);
  } // end of kalenderbutton_ActionPerformed
  
  
  
  
  
  //Programm********************************************************************Programm
  public void programmbutton_ActionPerformed(ActionEvent evt) {
    //sichtbar
    programmtextScrollPane.setVisible(true);
    programmtext.setText(steuerung.programmLaden());
    programmueberschrift.setVisible(true);
    
    //nicht sichtbar  
    startlogo.setVisible(false);
    todoEingabefeld.setVisible(false);
    todoEintraghinzufuegen.setVisible(false);
    todoEintragLoeschen.setVisible(false);
    todoEintragAlleLoeschen.setVisible(false);
    todoSpeichern.setVisible(false); 
    todoAuflistungScrollPane.setVisible(false);
    hilfetextScrollPane.setVisible(false); 
    hilfeueberschrift.setVisible(false);
    notiztitelfeld.setVisible(false); 
    notiztitelhinzufuegenbutton.setVisible(false); 
    notizspeichernbutton.setVisible(false); 
    notizeinsbutton.setVisible(false); 
    notizzweibutton.setVisible(false); 
    notizdreibutton.setVisible(false);
    notizvierbutton.setVisible(false); 
    notizloeschenbutton.setVisible(false);
    notiztextfeldScrollPane.setVisible(false);
  } 
  
  //Hilfe***********************************************************************Hilfe
  public void hilfebutton_ActionPerformed(ActionEvent evt) {
    //sichtbar
    hilfetextScrollPane.setVisible(true);
    hilfetext.setText(steuerung.hilfeLaden());
    hilfeueberschrift.setVisible(true);
    
    //nicht sichtbar
    startlogo.setVisible(false);
    todoEingabefeld.setVisible(false);
    todoEintraghinzufuegen.setVisible(false);
    todoEintragLoeschen.setVisible(false);
    todoEintragAlleLoeschen.setVisible(false);
    todoSpeichern.setVisible(false); 
    todoAuflistungScrollPane.setVisible(false);
    programmtextScrollPane.setVisible(false);
    programmueberschrift.setVisible(false);
    notiztitelfeld.setVisible(false); 
    notiztitelhinzufuegenbutton.setVisible(false); 
    notizspeichernbutton.setVisible(false); 
    notizeinsbutton.setVisible(false); 
    notizzweibutton.setVisible(false); 
    notizdreibutton.setVisible(false);
    notizvierbutton.setVisible(false); 
    notizloeschenbutton.setVisible(false);
    notiztextfeldScrollPane.setVisible(false);
  } 
  
  // Ende Methoden
  
  public static void main(String[] args) {
    new GUI("Kanotodo");
  } // end of main
  
} // end of class GUI