package packaeroport;
//test
import packvols.Avion;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class Aeroport {
	
	private String nom;
	private Vector<Avion> lesAvions;
        private Vector<Hall> lesHalls;
	//private static Hashtable<String, Aeroport> LesAeroports = new Hashtable<String, Aeroport>();

	
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
	
	public void Afficher(){
		System.out.println(this.toString());
	}
	
	public String getNom(){
		return nom;
	}
}
