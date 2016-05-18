
package packvols;

import java.util.ArrayList;
import java.util.Hashtable;
import packhoraires.Horaire; 

public class VolDepart extends Vol {
    String destination;
    private static Hashtable <String, Vol> lesVolsDepart = new Hashtable<String, Vol>();
    
    public VolDepart(String num_vol, Horaire horaire, Avion avion,String dep) {
                super(num_vol, horaire, avion);
                destination = dep;
                lesVolsDepart.put(num_vol, this);
    }
    
    public String toString(){
        String info = super.toString()+" A destination de: "+destination;
        return info;
    }
    
    public String getdestination(){
        return destination;
    }
}
