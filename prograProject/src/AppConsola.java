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


    
}
