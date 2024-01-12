package aplicacionsTest.arxius;

import dades.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;

public class UsaArxiusNormals {
    public static void main(String[] args) {

        ArxiuNormal activitats = new ArxiuNormal("activitats.txt");
        ArxiuNormal entitats = new ArxiuNormal("entitats.txt");
        ArxiuNormal usuaris = new ArxiuNormal("usuaris.txt");

        LlistaActivitats llistaActivitats = new LlistaActivitats(100);
        LlistaEntitats llistaEntitats = new LlistaEntitats(100);
        LlistaUsuaris llistaUsuaris = new LlistaUsuaris(100);

        ficarLlistaActivitats(activitats,llistaActivitats);
        ficarLlistaEntitats(entitats,llistaEntitats);
        ficarLlistaUsuaris(usuaris,llistaUsuaris);

        System.out.println("Validacio lectura Activitats");
        System.out.println(llistaActivitats);
        System.out.println("Validacio lectura Entitats");
        System.out.println(llistaEntitats);
        System.out.println("Validacio lectura Usuaris");
        System.out.println(llistaUsuaris);

        Xerrades xerrada = new Xerrades("Iulian", "TGN", 43860, LocalDate.of(2022, 11, 24), "Lufthansa", "Kevin");
        Tallers talller = new Tallers("Taller1", "Tarragona", 43431, LocalDate.of(2024,01,11), "URV",3,300);
        Usuaris usuari1 = new Usuaris("Illya","Illya@gmail.com",55456);
        Usuaris usuari2 = new Usuaris("Illi","Mateu@gmail.com",3333);
        Entitats entitat1 = new Entitats("Nawfall", "642668905", "Nawfall@gmail.com");
        Entitats entitat2 = new Entitats("Nicolas", "642671632", "Nicolas@gmail.com");
        Visites visita = new Visites("Visita1", "Tarragona", 43431, LocalDate.of(2024,01,11), "URV", "Tarragona", "Serveis", true);
        
        LlistaActivitats llistaActivitats2 = new LlistaActivitats(100);
        LlistaEntitats llistaEntitats2 = new LlistaEntitats(100);   
        LlistaUsuaris llistaUsuaris2 = new LlistaUsuaris(100);

        llistaActivitats2.afegirActivitat(xerrada);
        llistaActivitats2.afegirActivitat(talller);
        llistaActivitats2.afegirActivitat(visita);
        llistaEntitats2.afegirEntitat(entitat1);
        llistaEntitats2.afegirEntitat(entitat2);
        llistaUsuaris2.afegirUsuari(usuari1);
        llistaUsuaris2.afegirUsuari(usuari2);
        
        System.out.println("Validacio escritura arxius");
        ficarArxiuEntitats(entitats, llistaEntitats2);
        ficarArxiuUsuaris(usuaris, llistaUsuaris2);
        ficarArxiuActivitats(activitats, llistaActivitats2);
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
    private static void ficarArxiuEntitats(ArxiuNormal alpha,LlistaEntitats LlistaEntitats){
        int nElem = LlistaEntitats.getNumEntitats();
        int numero = nElem * 4;
        String[] entitats = new String[numero]; 
        int j = 0;
        for (int i = 0; i < nElem; i++) {
            entitats[j] = LlistaEntitats.getNom(i);
            entitats[++j] = LlistaEntitats.getTelefon(i);
            entitats[++j] = LlistaEntitats.getCorreu(i);
            entitats[++j] = "//";
            j++;
        }
        try{
            alpha.EscriureArxiu(entitats);
        }catch(IOException e){
            System.out.println("Error al escriure");
        }
    }
    private static void ficarArxiuUsuaris(ArxiuNormal alpha,LlistaUsuaris LlistaUsuaris){
        int nElem = LlistaUsuaris.getNumUsuaris();
        int numero = nElem * 4;
        String[] usuaris = new String[numero]; 
        int j = 0;
        for (int i = 0; i < nElem; i++) {
            usuaris[j] = LlistaUsuaris.getAliesLlista(i);
            usuaris[++j] = LlistaUsuaris.getCorreuLlista(i);
            usuaris[++j] = String.valueOf(LlistaUsuaris.getCodiPostalLlista(i));
            usuaris[++j] = "//";
            j++;
        }
        try{
            alpha.EscriureArxiu(usuaris);
        }catch(IOException e){
            System.out.println("Error al escriure");
        }
    }
    private static void ficarArxiuActivitats(ArxiuNormal alpha,LlistaActivitats LlistaActivitats){
        int nElem = LlistaActivitats.getNumActivitats();
        int numero = nElem * 8;
        String[] activitats = new String[numero]; 
        int j = 0;
        for (int i = 0; i < nElem; i++) {
            if(LlistaActivitats.getActivitat(i) instanceof Xerrades){
                Xerrades xerrada = (Xerrades) LlistaActivitats.getActivitat(i);
                activitats[j] = xerrada.getNom();
                activitats[++j] = xerrada.getLloc();
                activitats[++j] = String.valueOf(xerrada.getCodiPostal());
                activitats[++j] = String.valueOf(xerrada.getData());
                activitats[++j] = String.valueOf(xerrada.getNomEntitat());
                activitats[++j] = xerrada.getNomPersona();
                activitats[++j] = "//";
            }else if(LlistaActivitats.getActivitat(i) instanceof Visites){
                Visites visita = (Visites) LlistaActivitats.getActivitat(i);
                activitats[j] = visita.getNom();
                activitats[++j] = visita.getLloc();
                activitats[++j] = String.valueOf(visita.getCodiPostal());
                activitats[++j] = String.valueOf(visita.getData());
                activitats[++j] = visita.getTipusEdifici();
                activitats[++j] = visita.getServeis();
                activitats[++j] = String.valueOf(visita.isAdaptatCegos());
                activitats[++j] = "//";
            }else if(LlistaActivitats.getActivitat(i) instanceof Tallers){
                Tallers taller = (Tallers) LlistaActivitats.getActivitat(i);
                activitats[j] = taller.getNom();
                activitats[++j] = taller.getLloc();
                activitats[++j] = String.valueOf(taller.getCodiPostal());
                activitats[++j] = String.valueOf(taller.getData());
                activitats[++j] = taller.getNomEntitat();
                activitats[++j] = String.valueOf(taller.getDurada());
                activitats[++j] = String.valueOf(taller.getCapacitat());
                activitats[++j] = "//";
            }
            j++;
        }
        try{
            alpha.EscriureArxiu(activitats);
        }catch(IOException e){
            System.out.println("Error al escriure");
        }
    }

}
