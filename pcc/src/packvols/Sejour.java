package packvols;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import packhoraires.TrancheHoraire;

import java.util.Date;
import java.util.StringTokenizer;
import packaeroport.*;

public class Sejour {

    private TrancheHoraire dureeSejour; 
    private int margeMinutes;
    private Parking parking;
    private String immatriculation;
    private Avion avion;
    
    public Sejour(TrancheHoraire t, Parking p, Avion a){
        dureeSejour = t;
        parking = p;
        avion = a;        
    }
    
    public String toString(){
        String info = "test";
        return info;
    }
      
    
    
    
    
    
    
    
    
}
