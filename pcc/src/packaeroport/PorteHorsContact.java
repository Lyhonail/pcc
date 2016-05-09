/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packaeroport;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class PorteHorsContact extends Porte {

    private ArrayList lesParkingsHC; // parking hors contact

    public PorteHorsContact(String p, String ze) {
        super(p,ze);
        lesParkingsHC = new ArrayList<Parking>();
    }
        
    public String toString() {
        String info = "Porte Hors Contact : " + super.toString() + 
                " Les Parkings Hors Contact associés: " ;
        // Afficher ArrayList des parkings HorsContact
        Iterator<Parking> it = lesParkingsHC.iterator();
        while (it.hasNext()){
            info += "\n  " + it.next().toString();
        }             
        return info;
    }

    public void ajouterParking(Parking p) {
        lesParkingsHC.add(p);
    }

    public void retirerParking(Parking p) {
        lesParkingsHC.remove(p);
    }
}
