package packcontrole;

import packvue.FenetrePrincipale;
import java.util.Vector;
import packaeroport.Hall;
import packaeroport.HallInvalide;
import packaeroport.Parking;
import packaeroport.Porte;
import packvols.Avion;
import packvols.Sejour;
import packvols.Vol;
import packvols.VolArrivee;
import packvols.VolDepart;

public class Controleur {
    private  FenetrePrincipale maFenetre;
    
    public Controleur() {
        maFenetre=new FenetrePrincipale(this);
    }
    
    public String toStringLesAvions(){
        return Avion.toStringLesAvions();
    } 
  
    public String toStringLesHalls(){
        return Hall.toStringLesHalls();
    }
    
    public String toStringLesPortes(){
        return Porte.toStringLesPortes();
    }
    
    public String toStringLesParkings(){
        return Parking.toStringLesParkings();
    }
    
    public String toStringLesVols(){
        return Vol.toStringLesVols();
    }
    
    public String toStringLesVolsArrivee(){
        return VolArrivee.toStringLesVols();
    }
    
    public String toStringLesVolsDepart(){
        return VolDepart.toStringLesVols();
    }
    
    public String toStringLesSejours(){
        return Sejour.toStringLesSejours();
    }
    
    public String toStringEcranLesVols(){
        return Vol.toStringEcranLesVols();
    }
    public String toStringEcranVolsArrivee(){
        return VolArrivee.toStringEcranLesVols();
    }
    public String toStringEcranVolsDepart(){
        return VolDepart.toStringEcranLesVols();
    }

    public String getNumHallString(String numHall){ 
        String info = Hall.toStringEcranHall(numHall);
        return info;
    }
}