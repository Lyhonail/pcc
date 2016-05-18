
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
		//Avion a380 = new Avion("ABX00120045", "AIRBUS-A320");
		//orly.ajouter(a380);
                
        //ParkingHorsContact p = new ParkingHorsContact("Parktest1", "les chameaux", "capt");
        //Parking q = new ParkingContact("Parktest2", "les dromadaires");
        
       // p.afficher();
        //q.afficher();
        
        //Porte PA = new PorteContact("PA");
        
        //p.ajouterPorte(PA);
        
        
        // p.afficherLesParkings();
        //Parking.afficherLesParkings();
  
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
        
        // Creation des avions
        Avion.creerLesAvions();
        
        // Affichage
        //Hall.afficherLesHalls();
        //Porte.afficherLesPortes();
        //Parking.afficherLesParkings();
              
        
        // DEBUT TEST ODX ->
 /*       
           // test recup parking hors contact dans la hashtable
            System.out.println("\n Test recup objet parking dans Hashtable");
            try {
                Parking objet_parking = Parking.getParking("V7");
                //Parking objet_parking = Parking.getParking("M1");
                if (objet_parking instanceof ParkingContact){
                    ParkingContact objPC = (ParkingContact)objet_parking;
                    objPC.afficher();
                    objPC.desaffecterPorte();  
                    objPC.afficher();
                }
                else {
                    ParkingHorsContact objPHC = (ParkingHorsContact)objet_parking;
                    objPHC.afficher();
                }
            } catch (ParkingInvalide e){
		System.out.println(e.toString());
            }      
 */          
            // test recup porte dans la hashtable
 /*           System.out.println("Test recup objet porte dans Hashtable");
            try {
                //Porte objet_porte = Porte.getPorte("33");
                Porte objet_porte = Porte.getPorte("41");
                if (objet_porte instanceof PorteContact){
                    PorteContact objPC = (PorteContact)objet_porte;
                    objPC.afficher();
                    objPC.desaffecterParking();  
                    objPC.afficher();
                }
                else {
                    PorteHorsContact objPHC = (PorteHorsContact)objet_porte;
                    objPHC.afficher();
                    objPHC.desaffecterHall();
                    objPHC.afficher();
                }    
            } catch (PorteInvalide e){
		System.out.println(e.toString());
            }
*/
            // test recup d'un hall dans la hashtable
/*            System.out.println("Test recup objet hall dans Hashtable");
            try {
                Hall objet_hall = Hall.getHall("4");
                objet_hall.afficher();
            } catch (HallInvalide e){
		System.out.println(e.toString());
            }
*/           
            // Test des Avions
/*           Avion.creerLesAvions();
           // Recup d'un avion dans la Hastable
           try {
                Avion objet_avion = Avion.getAvion("ABX00120045");
                objet_avion.afficher();
            } catch (AvionInvalide e){
		System.out.println(e.toString());
            }
            
           Avion.afficherLesAvions();
*/           

            // Creation des vols
            Vol.creerLesVols();
            // Recup d'un avion dans la Hastable
            try {
                Vol objet_vol = Vol.getVol("IT4444");
                objet_vol.afficher();
            } catch (VolInvalide e){
		System.out.println(e.toString());
            }
           
            Vol.afficherLesVols();
             
       // FIN TEST ODX
       
/*
    //Avion.afficherLesAvions();
    Avion.creerLesAvions();
    Vol.creerLesVols();
 
    
   //Vol.afficherLesVols();
    Sejour.creerLesSejours();
    Sejour.afficherLesSejours();
*/    

    }
}
