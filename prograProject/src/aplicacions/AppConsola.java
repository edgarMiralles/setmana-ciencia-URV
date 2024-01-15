package aplicacions;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

import dades.*;

public class AppConsola {
    static Scanner teclat = new Scanner(System.in);
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

        LlistaActivitats Llistadiadeterminat=null;
        LlistaActivitats llistaTallers = llistaActivitats.llistaTallers();
        
        Usuaris UsuariMesTallers;
        Tallers TallerExit;
        int opcio;
        do {
            menuOpcions();
            opcio = teclat.nextInt();
            teclat.nextLine();

            switch (opcio) {
                case 1: //Mostrar les dades de qualsevol llista que tingueu definida
                    System.out.println("Introdueix la llista que vols consultar(Entitats/Usuaris/Activitats/Reserves):");
                    String llista = teclat.nextLine();
                    if(llista.equalsIgnoreCase("Entitats")){
                        System.out.println(llistaEntitats);
                    }else if(llista.equalsIgnoreCase("Usuaris")){
                        System.out.println(llistaUsuaris);
                    }else if(llista.equalsIgnoreCase("Activitats")){
                        System.out.println(llistaActivitats);
                    }else if(llista.equalsIgnoreCase("Reserves")){
                        System.out.println(llistaReserves);
                    }else{
                        System.out.println("S'ha introduit una paraula equivocada");
                    }
                    break;
                case 2: // Obtenir i mostrar la llista d’activitats que ofereix una entitat concreta
                    System.out.println("Introdueixi el nom de l'entitat de la que vol mostrar les activitats:");
                    String nomEntitat = teclat.nextLine();
                    LlistaActivitats llistaEntitat = new LlistaActivitats(10);
                    for(int i = 0; i < llistaActivitats.getNumActivitats(); i++){
                        if(llistaActivitats.getActivitat(i).getNomEntitat().equalsIgnoreCase(nomEntitat)){
                            System.out.println(llistaActivitats.getActivitat(i));
                            llistaEntitat.afegirActivitat(llistaActivitats.getActivitat(i));

                        }
                    }
                    System.out.println(llistaEntitat);
                    break;
                case 3: // Obtenir i mostrar la llista de les activitats que es duen a terme en un dia indicat per teclat.
                    System.out.println("Introdueixi el dia (AAAA-MM-DD) del que vol guardar la llista d'activitats:");
                    try{
                        Llistadiadeterminat = llistaActivitats.llistaDia(LocalDate.parse(teclat.next()));
                        System.out.println(Llistadiadeterminat);
                    }catch(DateTimeParseException e){
                        System.out.println("Format de data incorrecte. S'ha de fer servir el format (AAAA-MM-DD).");
                    }
                    break;
                case 4: // Obtenir i mostrar la llista dels tallers que tenen places disponibles.
                    LlistaActivitats llistaTallersDisponibles = llistaTallers.llistaTallersDisponibles(llistaReserves);
                    System.out.println(llistaTallersDisponibles);
                    break;
                case 5://Afegir una nova activitat a la LListaActivitats
                    afegirActivitat(llistaActivitats);
                    break;
                case 6: // Registrar la petició d’un usuari per reservar un taller
                    try {
                        String nomUsuari, codiTaller;
                        System.out.println("Introdueix el codi del taller al que es vol inscriure");
                        codiTaller = teclat.next();
                        System.out.println("Introdueixi l'alies de l'usuari que es vol inscriure");
                        nomUsuari = teclat.next();
                        menu6(nomUsuari, codiTaller, llistaTallers, llistaUsuaris);
                    } catch (InputMismatchException e) {
                        System.out.println("S'ha d'introduir cadenes de caracter per al codi i l'alies");
                    }
                    break;
                case 7: // Mostrar els usuaris que s’han apuntat a un tallers
                    System.out.println(llistaUsuaris.usuarisApuntatsTallers());
                    break;
                case 8: // Calcular l’usuari que s’ha apuntat a més tallers
                    try {
                        UsuariMesTallers = menu8(llistaUsuaris);
                        if (UsuariMesTallers != null) {
                            System.out.println("L'usuari inscrit a més tallers és el següent");
                            System.out.println(UsuariMesTallers);
                        }  
                    } catch (NullPointerException e) {
                        System.out.println("No hi ha cap usuari inscrit a cap taller o s'ha produït una excepció de punter nul.");
                    }
                    break;
                case 9:  // Registrar la nota que un usuari que s’ha apuntat a un taller li dona un cop s’ha fet
                    try {
                        String codiTaller;
                        int puntuacio;
                        System.out.println("Introdueixi el codi del taller al que es vol posar una puntuació");
                        codiTaller = teclat.next();
                        System.out.println("Introdueixi la puntuació que vol posar al taller");
                        puntuacio = teclat.nextInt();
                        System.out.println("Introdueixi el nom de l'usuari que ha fet la puntuació");
                        String nomUsuari = teclat.next();
                        /*if(llistaTallers.getUsuari(nomUsuari).equalsIgnoreCase(nomUsuari)){
                            llistaTallers.getTaller(codiTaller).setSatisfaccio(puntuacio);
                        }*/
                        llistaReserves.setSatisfaccio(nomUsuari, puntuacio, codiTaller);
                        System.out.println("S'ha actualitzat la puntuació del taller " + codiTaller + " amb la puntuació " + puntuacio);
                        //llistaTallers.getTaller(codiTaller).actualizarPuntuacion(puntuacio);
                    } catch (InputMismatchException e) {
                        System.out.println("S'ha d'introduir un enter per a la puntuació");
                    } catch (NullPointerException e) {
                        System.out.println("El taller amb aquest codi no es troba en la llista.");
                    }
                    break;
                case 10: // Calcular la nota mitja que ha rebut un taller
                try {
                        menu10(llistaTallers);   
                    } catch (NullPointerException e) {
                        System.out.println("El taller amb aquest codi no es troba en la llista.");
                    }
                    break;
                case 11: // Quin és el taller que ha tingut més èxit? Calcularem l’èxit segons el taller que ha tingut una ocupació més alta en proporció a les places que oferia
                    TallerExit = llistaTallers.getTallerExit();
                    if(TallerExit != null){
                        System.out.println("El taller amb mes exit d'ocupacio es el seguent:");
                        System.out.println(TallerExit);
                    }
                    break; 
                case 12: // Obtenir i mostrar les dades de la llista de visites ofertes per una entitat (per teclat s’indicarà si es vol audioguia o si cal que estigui adaptada per persones cegues).
                    System.out.println("Quina entitat hi vol ?");
                    String entitat = teclat.nextLine();
                    System.out.println("Autogia o Adaptat ? --> Autogia = false , Adaptat = true");
                    boolean adaptat = Boolean.parseBoolean(teclat.nextLine());
                    LlistaActivitats visitaEntitats = llistaActivitats.llistaVisitesEntitat(entitat,adaptat);
                    System.out.println(visitaEntitats);
                    break;
                case 13: // Mostrar les dades de les xerrades que farà una persona concreta
                    System.out.println("Quina persona hi vols que sigui la XERRADA ?");
                    String persona = teclat.nextLine();
                    System.out.println(llistaActivitats.llistaXerradesPersona(persona));
                    break;
                case 14:
                    menu14(llistaTallers);
                    break;
                case 15:
                    System.out.println("Has seleccionat sortir de la aplicació");
                    System.out.println("Vols guardar els canvis realitzats (Si escrius una cosa diferente a TRUE es igual que escriure FALSE ) ? Si --> True / No --> False");
                    boolean guardar = Boolean.parseBoolean(teclat.nextLine());
                    if(guardar){
                        System.out.println("S'han guardat els canvis realitzats");
                        ficarArxiuEntitats(entitatsFitxer,llistaEntitats);
                        ficarArxiuUsuaris(usuarisFitxer,llistaUsuaris);
                        ficarArxiuActivitats(activitatsFitxer,llistaActivitats);
                        reservesFitxer.EscriuArxiu(llistaReserves);
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta. Introdueix un número del 1 al 15.");
                    break;
            }

        } while (opcio != 15);
    }
    public static void menuOpcions(){
            System.out.println("Menu d'opcions:");
            System.out.println("[1] Mostrar les dades de les llistes definides.");
            System.out.println("[2] Obtenir i mostrar la llista de activitats que ofereix una entitat concreta.");
            System.out.println("[3] Obtenir i mostrar la llista de les activitats que es duen a terme en un dia.");
            System.out.println("[4] Obtenir i mostrar la llista dels tallers que tenen places disponibles.");
            System.out.println("[5] Afegir una nova activitat.");
            System.out.println("[6] Reservar un taller.");
            System.out.println("[7] Mostrar els usuaris que se han apuntat a un taller.");
            System.out.println("[8] Calcular el usuari que se ha apuntat a més tallers.");
            System.out.println("[9] Registrar la nota de un taller.");
            System.out.println("[10] Calcular la nota mitja que ha rebut un taller.");
            System.out.println("[11] Mostrar taller amb més éxit.");
            System.out.println("[12] Obtenir i mostrar les dades de la llista de visites ofertes per una entitat.");
            System.out.println("[13] Mostrar les dades de les xerrades que farà una persona.");
            System.out.println("[14] Donar de baixa un taller.");
            System.out.println("[15] Sortir de la aplicació.");
            System.out.println("Quina opció vol utilitzar?");
            
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
    private static void menu6(String nomUsuari, String codiTaller, LlistaActivitats llista, LlistaUsuaris llistaUsuaris) {
        try {
            Tallers taller = llista.getTaller(codiTaller);
            if (taller.getCapacitat() >= 1) {
                taller.afegirReserva(nomUsuari);    //Fem la reserva
                llistaUsuaris.afegirApuntat(nomUsuari); //Augmentem el numero de tallers als que s'apuntat l'usuari
            } else {
                System.out.println("El taller no te plaçes disponibles");
            }
        } catch (NullPointerException e) {
            System.out.println("El taller amb el codi " + codiTaller + " no es troba en la llista.");
        }
    }
    private static Usuaris menu8(LlistaUsuaris llistaUsuaris){
        int max = 0;
        Usuaris UsuariMesTallers=null;
        for (int i = 0; i < llistaUsuaris.getNumUsuaris(); i++) {
            if (llistaUsuaris.getNTallers(llistaUsuaris.getAliesLlista(i)) > max) {
                UsuariMesTallers = llistaUsuaris.getUsuari(llistaUsuaris.getAliesLlista(i));
                max = llistaUsuaris.getNTallers(llistaUsuaris.getAliesLlista(i));
            }
        }
        return UsuariMesTallers;

    }
    private static void menu10(LlistaActivitats llistaTallers){

        String coditaller;
        int MitjaTaller;
        int placesocupades;
        System.out.println("Introdueix el codi del taller per calcular la nota mitja. ");
        coditaller = teclat.next();
        MitjaTaller = llistaTallers.getTaller(coditaller).getPuntuacio();
        placesocupades = llistaTallers.getTaller(coditaller).getPlacesOcupades();
        if (placesocupades > 0) {
            System.out.println("La nota mitja del taller " + llistaTallers.getTaller(coditaller) + " es: " + MitjaTaller);
        } 
        else {
            System.out.println("No es possible calcular la nota mitja ja que no s'ha fet cap reserva.");
        }
    }
    private static void menu14(LlistaActivitats llistaTallers){
        Scanner teclat = new Scanner(System.in);
        try {
            String codiTaller;
            System.out.println("Introdueix el codi del taller que vols donar de baixa:");
            codiTaller = teclat.next();
            if (llistaTallers.getTaller(codiTaller).getPlacesOcupades() == 0){
                llistaTallers.eliminarActivitat(codiTaller);
                System.out.println("S'ha donat de baixa el taller amb codi " + codiTaller);
            }
            else{
                System.out.println("No es pot donar de baixa al taller. Hi ha usuaris apuntats,");
            }
        } catch (NullPointerException e) {
            System.out.println("El taller amb aquest codi no es troba en la llista.");
        } 
        teclat.close();
    }

    private static void afegirActivitat(LlistaActivitats llistaActivitats) {
        System.out.println("Introdueixi el nom de l'activitat:");
        String nom = teclat.nextLine();
        System.out.println("Introdueixi el lloc de l'activitat:");
        String lloc = teclat.nextLine();
        System.out.println("Introdueixi el codi postal de l'activitat:");
        int codiPostal = teclat.nextInt();
        teclat.nextLine();
        System.out.println("Introdueixi la data de l'activitat (AAAA-MM-DD):");
        LocalDate data = LocalDate.parse(teclat.nextLine());
        System.out.println("Introdueixi el nom de l'entitat que organitza l'activitat:");
        String nomEntitat2 = teclat.nextLine();
        System.out.println("Introdueixi el tipus d'activitat (Taller, Visita o Xerrada):");
        String tipus = teclat.nextLine();
        if(tipus.equalsIgnoreCase("Taller")){
            System.out.println("Introdueixi la durada del taller:");
            int durada = teclat.nextInt();
            teclat.nextLine();
            System.out.println("Introdueixi la capacitat del taller:");
            int capacitat = teclat.nextInt();
            teclat.nextLine();
            Tallers taller = new Tallers(nom,lloc,codiPostal,data,nomEntitat2,durada,capacitat);
            llistaActivitats.afegirActivitat(taller);
            System.out.println(taller);
        }else if(tipus.equalsIgnoreCase("Visita")){
            System.out.println("Introdueixi el lloc a visitar:");
            String llocVisita = teclat.nextLine();
            System.out.println("Introdueixi els serveis que s'ofereixen:");
            String serveis = teclat.nextLine();
            System.out.println("Introdueixi si està adaptat per a cegos (true o false):");
            boolean adaptatCegos = teclat.nextBoolean();
            Visites visita = new Visites(nom,lloc,codiPostal,data,nomEntitat2,llocVisita,serveis,adaptatCegos);
            llistaActivitats.afegirActivitat(visita);
            System.out.println(visita);
        }else if(tipus.equalsIgnoreCase("Xerrada")){
            System.out.println("Introdueixi el nom de la persona que farà la xerrada:");
            String nomPersona = teclat.nextLine();
            Xerrades xerrada = new Xerrades(nom,lloc,codiPostal,data,nomEntitat2,nomPersona);
            llistaActivitats.afegirActivitat(xerrada); 
            System.out.println(xerrada);
        }   
    }
    

    
}
