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
import packhorraires.*;
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
		
	try { //chargement des avions
	BufferedReader entree = new BufferedReader (new FileReader ("avionsFA-16-v1.txt"));
	String ligne = null;
	while((ligne= entree.readLine()) != null){
		// decouperla ligne de mots
		StringTokenizer st = new StringTokenizer (ligne); //separateur = espace
		String imatavion = st.nextToken();
		String modelavion = st.nextToken();
		Avion a = new Avion (imatavion, modelavion);
		bercy.ajouter(a);
		// traiter mot
		//System.out.println("immatriculation : "+imatavion+" Modèle : "+modelavion);
	}
	} catch (IOException e){
		System.out.println("fichier non trouvé");
		}
      pok^pok;  
try { //CHARGEMENT HALLS
        BufferedReader halls = new BufferedReader (new FileReader ("halls.txt"));
	String ligne_halls = null;
        while((ligne_halls= halls.readLine()) != null){//WHILE LIGNE HALLS
            StringTokenizer tokenHall = new StringTokenizer (ligne_halls);
            String hall_num_hall = tokenHall.nextToken();
            String hall_zone = tokenHall.nextToken();
            Hall hall = new Hall (hall_num_hall, hall_zone);
            while ((tokenHall.hasMoreTokens()){//WILE VOIR LES PORTES SUR LA LIGNE DU HALL
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
                    Parking parking = new Parking (num_parking, zone);
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
            hall.Afficher();
       }// FIN WHILE HALLS LIGNE
}catch (IOException e){ // CATCH PORTES
		System.out.println("fichier non trouvé");
}//FIN TRY CHARGEMENT HALLS
bercy.Afficher();
    }
    
}
