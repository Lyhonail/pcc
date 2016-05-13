package packvols;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.StringTokenizer;
import packaeroport.Porte;
import packhoraires.Horaire;

public abstract class Vol {

    private String num_vol;
    private Horaire horaire;
    private Avion avion;
    private static Hashtable <String, Vol> lesVols = new Hashtable<String, Vol>();

    public Vol(String num_vol, Horaire horaire, Avion avion) {
        this.num_vol = num_vol;
        this.horaire = horaire;
        this.avion = avion;
        lesVols.put(num_vol, this);
    }
    

    public String getNum_vol() {
        return num_vol;
    }


    public String toString() {
        String info = "Numero de vol : " + num_vol +"|avion :"+avion +" |horaire: " + horaire + "\n Liste  des vols du jour pour un avions  : \n";
        Iterator it = lesVols.values().iterator();
        while (it.hasNext()) {
            Vol v = (Vol) it.next();
            info += v.toString() + "\n";
        }
        return info;
    }

    public void afficher() {
        System.out.println(this.toString());
    }
    
    public static void creerLesVols(){
        String File = "ProgrammeVolsFA-16-v1.txt";
        Avion avion_find = null;
         try {
            // Lecture du fichier
            BufferedReader vol = new BufferedReader (new FileReader (File));
            String ligne = null;
            while((ligne= vol.readLine()) != null){
                 
                for(int i=0; i<2; i++){
                    if(i==0){
                        StringTokenizer tokenVol = new StringTokenizer (ligne);
                        String num_vol = tokenVol.nextToken();
                        String h_arivee = tokenVol.nextToken();
                        String m_arivee = tokenVol.nextToken();
                        String provenance = tokenVol.nextToken();
                        String immat = tokenVol.nextToken();
                        
                        int hor_arrivee = Integer.parseInt(h_arivee);
                        int min_arrivee = Integer.parseInt(m_arivee);
                        Horaire h = new Horaire(hor_arrivee, min_arrivee);
                        avion_find = Avion.getAvion(immat);
                        
                        VolArrivee v = new VolArrivee(num_vol, h, avion_find, provenance);
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
                        avion_find = Avion.getAvion(immat);
                        
                        VolDepart v = new VolDepart(num_vol, h, avion_find, destination);
                    }
                }
            }
         }
         
         catch (IOException e){
            System.out.println("fichier non trouvé: "+File+"\n");
            }
        
    }
    
    public static void afficherLesVols(){
        // Affichage de la hastable lesPortes
        String info = "Affichage Hashtable lesVols";
        ArrayList<Vol> vols = new ArrayList<Vol>(lesVols.values());
        Iterator<Vol> it = vols.iterator(); 
        while(it.hasNext()){
           Vol v = it.next();
           info += "\n Vol N° : "+v.getNum_vol();
           System.out.println(" test");
           
        }
        System.out.println(info);
    }
        
        
        
    }
    
    
    /*
    public class numvolInvalide extends Exception {

        private String numvol;

        public numvolInvalide(String numvol) {
            this.numvol = numvol;
        }

        public String toString() {
            return "numero de vol" + numvol + "  est inexistante !!";
        }

    }
*/

