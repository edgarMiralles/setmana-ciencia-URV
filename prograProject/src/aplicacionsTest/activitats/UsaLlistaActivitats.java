package aplicacionsTest.activitats;

import java.time.LocalDate;
import java.util.Scanner;

import dades.*;

public class UsaLlistaActivitats {
    public static void main(String[] args) {
        
        //Es crea una activitat i es msotra per pantalla
        LlistaActivitats llista = new LlistaActivitats(2);
        Activitats activitat = creaActivitats();
        for(int i= 0; i<llista.getNumActivitats(); i++){
            llista.afegirActivitat(creaActivitats());
        }
        
        System.out.println("Llista abans d'eliminar la primera activitat: \n"+llista);
        llista.eliminarActivitat("NOM100");
        System.out.println("Llista despres d'eliminar la primera activitat: \n"+llista);

        System.out.println("Nombre d'activitats a la llista: \n"+llista.getNumActivitats());

        System.out.println("Cercar activitat amb codi NOM101: \n"+llista.cercarActivitat("NOM101"));

        System.out.println("Llista abans de modificar l'activitat amb codi NOM102: \n"+llista);
        llista.modificarActivitat("NOM102", activitat);
        System.out.println("Llista despres de modificar l'activitat amb codi NOM102: \n"+llista);

        System.out.println("Test getData()"+llista.getData(1));
        System.out.println("Test getActivitat()"+llista.getActivitat(1));
    }

    private static Activitats creaActivitats() {
        Scanner input = new Scanner(System.in);
		String nom = "Nom";
        String lloc = "Tarragona";
        int codiPostal = 43777;
        input.nextLine();
        LocalDate data = LocalDate.parse("1991-12-26");
        String nomEntitat2 = "Entitat";
        System.out.println("Introdueixi el tipus d'activitat (Taller, Visita o Xerrada):");
        String tipus = input.nextLine();
        if(tipus.equalsIgnoreCase("Taller")){
            int durada = 10;
            int capacitat = 20;
            Tallers taller = new Tallers(nom,lloc,codiPostal,data,nomEntitat2,durada,capacitat);
            System.out.println(taller);
            input.close();
            return taller;
        }
        else if(tipus.equalsIgnoreCase("Visita")){
            String llocVisita = "Tarraco";
            String serveis = "Serveis";
            boolean adaptatCegos = true;
            Visites visita = new Visites(nom,lloc,codiPostal,data,nomEntitat2,llocVisita,serveis,adaptatCegos);
            System.out.println(visita);
            input.close();
            return visita;
        }
        else if(tipus.equalsIgnoreCase("Xerrada")){
            String nomPersona = "Paco";
            Xerrades xerrada = new Xerrades(nom,lloc,codiPostal,data,nomEntitat2,nomPersona);
            System.out.println(xerrada);
            input.close();
            return xerrada;
        }
        input.close();
        return null;
    }

    
}
