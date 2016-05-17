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
public class VolArrivee extends Vol {

    String provenance;
    private static Hashtable <String, Vol> lesVolsArrivee = new Hashtable<String, Vol>();

    public VolArrivee(String num_vol, Horaire horaire, Avion avion, String prov) {
        super(num_vol, horaire, avion);
        provenance = prov;
        lesVolsArrivee.put(num_vol, this);
    }
    
    public String toString(){
        String info = "Vol N° : "+this.getNum_vol();
        return info;
    }

}
