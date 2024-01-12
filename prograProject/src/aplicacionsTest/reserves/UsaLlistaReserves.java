package aplicacionsTest.reserves;
import dades.*;
import java.time.*;

public class UsaLlistaReserves {
    public static void main(String[] args) {
        // Validació constructor
        LlistaReserves llistaReserves= new LlistaReserves(2);

        //Validació afegirUsuari
        System.out.println("\nValidació afegirReserva Llista");
        Tallers t1 = new Tallers("Taller1", "Tarragona", 43431, LocalDate.parse("2024-01-11"), "URV", 40, 100);
        Reserves r1 = new Reserves("Kevin", t1);
        Reserves r2 = new Reserves("Pau", t1);
        llistaReserves.afegirReserva(r1);
        llistaReserves.afegirReserva(r2);
        System.out.println(llistaReserves);
 
        // Validació copia()
        System.out.println("\nValidació copia() Llista");
        LlistaReserves segonaLlista = llistaReserves.copiaLlista();
        System.out.println("Com ha quedat la copia\n"+segonaLlista);
 
        //Validació getters
        System.out.println("\nValidació getters Llista");
        System.out.println(llistaReserves.getUsuari(1));
        System.out.println(llistaReserves.getSatisfaccio(1));
        System.out.println(llistaReserves.getCodiTaller(1));
        System.out.println(llistaReserves.getCodiReserva(1));
        System.out.println(llistaReserves.getCodiReserva(0));
        System.out.println(llistaReserves.getPlacesOcupades());
 
        //Validacio setters
        System.out.println("\nValidació setters Llista");
        System.out.println("Abans = " + llistaReserves.getUsuari(1));
        llistaReserves.setUsuari(1,"Kevin Sanchez");
        llistaReserves.setSatisfaccio(1, 5);
        System.out.println("Despres = "+llistaReserves.getUsuari(1));
        System.out.println("Despres = "+llistaReserves.getSatisfaccio(1));

        //Validació getUsuari(int posicio)
        System.out.println("\nValidació getUsuari(pos)");
        System.out.println(llistaReserves.getUsuari(0));
    }
}
