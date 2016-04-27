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
import java.util.Hashtable;

public class Avion {

	private String immat;
	private String modele;
	
	
	public Avion (String i, String m){
		immat = i; modele = m;
	}
	
	public String getImmat(){
		return immat;
	}
	
	public String getModele(){
		return modele;
	}
	
	public String toString(){
		String info = "Immatriculation : "+immat+" | modèle : "+modele;
		
		return info;
	}
	
}
