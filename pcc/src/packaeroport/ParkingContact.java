package packaeroport;
//import java.lang.String;
//import packaeroport.*;

public class ParkingContact extends Parking {

    private Porte porteC;

    public ParkingContact(String code_p, String zone) {
        super(code_p, zone);
        porteC = null;
    }

   public String toString(){
        //String info = "Parking contact "+this.getCode_park()+" "+this.getZone();
        String info = "Parking contact "+ super.toString();
        if (porteC != null) 
            info += porteC.toString();
        
        return info;
    }

    public void afficher() {
        System.out.println(this.toString());
    }
    
    public void affecterPorte(Porte p) {
        porteC = p;
    }
}
