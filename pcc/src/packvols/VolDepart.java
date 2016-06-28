
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

public class VolDepart extends Vol {
    private String destination;
    private static Hashtable <String, VolDepart> lesVolsDepart = new Hashtable<String, VolDepart>();
    
    public VolDepart(String num_vol, Horaire horaire, Avion avion,String dep) {
                super(num_vol, horaire, avion);
                destination = dep;
                lesVolsDepart.put(num_vol, this);
    }
    
    public String toString(){
        String info = super.toString()+" A destination de: "+destination;
        return info;
    }
    
    public String getdestination(){
        return destination;
    }
    
    public static String toStringLesVols(){
        // Affichage de la hastable lesVols arrivee
        String info = "Liste des vols de départ";
        ArrayList<Vol> vols_dep = new ArrayList<Vol>(lesVolsDepart.values());
        Collections.sort(vols_dep);
        Iterator<Vol> it = vols_dep.iterator(); 
        while(it.hasNext()){
           Vol v = it.next();
           info +=v.toString();
        }
        return (info);
    }
        
    public static String toStringEcranLesVols(){
        // Affichage de la hastable Vols
        String info = String.format("\n %-8s  %-8s %-20s %-10s %-10s",
                "Horaire","Vol","Destination","Hall","Porte");
        //String info = "Horaire    Vol  Destination            Hall  Porte ";
        ArrayList<VolDepart> vols = new ArrayList<VolDepart>(lesVolsDepart.values());
        Collections.sort(vols);
        Iterator<VolDepart> it = vols.iterator(); 
        while(it.hasNext()){
            String hall = null, porte = null;
            VolDepart v = it.next();
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
            info += String.format("\n%8s   %-8s %-20s %-10s %-10s",
                   v.getHoraire(),v.getNum_vol(),v.destination, hall,porte);
        }   
        return(info);
    }       
}
