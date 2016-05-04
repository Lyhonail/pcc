package packaeroport;

import java.util.ArrayList;
import java.util.Hashtable;

public class Porte {
    
    private String num_porte;
    private Hall hall; //ajouté par prof
    
    private static Hashtable<String, Porte> lesPortes = new Hashtable<String, Porte>();
   
    public Porte(String p) {
        num_porte = p;
        // ajout dans la Hashtable
        lesPortes.put (p, this);
    }

    public String toString(){
        String info = "Porte : "+ num_porte;
        return info;
    }
    
    public void afficher() {
            System.out.println(this.toString());
    }

    public String getNum_porte(){
        return num_porte;
    }
    
    public void ajouterHall(String noHall,String zoneEnreg){
        hall = new Hall(noHall,zoneEnreg);
    }
}