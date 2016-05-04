/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packvols;

import java.util.ArrayList;
import packhoraires.Horaire; 


/**
 *
 * @author user
 */
public class VolDepart extends Vol {
    String depart;
    ArrayList<VolDepart> lesVolsArrivee;
    
    
    public VolDepart(String num_vol, Horaire horaire, Avion avion,String dep) {
        super(num_vol, horaire, avion);
                depart = dep;
                lesVolsArrivee  = new ArrayList<VolDepart>();
    }
    
}
