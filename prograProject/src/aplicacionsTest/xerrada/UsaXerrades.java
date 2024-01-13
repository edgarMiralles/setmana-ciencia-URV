package aplicacionsTest.xerrada;

import java.time.LocalDate;

import dades.Xerrades;

public class UsaXerrades {
    public static void main(String[] args) {
        Xerrades xerrades = new Xerrades("Pablo", "Barcelona", 18174, LocalDate.parse("2011-04-13"), "EntitatXYZ", "PersonaZYX");
        
        System.out.println("Test getNomPersona: "+xerrades.getNomPersona());
        
        System.out.println("Xerrada abans de setNomPersona: "+xerrades);
        xerrades.setNomPersona("Arseni");
        System.out.println("Xerrada despres de setNomPersona: "+xerrades);
    }
}