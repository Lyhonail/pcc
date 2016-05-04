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
public class VolArrivee extends Vol {

    String provenance;
    ArrayList<VolArrivee> lesVolsArrivee;

    public VolArrivee(String num_vol, Horaire horaire, Avion avion, String prov) {
        super(num_vol, horaire, avion);
        provenance = prov;
        lesVolsArrivee = new ArrayList<VolArrivee>();
    }

}
