package packvols;

import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import packhoraires.Horaire;

public class Vol {

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
    

    public void getNum_vol() {
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
}
