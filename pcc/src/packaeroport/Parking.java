package packaeroport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;

public abstract class Parking {

    private String code_park;
    private String zone;
    private static Hashtable<String, Parking> lesParkings = new Hashtable<String, Parking>();

    public Parking(String p, String z){
        code_park = p; zone = z;
        lesParkings.put(p, this);
    }
    
    public String getCode_park() {
        return code_park;
    }

    public String getZone() {
        return zone;
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
        Iterator<Parking> it = lesParkings.values().iterator();
        while(it.hasNext()){
            Parking p = it.next();
            //recupère le toString d'un parking Contact ou Hors Contact
            info += p.toString();
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
                //System.out.println("\nZone enregistrement: "+zone);
                while (tokenPark.hasMoreTokens()){//liste des parkings sur la ligne des zones
                    String num_park = tokenPark.nextToken();
                    if (zone.equals("Mike")){
                        //parking Hors contact
                        //System.out.println("\nParking hors contact: "+num_park);
                        ParkingHorsContact unPark = new ParkingHorsContact (num_park, zone);
                    }
                    else{
                        //porte contact
                        //System.out.println("\nPorte contact: "+num_porte);
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