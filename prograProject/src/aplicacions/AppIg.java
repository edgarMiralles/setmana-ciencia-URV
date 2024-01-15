package aplicacions;

import java.io.*;
import java.time.LocalDate;
import dades.*;
import interficie.*;

public class AppIg {
    
    public static void main(String[] args){ 
        //carregar fitxers i inicialitzar llistes
        int mida = 99;
        
        ArxiuNormal entitatsFitxer = new ArxiuNormal("entitats.txt");
        ArxiuNormal usuarisFitxer = new ArxiuNormal("usuaris.txt");
        ArxiuNormal activitatsFitxer = new ArxiuNormal("activitats.txt");
        ArxiusSerialitzats reservesFitxer = new ArxiusSerialitzats("reserves.ser");
        
        LlistaEntitats llistaEntitats = new LlistaEntitats(mida);
        LlistaUsuaris llistaUsuaris = new LlistaUsuaris(mida);
        LlistaActivitats llistaActivitats = new LlistaActivitats(mida);
        LlistaReserves llistaReserves = new LlistaReserves(mida);
        
        ficarLlistaEntitats(entitatsFitxer,llistaEntitats);
        ficarLlistaUsuaris(usuarisFitxer,llistaUsuaris);
        ficarLlistaActivitats(activitatsFitxer,llistaActivitats);
        reservesFitxer.LlegirArxiu(llistaReserves);
        
        new InterficieGrafica(llistaActivitats);
    }
    private static void ficarLlistaEntitats(ArxiuNormal entitats,LlistaEntitats llistaEntitats){
        try{
            String[] dades = entitats.LlegirArxiu();
            int i = 0;
            while(dades[i] != null){
                String[] dadesFinals = dades[i].split(";");
                String nom = dadesFinals[0];
                String telefon = dadesFinals[1];
                String adreca = dadesFinals[2];
                Entitats entitat = new Entitats(nom,telefon,adreca);
                llistaEntitats.afegirEntitat(entitat);
                i++;
            }
    
        }catch(FileNotFoundException e){
            System.out.println("Fitxer (entitats.txt) no trobat");
        }catch(IOException e){
            System.out.println("Un altre error");
        }
    
    }
    private static void ficarLlistaUsuaris(ArxiuNormal usuariFitxer,LlistaUsuaris llistaUsuaris){
        try{
            String[] dades = usuariFitxer.LlegirArxiu();
            int i = 0;
            while(dades[i] != null){
                String[] dadesFinals = dades[i].split(";");
                String alies = dadesFinals[0];
                String correu = dadesFinals[1];
                int codiPostal = Integer.parseInt(dadesFinals[2]);
                Usuaris usuari = new Usuaris(alies,correu,codiPostal);
                llistaUsuaris.afegirUsuari(usuari);
                i++;
            }

        }catch(FileNotFoundException e){
            System.out.println("Fitxer (usuaris.txt) no trobat");
        }catch(IOException e){
            System.out.println("Un altre error");
        }

    }
    private static void ficarLlistaActivitats(ArxiuNormal activitatsFitxer,LlistaActivitats llistaActivitats){
        try{
            String[] dades = activitatsFitxer.LlegirArxiu();
            int i = 0;
            while(dades[i] != null){
                String[] dadesFinals = dades[i].split(";");
                String nom = dadesFinals[0];
                String lloc = dadesFinals[1];
                int codiPostal = Integer.parseInt(dadesFinals[2]);
                //String[] dataInici = dadesFinals[3].split("-");
                //LocalDate data = LocalDate.of(Integer.parseInt(dataInici[0]),Integer.parseInt(dataInici[1]),Integer.parseInt(dataInici[2]));
                LocalDate data = LocalDate.parse(dadesFinals[3]);
                String nomEntitat = dadesFinals[4];
                try{
                    int durada = Integer.parseInt(dadesFinals[5]);
                    int capacitat = Integer.parseInt(dadesFinals[6]);
                    Tallers talleria = new Tallers(nom,lloc,codiPostal,data,nomEntitat,durada,capacitat);
                    llistaActivitats.afegirActivitat(talleria);
                }catch(NumberFormatException e){
                    String dada = dadesFinals[5];
                    try{
                        String serveis = dadesFinals[6];
                        boolean adaptatCegos = Boolean.parseBoolean(dadesFinals[7]);
                        Visites visita = new Visites(nom,lloc,codiPostal,data,nomEntitat,dada,serveis,adaptatCegos);
                        llistaActivitats.afegirActivitat(visita);
                    }catch(ArrayIndexOutOfBoundsException e2){
                        Xerrades xerrada = new Xerrades(nom,lloc,codiPostal,data,nomEntitat,dada);
                        llistaActivitats.afegirActivitat(xerrada);
                    }
                }
                i++;
            }
        }catch(FileNotFoundException e){
            System.out.println("Fitxer (activitats.txt) no trobat");
        }catch(IOException e){
            System.out.println("Un altre error");
        }

    }
}
