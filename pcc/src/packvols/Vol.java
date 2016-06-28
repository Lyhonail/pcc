package packvols;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import packaeroport.Porte;
import packhoraires.Horaire;
import  java.util.Collections;
import packaeroport.*;
import static packaeroport.Porte.toStringLesPortes;
import packaeroport.PorteInvalide;

public abstract class Vol implements Comparable<Vol>  {

    private String num_vol;
    private Horaire horaire;
    private Avion avion;
    private Sejour sejour;
    private static Hashtable <String, Vol> lesVols = new Hashtable<String, Vol>();

    public Vol(String num_vol, Horaire horaire, Avion avion) {
        this.num_vol = num_vol;
        this.horaire = horaire;
        this.avion = avion;
        lesVols.put(num_vol, this);
    }
    
    public void affecterSejour(Sejour s){
        sejour = s;
    }
    
    public int compareTo(Vol v) {
        return this.horaire.compareTo(v.horaire);
    }

    public String getNum_vol() {
        return num_vol;
    }
    
    public Horaire getHoraire(){
        return horaire;
    }
    
    public Avion getAvion(){
        return avion;
    }
    
    public Sejour getSejour(){
        return sejour;
    }
    
    public static Vol getVol(String v) throws VolInvalide{
        // récupération d'un vol de la HashTable des vols
        if (!lesVols.containsKey(v))
            throw new VolInvalide(v);
        else
            return (Vol)lesVols.get(v);
    }
    
    public static Hashtable <String, Vol> getLesVols(){
        return lesVols;
    }

    public String toString() {
        // ici on devrait appeler avion.toString() mais \n dans avion.toString
        String info = "\n Vol: " + num_vol +" à "+horaire.toString()+" Avion: "+ avion.getImmat()  ;
        return info;
    }

    public void afficher() {
        System.out.println(this.toString());
    }
    
    public static void creerLesVols(){
        String file = "ProgrammeVolsFA-16-v1.txt";
        Avion avion_find = null;
        try {
            // Lecture du fichier
            BufferedReader vol = new BufferedReader (new FileReader (file));
            String ligne = null;
            boolean arrivee=true;
            while((ligne= vol.readLine()) != null){           
                if(arrivee){
                    StringTokenizer tokenVol = new StringTokenizer (ligne);
                    String num_vol = tokenVol.nextToken();
                    String h_arivee = tokenVol.nextToken();
                    String m_arivee = tokenVol.nextToken();
                    String provenance = tokenVol.nextToken();
                    String immat = tokenVol.nextToken();

                    int hor_arrivee = Integer.parseInt(h_arivee);
                    int min_arrivee = Integer.parseInt(m_arivee);
                    Horaire h = new Horaire(hor_arrivee, min_arrivee);
                    try {
                        avion_find = Avion.getAvion(immat);
                        Vol v = new VolArrivee(num_vol, h, avion_find, provenance);
                        arrivee = false;
                        //System.out.println(v);
                    } catch (AvionInvalide e){ 
                        System.out.println(e.toString());
                    }               
                }
                else {
                    StringTokenizer tokenVol = new StringTokenizer (ligne);
                    String num_vol = tokenVol.nextToken();
                    String h_depart = tokenVol.nextToken();
                    String m_depart = tokenVol.nextToken();
                    String destination = tokenVol.nextToken();
                    String immat = tokenVol.nextToken();

                    int hor_depart = Integer.parseInt(h_depart);
                    int min_depart = Integer.parseInt(m_depart);
                    Horaire h = new Horaire(hor_depart, min_depart);
                    try {
                        avion_find = Avion.getAvion(immat);
                        Vol v = new VolDepart(num_vol, h, avion_find, destination);
                        arrivee = true;
                        //System.out.println(v);
                    } catch (AvionInvalide e){ 
                        System.out.println(e.toString());
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
  
    public static String toStringEcranLesVols(){
        // Affichage de la hastable lesVols
        String info = String.format("\n %-8s  %-8s %-15s %-25s %-10s %-10s",
            "Horaire","Vol","Arrivée/Départ","Destination/Provenance","Hall","Porte");
        ArrayList<Vol> vols = new ArrayList<Vol>(lesVols.values());
        Collections.sort(vols);
        Iterator<Vol> it = vols.iterator(); 
        while(it.hasNext()){
           String hall = null, porte = null;
           Vol v = it.next();
           info += String.format("\n%8s   %-14s ",v.getHoraire(),v.getNum_vol());
           if (v instanceof VolArrivee)
               info += String.format("%-9s %-25s ", "A",((VolArrivee) v).getProvenance());
           else
               info += String.format("%-9s %-25s ", "D",((VolDepart) v).getdestination());
               
           if (v.sejour.getParking() instanceof ParkingContact  ){
               ParkingContact p = (ParkingContact) v.sejour.getParking();
               PorteContact porteC = (PorteContact) p.getPorteC();
               hall = porteC.getHall().getNum_hall();
               porte = porteC.getNum_porte();
           }
           else {
               ParkingHorsContact p = (ParkingHorsContact) v.sejour.getParking();
               PorteHorsContact porteHC = (PorteHorsContact) p.getPorteHC();
               hall = porteHC.getHall().getNum_hall();
               porte = porteHC.getNum_porte();
           }
           info += String.format("%-10s %-10s", hall ,porte);
        }   
        return(info);
    }

    public static void afficherEcranLesVols(){
        System.out.println(toStringLesVols());
    }   
    
    public static String toStringLesVols(){
        // Affichage de la hastable lesVols
        String info = "Liste des vols (départ et arrivée)";
        ArrayList<Vol> vols = new ArrayList<Vol>(lesVols.values());
        Collections.sort(vols);
        Iterator<Vol> it = vols.iterator(); 
        while(it.hasNext()){
           Vol v = it.next();
           info +=v.toString();
        }
        return (info);
    }
        
    public static void afficherLesVols(){
        System.out.println(toStringLesVols());
    }       
}