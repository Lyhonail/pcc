package packaeroport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import packhoraires.*;
import packvols.*;

public abstract class Parking {

    private String code_park;
    private String zone;
    private TrancheHoraire dispo;
    private ArrayList<TrancheHoraire> tranche;
    private ArrayList <Sejour> lesSejoursAffectés = new ArrayList <Sejour>();
    private Hashtable <String, TrancheHoraire> trancheOccupee = new Hashtable<String, TrancheHoraire>();
    private static final Hashtable<String, Parking> lesParkings = new Hashtable<String, Parking>();
    private static Hashtable <String, TrancheHoraire> lesTranchessAffectés = new Hashtable<>();
    
    

    public Parking(String p, String z){
        code_park = p; zone = z;
        lesParkings.put(p, this);
        lesTranchessAffectés = new Hashtable <String, TrancheHoraire>();
        trancheOccupee = new Hashtable <String, TrancheHoraire>() ;
        lesSejoursAffectés = new ArrayList <Sejour>();
        tranche = new ArrayList<TrancheHoraire>() ;
        Horaire h = new Horaire(0,0);
        TrancheHoraire t = new TrancheHoraire(h,h);
        dispo = t;
    }
    
    public String getCode_park() {
        return code_park;
    }
    
    public TrancheHoraire getDispo(){
        return dispo;
    }

    public String getZone() {
        return zone;
    }
    
    public ArrayList getTranche(){
        return tranche;
    }
    
    public ArrayList <Sejour> getLesSejours(){
        return lesSejoursAffectés;
    }

    public static Hashtable <String, Parking> getLesParkings(){
        return lesParkings;
    }
    
    public void majTranche(TrancheHoraire t, TrancheHoraire hd){
        dispo = t;
        tranche.add(hd);
        trancheOccupee.put("0", hd);
    }
    
    public void majSejour(Sejour s){
        lesSejoursAffectés.add(s);
        
    }
    
    public void majTrancheOccupee(TrancheHoraire t, String n){
        lesTranchessAffectés.put(n, t);   
    }
    
    public void AffecterSejour(Hashtable <String, TrancheHoraire> liste){        
        lesTranchessAffectés = liste;        
    }
        
    public String toString() {
        String info =  "\n   Parking: " +code_park + " Zone: " +zone;
        return info; 
    }
    
    public void afficher() {
        System.out.println(this.toString());
    }
    
    public static String toStringLesParkings(){
        String info= "\n Liste des Parkings: ";
        //Collections.sort(lesParkings);
        Iterator<Parking> it = lesParkings.values().iterator();
        while(it.hasNext()){
            Parking p = it.next();
            //recupère le toString d'un parking Contact ou Hors Contact
            info += p.toString();
            info += "\n Programme de la journée : ";
            Horaire h = new Horaire(0,0);
            
            TrancheHoraire th = new TrancheHoraire(h,h);
            if(p.dispo.equals(th)){
                info += " N/A \n";    
            }
            else {
                info += p.getDispo();
                Iterator<TrancheHoraire> itTranche = p.getTranche().iterator(); 
                while(itTranche.hasNext()){
                    TrancheHoraire t = itTranche.next();
                    //recupère le toString d'un parking Contact ou Hors Contact
                    info += "\n"+t.toString();
                    }
                }   
        }
        return info;
    }
    
    public static void afficherLesParkings(){
        System.out.println(toStringLesParkings());
    }
  
    public static void creerParkings(){
        String file = "01-zones-et-parkings.txt";
        try {
            // Lecture du fichier
            BufferedReader parkings = new BufferedReader (new FileReader (file));
            String ligne = null;
            while((ligne= parkings.readLine()) != null){//WHILE LIGNE des zones
                StringTokenizer tokenPark = new StringTokenizer (ligne);
                String zone = tokenPark.nextToken();
                while (tokenPark.hasMoreTokens()){//liste des parkings sur la ligne des zones
                    String num_park = tokenPark.nextToken();
                    if (zone.equals("Mike")){
                        //parking Hors contact
                        ParkingHorsContact unPark = new ParkingHorsContact (num_park, zone);
                    }
                    else{
                        //porte contact
                        ParkingContact unePorte = new ParkingContact (num_park, zone);
                    }
                }
            }    
	} catch (FileNotFoundException e){
            System.out.println("fichier non trouvé: "+file+"\n");
        }
	catch (IOException e){
		System.out.println("Erreur de lecture fichier: "+file+"\n");
	}
    }
    
    public static Parking getParking(String num_park) throws ParkingInvalide {
        if (!lesParkings.containsKey(num_park))
            throw new ParkingInvalide(num_park);
        else
            return (Parking)lesParkings.get(num_park);
    }
     
}
