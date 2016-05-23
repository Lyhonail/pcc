package packaeroport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import packvols.Avion;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import packvols.Sejour;

public class Aeroport {
	
    private String nom;
    private Vector<Avion> lesAvions;
    private Vector<Hall> lesHalls;
	
    public Aeroport(String a){
        nom = a; 
        lesAvions = new Vector<Avion>(); 
        lesHalls = new Vector<Hall>();
    }

    public void ajouter(Avion a){
        lesAvions.add(a);//hghghg
    }

    public void ajouterHall(Hall h){
        lesHalls.add(h);
    }

    public String toString(){
        String info = "Aéroport : "+nom+"\n Liste des avions de cet aéroport : \n";

        Iterator ita = lesAvions.iterator();
        while(ita.hasNext()){
                Avion p = (Avion) ita.next();
                info += p.toString() +"\n";	
        }

        Iterator ith = lesHalls.iterator();
        while(ith.hasNext()){
                Hall h = (Hall) ith.next();
                info += h.toString() +"\n";	
        }
        return info;
    }

    public void afficher(){
        System.out.println(this.toString());
    }

    public String getNom(){
        return nom;
    }
    
    

    public static void associerHallslPortes(){
        String File = "04-assos-halls-et-portes.txt";
        Hall hall_find =null;
        Porte porte_find =null;
        try {
            // Lecture du fichier
            BufferedReader hall_portes = new BufferedReader (new FileReader (File));
            String ligne = null;
            while((ligne= hall_portes.readLine()) != null){//WHILE LIGNE du hall et des portes associés
                StringTokenizer tokenHall = new StringTokenizer (ligne);
                String num_hall = tokenHall.nextToken();
                // recup de l'objet hall correspondant
                try {
                    hall_find = Hall.getHall(num_hall);
                    ////System.out.println("\nHall: "+hall);
                    while (tokenHall.hasMoreTokens()){//liste des portes sur la ligne du hall
                        String num_porte = tokenHall.nextToken();
                        // recup de l'objet Porte correspondant
                        try {
                            porte_find = Porte.getPorte(num_porte);
                           // Ajouter la porte dans l'ArrayList des portes du hall
                            hall_find.ajouterPorte(porte_find);    
                            // affecter le hall à la porte
                            porte_find.affecterHall(hall_find);
                            //System.out.println(porte_find.getHall());
                        } catch (PorteInvalide e){ 
                            System.out.println(e.toString());
                        }       
                    }//liste des portes sur la ligne du hall
                } catch (HallInvalide e){ 
                    System.out.println(e.toString());
                }       
            }
        } catch (FileNotFoundException e){
            System.out.println("fichier non trouvé: "+File+"\n");
        }
	catch (IOException e){
            System.out.println("Erreur de lecture fichier: "+File+"\n");
        }
    }
    
    public static void associerPortesParkings(){
        String File = "05-assos-portes-et-parkings.txt";
        Porte porte_find =null;
        PorteContact porte_findC =null;
        PorteHorsContact porte_findHC =null;
        
        Parking parking_find =null;
        ParkingContact parking_findC =null;
        ParkingHorsContact parking_findHC =null;

        try {
            // Lecture du fichier
            BufferedReader porte_parks = new BufferedReader (new FileReader (File));
            String ligne = null;
            while((ligne= porte_parks.readLine()) != null){//WHILE LIGNE de la porte et des parkings associés
                StringTokenizer tokenHall = new StringTokenizer (ligne);
                String num_porte = tokenHall.nextToken();
                // recup de l'objet porte correspondant
                try {
                    porte_find = Porte.getPorte(num_porte);
                    //System.out.println("\nPorte: "+num_porte);
                    while (tokenHall.hasMoreTokens()){//liste des parkings sur la ligne de la porte
                        String num_park = tokenHall.nextToken();
                        // recup de l'objet Parking correspondant
                        try {
                            parking_find = Parking.getParking(num_park);                        
                            // test si le parking est contact 
                            if (parking_find instanceof ParkingContact){
                                // typage de la porte en PorteContact
                                porte_findC = (PorteContact)porte_find;                                                   
                                // affecter le parking à la porte ocntact
                                porte_findC.affecterParking((ParkingContact)parking_find);

                                // typage du parking en ParkingContact
                                parking_findC = (ParkingContact)parking_find;                                                        
                                // affecter la porte au parking
                                parking_findC.affecterPorte((PorteContact)porte_find);
                            }
                            else{
                                // typage de la porte en PorteHorsContact
                                porte_findHC = (PorteHorsContact)porte_find;
                                // Ajouter le parking dans l'ArrayList des parkings de la porte
                                porte_findHC.ajouterParking((ParkingHorsContact)parking_find); 

                                // typage du parking en ParkingHorsContact
                                parking_findHC = (ParkingHorsContact)parking_find;
                                // Ajouter la porte dans l'ArrayList des portes du parking
                                parking_findHC.ajouterPorte(porte_find); 
                            }                            
                        } catch (ParkingInvalide e){
                            System.out.println(e.toString());
                        }          
                    }  
                } catch (PorteInvalide e){
                    System.out.println(e.toString());
                }
            }    
	} catch (FileNotFoundException e){
            System.out.println("fichier non trouvé: "+File+"\n");
        }
	catch (IOException e){
		System.out.println("Erreur de lecture fichier: "+File+"\n");
	}
      }
    
     public static void affecterLesParkings(){
        
         String FileSejour = "ProgrammeVolsFA-16-v1.txt";
         
         try {
         BufferedReader parking_sejour = new BufferedReader (new FileReader (FileSejour));
            String ligne = null;
            Sejour sejourFind = null;
            while((ligne= parking_sejour.readLine()) != null){//on parcours le fichier
                
                //Récupération du n° de vol d'arrvié, qui est l'identifiant du séjour
                StringTokenizer tokenSejour = new StringTokenizer (ligne);
                String num_volArrivee = tokenSejour.nextToken();
                
                //lecture de la 2nde ligne qui récupère le N° de vol départ
                ligne=parking_sejour.readLine();
                StringTokenizer tokenVolDepart = new StringTokenizer (ligne);
                String num_volDepart = tokenVolDepart.nextToken();
                
                sejourFind = Sejour.getSejour(num_volArrivee);
                
                //On va récupérer les parking un par un, et remplir à chacun son planning de la journée
                Parking p = null;
                boolean disponible = false;
                Hashtable<String, Parking> lesParkings = Parking.getLesParkings();
                ArrayList<Parking> parkings = new ArrayList<Parking>(lesParkings.values());
                Iterator<Parking> it = parkings.iterator(); 
                
                while(it.hasNext() && p == null){//on parcours la liste des parkings, on sort de la boucle dès qu'un parking est affecté
                   Parking park = it.next();
                   Hashtable <String, Sejour> SejourParkingFind = Sejour.getLesSejours();
                   ArrayList<Sejour> sejours = new ArrayList<Sejour>(SejourParkingFind.values());
                   Iterator<Sejour> itSejour = sejours.iterator();
                   Sejour s = null;
                    while(it.hasNext()){//on parcours la liste des sejour pour voir leur parkings affectés
                        s = itSejour.next();
                        if(s.getCodeParking()==park.getCode_park() && num_volArrivee != s.getCodeSejour()){
                            //le parking est déjà utilisé, chercher selon l'horraire
                            disponible = false;
                        }// fin if s.getParking
                        else { //le parking n'est pas affecté à ce séjour, on continue a renvoyer true "disponible"
                            disponible = true;
                        }//fin else
                        
                    }//fin while it.hasNext()
                    if(disponible == true) { p = s.getParking();  }
                }//fin while it.hasNext() && p == null

                sejourFind.affecterParking(p);
                
                
            }
        
            } catch (IOException e){
		System.out.println("Erreur de lecture fichier: "+FileSejour+"\n");
	}
    }
    
}
