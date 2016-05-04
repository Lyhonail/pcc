package packaeroport;
//import java.lang.String;
//import packaeroport.*;

public class ParkingContact extends Parking {

    private Porte porte;

    public ParkingContact(String code_p, String zone) {
        super(code_p, zone);
        
    }

   public String toString(){
        String info = "Parking hors contact "+this.getCode_park()+" "+this.getZone();
        
        return info;
    }

    public void afficher() {
        System.out.println(this.toString());
    }
    
    
    public void ajouterPorte(){
        
    }
}
