package packaeroport;
//import java.lang.String;
//import packaeroport.*;

public class ParkingContact extends Parking {

    private Porte porte;

    public ParkingContact(String code_p, String zone) {
        super(code_p, zone);
        
    }

    public void afficher() {
        System.out.println(this.toString());
    }
}
