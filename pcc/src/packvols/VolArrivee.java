
package packvols;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import packaeroport.ParkingContact;
import packaeroport.ParkingHorsContact;
import packaeroport.PorteContact;
import packaeroport.PorteHorsContact;
import packhoraires.Horaire;

public class VolArrivee extends Vol {

    String provenance;
    private static Hashtable <String, VolArrivee> lesVolsArrivee = new Hashtable<String, VolArrivee>();

    public VolArrivee(String num_vol, Horaire horaire, Avion avion, String prov) {
        super(num_vol, horaire, avion);
        provenance = prov;
        lesVolsArrivee.put(num_vol, this);
    }
    
    public String toString(){
        String info = super.toString()+" En provenance de: "+provenance;
        return info;
    }
    
    public String getProvenance(){
        return provenance;
    }
    
    public static String toStringLesVols(){
        // Affichage de la hastable lesVols arrivee
        String info = "Liste des vols d'arrivée";
        ArrayList<Vol> vols_arr = new ArrayList<Vol>(lesVolsArrivee.values());
        Collections.sort(vols_arr);
        Iterator<Vol> it = vols_arr.iterator(); 
        while(it.hasNext()){
           Vol v = it.next();
           info +=v.toString();
        }
        return (info);
    }
        
    public static String toStringEcranLesVols(){
        // Affichage de la hastable Vols
        String info = String.format("\n%-8s %-8s %-20s %-10s %-10s",
            "Horaire","Vol","Provenance","Hall","Porte");
        ArrayList<VolArrivee> vols = new ArrayList<VolArrivee>(lesVolsArrivee.values());
        Collections.sort(vols);
        Iterator<VolArrivee> it = vols.iterator(); 
        while(it.hasNext()){
            String hall = null, porte = null;
            VolArrivee v = it.next();
            if (v.getSejour().getParking() instanceof ParkingContact  ){
                ParkingContact p = (ParkingContact) v.getSejour().getParking();
                PorteContact porteC = (PorteContact) p.getPorteC();
                hall = porteC.getHall().getNum_hall();
                porte = porteC.getNum_porte();
            }
            else {
                ParkingHorsContact p = (ParkingHorsContact) v.getSejour().getParking();
                PorteHorsContact porteHC = (PorteHorsContact) p.getPorteHC();
                hall = porteHC.getHall().getNum_hall();
                porte = porteHC.getNum_porte();
            }
            info += String.format("\n%-8s %-8s %-20s %-10s %-10s",
                   v.getHoraire(),v.getNum_vol(),v.provenance, hall,porte);
        }   
        return(info);
        }    
}
