package packaeroport;

import java.util.ArrayList;
import java.util.Iterator;

public class ParkingHorsContact extends Parking {

    private ArrayList<Porte> lesPortesHorsContact;
    //private String cap;
    
    public ParkingHorsContact(String code_p, String zone) {
        super(code_p, zone);
        lesPortesHorsContact = new ArrayList<Porte>();
    }

    public String toString(){
        //String info = "Parking hors contact "+this.getCode_park()+" "
        //        +this.getZone()+"\n";
        String info = "Parking hors contact "+super.toString() + 
                " Les Portes Hors Contact associés: " ;
        Iterator it = lesPortesHorsContact.iterator();
		while(it.hasNext()){
                    //Porte p = (Porte) ita.next();
                    //info += p.toString() +"\n";
                    info += "\n  " + it.next().toString();
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
