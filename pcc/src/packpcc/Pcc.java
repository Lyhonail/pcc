
 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packpcc;
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import packvols.*;
import packaeroport.*;
//truc

/**
 *
 * @author Lionel
 */
public class Pcc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            Aeroport bercy = new Aeroport("bercy");
		//Avion a380 = new Avion("ABX00120045", "AIRBUS-A320");
		//bercy.ajouter(a380);
                
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
       // Aeroport.associerPortesParkings();
        
       //Porte porte = new PorteContact("Porte01", "10");
       //Hall h4 = new Hall ("Hall4","Zone 40");
       
       //porte.affecterHall(h4);
        //Hall.afficherLesHalls();
        //Porte.afficherLesPortes();
        Parking.afficherLesParkings();
        
        
       // ParkingContact p = new ParkingContact("Parking01", "Mike");
        
        
        //p.affecterPorte(porte);
        //p.afficher();
        // affichage de la Hasttable des halls
        //Hall.afficherLesHalls();
        // affichage de la Hasttable des portes
        //Porte.afficherLesPortes();
        // affichage de la Hasttable des parkingss
        //Parking.afficherLesParkings();
        
 /*       // DEBUT TEST ODX -> LES PORTES
            // Creation des Halls
            Hall h1 = new Hall ("Hall1","Zone 10");
            h1.afficher();
            
            Hall h4 = new Hall ("Hall4","Zone 40");
            h4.afficher();
            
            // Création des parkings
            ParkingHorsContact pa_hc1 = new ParkingHorsContact("M1", "Mike");
            pa_hc1.afficher();

            ParkingHorsContact pa_hc2 = new ParkingHorsContact("M2", "Mike");
            pa_hc2.afficher();

            ParkingContact pa_c1 = new ParkingContact("P1", "Papa");
            pa_c1.afficher();
       
            // Création des portes contact
            PorteContact po_c1 = new PorteContact("10A","10");
            po_c1.affecterHall(h1);
            //po_c1.affecterHall(null); // pour retirer un hall MAis ne marche pas
            po_c1.affecterParking(pa_c1);
            po_c1.afficher();
            
            // Création des portes hors contact
            System.out.println("Creation de portes hors contact");
            PorteHorsContact po_hc1 = new PorteHorsContact("41","40");
            po_hc1.affecterHall(h4);
            po_hc1.ajouterParking(pa_hc1);
            po_hc1.ajouterParking(pa_hc2);
            //po_hc1.retirerParking(pa_hc2); // test du remove dans arrayList
            po_hc1.afficher();

            // ------- Affectation d'une porte a un hall ----------
            System.out.println("Affectation d'une porte a un hall");
            h1.ajouterPorte(po_c1);
            h1.afficher();            
            
            // ------- Affectation d'une porte a un parking contact ----------
            System.out.println("Affectation d'une porte a un parking contact");
            pa_c1.affecterPorte(po_c1);
            pa_c1.afficher();
        
            // affichage de la Hasttable des portes
            Porte.afficherLesPortes();
            
            // test recup porte dans la hashtable
            System.out.println("Test recup objet porte dans Hashtable");
            try {
                Porte objet_porte = Porte.getPorte("41");
                objet_porte.afficher();
            } catch (PorteInvalide e){
		System.out.println(e.toString());
            }

            // test recup porte dans la hashtable
            System.out.println("Test recup objet hall dans Hashtable");
            try {
                Hall objet_hall = Hall.getHall("Hall1");
                objet_hall.afficher();
            } catch (HallInvalide e){
		System.out.println(e.toString());
            }
            
       // FIN TEST ODX
 */        
		
	try { //chargement des avions
	BufferedReader entree = new BufferedReader (new FileReader ("avionsFA-16-v1.txt"));
	String ligne = null;
	while((ligne= entree.readLine()) != null){
		// decouperla ligne de mots
		StringTokenizer st = new StringTokenizer (ligne); //separateur = espace
		String imatavion = st.nextToken();
		String modelavion = st.nextToken();
		Avion a = new Avion (imatavion, modelavion);
		// traiter mot
		
	}
	} catch (IOException e){
		System.out.println("fichier non trouvé");
		}
    Avion.afficherLesAvions();
    Vol.creerLesVols();
    Vol.afficherLesVols();
        /*
try { //CHARGEMENT HALLS
        BufferedReader halls = new BufferedReader (new FileReader ("halls.txt"));
	String ligne_halls = null;
        while((ligne_halls= halls.readLine()) != null){//WHILE LIGNE HALLS
            StringTokenizer tokenHall = new StringTokenizer (ligne_halls);
            String hall_num_hall = tokenHall.nextToken();
            String hall_zone = tokenHall.nextToken();
            Hall hall = new Hall (hall_num_hall, hall_zone);
            while (tokenHall.hasMoreTokens()){//WILE VOIR LES PORTES SUR LA LIGNE DU HALL
                String hall_porte = tokenHall.nextToken();
                
try { //chargement des PORTES
	BufferedReader portes = new BufferedReader (new FileReader ("portes.txt"));
	String ligne_porte = null;
        //System.out.println("test");
	while((ligne_porte= portes.readLine()) != null){//WHILE ligne PORTES
            StringTokenizer tokenPorte = new StringTokenizer (ligne_porte);
            String num_porte = tokenPorte.nextToken();
            String porte_num_parking = tokenPorte.nextToken();
            
    try { //chargement des PARKINGS
	BufferedReader parkings = new BufferedReader (new FileReader ("parkings.txt"));
	String ligne_parking = null;
	while((ligne_parking= parkings.readLine()) != null){
		// decouperla ligne de mots
		StringTokenizer tokenParking = new StringTokenizer (ligne_parking); //separateur = espace
                String num_parking = tokenParking.nextToken();
                String zone = tokenParking.nextToken();

                if (porte_num_parking.equals(num_parking) ){
                    //System.out.println("test : "+porte_num_parking);
                    //System.out.println("test : "+num_parking);
                    ParkingContact parking = new ParkingContact (num_parking, zone);
                    Porte porte = new Porte (num_porte, parking);
                    //porte.afficher();
                    if(num_porte.equals(hall_porte)){hall.AjouterPorte(porte);}
                    } 
		// traiter mot
	}//FIN TRY CHARGEMENT DES PARKING
        
	} catch (IOException e){// CATCH PARKINGS
		System.out.println("fichier non trouvé");
		}
        }// FIN WHILE LIGNE PORTE
}catch (IOException e){ // CATCH PORTES
		System.out.println("fichier non trouvé");
        }// FIN TRY CHARGEMENT PORTES
        }//FIN WILE VOIR LES PORTES SUR LA LIGNE DU HALL
            //hall.Afficher();
            bercy.ajouterHall(hall);
       }// FIN WHILE HALLS LIGNE
}catch (IOException e){ // CATCH PORTES
		System.out.println("fichier non trouvé");
}//FIN TRY CHARGEMENT HALLS
bercy.Afficher();
*/
    }
    
}
