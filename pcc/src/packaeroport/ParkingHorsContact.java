package packaeroport;

import java.util.ArrayList;
import java.util.Iterator;

public class ParkingHorsContact extends Parking {

    private ArrayList lesPortesHorsContact;
    private String cap;
    
    public ParkingHorsContact(String code_p, String zone, String c) {
        super(code_p, zone);
        cap= c;
        lesPortesHorsContact = new ArrayList<Porte>();
    }

    public String toString(){
        String info = "Parking hors contact "+this.getCode_park()+" "+this.getZone()+" le test : "+cap+"\n";
        
        Iterator ita = lesPortesHorsContact.iterator();
		while(ita.hasNext()){
			Porte p = (Porte) ita.next();
			info += p.toString() +"\n";	
		}
        
        return info;
    }

    public void afficher() {
        System.out.println(this.toString());
    }
    
    public void ajouterPorte(Porte porte){
        lesPortesHorsContact.add(porte);
    }
}
