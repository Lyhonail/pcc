
package packvols;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import static packaeroport.Porte.toStringLesPortes;

public class Avion {
    private String immat;
    private String modele;
    private static Hashtable <String, Avion> lesAvions = new Hashtable<String, Avion>();
	
    public Avion (String i, String m){
	immat = i; 
        modele = m;
        lesAvions.put(immat, this);
    }
	
    public void afficher() {
        System.out.println(this.toString());
    }
            
    public String getImmat(){
            return immat;
    }
        
    public static Avion getAvion(String num_avion) throws AvionInvalide {
        // récupération d'un avion dans HashTable des avions
        if (!lesAvions.containsKey(num_avion))
            throw new AvionInvalide(num_avion);
        else
            return (Avion)lesAvions.get(num_avion);
    }         
	
    public String getModele(){
        return modele;
    }
	
    public String toString(){
        String info = "\n Immatriculation: "+immat+" Modèle: "+modele;
        return info;
    }
        
    public static void creerLesAvions(){
        String file = "avionsFA-16-v1.txt"; 
        try { //chargement des avions
            BufferedReader entree = new BufferedReader (new FileReader (file));
            String ligne = null;
            while((ligne= entree.readLine()) != null){
                // decouperla ligne de mots
                StringTokenizer st = new StringTokenizer (ligne); //separateur = espace
                String imatavion = st.nextToken();
                String modelavion = st.nextToken();
                Avion a = new Avion (imatavion, modelavion);		
            }
 	} catch (FileNotFoundException e){
            System.out.println("fichier non trouvé: "+file+"\n");
        }
	catch (IOException e){
		System.out.println("Erreur de lecture fichier: "+file+"\n");
	}           
    }
        
    public static String toStringLesAvions(){
        // Affichage de la hastable lesAvions
        // Affichage de la hastable lesPortes
        String info = "\n Liste des avions";
        ArrayList<Avion> avions = new ArrayList<Avion>(lesAvions.values());
        Iterator<Avion> it = avions.iterator(); 
        while(it.hasNext()){
            Avion a = it.next();
            info += a.toString();
        }
        return info;
    }
	
    public static void afficherLesAvions(){
        System.out.println(toStringLesAvions());
    }
}
