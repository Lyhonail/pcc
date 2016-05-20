
package packpcc;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import packvols.*;
import packaeroport.*;
import packhoraires.*;


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
        
        // Affichage
       // Hall.afficherLesHalls();
       // Porte.afficherLesPortes();
      //  Parking.afficherLesParkings();
              
        
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
       // FIN TEST ODX

    //Avion.afficherLesAvions();
    Avion.creerLesAvions();
    Vol.creerLesVols();
 
    
   //Vol.afficherLesVols();
    Sejour.creerLesSejours();
    Aeroport.affecterLesParkings();
    Sejour.afficherLesSejours();
    
    System.out.println("\nHoraire A ");
    Horaire adebut = new Horaire (8, 30);
    adebut.afficher();
    Horaire afin = new Horaire (10, 30);
    afin.afficher();
    
    System.out.println("\nHoraire B ");
    Horaire bdebut = new Horaire (9, 30);
    bdebut.afficher();
    Horaire bfin = new Horaire (12, 30);
    bfin.afficher();
    
    TrancheHoraire A = new TrancheHoraire(adebut, afin);
    TrancheHoraire B = new TrancheHoraire(bdebut, bfin);
    
    /* if(A.dansTrancheHoraire(A)) System.out.println("\n Vrai danstranche");
    else System.out.println("\n faux danstranche");
    
   if(A.contient(B)) System.out.println("\n Vrai contient ");
   else System.out.println("\n faux contient"); */
   
   if(A.contientStrictement(bdebut)) System.out.println("\n contient l'horraire de début");
   else System.out.println("\n ne contient pas l'horraire");
    }
}
