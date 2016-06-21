package packaeroport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import packvols.Sejour;

public class Hall {

    private String num_hall;
    private  ArrayList<Porte> lesPortes ;
    private String zone_enreg;
    private static Hashtable<String, Hall> lesHalls = new Hashtable<String, Hall>();

    public Hall(String n, String ze) {
        num_hall = n;
        zone_enreg = ze;
        lesPortes = new ArrayList<Porte>(); 
        lesHalls.put(n, this);
    }
    
    public static Hall getHall(String num_hall) throws HallInvalide {
        if (!lesHalls.containsKey(num_hall))
            throw new HallInvalide(num_hall);
        else
            return (Hall)lesHalls.get(num_hall);
    } 
    
    public String getNum_hall(){
       return num_hall;
    }
    
    public String getZone_enreg(){
       return zone_enreg;
    }
    
    public ArrayList<Porte> getLesPortes(){
        return lesPortes;
    }

    public void afficher(){
        System.out.println(this.toString());
    }
    
    public String toString(){
        String info = "\n Hall: "+num_hall+" Zone d'enregistrement: "+zone_enreg+
                "\n Les Portes associées: " ;
        // recuperation de l'arrayList des portes    
        Iterator it = lesPortes.iterator();
	while(it.hasNext()){
            info += it.next().toString();
	}
        return info;
    }
    
    public void ajouterPorte(Porte p){
        lesPortes.add(p);
    }
    
    public void retirerPorte(Porte p){
        lesPortes.remove(p);
    }
    
    public static void afficherLesHalls(){
        System.out.println(toStringLesHalls());
    }
    
    public static String toStringLesHalls(){
        // Affichage de la hastable lesHalls
        String info = "\n Liste des Halls: ";
        ArrayList<Hall> halls = new ArrayList<Hall>(lesHalls.values());
        Iterator<Hall> it = halls.iterator(); 
        while(it.hasNext()){
            info += it.next().toString();
        }
        return info;
    }
       
    public static void creerHalls(){
        String file = "03-zones-enreg-et-halls.txt";
        try {
            // Lecture du fichier
            BufferedReader halls = new BufferedReader (new FileReader (file));
            String ligne = null;
            while((ligne= halls.readLine()) != null){//liste des halls
                StringTokenizer tokenHall = new StringTokenizer (ligne);
                String num_hall = tokenHall.nextToken();
                String zone_enr = tokenHall.nextToken();
                Hall lesHalls = new Hall (num_hall, zone_enr);
            } 
	} catch (FileNotFoundException e){
            System.out.println("Fichier non trouvé: "+file+"\n");
        }
	catch (IOException e){
		System.out.println("Erreur de lecture fichier: "+file+"\n");
	}
    }

    public static String toStringEcranHall(String numHall){
        //String info = "Affichages des parkings : \n";
        String info = null;
        //Recuperation de la date/heure courante
        String format = "dd/MM/yy HH:mm:ss";
        java.text.SimpleDateFormat formater = new java.text.SimpleDateFormat( format );
        java.util.Date date = new java.util.Date();
        String dateCourante= formater.format( date ); 
        
        Parking p = null;
        //Affichage des Halls
        ArrayList<Hall> halls = new ArrayList<Hall>(lesHalls.values());
        Iterator<Hall> it = halls.iterator();
        while(it.hasNext()){
            Hall h = it.next();
            if (h.num_hall.equals(numHall)){
                info = "\nSéjours du Hall "+numHall+ "        "+ dateCourante;
                info += String.format("\n%-8s %-14s %-9s %-13s %-10s %-10s",
                    "Parking","Heure Arrivee","No Vol","Heure Départ","No Vol","No Avion");
                //Récupération des portes
                Iterator itPortes = h.getLesPortes().iterator();
                while(itPortes.hasNext()){
                    Porte porte = (Porte) itPortes.next();

                    //récupération du parking en fonction de la porte
                    if(porte instanceof PorteHorsContact){ 
                      p = ((PorteHorsContact) porte).getParkingHC();
                      //info += "HorsContact\n";
                    } 
                    if(porte instanceof PorteContact){
                      p = ((PorteContact) porte).getParkingC();
                      //info += "contact\n";
                    }

                    //à partir de la on a le Hall 'h', la porte 'porte' et la parking 'p'
                    //avec le parking 'p', il faut récupérer les séjours 's'
                    //Récupération des séjours
                    ArrayList<Sejour> lesSejours = new ArrayList<Sejour>(p.getLesSejours());
                    Iterator<Sejour> itSejour = lesSejours.iterator();

                    boolean parkAffiche = false;
                    while(itSejour.hasNext()){
                        // Affichage du parking une seule fois
                        if (parkAffiche == false){
                            info += String.format("\n%-8s",p.getCode_park());
                            parkAffiche = true;
                        }
                        Sejour s = itSejour.next();
                        s.getAvion().getImmat();
                        info += String.format("\n%-8s %-14s %-9s %-13s %-10s %-10s",
                                "        ",
                                s.getTrancheHoraire().getDebutTrancheHoraire(),
                                s.getNumVolArrivee(),
                                s.getTrancheHoraire().getFinTrancheHoraire(),
                                s.getNumVolDepart(),
                                s.getAvion().getImmat());
                    }
                }//fin while(itParking.hasNext())
            }//Fin du if
        } // Fin while(it.hasNext())
        
        return info;
    }

}
