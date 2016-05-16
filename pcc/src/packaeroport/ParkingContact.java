package packaeroport;

public class ParkingContact extends Parking {

    private PorteContact porteC;

    public ParkingContact(String code_p, String zone) {
        super(code_p, zone);
        porteC = null;
    }

   public String toString(){
        String info = "\n PARKING CONTACT:  "+ super.toString() +
                  "\n   Porte Contact associée: ";;
        if (porteC != null) 
            info += porteC.toStringSansParkings();
        else
            info += "\n   Porte contact: N/A";
        
        return info;
    }

    public String toStringSansPortes(){
        return super.toString();
    }
   
    public void affecterPorte(PorteContact p) {
        porteC = p;
    }

    public void desaffecterPorte() {
        porteC = null;
    }
}
