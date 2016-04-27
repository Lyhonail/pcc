package packaeroport;

import java.util.ArrayList;
import java.util.Iterator;


public class Hall {

    private String num_hall;
    private  ArrayList<Porte> porte;
    private String zone_enreg;

public Hall(String n, String ze) {
        num_hall = n; porte = new ArrayList<Porte>(); zone_enreg = ze;
    }
    
public void Afficher(){
		System.out.println(this.toString());
}

public void AjouterListePorte(ArrayList<Porte> p){
    porte = p;
}

public void AjouterPorte(Porte p){
    porte.add(p);
}

public String toString(){
  String info = num_hall+"\n Zone d'enregistrement : "+zone_enreg;
   
 for(int i = 0; i < porte.size(); i++)
    {   
      info += "\n" + porte.get(i);  
    }    
    return info;

    
}
   
    
}
