/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packvols;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import packhoraires.Horaire;

/**
 *
 * @author user
 */
public class VolArrivee extends Vol {

    String provenance;
    private static Hashtable <String, Vol> lesVolsArrivee = new Hashtable<String, Vol>();

    public VolArrivee(String num_vol, Horaire horaire, Avion avion, String prov) {
        super(num_vol, horaire, avion);
        provenance = prov;
        lesVolsArrivee.put(num_vol, this);
    }
    
    public String toString(){
        String info = super.toString()+" En provenance de: "+provenance;
        //info +=" test ";
        return info;
    }
    
    public String getProvenance(){
        return provenance;
    }
    
    /*
    public static void afficherLesVols(){
        // Affichage de la hastable lesPortes
        String info = "Affichage Hashtable lesVols";
        
        ArrayList<Vol> vols = new ArrayList<Vol>(lesVolsArrivee.values());
        
        Iterator<Vol> it = vols.iterator(); 
        while(it.hasNext()){
           Vol v = it.next();
           info += "\n Vol Arrivee N° : "+v.getNum_vol()+" ";
           info += v.getHoraire()+" ";
           Avion a = v.getAvion();
          String immat = a.getImmat();
         info += " "+immat;
        }
        System.out.println(info);
    }*/

}
