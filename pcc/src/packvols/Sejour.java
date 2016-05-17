package packvols;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import packhoraires.TrancheHoraire;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import packaeroport.*;
import packhoraires.Horaire;

public class Sejour {

    private TrancheHoraire dureeSejour; 
    //private int margeMinutes;
    private Parking parking;
    //private String immatriculation;
    private Avion avion;
    private Vol volArrivee;
    private Vol volDepart;
    
    private static Hashtable <String, Sejour> lesSejours = new Hashtable<String, Sejour>();
    
    public Sejour(TrancheHoraire t, Vol va, Vol vd, Parking p, Avion a, String num_volArrivee){
        dureeSejour = t;
        parking = p;
        avion = a; 
        volArrivee = va;
        volDepart = vd;
        lesSejours.put(num_volArrivee, this);
    }
    
    public String toString(){
        String info = "test";
        return info;
    }
    
    public static void creerLesSejours(){
        String File = "ProgrammeVolsFA-16-v1.txt";
        Avion avion_find = null;
         try {
            // Lecture du fichier
            BufferedReader vol = new BufferedReader (new FileReader (File));
            String ligne = null;
            while((ligne= vol.readLine()) != null){
                 
               
                        StringTokenizer tokenVolArrivee = new StringTokenizer (ligne);
                        String num_volArrivee = tokenVolArrivee.nextToken();
                        String h_arivee = tokenVolArrivee.nextToken();
                        String m_arivee = tokenVolArrivee.nextToken();
                        String provenance = tokenVolArrivee.nextToken();
                        String immatArrivee = tokenVolArrivee.nextToken();
                        
                       int hor_arrivee = Integer.parseInt(h_arivee);
                       int min_arrivee = Integer.parseInt(m_arivee);
                       //Horaire h = new Horaire(hor_arrivee, min_arrivee);
                        //avion_find = Avion.getAvion(immatArrivee);
                        
                        //récupération du vol d'arrivée
                        Vol vol_arrivee = Vol.getVol(num_volArrivee);
                        //récupération de l'horraire arrivée
                        Horaire ha = vol_arrivee.getHoraire();
                        
                        StringTokenizer tokenVolDepart = new StringTokenizer (ligne);
                        String num_volDepart = tokenVolDepart.nextToken();
                        String h_depart = tokenVolDepart.nextToken();
                        String m_depart = tokenVolDepart.nextToken();
                        String destination = tokenVolDepart.nextToken();
                        String immatDepart = tokenVolDepart.nextToken();
                        
                        int hor_depart = Integer.parseInt(h_depart);
                        int min_depart = Integer.parseInt(m_depart);
                        Horaire h = new Horaire(hor_depart, min_depart);
                        avion_find = Avion.getAvion(immatDepart);
                        
                        //récupération du vol d'arrivée
                        Vol vol_depart = Vol.getVol(num_volDepart);
                        //récupération de l'horaire de départ
                        Horaire hd = vol_depart.getHoraire();
                        
                        //création de la tranche horaire
                        TrancheHoraire tranche = new TrancheHoraire(ha, hd);
                        
                        //création d'un parking de test avant affectation
                        Parking test = new ParkingContact("test", "test");
                        
                        Sejour s = new Sejour(tranche, vol_arrivee, vol_depart, test, avion_find, num_volArrivee );
                        
            }
         }
         
         catch (IOException e){
            System.out.println("fichier non trouvé: "+File+"\n");
            }
    }
    
    public static void afficherLesSejpours(){
        
        // Affichage de la hastable lesPortes
        String info = "Affichage Hashtable lesSéjours";
        
        
        ArrayList<Sejour> sejours = new ArrayList<Sejour>(lesSejours.values());
        
        Iterator<Sejour> it = sejours.iterator(); 
        while(it.hasNext()){
           Sejour s = it.next();
           info += " test \n";
        
    }
        System.out.println(info);
    }
    
    
    
    }
