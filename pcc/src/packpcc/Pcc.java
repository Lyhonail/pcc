
package packpcc;

import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import packvols.*;
import packaeroport.*;
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
            
        // Affichage dans fenetre
        Controleur unControleur = new Controleur();
             


    }
}
