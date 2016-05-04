package packaeroport;

import java.util.ArrayList;

public class ParkingHorsContact extends Parking {

    private ArrayList lesParkingHorsContact;
    
    
    public ParkingHorsContact(String code_p, String zone) {
        super(code_p, zone);
    }

    public String toString(){
        String info = "Parking ";
        
        return info;
    }

    public void afficher() {
        System.out.println(this.toString());
    }
}
