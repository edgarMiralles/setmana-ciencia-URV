package aplicacionsTest.activitats;

import java.time.LocalDate;
import java.util.Scanner;

import dades.Activitats;
import dades.Tallers;
import dades.Visites;
import dades.Xerrades;

public class UsaActivitats {
    //Crea una aplicacion para probar la funcionalidad de la clase Activitats
    public static void main(String[] args) {
        
        //Es crea una activitat i es mostra per pantalla
        Activitats activitat = creaActivitats();


        System.out.println("Prova getCodi()\n"+activitat.getCodi());
        activitat.setCodi("AYE228");
        System.out.println("Prova setCodi()\n"+activitat.getCodi());
        System.out.println("Prova getNom()\n"+activitat.getNom());
        System.out.println("Prova getLloc()\n"+activitat.getLloc());
        System.out.println("Prova getCodiPostal()\n"+activitat.getCodiPostal());
        System.out.println("Prova getData()\n"+activitat.getData());
        System.out.println("Prova getNomEntitat()\n"+activitat.getNomEntitat());
    }

    private static Activitats creaActivitats() {
        Scanner input = new Scanner(System.in);
        System.out.println("Introdueixi el nom de l'activitat:");
		String nom = input.nextLine();
        System.out.println("Introdueixi el lloc de l'activitat:");
        String lloc = input.nextLine();
        System.out.println("Introdueixi el codi postal de l'activitat:");
        int codiPostal = input.nextInt();
        input.nextLine();
        System.out.println("Introdueixi la data de l'activitat (AAAA-MM-DD):");
        LocalDate data = LocalDate.parse(input.nextLine());
        System.out.println("Introdueixi el nom de l'entitat que organitza l'activitat:");
        String nomEntitat2 = input.nextLine();
        System.out.println("Introdueixi el tipus d'activitat (Taller, Visita o Xerrada):");
        String tipus = input.nextLine();
        if(tipus.equalsIgnoreCase("Taller")){
            System.out.println("Introdueixi la durada del taller:");
            int durada = input.nextInt();
            System.out.println("Introdueixi la capacitat del taller:");
            int capacitat = input.nextInt();
            Tallers taller = new Tallers(nom,lloc,codiPostal,data,nomEntitat2,durada,capacitat);
            System.out.println(taller);
            input.close();
            return taller;
        }
        else if(tipus.equalsIgnoreCase("Visita")){
            System.out.println("Introdueixi el lloc a visitar:");
            String llocVisita = input.nextLine();
            System.out.println("Introdueixi els serveis que s'ofereixen:");
            String serveis = input.nextLine();
            System.out.println("Introdueixi si està adaptat per a cegos (true o false):");
            boolean adaptatCegos = input.nextBoolean();
            Visites visita = new Visites(nom,lloc,codiPostal,data,nomEntitat2,llocVisita,serveis,adaptatCegos);
            System.out.println(visita);
            input.close();
            return visita;
        }
        else if(tipus.equalsIgnoreCase("Xerrada")){
            System.out.println("Introdueixi el nom de la persona que farà la xerrada:");
            String nomPersona = input.nextLine();
            Xerrades xerrada = new Xerrades(nom,lloc,codiPostal,data,nomEntitat2,nomPersona);
            System.out.println(xerrada);
            input.close();
            return xerrada;
        }
        input.close();
        return null;
    }


}
