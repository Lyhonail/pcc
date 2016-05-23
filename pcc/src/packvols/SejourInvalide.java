
package packvols;

public class SejourInvalide extends Exception {
        private String num_sejour;
        public SejourInvalide (String id_sejour) {
            this.num_sejour=id_sejour;
        }
        public String toString(){
                return "Séjour: " + num_sejour + " inexistant !!";
        }
}
