/*package aplicacionsTest.tallers;
import dades.*;
import java.time.*;

public class UsaLlistaTallers{
    public static void main(String[] args) {
        // Validació constructor
        LlistaTallers llistatTallers= new LlistaTallers(2);

        //Validació afegirUsuari
        System.out.println("\nValidació afegirReserva Llista");
        Tallers t1 = new Tallers("Taller1", "Tarragona", 43431, LocalDate.parse("2024-01-11"), "URV", 40, 100);
        Tallers t2 = new Tallers("Taller2", "Barcelona", 00000, LocalDate.parse("2024-01-11"), "UAB", 60, 500);  
        llistatTallers.afegirTaller(t1);
        llistatTallers.afegirTaller(t2);
        System.out.println(llistatTallers);
 
        // Validació copia()
        System.out.println("\nValidació copia() Llista");
        LlistaTallers segonaLlista = llistatTallers.copia();
        System.out.println("Com ha quedat la copia\n"+segonaLlista);
 
        //Validació getters
        System.out.println("\nValidació getters Llista");
        System.out.println(llistatTallers.getPTallers(0));
        System.out.println(llistatTallers.getData(0));
        System.out.println(llistatTallers.getPTallers(1));
        System.out.println(llistatTallers.getData(1));
        System.out.println(llistatTallers.getNumActivitats());
 
        //Validacio setters
        System.out.println("\nValidació setters Llista");
        System.out.println("Abans = " + llistatTallers);
        llistatTallers.modificarTaller(llistatTallers.getCodiT(0),t2);
        System.out.println("Despres = "+llistatTallers);
    }
}*/
