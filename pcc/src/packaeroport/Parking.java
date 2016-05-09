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
    //09-Mai private Porte porteC;
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
        String info = "Numéro de parking: "+ code_park + 
                    " Zone: "+zone;
        //if (porteC != null) 
        //    info += porteC.toString();
        return info;
    }
    
    public void afficher() {
        System.out.println(this.toString());
    }
    
    public static String toStringLesParkings(){
       String info= "Liste des Parkings \n";
        //Hashtable<String, Parking> parkings = (Hashtable<String, Parking>) lesParkings.values();
        Iterator it = lesParkings.values().iterator();
        while(it.hasNext()){
            Parking p = (Parking) it.next();
            info += p.toString()+"\n";
        }
        return info;
    }
    
    public static  void afficherLesParkings(){
        System.out.println(toStringLesParkings());
    }
    
    public static void creerParkings(){
        String File = "01-zones-et-parkings.txt";
        try {
            // Lecture du fichier
            BufferedReader parkings = new BufferedReader (new FileReader (File));
            String ligne = null;
            while((ligne= parkings.readLine()) != null){//WHILE LIGNE des zones
                StringTokenizer tokenHall = new StringTokenizer (ligne);
                String zone = tokenHall.nextToken();
                //System.out.println("\nZone enregistrement: "+zone);
                while (tokenHall.hasMoreTokens()){//liste des parkings sur la ligne des zones
                    String num_park = tokenHall.nextToken();
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
            System.out.println("fichier non trouvé: "+File+"\n");
        }
	catch (IOException e){
		System.out.println("Erreur de lecture fichier: "+File+"\n");
	}
    }
    
    public static Parking getParking(String num_park) throws ParkingInvalide {
        if (!lesParkings.containsKey(num_park))
            throw new ParkingInvalide(num_park);
        else
            return (Parking)lesParkings.get(num_park);
    }
}