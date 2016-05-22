
package packvols;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import packhoraires.Horaire; 

public class VolDepart extends Vol {
    String destination;
    private static Hashtable <String, Vol> lesVolsDepart = new Hashtable<String, Vol>();
    
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
        
    //public static void afficherLesVols(){
    //    System.out.println(toStringLesVols());
    //}       
}
