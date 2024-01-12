package aplicacionsTest.arxius;

import dades.*;
import java.time.LocalDate;

public class UsaArxiusSerialitzats {
    
    public static void main(String[] args) {
        
        ArxiusSerialitzats reserva = new ArxiusSerialitzats("reserves.ser");

        System.out.println("Validació EscriuArxiu");
        Tallers t1 = new Tallers("Taller1", "Tarragona", 43431, LocalDate.of(2023,01,11), "URV", 40, 100);
        Reserves alpha = new Reserves("Iulian",t1); 
        Reserves beta = new Reserves("Kevin", t1);
        LlistaReserves llistaReserves = new LlistaReserves(3);
        llistaReserves.afegirReserva(alpha);
        llistaReserves.afegirReserva(beta);        
        reserva.EscriuArxiu(llistaReserves);

        System.out.println("Validació LLegirArxiu");
        LlistaReserves llistaReserves2 = new LlistaReserves(3);
        reserva.LlegirArxiu(llistaReserves2);
        System.out.println(llistaReserves2);

    }

}
