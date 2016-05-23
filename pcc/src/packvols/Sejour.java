package packvols;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import packhoraires.TrancheHoraire;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import packaeroport.*;
import packhoraires.Horaire;

public class Sejour implements Comparable<Sejour> {
    private TrancheHoraire dureeSejour; 
    //private int margeMinutes;
    private Parking parking;
    private String num_volArrivee;
    private Avion avion;
    private Vol volArrivee;
    private Vol volDepart;
    
    private static Hashtable <String, Sejour> lesSejours = new Hashtable<String, Sejour>();
    
    public Sejour(TrancheHoraire t, Vol va, Vol vd, Parking p, Avion a, String num_va){
        num_volArrivee = num_va;
        dureeSejour = t;
        parking = p;
        avion = a; 
        volArrivee = va;
        volDepart = vd;
        lesSejours.put(num_volArrivee, this);
    }
    
    public int compareTo(Sejour v) {
        return this.dureeSejour.getDebutTrancheHoraire().compareTo(v.dureeSejour.getDebutTrancheHoraire());
    }
    
    public String toString(){

        //String info = "\n Séjour du vol: "+ num_volArrivee + "\n";
        //info += volArrivee.toString()+"\n";
        //info += volDepart.toString()+"\n";
        String info = "\n Séjour du vol: "+ num_volArrivee+ " Durée du séjour:" + dureeSejour;
        info += volArrivee.toString();
        info += volDepart.toString();
        if (parking != null)
             info += parking.toString();
        else  
            info += " Hall : N/A";
      
        return info;
    }
    
    public void afficher(){
        System.out.println(this.toString());
    }
    
    public static Hashtable <String, Sejour> getLesSejours(){
        return lesSejours;
    }
        
    public static Sejour getSejour(String s) throws SejourInvalide{
        // récupération d'un sejour dans la HashTable des sejours
        if (!lesSejours.containsKey(s))
            throw new SejourInvalide(s);
        else
            return (Sejour)lesSejours.get(s);
    }
        
    public static void creerLesSejours(){
        String file = "ProgrammeVolsFA-16-v1.txt";
        try {
            // Lecture du fichier
            BufferedReader vol = new BufferedReader (new FileReader (file));
            String ligne = null;
            // Les no de vol sur 1 journée sont unique, il suffit de recupérer le 
            // no de vol et recupérer les objets correspondant dans les classes
            // volArrivee et volDepart
            while((ligne= vol.readLine()) != null){     
                StringTokenizer tokenVolArrivee = new StringTokenizer (ligne);
                String num_volArrivee = tokenVolArrivee.nextToken();                        
                try {    
                    //récupération du vol d'arrivée
                    Vol vol_arrivee = Vol.getVol(num_volArrivee);
                    //récupération de l'horaire arrivée
                    Horaire ha = vol_arrivee.getHoraire();
                    //Recuperation de l'Avion
                    Avion avion_find = vol_arrivee.getAvion();
                    
                    //Lecture de la ligne depart dans le fichier
                    ligne=vol.readLine();
                    StringTokenizer tokenVolDepart = new StringTokenizer (ligne);
                    String num_volDepart = tokenVolDepart.nextToken();                        
                    //récupération du vol de depart
                    try {
                        Vol vol_depart = Vol.getVol(num_volDepart);
                        //récupération de l'horaire de départ
                        Horaire hd = vol_depart.getHoraire();

                        //création de la tranche horaire
                        TrancheHoraire tranche = new TrancheHoraire(ha, hd);
                        
                        
                            // Recuperation d'un parking pour test
                            Parking objet_parking = null;
                            ParkingContact objPC = (ParkingContact)objet_parking;                                               
                            
                            // Creation du sejour
                            Sejour s = new Sejour(tranche, vol_arrivee, vol_depart, objPC, avion_find, num_volArrivee );
                           
                    } catch (    VolInvalide e){ //fin try Vol.getVol(num_volDepart);
                        System.out.println(e.toString());
                    }  
                    } catch (VolInvalide e){ //fin try Vol.getVol(num_volArrivee);
                            System.out.println(e.toString());
                }                 
            }               
        } catch (FileNotFoundException e){
            System.out.println("fichier non trouvé: "+file+"\n");
        }
        catch (IOException e){
            System.out.println("Erreur de lecture fichier: "+file+"\n");
        }
    }
    
    public static void afficherLesSejours(){
        System.out.println(toStringLesSejours());
    }    
    
    public static String toStringLesSejours(){
        // Affichage de la hastable lesSejours
        String info = "Liste des séjours";
        ArrayList<Sejour> sejours = new ArrayList<Sejour>(lesSejours.values());
        Collections.sort(sejours);
        Iterator<Sejour> it = sejours.iterator(); 
        while(it.hasNext()){
           Sejour s = it.next();
           info +=s.toString()+"\n";   
        }
        return(info);
    }
        
    public static void associerSejoursParkings(){
                //On ouvre la liste des parkings
                Hashtable <String, Parking> lesParkings = Parking.getLesParkings();
                Iterator<Parking> itp = lesParkings.values().iterator();
                 
                //Tant qu'il y a un parking dans la liste
                while(itp.hasNext()){
                    Parking p = itp.next();//on prend un parking
                    //on creer une Hashtable à ce parking qui contiendra la liste des séjours(TrancheHoraire)
                    Hashtable <String, TrancheHoraire> lesSejoursAffectes = new Hashtable <String, TrancheHoraire>() ;
                    
                    // on ouvre la liste des séjours
                    ArrayList<Sejour> sejours = new ArrayList<Sejour>(lesSejours.values());
                    Collections.sort(sejours);
                    Iterator<Sejour> it = sejours.iterator();
                    //tant qu'il y a un sejour
                    while(it.hasNext()){
                        Sejour s = it.next();
                        if(s.parking == null){
                            Boolean dispo = true;
                            //cherche d'autres séjours avec tranche horaire non chevauchante
                            
                            if(lesSejoursAffectes==null) {
                                lesSejoursAffectes.put(s.volArrivee.getNum_vol(), s.getTrancheHoraire());
                                s.affecterParking(p);
                                }
                            else {
                                ArrayList<TrancheHoraire> lesTranches = new ArrayList<TrancheHoraire>(lesSejoursAffectes.values());
                                Iterator<TrancheHoraire> tranche = lesTranches.iterator(); 
                                while(tranche.hasNext()){
                                    TrancheHoraire t = tranche.next();
                            
                                    if(s.dureeSejour.contient(t.getDebutTrancheHoraire()) || s.dureeSejour.contient(t.getFinTrancheHoraire()) || t.contient(s.dureeSejour) || s.dureeSejour.contient(t)){
                                        dispo = false;
                                        //System.out.println("faux");
                                        } //else System.out.println("vrai");
                            
                                    }//fin tranche.hasNext() liste des tranche horraires du parking
                                if(dispo==true){
                                //on ajoute le séjour à la liste du parking
                                lesSejoursAffectes.put(s.volArrivee.getNum_vol(), s.getTrancheHoraire());
                                //on affecte le parking au séjour
                                s.affecterParking(p);
                                }
                            }//fin if s.parking != null
                       }
                    }//fin it.hasNext() iterator des sejours
                
           }
           // on affecte la liste des séjours trouvés au parking
           
           

        }
    
    
    
    public TrancheHoraire getTrancheHoraire(){
        return dureeSejour;
    }
    
    public void affecterParking(Parking p){
        parking = p;
    }
    
}

