package aplicacions.usuaris;

import dades.Usuaris;

public class UsaUsuaris {
        public static void main(String[] args){
        
        // Validació constructor
        System.out.println("Validació constructor");
        Usuaris u1 = new Usuaris("Iulian","iuliansebastian.oprea@urv.cat",43201);
        System.out.println(u1);

        // Validació copia()
        System.out.println("\nValidació copia()");
        Usuaris u2 = u1.copia();
        System.out.println(u2);

        //Validació getters
        System.out.println("\nValidació getters");
        System.out.println(u1.getAlies());
        System.out.println(u1.getCorreu());
        System.out.println(u1.getCodiPostal());

        //Validacio setters
        System.out.println("\nValidació setters");
        u1.setAlies("Iulian Sebastian");
        u1.setCorreu("sebastian@gmail.com");
        u1.setCodiPostal(45555);
        System.out.println(u1);

    }

}
