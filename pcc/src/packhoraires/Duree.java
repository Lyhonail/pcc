package packhoraires;

public class Duree implements Comparable{
  private int heures, minutes;
  public Duree() {
    heures=0;minutes=0;
  }
  public Duree(int h, int m) {
      heures=h;minutes=m%60;
      heures+= (m/60);
    }
    public Duree(int m) {
      m=m%1440;
      heures=m/60;;minutes=m%60;
    }
    public int dureeEnMinutes(){
      return heures*60+minutes;
    }
    public Duree ajout(Duree d){
     return new Duree(dureeEnMinutes()+d.dureeEnMinutes());
    }
    public String toString(){
      String tHeures=(heures<2)?" heure ":" heures ";
      String tMinutes=(minutes<2)?" minute ":" minutes ";
      String info=heures+tHeures+minutes +tMinutes;
      return info;
    }
    public void afficher(){
      System.out.println(toString());
    }
    public int compareTo(Object o){
       Duree d=(Duree) o;
       return dureeEnMinutes()-d.dureeEnMinutes();
     }

}

