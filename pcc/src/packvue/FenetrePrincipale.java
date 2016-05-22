package packvue;

import java.awt.Color;
import java.awt.HeadlessException;
import static java.awt.SystemColor.menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
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
        menuSaisie=new  JMenu ("Saisie") ;
        menuAffichage=new JMenu("Affichage"); 
        menu.add(menuSaisie); 
        menu.add(menuAffichage);

        //cr�ation des composants
        saisieEtudiant=new JMenuItem("SaisieXXX"); 
        saisieNotes=new JMenuItem("SaisieYYY");
        afficherLesAvions=new JMenuItem("afficher les avions");
        afficherLesHalls=new JMenuItem("afficher les halls");
        afficherLesPortes=new JMenuItem("afficher les portes");
        afficherLesParkings=new JMenuItem("afficher les parkings");
        afficherLesVols=new JMenuItem("afficher les vols");
        afficherLesVolsArrivee=new JMenuItem("afficher les vols d'arrivee");
        afficherLesVolsDepart=new JMenuItem("afficher les vols de depart");
        afficherLesSejours=new JMenuItem("afficher les sejours");
        
        //creation de la zone d'affichage
        zoneTexte=new JTextArea();
        JScrollPane texteAsc=new JScrollPane(zoneTexte);
        System.setProperty("myColor", "0X87CEFA");
        zoneTexte.setBackground(Color.getColor("myColor"));

        //Ajout des �couteur
        //saisieEtudiant.addActionListener(monEcouteur); 
        //saisieNotes.addActionListener(monEcouteur); 
        afficherLesAvions.addActionListener(monEcouteur);
        afficherLesHalls.addActionListener(monEcouteur);
        afficherLesPortes.addActionListener(monEcouteur);
        afficherLesParkings.addActionListener(monEcouteur);
        afficherLesVols.addActionListener(monEcouteur);
        afficherLesVolsArrivee.addActionListener(monEcouteur);
        afficherLesVolsDepart.addActionListener(monEcouteur);
        afficherLesSejours.addActionListener(monEcouteur);

        //Ajouts des composants
        // affectation des sous-menus
        menuSaisie.add(saisieEtudiant); 
        menuSaisie.add(saisieNotes);
        menuAffichage.add(afficherLesAvions);
        menuAffichage.add(afficherLesHalls);
        menuAffichage.add(afficherLesPortes);
        menuAffichage.add(afficherLesParkings);
        menuAffichage.add(afficherLesVols);
        menuAffichage.add(afficherLesVolsArrivee);
        menuAffichage.add(afficherLesVolsDepart);
        menuAffichage.add(afficherLesSejours);
        
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
            if(source==saisieEtudiant){
                System.out. println("saisie xxxx");
                //saisirEtudiant();
                return;
            }
            if(source==saisieNotes){ 
                System.out.println("saisie yyyy");
                //saisirNotes();
                return;
            }
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
        }
    }

    //  les attributs
    private JMenuBar menu;
    private JMenu menuSaisie,menuAffichage;
    private JMenuItem   saisieEtudiant,saisieNotes,
                        afficherLesAvions,
                        afficherLesHalls,
                        afficherLesPortes,
                        afficherLesParkings,
                        afficherLesVols,
                        afficherLesVolsArrivee,
                        afficherLesVolsDepart,
                        afficherLesSejours;

    private JTextArea zoneTexte;

    // les  méthodes
    public void afficherLesAvions(){
        String info=monControleur.toStringLesAvions();
        zoneTexte.setText(info);
    }
    
    public void afficherLesHalls(){
        String info=monControleur.toStringLesHalls();
        zoneTexte.setText(info);
    }
    
    public void afficherLesPortes(){
        String info=monControleur.toStringLesPortes();
        zoneTexte.setText(info);
    }
    
    public void afficherLesParkings(){
        String info=monControleur.toStringLesParkings();
        zoneTexte.setText(info);
    }
    
    public void afficherLesVols(){
        String info=monControleur.toStringLesVols();
        zoneTexte.setText(info);
    }
    
    public void afficherLesVolsArrivee(){
        String info=monControleur.toStringLesVolsArrivee();
        zoneTexte.setText(info);
    }

    public void afficherLesVolsDepart(){
        String info=monControleur.toStringLesVolsDepart();
        zoneTexte.setText(info);
    }
    
    public void afficherLesSejours(){
        String info=monControleur.toStringLesSejours();
        zoneTexte.setText(info);
    }
}