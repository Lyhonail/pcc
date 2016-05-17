
package packvols;

public class VolInvalide extends Exception {
        private String num_vol;
        public VolInvalide (String num_vol) {
            this.num_vol=num_vol;
        }
        public String toString(){
                return "Numéro de vol: " + num_vol + " inexistant!!";
        }
}
