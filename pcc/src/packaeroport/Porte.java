package packaeroport;

import java.util.ArrayList;

public class Porte {
    
    private String num_porte;
    private Object parking;
    

public Porte(String p, Object park) {
        num_porte = p; parking = park;
    }

public String toString(){
        String info = "Porte : "+ num_porte+" "+parking.toString();
        return info;
    }
public void afficher() {
        System.out.println(this.toString());
    }

public String getCode(){
    return num_porte;
    }
    
}
