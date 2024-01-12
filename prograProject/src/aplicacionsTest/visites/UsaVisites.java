package aplicacionsTest.visites;

import java.time.LocalDate;

import dades.Visites;

public class UsaVisites {
    public static void main(String[] args) {
        Visites visites = new Visites("Antoni", "Reus", 43884, LocalDate.parse("2014-03-14"), "Entitat", "EdificiGran", "ServeiX", true);
        
        System.out.println("Test getTipusEdifici(): \n"+visites.getTipusEdifici());
        System.out.println("Test getServeis(): \n"+visites.getServeis());
        System.out.println("Test isAdaptatCegos(): \n"+visites.isAdaptatCegos());

        System.out.println("Visita abans de setTipusEdifici(): \n"+visites);
        visites.setTipusEdifici("EdificiPetit");
        System.out.println("Visita despres de setTipusEdifici(): \n"+visites);

        System.out.println("Visita abans de setServeis(): \n"+visites);
        visites.setServeis("ServeiY");
        System.out.println("Visita despres de setServeis(): \n"+visites);

        System.out.println("Visita abans de setAdaptatCegos(): \n"+visites);
        visites.setAdaptatCegos(false);
        System.out.println("Visita despres de setAdaptatCegos(): \n"+visites);
    }
}