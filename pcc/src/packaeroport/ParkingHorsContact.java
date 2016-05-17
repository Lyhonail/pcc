package packaeroport;

import java.util.ArrayList;
import java.util.Iterator;

public class ParkingHorsContact extends Parking {

    private ArrayList lesPortesHorsContact;
    
    public ParkingHorsContact(String code_p, String zone) {
        super(code_p, zone);
        lesPortesHorsContact = new ArrayList<Porte>();
    }
    
    public String toStringSansPortes(){
        return super.toString();
    }
        
    public String toString(){
        String info = "\n PARKING HORS CONTACT: " +super.toString() + 
                "\n   Les Portes Hors Contact associées: " ;
        Iterator<PorteHorsContact> it = lesPortesHorsContact.iterator();
            while(it.hasNext()){
                info += it.next().toStringSansParkings();
	}  
        return info;
    }
    
    public void ajouterPorte(Porte porte){
        lesPortesHorsContact.add(porte);
    }
    
    public void retirerPorte(Porte porte){
        lesPortesHorsContact.remove(porte);
    }
}
