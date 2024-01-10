import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

public class AppConsola{
    public static void main(String[] args){ 
        //carregar fitxers i inicialitzar llistes
        int mida = 99;
        
        ArxiuNormal entitats = new ArxiuNormal("entitats.txt");
        ArxiuNormal usuarisFitxer = new ArxiuNormal("usuaris.txt");
        ArxiuNormal activitatsFitxer = new ArxiuNormal("activitats.txt");

        LlistaEntitats llistaEntitats = new LlistaEntitats(mida);
        LlistaUsuaris llistaUsuaris = new LlistaUsuaris(mida);
        LlistaActivitats llistaActivitats = new LlistaActivitats(mida);
        ArxiusSerialitzats reservesFitxer = new ArxiusSerialitzats("reserves.ser");
        
        ficarLlistaEntitats(entitats,llistaEntitats);
        ficarLlistaUsuaris(usuarisFitxer,llistaUsuaris);
        ficarLlistaActivitats(activitatsFitxer,llistaActivitats);
        reservesFitxer.LlegirArxiu(llistaReserves);
        
        LlistaActivitats Llistadiadeterminat=null;
        LlistaTallers llistaTallers= llistaActivitats.llistaTallers();
        LlistaReserves llistaReserves = null;
        Usuaris UsuariMesTallers;
        Tallers TallerExit;
        Scanner teclat = new Scanner(System.in);
        int opcio;
        do {
            menuOpcions();
            opcio = teclat.nextInt();
            teclat.nextLine();

            switch (opcio) {
                case 1: 
                    System.out.println("Introdueix la llista que vols consultar(Entitats/Usuaris/Activitats):");
                    String llista = teclat.nextLine();
                    if(llista.equalsIgnoreCase("Entitats")){
                        for(int i = 0; i < llistaEntitats.getNumEntitats(); i++){
                            System.out.println(llistaEntitats.getEntitat(i).toString());
                        }
                    }else if(llista.equalsIgnoreCase("Usuaris")){
                        for(int i = 0; i < llistaUsuaris.getNumUsuaris(); i++){
                            System.out.println(llistaUsuaris.getUsuari(i).toString());
                        }
                    }else if(llista.equalsIgnoreCase("Activitats")){
                        for(int i = 0; i < llistaActivitats.getNumActivitats(); i++){
                            System.out.println(llistaActivitats.getActivitat(i).toString());
                        }
                    break;
                case 2: 
                    System.out.println("Introdueixi el nom de l'entitat de la que vol mostrar les activitats:");
                    String nomEntitat = teclat.nextLine();
                    for(int i = 0; i < llistaActivitats.getNumActivitats(); i++){
                        if(llistaActivitats.getActivitat(i).getNomEntitat().equalsIgnoreCase(nomEntitat)){
                            System.out.println(llistaActivitats.getActivitat(i).toString());
                        }
                    }
                    

                    break;
                case 3:
                    System.out.println("Introdueixi el dia (AAAA-MM-DD) del que vol guardar la llista d'activitats:");
                    try{
                    Llistadiadeterminat = llistaDia(LocalDate.parse(teclat.next()), llistaActivitats);
                    }catch(DateTimeParseException e){
                        System.out.println("Format de data incorrecte. S'ha de fer servir el format (AAAA-MM-DD).");
                    }
                    break;
                case 4:
                    for ( int i = 0; i < llistatallers.getNumActivitats(); i++){
                        String codi = llistatallers.getActivitat(i).getCodi();
                        if (reserves.getPlacesOcupadesTaller(codi) < llistatallers.getCapacitatTaller(codi)) {
                            System.out.println(llistatallers.getActivitat(i));
                        }
                    }
                    break;
                case 5://Afegir una nova activitat a la LListaActivitats
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
                        System.out.println("Introdueixi la capacitat del taller:");
                        int capacitat = teclat.nextInt();
                        Tallers taller = new Tallers(nom,lloc,codiPostal,data,nomEntitat2,durada,capacitat);
                        llistaActivitats.afegirActivitat(taller);
                        llistaTallers.afegirActivitat(taller);
                    }else if(tipus.equalsIgnoreCase("Visita")){
                        System.out.println("Introdueixi el lloc a visitar:");
                        String llocVisita = teclat.nextLine();
                        System.out.println("Introdueixi els serveis que s'ofereixen:");
                        String serveis = teclat.nextLine();
                        System.out.println("Introdueixi si està adaptat per a cegos (true o false):");
                        boolean adaptatCegos = teclat.nextBoolean();
                        Visites visita = new Visites(nom,lloc,codiPostal,data,nomEntitat2,llocVisita,serveis,adaptatCegos);
                        llistaActivitats.afegirActivitat(visita);
                    }else if(tipus.equalsIgnoreCase("Xerrada")){
                        System.out.println("Introdueixi el nom de la persona que farà la xerrada:");
                        String nomPersona = teclat.nextLine();
                        Xerrades xerrada = new Xerrades(nom,lloc,codiPostal,data,nomEntitat2,nomPersona);
                        llistaActivitats.afegirActivitat(xerrada);}   
                    break;
                case 6:
                    break;
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
                case 7:
                    String[] noms = llistareserves.nomUsuariReserva();
                    for (int i = 0; i < noms.length; i++) {
                        System.out.println(llistaUsuaris.getUsuari(noms[i]));
                    }
                    break;
                case 8:
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
                case 9: 
                    try {
                        String codiTaller;
                        int puntuacio;
                        System.out.println("Introdueix el codi del taller al que es vol posar una puntuació");
                        codiTaller = teclat.next();
                        System.out.println("Introdueixi la puntuació que vol posar al taller");
                        puntuacio = teclat.nextInt();
                        llistaTallers.getTaller(codiTaller).actualizarPuntuacion(puntuacio);
                    } catch (InputMismatchException e) {
                        System.out.println("S'ha d'introduir un enter per a la puntuació");
                    } catch (NullPointerException e) {
                        System.out.println("El taller amb aquest codi no es troba en la llista.");
                    }
                    break;

                case 10:
                case 11:
                        TallerExit = menu11(llistaTallers);
                        if(TallerExit != null){
                            System.out.println("El taller amb mes exit d'ocupacio es el seguent:");
                            System.out.println(TallerExit);
                        } 
                case 12:
                    System.out.println("Quina entitat hi vol ?");
                    String entitat = teclat.nextLine();

                    System.out.println("Autogia o Adaptat ? --> Autogia = 0 , Adaptat = 1");
                    boolean adaptat = Boolean.parseBoolean(teclat.nextLine());
                    LlistaActivitats visitaentitats = llistavisites.llistaVisitesEntintat(entitat);
                    for (int i = 0; i < visitaentitats.getNumActivitats(); i++) {
                        Visites a = (Visites)visitaentitats.getActivitat(i);
                        if(a.isAdaptatCegos() == adaptat){
                            System.out.println(visitaentitats.getActivitat(i));
                        }
                    }
                    break;
                case 13:
                    System.out.println("Quina entitat hi vol ?");
                    String persona = teclat.nextLine();

                    LlistaActivitats llistaXerrades = llistaActivitats.llistaXerrades();

                    for (int i = 0; i < llistaXerrades.getNumActivitats(); i++) {
                        Xerrades b = (Xerrades) llistaXerrades.getActivitat(i);
                        if (b.getNomPersona().equalsIgnoreCase(persona)) {
                            System.out.println(b);
                        }
                    }
                case 14:
                case 15:
                    System.out.println("Has seleccionat sortir de la aplicació");
                    break;
                default:
                    System.out.println("Opción incorrecta. Introdueix un número del 1 al 15.");
                    break;
            }

        } while (opcio != 15);
        teclat.close();
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
                String[] dataInici = dadesFinals[3].split("/");
                LocalDate data = new LocalDate((Integer.parseInt(dataInici[0])-1900),(Integer.parseInt(dataInici[1])-1),Integer.parseInt(dataInici[2]));
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
    private static LlistaActivitats llistaDia(LocalDate dia, LlistaActivitats llista){
        LlistaActivitats aux = new LlistaActivitats(llista.getNumActivitats());
        for (int i = 0; i < llista.getNumActivitats(); i++) {
            if ((dia.compareTo(llista.getData(i))) == 0) {
                aux.afegirActivitat(llista.getActivitat(i));
            }
        }
        return aux;
    }    

    private static void menu6(String nomUsuari, String codiTaller, LlistaTallers llista, LlistaUsuaris llistaUsuaris) {
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
    private static Tallers menu11(LlistaTallers llistaTallers){
        Tallers tallerExit=null; //Taller amb més èxit d'ocupació
        Tallers aux;
        float max = 0; //Indica el percentatge d'ocupació en relació a la capacitat
        for (int i = 0; i < llistaTallers.getNumActivitats(); i++) {
            aux = llistaTallers.getPTallers(i);
            if ((aux.getCapacitat()/aux.getPlacesOcupades()) > max) {
                max = aux.getCapacitat()/aux.getPlacesOcupades();
                tallerExit = (Tallers)aux.copia();
            }
        }
        return tallerExit;
    }
    
}
