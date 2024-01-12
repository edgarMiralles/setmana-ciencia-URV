package aplicacionsTest.ig;

import java.time.LocalDate;
import dades.LlistaActivitats;
import dades.Tallers;
import dades.Visites;
import dades.Xerrades;
import interficie.*;

public class UsaIg {    
    public static void main(String[] args) {

        System.out.println("Validació Interficie Grafica ");
        
        LlistaActivitats llistaActivitats = new LlistaActivitats(11);
        Xerrades activitat1 = new Xerrades("Xerrada1", "Iulian1", 43860, LocalDate.of(2022,1, 1), "Illya1","Nawfall1");
        Xerrades activitat2 = new Xerrades("Xerrada2", "Iulian2", 43860, LocalDate.of(2022,1, 2), "Illya2","Nawfall2");
        Xerrades activitat3 = new Xerrades("Xerrada3", "Iulian3", 43860, LocalDate.of(2022,1, 2), "Illya3","Nawfall3");
        Xerrades activitat4 = new Xerrades("Xerrada4", "Iulian4", 43860, LocalDate.of(2022,1, 3), "Illya4","Nawfall4");
        Xerrades activitat5 = new Xerrades("Xerrada5", "Iulian5", 43860, LocalDate.of(2022,1, 5), "Illya5","Nawfall5");
        Tallers activitat6 = new Tallers("Tallers6", "Iulian6", 43860, LocalDate.of(2022,1, 5),"ISO", 3,30);
        Xerrades activitat7 = new Xerrades("Xerrada7", "Iulian7", 43860, LocalDate.of(2022,1, 6), "Illya7","Nawfall7");
        Xerrades activitat8 = new Xerrades("Xerrada8", "Iulian8", 43860, LocalDate.of(2022,1, 7), "Illya8","Nawfall8");
        Xerrades activitat9 = new Xerrades("Xerrada9", "Iulian9", 9, LocalDate.of(2022,1, 7), "Illy9a","Nawfall9");
        Visites activitat10 = new Visites("Visites10", "Iulian10", 10, LocalDate.of(2022,1, 9), "Illya10","Nawfall10","Fora",true);
        Xerrades activitat11 = new Xerrades("Xerrada11", "Iulian11", 11, LocalDate.of(2022,1, 10), "Illya11","Nawfall11");

        llistaActivitats.afegirActivitat(activitat1);
        llistaActivitats.afegirActivitat(activitat2);
        llistaActivitats.afegirActivitat(activitat3);
        llistaActivitats.afegirActivitat(activitat4);
        llistaActivitats.afegirActivitat(activitat5);
        llistaActivitats.afegirActivitat(activitat6);
        llistaActivitats.afegirActivitat(activitat7);
        llistaActivitats.afegirActivitat(activitat8);
        llistaActivitats.afegirActivitat(activitat9);
        llistaActivitats.afegirActivitat(activitat10);
        llistaActivitats.afegirActivitat(activitat11);

        new InterficieGrafica(llistaActivitats);
    }

}
