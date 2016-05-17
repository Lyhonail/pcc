
package packpcc;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import packvols.*;
import packaeroport.*;


public class Pcc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Aeroport orly = new Aeroport("ORLY W");

  
        // DEBUT TEST ODX
        // --------------
        // Creation des Halls en masse
        Hall.creerHalls();
        
        // Creation des portes en masse
        Porte.creerPortes();
        //Porte.afficherLesPortes();
        
        // Creation des parkings en masse
        Parking.creerParkings();
        //Parking.afficherLesParkings();
          
        // Associer Halls et Portes
        Aeroport.associerHallslPortes();
        
        // Associer Portes et parking
        Aeroport.associerPortesParkings();
        
        // Affichage
        Hall.afficherLesHalls();
        Porte.afficherLesPortes();
        Parking.afficherLesParkings();
              
        
       
		
    Avion.creerLesAvions();
    Avion.afficherLesAvions();
    Vol.creerLesVols();
    Vol.afficherLesVols();
       
    }
}
