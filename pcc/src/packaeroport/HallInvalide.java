
package packaeroport;

public class HallInvalide extends Exception {
        private String num_hall;
        public HallInvalide (String num_hall) {
            this.num_hall=num_hall;
        }
        public String toString(){
                return "Numéro de hall: " + num_hall + " inexistant!!";
        }
}