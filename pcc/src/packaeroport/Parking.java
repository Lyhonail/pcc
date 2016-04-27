package packaeroport;

public class Parking {

    private String code_park;
    private String zone;


public Parking(String p, String z){
    code_park = p; zone = z;
}

 public String getCode_park() {
     return code_park;
    }

    public String getZone() {
        return zone;
    }

    public String toString() {
        String info = "Parking : "+code_park+" Zone : "+zone;
        return info;
    }

    public void afficher() {
        System.out.println(this.toString());
    }

}