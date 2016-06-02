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
import packvols.Sejour;

public class Hall {

    private String num_hall;
    private  ArrayList<Porte> lesPortes ;
    private String zone_enreg;
    private static Hashtable<String, Hall> lesHalls = new Hashtable<String, Hall>();

    public Hall(String n, String ze) {
        num_hall = n;
        zone_enreg = ze;
        lesPortes = new ArrayList<Porte>(); 
        lesHalls.put(n, this);
    }

    public void afficher(){
        System.out.println(this.toString());
    }
    
    public String toString(){
        String info = "\n Hall: "+num_hall+" Zone d'enregistrement: "+zone_enreg+
                "\n Les Portes associées: " ;
        // recuperation de l'arrayList des portes    
        Iterator it = lesPortes.iterator();
	while(it.hasNext()){
            info += it.next().toString();
	}
        return info;
    }
    
    public static void afficherLesHalls(){
        System.out.println(toStringLesHalls());
    }
    
    public static String toStringLesHalls(){
        // Affichage de la hastable lesHalls
        String info = "\n Liste des Halls: ";
        ArrayList<Hall> halls = new ArrayList<Hall>(lesHalls.values());
        Iterator<Hall> it = halls.iterator(); 
        while(it.hasNext()){
            info += it.next().toString();
        }
        return info;
    }
       
    public static void creerHalls(){
        String file = "03-zones-enreg-et-halls.txt";
        try {
            // Lecture du fichier
            BufferedReader halls = new BufferedReader (new FileReader (file));
            String ligne = null;
            while((ligne= halls.readLine()) != null){//liste des halls
                StringTokenizer tokenHall = new StringTokenizer (ligne);
                String num_hall = tokenHall.nextToken();
                String zone_enr = tokenHall.nextToken();
                Hall lesHalls = new Hall (num_hall, zone_enr);
            } 
	} catch (FileNotFoundException e){
            System.out.println("Fichier non trouvé: "+file+"\n");
        }
	catch (IOException e){
		System.out.println("Erreur de lecture fichier: "+file+"\n");
	}
    }
    
    public static Hall getHall(String num_hall) throws HallInvalide {
        if (!lesHalls.containsKey(num_hall))
            throw new HallInvalide(num_hall);
        else
            return (Hall)lesHalls.get(num_hall);
    } 
    
    public String getNum_hall(){
       return num_hall;
    }
    
    public String getZone_enreg(){
       return zone_enreg;
    }
    
    public void ajouterPorte(Porte p){
        lesPortes.add(p);
    }
    
    public void retirerPorte(Porte p){
        lesPortes.remove(p);
    }
    
    public static void toStringEcranHallParkings(){
        String info = null;
        //Affichage des parkings
        ArrayList<Parking> sejours = new ArrayList<Parking>(Parking.getLesParkings().values());
        //Collections.sort(sejours);
        Iterator<Parking> itParking = sejours.iterator();
        while(itParking.hasNext()){
        Parking p = itParking.next();
        info += "\n"+p.getCode_park()+" : \n";
            //Affichage des séjours affectés
            ArrayList<Sejour> lesSejours = new ArrayList<Sejour>(p.getLesSejours());
            Iterator<Sejour> itSejour = lesSejours.iterator();
            
            while(itSejour.hasNext()){
                Sejour s = itSejour.next();
                
                info += "\n"+s.getTrancheHoraire();
            }
        }//fin while(itParking.hasNext())
        
                 System.out.println( "salut hall parking \n"+info);
    }
}
