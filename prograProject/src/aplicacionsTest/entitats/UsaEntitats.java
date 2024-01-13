package aplicacionsTest.entitats;
import dades.*;
public class UsaEntitats {
    public static void main(String[] args) {
        Entitats ent1 = new Entitats("Illya", "123456789", "illya@urv.cat");
        System.out.println(ent1);

        System.out.println("Nom:" +ent1.getNom());
        System.out.println("Telèfon:" +ent1.getTelefon());
        System.out.println("Correu:" +ent1.getCorreu());

        ent1.setNom("Kunakh");
        ent1.setTelefon("987654321");
        ent1.setCorreu("Kunakh@gmail.com");
        
        Entitats ent2 = ent1.copia();
        System.out.println(ent2);

    }
    
}
