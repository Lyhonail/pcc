
package packaeroport;

import java.util.ArrayList;
import java.util.Iterator;

public class PorteHorsContact extends Porte {

    private ArrayList<ParkingHorsContact> lesParkingsHC; // parkings hors contact

    public PorteHorsContact(String p, String ze) {
        super(p,ze);
        lesParkingsHC = new ArrayList<ParkingHorsContact>();
        
    }
        
    public String toString() {
        String info = "\n PORTE HORS CONTACT: " + super.toString() + 
                "\n   Les Parkings Hors Contact associés: " ;
        // Afficher ArrayList des parkings HorsContact
        Iterator<ParkingHorsContact> it = lesParkingsHC.iterator();
        while (it.hasNext()){
            info += it.next().toStringSansPortes();
        }             
        return info;
    }
    
    public ParkingHorsContact getParkingHC(){
        ParkingHorsContact parkingHC = null;
        Iterator<ParkingHorsContact> it = lesParkingsHC.iterator();
        parkingHC = it.next();
        return parkingHC;
    }
    
    public String toStringSansParkings(){
        return super.toString();
    }
    
    public void ajouterParking(ParkingHorsContact p) {
        lesParkingsHC.add(p);
    }

    public void retirerParking(ParkingHorsContact p) {
        lesParkingsHC.remove(p);
    }
}
