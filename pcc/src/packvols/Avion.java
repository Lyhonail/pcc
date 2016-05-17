/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packvols;

/**
 *
 * @author Lionel
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Avion {

    

	private String immat;
	private String modele;
        private static Hashtable <String, Avion> lesAvions = new Hashtable<String, Avion>();
	
	
	public Avion (String i, String m){
		immat = i; modele = m;
                lesAvions.put(immat, this);
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
		String info = "\n Immatriculation : "+immat+" | modèle : "+modele;
		
		return info;
	}
        
        public static void creerLesAvions(){
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
        }
        
        
        public static void afficherLesAvions(){
            // Affichage de la hastable lesAvions
        // Affichage de la hastable lesPortes
        String info = "Affichage Hashtable lesvions";
        ArrayList<Avion> portes = new ArrayList<Avion>(lesAvions.values());
        Iterator<Avion> it = portes.iterator(); 
        while(it.hasNext()){
            Avion a = it.next();
           info += a.toString();
        }
        System.out.println(info);
    }
	
}
