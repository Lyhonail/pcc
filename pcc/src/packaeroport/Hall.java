package packaeroport;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Hall {

    private String num_hall;
    private  ArrayList<Porte> lesPortes;
    private String zone_enreg;
    private static Hashtable<String, Hall> lesHalls = new Hashtable<String, Hall>();

    public Hall(String n, String ze) {
        num_hall = n;
        zone_enreg = ze;
        lesPortes = new ArrayList<Porte>(); 
        lesHalls.put(n, this);
    }

    public void afficher(){
        System.out.println(this.toString());
    }

    public void ajouterListePorte(ArrayList<Porte> p){
        lesPortes = p;
    }

    public void ajouterPorte(Porte p){
        lesPortes.add(p);
    }
    
    public void retirerPorte(Porte p){
        lesPortes.remove(p);
    }    

    public String toString(){
        String info = " Hall: "+num_hall+" Zone d'enregistrement: "+zone_enreg+
                " Les Portes associés: " ;
        // recuperation de l'arrayList des portes
/*        for(int i = 0; i < lesPortes.size(); i++)
        {   
            info += "\n" + lesPortes.get(i);
        }    
*/        
        Iterator it = lesPortes.iterator();
		while(it.hasNext()){
                    info += "\n  " + it.next().toString();
		}

return info;
    }
    
    public static void creerHalls(){
        String File = "03-zones-enreg-et-halls.txt";
        try {
            // Lecture du fichier
            BufferedReader halls = new BufferedReader (new FileReader (File));
            String ligne = null;
            while((ligne= halls.readLine()) != null){//liste des halls
                StringTokenizer tokenHall = new StringTokenizer (ligne);
                String num_hall = tokenHall.nextToken();
                String zone_enr = tokenHall.nextToken();
                Hall lesHalls = new Hall (num_hall, zone_enr);
            } 
	} catch (FileNotFoundException e){
            System.out.println("Fichier non trouvé: "+File+"\n");
        }
	catch (IOException e){
		System.out.println("Erreur de lecture fichier: "+File+"\n");
	}
    }
    
    public static void afficherLesHalls(){
        // Affichage de la hastable lesHalls
        System.out.println("Affichage Hashtable lesHalls");
        ArrayList<Hall> halls = new ArrayList<Hall>(lesHalls.values());
        Iterator<Hall> it = halls.iterator(); 
        while(it.hasNext()){
            it.next().afficher();
        }
    }
    
    public static Hall getHall(String num_hall) throws HallInvalide {
        if (!lesHalls.containsKey(num_hall))
            throw new HallInvalide(num_hall);
        else
            return (Hall)lesHalls.get(num_hall);
    }
}
