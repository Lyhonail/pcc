package packaeroport;

import java.util.Hashtable;

public class ParkingContact extends Parking {

    private PorteContact porteC;
    private static Hashtable<String, ParkingContact> lesParkingsContact = new Hashtable<String, ParkingContact>();

    public ParkingContact(String code_p, String zone) {
        super(code_p, zone);
        porteC = null;
        lesParkingsContact.put(code_p, this);
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
   
   public Porte getPorteC(){
       return porteC;
   }
   
   public static void afficherLesParkingsContact(){
        System.out.println(toStringLesParkings());
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
    
    public static Hashtable <String, ParkingContact> getLesParkingsContact(){
        return lesParkingsContact;
    }
}
