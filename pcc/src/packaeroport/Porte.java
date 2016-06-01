package packaeroport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import static packaeroport.Parking.toStringLesParkings;

public abstract class Porte {
    
    private String num_porte;
    private String zone_enreg;
    private Hall hall;
    
    private static Hashtable<String, Porte> lesPortes = new Hashtable<String, Porte>();
   
    public Porte(String p , String ze) {
        num_porte = p;
        zone_enreg = ze;
        // ajout dans la Hashtable
        lesPortes.put(p, this);
        Hall hall= null;
    }

    public String toString(){
        String info = "\n   Numéro de porte: "+ num_porte + 
                    " Zone d'enregistrement: "+zone_enreg;
        if (hall != null)
            info += " Hall: " +hall.getNum_hall();
        else  
            info += " Hall : N/A";
        
        return info;
    }
   
    public void afficher() {
        System.out.println(this.toString());
    }

    public String getNum_porte(){
        return num_porte;
    }
    
    public String getZone_enreg(){
        return zone_enreg;
    }
    
    public Hall getHall(){
        return hall;
    }
    
    public void affecterHall(Hall h){
        // Affectation d'un Hall déjà existant
        hall = h;
    }
    
    public void desaffecterHall(){
        // desaffecter le Hall à la porte
        hall = null;
    }
    
    public static void afficherLesPortes(){
        System.out.println(toStringLesPortes());
    }
    
    public static String toStringLesPortes(){ 
        // Affichage de la hastable lesPortes
        String info = "\n Liste des Portes:";
        ArrayList<Porte> portes = new ArrayList<Porte>(lesPortes.values());
        Iterator<Porte> it = portes.iterator(); 
        while(it.hasNext()){
           Porte p = it.next();
           info += p.toString();             
        }
        return(info);
    }
      
    public static Porte getPorte(String num_porte) throws PorteInvalide {
        // récupération d'une porte de la HashTable des portes
        if (!lesPortes.containsKey(num_porte))
            throw new PorteInvalide(num_porte);
        else
            return (Porte)lesPortes.get(num_porte);
    }
    
    public static void creerPortes(){
        String file = "02-zones-enreg-et-portes.txt";
        try {
            // Lecture du fichier
            BufferedReader portes = new BufferedReader (new FileReader (file));
            String ligne = null;
            while((ligne= portes.readLine()) != null){//WHILE LIGNE des zones
                StringTokenizer tokenPorte = new StringTokenizer (ligne);
                String zone_enr = tokenPorte.nextToken();
                //System.out.println("\nZone enregistrement: "+zone_enr);
                while (tokenPorte.hasMoreTokens()){//liste des portes sur la ligne des zones
                    String num_porte = tokenPorte.nextToken();
                    if (zone_enr.equals("40")){
                        //porte Hors contact
                        //System.out.println("\nPorte hors contact: "+num_porte);
                        PorteHorsContact unePorte = new PorteHorsContact (num_porte, zone_enr);
                    }
                    else{
                        //porte contact
                        //System.out.println("\nPorte contact: "+num_porte);
                        PorteContact unePorte = new PorteContact (num_porte, zone_enr);
                    }
                }
            }    
	} catch (FileNotFoundException e){
            System.out.println("fichier non trouvé: "+file+"\n");
        }
	catch (IOException e){
		System.out.println("Erreur de lecture fichier: "+file+"\n");
	}
    }
}
