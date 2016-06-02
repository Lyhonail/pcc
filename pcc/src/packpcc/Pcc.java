
package packpcc;

import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import packvols.*;
import packaeroport.*;
import packhoraires.*;

import packcontrole.Controleur;


public class Pcc {

    public static void main(String[] args) {
        // Creation de l'aeroport
        Aeroport orly = new Aeroport("ORLY W");
        // Creation des Halls en masse
        Hall.creerHalls();  
        // Creation des portes en masse
        Porte.creerPortes();      
        // Creation des parkings en masse
        Parking.creerParkings();
        // Associer Halls et Portes
        Aeroport.associerHallslPortes();
        // Associer Portes et parking
        Aeroport.associerPortesParkings();
        // Creation des avions
        Avion.creerLesAvions();           
        // Creation des vols
        Vol.creerLesVols();
        // Création des séjours
        Sejour.creerLesSejours();
        Sejour.associerSejoursParkings();
        
        // Associer les sejours aux parkings
        //Aeroport.associerSejoursParkings();
        //Sejour.associerSejoursParkings();
            
        // Affichage dans fenetre
        Controleur unControleur = new Controleur();
        
 /*       Horaire adebut = new Horaire (8, 30);
        Horaire afin = new Horaire (12, 30);
        
        Horaire bdebut = new Horaire (8, 30);
        Horaire bfin = new Horaire (12, 30);
        
        TrancheHoraire ta = new TrancheHoraire(adebut, afin);
        TrancheHoraire tb = new TrancheHoraire(bdebut, bfin);
        
        System.out.println(ta);
        System.out.println(tb);
        
        
        //System.out.println(ta.contient(tb));
        //System.out.println(ta.contientStrictement(bdebut));
        System.out.println(ta.contientStrictement(bdebut));
        
        ParkingHorsContact.afficherLesParkings();
 */       
        
        //if(! ta.contient(tb))System.out.println("vrai") ;
             

    }
}
