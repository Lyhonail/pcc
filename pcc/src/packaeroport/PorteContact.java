
package packaeroport;

public class PorteContact extends Porte {

    private ParkingContact parkingC;  // Parking contact

    public PorteContact(String p, String ze) {
        super(p,ze);
        parkingC=null;
    }

    public ParkingContact getParkingC(){
        return parkingC;
    }
            
    public String toString(){
        String info = "\n PORTE CONTACT: " + super.toString() + 
                "\n   Parking Contact associé: ";
        if ( parkingC != null)
            info += parkingC.toStringSansPortes();  
        else
            info += "\n   Parking : N/A";
        return info;
    }
    
    public String toStringSansParkings(){
        return super.toString();
    }
    
    public void affecterParking(ParkingContact p) {
        parkingC = p;
    }
     
    public void desaffecterParking() {
        parkingC = null;
    }
}