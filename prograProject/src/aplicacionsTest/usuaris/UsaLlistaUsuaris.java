//Autor : Iulian Sebastian Oprea --> iuliansebastian.oprea@urv.estudiants.cat

package aplicacionsTest.usuaris;

import dades.LlistaUsuaris;
import dades.Usuaris;

public class UsaLlistaUsuaris {
    
    public static void main(String[] args) {
        // Validació constructor
        LlistaUsuaris llistaUsuaris = new LlistaUsuaris(2);

        //Validació afegirUsuari
        System.out.println("\nValidació afegirUsuari Llista");
        Usuaris u1 = new Usuaris("Iulian","iuliansebastian.oprea@urv.cat",43201);
        Usuaris u2 = new Usuaris("Sebastian","sebas@gmai.com",43202);
        llistaUsuaris.afegirUsuari(u1);
        llistaUsuaris.afegirUsuari(u2);
        System.out.println(llistaUsuaris);
 
        // Validació copia()
        System.out.println("\nValidació copia() Llista");
        LlistaUsuaris segonaLlista = llistaUsuaris.copiaLlista();
        System.out.println("Com ha quedat la copia\n"+segonaLlista);
 
        //Validació getters
        System.out.println("\nValidació getters Llista");
        System.out.println(llistaUsuaris.getAliesLlista(1));
        System.out.println(llistaUsuaris.getCorreuLlista(1));
        System.out.println(llistaUsuaris.getCodiPostalLlista(1));
 
        //Validacio setters
        System.out.println("\nValidació setters Llista");
        System.out.println("Abans = " + llistaUsuaris.getUsuari(1));
        llistaUsuaris.setAliesLlista(1,"Iulian Sebastian");
        llistaUsuaris.setCorreuLlista(1,"sebastian@gmail.com");
        llistaUsuaris.setCodiPostalLlista(1,45555);
        System.out.println("Despres = "+llistaUsuaris.getUsuari(1));

        //Validació getUsuari(String nom Usuari) 
        System.out.println("\nValidació getUsuari(nom)");
        System.out.println(llistaUsuaris.getUsuari("Iulian Sebastian"));

        //Validació getUsuari(int posicio)
        System.out.println("\nValidació getUsuari(pos)");
        System.out.println(llistaUsuaris.getUsuari(0));
    }
}
