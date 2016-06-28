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
    private VolArrivee volArrivee;
    private VolDepart  volDepart;
    
    private static Hashtable <String, Sejour> lesSejours = new Hashtable<String, Sejour>();
    
    public Sejour(TrancheHoraire t, VolArrivee va, VolDepart vd, Parking p, Avion a, String num_va){
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
        String info = "\n Séjour du vol: "+ num_volArrivee+ " Durée du séjour:" + dureeSejour;
        info += volArrivee.toString();
        info += volDepart.toString();
        if (parking != null)
             info += parking.toString();
        else  
            info += " Hall : N/A";
      
        return info;
    }
    
    public Parking getParking(){
        return parking;
    }
    
    public String getNumVolArrivee(){
        return this.volArrivee.getNum_vol();
    }
    
    public String getNumVolDepart(){
        return this.volDepart.getNum_vol();
    }
    
    public Avion getAvion(){
        return avion;
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
                    VolArrivee vol_arrivee = (VolArrivee) Vol.getVol(num_volArrivee);
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
                        VolDepart vol_depart = (VolDepart) Vol.getVol(num_volDepart);
                        //récupération de l'horaire de départ
                        Horaire hd = vol_depart.getHoraire();

                        //création de la tranche horaire
                        TrancheHoraire tranche = new TrancheHoraire(ha, hd);
                                                                                             
                        // Creation du sejour
                        Sejour s = new Sejour(tranche, vol_arrivee, vol_depart, null, avion_find, num_volArrivee );
                           
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
        // on ouvre la liste des séjours
        ArrayList<Sejour> sejours = new ArrayList<Sejour>(lesSejours.values());
        // tri de la liste des séjours dans l'odre croissant des horaires de début
        Collections.sort(sejours);
        Iterator<Sejour> it = sejours.iterator();
        while(it.hasNext()){
            Sejour s = it.next();
            if(s.parking == null){
                //on lit les parkings contact
                boolean affecte = false;
                Hashtable<String, ParkingContact> lesParkingsContact = ParkingContact.getLesParkingsContact();
                Iterator<ParkingContact> itpc = lesParkingsContact.values().iterator();
                while(itpc.hasNext() && affecte == false){
                    Parking p = itpc.next();
                    Horaire h = s.dureeSejour.getDebutTrancheHoraire();
                    if(p.getDispo().contient(h)){
                        //ne rien faire
                    }// fin if(p.getDispo().contient(h))
                    else {
                        s.affecterParking(p);
                        s.volArrivee.affecterSejour(s);
                        s.volDepart.affecterSejour(s);
                        TrancheHoraire th = new TrancheHoraire(p.getDispo().getDebutTrancheHoraire(), s.dureeSejour.getFinTrancheHoraire());
                        TrancheHoraire hd = new TrancheHoraire(s.dureeSejour.getDebutTrancheHoraire(), s.dureeSejour.getFinTrancheHoraire());
                        p.majTranche(th, hd);
                        p.majSejour(s);
                        affecte = true;
                    } //fin else
                    
                }//fin  while(itpc.hasNext())
                if(affecte == false){
                    Hashtable<String, ParkingHorsContact> lesParkingsHorsContact = ParkingHorsContact.getLesParkingsHorsContact();
                    Iterator<ParkingHorsContact> itphc = lesParkingsHorsContact.values().iterator();
                    while(itphc.hasNext() && affecte == false){
                        Parking phc = itphc.next();
                        Horaire hhc = s.dureeSejour.getDebutTrancheHoraire();
                        if(phc.getDispo().contient(hhc)){
                            //ne rien faire
                        }// fin if(phc.getDispo().contient(hhc))
                        else {
                            s.affecterParking(phc);
                            s.volArrivee.affecterSejour(s);
                            s.volDepart.affecterSejour(s);
                            TrancheHoraire thhc = new TrancheHoraire(phc.getDispo().getDebutTrancheHoraire(), s.dureeSejour.getFinTrancheHoraire());
                            TrancheHoraire hd = new TrancheHoraire(s.dureeSejour.getDebutTrancheHoraire(), s.dureeSejour.getFinTrancheHoraire());
                            phc.majTranche(thhc, hd);
                            phc.majSejour(s);
                            affecte = true;
                        } //fin else
                    }//fin while(itphc.hasNext() && affecte == false)
                }//fin if(affecte == false)
     
            }// fin if(s.parking == null)
        }//fin it.hasNext() >> on lit les sejours
    }//Fin methode   
    
    public TrancheHoraire getTrancheHoraire(){
        return dureeSejour;
    }
    
    public void affecterParking(Parking p){
        parking = p;
    }
}

