package packaeroport;

import java.util.Hashtable;
import java.util.Iterator;

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

    /*public String toString() {
        String info = "rien"; //Parking : "+code_park+" Zone : "+zone;
        return info;
    }*/
    
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
}