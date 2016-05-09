package packaeroport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;

public abstract class Porte {
    
    private String num_porte;
    private String zone_enreg;
    private Hall hall; //ajouté par prof
    
    private static Hashtable<String, Porte> lesPortes = new Hashtable<String, Porte>();
   
    public Porte(String p , String ze) {
        num_porte = p;
        zone_enreg = ze;
        // ajout dans la Hashtable
        lesPortes.put(p, this);
    }

    public String toString(){
        // affichage 
        //String info = "Numéro de porte: "+ num_porte + 
        //            "Zone d'enregistrement: "+zone_enreg + hall.toString();
        String info = "Numéro de porte: "+ num_porte + 
                    " Zone d'enregistrement: "+zone_enreg;
        if (hall != null)
            info += hall.toString();
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
    
    //public void ajouterHall(String noHall,String zoneEnreg){
    //    hall = new Hall(noHall,zoneEnreg);
    //}
    public void affecterHall(Hall h){
        // Affectation d'un Hall déjà existant
        hall = h;
    }
    
    // NE FAUT-IL PAS UNE METHODE RETIRERHALL() ????
    
    public static void afficherLesPortes(){
        // Affichage de la hastable lesPortes
        System.out.println("Affichage Hashtable lesPortes");
        ArrayList<Porte> portes = new ArrayList<Porte>(lesPortes.values());
        Iterator<Porte> it = portes.iterator(); 
        while(it.hasNext()){
            it.next().afficher();
        }
    }
    
    public static Porte getPorte(String num_porte) throws PorteInvalide {
        if (!lesPortes.containsKey(num_porte))
            throw new PorteInvalide(num_porte);
        else
            return (Porte)lesPortes.get(num_porte);
    }
    
    public static void creerPortes(){
        String File = "02-zones-enreg-et-portes.txt";
        try {
            // Lecture du fichier
            BufferedReader portes = new BufferedReader (new FileReader (File));
            String ligne = null;
            while((ligne= portes.readLine()) != null){//WHILE LIGNE des zones
                StringTokenizer tokenHall = new StringTokenizer (ligne);
                String zone_enr = tokenHall.nextToken();
                //System.out.println("\nZone enregistrement: "+zone_enr);
                while (tokenHall.hasMoreTokens()){//liste des portes sur la ligne des zones
                    String num_porte = tokenHall.nextToken();
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
            System.out.println("fichier non trouvé: "+File+"\n");
        }
	catch (IOException e){
		System.out.println("Erreur de lecture fichier: "+File+"\n");
	}
    }
}
