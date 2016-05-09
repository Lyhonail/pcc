
package packaeroport;

public class ParkingInvalide extends Exception {
        private String num_park;
        public ParkingInvalide (String num_park) {
            this.num_park=num_park;
        }
        public String toString(){
                return "Numéro de parking: " + num_park + " inexistant!!";
        }
}
