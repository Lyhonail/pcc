
package packaeroport;

public class PorteInvalide extends Exception {
        private String num_porte;
        public PorteInvalide (String num_porte) {
            this.num_porte=num_porte;
        }
        public String toString(){
                return "Numéro de porte: " + num_porte + " inexistante!!";
        }
}
