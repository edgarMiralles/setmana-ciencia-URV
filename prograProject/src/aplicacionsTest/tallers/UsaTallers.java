package aplicacionsTest.tallers;
import dades.*;
import java.time.LocalDate;

public class UsaTallers{
    public static void main(String[] args){
    // Validació constructor
        System.out.println("Validació constructor");
        Tallers t1 = new Tallers("Taller1", "Tarragona", 43431, LocalDate.parse("2024-01-11"), "URV", 40, 100);
        System.out.println(t1);

        // Validació copia()
        System.out.println("\nValidació copia()");
        Tallers t2 = t1.copia();
        System.out.println(t2);

        //Validació getters
        System.out.println("\nValidació getters");
        System.out.println(t1.getCapacitat());
        System.out.println(t1.getCodi());
        System.out.println(t1.getCodiPostal());
        System.out.println(t1.getDurada());
        System.out.println(t1.getLloc());
        System.out.println(t1.getNom());
        System.out.println(t1.getNomEntitat());
        System.out.println(t1.getPlacesOcupades());
        System.out.println(t1.getPlaces_disponibles());
        System.out.println(t1.getPuntuacio());
        System.out.println(t1.getData());

        //Validacio setters
        System.out.println("\nValidació setters");
        t1.setCapacitat(25);
        t1.setDurada(10);
        System.out.println(t1);
    }
}
