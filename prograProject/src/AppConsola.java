import java.util.Scanner;

public class UsaSetmana {
    public static void main(String[] args){ 
        //carregar fitxers i inicialitzar llistes

        Scanner teclat = new Scanner(System.in);
        int opcio;
        do {
            menuOpcions();
            opcio = teclat.nextInt();
            teclat.nextLine();

            switch (opcio) {
                case 1:
                    
                    break;
                case 2:

                    break;
                case 3:
                    
                    break;
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
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
                Date data = new Date((Integer.parseInt(dataInici[0])-1900),(Integer.parseInt(dataInici[1])-1),Integer.parseInt(dataInici[2]));
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
