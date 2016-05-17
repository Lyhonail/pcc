/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packvols;

import java.util.ArrayList;
import java.util.Hashtable;
import packhoraires.Horaire; 


/**
 *
 * @author user
 */
public class VolDepart extends Vol {
    String depart;
    private static Hashtable <String, Vol> lesVolsDepart = new Hashtable<String, Vol>();
    
    
    public VolDepart(String num_vol, Horaire horaire, Avion avion,String dep) {
                super(num_vol, horaire, avion);
                depart = dep;
                lesVolsDepart.put(num_vol, this);
    }
    
    public String toString(){
        String info = " Départ "+super.toString();
        //info +=" test ";
        return info;
    }
    
}
