/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packaeroport;


public class PorteContact extends Porte {

    private Parking parkingC;  // Parking contact

    public PorteContact(String p, String ze) {
        super(p,ze);
        parkingC=null;
        

    }

    public String toString(){
        //String info = "Porte Contact: " + super.toString() + 
        //        " Parking Contact associé: " + parkingC.toString();
        String info = "\n PORTE CONACT: " + super.toString() + 
                " \n Parking Contact associé: ";
        if ( parkingC != null)
            info += parkingC.toString();      
        return info;
    }

    public void affecterParking(Parking p) {
        parkingC = p;
    }

    public void retirerParking() {
    }


    public String toStringDepuisParking(){
    String info = "\n PORTE CONACT ASSOCIEE : " + super.toStringDepuisParking();
    return info;
    }
    
    public String toStringDepuisHall(){
        String info = super.toStringDepuisHall();
        return info;
    }
}