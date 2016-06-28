package packvue;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import static jdk.nashorn.internal.objects.NativeRegExp.source;
import packcontrole.Controleur;
import packvols.Avion;

public  class FenetrePrincipale extends JFrame {
    private  Controleur  monControleur;
    private  Ecouteur monEcouteur;
    
    public FenetrePrincipale(Controleur c) throws HeadlessException {
        monControleur=c;
        monEcouteur=new Ecouteur();
        //r�cup�ration du look and feel syst�me
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e){}
        
        // cr�ation des menus associ�s aux bandeau de la JFrame
        menu=new JMenuBar();
        this.setJMenuBar(menu);
        menuAffichage=new JMenu("Affichage"); 
        menu.add(menuAffichage);

        //création des composants
        afficherLesAvions=new JMenuItem("afficher les avions");
        afficherLesHalls=new JMenuItem("afficher les halls");
        afficherLesPortes=new JMenuItem("afficher les portes");
        afficherLesParkings=new JMenuItem("afficher les parkings");
        afficherLesVols=new JMenuItem("afficher les vols");
        afficherLesVolsArrivee=new JMenuItem("afficher les vols d'arrivee");
        afficherLesVolsDepart=new JMenuItem("afficher les vols de depart");
        afficherLesSejours=new JMenuItem("afficher les sejours");
        afficherEcranLesVols=new JMenuItem("afficher Ecran Passagers tous les vols");
        afficherEcranVolsArrivee=new JMenuItem("afficher Ecran Passagers les vols d'arrivee");
        afficherEcranVolsDepart=new JMenuItem("afficher Ecran Passagers les vols de depart");
        afficherEcranHall=new JMenuItem("afficher Ecran Hall");

        //creation de la zone d'affichage
        zoneTexte=new JTextArea();
        JScrollPane texteAsc=new JScrollPane(zoneTexte);
        // pour affichage image de fond
        zoneTexte.setBackground(Color.blue);
        zoneTexte.setForeground(Color.WHITE);
        
        //Ajout des �couteur
        afficherLesAvions.addActionListener(monEcouteur);
        afficherLesHalls.addActionListener(monEcouteur);
        afficherLesPortes.addActionListener(monEcouteur);
        afficherLesParkings.addActionListener(monEcouteur);
        afficherLesVols.addActionListener(monEcouteur);
        afficherLesVolsArrivee.addActionListener(monEcouteur);
        afficherLesVolsDepart.addActionListener(monEcouteur);
        afficherLesSejours.addActionListener(monEcouteur);
        afficherEcranLesVols.addActionListener(monEcouteur);
        afficherEcranVolsArrivee.addActionListener(monEcouteur);
        afficherEcranVolsDepart.addActionListener(monEcouteur);
        afficherEcranHall.addActionListener(monEcouteur);
        
        //Ajouts des composants
        // affectation des sous-menus
        menuAffichage.add(afficherLesAvions);
        menuAffichage.add(afficherLesHalls);
        menuAffichage.add(afficherLesPortes);
        menuAffichage.add(afficherLesParkings);
        menuAffichage.add(afficherLesVols);
        menuAffichage.add(afficherLesVolsArrivee);
        menuAffichage.add(afficherLesVolsDepart);
        menuAffichage.add(afficherLesSejours);
        menuAffichage.add(afficherEcranLesVols);
        menuAffichage.add(afficherEcranVolsArrivee);
        menuAffichage.add(afficherEcranVolsDepart);
        menuAffichage.add(afficherEcranHall);
        
        // Affichage Titre sur bandeau supérieur de la fenetre 
        this.add(texteAsc);
        // position/taille fenetre: x,y,larheur,hauteur
        setBounds(5,5,750,750);
        setVisible(true);
        this.setTitle("Aeroport ORLY W") ;
 
        //arr�t de l'ex�cution sur fermeture de la fen�tre
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private class Ecouteur implements ActionListener{
        public void actionPerformed(ActionEvent ev){
            Object source=ev.getSource();
            if(source==afficherLesAvions) { 
                System.out.println("afficher les Avions");
                afficherLesAvions();
                return;
            }
            if(source==afficherLesHalls) { 
                System.out.println("afficher les Halls");
                afficherLesHalls();
                return;
            }
            if(source==afficherLesPortes) { 
                System.out.println("afficher les Portes");
                afficherLesPortes();
                return;
            }
            if(source==afficherLesParkings) { 
                System.out.println("afficher les Parkings");
                afficherLesParkings();
                return;
            }
            if(source==afficherLesVols) { 
                System.out.println("afficher les Vols");
                afficherLesVols();
                return;
            }
            if(source==afficherLesVolsArrivee) { 
                System.out.println("afficher les Vols d'arrivee");
                afficherLesVolsArrivee();
                return;
            }
            if(source==afficherLesVolsDepart) { 
                System.out.println("afficher les Vols de depart");
                afficherLesVolsDepart();
                return;
            }
            if(source==afficherLesSejours) { 
                System.out.println("afficher les sejours");
                afficherLesSejours();
                return;
            }
            if(source==afficherEcranLesVols) { 
                System.out.println("afficher Ecran les vols");
                afficherEcranLesVols();
                return;
            }
            if(source==afficherEcranVolsArrivee) { 
                System.out.println("afficher Ecran les vols d'arrivee");
                afficherEcranVolsArrivee();
                return;
            }
            if(source==afficherEcranVolsDepart) { 
                System.out.println("afficher Ecran les vols de départ");
                afficherEcranVolsDepart();
                return;
            }
            if(source==afficherEcranHall) { 
                System.out.println("afficher Ecran Hall");
                afficherEcranHall();
                return;
            }
        }
    }

    //  les attributs
    private JMenuBar menu;
    private JMenu menuAffichage;  
    private JMenuItem   afficherLesAvions,
                        afficherLesHalls,
                        afficherLesPortes,
                        afficherLesParkings,
                        afficherLesVols,
                        afficherLesVolsArrivee,
                        afficherLesVolsDepart,
                        afficherLesSejours,
                        afficherEcranLesVols,
                        afficherEcranVolsArrivee,
                        afficherEcranVolsDepart,
                        afficherEcranHall;
                        
    private JTextArea zoneTexte;

    // les  méthodes
    public void afficherLesAvions(){
        String info=monControleur.toStringLesAvions();
        zoneTexte.setText(info);
        zoneTexte.setCaretPosition(0);
    }
    
    public void afficherLesHalls(){
        String info=monControleur.toStringLesHalls();
        zoneTexte.setText(info);
        zoneTexte.setCaretPosition(0);
    }
    
    public void afficherLesPortes(){
        String info=monControleur.toStringLesPortes();
        zoneTexte.setText(info);
        zoneTexte.setCaretPosition(0);
    }
    
    public void afficherLesParkings(){
        String info=monControleur.toStringLesParkings();
        zoneTexte.setText(info);
        zoneTexte.setCaretPosition(0);
    }
    
    public void afficherLesVols(){
        String info=monControleur.toStringLesVols();
        zoneTexte.setText(info);
        zoneTexte.setCaretPosition(0);
    }
    
    public void afficherLesVolsArrivee(){
        String info=monControleur.toStringLesVolsArrivee();
        zoneTexte.setText(info);
        zoneTexte.setCaretPosition(0);
    }

    public void afficherLesVolsDepart(){
        String info=monControleur.toStringLesVolsDepart();
        zoneTexte.setText(info);
        zoneTexte.setCaretPosition(0);
    }
    
    public void afficherLesSejours(){
        String info=monControleur.toStringLesSejours();
        zoneTexte.setText(info);
        zoneTexte.setCaretPosition(0);
    }
    
    public void afficherEcranLesVols(){
        String info=monControleur.toStringEcranLesVols();
        zoneTexte.setText(info);
        //positionner l'ascenceur en position haute
        zoneTexte.setCaretPosition(0);
    }
    public void afficherEcranVolsArrivee(){
        String info=monControleur.toStringEcranVolsArrivee();
        zoneTexte.setText(info);
        //positionner l'ascenceur en position haute
        zoneTexte.setCaretPosition(0);
    }
    public void afficherEcranVolsDepart(){
        String info=monControleur.toStringEcranVolsDepart();
        zoneTexte.setText(info);
        //positionner l'ascenceur en position haute 
        zoneTexte.setCaretPosition(0);
    }
    public void afficherEcranHall(){
        
        String numHall=JOptionPane.showInputDialog(this,  "No Hall?",
                "Saisie No Hall");
        if(numHall!=null){
            String info=monControleur.getNumHallString(numHall);
            if (info!=null){
                // recup caractéristique de OptionPanel pour les restituer après
                Object optionPaneBG = UIManager.get("OptionPane.background");
                Object panelBG = UIManager.get("Panel.background");
                Object msgFor = UIManager.get("OptionPane.messageForeground");
                UIManager UI=new UIManager();   
                // Modif couleur de fond et couleur du texte
                UI.put("OptionPane.background", Color.BLUE);
                UI.put("Panel.background", Color.BLUE);
                UI.put("OptionPane.messageForeground", Color.WHITE);
                // Modif Police pour que l'affichage ne soit pas décalé
                Font f1 = new Font("Monospaced",Font.BOLD,12);
                UI.put("OptionPane.messageFont",f1);
                
                // affichage boite d'affichage
                
                JOptionPane.showMessageDialog(this, info,"Ecran Hall no "+numHall ,JOptionPane.PLAIN_MESSAGE);
                // Restitution des caractéristiques
                UI.put("OptionPane.background", optionPaneBG);
                UI.put("Panel.background", panelBG);
                UI.put("OptionPane.messageForeground",msgFor);
            }
            else
                JOptionPane.showMessageDialog(this,"Hall: "+  numHall+
                    " inexistant!!!") ;
        }
    }
}