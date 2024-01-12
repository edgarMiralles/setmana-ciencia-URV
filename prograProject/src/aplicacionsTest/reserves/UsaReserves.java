package aplicacionsTest.reserves;

import dades.*;
import java.time.LocalDate;

public class UsaReserves {
    public static void main(String[] args){
    // Validació constructor
        System.out.println("Validació constructor");
        Tallers t1 = new Tallers("Taller1", "Tarragona", 43431, LocalDate.parse("2024-01-11"), "URV", 40, 100);
        Reserves r1 = new Reserves("Kevin", t1);
        System.out.println(r1);

        // Validació copia()
        System.out.println("\nValidació copia()");
        Reserves r2 = r1.copia();
        System.out.println(r2);

        //Validació getters
        System.out.println("\nValidació getters");
        System.out.println(r1.getCodi_reserva());
        System.out.println(r1.getUsuari());
        System.out.println(r1.getCodi_taller());
        System.out.println(r1.getSatisfaccio());

        //Validacio setters
        System.out.println("\nValidació setters");
        r1.setUsuari("Kevin Sanchez");
        r1.setSatisfaccio(10);
        System.out.println(r1);
    }
}
