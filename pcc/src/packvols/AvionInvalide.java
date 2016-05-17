
package packvols;

public class AvionInvalide extends Exception {
        private String num_avion;
        public AvionInvalide (String num_avion) {
            this.num_avion=num_avion;
        }
        public String toString(){
                return "Numéro d'avion: " + num_avion + " inexistant !!";
        }
}
