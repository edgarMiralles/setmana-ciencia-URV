package aplicacionsTest.entitats;

import dades.Entitats;
import dades.LlistaEntitats;


public class UsaLlistaEntitats {
    public static void main(String[] args) {
        LlistaEntitats llistaent = new LlistaEntitats(2);

        Entitats e1 = new Entitats("Illya", "123456789", "illya@urv.cat");
        Entitats e2 = new Entitats("Nawfal", "987654321", "nawfal@urv.cat");
        llistaent.afegirEntitat(e1);
        llistaent.afegirEntitat(e2);
        System.out.println(llistaent);

        LlistaEntitats llistaentcopia = llistaent.llistaCopia();
        System.out.println("Copia: "+llistaentcopia);
        System.out.println(llistaent.getNom(1));
        System.out.println(llistaent.getTelefon(1));
        System.out.println(llistaent.getCorreu(1));

        System.out.println("Abans =" +llistaent);
        llistaent.setNom(1,"Illya Kunakh");
        llistaent.setCorreu(1,"illya.k@urv.cat");
        llistaent.setTelefon(1,"102030405");
        System.out.println("Despres =" + llistaent);

        System.out.println(llistaent.getNom(1));



        

        



    }
    
}
